package pointbgc;

import java.io.File;

import classes.CO2Control;
import classes.Constant;

public class CO2_Init {
	
	
	
	
	int co2_init(File init, CO2Control co2, int simyears){
		
		
		int i;
		String key1 = "CO2_Control";
		String keyword;
		String junk;
		File temp;
		int reccount = 0;
		
		String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());
		
		Ini ini = new Ini();
		
		
		/********************************************************************
		**                                                                 **
		** Begin reading initialization file block starting with keyword:  **
		** CO2_CONTROL                                                     ** 
		**                                                                 **
		********************************************************************/

		/* scan for the climate change block keyword, exit if not next */
		
		try{
			
			keyword = (String) ini.scan_value(init, 's').get(0);
		}
		
		catch (IndexOutOfBoundsException ibe){
			System.out.println(ibe);
			System.out.printf(BV_ERROR, "Error reading keyword, co2_init()\n");
		}
		
		catch (ClassCastException cce){
			System.out.println(cce);
			System.out.printf(BV_ERROR, "Error reading keyword, co2_init()\n");
		
		}
		
		
		return 0;
	}

}
