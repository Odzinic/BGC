package bgclib;

import classes.Control;
import classes.Epconst;
import classes.MetArr;
import classes.PhenArray;
import classes.Siteconst;
import classes.Constant;
import bgclib.Smooth;

import java.util.ArrayList;
import java.util.List;

public class Prephenology {
	
	int prephenology(final Control ctrl, final Epconst epc, 
			final Siteconst sitec, final MetArr metarr,
			PhenArray phen)
			{
				int ok=1;
				int model,woody,evergreen,south = 0;
				double t1;
				String round;
				int i,pday,ndays,py;
				int nyears,phenyears;
				int ngrowthdays,ntransferdays,nlitfalldays;
				int onday,offday;
				int counter;
                List<Integer> remdays_curgrowth = new ArrayList<>();
                List<Integer> remdays_transfer = new ArrayList<>();
                List<Integer> predays_transfer = new ArrayList<>();
                List<Integer> remdays_litfall = new ArrayList<>();
                List<Integer> predays_litfall = new ArrayList<>();
                /* phenology model variables */
                List<Integer> onday_arr = new ArrayList<>();
                List<Integer> offday_arr = new ArrayList<>();
                int fall_tavg_count;
				int onset_day, offset_day;
				double mean_tavg,fall_tavg;
				double phensoilt,phendayl;
				double onset_critsum, sum_soilt;
				double critdayl = 39300.0; /* seconds */
				/* grass model parameters */
				double ann_prcp;
				double sum_prcp, phenprcp;
				double grass_stsumcrit;
				double grass_prcpcrit;
				double grass_stsummax = 1380.0;
				double grass_stsummid = 900.0;
				double grass_stsummin = 418.0;
				double grass_a = 32.9;
				double grass_k = 0.15;
				double grass_tmid = 9.0;
                List<Double> grass_prcpyear = new ArrayList<>();
                double grass_prcpprevcrit = 1.14;
				double grass_prcpprev;
				double grass_prcpnextcrit = 0.97;
				double grass_prcpnext;
                List<Double> grass_tmaxyear = new ArrayList<>();
                List<Double> grass_tminyear = new ArrayList<>();
                List<Double> grass_3daytmin = new ArrayList<>();
                int psum_startday, psum_stopday;
				double tmax_ann, tmax, new_tmax;
				double tmin_annavg;

				Smooth smooth = new Smooth();
				
				String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

				/* allocate space for phenology arrays */
				nyears = ctrl.metyears;
				ndays = 365 * nyears;

				/* set some local flags to control the phenology model behavior */
				/* model=1 -. use phenology model   model=0 -. user specified phenology */
				/* woody=1 -. woody veg type        woody=0 -. non-woody veg type */
				/* evergreen=1 -. evergreen type    evergreen=0 -. deciduous type */
				/* south=1 -. southern hemisphere   south=0 -. northern hemisphere */
				model = epc.phenology_flag;
				woody = epc.woody;
				evergreen = epc.evergreen;

				
				if (sitec.lat < 0.0){
					south = 1;
				}
					
				/* for southern hemisphere sites, use an extra phenology year */
				if (south == 1) phenyears = nyears+1;
				else phenyears = nyears;
				
				/* define the phenology signals for cases in which the phenology signals
				are constant between years */
				if (evergreen == 1 || model == 0)
				{
					/* zero the 365-day phen arrays */
					for (pday=0 ; pday<365 ; pday++)
					{
                        remdays_curgrowth.add(pday, 0);
                        remdays_transfer.add(pday, 0);
                        predays_transfer.add(pday, 0);
                        remdays_litfall.add(pday, 0);
                        predays_litfall.add(pday, 0);
                    }



					/* user defined on and off days (base zero) */
					onday = epc.onday;
					offday = epc.offday;
					if (model == 0 && onday == -1 && offday == -1)
					{
						/* this is the special signal to repress all vegetation
						growth, for simulations of bare ground */
						for (pday=0 ; pday<365 ; pday++)
						{
                            remdays_curgrowth.set(pday, 0);
                            remdays_transfer.set(pday, 0);
                            predays_transfer.set(pday, 0);
                            remdays_litfall.set(pday, 0);
                            predays_litfall.set(pday, 0);
                        }
					} /* end if special no-growth signal */
					else
					{
						/* normal growth */

						if (model == 0 && evergreen == 0)
						{
							/* user-specified dates for onset and offset, but this
							gets overridden for evergreen types, so this case is only
							for USER-SPECIFIED DECIDUOUS (either woody or non-woody) */
							/* IMPORTANT NOTE:  the user specified yeardays for onset
							and offset are in relation to a phenological definition for
							a year, instead of the calendar year. In the Northern hemisphere,
							this is the same as the calendar year, but in the southern
							hemisphere, the phenological yeardays are defined to start on
							July 2 (N. Hem yearday 182, using base-zero).  This lets a
							user shift from N. Hem site to S. Hem site without having to
							change phenological yeardays in the ini file */
							/* force onset and offset to be at least one day apart */
							if (onday == offday)
							{
								if (onday > 0) onday--;
								else offday++;
							}
							ngrowthdays = offday - onday;
							/* define the length of the transfer and litfall periods */
							/* calculate number of transfer days and number of litfall days
							as proportions of number of growth days, as specified by user.
							Round and truncate to force these values between 1 and 
							ngrowthdays */
							t1 = epc.transfer_pdays * (double)ngrowthdays;
							round = String.format("%.0f",t1);
							ntransferdays = Integer.parseInt(round);
//							ntransferdays = atoi(round);
							if (ntransferdays < 1) ntransferdays = 1;
							if (ntransferdays > ngrowthdays) ntransferdays = ngrowthdays;
							t1 = epc.litfall_pdays * (double)ngrowthdays;
							round = String.format("%.0f",t1);
							nlitfalldays = Integer.parseInt(round);
//							nlitfalldays = atoi(round);
							if (nlitfalldays < 1) nlitfalldays = 1;
							if (nlitfalldays > ngrowthdays) nlitfalldays = ngrowthdays;
                            for (pday = 0; pday < onday; pday++) {
								remdays_curgrowth.set(pday, 0);
								remdays_transfer.set(pday, 0);
								predays_transfer.set(pday, 0);
								remdays_litfall.set(pday, 0);
								predays_litfall.set(pday, 0);
                            }
							counter = ngrowthdays;
							for (pday=onday ; pday<offday ; pday++)
							{
                                remdays_curgrowth.set(pday, counter);
                                counter--;
							}
							for (pday=offday ; pday<365 ; pday++)
							{
                                remdays_curgrowth.set(pday, 0);
                            }
							counter = ntransferdays;
							for (pday=onday ; pday<onday+ntransferdays ; pday++)
							{
                                remdays_transfer.set(pday, counter);
                                predays_transfer.set(pday, ntransferdays - counter);
                                counter--;
							}
							for (pday=onday+ntransferdays ; pday<=offday ; pday++)
							{
                                remdays_transfer.set(pday, 0);
                                predays_transfer.set(pday, ntransferdays);
                            }
							for (pday=offday+1 ; pday<365 ; pday++)
							{
                                remdays_transfer.set(pday, 0);
                                predays_transfer.set(pday, 0);
                            }
							for (pday=onday ; pday<offday-nlitfalldays+1 ; pday++)
							{
                                remdays_litfall.set(pday, 0);
                                predays_litfall.set(pday, 0);
                            }
							counter = nlitfalldays;
							for (pday=offday-nlitfalldays+1 ; pday<=offday ; pday++)
							{
                                remdays_litfall.set(pday, counter);
                                predays_litfall.set(pday, nlitfalldays - counter);
                                counter--;
							}
							for (pday=offday+1 ; pday<365 ; pday++)
							{
                                remdays_litfall.set(pday, 0);
                                predays_litfall.set(pday, 0);
                            }
						} /* end if user-specified and deciduous */

						if (evergreen == 1)
						{	
							/* specifying evergreen overrides any user input phenology data,
							and triggers a very simple treatment of the transfer, litterfall,
							and current growth signals.  Treatment is the same for woody and
							non-woody types, and the same for model or user-input phenology */
							/* fill the local phenyear control arrays */
							for (pday=0 ; pday<365 ; pday++)
							{
                                remdays_curgrowth.set(pday, 365 - pday);
                                remdays_transfer.set(pday, 365 - pday);
                                remdays_litfall.set(pday, 365 - pday);
                                predays_transfer.set(pday, pday);
                                predays_litfall.set(pday, pday);
                            }
						} /* end if evergreen */
					} /* end else normal growth */

					/* now copy this year multiple times to the permanent phenology struct
					arrays, with tests for southern hemisphere. */
					//TODO: Check if add works instead of set
					for (py=0 ; py<phenyears ; py++)
					{
						if (south == 1)
						{
							if (py==0)
							{
								/* only copy the second half of this phenological
								year to the permanent phenology array */
								for (pday=182 ; pday<365 ; pday++)
								{
									phen.remdays_curgrowth.add(pday - 182, remdays_curgrowth.get(pday));
									phen.remdays_transfer.add(pday - 182, remdays_transfer.get(pday));
									phen.remdays_litfall.add(pday - 182, remdays_litfall.get(pday));
									phen.predays_transfer.add(pday - 182, predays_transfer.get(pday));
									phen.predays_litfall.add(pday - 182, predays_litfall.get(pday));



								}

							}
							else if (py==phenyears-1)
							{
								/* only copy the first half of this phenological
								year to the permanent phenology array */
								for (pday=0 ; pday<182 ; pday++)
								{
									phen.remdays_curgrowth.add(py * 365 - 182 + pday, remdays_curgrowth.get(pday));
									phen.remdays_transfer.add(py * 365 - 182 + pday, remdays_transfer.get(pday));
									phen.remdays_litfall.add(py * 365 - 182 + pday, remdays_litfall.get(pday));
									phen.predays_transfer.add(py * 365 - 182 + pday, predays_transfer.get(pday));
									phen.predays_litfall.add(py * 365 - 182 + pday, predays_litfall.get(pday));
                                }
							}
							else
							{
								for (pday=0 ; pday<365 ; pday++)
								{
									phen.remdays_curgrowth.add(py * 365 - 182 + pday, remdays_curgrowth.get(pday));
									phen.remdays_transfer.add(py * 365 - 182 + pday, remdays_transfer.get(pday));
									phen.remdays_litfall.add(py * 365 - 182 + pday, remdays_litfall.get(pday));
									phen.predays_transfer.add(py * 365 - 182 + pday, predays_transfer.get(pday));
									phen.predays_litfall.add(py * 365 - 182 + pday, predays_litfall.get(pday));
                                }
							}
						} /* end if south */
						else
						{
							/* north */
							for (pday=0 ; pday<365 ; pday++)
							{
								phen.remdays_curgrowth.add(py * 365 + pday, remdays_curgrowth.get(pday));
								phen.remdays_transfer.add(py * 365 + pday, remdays_transfer.get(pday));
								phen.remdays_litfall.add(py * 365 + pday, remdays_litfall.get(pday));
								phen.predays_transfer.add(py * 365 + pday, predays_transfer.get(pday));
								phen.predays_litfall.add(py * 365 + pday, predays_litfall.get(pday));
                            }
						} /* end if north */
					} /* end py loop */
				} /* end if constant phenological signals */
				else
				{
					/* Cases that have variable phenological signals between years */
					/* Use the phenology model described in White et al., 1997 */
					/* the two cases that make it to this block are:
					model, deciduous, woody   and
					model, deciduous, non-woody (grass), which are the two cases
					handled by the White et al. paper */
					if (woody == 1)
					{
						/* use DECIDUOUS TREE PHENOLOGY MODEL */
						/* loop through the entire tavg timeseries to calculate long-term
						average tavg */
						mean_tavg = 0.0;
						for (i=0 ; i<ndays ; i++)
						{
                            mean_tavg += metarr.tavg.get(i);
                        }
						mean_tavg /= (double)ndays;
						/* tree onset equation from Mike White, Aug. 1997 */
						onset_critsum = Math.exp(4.795 + 0.129*mean_tavg);
						
						/* now go through the phenological years and generate expansion
						and litterfall arrays. Some complications for Southern
						hemisphere sites... */
						/* calculate fall_tavg, the mean tavg from phenyday 244-304 */
						fall_tavg = 0.0;
						fall_tavg_count = 0;
						for (py=0 ; py<phenyears ; py++)
						{
							for (pday=244 ; pday<305 ; pday++)
							{
								if (south == 1)
								{
									if (py==phenyears-1 && pday>181)
									{
										/* use the beginning of the last year to fill the
										end of the last phenological year */
                                        phensoilt = metarr.tavg_ra.get(ndays - 547 + pday);
                                    }
									else
									{
                                        phensoilt = metarr.tavg_ra.get(py * 365 - 182 + pday);
                                    }
								}
								else /* north */
								{
                                    phensoilt = metarr.tavg_ra.get(py * 365 + pday);
                                }
								
								fall_tavg += phensoilt;
								fall_tavg_count++;
								
							} /* end pday loop */
						} /* end py loop */
						fall_tavg /= (double)fall_tavg_count;
						
						/* loop through phenyears again, fill onset and offset arrays */
						for (py=0 ; py<phenyears ; py++)
						{
							sum_soilt = 0.0;
							onset_day = offset_day = -1;
							for (pday=0 ; pday<365 ; pday++)
							{
								if (south == 1)
								{
									if (py==0 && pday<182)
									{
										/* use the end of the first year to fill the 
										beginning of a southern hemisphere phenological
										year */
                                        phensoilt = metarr.tavg_ra.get(183 + pday);
                                        phendayl = metarr.dayl.get(183 + pday);
                                    }
									else if (py==phenyears-1 && pday>181)
									{
										/* use the beginning of the last year to fill the
										end of the last phenological year */
                                        phensoilt = metarr.tavg_ra.get(ndays - 547 + pday);
                                        phendayl = metarr.dayl.get(ndays - 547 + pday);
                                    }
									else
									{
                                        phensoilt = metarr.tavg_ra.get(py * 365 - 182 + pday);
                                        phendayl = metarr.dayl.get(py * 365 - 182 + pday);
                                    }
								}
								else /* north */
								{
                                    phensoilt = metarr.tavg_ra.get(py * 365 + pday);
                                    phendayl = metarr.dayl.get(py * 365 + pday);
                                }
								
								/* tree onset test */
								if (onset_day == -1)
								{
									if (phensoilt > 0.0) sum_soilt += phensoilt;
									if (sum_soilt >= onset_critsum) onset_day = pday;
								}
								
								/* tree offset test */
								if (onset_day != -1 && offset_day == -1)
								{
									if ((pday>182) && 
									(((phendayl<=critdayl) && (phensoilt<=fall_tavg)) ||
									(phensoilt<=2.0))) offset_day = pday;
								}
								
							} /* end pday loop */
							
							/* now do some exception handling for this year's phenology */
							if (onset_day != -1)
							{
								/* leaves are turned on sometime this year */
								/* subtract 15 days from onset day to approximate the
								start of the new growth period, instead of the middle of
								the new growth period, as is used in the White et al. ms. */
								if (onset_day >= 15)
								{
									onset_day -= 15;
								}
								else onset_day = 0;

								/* if leaves never got turned off, force off on last day */
								if (offset_day == -1) offset_day = 364;
								/* add 15 days to offset day to approximate the
								end of the litterfall period, instead of the middle
								as in the White et al. ms. */
								if (offset_day <= 349)
								{
									offset_day += 15;
								}
								else offset_day = 364;
								
								/* force onset and offset to be at least one day apart */
								if (onset_day == offset_day)
								{
									if (onset_day > 0) onset_day--;
									else offset_day++;
								}
							}
							else
							{
								/* leaves never got turned on, this is a non-growth
								year.  This probably indicates a problem with the
								phenology model */
								onset_day = -1;
								offset_day = -1;
							}

							/* save these onset and offset days and go to the next
							phenological year */
							onday_arr.add(py, onset_day);
							offday_arr.add(py, offset_day);

                        } /* end phenyears loop for filling onset and offset arrays */
					} /* end if woody (tree phenology model) */
					else
					{
						/* non-woody, use the GRASS PHENOLOGY MODEL to calculate the
						array of onset and offset days */
						/* loop through the entire tavg timeseries to calculate long-term
						average tavg and long-term average annual total precip */
						mean_tavg = 0.0;
						ann_prcp = 0.0;
						for (i=0 ; i<ndays ; i++)
						{
                            mean_tavg += metarr.tavg.get(i);
                            ann_prcp += metarr.prcp.get(i);
                        }
						mean_tavg /= (double)ndays;
						ann_prcp /= (double)ndays / 365.0;
						
						/* grass onset equation from White et al., 1997, with parameter
						values specified by Mike White, Aug. 1997 */
						t1 = Math.exp(grass_a * (mean_tavg - grass_tmid));
						grass_stsumcrit = ((grass_stsummax - grass_stsummin)* 0.5 *
							((t1-1)/(t1+1))) + grass_stsummid;
						grass_prcpcrit = ann_prcp * grass_k;
						
						/* now go through the phenological years and generate onset
						and offset days */
						
						/* calculate the long-term average annual high temperature
						for use in grass offset prediction */
						tmax_ann = 0.0;
						tmin_annavg = 0.0;
						for (py=0 ; py<phenyears ; py++)
						{
							new_tmax = -1000.0;
							for (pday=0 ; pday<365 ; pday++)
							{
								if (south == 1)
								{
									if (py==0 && pday<182)
									{
										/* use the end of the first year to fill the 
										beginning of a southern hemisphere phenological
										year */
                                        tmax = metarr.tmax.get(183 + pday);
                                        tmin_annavg += metarr.tmin.get(183 + pday);
                                    }
									else if (py==phenyears-1 && pday>181)
									{
										/* use the beginning of the last year to fill the
										end of the last phenological year */
                                        tmax = metarr.tmax.get(ndays - 547 + pday);
                                        tmin_annavg += metarr.tmin.get(ndays - 547 + pday);
                                    }
									else
									{
                                        tmax = metarr.tmax.get(py * 365 - 182 + pday);
                                        tmin_annavg += metarr.tmin.get(py * 365 - 182 + pday);
                                    }
								}
								else /* north */
								{
                                    tmax = metarr.tmax.get(py * 365 + pday);
                                    tmin_annavg += metarr.tmin.get(py * 365 + pday);
                                }
								
								if (tmax > new_tmax) new_tmax = tmax;
								
							} /* end pday loop */
							
							tmax_ann += new_tmax;
						} /* end py loop */
						tmax_ann /= (double) phenyears;
						/* 92% of tmax_ann is the threshold used in grass offset below */
						tmax_ann *= 0.92;
						tmin_annavg /= (double) phenyears * 365.0;
						
						/* loop through phenyears again, fill onset and offset arrays */
						for (py=0 ; py<phenyears ; py++)
						{
							sum_soilt = 0.0;
							sum_prcp = 0.0;
							onset_day = offset_day = -1;
							for (pday=0 ; pday<365 ; pday++)
							{
								if (south == 1)
								{
									if (py==0 && pday<182)
									{
										/* use the end of the first year to fill the 
										beginning of a southern hemisphere phenological
										year */
                                        phensoilt = metarr.tavg_ra.get(183 + pday);
                                        phenprcp = metarr.prcp.get(183 + pday);
										grass_prcpyear.add(pday, phenprcp);
										grass_tminyear.add(pday, metarr.tmin.get(183 + pday));
										grass_tmaxyear.add(pday, metarr.tmax.get(183 + pday));
                                    }
									else if (py==phenyears-1 && pday>181)
									{
										/* use the beginning of the last year to fill the
										end of the last phenological year */
                                        phensoilt = metarr.tavg_ra.get(ndays - 547 + pday);
                                        phenprcp = metarr.prcp.get(ndays - 547 + pday);
										grass_prcpyear.add(pday, phenprcp);
										grass_tminyear.add(pday, metarr.tmin.get(ndays - 547 + pday));
										grass_tmaxyear.add(pday, metarr.tmax.get(ndays - 547 + pday));
                                    }
									else
									{
                                        phensoilt = metarr.tavg_ra.get(py * 365 - 182 + pday);
                                        phenprcp = metarr.prcp.get(py * 365 - 182 + pday);
										grass_prcpyear.add(pday, phenprcp);
										grass_tminyear.add(pday, metarr.tmin.get(py * 365 - 182 + pday));
										grass_tmaxyear.add(pday, metarr.tmax.get(py * 365 - 182 + pday));
                                    }
								}
								else /* north */
								{
                                    phensoilt = metarr.tavg_ra.get(py * 365 + pday);
                                    phenprcp = metarr.prcp.get(py * 365 + pday);
									grass_prcpyear.add(pday, phenprcp);
									grass_tminyear.add(pday, metarr.tmin.get(py * 365 + pday));
									grass_tmaxyear.add(pday, metarr.tmax.get(py * 365 + pday));
                                }
								
								/* grass onset test */
								if (onset_day == -1)
								{
									if (phensoilt > 0.0) sum_soilt += phensoilt;
									sum_prcp += phenprcp;
									if (sum_soilt >= grass_stsumcrit &&
										sum_prcp >= grass_prcpcrit) onset_day = pday;
								}
								
							} /* end pday loop */
							
							/* do averaging operations on grass_prcpyear and grass_tminyear,
							and do tests for offset day. Offset due to hot & dry can't
							happen within one month after the onset day, and offset due
							to cold can't happen before midyear (yearday 182) */
							if (onset_day != -1)
							{
								/* calculate three-day boxcar average of tmin */
								if (smooth.boxcar_smooth(grass_tminyear, grass_3daytmin, 365,3,0) == 1)
								{
									System.out.printf(BV_ERROR, "Error in prephenology() call to boxcar()\n");
									ok=0;
								}
								
								for (pday=onset_day+30 ; pday<365 ; pday++)
								{
									/* calculate the previous 31-day prcp total */
									psum_startday = pday - 30;
									grass_prcpprev = 0.0;
									for (i=psum_startday ; i<=pday ; i++)
									{
                                        grass_prcpprev += grass_prcpyear.get(i);
                                    }

									/* calculate the next 7-day prcp total */
									if (pday > 358) psum_stopday = 364;
									else psum_stopday = pday + 6;
									grass_prcpnext = 0.0;
									for (i=pday ; i<=psum_stopday ; i++)
									{
                                        grass_prcpnext += grass_prcpyear.get(i);
                                    }
									
									/* test for hot and dry conditions */
									if (offset_day == -1)
									{
										if (grass_prcpprev < grass_prcpprevcrit && 
											grass_prcpnext < grass_prcpnextcrit &&
                                                grass_tmaxyear.get(pday) > tmax_ann)
                                            offset_day = pday;
									}
									
									/* test for cold offset condition */
									if (offset_day == -1)
									{
										if (pday > 182 &&
                                                grass_3daytmin.get(pday) <= tmin_annavg)
                                            offset_day = pday;
									}
									
								} /* end of pdays loop for grass offset testing */
							} /* end of if onset_day != -1 block */
								
							/* now do some exception handling for this year's phenology */
							if (onset_day != -1)
							{
								/* leaves are turned on sometime this year */
								/* subtract 15 days from onset day to approximate the
								start of the new growth period, instead of the middle of
								the new growth period, as is used in the White et al. ms. */
								if (onset_day >= 15)
								{
									onset_day -= 15;
								}
								else onset_day = 0;

								/* if leaves never got turned off, force off on last day */
								if (offset_day == -1) offset_day = 364;

								/* force onset and offset to be at least one day apart */
								if (onset_day == offset_day)
								{
									if (onset_day > 0) onset_day--;
									else offset_day++;
								}
							}
							else
							{
								/* leaves never got turned on, this is a non-growth
								year.  This probably indicates a problem with the
								phenology model */
								onset_day = -1;
								offset_day = -1;
							}
							
							/* save these onset and offset days and go to the next
							phenological year */
							onday_arr.add(py, onset_day);
							offday_arr.add(py, offset_day);

                        } /* end phenyears loop for filling onset and offset arrays */
					} /* end else !woody (grass phenology model) */
					
					/* now the onset and offset days are established for each phenyear,
					either by the deciduous tree or the grass model.  Next loop through
					phenyears filling the phenology signal arrays and copying them to 
					the permanent phen struct arrays */
					for (py=0 ; py<phenyears ; py++)
					{
						/* zero the 365-day phen arrays */
						for (pday=0 ; pday<365 ; pday++)
						{
							remdays_curgrowth.add(pday, 0);
							remdays_transfer.add(pday, 0);
							predays_transfer.add(pday, 0);
							remdays_litfall.add(pday, 0);
							predays_litfall.add(pday, 0);
                        }

                        onday = onday_arr.get(py);
                        offday = offday_arr.get(py);

                        if (onday == -1 && offday == -1)
						{
							/* this is the special signal to repress all vegetation
							growth */
							for (pday=0 ; pday<365 ; pday++)
							{
								remdays_curgrowth.add(pday, 0);
								remdays_transfer.add(pday, 0);
								predays_transfer.add(pday, 0);
								remdays_litfall.add(pday, 0);
								predays_litfall.add(pday, 0);
                            }
						} /* end if special no-growth signal */
						else
						{
							/* normal growth year */
							ngrowthdays = offday - onday;
							if (ngrowthdays < 1)
							{
								System.out.printf(BV_ERROR, "FATAL ERROR: ngrowthdays < 1\n");
								System.out.printf(BV_ERROR, "ngrowthdays = %d\n",ngrowthdays);
								System.out.printf(BV_ERROR, "onday = %d\toffday = %d\tphenyear = %d\n",
								onday,offday,py);
								ok=0;
							}
							/* define the length of the transfer and litfall periods */
							/* calculate number of transfer days and number of litfall days
							as proportions of number of growth days, as specified by user.
							Round and truncate to force these values between 1 and 
							ngrowthdays */
							t1 = epc.transfer_pdays * (double)ngrowthdays;
							round = String.format("%.0f",t1);
							ntransferdays = Integer.parseInt(round);
//							sprintf(round,"%.0f",t1);
//							ntransferdays = atoi(round);
							if (ntransferdays < 1) ntransferdays = 1;
							if (ntransferdays > ngrowthdays) ntransferdays = ngrowthdays;
							t1 = epc.litfall_pdays * (double)ngrowthdays;
							round = String.format("%.0f",t1);
							nlitfalldays = Integer.parseInt(round);
//							sprintf(round,"%.0f",t1);
//							nlitfalldays = atoi(round);
							if (nlitfalldays < 1) nlitfalldays = 1;
							if (nlitfalldays > ngrowthdays) nlitfalldays = ngrowthdays;
							
							for (pday=0 ; pday<onday ; pday++)
							{
								remdays_curgrowth.add(pday, 0);
								remdays_transfer.add(pday, 0);
								predays_transfer.add(pday, 0);
								remdays_litfall.add(pday, 0);
								predays_litfall.add(pday, 0);
                            }
							counter = ngrowthdays;
							for (pday=onday ; pday<offday ; pday++)
							{
								remdays_curgrowth.add(pday, counter);
                                counter--;
							}
							for (pday=offday ; pday<365 ; pday++)
							{
								remdays_curgrowth.add(pday, 0);
                            }
							counter = ntransferdays;
							for (pday=onday ; pday<onday+ntransferdays ; pday++)
							{
								remdays_transfer.add(pday, counter);
								predays_transfer.add(pday, ntransferdays - counter);
                                counter--;
							}
							for (pday=onday+ntransferdays ; pday<=offday ; pday++)
							{
								remdays_transfer.add(pday, 0);
								predays_transfer.add(pday, ntransferdays);
                            }
							for (pday=offday+1 ; pday<365 ; pday++)
							{
								remdays_transfer.add(pday, 0);
								predays_transfer.add(pday, 0);
                            }
							for (pday=onday ; pday<offday-nlitfalldays+1 ; pday++)
							{
								remdays_litfall.add(pday, 0);
								predays_litfall.add(pday, 0);
                            }
							counter = nlitfalldays;
							for (pday=offday-nlitfalldays+1 ; pday<=offday ; pday++)
							{
								remdays_litfall.add(pday, counter);
								predays_litfall.add(pday, nlitfalldays - counter);
                                counter--;
							}
							for (pday=offday+1 ; pday<365 ; pday++)
							{
								remdays_litfall.add(pday, 0);
								predays_litfall.add(pday, 0);
                            }
						} /* end else normal growth year */
						
						/* now put the signals for this phenological year into the
						right place in the permanent phen struct arrays */ 
						if (south == 1)
						{
							if (py==0)
							{
								/* only copy the second half of this phenological
								year to the permanent phenology array */
								for (pday=182 ; pday<365 ; pday++)
								{
									phen.remdays_curgrowth.add(pday - 182, remdays_curgrowth.get(pday));
									phen.remdays_transfer.add(pday - 182, remdays_transfer.get(pday));
									phen.remdays_litfall.add(pday - 182, remdays_litfall.get(pday));
									phen.predays_transfer.add(pday - 182, predays_transfer.get(pday));
									phen.predays_litfall.add(pday - 182, predays_litfall.get(pday));
                                }
							}
							else if (py==phenyears-1)
							{
								/* only copy the first half of this phenological
								year to the permanent phenology array */
								for (pday=0 ; pday<182 ; pday++)
								{
									phen.remdays_curgrowth.add(py * 365 - 182 + pday, remdays_curgrowth.get(pday));
									phen.remdays_transfer.add(py * 365 - 182 + pday, remdays_transfer.get(pday));
									phen.remdays_litfall.add(py * 365 - 182 + pday, remdays_litfall.get(pday));
									phen.predays_transfer.add(py * 365 - 182 + pday, predays_transfer.get(pday));
									phen.predays_litfall.add(py * 365 - 182 + pday, predays_litfall.get(pday));
                                }
							}
							else
							{
								for (pday=0 ; pday<365 ; pday++)
								{
									phen.remdays_curgrowth.add(py * 365 - 182 + pday, remdays_curgrowth.get(pday));
									phen.remdays_transfer.add(py * 365 - 182 + pday, remdays_transfer.get(pday));
									phen.remdays_litfall.add(py * 365 - 182 + pday, remdays_litfall.get(pday));
									phen.predays_transfer.add(py * 365 - 182 + pday, predays_transfer.get(pday));
									phen.predays_litfall.add(py * 365 - 182 + pday, predays_litfall.get(pday));
                                }
							}
						} /* end if south */
						else
						{
							/* north */
							for (pday=0 ; pday<365 ; pday++)
							{
								phen.remdays_curgrowth.add(py * 365 + pday, remdays_curgrowth.get(pday));
								phen.remdays_transfer.add(py * 365 + pday, remdays_transfer.get(pday));
								phen.remdays_litfall.add(py * 365 + pday, remdays_litfall.get(pday));
								phen.predays_transfer.add(py * 365 + pday, predays_transfer.get(pday));
								phen.predays_litfall.add(py * 365 + pday, predays_litfall.get(pday));
                            }
						} /* end if north */
					} /* end phenyears loop for filling permanent arrays */
				} /* end else phenology model block */
							
				/* free the local array memory */
				return 0;
			}

}
