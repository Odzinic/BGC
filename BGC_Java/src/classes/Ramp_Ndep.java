package classes;

public class Ramp_Ndep {

	public int doramp; /* (flag) 1=ramped Ndep, 0=constant Ndep */
	public int ind_year; /* (int) reference year for indust. Ndep */
	public double preind_ndep; /*
								 * (double) (kgN/m2/yr) preindustrial Ndep (at
								 * first metyear)
								 */
	public double ind_ndep; /* (double) (kgN/m2/yr) industrial Ndep at ref yr */

	public Ramp_Ndep(int iDoramp, int iInd_year, double dPreind_ndep, double dInd_ndap) {

		this.doramp = iDoramp;
		this.ind_year = iInd_year;
		this.preind_ndep = dPreind_ndep;
		this.ind_ndep = dInd_ndap;
	}

}
