package pointbgc;

import java.io.File;

import classes.Constant;
import classes.Epconst;

public class Epc_Init {
	
	public int epc_init(File init, Epconst epc){
		
		double t1, t2, t3, t4, r1;
		File temp;
		String key1 = "EPC_FILE";
		String key2 = "ECOPHYS";
		String keyword = null;
		
		String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());
		double FLT_COND_TOL = Constant.FLT_COND_TOL.getValue();
		
		Ini ini = new Ini();
		
		/********************************************************************
		**                                                                 **
		** Begin reading initialization file block starting with keyword:  **
		** EPC_FILES                                                       ** 
		**                                                                 **
		********************************************************************/
		
		/* scan for the EPC file keyword, exit if not next */
		if (!ini.scan_open(init, key1, 'r')){
			return 0;
		}
		
		/* begin reading constants from *.init */
		epc.woody = (int) ini.scan_value(init, 'i').get(0);
		epc.evergreen = (int) ini.scan_value(init, 'i').get(0);
		epc.c3_flag = (int) ini.scan_value(init, 'i').get(0);
		epc.phenology_flag = (int) ini.scan_value(init, 'i').get(0);
		epc.onday = (int) ini.scan_value(init, 'i').get(0);
		epc.offday = (int) ini.scan_value(init, 'i').get(0);
		epc.transfer_pdays = (int) ini.scan_value(init, 'i').get(0);
		epc.litfall_pdays = (double) ini.scan_value(init, 'd').get(0);
		epc.leaf_turnover = (double) ini.scan_value(init, 'd').get(0);
		
		if (epc.evergreen == 0){
			
			epc.leaf_turnover = 1.0;
		}
		
		epc.froot_turnover = epc.leaf_turnover;
		epc.livewood_turnover = (double) ini.scan_value(init, 'd').get(0);
		
		t1 = (double) ini.scan_value(init, 'd').get(0);
		epc.daily_mortality_turnover = t1/365;
		t1 = (double) ini.scan_value(init, 'd').get(0);
		epc.daily_fire_turnover = t1/365;
		
		epc.alloc_frootc_leafc = (double) ini.scan_value(init, 'd').get(0);
		epc.alloc_newstemc_newleafc = (double) ini.scan_value(init, 'd').get(0);
		epc.alloc_newlivewoodc_newwoodc = (double) ini.scan_value(init, 'd').get(0);
		epc.alloc_crootc_stemc = (double) ini.scan_value(init, 'd').get(0);
		epc.alloc_prop_curgrowth = (double) ini.scan_value(init, 'd').get(0);
		epc.leaf_cn = (double) ini.scan_value(init, 'd').get(0);
		epc.leaflitr_cn = (double) ini.scan_value(init, 'd').get(0);
		
		/* test for leaflitter C:N > leaf C:N */
		if (epc.leaflitr_cn < epc.leaf_cn){
			
			System.out.print("Error: leaf litter C:N must be >= leaf C:N\n");
			System.out.print("change the values in ECOPHYS block of initialization file\n");
			
			return 0;
		}
		
		epc.froot_cn = (double) ini.scan_value(init, 'd').get(0);
		epc.livewood_cn = (double) ini.scan_value(init, 'd').get(0);
		epc.deadwood_cn = (double) ini.scan_value(init, 'd').get(0);
		
		/* test for deadwood C:N > livewood C:N */
		if (epc.deadwood_cn < epc.livewood_cn){
			
			System.out.print("Error: livewood C:N must be >= deadwood C:N\n");
			System.out.print("change the values in ECOPHYS block of initialization file\n");
			
			return 0;
		}
		
		t1 = (double) ini.scan_value(init, 'd').get(0);
		epc.leaflitr_flab = t1;
		t2 = (double) ini.scan_value(init, 'd').get(0);
		t3 = (double) ini.scan_value(init, 'd').get(0);
		epc.leaflitr_flig = t3;
		
		/* test for litter fractions sum to 1.0 */
		if (Math.abs(t1+t2+t3-1.0) > FLT_COND_TOL){
			
			System.out.print("Error:\n");
			System.out.print("leaf litter proportions of labile, cellulose, and lignin\n");
			System.out.print("must sum to 1.0. Check initialization file and try again.\n");
			
			return 0;
		}
		
		/* calculate shielded and unshielded cellulose fraction */
		r1 = t3/t2;
		if (r1 <= 0.45)
		{
			epc.leaflitr_fscel = 0.0;
			epc.leaflitr_fucel = t2;
		}
		else if (r1 > 0.45 && r1 < 0.7)
		{
			t4 = (r1 - 0.45)*3.2;
			epc.leaflitr_fscel = t4*t2;
			epc.leaflitr_fucel = (1.0 - t4)*t2;
		}
		else
		{
			epc.leaflitr_fscel = 0.8*t2;
			epc.leaflitr_fucel = 0.2*t2;
		}
		
		t1 = (double) ini.scan_value(init, 'd').get(0);
		epc.frootlitr_flab = t1;
		t2 = (double) ini.scan_value(init, 'd').get(0);
		t3 = (double) ini.scan_value(init, 'd').get(0);
		
		epc.frootlitr_flig = t3;
		
		/* test for litter fractions sum to 1.0 */
		if (Math.abs(t1+t2+t3-1.0) > FLT_COND_TOL){
			
			System.out.print("Error:\n");
			System.out.print("froot litter proportions of labile, cellulose, and lignin\n");
			System.out.print("must sum to 1.0. Check initialization file and try again.\n");
			
			return 0;
		}
		
		/* calculate shielded and unshielded cellulose fraction */
		r1 = t3/t2;
		
		if (r1 <= 0.45){
			
			epc.frootlitr_fscel = 0.0;
			epc.frootlitr_fucel = t2;
		}
		else if (r1 > 0.45 && r1 < 0.7){
			
			t4 = (r1 - 0.45) * 3.2;
			epc.frootlitr_fscel = t4 * t2;
			epc.frootlitr_fucel = (1.0 - t4) * t2; 
		}
		else{
			
			epc.frootlitr_fscel = 0.8 * t2;
			epc.frootlitr_fucel = 0.2 * t2;
		}
		
		t1 = (double) ini.scan_value(init, 'd').get(0);
		t2 = (double) ini.scan_value(init, 'd').get(0);
		epc.deadwood_flig = t2;
		
		if (Math.abs(t1 + t2 - 1.0) > FLT_COND_TOL){
			
			System.out.print("Error:\n");
			System.out.print("deadwood proportions of cellulose and lignin must sum\n");
			System.out.print("to 1.0. Check initialization file and try again.\n");
			
			return 0;
		}
		
		r1 = t2/t1;
		if (r1 <= 0.45)
		{
			epc.deadwood_fscel = 0.0;
			epc.deadwood_fucel = t1;
		}
		else if (r1 > 0.45 && r1 < 0.7)
		{
			t4 = (r1 - 0.45)*3.2;
			epc.deadwood_fscel = t4*t1;
			epc.deadwood_fucel = (1.0 - t4)*t1;
		}
		else
		{
			epc.deadwood_fscel = 0.8*t1;
			epc.deadwood_fucel = 0.2*t1;
		}
		
		epc.int_coef = (double) ini.scan_value(init, 'd').get(0);
		epc.ext_coef = (double) ini.scan_value(init, 'd').get(0);
		epc.lai_ratio = (double) ini.scan_value(init, 'd').get(0);
		epc.avg_proj_sla = (double) ini.scan_value(init, 'd').get(0);
		epc.sla_ratio = (double) ini.scan_value(init, 'd').get(0);
		epc.flnr = (double) ini.scan_value(init, 'd').get(0);
		epc.gl_smax = (double) ini.scan_value(init, 'd').get(0);
		epc.gl_c = (double) ini.scan_value(init, 'd').get(0);
		epc.gl_bl = (double) ini.scan_value(init, 'd').get(0);
		epc.psi_open = (double) ini.scan_value(init, 'd').get(0);
		epc.psi_close = (double) ini.scan_value(init, 'd').get(0);
		epc.vpd_open = (double) ini.scan_value(init, 'd').get(0);
		epc.vpd_close = (double) ini.scan_value(init, 'd').get(0);
		
		ini.close_file();
		
	
		
		return 0;
		
	}

}
