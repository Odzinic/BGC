package pointbgc;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/* ReturnValue is a class that is used for returning multiple data types
   when scan_value is called. Can return a String, Integer or Double.
 */
class ReturnValue{

    public String strVal = null;
    // TODO See if -1 is a good initialization value
    public int intVal = -1;
    public double doubVal = -1.0;

//    public ReturnValue(String strVal, int intVal, double doubVal){
    public ReturnValue(){

    }

}


public class Ini_REDO {

    public File init;
    public String keyword;
    public List<String> inputLines;

    public Ini_REDO(File fInit, String sKeyword){

        this.init = fInit;
        this.keyword = sKeyword;

        inputLines = readData(this.init, this.keyword);
    }

    List<String> readData(File fInit, String sKeyword){

        // String array containing data matching the keyword
        List<String> readLines = new ArrayList<String>();

        // Scanner sc used for reading in the data from input file
        Scanner sc = null;

        String sCurrline;


        try{
            sc = new Scanner(fInit);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Scans the input file for the specified keyword and stop once it is found
        while (sc.hasNextLine()){

            sCurrline = sc.nextLine();

            if (sCurrline.contains(sKeyword)){

                break;
            }

            else if (sCurrline.contains("END_INIT")){

                System.out.print("ERROR: REACHED END OF INI FILE WITHOUT FINDING KEYWORD");
                return null;
            }

        }

        // Scanner starts at keyword position in input file and reads in all the data related to the
        // keyword into a list readLines
        while (sc.hasNextLine()){


            sCurrline = sc.nextLine();

            if (sCurrline.equals("")){
                break;
            }
            else{
                readLines.add(sCurrline.split(" ")[0]);

            }

        }

        sc.close();
        return readLines;

    }

    /* scan_value receives an integer iPos and char cType that determines which value from inputLines
       will be returned and what data type it will be stored as. Possible values for type 'i' for integer
       'd' for double 's' for string
    */
    ReturnValue scan_value(int iPos, char cType){


        // Check if the specified list position is in the bounds of the list. If false, returns null.
        if (iPos >= inputLines.size()){

            System.out.println("ERROR: Specified position value iPos is outside the the list bounds.");

            return null;
        }

        switch (cType){

            case 'i':
                ReturnValue returnInt = new ReturnValue();

                try{

                    returnInt.intVal = Integer.valueOf(inputLines.get(iPos));
//                    readInt.add(Integer.valueOf(inputLines.get(iPos)));

                    return returnInt;
                } catch (UnsupportedOperationException uoe) {

                    uoe.printStackTrace();
                    return null;
                }

            case 'd':
                ReturnValue returnDouble = new ReturnValue();

                try{

                    returnDouble.doubVal = Double.valueOf(inputLines.get(iPos));
//                    readDouble.add(Double.valueOf(inputLines.get(iPos)));

                    return returnDouble;
                } catch (UnsupportedOperationException uoe) {

                    uoe.printStackTrace();;
                    return null;
                }

            case 's':
                ReturnValue returnString = new ReturnValue();

                try{

                    returnString.strVal = String.valueOf(inputLines.get(iPos));
//                    readString.add(String.valueOf(inputLines.get(iPos)));
                } catch (UnsupportedOperationException uoe) {

                    uoe.printStackTrace();
                    return null;
                }

            default:

                System.out.println("ERROR: Unsupported data type specified for scan_value.");
        }

        return null;
    }



}
