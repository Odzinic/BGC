package bgclib;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import classes.BGCIn;
import classes.BGCOut;
import classes.CFlux;
import classes.Sub_CFlux;
import classes.CInit;
import classes.CO2Control;
import classes.CState;
import classes.Constant;
import classes.Control;
import classes.Epconst;
import classes.Epvar;
import classes.MetArr;
import classes.MetVar;
import classes.NFlux;
import classes.NState;
import classes.NTemp;
import classes.PSn;
import classes.PhenArray;
import classes.Phenology;
import classes.Ramp_Ndep;
import classes.Siteconst;
import classes.Summary;
import classes.WFlux;
import classes.WState;

public class BGC {

    /*
     * These DEBUG defines are now depricated. Please use
     * System.out.printf(BV_DIAG,...) instead. The only place where a DEBUG
     * define is still used is inside System.out.printf().
     */

    /* #define DEBUG */
    /* #define DEBUG_SPINUP set this to see the spinup details on-screen */

    /*
     * SANE = Do 'Pan-Arctic' style summary. INSANE is traditional style
     * summary. See the '-p' cli flag in USAGE.TXT
     */

    public boolean bgc(BGCIn bgcin, BGCOut bgcout, int mode) {

//        PrintStream originalStream = System.out;
//        PrintStream dummyStream = new PrintStream(new OutputStream(){
//            public void write(int b) {
//                // NO-OP
//            }
//        });

//        System.setOut(dummyStream);

        //TODO: Remove dummy output streams

        String summary_sanity = "INSANE";
        /* variable declarations */

        /* iofiles and program control variables */
        Control ctrl;

        /* meteorological variables */
        MetArr metarr;
        MetVar metv = new MetVar(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        CO2Control co2;
        Ramp_Ndep ramp_ndep;

        /* state and flux variables for water, carbon, and nitrogen */
        //TODO: See if metv, wf, cf, ns, nf, epv, psn_sun, psn_shade and summary are properly initialized
        WState ws;
        WFlux wf = new WFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        WFlux zero_wf = new WFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        CInit cinit;
        CState cs;
        Sub_CFlux subCFlux = new Sub_CFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        CFlux cf = new CFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, subCFlux);
        CFlux zero_cf;
        NState ns;
        NFlux nf = new NFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        NFlux zero_nf = new NFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

        /* primary ecophysiological variables */
        Epvar epv = new Epvar(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

        /* site physical constants */
        Siteconst sitec;

        /* phenological data */
        PhenArray phenarr;
        Phenology phen = new Phenology(0.0, 0.0, 0.0, 0.0, 0.0);

        /* ecophysiological constants */
        Epconst epc;

        /* photosynthesis constructs */
        PSn psn_sun = new PSn(0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        PSn psn_shade = new PSn(0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        ;

        /* temporary nitrogen variables for decomposition and allocation */
        NTemp nt;

        /* summary variable structure */
        Summary summary = new Summary(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

        Annual_Rates annrate = new Annual_Rates();
        Atm_Pres atmpres = new Atm_Pres();
        Baresoil_Evap barevap = new Baresoil_Evap();
        Canopy_Et canet = new Canopy_Et();
        Check_Balance checbal = new Check_Balance();
        Make_Zero_Flux_Struct mzf = new Make_Zero_Flux_Struct();
        Restart_IO restio = new Restart_IO();
        FirstDay firday = new FirstDay();
        Zero_Srcsnk zersrc = new Zero_Srcsnk();
        Get_NDep getndep = new Get_NDep();
        Get_CO2 getco2 = new Get_CO2();
        Precision_Control prectrl = new Precision_Control();
        Photosynthesis photsynth = new Photosynthesis();
        DayMet dmet = new DayMet();
        DayPhen dphen = new DayPhen();
        Radtrans ratran = new Radtrans();
        Prcp_Route prcout = new Prcp_Route();
        Snowmelt snmelt = new Snowmelt();
        Soilpsi sopsi = new Soilpsi();
        Maint_Resp maresp = new Maint_Resp();
        Outflow oflow = new Outflow();
        Decomp dcomp = new Decomp();
        Daily_Allocation dalloc = new Daily_Allocation();
        Growth_Resp groresp = new Growth_Resp();
        State_Update statup = new State_Update();
        NLeaching nleach = new NLeaching();
        Mortality mort = new Mortality();
        Check_Balance checkbal = new Check_Balance();
        Summary_Fun sumfun = new Summary_Fun();
        Phenology_Fun phenfun = new Phenology_Fun();
        Output_Map_Init outmapin = new Output_Map_Init();
        Output_ASCII outasc = new Output_ASCII();
        Prephenology prephen = new Prephenology();

        /* Initialize "Zero" objects */
        zero_cf = new CFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, subCFlux);
        zero_nf = new NFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        zero_wf = new WFlux(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        nt = new NTemp(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        phenarr = new PhenArray(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        String SANE = String.valueOf(Constant.SANE.getValue());
        double SPINUP_TOLERANCE = Constant.SPINUP_TOLERANCE.getValue();

        PrintWriter writer = null;


        /* output mapping (array of pointers to double) */
        List<Double> output_map = new ArrayList<>();

        /* local storage for daily and annual output variables */
        List<Double> dayarr = new ArrayList<>();
        List<Double> monavgarr = new ArrayList<>();
        List<Double> annavgarr = new ArrayList<>();
        List<Double> annarr = new ArrayList<>();

        /* miscelaneous variables for program control in main */
        //TODO: See if settings metyr as zero is appropriate
        int simyr, yday = 0, metyr = 0, metday;
        int first_balance;
        int annual_alloc;
        int outv;
        int i, nmetdays;
        double tair_avg, tdiff;
        int dayout;

        /* mode == MODE_MODEL only */
        double daily_ndep = 0;
        double daily_nfix = 0;
        double ndep_scalar = 0;
        double ndep_diff = 0;
        double ndep = 0;
        int ind_simyr;

        /* variables used for monthly average output */
        int curmonth;
        int[] mondays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] endday = {30, 58, 89, 119, 150, 180, 211, 242, 272, 303, 333, 364};
        double monmaxlai = 0.0, annmaxlai = 0.0, monmaxsnoww = 0.0;
        double eomsnoww = 0.0, eomsoilw = 0.0;

        int tmpyears = 0;

        /* mode == MODE_SPINUP only */
        /* spinup control */
        int ntimesmet, nblock = 0;
        int steady1 = 0, steady2 = 0, rising = 0, metcycle = 0, spinyears = 0;
        double tally1 = 0.0, tally1b = 0.0, tally2 = 0.0, tally2b = 0.0, t1 = 0.0;
        double naddfrac = 0;

        /* mode == MODE_MODEL only */
        /* simple annual variables for text output */
        double annmaxplai = 0, annet = 0, annoutflow = 0, annnpp = 0, annnbp = 0, annprcp = 0, anntavg = 0;

        double MODE_SPINUP = Constant.MODE_SPINUP.getValue();
        double MODE_MODEL = Constant.MODE_MODEL.getValue();



        if (mode != MODE_SPINUP && mode != MODE_MODEL) {
            System.out.print("Error: Unknown MODE given when calling bgc()\n");
            return false;
        }

        /* copy the input structures into local structures */
        ws = bgcin.ws;
        cinit = bgcin.cinit;
        cs = bgcin.cs;
        ns = bgcin.ns;
        sitec = bgcin.sitec;
        epc = bgcin.epc;
        /* note that the following three structures have dynamic memory elements,
		and so the notion of copying the input structure to a local structure
		value-by-value is not the same as above. In this case, the array pointers
		are being copied, so the local members use the same memory that was
		allocated in the calling function. Note also that bgc() does not modify
		the contents of these structures. */
        ctrl = bgcin.ctrl;
        metarr = bgcin.metarr;
        co2 = bgcin.co2;
        if (mode == MODE_MODEL) {
            ramp_ndep = bgcin.ramp_ndep;
        } else {
            ramp_ndep = new Ramp_Ndep(0, 0, 0.0, 0.0);
        }

        System.out.print("done copy input\n");

        /* local variable that signals the need for daily output array */
//		dayout = (ctrl.dodaily == 1 || ctrl.domonavg == 1 || ctrl.doannavg == 1);

        if (ctrl.dodaily == 1 || ctrl.domonavg == 1 || ctrl.doannavg == 1) {

            dayout = 1;
        } else {
            dayout = 0;
        }


        /* initialize monavg and annavg to 0.0 */
//        if (dayout == 1) {
//            for (outv = 0; outv < ctrl.ndayout; outv++) {
//                dayarr.add(outv, 0.0);
//            }
//        }
        if (ctrl.domonavg == 1) {
            for (outv = 0; outv < ctrl.ndayout; outv++) {
                monavgarr.add(outv, 0.0);
            }
        }

        if (ctrl.doannavg == 1) {
            for (outv = 0; outv < ctrl.ndayout; outv++) {
                annavgarr.add(outv, 0.0);
            }
        }

        /* initialize the output mapping array */
        if (!outmapin.output_map_init(output_map, metv, ws, wf, cs, cf, ns, nf, phen,
                epv, psn_sun, psn_shade, summary)) {
            System.out.print("Error in call to output_map_init() from bgc()\n");
            return false;
        }

        System.out.print("done initialize outmap\n");

        /* make zero-flux structures for use inside annual and daily loops */
        if (!mzf.make_zero_flux_struct(zero_wf, zero_cf, zero_nf)) {
            System.out.print("Error in call to make_zero_flux_struct() from bgc()\n");
            return false;
        }

        System.out.print("done make_zero_flux\n");

        /* atmospheric pressure (Pa) as a function of elevation (m) */
        if (!atmpres.atm_pres(sitec.elev, metv)) {
            System.out.print("Error in atm_pres() from bgc()\n");
            return false;
        }

        System.out.print("done atm_pres\n");

        /* determine phenological signals */
        if (!prephen.prephenology(ctrl, epc, sitec, metarr, phenarr)) {
            System.out.print("Error in call to prephenology(), from bgc()\n");
            return false;
        }

        System.out.print("done prephenology\n");

		/* calculate the annual average air temperature for use in soil 
		temperature corrections. This code added 9 February 1999, in
		conjunction with soil temperature testing done with Mike White. */
        tair_avg = 0.0;
        nmetdays = ctrl.metyears * 365;
        for (i = 0; i < nmetdays; i++) {
            tair_avg += metarr.tavg.get(i);
        }
        tair_avg /= (double) nmetdays;

		/* if this simulation is using a restart file for its initial
		conditions, then copy restart info into structures */
        if (ctrl.read_restart == 1) {
            if (!restio.restart_input(ctrl, ws, cs, ns, epv, metyr,
                    (bgcin.restart_input))) {
                System.out.print("Error in call to restart_input() from bgc()\n");
                return false;
            }

            System.out.print("done restart_input\n");

        } else
            /* no restart file, user supplies initial conditions */ {
			/* initialize leaf C and N pools depending on phenology signals for
			the first metday */
            if (!firday.firstday(epc, cinit, epv, phenarr, cs, ns)) {
                System.out.print("Error in call to firstday(), from bgc()\n");
                return false;
            }

            /* initial value for metyr */
            metyr = 0;

            System.out.print("done firstday\n");
        }

        /* zero water, carbon, and nitrogen source and sink variables */
        if (!zersrc.zero_srcsnk(cs, ns, ws, summary)) {
            System.out.print("Error in call to zero_srcsnk(), from bgc()\n");
            return false;
        }

        System.out.print("done zero_srcsnk\n");

		/* initialize the indicator for first day of current simulation, so
		that the checks for mass balance can have two days for comparison */
        first_balance = 1;


        /* mode == MODE_SPINUP only*/
        if (mode == MODE_SPINUP) {
            /* for simulations with fewer than 50 metyears, find the multiple of
			metyears that gets close to 100, use this as the block size in
			spinup control */
            if (ctrl.metyears < 50) {
                ntimesmet = 100 / ctrl.metyears;
                nblock = ctrl.metyears * ntimesmet;
            } else {
                nblock = ctrl.metyears;
            }

            /* initialize spinup control variables */
            spinyears = 0;
            metcycle = 0;
            steady1 = 0;
            steady2 = 0;
            rising = 1;
        }

        if (mode == MODE_MODEL) {
            tmpyears = ctrl.simyears;
        } else if (mode == MODE_SPINUP) {
            tmpyears = nblock;
        }

        /* do loop for spinup. will only execute once for MODE_MODEL */
        do {

            /* begin the annual model loop */
            for (simyr = 0; simyr < tmpyears; simyr++) {
                if (mode == MODE_MODEL) {
                    /* reset the simple annual output variables for text output */
                    annmaxlai = 0.0;
                    annet = 0.0;
                    annoutflow = 0.0;
                    annnpp = 0.0;
                    annnbp = 0.0;
                    annprcp = 0.0;
                    anntavg = 0.0;
                }

                /* set current month to 0 (january) at the beginning of each year */
                curmonth = 0;

                if (mode == MODE_SPINUP) {
                /* calculate scaling for N additions (decreasing with
				time since the beginning of metcycle = 0 block */
                    naddfrac = 1.0 - ((double) simyr / (double) nblock);

                    if (metcycle == 0) {
                        tally1 = 0.0;
                        tally1b = 0.0;
                        tally2 = 0.0;
                        tally2b = 0.0;
                    }
                }

                /* test whether metyr needs to be reset */
                if (metyr == ctrl.metyears) {
                    if (mode == MODE_MODEL) {
                        if (ctrl.onscreen == 1) System.out.print("Resetting met data for cyclic input\n");
                    }
                    if (mode == MODE_SPINUP) {
                        System.out.print("Resetting met data for cyclic input\n");
                    }
                    metyr = 0;
                }

                if (mode == MODE_MODEL) {
                    /* output to screen to indicate start of simulation year */
                    if (ctrl.onscreen == 1) System.out.printf("Year: %6d\n", ctrl.simstartyear + simyr);
                } else if (mode == MODE_SPINUP) {
                    /* output to screen to indicate start of simulation year */
                    if (ctrl.onscreen == 1) System.out.printf("Year: %6d\n", spinyears);
                }

                /* set the max lai variable, for annual diagnostic output */
                epv.ytd_maxplai = 0.0;

                if (mode == MODE_MODEL) {
                    /* atmospheric CO2 and Ndep handling */
                    if ((co2.varco2) == 0) {
                        /* constant CO2, constant Ndep */
                        metv.co2 = co2.co2ppm;
                        daily_ndep = sitec.ndep / 365.0;
                        daily_nfix = sitec.nfix / 365.0;
                    } else {
                        /* when varco2 = 1, use file for co2 */
                        if (co2.varco2 == 1) metv.co2 = getco2.get_co2(co2, (ctrl.simstartyear + simyr));
                        System.out.printf("CO2 val: %f Year: %d\n", metv.co2, (ctrl.simstartyear + simyr));
                        if (metv.co2 < -999) {
                            System.out.printf("Error finding CO2 value for year: %d\n", (ctrl.simstartyear + simyr));
                            break;
                        }

                        /* when varco2 = 2, use the constant CO2 value, but vary Ndep */
                        if (co2.varco2 == 2) metv.co2 = co2.co2ppm;

                        if (ramp_ndep.doramp == 1 && bgcin.ndepctrl.varndep == 0) {
                            /* increasing CO2, ramped Ndep */
                            ind_simyr = ramp_ndep.ind_year - ctrl.simstartyear;
                            ndep_scalar = (ramp_ndep.ind_ndep - ramp_ndep.preind_ndep) /
                                    (co2.co2ppm_array.get(ind_simyr) - co2.co2ppm_array.get(0));
                            ndep_diff = (co2.co2ppm_array.get(simyr) - co2.co2ppm_array.get(0)) *
                                    ndep_scalar;
                            ndep = ramp_ndep.preind_ndep + ndep_diff;
                        /* don't allow the industrial ndep levels to be less than
						the preindustrial levels */
                            if (ndep < ramp_ndep.preind_ndep) ndep = ramp_ndep.preind_ndep;
                            daily_ndep = ndep / 365.0;
                            daily_nfix = sitec.nfix / 365.0;
                        } else {
                            /* increasing CO2, constant Ndep */
                            daily_ndep = sitec.ndep / 365.0;
                            daily_nfix = sitec.nfix / 365.0;

                        }
                    }
                    if (bgcin.ndepctrl.varndep == 1 && mode == MODE_MODEL) {

                        daily_ndep = getndep.get_ndep(bgcin.ndepctrl, (ctrl.simstartyear + simyr));
                        if (daily_ndep < -999) {
                            System.out.printf("Error finding NDEP for year: %d\n", (ctrl.simstartyear + simyr));
                            break;
                        } else {
                            System.out.printf("Using annual NDEP value: %f\n", daily_ndep);
                            daily_ndep /= 365.0;
                        }
                    }
                } else if (mode == MODE_SPINUP) {
                    /* atmospheric concentration of CO2 (ppm) */
                    /* Always assign a fixed CO2 value for spinups */
                    metv.co2 = co2.co2ppm;

				/*if (!(co2.varco2)) 
				else metv.co2 = co2.co2ppm_array[simyr]; */
                }

                /* begin the daily model loop */
                for (yday = 0; yday < 365; yday++) {
                    System.out.printf("year %d\tyday %d\n", simyr, yday);

				/* Test for very low state variable values and force them
				to 0.0 to avoid rounding and floating point overflow errors */
                    if (!prectrl.precision_control(ws, cs, ns)) {
                        System.out.print("Error in call to precision_control() from bgc()\n");
                        return false;
                    }

                    /* set the day index for meteorological and phenological arrays */
                    metday = metyr * 365 + yday;

                    /* zero all the daily flux variables */
                    wf = zero_wf;
                    cf = zero_cf;
                    nf = zero_nf;

                    /* daily meteorological variables from metarrays */
                    if (!dmet.daymet(metarr, metv, metday)) {
                        System.out.print("Error in daymet() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone daymet\n", simyr, yday);

				/* soil temperature correction using difference from
				annual average tair */
                    tdiff = tair_avg - metv.tsoil;
                    if (ws.snoww == 1) {
                        metv.tsoil += 0.83 * tdiff;
                    } else {
                        metv.tsoil += 0.2 * tdiff;
                    }

                    /* daily phenological variables from phenarrays */
                    if (!dphen.dayphen(phenarr, phen, metday)) {
                        System.out.print("Error in dayphen() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone dayphen\n", simyr, yday);

                    /* test for the annual allocation day */
                    if (phen.remdays_litfall == 1) annual_alloc = 1;
                    else annual_alloc = 0;

                    /* phenology fluxes */
                    if (!phenfun.phenology(epc, phen, epv, cs, cf, ns, nf)) {
                        System.out.print("Error in phenology() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone phenology\n", simyr, yday);

				/* calculate leaf area index, sun and shade fractions, and specific
				leaf area for sun and shade canopy fractions, then calculate
				canopy radiation interception and transmission */
                    if (!ratran.radtrans(cs, epc, metv, epv, sitec.sw_alb)) {
                        System.out.print("Error in radtrans() from bgc()\n");
                        return false;
                    }

                    /* update the ann max LAI for annual diagnostic output */
                    if (epv.proj_lai > epv.ytd_maxplai) epv.ytd_maxplai = epv.proj_lai;

                    System.out.printf("%d\t%d\tdone radtrans\n", simyr, yday);

                    /* precip routing (when there is precip) */
                    if (metv.prcp == 1.0 && !prcout.prcp_route(metv, epc.int_coef, epv.all_lai,
                            wf)) {
                        System.out.print("Error in prcp_route() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone prcp_route\n", simyr, yday);

                    /* snowmelt (when there is a snowpack) */
                    if (ws.snoww == 1.0 && !snmelt.snowmelt(metv, wf, ws.snoww)) {
                        System.out.print("Error in snowmelt() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone snowmelt\n", simyr, yday);

                    /* bare-soil evaporation (when there is no snowpack) */
                    if (ws.snoww == 0.0 && !barevap.baresoil_evap(metv, wf, epv.dsr)) {
                        System.out.print("Error in baresoil_evap() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone bare_soil evap\n", simyr, yday);

                    /* soil water potential */
                    if (!sopsi.soilpsi(sitec, ws.soilw, epv.psi, epv.vwc)) {
                        System.out.print("Error in soilpsi() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone soilpsi\n", simyr, yday);

                    /* daily maintenance respiration */
                    if (!maresp.maint_resp(cs, ns, epc, metv, cf, epv)) {
                        System.out.print("Error in m_resp() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone maint resp\n", simyr, yday);

                    /* begin canopy bio-physical process simulation */
				/* do canopy ET calculations whenever there is leaf area
				displayed, since there may be intercepted water on the 
				canopy that needs to be dealt with */
                    if (cs.leafc == 1 && metv.dayl == 1) {
                        /* conductance and evapo-transpiration */
                        if (!canet.canopy_et(metv, epc, epv, wf, 1)) {
                            System.out.print("Error in canopy_et() from bgc()\n");
                            return false;
                        }

                        System.out.printf("%d\t%d\tdone canopy_et\n", simyr, yday);

                    }
                /* do photosynthesis only when it is part of the current
				growth season, as defined by the remdays_curgrowth flag.  This
				keeps the occurrence of new growth consistent with the treatment
				of litterfall and allocation */
                    if (cs.leafc == 1 && phen.remdays_curgrowth == 1 && metv.dayl == 1) {
                        if (!photsynth.total_photosynthesis(metv, epc, epv, cf, psn_sun, psn_shade)) {
                            System.out.print("Error in total_photosynthesis() from bgc()\n");
                            return false;
                        }

                    } /* end of photosynthesis calculations */ else {
                        epv.assim_sun = epv.assim_shade = 0.0;
                    }

                    if (mode == MODE_MODEL) {
                        /* nitrogen deposition and fixation */
                        nf.ndep_to_sminn = daily_ndep;
                        nf.nfix_to_sminn = daily_nfix;
                    } else if (mode == MODE_SPINUP) {
                        /* nitrogen deposition and fixation */
                        nf.ndep_to_sminn = sitec.ndep / 365.0;
                        nf.nfix_to_sminn = sitec.nfix / 365.0;
                    }

                    /* calculate outflow */
                    if (!oflow.outflow(sitec, ws, wf)) {
                        System.out.print("Error in outflow() from bgc.c\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone outflow\n", simyr, yday);

                    /* daily litter and soil decomp and nitrogen fluxes */
                    if (!dcomp.decomp(metv.tsoil, epc, epv, sitec, cs, cf, ns, nf, nt)) {
                        System.out.print("Error in decomp() from bgc.c\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone decomp\n", simyr, yday);

				/* Daily allocation gets called whether or not this is a
				current growth day, because the competition between decomp
				immobilization fluxes and plant growth N demand is resolved
				here.  On days with no growth, no allocation occurs, but
				immobilization fluxes are updated normally */
                    if (mode == MODE_MODEL) {
                        if (!dalloc.daily_allocation(cf, cs, nf, ns, epc, epv, nt, 1.0, (int) MODE_MODEL)) {
                            System.out.print("Error in daily_allocation() from bgc.c\n");
                            return false;
                        }
                    } else if (mode == MODE_SPINUP) {
                        /* spinup control */
					/* in the rising limb, use the spinup allocation code
					that supplements N supply */
                        if (steady1 == 0 && rising == 1 && metcycle == 0) {
                            if (!dalloc.daily_allocation(cf, cs, nf, ns, epc, epv, nt, naddfrac, (int) MODE_SPINUP)) {
                                System.out.print("Error in daily_allocation() from bgc.c\n");
                                return false;
                            }
                        } else {
                            if (!dalloc.daily_allocation(cf, cs, nf, ns, epc, epv, nt, 1.0, (int) MODE_MODEL)) {
                                System.out.print("Error in daily_allocation() from bgc.c\n");
                                return false;
                            }
                        }
                    }

                    System.out.printf("%d\t%d\tdone daily_allocation\n", simyr, yday);

				/* reassess the annual turnover rates for livewood -. deadwood,
				and for evergreen leaf and fine root litterfall. This happens
				once each year, on the annual_alloc day (the last litterfall day) */
                    if (annual_alloc == 1) {
                        if (!annrate.annual_rates(epc, epv)) {
                            System.out.print("Error in annual_rates() from bgc()\n");
                            return false;
                        }

                        System.out.printf("%d\t%d\tdone annual rates\n", simyr, yday);
                    }


                    /* daily growth respiration */
                    if (!groresp.growth_resp(epc, cf)) {
                        System.out.print("Error in daily_growth_resp() from bgc.c\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone growth_resp\n", simyr, yday);

                    /* daily update of the water state variables */
                    if (!statup.daily_water_state_update(wf, ws)) {
                        System.out.print("Error in daily_water_state_update() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone water state update\n", simyr, yday);

                    /* daily update of carbon state variables */
                    if (!statup.daily_carbon_state_update(cf, cs, annual_alloc,
                            epc.woody, epc.evergreen)) {
                        System.out.print("Error in daily_carbon_state_update() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone carbon state update\n", simyr, yday);
//TODO: May have been checking daily_nitrogen for true....
                    /* daily update of nitrogen state variables */
                    if (!statup.daily_nitrogen_state_update(nf, ns, annual_alloc,
                            epc.woody, epc.evergreen)) {
                        System.out.print("Error in daily_nitrogen_state_update() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone nitrogen state update\n", simyr, yday);

				/* calculate N leaching loss.  This is a special state variable
				update routine, done after the other fluxes and states are
				reconciled in order to avoid negative sminn under heavy leaching
				potential */
                    if (!nleach.nleaching(ns, nf, ws, wf)) {
                        System.out.print("Error in nleaching() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone nitrogen leaching\n", simyr, yday);

                    /* calculate daily mortality fluxes and update state variables */
				/* this is done last, with a special state update procedure, to
				insure that pools don't go negative due to mortality fluxes
				conflicting with other proportional fluxes */
                    if (!mort.mortality(epc, cs, cf, ns, nf)) {
                        System.out.print("Error in mortality() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone mortality\n", simyr, yday);

                    /* test for water balance */
                    if (!checbal.check_water_balance(ws, first_balance)) {
                        System.out.print("Error in check_water_balance() from bgc()\n");
                        System.out.printf("%d\n", metday);
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone water balance\n", simyr, yday);


                    /* test for carbon balance */
                    if (!checbal.check_carbon_balance(cs, first_balance)) {
                        System.out.print("Error in check_carbon_balance() from bgc()\n");
                        System.out.printf("%d\n", metday);
                        return false;
                    }
//                    System.setOut(dummyStream);
//
                    System.out.printf("%d\t%d\tdone carbon balance\n", simyr, yday);

                    /* test for nitrogen balance */
                    if (!checbal.check_nitrogen_balance(ns, first_balance)) {
                        System.out.print("Error in check_nitrogen_balance() from bgc()\n");
                        System.out.printf("%d\n", metday);
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone nitrogen balance\n", simyr, yday);

                    /* calculate carbon summary variables */
                    if (!sumfun.csummary(cf, cs, summary)) {
                        System.out.print("Error in csummary() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone carbon summary\n", simyr, yday);

                    /* calculate water summary variables */
                    if (!sumfun.wsummary(ws, wf, summary)) {
                        System.out.printf("Error in wsummary() from bgc()\n");
                        return false;
                    }

                    System.out.printf("%d\t%d\tdone water summary\n", simyr, yday);

                    /* DAILY OUTPUT HANDLING */
				/* fill the daily output array if daily output is requested,
				or if the monthly or annual average of daily output variables
				have been requested */
                    System.out.printf("Number of daily outputs: %d\n", ctrl.ndayout);
                    if (dayout == 1) {
                        /* fill the daily output array */
                        for (outv = 0; outv < ctrl.ndayout; outv++) {
                            System.out.printf("Outv: %d, ", outv);
                            System.out.printf("DayCode: %d, ", ctrl.daycodes.get(outv));
                            System.out.printf("Output: %f\n", output_map.get(ctrl.daycodes.get(outv)));
                            dayarr.add(outv, (double) output_map.get(ctrl.daycodes.get(outv)));
                        }
                    }
                    /* only write daily outputs if requested */
                    if (ctrl.dodaily == 1) {
//					/* write the daily output array to daily output file */
//					if (fwrite(dayarr, sizeof(float), ctrl.ndayout, bgcout.dayout.ptr)
//						!= (size_t)ctrl.ndayout)
//					{
//						System.out.printf("Error writing to %s: simyear = %d, simday = %d\n",
//							bgcout.dayout.name,simyr,yday);
//						ok=0;
//					}

                        System.out.printf("%d\t%d\tdone daily output\n", simyr, yday);
                        if (bgcout.bgc_ascii == 1) {

                            outasc.output_ascii(dayarr, ctrl.ndayout, bgcout.dayoutascii);

                        }

                    }

                    /*******************/
                    /* MONTHLY OUTPUTS */
                    /*******************/

                    /* MONTHLY AVERAGE OF DAILY OUTPUT VARIABLES */
                    if (ctrl.domonavg == 1) {
                        /* update the monthly average array */
                        for (outv = 0; outv < ctrl.ndayout; outv++) {
                            monavgarr.set(outv, monavgarr.get(outv) + dayarr.get(outv));

                            switch (ctrl.daycodes.get(outv)) {
                                /* Leaf area index */
                                case 545:
                                    if (dayarr.get(outv) > monmaxlai) {
                                        monmaxlai = dayarr.get(outv);
                                    }
                                    break;
                            }
                        }

                        /* if this is the last day of the current month, output... */
                        if (yday == endday[curmonth]) {
                            /* finish the averages */
                            for (outv = 0; outv < ctrl.ndayout; outv++) {
                                if (summary_sanity == SANE) {
                                    switch (ctrl.daycodes.get(outv)) {
                                        /* Leaf area index */
                                        /* Maximum monthly */
                                        case 545:
                                            monavgarr.set(outv, monmaxlai);
                                            break;
                                        /* Snow water */
                                        case 21:
                                            monavgarr.set(outv, dayarr.get(outv) - eomsnoww);
                                            eomsnoww = dayarr.get(outv);
                                            break;
                                        /* Soil water content */
                                        case 20:
                                            monavgarr.set(outv, dayarr.get(outv) - eomsoilw);
                                            eomsoilw = dayarr.get(outv);
                                            break;
                                        default:
                                            monavgarr.set(outv, monavgarr.get(outv) / (float) mondays[curmonth]);
                                            break;
                                    }
                                } else {
                                    monavgarr.set(outv, monavgarr.get(outv) / (float) mondays[curmonth]);
                                }
                            }

                            /* write to file */
//						if (fwrite(monavgarr, sizeof(float), ctrl.ndayout, bgcout.monavgout.ptr)
//							!= (size_t)ctrl.ndayout)
//						{
//							System.out.printf("Error writing to %s: simyear = %d, simday = %d\n",
//								bgcout.monavgout.name,simyr,yday);
//							ok=0;
//						}

                            if (bgcout.bgc_ascii == 1) {
                                outasc.output_ascii(monavgarr, ctrl.ndayout, bgcout.monoutascii);

                            }

                            /* reset monthly average variables for next month */
                            for (outv = 0; outv < ctrl.ndayout; outv++) {
                                monavgarr.set(outv, 0.0);
                                monmaxlai = 0.0;
                                monmaxsnoww = 0.0;
                            }

                            /* increment current month counter */
                            curmonth++;

                            System.out.printf("%d\t%d\tdone monavg output\n", simyr, yday);

                        }
                    }

                    /* ANNUAL AVERAGE OF DAILY OUTPUT VARIABLES */
                    if (ctrl.doannavg == 1) {
                        /* update the annual average array */
                        for (outv = 0; outv < ctrl.ndayout; outv++) {
                            annavgarr.set(outv, annavgarr.get(outv) + dayarr.get(outv));
                            switch (ctrl.daycodes.get(outv)) {
                                /* Leaf area index */
                                case 545:
                                    if (dayarr.get(outv) > annmaxplai) {
                                        annmaxplai = dayarr.get(outv);
                                        break;
                                    }

                            }
                        }

                        /* if this is the last day of the year, output... */
                        if (yday == 364) {
                            /* finish averages */
                            for (outv = 0; outv < ctrl.ndayout; outv++) {
                                if (summary_sanity == SANE) {
                                    switch (ctrl.daycodes.get(outv)) {
                                        /* Leaf area index*/
                                        case 545:
                                            annavgarr.set(outv, (double) annmaxplai);
                                            break;
                                        default:
                                            annavgarr.set(outv, annavgarr.get(outv) / 365.0);
                                            break;
                                    }
                                } else {
                                    annavgarr.set(outv, annavgarr.get(outv) / 365.0);
                                }
                            }

                            /* write to file */
//						if (fwrite(annavgarr, sizeof(float), ctrl.ndayout, bgcout.annavgout.ptr)
//							!= (size_t)ctrl.ndayout)
//						{
//							System.out.printf("Error writing to %s: simyear = %d, simday = %d\n",
//								bgcout.annavgout.name,simyr,yday);
//							ok=0;
//						}

                            /* reset annual average variables for next month */
                            for (outv = 0; outv < ctrl.ndayout; outv++) {
                                annavgarr.set(outv, 0.0);
                                annmaxplai = 0.0;
                            }

                            System.out.printf("%d\t%d\tdone annavg output\n", simyr, yday);

                        }
                    }

                    if (mode == MODE_MODEL) {
                        /* very simple annual summary variables for text file output */
                        if (epv.proj_lai > (double) annmaxlai) annmaxlai = (float) epv.proj_lai;
                        annet += wf.canopyw_evap + wf.snoww_subl + wf.soilw_evap +
                                wf.soilw_trans;
                        annoutflow += wf.soilw_outflow;
                        annnpp += summary.daily_npp * 1000.0;
                        annnbp += summary.daily_nee * 1000.0;
                        annprcp += metv.prcp;
                        anntavg += metv.tavg / 365.0;
                    } else if (mode == MODE_SPINUP) {
                        /* spinup control */
					/* keep a tally of total soil C during successive
					met cycles for comparison */
                        if (metcycle == 1) {
                            tally1 += summary.soilc;
                            tally1b += summary.totalc;
                        }
                        if (metcycle == 2) {
                            tally2 += summary.soilc;
                            tally2b += summary.totalc;
                        }
                    }

				/* at the end of first day of simulation, turn off the 
				first_balance switch */
                    if (first_balance == 1) first_balance = 0;

                }   /* end of daily model loop */

                /* ANNUAL OUTPUT HANDLING */
                /* only write annual outputs if requested */
                if (ctrl.doannual == 1) {
                    /* fill the annual output array */
                    for (outv = 0; outv < ctrl.nannout; outv++) {
                        annarr.add(outv, (double) output_map.get(ctrl.anncodes.get(outv)));
                    }
                    /* write the annual output array to annual output file */
//				if (fwrite(annarr, sizeof(float), ctrl.nannout, bgcout.annout.ptr)
//					!= (size_t)ctrl.nannout)
//				{
//					System.out.printf("Error writing to %s: simyear = %d, simday = %d\n",
//						bgcout.annout.name,simyr,yday);
//					ok=0;
//				}

                    if (bgcout.bgc_ascii == 1) {

                        outasc.output_ascii(annarr, ctrl.nannout, bgcout.annoutascii);

                    }
                    System.out.printf("%d\t%d\tdone annual output\n", simyr, yday);
                }

                if (mode == MODE_MODEL && bgcout.bgc_ascii == 1) {
                    /* write the simple annual text output */

                    try {
                        writer = new PrintWriter(bgcout.anntext, "UTF-8");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        return false;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return false;
                    }

                    writer.printf("%6d%10.1f%10.1f%10.1f%10.1f%10.1f%10.1f%10.1f\n",
                            ctrl.simstartyear + simyr, annprcp, anntavg, annmaxlai, annet, annoutflow, annnpp, annnbp);
                }

                metyr++;

                if (mode == MODE_SPINUP) {
                    /* spinup control */
                    spinyears++;
                }

            }   /* end of annual model loop */


            if (mode == MODE_SPINUP) {
                /* spinup control */
                /* if this is the third pass through metcycle, do comparison */
                /* first block is during the rising phase */
                if (steady1 == 0 && metcycle == 2) {
                    /* convert tally1 and tally2 to average daily soilc */
                    tally1 /= (double) nblock * 365.0;
                    tally2 /= (double) nblock * 365.0;
                    if (tally2 > tally1) {
                        rising = 1;
                    }
                    t1 = (tally2 - tally1) / (double) nblock;

                    if (Math.abs(t1) < SPINUP_TOLERANCE) {
                        steady1 = 1;
                    }
//				steady1 = (Math.abs(t1) < SPINUP_TOLERANCE);

                    System.out.printf("spinyears = %d rising = %d steady1 = %d\n", spinyears,
                            rising, steady1);
                    System.out.printf("metcycle = %d tally1 = %f tally2 = %f pdif = %f\n\n",
                            metcycle, tally1, tally2, t1);
                    if (steady1 == 1) System.out.printf("SWITCH\n\n");

                    metcycle = 0;
                }
                /* second block is after supplemental N turned off */
                else if (steady1 == 1 && metcycle == 2) {
                    /* convert tally1 and tally2 to average daily soilc */
                    tally1 /= (double) nblock * 365.0;
                    tally2 /= (double) nblock * 365.0;
                    t1 = (tally2 - tally1) / (double) nblock;

                    if (Math.abs(t1) < SPINUP_TOLERANCE) {
                        steady2 = 1;
                    }
//				steady2 = (Math.abs(t1) < SPINUP_TOLERANCE);

                    /* if rising above critical rate, back to steady1=0 */
                    if (t1 > SPINUP_TOLERANCE) {
                        System.out.print("\nSWITCH BACK\n");

                        steady1 = 0;
                        rising = 1;
                    }

                    System.out.printf("spinyears = %d rising = %d steady2 = %d\n", spinyears,
                            rising, steady2);
                    System.out.printf("metcycle = %d tally1 = %f tally2 = %f pdif = %f\n\n",
                            metcycle, tally1, tally2, t1);

                    metcycle = 0;
                } else {
                    System.out.printf("spinyears = %d rising = %d steady1 = %d\n", spinyears,
                            rising, steady1);
                    System.out.printf("metcycle = %d tally1 = %f tally2 = %f pdif = %f\n",
                            metcycle, tally1, tally2, t1);

                    metcycle++;
                }
            }

            /* end of do block, test for steady state */
        } while (mode == MODE_SPINUP && (!(steady1 == 1 && steady2 == 1) && (spinyears < ctrl.maxspinyears ||
                metcycle != 0)));

        /* mode == MODE_SPINUP only */
        if (mode == MODE_SPINUP) {
            /* save some information on the end status of spinup */
            tally1b /= (double) nblock * 365.0;
            tally2b /= (double) nblock * 365.0;
            bgcout.spinup_resid_trend = (tally2b - tally1b) / (double) nblock;
            bgcout.spinup_years = spinyears;
        }

        /* RESTART OUTPUT HANDLING */
        /* if write_restart flag is set, copy data to the output restart struct */
        /* Removed 'write_restart' restriction to ensure that restart data are */
        /* available for spin and go operation.  WMJ 3/16/2005 */

        if (!restio.restart_output(ctrl, ws, cs, ns, epv, metyr,
                (bgcout.restart_output))) {
            System.out.print("Error in call to restart_output() from bgc()\n");
            return false;
        } else System.out.printf("%d\t%d\tdone restart output\n", simyr, yday);


        /* free phenology memory */
//		if (ok && free_phenmem(phenarr))
//		{
//			System.out.printf("Error in free_phenmem() from bgc()\n");
//			ok=0;
//		}
//
//		System.out.printf("%d\t%d\tdone free phenmem\n",simyr,yday);

        /* free memory for local output arrays */

//		if (dayout == 1) free(dayarr);
//		if (ctrl.domonavg) free(monavgarr);
//		if (ctrl.doannavg) free(annavgarr);
//		if (ctrl.doannual) free(annarr);
//		free(output_map);

//        /* print timing info if error */
//        if (ok == 0) {
//            System.out.printf(BV_ERROR, "ERROR at year %d\n", simyr - 1);
//            System.out.printf(BV_ERROR, "ERROR at yday %d\n", yday - 1);
//        }

        return true;
    }

}
