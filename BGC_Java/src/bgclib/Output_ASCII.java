package bgclib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Output_ASCII {
	
	/* ASCII output function for Biome-BGC 		*/

	/**
	Biome-BGC version 4.2 (final release)
	See copyright.txt for Copyright information
	**/


	public int output_ascii(double[] arr,int nvars,  File ptr)
	{
		int i = 0;
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(ptr, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(i = 0;i < nvars;i++){ writer.printf("%10.8f\t",arr[i]);}
		writer.printf("\n");
		
		return 0;

	}

}
