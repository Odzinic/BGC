//Compatible
/*
scc_init.c
Initialize the scalar climate change parameters for bgc simulation

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/

package pointbgc;

import classes.ClimChange;

import java.io.File;

public class Scc_Init {

    public boolean scc_init(File init, ClimChange scc) {

        String key1 = "CLIM_CHANGE";

        Ini_REDO ini = new Ini_REDO(init, key1);

        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** CLIM_CHANGE                                                     **
         **                                                                 **
         ********************************************************************/

        /* scan for the climate change block keyword, exit if not next */
        try {

            scc.s_tmax = ini.scan_value(0, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {

            System.out.println("Error reading scalar for tmax, SCC_Init");
            return false;
        }

        try {

            scc.s_tmin = ini.scan_value(1, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {

            System.out.println("Error reading scalar for tmin, SCC_Init");
            return false;
        }

        try {

            scc.s_prcp = ini.scan_value(2, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {

            System.out.println("Error reading scalar for s_prcp, SCC_Init");
            return false;
        }

        try {

            scc.s_vpd = ini.scan_value(3, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {

            System.out.println("Error reading scalar for vpd, SCC_Init");
            return false;
        }

        try {

            scc.s_swavgfd = ini.scan_value(4, 'd').doubVal;
        } catch (IndexOutOfBoundsException ibe) {

            System.out.println("Error reading scalar for swavgfd, SCC_Init");
            return false;
        }

        /* some error checking on scalar climate change values */
        if (scc.s_prcp < 0.0) {

            System.out.println("Error in SCC_Init: prcp scalar must be positive");
            return false;
        }

        if (scc.s_vpd < 0.0) {

            System.out.println("Error in SCC_Init: vpd scalar must be positive");
            return false;
        }

        if (scc.s_swavgfd < 0.0) {

            System.out.println("Error in SCC_Init: swavgfd scalar must be positive");
            return false;
        }

        return true;

    }

}
