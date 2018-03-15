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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PointBGC {

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
        bgcin = new BGCIn(new Restart_Data(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0),
                new Control(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, 0),
                new Ramp_Ndep(0, 0, 0.0, 0.0),
                new CO2Control(0, 0.0, new ArrayList<>(), new ArrayList<>(), 0),
                new NDepControl(0, 0.0, new ArrayList<>(), new ArrayList<>(), 0),
                new MetArr(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()),
                new WState(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0),
                new CInit(0.0, 0.0),
                new CState(.0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0),
                new NState(.0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0),
                new Siteconst(.0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0, .0),
                new Epconst(0, 0, 0, 0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));

        int BV_SILENT = (int) Constant.BV_SILENT.getValue();
        int BV_DIAG = (int) Constant.BV_DIAG.getValue();
        int SANE = (int) Constant.SANE.getValue();
        int MODE_SPINUP = (int) Constant.MODE_SPINUP.getValue();
        int MODE_MODEL = (int) Constant.MODE_MODEL.getValue();
        int MODE_SPINNGO = (int) Constant.MODE_SPINNGO.getValue();

        /* system time variables */
        //TODO: Check if the java implementation of time works properly
        ZonedDateTime zdt = ZonedDateTime.now();

        /* program variables */
        String VERS = "4.2";
        String USER = "unknown";
        String HOST = "Windows";

        //TODO: Check to see if these variables should be global because they are references in other classes
        int summary_sanity;

        int c; /* for getopt cli argument processing */
        int bgc_verbosity;
        int optind, opterr;
        int bgc_ascii = 0;
        int optarg;
        int cli_mode; /* What cli requested mode to run in.*/
        int readndepfile = 0;        /* Flag to tell the program to read an external NDEP file passed using getpopt -n */

        bgcin.ndepctrl.varndep = 0;
        /* Store command name for use by bgc_print_usage() */
        String argv_zero = args[0];

        //TODO: Check if this is the proper way to iterate through arguments
        for (int currArg = 0; currArg < args.length; currArg++) {

            switch (args[currArg]) {

                case "V":
                    System.out.printf("BiomeBGC version %s (built %s %s by %s on %s", VERS, zdt.format(DateTimeFormatter.BASIC_ISO_DATE), zdt.format(DateTimeFormatter.ISO_LOCAL_TIME), USER, HOST);
                    return;

                case "s":
                    bgc_verbosity = BV_SILENT;
                    break;

                case "v":
                    try {
                        bgc_verbosity = Integer.valueOf(args[currArg + 2]);
                    } catch (ClassCastException cce) {

                        System.out.println("Invalid data type inputted for verbosity level. Must be a number.");
                        return;
                    }
                    break;

                case "l":


            }


        }
    }
}
