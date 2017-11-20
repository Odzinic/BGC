//Compatible
package pointbgc;

import java.io.File;
import java.io.FileNotFoundException;

import classes.Constant;
import classes.Epconst;

public class Epc_Init {

    public boolean epc_init(File init, Epconst epc) {

        double t1, t2, t3, t4, r1;
        File fEpcIni;
        String key1 = "EPC_FILE";
        String key2 = "ECOPHYS";

        String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());
        double FLT_COND_TOL = Constant.FLT_COND_TOL.getValue();

        Ini_REDO findini = new Ini_REDO(init, key1);
        Ini_REDO ini = null;

        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** EPC_FILES                                                       **
         **                                                                 **
         ********************************************************************/

		/* read in the epc filepath from the ini */
        try {
            fEpcIni = new File(findini.scan_value(0, 's').strVal);
            ini = new Ini_REDO(fEpcIni, key2);
        } catch (NullPointerException npe) {

            System.out.println("ERROR: No/Incorrect epc filepath specified in .ini file, epc_init()");

        }
		
		/* begin reading constants from *.init */
        epc.woody = ini.scan_value(0, 'i').intVal;
        epc.evergreen = ini.scan_value(1, 'i').intVal;
        epc.c3_flag = ini.scan_value(2, 'i').intVal;
        epc.phenology_flag = ini.scan_value(3, 'i').intVal;
        epc.onday = ini.scan_value(4, 'i').intVal;
        epc.offday = ini.scan_value(5, 'i').intVal;
        epc.transfer_pdays = ini.scan_value(6, 'd').doubVal;
        epc.litfall_pdays = ini.scan_value(7, 'd').doubVal;
        epc.leaf_turnover = ini.scan_value(8, 'd').doubVal;

        if (epc.evergreen == 0){

            epc.leaf_turnover = 1.0;
        }

        epc.froot_turnover = epc.leaf_turnover;
        epc.livewood_turnover = ini.scan_value(9, 'd').doubVal;

        t1 = ini.scan_value(10, 'd').doubVal;
        epc.daily_mortality_turnover = t1/365;
        t1 = ini.scan_value(11, 'd').doubVal;
        epc.daily_fire_turnover = t1/365;

        epc.alloc_frootc_leafc = ini.scan_value(12, 'd').doubVal;
        epc.alloc_newstemc_newleafc = ini.scan_value(13, 'd').doubVal;
        epc.alloc_newlivewoodc_newwoodc = ini.scan_value(14, 'd').doubVal;
        epc.alloc_crootc_stemc = ini.scan_value(15, 'd').doubVal;
        epc.alloc_prop_curgrowth = ini.scan_value(16, 'd').doubVal;
        epc.leaf_cn = ini.scan_value(17, 'd').doubVal;
        epc.leaflitr_cn = ini.scan_value(18, 'd').doubVal;

		/* test for leaflitter C:N > leaf C:N */
        if (epc.leaflitr_cn < epc.leaf_cn){

            System.out.print("Error: leaf litter C:N must be >= leaf C:N\n");
            System.out.print("change the values in ECOPHYS block of initialization file\n");

            return false;
        }

        epc.froot_cn = ini.scan_value(19, 'd').doubVal;
        epc.livewood_cn = ini.scan_value(20, 'd').doubVal;
        epc.deadwood_cn = ini.scan_value(21, 'd').doubVal;

		/* test for deadwood C:N > livewood C:N */
        if (epc.deadwood_cn < epc.livewood_cn){

            System.out.print("Error: livewood C:N must be >= deadwood C:N\n");
            System.out.print("change the values in ECOPHYS block of initialization file\n");

            return false;
        }

        t1 = ini.scan_value(22, 'd').doubVal;
        epc.leaflitr_flab = t1;
        t2 = ini.scan_value(23, 'd').doubVal;
        t3 = ini.scan_value(24, 'd').doubVal;
        epc.leaflitr_flig = t3;
		
		/* test for litter fractions sum to 1.0 */
        if (Math.abs(t1+t2+t3-1.0) > FLT_COND_TOL){

            System.out.print("Error:\n");
            System.out.print("leaf litter proportions of labile, cellulose, and lignin\n");
            System.out.print("must sum to 1.0. Check initialization file and try again.\n");

            return false;
        }
		
		/* calculate shielded and unshielded cellulose fraction */
        r1 = t3/t2;
        if (r1 <= 0.45) {
            epc.leaflitr_fscel = 0.0;
            epc.leaflitr_fucel = t2;
        } else if (r1 > 0.45 && r1 < 0.7) {
            t4 = (r1 - 0.45)*3.2;
            epc.leaflitr_fscel = t4*t2;
            epc.leaflitr_fucel = (1.0 - t4)*t2;
        } else {
            epc.leaflitr_fscel = 0.8*t2;
            epc.leaflitr_fucel = 0.2*t2;
        }

        t1 = ini.scan_value(25, 'd').doubVal;
        epc.frootlitr_flab = t1;
        t2 = ini.scan_value(26, 'd').doubVal;
        t3 = ini.scan_value(27, 'd').doubVal;

        epc.frootlitr_flig = t3;
		
		/* test for litter fractions sum to 1.0 */
        if (Math.abs(t1+t2+t3-1.0) > FLT_COND_TOL){

            System.out.print("Error:\n");
            System.out.print("froot litter proportions of labile, cellulose, and lignin\n");
            System.out.print("must sum to 1.0. Check initialization file and try again.\n");

            return false;
        }
		
		/* calculate shielded and unshielded cellulose fraction */
        r1 = t3/t2;

        if (r1 <= 0.45){

            epc.frootlitr_fscel = 0.0;
            epc.frootlitr_fucel = t2;
        } else if (r1 > 0.45 && r1 < 0.7){

            t4 = (r1 - 0.45) * 3.2;
            epc.frootlitr_fscel = t4 * t2;
            epc.frootlitr_fucel = (1.0 - t4) * t2;
        } else{

            epc.frootlitr_fscel = 0.8 * t2;
            epc.frootlitr_fucel = 0.2 * t2;
        }

        t1 = ini.scan_value(28, 'd').doubVal;
        t2 = ini.scan_value(29, 'd').doubVal;
        epc.deadwood_flig = t2;

        if (Math.abs(t1 + t2 - 1.0) > FLT_COND_TOL){

            System.out.print("Error:\n");
            System.out.print("deadwood proportions of cellulose and lignin must sum\n");
            System.out.print("to 1.0. Check initialization file and try again.\n");

            return false;
        }

        r1 = t2/t1;
        if (r1 <= 0.45) {
            epc.deadwood_fscel = 0.0;
            epc.deadwood_fucel = t1;
        } else if (r1 > 0.45 && r1 < 0.7) {
            t4 = (r1 - 0.45)*3.2;
            epc.deadwood_fscel = t4*t1;
            epc.deadwood_fucel = (1.0 - t4)*t1;
        } else {
            epc.deadwood_fscel = 0.8*t1;
            epc.deadwood_fucel = 0.2*t1;
        }

        epc.int_coef = ini.scan_value(30, 'd').doubVal;
        epc.ext_coef = ini.scan_value(31, 'd').doubVal;
        epc.lai_ratio = ini.scan_value(32, 'd').doubVal;
        epc.avg_proj_sla = ini.scan_value(33, 'd').doubVal;
        epc.sla_ratio = ini.scan_value(34, 'd').doubVal;
        epc.flnr = ini.scan_value(35, 'd').doubVal;
        epc.gl_smax = ini.scan_value(36, 'd').doubVal;
        epc.gl_c = ini.scan_value(37, 'd').doubVal;
        epc.gl_bl = ini.scan_value(38, 'd').doubVal;
        epc.psi_open = ini.scan_value(39, 'd').doubVal;
        epc.psi_close = ini.scan_value(40, 'd').doubVal;
        epc.vpd_open = ini.scan_value(41, 'd').doubVal;
        epc.vpd_close = ini.scan_value(42, 'd').doubVal;

        return true;

    }

}
