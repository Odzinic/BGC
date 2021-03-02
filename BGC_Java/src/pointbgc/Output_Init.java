package pointbgc;

/*
output_init.c
Reads output control information from initialization file

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information

Revisions from version 4.1.2:
Seperated init scanning and outputfile opening.
This function now opens output files. Output controls
are now read from output_ctrl.c

Revisions from version 4.1.1:
Fixed error in ascii output file that incorrectly gave the
units for annual precipitation as cm/year - the real units are mm/yr.
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/

import java.io.*;

import classes.Output;

public class Output_Init {

    public boolean output_init(Output output) {

		String sNewPath;
        PrintWriter writer;

		/* open outfiles if specified */
		if (output.dodaily == 1) {

            sNewPath = output.outprefix + ".dayout";
            output.dayout = new File(sNewPath);

            try {
                writer = new PrintWriter(output.dayout, "UTF-8");
                System.out.println("Opened binary daily output file in write mode");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening daily outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening daily outfile in output_ctrl()");

                return false;
            }
		}

		if (output.domonavg == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
            sNewPath = output.outprefix + ".monavgout";
            output.monavgout = new File(sNewPath);

            try {
                writer = new PrintWriter(output.monavgout, "UTF-8");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening monthly average outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening monthly average outfile in output_ctrl()");

                return false;
            }
		}

		if (output.doannavg == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
            sNewPath = output.outprefix + ".annavgout";
            output.annavgout = new File(sNewPath);

            try {
                writer = new PrintWriter(output.annavgout, "UTF-8");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening annual average outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening annual average outfile in output_ctrl()");

                return false;
            }
		}

		if (output.doannual == 1) {

			// !!! CHECK IF THIS PATH WORKS !!! //
            sNewPath = output.outprefix + ".annavgout";
            output.annout = new File(sNewPath);

            try {
                writer = new PrintWriter(output.annout, "UTF-8");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening annual outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening annual outfile in output_ctrl()");

                return false;
            }
		}

		/****************************************/
		/*					*/
		/* ASCII Outputs */
		/*					*/
		/****************************************/

		/* open daily ascii output files if specified */
		if (output.bgc_ascii == 1 && output.dodaily == 1) {

            sNewPath = output.outprefix + ".dayout.ascii";
            output.dayoutascii = new File(sNewPath);

            try {
                writer = new PrintWriter(output.dayoutascii, "UTF-8");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening annual outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening annual outfile in output_ctrl()");

                return false;
            }
		}

		if (output.bgc_ascii == 1 && output.domonavg == 1) {

            sNewPath = output.outprefix + ".monavgout.ascii";
            output.monoutascii = new File(sNewPath);

            try {
                writer = new PrintWriter(output.monoutascii, "UTF-8");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening monthly ascii outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening monthly ascii outfile in output_ctrl()");

                return false;
            }
		}

		if (output.bgc_ascii == 1 && output.doannual == 1) {

            sNewPath = output.outprefix + ".annout.ascii";
            output.annoutascii = new File(sNewPath);

            try {
                writer = new PrintWriter(output.annoutascii, "UTF-8");
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening annual ascii outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening annual ascii outfile in output_ctrl()");

                return false;
            }
		}
		
		
		/****************************************/
		/*					*/
		/* 	End ASCII Outputs		*/
		/*					*/
		/****************************************/
		if (output.bgc_ascii == 1 && output.doannual == 1){

            sNewPath = output.outprefix + "_ann.txt";
            output.anntext = new File(sNewPath);


            try {
                writer = new PrintWriter(output.anntext, "UTF-8");
                writer.write("Annual summary output from Biome-BGC version\n");
                writer.write("ann PRCP = annual total precipitation (mm/yr)\n");
                writer.write("ann Tavg = annual average air temperature (deg C)\n");
                writer.write("max LAI = annual maximum value of projected leaf area index (m2/m2)\n");
                writer.write("ann ET = annual total evapotranspiration (mm/yr)\n");
                writer.write("ann OF = annual total outflow (mm/yr)\n");
                writer.write("ann NPP = annual total net primary production (gC/m2/yr)\n");
                writer.write("ann NPB = annual total net biome production (gC/m2/yr)\n\n");
                writer.write(String.format("%6s%10s%10s%10s%10s%10s%10s%10s\n", "year", "ann PRCP", "ann Tavg",
                        "max LAI", "ann ET", "ann OF", "ann NPP", "ann NBP"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error opening annual ascii outfile in output_ctrl()");

                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("Error opening annual ascii outfile in output_ctrl()");

                return false;
            }
		}

        return true;
    }

}
