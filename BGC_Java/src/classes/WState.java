package classes;

public class WState {

	public double soilw; /* (kgH2O/m2) water stored in soil */
	public double snoww; /* (kgH2O/m2) water stored in snowpack */
	public double canopyw; /* (kgH2O/m2) water stored on canopy */
	public double prcp_src; /* (kgH2O/m2) SUM of precipitation */
	public double outflow_snk; /* (kgH2O/m2) SUM of outflow */
	public double soilevap_snk; /* (kgH2O/m2) SUM of soil water evaporation */
	public double snowsubl_snk; /* (kgH2O/m2) SUM of snow water sublimation */
	public double canopyevap_snk; /*
									 * (kgH2O/m2) SUM of canopy water evaporation
									 */
	public double trans_snk; /* (kgH2O/m2) SUM of transpiration */

	public WState(double dSoilw, double dSnoww, double dCanopyw, double dPrcp_src, double dOutflow_snk,
			double dSoilevap_snk, double dSnowsubl_snk, double dCanopyevap_snk, double dTrans_snk) {
		
		this.soilw = dSoilw;
		this.snoww = dSnoww;
		this.canopyw = dCanopyw;
		this.prcp_src = dPrcp_src;
		this.outflow_snk = dOutflow_snk;
		this.soilevap_snk = dSoilevap_snk;
		this.snowsubl_snk = dSnowsubl_snk;
		this.canopyevap_snk = dCanopyevap_snk;
		this.trans_snk = dTrans_snk;

	}

}
