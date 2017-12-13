//Compatible
package pointbgc;

import java.io.File;

import classes.Constant;
import classes.Output;

public class Output_Ctrl {

    public int output_ctrl(File init, Output output) {

        int i = 0;
        String key1 = "OUTPUT_CONTROL";
        String key2 = "DAILY_OUTPUT";
        String key3 = "ANNUAL_OUTPUT";

        String cli_mode = null; // TODO: NEED TO CREATE PUBLIC STATIC CLI_MODE IN POINTBGC

        Ini_REDO outputIni = new Ini_REDO(init, key1);    // Ini class for reading in OUTPUT_CONTROL values
        Ini_REDO dailyIni = new Ini_REDO(init, key2);    // Ini class for reading in DAILY_OUTPUT values
        Ini_REDO annualIni = new Ini_REDO(init, key3);    // Ini class for reading in ANNUAL_OUTPUT values

        String MODE_SPINUP = String.valueOf(Constant.MODE_SPINUP.getValue());
        String MODE_MODEL = String.valueOf(Constant.MODE_MODEL.getValue());
        String MODE_SPINNGO = String.valueOf(Constant.MODE_SPINNGO.getValue());

        /********************************************************************
         ** ** Begin reading initialization file block starting with keyword: **
         ** OUTPUT_CONTROL ** **
         ********************************************************************/


		/* get the output filename prefix */
        output.outprefix = outputIni.scan_value(0, 's').strVal;

		/* scan flags for daily output */
        output.dodaily = outputIni.scan_value(1, 'i').intVal;

        if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

            output.dodaily = 0;
        } else if (cli_mode.equals(MODE_MODEL)) {

            output.dodaily = 1;
        }

		/*
         * scan flag for monthly average output (operates on daily
		 * variables)
		 */
        output.domonavg = outputIni.scan_value(2, 'i').intVal;

        if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

            output.domonavg = 0;
        } else if (cli_mode.equals(MODE_MODEL)) {

            output.domonavg = 1;
        }

		/*
         * scan flag for annual average output (operates on daily variables)
		 */
        output.doannavg = outputIni.scan_value(3, 'i').intVal;

        if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

            output.doannavg = 0;
        } else if (cli_mode.equals(MODE_MODEL)) {

            output.doannavg = 1;
        }

		/* scan flag for annual output */
        output.doannual = outputIni.scan_value(4, 'i').intVal;

        if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

            output.doannual = 0;
        } else if (cli_mode.equals(MODE_MODEL)) {

            output.doannual = 1;
        }

        output.onscreen = outputIni.scan_value(5, 'i').intVal;


        /********************************************************************
         ** ** Begin reading initialization file block starting with keyword: **
         ** DAILY_OUTPUT ** **
         ********************************************************************/



		/* read the number of daily output variables */
        output.ndayout = dailyIni.scan_value(0, 'i').intVal;

		/* begin loop to read in the daily output variable indices */
        for (i = 0; i < output.ndayout; i++) {

            output.daycodes.add(i, dailyIni.scan_value(1, 'i').intVal);
        }


        /********************************************************************
         ** ** Begin reading initialization file block starting with keyword: **
         ** ANNUAL_OUTPUT ** **
         ********************************************************************/



		/* read the number of annual output variables */
        output.nannout = annualIni.scan_value(0, 'i').intVal;

        if (output.nannout == 0 && output.ndayout == 0 && (cli_mode == MODE_MODEL || cli_mode == MODE_SPINNGO)) {

            System.out.println("ERROR! You are trying to run the model with no output variables. Please add some output variables to your ini file.");
            return 0;
        } else {

            for (i = 0; i < output.nannout; i++) {

                output.anncodes.add(i, annualIni.scan_value(1, 'i').intVal);
            }
        }


        return 0;

    }

}
