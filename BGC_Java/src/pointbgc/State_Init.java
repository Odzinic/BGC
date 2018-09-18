//Compatible
/*
state_init.c
Initialize water, carbon, and nitrogen state variables for pointbgc simulation

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/

package pointbgc;

import classes.*;

import java.io.File;

public class State_Init {

    public boolean wstate_init(File init, Siteconst sitec, WState ws) {

        String key = "W_STATE";
        double psat = 0.0;

        Ini_REDO ini = new Ini_REDO(init, key);

        /* read water state variable initialization values from init */
        try {
            ws.snoww = ini.scan_value(0, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading snowpack, Wstate_Init");
            return false;
        }

        try {
            psat = ini.scan_value(1, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading soilwater, Wstate_Init");
            return false;
        }

        /* check that psat is an acceptable proportion  */
        if (psat < 0.0 || psat > 1.0) {
            System.out.println("Error: initial soil water proportion must be >= 0.0 and <= 1.0");
            return false;
        } else {
            /* calculate initial soilwater in kg/m2 from proportion of
            saturated volumetric water content, depth, and density of water */
            ws.soilw = sitec.vwc_sat * psat * sitec.soil_depth * 1000.0;
        }


        return true;
    }

    public boolean cnstate_init(File init, Epconst epc, CState cs, CInit cinit, NState ns) {

        String key1 = "C_STATE";
        String key2 = "N_STATE";

        Double SOIL1_CN = Constant.SOIL1_CN.getValue();
        Double SOIL2_CN = Constant.SOIL2_CN.getValue();
        Double SOIL3_CN = Constant.SOIL3_CN.getValue();
        Double SOIL4_CN = Constant.SOIL4_CN.getValue();

        /* Ini reader for the C_State variables */
        Ini_REDO ini_cstate = new Ini_REDO(init, key1);
        /* Ini reader for the N_State variables */
        Ini_REDO ini_nstate = new Ini_REDO(init, key2);

        /* read carbon state variable initial values from init */
        try {
            cinit.max_leafc = ini_cstate.scan_value(0, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading first-year maximum leaf carbon, Cstate_Init");
            return false;
        }

        try {
            cinit.max_stemc = ini_cstate.scan_value(1, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading first-year maximum stem carbon, Cstate_Init");
            return false;
        }

        try {
            cs.cwdc = ini_cstate.scan_value(2, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading coarse woody debris carbon, Cstate_Init");
            return false;
        }

        ns.cwdn = cs.cwdc / epc.deadwood_cn;

        /* read the litter carbon pool initial values */
        try {
            cs.litr1c = ini_cstate.scan_value(3, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading litter carbon in labile pool, Cstate_Init");
            return false;
        }

        try {
            cs.litr2c = ini_cstate.scan_value(4, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading litter carbon in unshielded cellulose pool, Cstate_Init");
            return false;
        }

        try {
            cs.litr3c = ini_cstate.scan_value(5, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading litter carbon in shielded cellulose pool, Cstate_Init");
            return false;
        }

        try {
            cs.litr4c = ini_cstate.scan_value(6, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading litter carbon in ligning pool, Cstate_Init");
            return false;
        }

        /* calculate the litter nitrogen pool initial values for cellulose and
	    and lignin pools, using the leaf litter C:N as the basis for determining
	    N content in all litter components */
        ns.litr2n = cs.litr2c / epc.leaflitr_cn;
        ns.litr3n = cs.litr3c / epc.leaflitr_cn;
        ns.litr4n = cs.litr4c / epc.leaflitr_cn;

        try {
            cs.soil1c = ini_cstate.scan_value(7, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading fast microbial recycling carbon, Cstate_Init");
            return false;
        }

        ns.soil1n = cs.soil1c / SOIL1_CN;

        try {
            cs.soil2c = ini_cstate.scan_value(8, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading medium microbial recycling carbon, Cstate_Init");
            return false;
        }

        ns.soil2n = cs.soil2c / SOIL2_CN;

        try {
            cs.soil3c = ini_cstate.scan_value(9, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading slow microbial recycling carbon, Cstate_Init");
            return false;
        }

        ns.soil3n = cs.soil3c / SOIL3_CN;

        try {
            cs.soil4c = ini_cstate.scan_value(10, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading recalcitrant SOM carbon, Cstate_Init");
            return false;
        }

        ns.soil4n = cs.soil4c / SOIL4_CN;

        /* read nitrogen state variable initial values from init */
        try {
            ns.litr1n = ini_nstate.scan_value(0, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading litter nitrogen in labile pool, Nstate_Init");
            return false;
        }

        try {
            ns.sminn = ini_nstate.scan_value(1, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading soil mineral nitrogen, Nstate_Init");
            return false;
        }

        return true;
    }
}
