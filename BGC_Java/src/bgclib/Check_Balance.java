package bgclib;

import classes.WState;
import classes.CState;
import classes.Constant;
import classes.NState;

public class Check_Balance {

	String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

	int check_water_balance(WState ws, int first_balance) {
		int ok = 1;
		double old_balance = 0;
		double in, out, store, balance;

		/* DAILY CHECK ON WATER BALANCE */

		/* sum of sources */
		in = ws.prcp_src;

		/* sum of sinks */
		out = ws.outflow_snk + ws.soilevap_snk + ws.snowsubl_snk + ws.canopyevap_snk + ws.trans_snk;

		/* sum of current storage */
		store = ws.soilw + ws.snoww + ws.canopyw;

		/* calculate current balance */
		balance = in - out - store;

		if (first_balance == 0) {
			if (Math.abs(old_balance - balance) > 1e-4) {
				System.out.printf(BV_ERROR, "FATAL ERRROR: Water balance error:\n");
				System.out.printf(BV_ERROR, "Balance from previous day = %lf\n", old_balance);
				System.out.printf(BV_ERROR, "Balance from current day  = %lf\n", balance);
				System.out.printf(BV_ERROR, "Difference (previous - current) = %lf\n", old_balance - balance);
				System.out.printf(BV_ERROR, "Components of current balance:\n");
				System.out.printf(BV_ERROR, "Sources (summed over entire run)  = %lf\n", in);
				System.out.printf(BV_ERROR, "Sinks   (summed over entire run)  = %lf\n", out);
				System.out.printf(BV_ERROR, "Storage (current state variables) = %lf\n", store);
				System.out.printf(BV_ERROR, "Exiting...\n");
				ok = 0;
			}
		}
		old_balance = balance;

		return 0;
	}

	int check_carbon_balance(CState cs, int first_balance) {
		int ok = 1;
		double old_balance = 0;
		double in, out, store, balance;

		/* DAILY CHECK ON CARBON BALANCE */

		/* sum of sources */
		in = cs.psnsun_src + cs.psnshade_src;

		/* sum of sinks */
		out = cs.leaf_mr_snk + cs.leaf_gr_snk + cs.froot_mr_snk + cs.froot_gr_snk + cs.livestem_mr_snk
				+ cs.livestem_gr_snk + cs.deadstem_gr_snk + cs.livecroot_mr_snk + cs.livecroot_gr_snk
				+ cs.deadcroot_gr_snk + cs.litr1_hr_snk + cs.litr2_hr_snk + cs.litr4_hr_snk + cs.soil1_hr_snk
				+ cs.soil2_hr_snk + cs.soil3_hr_snk + cs.soil4_hr_snk + cs.fire_snk;

		/* sum of current storage */
		store = cs.leafc + cs.leafc_storage + cs.leafc_transfer + cs.frootc + cs.frootc_storage + cs.frootc_transfer
				+ cs.livestemc + cs.livestemc_storage + cs.livestemc_transfer + cs.deadstemc + cs.deadstemc_storage
				+ cs.deadstemc_transfer + cs.livecrootc + cs.livecrootc_storage + cs.livecrootc_transfer + cs.deadcrootc
				+ cs.deadcrootc_storage + cs.deadcrootc_transfer + cs.gresp_storage + cs.gresp_transfer + cs.cwdc
				+ cs.litr1c + cs.litr2c + cs.litr3c + cs.litr4c + cs.soil1c + cs.soil2c + cs.soil3c + cs.soil4c
				+ cs.cpool;

		/* calculate current balance */
		balance = in - out - store;

		if (first_balance == 0) {
			if (Math.abs(old_balance - balance) > 1e-8) {
				System.out.printf(BV_ERROR, "FATAL ERRROR: carbon balance error:\n");
				System.out.printf(BV_ERROR, "Balance from previous day = %lf\n", old_balance);
				System.out.printf(BV_ERROR, "Balance from current day  = %lf\n", balance);
				System.out.printf(BV_ERROR, "Difference (previous - current) = %lf\n", old_balance - balance);
				System.out.printf(BV_ERROR, "Components of current balance:\n");
				System.out.printf(BV_ERROR, "Sources (summed over entire run)  = %lf\n", in);
				System.out.printf(BV_ERROR, "Sinks   (summed over entire run)  = %lf\n", out);
				System.out.printf(BV_ERROR, "Storage (current state variables) = %lf\n", store);
				System.out.printf(BV_ERROR, "Exiting...\n");
				ok = 0;
			}
		}
		old_balance = balance;

		return 0;
	}

	int check_nitrogen_balance(NState ns, int first_balance) {
		int ok = 1;
		double in, out, store, balance;
		double old_balance = 0.0;

		/* DAILY CHECK ON NITROGEN BALANCE */

		/* sum of sources */
		in = ns.nfix_src + ns.ndep_src;

		/* sum of sinks */
		out = ns.nleached_snk + ns.nvol_snk + ns.fire_snk;

		/* sum of current storage */
		store = ns.leafn + ns.leafn_storage + ns.leafn_transfer + ns.frootn + ns.frootn_storage + ns.frootn_transfer
				+ ns.livestemn + ns.livestemn_storage + ns.livestemn_transfer + ns.deadstemn + ns.deadstemn_storage
				+ ns.deadstemn_transfer + ns.livecrootn + ns.livecrootn_storage + ns.livecrootn_transfer + ns.deadcrootn
				+ ns.deadcrootn_storage + ns.deadcrootn_transfer + ns.cwdn + ns.litr1n + ns.litr2n + ns.litr3n
				+ ns.litr4n + ns.soil1n + ns.soil2n + ns.soil3n + ns.soil4n + ns.sminn + ns.npool + ns.retransn;

		/* calculate current balance */
		balance = in - out - store;

		if (first_balance == 0) {
			if (Math.abs(old_balance - balance) > 1e-8) {
				System.out.printf(BV_ERROR, "FATAL ERRROR: nitrogen balance error:\n");
				System.out.printf(BV_ERROR, "Balance from previous day = %lf\n", old_balance);
				System.out.printf(BV_ERROR, "Balance from current day  = %lf\n", balance);
				System.out.printf(BV_ERROR, "Difference (previous - current) = %lf\n", old_balance - balance);
				System.out.printf(BV_ERROR, "Components of current balance:\n");
				System.out.printf(BV_ERROR, "Sources (summed over entire run)  = %lf\n", in);
				System.out.printf(BV_ERROR, "Sinks   (summed over entire run)  = %lf\n", out);
				System.out.printf(BV_ERROR, "Storage (current state variables) = %lf\n", store);
				System.out.printf(BV_ERROR, "Exiting...\n");
				ok = 0;
			}
		}
		old_balance = balance;

		return 0;
	}

}
