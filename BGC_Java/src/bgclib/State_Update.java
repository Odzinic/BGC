package bgclib;

import classes.WFlux;
import classes.WState;
import classes.Constant;

public class State_Update {

	public int daily_water_state_update(WFlux wf, WState ws) {

		/* daily update of the water state variables */

		int ok = 1;

		String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

		/* precipitation fluxes */
		ws.canopyw += wf.prcp_to_canopyw;
		ws.prcp_src += wf.prcp_to_canopyw;
		ws.soilw += wf.prcp_to_soilw;
		ws.prcp_src += wf.prcp_to_soilw;
		ws.snoww += wf.prcp_to_snoww;
		ws.prcp_src += wf.prcp_to_snoww;

		/* snowmelt fluxes */
		ws.soilw += wf.snoww_to_soilw;
		ws.snoww -= wf.snoww_to_soilw;
		ws.snowsubl_snk += wf.snoww_subl;
		ws.snoww -= wf.snoww_subl;

		/* bare soil evaporation */
		ws.soilevap_snk += wf.soilw_evap;
		ws.soilw -= wf.soilw_evap;

		/* canopy intercepted water fluxes */
		ws.canopyevap_snk += wf.canopyw_evap;
		ws.canopyw -= wf.canopyw_evap;
		ws.soilw += wf.canopyw_to_soilw;
		ws.canopyw -= wf.canopyw_to_soilw;

		/* transpiration */
		ws.trans_snk += wf.soilw_trans;
		ws.soilw -= wf.soilw_trans;

		/* outflow */
		ws.outflow_snk += wf.soilw_outflow;
		ws.soilw -= wf.soilw_outflow;

		/*
		 * the following special case prevents evaporation under very dry
		 * conditions from causing a negative soilwater content
		 */
		if (ws.soilw < 0.0) /* negative soilwater */
		{
			/*
			 * add back the evaporation and transpiration fluxes, and set these
			 * fluxes to 0.0
			 */
			ws.soilw += wf.soilw_evap;
			ws.soilevap_snk -= wf.soilw_evap;
			ws.soilw += wf.soilw_trans;
			ws.trans_snk -= wf.soilw_trans;
			wf.soilw_evap = 0.0;
			wf.soilw_trans = 0.0;

			/* test again for negative soilwater...should never be true */
			if (ws.soilw < 0.0) {
				System.out.printf(BV_ERROR, "Fatal negative soilwater error\n");
				System.out.printf(BV_ERROR, "soilwater = %e\n", ws.soilw);
				System.out.printf(BV_ERROR, "most likely a problem with reading the met data input file...\n");
				ok = 0;
			}
		}

		return 0;
	}

}
