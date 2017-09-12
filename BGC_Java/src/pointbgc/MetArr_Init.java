//Compatible
package pointbgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bgclib.Smooth;
import classes.ClimChange;
import classes.Constant;
import classes.MetArr;

public class MetArr_Init {

	/*
     * It is assumed here that the meteorological datafile contains the
	 * following list of variables, with the indicated units. All other
	 * variables in the metv arrays are derived from this basic set:
	 * 
	 * VARIABLE UNITS yday (none) (yearday) prcp cm (daily total precipitation,
	 * water equivalent) tmax deg C (daily maximum temperature) tmin deg C
	 * (daily minimum temperature) VPD Pa (daylight average VPD) swavgfd W/m2
	 * (daylight average shortwave flux density) daylength s (daylight duration)
	 * 
	 */

    //TODO: Determine if the metf file is properly read in somewhere else in the code
    public boolean metarr_init(File metf, MetArr metarr, final ClimChange scc, int nyears, int nhead) {

        int i;
        int ndays;
        int year;
        double tmax, tmin, prcp, vpd, swavgfd = 0, dayl = 0;
        Scanner sc = null;
        String[] sCurrline;

        double RAD2PAR = Constant.RAD2PAR.getValue();

        try {
            sc = new Scanner(metf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Smooth sm = new Smooth();

        ndays = 365 * nyears;

		/* Skips the header files */
        for (int j = 0; j < nhead; j++) {

            sc.nextLine();

        }

		/* begin daily loop: read input file, generate array values */
        for (i = 0; i < ndays; i++) {

			/* Fixed 02/05/04 */
            if (swavgfd < 0.0) {
                swavgfd = 0.0;
            }

            if (dayl < 0.0) {
                dayl = 0.0;
            }

            sCurrline = sc.nextLine().split("\\s+");

			/*
			 * apply the climate change scenario and store NOTE: Skips year,
			 * yday and Tday columns
			 */

            tmax = Double.valueOf(sCurrline[2]);
            tmin = Double.valueOf(sCurrline[3]);
            prcp = Double.valueOf(sCurrline[5]);
            vpd = Double.valueOf(sCurrline[6]);
            swavgfd = Double.valueOf(sCurrline[7]);


            metarr.tmax.add(i, tmax + scc.s_tmax);
            metarr.tmin.add(i, tmin + scc.s_tmin);
            metarr.prcp.add(i, prcp + scc.s_prcp);
            metarr.vpd.add(i, vpd + scc.s_vpd);
            metarr.swavgfd.add(i, swavgfd * scc.s_swavgfd);
            metarr.par.add(i, swavgfd * RAD2PAR * scc.s_swavgfd);
            metarr.tavg.add(i, (metarr.tmax.get(i) + metarr.tmin.get(i)) / 2.0);
        }

        sm.run_avg(metarr.tavg, metarr.tavg_ra, ndays, 11, 1);

        sc.close();
        return true;
    }


}
