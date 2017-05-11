package pointbgc;

import java.io.File;

import classes.Constant;

public class End_Init {
	
	int end_init(File init){
		
		String key1 = "END_INIT";
		String keyword = null;
		
		String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());
		
		Ini ini = new Ini();
		
		
		/********************************************************************
		**                                                                 **
		** Begin reading initialization file block starting with keyword:  **
		** END_INIT                                                        ** 
		**                                                                 **
		********************************************************************/
		
		try{
			keyword = (String) ini.scan_value(init, 's').get(0);
		}
		
		catch (IndexOutOfBoundsException ibe) {
			System.out.printf(BV_ERROR, "Error reading keyword for end of initialization file\n");
			System.out.printf(BV_ERROR, "Expecting keyword --> %s in file %s\n",key1,init.getName());
			System.out.printf(BV_ERROR, "This indicates that you have the wrong number of lines\n");
			System.out.printf(BV_ERROR, "of information in your initialization file.\n");
			System.out.printf(BV_ERROR, "Refer to documentation to determine proper format.\n");
		}
		
		
		if (keyword.equals(key1)){
			
			return 1;
		}
		
		
	return 0;	
		
	}

}
