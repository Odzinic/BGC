//Compatible
package classes;

import java.io.File;

public class Point {

    public String header;
    public String systime;
    public File metf;
    //TODO: Add numhead to appropriate function calls
    public int numhead; // Integer containing the number of header files in the metf file

    public Point(String sHeader, String sSystime, File sMetf, int iHead) {

        this.header = sHeader;
        this.systime = sSystime;
        this.metf = sMetf;
        this.numhead = iHead;

    }

}
