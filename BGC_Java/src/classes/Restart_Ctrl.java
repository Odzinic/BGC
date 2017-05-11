package classes;


import java.io.File;

public class Restart_Ctrl {

    public int read_restart;      /* flag to read restart file */
    public int write_restart;     /* flag to write restart file */
    public int keep_metyr;        /* (flag) 1=retain restart metyr, 0=reset metyr */
    public File in_restart;       /* input restart file */
    public File out_restart;      /* output restart file */

    public Restart_Ctrl(int iRead_restart, int iWrite_restart, int iKeep_metyr, File fIn_restart, File fOut_restart) {

        this.read_restart = iRead_restart;
        this.write_restart = iWrite_restart;
        this.keep_metyr = iKeep_metyr;
        this.in_restart = fIn_restart;
        this.out_restart = fOut_restart;
    }

}
