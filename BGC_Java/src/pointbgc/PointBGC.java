/*
pointbgc.c
front-end to BIOME-BGC for single-point, single-biome simulations
Uses BIOME-BGC function library

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/

package pointbgc;

import classes.*;

import java.io.File;
import java.time.ZonedDateTime;

public class pointbgc {

    public static void main(String args[]) {

        /* bgc input and output structures */
        BGCIn bgcin;
        BGCOut bgcout;

        /* local control information */
        Point point;
        Restart_Ctrl restart;
        ClimChange scc;
        Output output;

        File init;
        File ndep_file;

        // Initialize variables
        bgcin = new BGCIn(new Restart_Data(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0), new Control(), new Ramp_Ndep(), new CO2Control(), new NDepControl(), new MetArr(), new WState(), new CInit(), new CState(), new NState(), new Siteconst(), new Epconst())

        /* system time variables */
        //TODO: Check if the java implementation of time works properly
        ZonedDateTime zdt = ZonedDateTime.now();

        int summary_sanity;

        int c; /* for getopt cli argument processing */
        int bgc_verbosity;
        int optind, opterr;
        int bgc_ascii = 0;
        int optarg;
        int cli_mode; /* What cli requested mode to run in.*/
        int readndepfile = 0;		/* Flag to tell the program to read an external NDEP file passed using getpopt -n */

        bgcin.ndepctrl.varndep = 0;
    }
}
