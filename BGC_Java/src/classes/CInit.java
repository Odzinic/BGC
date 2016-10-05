package classes;

public class CInit {

	public double max_leafc; /* (kgC/m2) first-year displayed + stored leafc */
	public double max_stemc; /* (kgC/m2) first-year total stem carbon */

	public CInit(double dMax_leafc, double dMax_stemc) {

		this.max_leafc = dMax_leafc;
		this.max_stemc = dMax_stemc;
	}

}
