package classes;

public class PMet {

	public double ta; /* (degC) air temperature */
	public double pa; /* (Pa) air pressure */
	public double vpd; /* (Pa) vapor pressure deficit */
	public double irad; /* (W/m2) incident shortwave flux density */
	public double rv; /* (s/m) resistance to water vapor flux */
	public double rh; /* (s/m) resistance to sensible heat flux */

	public PMet(double dTa, double dPa, double dVpd, double dIrad, double dRv, double dRh) {

		this.ta = dTa;
		this.pa = dPa;
		this.vpd = dVpd;
		this.irad = dIrad;
		this.rv = dRv;
		this.rh = dRh;

	}

}
