package pointbgc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import classes.Output;

public class Output_Init {

	public int output_init(Output output) {

		String sNewPath;
		
		FileWriter fw = null;

        Ini_REDO ini = new Ini_REDO();

		/* open outfiles if specified */
		if (output.dodaily == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
			sNewPath = String.join(output.outprefix, ".dayout");
			output.dayout = new File(sNewPath);

			if (ini.file_open(output.dayout, 'w')) {

				System.out.println("Opened binary daily output file in write mode");
			}

			else {

				System.out.println("Error opening daily outfile in output_ctrl()");
				return 0;
			}
		}

		if (output.domonavg == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
			sNewPath = String.join(output.outprefix, ".monavgout");
			output.monavgout.renameTo(new File(sNewPath));

			if (ini.file_open(output.monavgout, 'w')) {

			}

			else {

				System.out.println("Error opening monthly average outfile in output_ctrl()");
				return 0;
			}
		}

		if (output.doannavg == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
			sNewPath = String.join(output.outprefix, ".annavgout");
			output.annavgout.renameTo(new File(sNewPath));

			if (ini.file_open(output.annavgout, 'w')) {

			}

			else {

				System.out.println("Error opening annual average outfile in output_ctrl()");
				return 0;
			}
		}

		if (output.doannual == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
			sNewPath = String.join(output.outprefix, ".annavgout");
			output.annout.renameTo(new File(sNewPath));

			if (ini.file_open(output.annout, 'w')) {

			}

			else {

				System.out.println("Error opening annual outfile in output_ctrl()");
				return 0;
			}
		}

		/****************************************/
		/*					*/
		/* ASCII Outputs */
		/*					*/
		/****************************************/

		/* open daily ascii output files if specified */
		if (output.bgc_ascii == 1 && output.dodaily == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
			sNewPath = String.join(output.outprefix, ".dayout.ascii");
			output.dayoutascii.renameTo(new File(sNewPath));

			if (ini.file_open(output.dayoutascii, 'o')) {

			}

			else {

				System.out.println("Error opening annual outfile in output_ctrl()");
				return 0;
			}
		}

		if (output.bgc_ascii == 1 && output.domonavg == 1) {

			sNewPath = String.join(output.outprefix, ".monavgout.ascii");
			output.monoutascii.renameTo(new File(sNewPath));

			if (ini.file_open(output.monoutascii, 'o')) {

			}

			else {

				System.out.println("Error opening monthly ascii outfile in output_ctrl()");
			}
		}

		if (output.bgc_ascii == 1 && output.doannual == 1) {

			sNewPath = String.join(output.outprefix, ".annout.ascii");
			output.annoutascii.renameTo(new File(sNewPath));

			if (ini.file_open(output.annoutascii, 'o')) {

			}

			else {

				System.out.println("Error opening annual ascii outfile in output_ctrl()");
			}
		}
		
		
		/****************************************/
		/*					*/
		/* 	End ASCII Outputs		*/
		/*					*/
		/****************************************/
		if (output.bgc_ascii == 1 && output.doannual == 1){
			
			sNewPath = String.join(output.outprefix, "_ann.txt");
			output.anntext.renameTo(new File(sNewPath));
			
			if (ini.file_open(output.anntext, 'o')){
				
				ini.close_file();
				
				try {
					fw = new FileWriter(output.anntext);
					
					fw.write("Annual summary output from Biome-BGC version\n");
					fw.write("ann PRCP = annual total precipitation (mm/yr)\n");
					fw.write("ann Tavg = annual average air temperature (deg C)\n");
					fw.write("max LAI = annual maximum value of projected leaf area index (m2/m2)\n");
					fw.write("ann ET = annual total evapotranspiration (mm/yr)\n");
					fw.write("ann OF = annual total outflow (mm/yr)\n");
					fw.write("ann NPP = annual total net primary production (gC/m2/yr)\n");
					fw.write("ann NPB = annual total net biome production (gC/m2/yr)\n\n");
					fw.write(String.format("%6s%10s%10s%10s%10s%10s%10s%10s\n", "year","ann PRCP","ann Tavg",
							"max LAI","ann ET","ann OF","ann NPP","ann NBP"));
					
				} catch (IOException e) {
					e.printStackTrace();
					return 0;
				}
				
				
				
			}
		}
		
		return 0;
	}

}
