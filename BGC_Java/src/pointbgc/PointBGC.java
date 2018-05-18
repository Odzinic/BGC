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

import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PointBGC {

    //TODO: Can these be properly accessed outside of PointBGC class
    public static int cli_mode = (int) Constant.MODE_INI.getValue();
    public static int summary_sanity;
    public static int bgc_verbosity;


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
        FileWriter bgc_logfile;


        // Initialization classes
        Presim_State_Init pres_state_init;
        Ini ini;
        Met_Init met_init;
        Restart_Init restart_init;
        Time_Init time_init;
        Scc_Init scc_init;
        CO2_Init co2_init;
        Sitec_Init sitec_init;
        Ramp_NDep_Init ramp_ndep_init;
        Epc_Init epc_init;
        State_Init wstate_init;
        State_Init cnstate_init;
        Output_Ctrl output_ctrl;
        Output_Init output_init;
        End_Init end_init;
        MetArr_Init metarr_init;



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

        point = new Point("", "", null, 0);
        output = new Output(0, "", 0, 0, 0, 0, 0, 0, new ArrayList<>(), new ArrayList<>(), null, null, null, null, null, null, null, null, 0);

        pres_state_init = new Presim_State_Init();
        ini = new Ini();
        met_init = new Met_Init();
        restart_init = new Restart_Init();
        time_init = new Time_Init();
        scc_init = new Scc_Init();
        co2_init = new CO2_Init();
        sitec_init = new Sitec_Init();
        ramp_ndep_init = new Ramp_NDep_Init();
        epc_init = new Epc_Init();
        wstate_init = new State_Init();
        cnstate_init = new State_Init();
        output_ctrl = new Output_Ctrl();
        output_init = new Output_Init();
        end_init = new End_Init();
        metarr_init = new MetArr_Init();


        int BV_SILENT = (int) Constant.BV_SILENT.getValue();
        int BV_DIAG = (int) Constant.BV_DIAG.getValue();
        int SANE = (int) Constant.SANE.getValue();
        int MODE_SPINUP = (int) Constant.MODE_SPINUP.getValue();
        int MODE_MODEL = (int) Constant.MODE_MODEL.getValue();
        int MODE_SPINNGO = (int) Constant.MODE_SPINNGO.getValue();
        int MODE_INI = (int) Constant.MODE_INI.getValue();


        /* system time variables */
        //TODO: Check if the java implementation of time works properly
        ZonedDateTime zdt = ZonedDateTime.now();

        /* program variables */
        String VERS = "4.2";
        String USER = "unknown";
        String HOST = "Windows";

        //TODO: Check to see if these variables should be global because they are references in other classes
        //   int summary_sanity;

        int c; /* for getopt cli argument processing */
        //   int bgc_verbosity;
        int optind, opterr;
        int bgc_ascii = 0;
        int optarg;
        //   public static int cli_mode; /* What cli requested mode to run in.*/
        int readndepfile = 0;        /* Flag to tell the program to read an external NDEP file passed using getpopt -n */

        bgcin.ndepctrl.varndep = 0;
        /* Store command name for use by bgc_print_usage() */
        String argv_zero = args[0];

        //TODO: Check if this is the proper way to iterate through arguments
        for (int currArg = 0; currArg < args.length; currArg++) {

            switch (args[currArg]) {

                case "-V":
                    System.out.printf("BiomeBGC version %s (built %s %s by %s on %s\n", VERS, zdt.format(DateTimeFormatter.BASIC_ISO_DATE), zdt.format(DateTimeFormatter.ISO_LOCAL_TIME), USER, HOST);
                    return;

                case "-s":
                    bgc_verbosity = BV_SILENT;
                    break;

                case "-v":
                    try {
                        bgc_verbosity = Integer.valueOf(args[currArg + 1]);
                        break;

                    } catch (ClassCastException cce) {

                        System.out.println("Invalid data type inputted for verbosity level. Must be a number.");
                        return;
                    }

                case "-l":
                    // Attempt to open logfile specified by user
                    try {
                        File logpath = new File(args[currArg + 1]);
                        bgc_logfile = new FileWriter(logpath);
                        break;
                    } catch (FileNotFoundException fnfe) {
                        System.out.println("Specified logfile path does not exist.");
                        return;
                    } catch (IOException ioe) {
                        System.out.println("Specified logfile path cannot be opened.");
                        return;
                    }

                case "-p":
                    // Do alternate calculation for summary outputs (see USAGE.TXT)
                    summary_sanity = SANE;
                    break;

                case "-u":
                    // Run in spin-up mode (over ride ini setting)
                    cli_mode = MODE_SPINUP;
                    break;

                case "-m":
                    // Run in model mode (over ride ini setting)
                    cli_mode = MODE_MODEL;
                    break;

                case "-g":
                    // Run in spin 'n go mode: do spinup and model in one run
                    cli_mode = MODE_SPINNGO;
                    break;

                case "-a":
                    bgc_ascii = 1;
                    break;

                case "-n": /* Nitrogen deposition file */
                    //Try to open nitrogen deposition file
                    ndep_file = new File(args[currArg + 1]);
                    System.out.printf("Using annual NDEP file %s\n", ndep_file.getName());
                    readndepfile = 1;
                    bgcin.ndepctrl.varndep = 1;
                    break;

                case "-?":
                    break;

                default:
                    break;
            }

        }

        System.out.printf("Verbosity Level Set To: %d\n", bgc_verbosity);

        if (summary_sanity == SANE) {
            System.out.println("Summary outputs will be calculated more sanely. See USAGE.TXT for details\n");
        }

        if (cli_mode != MODE_INI) {
            System.out.println("Overridding ini mode.");

            if (cli_mode == MODE_SPINUP) {
                System.out.println("Running in Spinup mode.");
            }
            if (cli_mode == MODE_MODEL) {
                System.out.println("Running in Model mode.");
            }
            if (cli_mode == MODE_SPINNGO) {
                System.out.println("Running in Spin-and-Go mode.\nThe spinup and model will both be run.");
            }


        }

        System.out.println(("Done processing CLI arguments."));

        /* get the system time at start of simulation */
        point.systime = zdt.toString();

        output.anncodes = null;
        output.daycodes = null;
        output.bgc_ascii = bgc_ascii;

        /* initialize the bgcin state variable structures before filling with
        values from ini file */
        if (pres_state_init.presim_state_init(bgcin.ws, bgcin.cs, bgcin.ns, bgcin.cinit) == false) {
            System.out.println("Error in call to presim_state_init() from pointbgc()");
            return;
        }

        /******************************
         **                           **
         **  BEGIN READING INIT FILE  **
         **                           **
         ******************************/

        /* open the main init file for ascii read and check for errors */
        if (ini.file_open(new File(args[args.length - 1]), 'i') == false) {
            System.out.println("Error opening init file, pointbgc.c");
            return;
        }
        init = new File(args[args.length - 1]);

        /* open met file, discard header lines */
        if (met_init.met_init(init, point) == false) {

            System.out.println("Error in initializing Met class.");
            return;
        } else System.out.println("Met class initialized");








    }
}
