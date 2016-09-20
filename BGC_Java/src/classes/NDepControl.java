package classes;

public class NDepControl {
	
	public int varndep;
	public double ndep;
	public double[] ndep_array;
	public int[] ndepyear_array;
	public int ndepvals;
	
	public NDepControl(int iVarndep, double dNdep, double[] dNdep_array, int[] iNdepyear_array, int iNdepvals){
		
		this.varndep = iVarndep;
		this.ndep = dNdep;
		this.ndep_array = dNdep_array;
		this.ndepyear_array = iNdepyear_array;
		this.ndepvals = iNdepvals;
	}

}
