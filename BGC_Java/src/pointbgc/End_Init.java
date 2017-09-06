//Compatible
//TODO: Find way to prevent "ERROR: Specified position value iPos is outside the the list bounds." from occurring in null scan
package pointbgc;

import java.io.File;

import classes.Constant;

public class End_Init {

    public boolean end_init(File init) {

        String key1 = "END_INIT";
        String keyword = null;

        String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());

        Ini_REDO ini = new Ini_REDO(init, key1);


        /********************************************************************
         **                                                                 **
         ** Begin reading initialization file block starting with keyword:  **
         ** END_INIT                                                        **
         **                                                                 **
         ********************************************************************/

        try{
            keyword = ini.scan_value(0, 's').strVal;
        } catch (IndexOutOfBoundsException ibe) {
            System.out.printf(BV_ERROR, "Error reading keyword for end of initialization file\n");
            System.out.printf(BV_ERROR, "Expecting keyword --> %s in file %s\n",key1,init.getName());
            System.out.printf(BV_ERROR, "This indicates that you have the wrong number of lines\n");
            System.out.printf(BV_ERROR, "of information in your initialization file.\n");
            System.out.printf(BV_ERROR, "Refer to documentation to determine proper format.\n");


        } catch (NullPointerException npe) {

            if (keyword == null) {

                return true;
            }

        }


        return false;

    }

}
