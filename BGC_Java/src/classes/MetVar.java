package classes;

public class MetVar {

	public double prcp; /* (kg/m2) precipitation */
	public double tmax; /* (deg C) daily maximum air temperature */
	public double tmin; /* (deg C) daily minimum air temperature */
	public double tavg; /* (deg C) daily average air temperature */
	public double tday; /* (deg C) daylight average air temperature */
	public double tnight; /* (deg C) nightime average air temperature */
	public double tsoil; /* (deg C) daily soil temperature, avg, top 10 cm */
	public double vpd; /* (Pa) vapor pressure deficit */
	public double swavgfd; /* (W/m2) daylight average shortwave flux */
	public double swabs; /* (W/m2) canopy absorbed shortwave flux */
	public double swtrans; /* (W/m2) transmitted shortwave flux */
	public double swabs_per_plaisun; /* (W/m2) swabs per unit sunlit proj LAI */
	public double swabs_per_plaishade; /*
										 * (W/m2) swabs per unit shaded proj LAI
										 */
	public double ppfd_per_plaisun; /*
									 * (umol/m2/s) ppfd per unit sunlit proj LAI
									 */
	public double ppfd_per_plaishade; /*
										 * (umol/m2/s) ppfd per unit shaded proj
										 * LAI
										 */
	public double par; /* (W/m2) photosynthetically active radiation */
	public double parabs; /* (W/m2) PAR absorbed by canopy */
	public double pa; /* (Pa) atmospheric pressure */
	public double co2; /* (ppm) atmospheric concentration of CO2 */
	public double dayl; /* (s) daylength */

	public MetVar(double dPrcp, double dTmax, double dTmin, double dTavg, double dTday, double dTnight, double dTsoil,
			double dVpd, double dSwavgfd, double dSwabs, double dSwtrans, double dSwabs_per_plaisun,
			double dSwabs_per_plaishade, double dPpfd_per_plaisun, double dPpfd_per_plaishade, double dPar,
			double dParabs, double dPa, double dCo2, double dDayl) {
		
		this.prcp = dPrcp;
		this.tmax = dTmax;
		this.tmin = dTmin;
		this.tavg = dTavg;
		this.tday = dTday;
		this.tnight = dTnight;
		this.tsoil = dTsoil;
		this.vpd = dVpd;
		this.swavgfd = dSwavgfd;
		this.swabs = dSwabs;
		this.swtrans = dSwtrans;
		this.swabs_per_plaisun = dSwabs_per_plaisun;
		this.swabs_per_plaishade = dSwabs_per_plaishade;
		this.ppfd_per_plaisun = dPpfd_per_plaisun;
		this.ppfd_per_plaishade = dPpfd_per_plaishade;
		this.par = dPar;
		this.parabs = dParabs;
		this.pa = dPa;
		this.co2 = dCo2;
		this.dayl = dDayl;

	}

}
