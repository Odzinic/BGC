package bgclib;

import classes.WState;
import classes.CState;
import classes.Constant;
import classes.NState;

public class Check_Balance {

    //TODO: Check if this is a good fix for balance
    double old_waterbalance = 0.0;
    double old_carbonbalance = 0.0;
    double old_nitrogenbalance = 0.0;



    boolean check_water_balance(WState ws, int first_balance) {
		double in, out, store, balance;

		/* DAILY CHECK ON WATER BALANCE */

		/* sum of sources */
		in = ws.prcp_src;

		/* sum of sinks */
		out = ws.outflow_snk + ws.soilevap_snk + ws.snowsubl_snk + ws.canopyevap_snk + ws.trans_snk;

		/* sum of current storage */
		store = ws.soilw + ws.snoww + ws.canopyw;

//		System.out.printf("Numbers are %f, %f, %f", in, out, store);

		/* calculate current balance */
		balance = in - out - store;


		if (first_balance == 0) {
            if (Math.abs(old_waterbalance - balance) > 1e-4) {
                System.out.printf("FATAL ERRROR: Water balance error:\n");
                System.out.printf("Balance from previous day = %f\n", old_waterbalance);
                System.out.printf("Balance from current day  = %f\n", balance);
                System.out.printf("Difference (previous - current) = %f\n", old_waterbalance - balance);
                System.out.printf("Components of current balance:\n");
                System.out.printf("Sources (summed over entire run)  = %f\n", in);
                System.out.printf("Sinks   (summed over entire run)  = %f\n", out);
                System.out.printf("Storage (current state variables) = %f\n", store);
                System.out.printf("Exiting...\n");
                return false;
			}
		}
        //TODO: Old_balance may not be checking correctly
        old_waterbalance = balance;

        return true;
    }

    boolean check_carbon_balance(CState cs, int first_balance) {
		double in, out, store, balance;

		/* DAILY CHECK ON CARBON BALANCE */

		/* sum of sources */
		in = cs.psnsun_src + cs.psnshade_src;

		/* sum of sinks */
        out = cs.leaf_mr_snk + cs.leaf_gr_snk + cs.froot_mr_snk +
                cs.froot_gr_snk + cs.livestem_mr_snk + cs.livestem_gr_snk +
                cs.deadstem_gr_snk + cs.livecroot_mr_snk + cs.livecroot_gr_snk +
                cs.deadcroot_gr_snk + cs.litr1_hr_snk + cs.litr2_hr_snk +
                cs.litr4_hr_snk + cs.soil1_hr_snk + cs.soil2_hr_snk +
                cs.soil3_hr_snk + cs.soil4_hr_snk + cs.fire_snk;

        /* sum of current storage */
        store = cs.leafc + cs.leafc_storage + cs.leafc_transfer +
                cs.frootc + cs.frootc_storage + cs.frootc_transfer +
                cs.livestemc + cs.livestemc_storage + cs.livestemc_transfer +
                cs.deadstemc + cs.deadstemc_storage + cs.deadstemc_transfer +
                cs.livecrootc + cs.livecrootc_storage + cs.livecrootc_transfer +
                cs.deadcrootc + cs.deadcrootc_storage + cs.deadcrootc_transfer +
                cs.gresp_storage + cs.gresp_transfer + cs.cwdc + cs.litr1c +
                cs.litr2c + cs.litr3c + cs.litr4c + cs.soil1c + cs.soil2c +
                cs.soil3c + cs.soil4c + cs.cpool;

//        System.out.printf("Numbers are %f, %f, %f", in, out, store);

		/* calculate current balance */
		balance = in - out - store;

        System.out.printf("The old balance is: %.8f and then new balance is %.8f\n", balance, old_carbonbalance);

		if (first_balance == 0) {
            if (Math.abs(old_carbonbalance - balance) > 1e-8) {
                System.out.printf("FATAL ERRROR: carbon balance error:\n");
                System.out.printf("Balance from previous day = %f\n", old_carbonbalance);
                System.out.printf("Balance from current day  = %f\n", balance);
                System.out.printf("Difference (previous - current) = %f\n", old_carbonbalance - balance);
                System.out.printf("Components of current balance:\n");
                System.out.printf("Sources (summed over entire run)  = %f\n", in);
                System.out.printf("Sinks   (summed over entire run)  = %f\n", out);
                System.out.printf("Storage (current state variables) = %f\n", store);
                System.out.printf("Exiting...\n");
                return false;
			}
		}
        old_carbonbalance = balance;


        return true;
    }

    boolean check_nitrogen_balance(NState ns, int first_balance) {
		double in, out, store, balance;


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

//        System.out.printf("Numbers are %f, %f, %f", in, out, store);

		/* calculate current balance */
		balance = in - out - store;

		if (first_balance == 0) {
            if (Math.abs(old_nitrogenbalance - balance) > 1e-8) {
                System.out.printf("FATAL ERRROR: nitrogen balance error:\n");
                System.out.printf("Balance from previous day = %f\n", old_nitrogenbalance);
                System.out.printf("Balance from current day  = %f\n", balance);
                System.out.printf("Difference (previous - current) = %f\n", old_nitrogenbalance - balance);
                System.out.printf("Components of current balance:\n");
                System.out.printf("Sources (summed over entire run)  = %f\n", in);
                System.out.printf("Sinks   (summed over entire run)  = %f\n", out);
                System.out.printf("Storage (current state variables) = %f\n", store);
                System.out.printf("Exiting...\n");
                return false;
			}
		}
        old_nitrogenbalance = balance;

        return true;
	}

}
