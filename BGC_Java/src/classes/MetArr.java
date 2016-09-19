package classes;

public class MetArr {

	public double[] tmax; /* (deg C) daily maximum air temperature */
	public double[] tmin; /* (deg C) daily minimum air temperature */
	public double[] prcp; /* (cm) precipitation */
	public double[] vpd; /* (Pa) vapor pressure deficit */
	public double[] swavgfd; /* (W/m2) daylight avg shortwave flux density */
	public double[] par; /* (W/m2) photosynthetically active radiation */
	public double[] dayl; /* (s) daylength */
	public double[] tavg; /* (deg C) daily average temperature */
	public double[] tavg_ra; /* (deg C) 11-day running avg of daily avg temp */

	public MetArr(double[] cTmax, double[] cTmin, double[] cPrcp, double[] cVpd, double[] cSwavgfd, double[] cPar,
			double[] cDayl, double[] cTavg, double[] cTavg_ra) {

		this.tmax = cTmax;
		this.tmin = cTmin;
		this.prcp = cPrcp;
		this.vpd = cVpd;
		this.swavgfd = cSwavgfd;
		this.par = cPar;
		this.dayl = cDayl;
		this.tavg = cTavg;
		this.tavg_ra = cTavg_ra;
	}

}
