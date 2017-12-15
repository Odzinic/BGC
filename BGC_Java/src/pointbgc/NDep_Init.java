//Compatible
package pointbgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import classes.NDepControl;

public class NDep_Init {

    public boolean ndep_init(File ndepfile, NDepControl ndepctrl) {

        int i = 0;
        int reccount = 0;
        String[] sCurrline;
        Scanner sc = null;


        try {
            sc = new Scanner(ndepfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

		/*
         * if using variable CO2 file, open it, otherwise discard the next line
		 * of the ini file
		 */


        for (i = 0; sc.hasNextLine(); i++) {

			/* Find the number of lines in the file */
            reccount++;

            sCurrline = sc.nextLine().split("\\s+");

            ndepctrl.ndepyear_array.add(i, Integer.valueOf(sCurrline[0]));
            ndepctrl.ndep_array.add(i, Double.valueOf(sCurrline[1]));

            System.out.printf("NDEP value read: %1$d, %2$f", ndepctrl.ndepyear_array.get(i), ndepctrl.ndep_array.get(i));

        }

        sc.close();
        return true;
    }

}
