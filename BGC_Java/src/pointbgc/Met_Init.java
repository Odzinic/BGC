package pointbgc;

import java.io.File;

import classes.Point;

public class Met_Init {
	
	public int met_init(File init, Point point){
		
		int nhead, i;
		String key1 = "MET_INPUT";
		String keyword;
		String junk_head;
		String sPath;
		
		Ini ini = new Ini();
		
		
		/********************************************************************
		**                                                                 **
		** Begin reading initialization file block starting with keyword:  **
		** MET_INPUT                                                       ** 
		**                                                                 **
		********************************************************************/
		
		/* scan for the input metfile keyword, exit if not next */
		if (!ini.scan_open(init, key1, 'r')){
			
			return 0;
		}
		/* get the met data filename and open file for ascii read */
		sPath = (String) ini.scan_value(init, 's').get(0);
		point.metf = new File(sPath);
		
		/* get number of metfile header lines */
		nhead = (int) ini.scan_value(init, 'i').get(0);
		
		
		/* Should be used in MetArr to skip headers */
		return nhead;
		
	}

}
