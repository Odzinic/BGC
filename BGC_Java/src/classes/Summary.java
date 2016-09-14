package classes;

public class Summary {

	public double daily_npp; /* kgC/m2/day = GPP - Rmaint - Rgrowth */
	public double daily_nep; /* kgC/m2/day = NPP - Rheterotroph */
	public double daily_nee; /* kgC/m2/day = NEP - fire losses */
	public double daily_gpp; /* kgC/m2/day gross PSN source */
	public double daily_mr; /* kgC/m2/day maintenance respiration */
	public double daily_gr; /* kgC/m2/day growth respiration */
	public double daily_hr; /* kgC/m2/day heterotrophic respiration */
	public double daily_fire; /* kgC/m2/day fire losses */
	public double daily_litfallc; /* kgC/m2/day total litterfall */
	public double daily_et; /* kgW/m2/day daily evapotranspiration */
	public double daily_evap; /* kgW/m2/day daily evaporation */
	public double daily_trans; /* kgW/m2/day daily transpiration */
	public double daily_outflow; /* kgW/m2/day daily outflow */
	public double daily_soilw; /* kgW/m2/day daily soilw */
	public double daily_snoww; /* kgW/m2/day daily snoww */
	public double cum_npp; /* kgC/m2 Summed over entire simulation */
	public double cum_nep; /* kgC/m2 Summed over entire simulation */
	public double cum_nee; /* kgC/m2 Summed over entire simulation */
	public double cum_gpp; /* kgC/m2 Summed over entire simulation */
	public double cum_mr; /* kgC/m2 Summed over entire simulation */
	public double cum_gr; /* kgC/m2 Summed over entire simulation */
	public double cum_hr; /* kgC/m2 Summed over entire simulation */
	public double cum_fire; /* kgC/m2 Summed over entire simulation */
	public double vegc; /* kgC/m2 total vegetation C */
	public double litrc; /* kgC/m2 total litter C */
	public double soilc; /* kgC/m2 total soil C */
	public double totalc; /* kgC/m2 total of vegc, litrc, and soilc */

	public Summary(double dDaily_npp, double dDaily_nep, double dDaily_nee, double dDaily_gpp, double dDaily_mr,
			double dDaily_gr, double dDaily_hr, double dDaily_fire, double dDaily_litfallc, double dDaily_et,
			double dDaily_evap, double dDaily_trans, double dDaily_outflow, double dDaily_soilw, double dDaily_snoww,
			double dCum_npp, double dCum_nep, double dCum_nee, double dCum_gpp, double dCum_mr, double dCum_gr,
			double dCum_hr, double dCum_fire, double dVegc, double dLitrc, double dSoilc, double dTotalc) {

		this.daily_npp = dDaily_npp;
		this.daily_nep = dDaily_nep;
		this.daily_nee = dDaily_nee;
		this.daily_gpp = dDaily_gpp;
		this.daily_mr = dDaily_mr;
		this.daily_gr = dDaily_gr;
		this.daily_hr = dDaily_hr;
		this.daily_fire = dDaily_fire;
		this.daily_litfallc = dDaily_litfallc;
		this.daily_et = dDaily_et;
		this.daily_evap = dDaily_evap;
		this.daily_trans = dDaily_trans;
		this.daily_outflow = dDaily_outflow;
		this.daily_soilw = dDaily_soilw;
		this.daily_snoww = dDaily_snoww;
		this.cum_npp = dCum_npp;
		this.cum_nep = dCum_nep;
		this.cum_nee = dCum_nee;
		this.cum_gpp = dCum_gpp;
		this.cum_mr = dCum_mr;
		this.cum_gr = dCum_gr;
		this.cum_hr = dCum_hr;
		this.cum_fire = dCum_fire;
		this.vegc = dVegc;
		this.litrc = dLitrc;
		this.soilc = dSoilc;
		this.totalc = dTotalc;

	}

}
