package pointbgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import classes.NDepControl;

public class NDep_Init {

	public int ndep_init(File ndepfile, NDepControl ndepctrl) {

		int i = 0;
		int reccount = 0;
		String[] sCurrline;
		Scanner sc = null;

		Ini ini = new Ini();

		try {
			sc = new Scanner(ndepfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		}

		/*
		 * if using variable CO2 file, open it, otherwise discard the next line
		 * of the ini file
		 */
		if (ini.file_open(ndepfile, 'r')) {

			for (i = 0; sc.hasNextLine(); i++) {

				/* Find the number of lines in the file */
				reccount++;

				sCurrline = sc.nextLine().split(" ");

				ndepctrl.ndepyear_array[i] = Integer.valueOf(sCurrline[0]);
				ndepctrl.ndep_array[i] = Double.valueOf(sCurrline[1]);

				System.out.printf("NDEP value read: %1$d, %2$f", ndepctrl.ndepyear_array[i], ndepctrl.ndep_array[i]);

			}

		}

		else {

			sc.close();
			return 0;
		}

		sc.close();
		return 0;
	}

}
