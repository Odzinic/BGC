//Compatible
package pointbgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import classes.CO2Control;
import classes.Constant;

public class CO2_Init {

    public boolean co2_init(File init, CO2Control co2, int simyears) {

        int i;
        String key1 = "CO2_CONTROL";
        String[] sParseLine;
        int reccount = 0;

        File fCO2var;
        Scanner sc = null;

        String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());
        String BV_DIAG = String.valueOf(Constant.BV_DIAG.getValue());

        Ini_REDO ini = new Ini_REDO(init, key1);

        try {
            sc = new Scanner(init);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /********************************************************************
         ** ** Begin reading initialization file block starting with keyword: **
         ** CO2_CONTROL ** **
         ********************************************************************/

		/* scan for the climate change block keyword, exit if not next */


		/* begin reading co2 control information */

        try {

            co2.varco2 = ini.scan_value(0, 'i').intVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println(ibe);
            System.out.println("Error reading keyword, co2_init()");

            return false;

        } catch (ClassCastException cce) {
            System.out.println(cce);
            System.out.println("Error reading keyword, co2_init()");

            return false;

        }

        try {

            co2.co2ppm = ini.scan_value(1, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println(ibe);
            System.out.println("Error reading keyword, co2_init()");

            return false;

        } catch (ClassCastException cce) {
            System.out.println(cce);
            System.out.println("Error reading keyword, co2_init()");

            return false;

        }

		/*
         * if using variable CO2 file, open it, otherwise discard the next line
		 * of the ini file
		 */

        if (co2.varco2 == 1) {

            fCO2var = new File(ini.scan_value(2, 's').strVal);

            try (Scanner scanner = sc = new Scanner(fCO2var)) {
            } catch (FileNotFoundException fnf) {
                System.out.println(fnf);
                System.out.println("Error opening CO2 variable file, co2_init()");

                return false;
            }

            while (sc.hasNextLine()) {

                reccount++;
            }
            sc.reset();

        } else if (!(co2.varco2 == 1)) {
            System.out.println(("CO2 variable file was not selected. Continuing."));

        }

		/*
		 * Store the total number of CO2 records found in the co2vals variable
		 */
        co2.co2vals = reccount;


        for (i = 0; i < reccount; i++) {

            sParseLine = sc.next().split(" ");

            if (sParseLine.length != 2) {

                System.out.println("Error reading annual CO2 array, ctrl_init()");
                System.out.println("Note: file must contain a pair of values for each");
                System.out.println("simyear: year and CO2.");

                return false;

            } else {
                co2.co2year_array.set(i, Integer.getInteger(sParseLine[0]));
                co2.co2ppm_array.set(i, Double.valueOf(sParseLine[1]));
            }

        }
        System.out.printf(String.format("Found: %d CO2 records in co2_init()", reccount));

        if (co2.co2ppm < 0.0) {
            System.out.println("Error in co2_init(): co2 (ppm) must be positive");
            return false;
        }

        return true;

    }

}
