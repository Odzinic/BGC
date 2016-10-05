package bgclib;

import classes.NState;
import classes.NFlux;
import classes.WState;
import classes.WFlux;
import classes.Constant;

public class NLeaching {

	public int nleaching(NState ns, NFlux nf, WState ws, WFlux wf) {

		double soilwater_nconc;
		double MOBILEN_PROPORTION = Constant.MOBILEN_PROPORTION.getValue();

		/*
		 * N leaching flux is calculated after all the other nfluxes are
		 * reconciled to avoid the possibility of removing more N than is there.
		 * This follows the implicit logic of precedence for soil mineral N
		 * resources: 1) microbial processes and plant uptake (competing) 2)
		 * leaching
		 * 
		 * leaching happens when there is outflow, as a function of the presumed
		 * proportion of the soil mineral N pool which is soluble (nitrates),
		 * the soil water content, and the outflow
		 */
		if (wf.soilw_outflow == 1) {
			soilwater_nconc = MOBILEN_PROPORTION * ns.sminn / ws.soilw;
			nf.sminn_leached = soilwater_nconc * wf.soilw_outflow;
			/* update state variables */
			ns.nleached_snk += nf.sminn_leached;
			ns.sminn -= nf.sminn_leached;

		}

		return 0;
	}
}
