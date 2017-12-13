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

			// !!! CHECK IF THIS PATH WORKS !!! //
            sNewPath = output.outprefix + ".dayout";
            output.dayout = new File(sNewPath);

            try {
                writer = new PrintWriter(output.dayout.toString(), "UTF-8");
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
                writer = new PrintWriter(output.monavgout.toString(), "UTF-8");
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
                writer = new PrintWriter(output.annavgout.toString(), "UTF-8");
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
                writer = new PrintWriter(output.annout.toString(), "UTF-8");
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

			// !!! CHECK IF THIS PATH WORKS !!! //
            sNewPath = output.outprefix + ".dayout.ascii";
            output.dayoutascii = new File(sNewPath);

            try {
                writer = new PrintWriter(output.dayoutascii.toString(), "UTF-8");
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
                writer = new PrintWriter(output.monoutascii.toString(), "UTF-8");
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
                writer = new PrintWriter(output.annoutascii.toString(), "UTF-8");
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
                writer = new PrintWriter(output.outprefix.toString(), "UTF-8");
                writer.println("Annual summary output from Biome-BGC version");
                writer.println("ann PRCP = annual total precipitation (mm/yr)");
                writer.println("ann Tavg = annual average air temperature (deg C)");
                writer.println("max LAI = annual maximum value of projected leaf area index (m2/m2)");
                writer.println("ann ET = annual total evapotranspiration (mm/yr)");
                writer.println("ann OF = annual total outflow (mm/yr)");
                writer.println("ann NPP = annual total net primary production (gC/m2/yr)");
                writer.println("ann NPB = annual total net biome production (gC/m2/yr)");
                writer.println(String.format("%6s%10s%10s%10s%10s%10s%10s%10s", "year", "ann PRCP", "ann Tavg",
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
