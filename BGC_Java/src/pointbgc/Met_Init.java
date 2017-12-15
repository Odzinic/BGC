//Compatible

/*
met_init.c
open met file for input, scan through header lines

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
Biome-BGC version 4.2 (final release)
See copyright.txt for Copyright information
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
*/

package pointbgc;

import java.io.File;

import classes.Point;

public class Met_Init {

    public boolean met_init(File init, Point point) {

        int nhead, i;
        String key1 = "MET_INPUT";
        String sPath;
        //TODO: Rename to Ini from Ini_REDO
        Ini_REDO ini = new Ini_REDO(init, key1);


        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** MET_INPUT                                                       **
         **                                                                 **
         ********************************************************************/

		/* get the met data filename and open file for ascii read */
        try {

            sPath = ini.scan_value(0, 's').strVal;
            point.metf = new File(sPath);
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println(ibe);
            System.out.println("Error reading met data filename, met_init()");

            return false;
        } catch (ClassCastException cce) {
            System.out.println(cce);
            System.out.println("Error reading met data filename, met_init()");

            return false;
        }


		/* get number of metfile header lines */
        try {
            nhead = ini.scan_value(1, 'i').intVal;
            point.numhead = nhead;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println(ibe);
            System.out.println("Error reading number of header lines, met_init()");

            return false;
        } catch (ClassCastException cce) {
            System.out.println(cce);
            System.out.println("Error reading number of header lines, met_init()");

            return false;
        }

        return true;

    }

}
