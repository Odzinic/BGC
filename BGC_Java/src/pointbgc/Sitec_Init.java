//Compatible
/*
Sitec_Init
Initialize the site physical constants for bgc simulation

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/

package pointbgc;

import classes.Constant;
import classes.Siteconst;

import java.io.File;

public class Sitec_Init {

    public boolean sitec_init(File init, Siteconst sitec) {

        /* reads the site physical constants from *.init */
        String key1 = "SITE";
        double sand = 0.0; /* percent sand */
        double silt = 0.0; /* percent silt */
        double clay = 0.0; /* percent clay */
        double FLT_COND_TOL = Constant.FLT_COND_TOL.getValue();

        Ini_REDO ini = new Ini_REDO(init, key1);

        /* begin reading constants from init */
        try {
            sitec.soil_depth = ini.scan_value(0, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading soil depth, Sitec_Init");
        }

        try {
            sand = ini.scan_value(1, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading sand, Sitec_Init");
        }

        try {
            silt = ini.scan_value(2, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading silt, Sitec_Init");
        }

        try {
            clay = ini.scan_value(3, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading clay, Sitec_Init");
        }

        try {
            sitec.elev = ini.scan_value(4, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading elevation, Sitec_Init");
        }

        try {
            sitec.lat = ini.scan_value(5, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading latitude, Sitec_Init");
        }

        try {
            sitec.sw_alb = ini.scan_value(6, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading shortwave albedo, Sitec_Init");
        }

        try {
            sitec.ndep = ini.scan_value(7, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading N deposition, Sitec_Init");
        }

        try {
            sitec.nfix = ini.scan_value(8, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading N fixation, Sitec_Init");
        }

        /* calculate the soil pressure-volume coefficients from texture data */
        /* Uses the multivariate regressions from Cosby et al., 1984 */
        /* first check that the percentages add to 100.0 */

        if (Math.abs(sand + silt + clay - 100) > FLT_COND_TOL) {

            System.out.println("Error: %%sand + %%silt + %%clay  MUST EQUAL 100");
            System.out.println("Check values in initialization file");
            return false;
        }

        sitec.soil_b = -(3.10 + 0.157 * clay - 0.003 * sand);
        sitec.vwc_sat = (50.5 - 0.142 * sand - 0.037 * clay) / 100.0;
        sitec.psi_sat = -(Math.exp((1.54 - 0.0095 * sand + 0.0063 * silt) * Math.log(10.0)) * 9.8e-5);
        sitec.vwc_fc = sitec.vwc_sat * Math.pow((-0.015 / sitec.psi_sat), (1.0 / sitec.soil_b));

	    /* define maximum soilwater content, for outflow calculation
		converts volumetric water content (m3/m3) --> (kg/m2) */
        sitec.soilw_fc = sitec.soil_depth * sitec.vwc_fc * 1000.0;
        sitec.soilw_sat = sitec.soil_depth * sitec.vwc_sat * 1000.0;


        return true;
    }
}
