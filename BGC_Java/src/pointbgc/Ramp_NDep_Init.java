//Compatible
package pointbgc;


import classes.Ramp_Ndep;
import classes.Constant;

import java.io.File;

public class Ramp_NDep_Init {

    public int ramp_ndep_init(File init, Ramp_Ndep ramp_ndep){

        String key1 = "RAMP_NDEP";

        String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

        Ini_REDO ini = new Ini_REDO(init, key1);

        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** RAMP_NDEP                                                     **
         **                                                                 **
         ********************************************************************/


        /* begin reading ramp_ndep information */
        try{

            ramp_ndep.doramp = (int) ini.scan_value(0, 'i').intVal;

        } catch (IndexOutOfBoundsException ibe) {

            System.out.printf(BV_ERROR, "Error reading keyword, ramp_ndep_init()\n");

        }

        try{

            ramp_ndep.ind_year = (int) ini.scan_value(1, 'i').intVal;

        } catch (IndexOutOfBoundsException ibe) {

            System.out.printf(BV_ERROR, "Error reading year of reference for industrial Ndep: ramp_ndep_init()\n");

        }

        try{

            ramp_ndep.ind_ndep = (double) ini.scan_value(2, 'd').doubVal;

        } catch (IndexOutOfBoundsException ibe) {

            System.out.printf(BV_ERROR, "Error reading industrial Ndep value: ramp_ndep_init()\n");

        }


        return 0;
    }
}
