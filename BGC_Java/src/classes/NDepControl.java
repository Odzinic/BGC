package classes;

import java.util.List;

public class NDepControl {

    public int varndep;
    public double ndep;
    public List<Double> ndep_array;
    public List<Integer> ndepyear_array;
    public int ndepvals;

    public NDepControl(int iVarndep, double dNdep, List<Double> dNdep_array, List<Integer> iNdepyear_array, int iNdepvals) {

        this.varndep = iVarndep;
        this.ndep = dNdep;
        this.ndep_array = dNdep_array;
        this.ndepyear_array = iNdepyear_array;
        this.ndepvals = iNdepvals;
    }

}
