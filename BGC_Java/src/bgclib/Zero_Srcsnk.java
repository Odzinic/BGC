package bgclib;

import classes.CState;
import classes.NState;
import classes.WState;
import classes.Summary;

public class Zero_Srcsnk {

    public boolean zero_srcsnk(CState cs, NState ns, WState ws, Summary summary) {


		/* zero the water sources and sinks */
		ws.prcp_src = 0.0;
		ws.outflow_snk = 0.0;
		ws.soilevap_snk = 0.0;
		ws.snowsubl_snk = 0.0;
		ws.canopyevap_snk = 0.0;
		ws.trans_snk = 0.0;

		/* zero the carbon sources and sinks */
		cs.psnsun_src = 0.0;
		cs.psnshade_src = 0.0;
		cs.leaf_mr_snk = 0.0;
		cs.leaf_gr_snk = 0.0;
		cs.froot_mr_snk = 0.0;
		cs.froot_gr_snk = 0.0;
		cs.livestem_mr_snk = 0.0;
		cs.livestem_gr_snk = 0.0;
		cs.deadstem_gr_snk = 0.0;
		cs.livecroot_mr_snk = 0.0;
		cs.livecroot_gr_snk = 0.0;
		cs.deadcroot_gr_snk = 0.0;
		cs.litr1_hr_snk = 0.0;
		cs.litr2_hr_snk = 0.0;
		cs.litr4_hr_snk = 0.0;
		cs.soil1_hr_snk = 0.0;
		cs.soil2_hr_snk = 0.0;
		cs.soil3_hr_snk = 0.0;
		cs.soil4_hr_snk = 0.0;
		cs.fire_snk = 0.0;

		/* zero the nitrogen sources and sinks */
		ns.nfix_src = 0.0;
		ns.ndep_src = 0.0;
		ns.nleached_snk = 0.0;
		ns.nvol_snk = 0.0;
		ns.fire_snk = 0.0;

		/* zero the summary variables */
		summary.cum_npp = 0.0;
		summary.cum_nep = 0.0;
		summary.cum_nee = 0.0;
		summary.cum_gpp = 0.0;
		summary.cum_mr = 0.0;
		summary.cum_gr = 0.0;
		summary.cum_hr = 0.0;
		summary.cum_fire = 0.0;

        return true;
	}

}
