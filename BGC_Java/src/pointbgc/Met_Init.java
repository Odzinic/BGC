//Compatible
package pointbgc;

import java.io.File;

import classes.Point;

public class Met_Init {

    public int met_init(File init, Point point){

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
        sPath = ini.scan_value(0, 's').strVal;
        point.metf = new File(sPath);
		
		/* get number of metfile header lines */
        nhead = ini.scan_value(1, 'i').intVal;

		
		/* Should be used in MetArr to skip headers */
        return nhead;

    }

}
