package classes;

public class Epconst {

	public int woody; /* (flag) 1=woody, 0=non-woody */
	public int evergreen; /* (flag) 1=evergreen, 0=deciduous */
	public int c3_flag; /* (flag) 1 = C3, 0 = C4 */
	public int phenology_flag; /* (flag) 1=phenology model, 0=user defined */
	public int onday; /* (yday) yearday leaves on */
	public int offday; /* (yday) yearday leaves off */
	public double transfer_pdays; /*
									 * (prop.) fraction of growth period for
									 * transfer
									 */
	public double litfall_pdays; /*
									 * (prop.) fraction of growth period for
									 * litfall
									 */
	public double leaf_turnover; /* (1/yr) annual leaf turnover fraction */
	public double froot_turnover; /*
									 * (1/yr) annual fine root turnover fraction
									 */
	public double livewood_turnover; /*
										 * (1/yr) annual live wood turnover
										 * fraction
										 */
	public double daily_mortality_turnover; /*
											 * (1/day) daily mortality turnover
											 */
	public double daily_fire_turnover; /* (1/day) daily fire turnover */
	public double alloc_frootc_leafc; /*
										 * (ratio) new fine root C to new leaf C
										 */
	public double alloc_newstemc_newleafc; /*
											 * (ratio) new stem C to new leaf C
											 */
	public double alloc_newlivewoodc_newwoodc; /*
												 * (ratio) new livewood C:new
												 * wood C
												 */
	public double alloc_crootc_stemc; /*
										 * (ratio) new live croot C to new live
										 * stem C
										 */
	public double alloc_prop_curgrowth; /*
										 * (prop.) daily allocation to current
										 * growth
										 */
	public double avg_proj_sla; /* (m2/kgC) canopy average proj. SLA */
	public double sla_ratio; /* (DIM) ratio of shaded to sunlit projected SLA */
	public double lai_ratio; /* (DIM) ratio of (all-sided LA / one-sided LA) */
	public double int_coef; /* (kg/kg/LAI/d) canopy precip interception coef */
	public double ext_coef; /* (DIM) canopy light extinction coefficient */
	public double flnr; /* (kg NRub/kg Nleaf) leaf N in Rubisco */
	public double psi_open; /* (MPa) psi at start of conductance reduction */
	public double psi_close; /* (MPa) psi at complete conductance reduction */
	public double vpd_open; /* (Pa) vpd at start of conductance reduction */
	public double vpd_close; /* (Pa) vpd at complete conductance reduction */
	public double gl_smax; /* (m/s) maximum leaf-scale stomatal conductance */
	public double gl_c; /* (m/s) leaf-scale cuticular conductance */
	public double gl_bl; /* (m/s) leaf-scale boundary layer conductance */
	public double froot_cn; /* (kgC/kgN) C:N for fine roots */
	public double leaf_cn; /* (kgC/kgN) C:N for leaves */
	public double livewood_cn; /* (kgC/kgN) C:N for live wood */
	public double deadwood_cn; /* (kgC/kgN) C:N for dead wood */
	public double leaflitr_cn; /* (kgC/kgN) constant C:N for leaf litter */
	public double leaflitr_flab; /* (DIM) leaf litter labile fraction */
	public double leaflitr_fucel; /*
									 * (DIM) leaf litter unshielded cellulose
									 * fract.
									 */
	public double leaflitr_fscel; /*
									 * (DIM) leaf litter shielded cellulose fract.
									 */
	public double leaflitr_flig; /* (DIM) leaf litter lignin fraction */
	public double frootlitr_flab; /* (DIM) froot litter labile fraction */
	public double frootlitr_fucel; /*
									 * (DIM) froot litter unshielded cellulose
									 * fract
									 */
	public double frootlitr_fscel; /*
									 * (DIM) froot litter shielded cellulose
									 * fract
									 */
	public double frootlitr_flig; /* (DIM) froot litter lignin fraction */
	public double deadwood_fucel; /*
									 * (DIM) dead wood unshileded cellulose
									 * fraction
									 */
	public double deadwood_fscel; /*
									 * (DIM) dead wood shielded cellulose fraction
									 */
	public double deadwood_flig; /* (DIM) dead wood lignin fraction */

	public Epconst(int nWoody, int nEvergreen, int nC3_flag, int nPhenology_flag, int nOnday, int nOffday,
			double dTransfer_pdays, double dLitfall_pdays, double dLeaf_turnover, double dFroot_turnover,
			double dLivewood_turnover, double dDaily_mortality_turnover, double dDaily_fire_turnover,
			double dAlloc_frootc_leafc, double dAlloc_newstemc_newleafc, double dAlloc_newlivewoodc_newwoodc,
			double dAlloc_crootc_stemc, double dAlloc_prop_curgrowth, double dAvg_proj_sla, double dSla_ratio,
			double dLai_ratio, double dInt_coef, double dExt_coef, double dFlnr, double dPsi_open, double dPsi_close,
			double dVpd_open, double dVpd_close, double dGl_smax, double dGl_c, double dGl_bl, double dFroot_cn,
			double dLeaf_cn, double dLivewood_cn, double dDeadwood_cn, double dLeaflitr_cn, double dLeaflitr_flab,
			double dLeaflitr_fucel, double dLeaflitr_fscel, double dLeaflitr_flig, double dFrootlitr_flab,
			double dFrootlitr_fucel, double dFrootlitr_fscel, double dFrootlitr_flig, double dDeadwood_fucel,
			double dDeadwood_fscel, double dDeadwood_flig) {

		this.woody = nWoody;
		this.evergreen = nEvergreen;
		this.c3_flag = nC3_flag;
		this.phenology_flag = nPhenology_flag;
		this.onday = nOnday;
		this.offday = nOffday;
		this.transfer_pdays = dTransfer_pdays;
		this.litfall_pdays = dLitfall_pdays;
		this.leaf_turnover = dLeaf_turnover;
		this.froot_turnover = dFroot_turnover;
		this.livewood_turnover = dLivewood_turnover;
		this.daily_mortality_turnover = dDaily_mortality_turnover;
		this.daily_fire_turnover = dDaily_fire_turnover;
		this.alloc_frootc_leafc = dAlloc_frootc_leafc;
		this.alloc_newstemc_newleafc = dAlloc_newstemc_newleafc;
		this.alloc_newlivewoodc_newwoodc = dAlloc_newlivewoodc_newwoodc;
		this.alloc_crootc_stemc = dAlloc_crootc_stemc;
		this.alloc_prop_curgrowth = dAlloc_prop_curgrowth;
		this.avg_proj_sla = dAvg_proj_sla;
		this.sla_ratio = dSla_ratio;
		this.lai_ratio = dLai_ratio;
		this.int_coef = dInt_coef;
		this.ext_coef = dExt_coef;
		this.flnr = dFlnr;
		this.psi_open = dPsi_open;
		this.psi_close = dPsi_close;
		this.vpd_open = dVpd_open;
		this.vpd_close = dVpd_close;
		this.gl_smax = dGl_smax;
		this.gl_c = dGl_c;
		this.gl_bl = dGl_bl;
		this.froot_cn = dFroot_cn;
		this.leaf_cn = dLeaf_cn;
		this.livewood_cn = dLivewood_cn;
		this.deadwood_cn = dDeadwood_cn;
		this.leaflitr_cn = dLeaflitr_cn;
		this.leaflitr_flab = dLeaflitr_flab;
		this.leaflitr_fucel = dLeaflitr_fucel;
		this.leaflitr_fscel = dLeaflitr_fscel;
		this.leaflitr_flig = dLeaflitr_flig;
		this.frootlitr_flab = dFrootlitr_flab;
		this.frootlitr_fucel = dFrootlitr_fucel;
		this.frootlitr_fscel = dFrootlitr_fscel;
		this.deadwood_fucel = dDeadwood_fucel;
		this.deadwood_fscel = dDeadwood_fscel;
		this.deadwood_flig = dDeadwood_flig;

	}
}
