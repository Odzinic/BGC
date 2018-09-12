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
            System.out.println("Error reading keyword for end of initialization file");
            System.out.printf("Expecting keyword --> %s in file %s", key1, init.getName());
            System.out.println("This indicates that you have the wrong number of lines");
            System.out.println("of information in your initialization file.");
            System.out.println("Refer to documentation to determine proper format.");


        } catch (NullPointerException npe) {

            if (keyword == null) {

                return true;
            }

        }


        return false;

    }

}
