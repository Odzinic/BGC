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

		String cli_mode = null; // NEED TO CREATE PUBLIC STATIC CLI_MODE IN
								// POINTBGC

		Ini ini = new Ini();

		String MODE_SPINUP = String.valueOf(Constant.MODE_SPINUP.getValue());
		String MODE_MODEL = String.valueOf(Constant.MODE_MODEL.getValue());
		String MODE_SPINNGO = String.valueOf(Constant.MODE_SPINNGO.getValue());

		/********************************************************************
		 ** ** Begin reading initialization file block starting with keyword: **
		 ** OUTPUT_CONTROL ** **
		 ********************************************************************/

		if (ini.scan_open(init, key1, 'r')) {

			/* get the output filename prefix */
			output.outprefix = (String) ini.scan_value(init, 's').get(0);

			/* scan flags for daily output */
			output.dodaily = (int) ini.scan_value(init, 'i').get(0);

			if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

				output.dodaily = 0;
			}

			else if (cli_mode.equals(MODE_MODEL)) {

				output.dodaily = 1;
			}

			/*
			 * scan flag for monthly average output (operates on daily
			 * variables)
			 */
			output.domonavg = (int) ini.scan_value(init, 'i').get(0);

			if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

				output.domonavg = 0;
			}

			else if (cli_mode.equals(MODE_MODEL)) {

				output.domonavg = 1;
			}

			/*
			 * scan flag for annual average output (operates on daily variables)
			 */
			output.doannavg = (int) ini.scan_value(init, 'i').get(0);

			if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

				output.doannavg = 0;
			}

			else if (cli_mode.equals(MODE_MODEL)) {

				output.doannavg = 1;
			}

			/* scan flag for annual output */
			output.doannual = (int) ini.scan_value(init, 'i').get(0);

			if (cli_mode.equals(MODE_SPINUP) || cli_mode.equals(MODE_SPINNGO)) {

				output.doannual = 0;
			}

			else if (cli_mode.equals(MODE_MODEL)) {

				output.doannual = 1;
			}

			output.onscreen = (int) ini.scan_value(init, 'i').get(0);

		}

		else if (!(ini.scan_open(init, key1, 'r'))) {

			System.out.println("Error reading keyword for output file data");
		}

		/********************************************************************
		 ** ** Begin reading initialization file block starting with keyword: **
		 ** DAILY_OUTPUT ** **
		 ********************************************************************/

		if (ini.scan_open(init, key2, 'r')) {

			/* read the number of daily output variables */
			output.ndayout = (int) ini.scan_value(init, 'i').get(0);

			/* begin loop to read in the daily output variable indices */
			for (i = 0; i < output.ndayout; i++) {

				output.daycodes[i] = (int) ini.scan_value(init, 'i').get(0);
			}

		}

		else if (!(ini.scan_open(init, key2, 'r'))) {

			System.out.println("Error reading keyword for output file data");
		}

		/********************************************************************
		 ** ** Begin reading initialization file block starting with keyword: **
		 ** ANNUAL_OUTPUT ** **
		 ********************************************************************/

		if (ini.scan_open(init, key3, 'r')) {

			/* read the number of annual output variables */
			output.nannout = (int) ini.scan_value(init, 'i').get(0);

			if (output.nannout == 0 && output.ndayout == 0 && (cli_mode == MODE_MODEL || cli_mode == MODE_SPINNGO)) {
				
				System.out.println("ERROR! You are trying to run the model with no output variables. Please add some output variables to your ini file.");
				return 0;
			}
			
			else{
				
				for (i = 0; i<output.nannout; i++){
					
					output.anncodes[i] = (int) ini.scan_value(init, 'i').get(0);
				}
			}
		}
		
		return 0;

	}

}
