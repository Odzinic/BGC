package classes;

public class Siteconst {

	public double soil_depth; /* (m) effective depth of rooting zone */
	public double soil_b; /* (DIM) Clapp-Hornberger "b" parameter */
	public double vwc_sat; /* (DIM) volumetric water content at saturation */
	public double vwc_fc; /* (DIM) VWC at field capacity ( = -0.015 MPa) */
	public double psi_sat; /* (MPa) soil matric potential at saturation */
	public double soilw_sat; /* (kgH2O/m2) soilwater at saturation */
	public double soilw_fc; /* (kgH2O/m2) soilwater at field capacity */
	public double elev; /* (m) site elevation */
	public double lat; /* (degrees) site latitude (negative for south) */
	public double sw_alb; /* (DIM) surface shortwave albedo */
	public double ndep; /* (kgN/m2/yr) wet+dry atmospheric deposition of N */
	public double nfix; /* (kgN/m2/yr) symbiotic+asymbiotic fixation of N */

	public Siteconst(double dSoil_depth, double dSoil_b, double dVwc_sat, double dVwc_fc, double dPsi_sat,
			double dSoilw_sat, double dSoilw_fc, double dElev, double dLat, double dSw_alb, double dNdep,
			double dNfix) {

		this.soil_depth = dSoil_depth;
		this.soil_b = dSoil_b;
		this.vwc_sat = dVwc_sat;
		this.vwc_fc = dVwc_fc;
		this.psi_sat = dPsi_sat;
		this.soilw_sat = dSoilw_sat;
		this.soilw_fc = dSoilw_fc;
		this.elev = dElev;
		this.lat = dLat;
		this.sw_alb = dSw_alb;
		this.ndep = dNdep;
		this.nfix = dNfix;
	}

}
