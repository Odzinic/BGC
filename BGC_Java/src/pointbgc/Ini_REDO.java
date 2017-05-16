package pointbgc;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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



}
