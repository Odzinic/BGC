//Compatible
/*
time_init.c
Initialize the simulation timing control parameters for bgc simulation

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/

package pointbgc;

import classes.Control;

import java.io.File;

public class Time_Init {

    public boolean time_init(File init, Control ctrl) {

        String key = "TIME_DEFINE";

        Ini_REDO ini = new Ini_REDO(init, key);


        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** TIME_DEFINE                                                     **
         **                                                                 **
         ********************************************************************/

        /* read the number of years of data in met files */
        try {
            ctrl.metyears = ini.scan_value(0, 'i').intVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading number of met years: Time_Init");
            return false;
        }

        /* read the number of simulation years */
        try {
            ctrl.simyears = ini.scan_value(1, 'i').intVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading simyears: Time_Init");
            return false;
        }

        /* read integer value for the first year of the simulation */
        try {
            ctrl.simstartyear = ini.scan_value(2, 'i').intVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading simstartyear: Time_Init");
            return false;
        }

        /* read flag controling whether or not this is a spinup simulation */
        try {
            ctrl.spinup = ini.scan_value(3, 'i').intVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("Error reading spinup flag: Time_Init");
            return false;
        }


        return true;
    }
}
