package pointbgc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ClassCastException;
import java.lang.UnsupportedOperationException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Scanner;

import classes.Constant;

public class Ini {

    String BV_ERROR = String.valueOf(Constant.BV_ERROR.getValue());
    Scanner sc;

    /*
     * file_open() is the generic file opening routine using the file structure
     * defined above
     */
    public boolean file_open(File target, char mode)
    /*
     * Possible values for mode 'r' for read binary 'i' for read ascii 'w' for
     * write binary 'o' for write ascii
     */ {
        int ok = 1;

        switch (mode) {
            case 'r':
                // if ((target->ptr = fopen(target->name,"rb")) == NULL)
                // {
                // bgc_printf(BV_ERROR, "Can't open %s for binary read ...
                // Exiting\n",target->name);
                // ok=0;
                // }

                try {
                    RandomAccessFile test = new RandomAccessFile(target, "r");
                    return true;
                } catch (IOException io) {
                    System.out.printf(BV_ERROR, "Can't open %s for binary read ... Exiting\n", target.getAbsolutePath());
                    ok = 0;
                    break;

                }

            case 'i':
                // if ((target->ptr = fopen(target->name,"r")) == NULL)
                // {
                // bgc_printf(BV_ERROR, "Can't open %s for ascii read ...
                // Exiting\n",target->name);
                // ok=0;
                // }
                // break;

                try {
                    RandomAccessFile test = new RandomAccessFile(target, "r");
                    return true;
                } catch (IOException io) {
                    System.out.printf(BV_ERROR, "Can't open %s for binary read ... Exiting\n", target.getAbsolutePath());
                    ok = 0;
                    break;

                }

            case 'w':
                // if ((target->ptr = fopen(target->name,"wb")) == NULL)
                // {
                // bgc_printf(BV_ERROR, "Can't open %s for binary write ...
                // Exiting\n",target->name);
                // ok=0;
                // }
                // break;

                try {
                    RandomAccessFile test = new RandomAccessFile(target, "rw");
                    return true;
                } catch (IOException io) {
                    System.out.printf(BV_ERROR, "Can't open %s for binary read ... Exiting\n", target.getAbsolutePath());
                    ok = 0;
                    break;

                }

            case 'o':
                // if ((target->ptr = fopen(target->name,"w")) == NULL)
                // {
                // bgc_printf(BV_ERROR, "Can't open %s for ascii write ...
                // Exiting\n",target->name);
                // ok=0;
                // }
                // break;

                try {
                    RandomAccessFile test = new RandomAccessFile(target, "rw");
                    return true;
                } catch (IOException io) {
                    System.out.printf(BV_ERROR, "Can't open %s for binary read ... Exiting\n", target.getAbsolutePath());
                    ok = 0;
                    break;

                }

            default:
                System.out.printf(BV_ERROR, "Invalid mode specification for file_open ... Exiting\n");
                ok = 0;
        }

        return false;
    }

    /*
     * scan_value is the generic ascii input function for use with text
     * initialization files. Reads the first whitespace delimited word on a
     * line, and discards the remainder of the line. Returns a pointer to value
     * depending on the specified scan type
     */
    public List<?> scan_value(File ini, char type)
    /*
     * Possible values for type 'i' for integer 'd' for double 's' for string
     */

    {
        int ok_scan;
        int ok = 1;

        String sCurrline = null;

        Scanner sc = null;
        try {
            sc = new Scanner(ini);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        switch (type) {
            case 'i':

                List lstReadInt = null;

                try {
                    sCurrline = sc.nextLine();

                    // Parse the line and get the Integer at position 0
                    lstReadInt.add(Integer.valueOf(sCurrline.split(" ")[0]));

                    // Clear sCurrline to prevent assigning the same value
                    sCurrline = null;

                    return lstReadInt;
                } catch (UnsupportedOperationException uoe) {

                    System.out.printf(BV_ERROR, "Error reading int value from %s ... exiting\n", ini.getName());
                    break;
                } catch (ClassCastException ce) {

                    System.out.printf(BV_ERROR, "Error reading int value from %s ... exiting\n", ini.getName());
                    break;
                }

            case 'd':

                List lstReadDoub = null;

                try {
                    sCurrline = sc.nextLine();

                    // Parse the line and get the Double at position 0
                    lstReadDoub.add(Double.valueOf(sCurrline.split(" ")[0]));

                    // Clear sCurrline to prevent assigning the same value
                    sCurrline = null;

                    return lstReadDoub;
                } catch (UnsupportedOperationException uoe) {

                    System.out.printf(BV_ERROR, "Error reading double value from %s ... exiting\n", ini.getName());
                    break;
                } catch (ClassCastException ce) {

                    System.out.printf(BV_ERROR, "Error reading double value from %s ... exiting\n", ini.getName());
                    break;
                }

            case 's':

                List lstReadStr = null;

                try {
                    sCurrline = sc.nextLine();

                    // Parse the line and get the String at position 0
                    lstReadStr.add(sCurrline.split(" ")[0]);

                    // Clear sCurrline to prevent assigning the same value
                    sCurrline = null;

                    return lstReadStr;
                } catch (UnsupportedOperationException uoe) {

                    System.out.printf(BV_ERROR, "Error reading double value from %s ... exiting\n", ini.getName());
                    break;
                } catch (ClassCastException ce) {

                    System.out.printf(BV_ERROR, "Error reading string value from %s ... exiting\n", ini.getName());
                    break;
                }

            default:

                System.out.printf(BV_ERROR, "Invalid type specifier for scan_value ... Exiting\n");
                ok = 0;

        }
        sc.close();
        return null;

    }

    /*
     * combines scan_value with file_open for reading a filename from an
     * initialization file and then opening it with a specified access mode
     */
    public boolean scan_open(File ini, String key, char mode) {
        /*
         * Possible values for mode 'r' for read binary 'i' for read ascii 'w'
         * for write binary 'o' for write ascii
         */

        if (scan_value(ini, 's') == null) {

            System.out.printf(BV_ERROR, "Error reading filename from %s... Exiting\n", ini.getName());
            return false;
        } else if (scan_value(ini, 's') != null) {
            // Resets the position of the scanner to 0
            sc.reset();

            // Scans for the keyword in the file
            while (!(sc.hasNext(key))) {

                sc.next();
            }

            // If the key is found and if the file can be opened, return true
            if (sc.hasNext(key) && file_open(ini, mode)) {

                return true;
            }

        }

        return false;

    }

    public boolean close_file() {

        try {

            sc.close();

            return true;
        } catch (IllegalStateException ise) {
            System.out.print(ise);

            return false;
        }

    }

}
