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

import bgclib.BGC;
import classes.*;

import java.io.*;
import java.lang.reflect.Field;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PointBGC {

    //TODO: Can these be properly accessed outside of PointBGC class
    public static double cli_mode = Constant.MODE_INI.getValue();
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
        BGC bgc;
        Presim_State_Init pres_state_init;
        Ini ini;
        Met_Init met_init;
        Restart_Init restart_init;
        Time_Init time_init;
        Scc_Init scc_init;
        CO2_Init co2_init;
        NDep_Init ndep_init;
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
        bgcout = new BGCOut(new Restart_Data(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0),
                new File(""), new File(""), new File(""), new File(""), new File(""), new File(""), new File(""), new File(""), 0.0, 0, 0);
        point = new Point("", "", null, 0);
        output = new Output(0, "", 0, 0, 0, 0, 0, 0, new ArrayList<>(), new ArrayList<>(), null, null, null, null, null, null, null, null, 0);
        restart = new Restart_Ctrl(0, 0, 0, new File(""), new File("")); //TODO: Find if this throws a file not found
        scc = new ClimChange(0.0, 0.0, 0.0, 0.0, 0.0);
        ndep_file = new File(""); //TODO: Find if this throws a file not found

        pres_state_init = new Presim_State_Init();
        ini = new Ini();
        met_init = new Met_Init();
        restart_init = new Restart_Init();
        time_init = new Time_Init();
        scc_init = new Scc_Init();
        co2_init = new CO2_Init();
        ndep_init = new NDep_Init();
        sitec_init = new Sitec_Init();
        ramp_ndep_init = new Ramp_NDep_Init();
        epc_init = new Epc_Init();
        wstate_init = new State_Init();
        cnstate_init = new State_Init();
        output_ctrl = new Output_Ctrl();
        output_init = new Output_Init();
        end_init = new End_Init();
        metarr_init = new MetArr_Init();
        bgc = new BGC();


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

        //TODO: Check to see if these variables should be global because they are referenced in other classes
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

//        output.anncodes = null;
//        output.daycodes = null;
        output.bgc_ascii = bgc_ascii;

        /* initialize the bgcin state variable structures before filling with
        values from ini file */
        if (!pres_state_init.presim_state_init(bgcin.ws, bgcin.cs, bgcin.ns, bgcin.cinit)) {
            System.out.println("Error in call to presim_state_init() from pointbgc()");
            return;
        }

        /******************************
         **                           **
         **  BEGIN READING INIT FILE  **
         **                           **
         ******************************/

        /* open the main init file for ascii read and check for errors */
        if (!(new File(args[args.length - 1]).canRead())) {
            System.out.println(args[args.length - 1]);
            System.out.println("Error opening init file, pointbgc.c");
            return;
        }
        init = new File(args[args.length - 1]);

        /* open met file, discard header lines */
        if (!met_init.met_init(init, point)) {
            System.out.println("Error in initializing Met class.");
            return;
        } else System.out.println("Met class initialized");

        /* read restart control parameters */
        if (!restart_init.restart_init(init, restart)) {
            System.out.println(("Error in initializing Restart class"));
            return;
        } else System.out.println(("Restart class initialized"));

        /* read simulation timing control parameters */
        if (!time_init.time_init(init, bgcin.ctrl)) {
            System.out.println(("Error in initializing Timing Control class"));
            return;
        } else System.out.println("Timing Control class initialized");

        /* read scalar climate change parameters */
        if (!scc_init.scc_init(init, scc)) {
            System.out.println(("Error in initializing Scalar Climate Change class"));
            return;
        } else System.out.println("Scalar Climate Change class initialized");

        /* read CO2 control parameters */
        if (!co2_init.co2_init(init, bgcin.co2, bgcin.ctrl.simyears)) {
            System.out.println("Error in initializing CO2 Control class");
            return;
        } else System.out.println("CO2 control initialized class");

        /* Check if reading Nitrogen Deposition file is enabled */
        if (readndepfile == 1) {

            if (!ndep_init.ndep_init(ndep_file, bgcin.ndepctrl)) {
                System.out.println("Error in initializing Nitrogen Deposition class");
                return;
            } else System.out.println("Nitrogen Deposition class initialized");
        }

        /* read site constants */
        if (!sitec_init.sitec_init(init, bgcin.sitec)) {
            System.out.println("Error in initializing Site class");
            return;
        } else System.out.println("Site class initialized");

        /* read ramped nitrogen deposition block */
        if (!ramp_ndep_init.ramp_ndep_init(init, bgcin.ramp_ndep)) {
            System.out.println("Error in initializing Ramped Deposition class");
            return;
        } else System.out.println("Ramped Deposition class initialized");

        /* read ecophysiological constants */
        if (!epc_init.epc_init(init, bgcin.epc)) {
            System.out.println("Error in initializing Ecophysiological class");
            return;
        } else System.out.println("Ecophysiological class initialized");

        /* initialize water state structure */
        if (!wstate_init.wstate_init(init, bgcin.sitec, bgcin.ws)) {
            System.out.println("Error in initializing Water State class");
            return;
        } else System.out.println("Water State class initialized");

        /* initialize carbon and nitrogen state structures */
        if (!cnstate_init.cnstate_init(init, bgcin.epc, bgcin.cs, bgcin.cinit, bgcin.ns)) {
            System.out.println("Error in initializing Carbon and Nitrogen State classes");
            return;
        } else System.out.println("Carbon and Nitrogen State classes initialized");

        /* read the output control information */
        if (!output_ctrl.output_ctrl(init, output)) {
            System.out.println("Error in initializing Output Control class");
            return;
        } else System.out.println("Output Control class initialized");

        /* initialize output files. Does nothing in spinup mode*/
        if (!output_init.output_init(output)) {
            System.out.println("Error in initializing Output class");
            return;
        } else System.out.println("Output class initialized");

        /* read final line out of init file to test for proper file structure */
        if (!end_init.end_init(init)) {
            System.out.println("Error reading end of init file");
            return;
        } else System.out.println("Ending of init read");

        /* read meteorology file, build metarr arrays, compute running avgs */
        if (!metarr_init.metarr_init(point.metf, bgcin.metarr, scc, point, bgcin.ctrl.metyears)) {
            System.out.println("Error in intializing Meteorological classes");
            return;
        } else System.out.println(("Meteorological classes initialized"));

        /* copy some of the info from input structure to bgc simulation control
	    structure */
        bgcin.ctrl.onscreen = output.onscreen;
        bgcin.ctrl.dodaily = output.dodaily;
        bgcin.ctrl.domonavg = output.domonavg;
        bgcin.ctrl.doannavg = output.doannavg;
        bgcin.ctrl.doannual = output.doannual;
        bgcin.ctrl.ndayout = output.ndayout;
        bgcin.ctrl.nannout = output.nannout;
        bgcin.ctrl.daycodes = output.daycodes;
        bgcin.ctrl.anncodes = output.anncodes;
        bgcin.ctrl.read_restart = restart.read_restart;
        bgcin.ctrl.write_restart = restart.write_restart;
        bgcin.ctrl.keep_metyr = restart.keep_metyr;

        /* copy the output file structures into bgcout */
        if (output.dodaily == 1) bgcout.dayout = output.dayout;
        if (output.domonavg == 1) bgcout.monavgout = output.monavgout;
        if (output.doannavg == 1) bgcout.annavgout = output.annavgout;
        if (output.doannual == 1) bgcout.annout = output.annout;
        if (output.bgc_ascii == 1 && output.dodaily == 1) bgcout.dayoutascii = output.dayoutascii;
        if (output.bgc_ascii == 1 && output.domonavg == 1) bgcout.monoutascii = output.monoutascii;
        if (output.bgc_ascii == 1 && output.doannual == 1) bgcout.annoutascii = output.annoutascii;
        bgcout.anntext = output.anntext;
        bgcout.bgc_ascii = bgc_ascii;

        /* if using ramped Ndep, copy preindustrial Ndep into ramp_ndep struct */
        if (bgcin.ramp_ndep.doramp == 1) {
            bgcin.ramp_ndep.preind_ndep = bgcin.sitec.ndep;
        }

        /* if using an input restart file, read a record */
        if (restart.read_restart == 1) {
            /* 02/06/04
             * The if statement gaurds against core dump on bad restart file.
             * If spinup exits with error then the norm trys to use the restart,
             * that has nothing in it, a seg fault occurs. Amac */
            if (!restart.in_restart.canRead()) {
                System.out.println("Error reading restart file! 0 bytes read. Aborting..");
                return;
            }

        }

        /*********************
         **                  **
         **  CALL BIOME-BGC  **
         **                  **
         *********************/

        /* all initialization complete, call model */
        /* either call the spinup code or the normal simulation code */
        if (bgcin.ctrl.spinup == 1) {

            if (!bgc.bgc(bgcin, bgcout, MODE_SPINUP)) {
                System.out.println("Error in call to bgc() using spinup mode");
                return;
            }

            System.out.println(String.format("SPINUP: residual trend  = %f", bgcout.spinup_resid_trend));
            System.out.println(String.format("SPINUP: number of years  = %d", bgcout.spinup_years));
        } else {

            if (!bgc.bgc(bgcin, bgcout, MODE_MODEL)) {
                System.out.println("Error in call to bgc() using model mode");
                return;
            }
        }

        //TODO: Check if this works the same as fwrite
        /* if using an output restart file, write a record */
        if (restart.write_restart == 1) {
            BufferedWriter restart_file = null;
            try {
                restart_file = new BufferedWriter(new FileWriter("restart/restart_file.ini", true));
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (Field f : bgcout.restart_output.getClass().getDeclaredFields()) {
                try {
                    restart_file.write(f.toString());
                    restart_file.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            try {
                restart_file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /* Now do the Model part of Spin & Go. */
        if (cli_mode == MODE_SPINNGO) {
            System.out.println("Finished Spinup for Spin 'n Go. Now starting Model run ('Go' part of Spin'n Go)");
            System.out.println("Assigned bgcout struct to bgcin for spinngo model run");

            bgcin.ctrl.spinup = 0;
            output.doannavg = 1;
            output.doannual = 1;
            output.dodaily = 1;
            output.domonavg = 1;

            if (!output_init.output_init(output)) {
                System.out.println("Error in call to output_init() from pointbgc.c... Exiting");
                return;
            }

            /* copy some of the info from input structure to bgc simulation control structure */
            bgcin.ctrl.dodaily = output.dodaily;
            bgcin.ctrl.domonavg = output.domonavg;
            bgcin.ctrl.doannavg = output.doannavg;
            bgcin.ctrl.doannual = output.doannual;

            /* copy the output file structures into bgcout */
            if (output.dodaily == 1) {
                bgcout.dayout = output.dayout;
            }
            if (output.domonavg == 1) {
                bgcout.monavgout = output.monavgout;
            }
            if (output.doannavg == 1) {
                bgcout.annavgout = output.annavgout;
            }
            if (output.doannual == 1) {
                bgcout.annout = output.annout;
            }
            if (output.bgc_ascii == 1 && output.dodaily == 1) {
                bgcout.dayoutascii = output.dayoutascii;
            }
            if (output.bgc_ascii == 1 && output.domonavg == 1) {
                bgcout.monoutascii = output.monoutascii;
            }
            if (output.bgc_ascii == 1 && output.doannual == 1) {
                bgcout.annoutascii = output.annoutascii;
            }
            if (output.bgc_ascii == 1 && output.doannual == 1) {
                bgcout.anntext = output.anntext;
            }

            /* initialize output files. Does nothing in spinup mode*/
            bgcin.ctrl.read_restart = 1;
            bgcin.restart_input = bgcout.restart_output;

            if (!bgc.bgc(bgcin, bgcout, MODE_MODEL)) {
                System.out.println("Error in call to bgc() in model mode with restart");
                return;
            }

            restart.read_restart = 0;
            bgcin.ctrl.read_restart = 0;

            System.out.println("Finished the bgc() Model call in spinngo");
        }


    }
} /* end of main */
