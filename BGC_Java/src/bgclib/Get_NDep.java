package bgclib;

import classes.NDepControl;

public class Get_NDep {
	
	public double get_ndep(NDepControl ndepctrl, int simyr){
		
		int i;
		
		for (i=0;i<ndepctrl.ndepvals;i++){
			
			if (ndepctrl.ndepyear_array[i] == simyr){
				
				return (ndepctrl.ndep_array[i]);
			}
		}
		
		return (-999.9);
	}

}
