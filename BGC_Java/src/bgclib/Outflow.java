package bgclib;

import classes.Siteconst;
import classes.WState;
import classes.WFlux;

public class Outflow {
	
	public int outflow(final Siteconst sitec, final WState ws, WFlux wf){
		
		/* calculates the outflow flux from the difference between soilwater
		and maximum soilwater */
		
		/* water in excess of saturation to outflow */
		if (ws.soilw > sitec.soilw_sat)  
		{
			wf.soilw_outflow = ws.soilw - sitec.soilw_sat;
		}
		/* slow drainage from saturation to field capacity */
		else if (ws.soilw > sitec.soilw_fc)
		{
			wf.soilw_outflow = 0.5 * (ws.soilw - sitec.soilw_fc);
		}
		/* otherwise, no outflow */
		else
		{
			wf.soilw_outflow = 0.0;
		}
		
		return 0;
		
	}

}
