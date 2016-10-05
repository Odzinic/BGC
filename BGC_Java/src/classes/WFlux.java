package classes;

public class WFlux {

	public double prcp_to_canopyw; /* (kgH2O/m2/d) interception on canopy */
	public double prcp_to_soilw; /*
									 * (kgH2O/m2/d) precip entering soilwater
									 * pool
									 */
	public double prcp_to_snoww; /* (kgH2O/m2/d) snowpack accumulation */
	public double canopyw_evap; /* (kgH2O/m2/d) evaporation from canopy */
	public double canopyw_to_soilw; /* (kgH2O/m2/d) canopy drip and stemflow */
	public double snoww_subl; /* (kgH2O/m2/d) sublimation from snowpack */
	public double snoww_to_soilw; /* (kgH2O/m2/d) melt from snowpack */
	public double soilw_evap; /* (kgH2O/m2/d) evaporation from soil */
	public double soilw_trans; /* (kgH2O/m2/d) transpiration */
	public double soilw_outflow; /* (kgH2O/m2/d) outflow */
	public double et; /* (kgH20/m2/d) evapotranspiration */

	public WFlux(double dPrcp_to_canopyw, double dPrcp_to_soilw, double dPrcp_to_snoww, double dCanopyw_evap,
			double dCanopyw_to_soilw, double dSnoww_subl, double dSnoww_to_soilw, double dSoilw_evap,
			double dSoilw_trans, double dSoilw_outflow, double dEt) {

		this.prcp_to_canopyw = dPrcp_to_canopyw;
		this.prcp_to_soilw = dPrcp_to_soilw;
		this.prcp_to_snoww = dPrcp_to_snoww;
		this.canopyw_evap = dCanopyw_evap;
		this.canopyw_to_soilw = dCanopyw_to_soilw;
		this.snoww_subl = dSnoww_subl;
		this.snoww_to_soilw = dSnoww_to_soilw;
		this.soilw_evap = dSoilw_evap;
		this.soilw_trans = dSoilw_trans;
		this.soilw_outflow = dSoilw_outflow;
		this.et = dEt;

	}

}
