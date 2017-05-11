package pointbgc;


import classes.Constant;
import classes.Restart_Ctrl;

import java.io.File;

/*
restart_init.c
Initialize the simulation restart parameters

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/
public class Restart_Init {

    int restart_init(File init, Restart_Ctrl restart){

        String key1 = "RESTART";
        String keyword = null;

        double cli_mode = 0.0; // TODO NEED TO CREATE PUBLIC STATIC CLI_MODE IN POINTBGC. Should be a double.

        String BV_ERROR= String.valueOf(Constant.BV_ERROR.getValue());
        double MODE_SPINUP = Constant.MODE_SPINUP.getValue();
        double MODE_SPINNGO = Constant.MODE_SPINNGO.getValue();
        double MODE_MODEL = Constant.MODE_MODEL.getValue();

        Ini ini = new Ini();

        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** RESTART                                                         **
         **                                                                 **
         ********************************************************************/

        /* scan for the restart block keyword, exit if not next */
        keyword = String.valueOf(ini.scan_value(init, 's').get(0));
        if (!keyword.equals(key1)){

            System.out.printf(BV_ERROR, "Error reading keyword for restart data\n");
            return 0;
        }

        /* check for input restart file */
        // TODO Make ini.scan_value return null if value isn't found BUT CANNOT RETURN NULL FOR INT
        // TODO Set an error code for when scanning for an int. Currently set as -1
        restart.read_restart = ini.scan_value(init, 'i').get(0);
        if (restart.read_restart  == -1){

            System.out.printf(BV_ERROR, "Error reading input restart flag\n");
            return 0;

        }

        if (cli_mode == MODE_SPINUP || cli_mode == MODE_SPINNGO){

            restart.read_restart = 0;

        }

        else if (cli_mode == MODE_MODEL){

            restart.read_restart = 1;

        }



        return 0;
    }
}
