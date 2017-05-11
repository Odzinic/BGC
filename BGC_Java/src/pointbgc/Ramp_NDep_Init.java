package pointbgc;


import classes.Ramp_Ndep;
import classes.Constant;

import java.io.File;

public class Ramp_NDep_Init {

    public int ramp_ndep_init(File init, Ramp_Ndep ramp_ndep){

        String key1 = "RAMP_NDEP";
        String keyword = null;

        String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

        Ini ini = new Ini();

        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** RAMP_NDEP                                                     **
         **                                                                 **
         ********************************************************************/

	    /* scan for the climate change block keyword, exit if not next */
	    try{

	        keyword = (String) ini.scan_value(init, 's').get(0);

        }

        catch (IndexOutOfBoundsException ibe) {

	        System.out.printf(BV_ERROR, "Error reading keyword, ramp_ndep_init()\n");

        }

        if (keyword.equals(key1)){

	        return 1;
        }

        /* begin reading ramp_ndep information */
        try{

            ramp_ndep.doramp = (int) ini.scan_value(init, 'i').get(0);

        }

        catch (IndexOutOfBoundsException ibe) {

            System.out.printf(BV_ERROR, "Error reading keyword, ramp_ndep_init()\n");

        }

        try{

            ramp_ndep.ind_year = (int) ini.scan_value(init, 'i').get(0);

        }

        catch (IndexOutOfBoundsException ibe) {

            System.out.printf(BV_ERROR, "Error reading year of reference for industrial Ndep: ramp_ndep_init()\n");

        }

        try{

            ramp_ndep.ind_ndep = (double) ini.scan_value(init, 'd').get(0);

        }

        catch (IndexOutOfBoundsException ibe) {

            System.out.printf(BV_ERROR, "Error reading industrial Ndep value: ramp_ndep_init()\n");

        }


        return 0;
    }
}
