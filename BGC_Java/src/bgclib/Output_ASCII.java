package bgclib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Output_ASCII {
	
	/* ASCII output function for Biome-BGC 		*/

	/**
	Biome-BGC version 4.2 (final release)
	See copyright.txt for Copyright information
	**/


    public int output_ascii(List<Double> arr, int nvars, File ptr) {
		int i = 0;
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(ptr, "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

        for (i = 0; i < nvars; i++) {
            writer.printf("%10.8f\t", arr.get(i));
        }
        writer.printf("\n");
		
		return 0;

	}

}
