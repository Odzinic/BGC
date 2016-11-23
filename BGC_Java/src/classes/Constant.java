package classes;

public enum Constant {

	/* atmospheric constants */
	/*
	 * from the definition of the standard atmosphere, as established by the
	 * International Civil Aviation Organization, and referenced in:
	 * 
	 * Iribane, J.V., and W.L. Godson, 1981. Atmospheric Thermodynamics. 2nd
	 * Edition. D. Reidel Publishing Company, Dordrecht, The Netherlands. pp
	 * 10,167-168,245)
	 */
	G_STD(9.80665), /* m/s2) standard gravitational accel. */
	P_STD(101325.0), /* Pa) standard pressure at 0.0 m elevation */
	T_STD(288.15), /* K) standard temp at 0.0 m elevation */
	MA(28.9644e-3), /* kg/mol) molecular weight of air */
	MW(18.0148e-3), /* kg/mol) molecular weight of water */
	CP(1010.0), /* J/kg K) specific heat of air */
	LR_STD(0.0065), /* -K/m) standard temperature lapse rate */
	R(8.3143), /* m3 Pa/ mol K) gas law constant */
	SBC(5.67e-8), /* W/m2 K4)) Stefan-Boltzmann constant */
	EPS(0.6219), /* MW/MA) unitless ratio of molec weights */

	/* ecosystem constants */
	RAD2PAR(0.45), /* DIM) ratio PAR / SWtotal */
	EPAR(4.55), /* umol/J) PAR photon energy ratio */
	SOIL1_CN(12.0), /* C:N for fast microbial recycling pool */
	SOIL2_CN(12.0), /* C:N for slow microbial recycling pool */
	SOIL3_CN(10.0), /* C:N for recalcitrant SOM pool humus) */
	SOIL4_CN(10.0), /* C:N for recalcitrant SOM pool humus) */
	GRPERC(0.3), /* DIM) growth resp per unit of C grown */
	GRPNOW(1.0), /* DIM) proportion of storage growth resp at fixation */
	PPFD50(75.0), /* umol/m2/s) PPFD for 1/2 stomatal closure */
	DENITRIF_PROPORTION(0.01), /* fraction of mineralization to volatile */
	MOBILEN_PROPORTION(0.1), /* fraction mineral N avail for leaching */

	/*
	 * use this block of constants to include the dynamics for slowest soil pool
	 * s4)
	 */
	/* respiration fractions for fluxes between compartments unitless) */
	RFL1S1(0.39), /* transfer from litter 1 to soil 1 */
	RFL2S2(0.55), /* transfer from litter 2 to soil 2 */
	RFL4S3(0.29), /* transfer from litter 4 to soil 3 */
	RFS1S2(0.28), /* transfer from soil 1 to soil 2 */
	RFS2S3(0.46), /* transfer from soil 2 to soil 3 */
	RFS3S4(0.55), /* transfer from soil 3 to soil 4 */
	/* base decomposition rate constants 1/day) */
	KL1_BASE(0.7), /* labile litter pool */
	KL2_BASE(0.07), /* cellulose litter pool */
	KL4_BASE(0.014), /* lignin litter pool */
	KS1_BASE(0.07), /* fast microbial recycling pool */
	KS2_BASE(0.014), /* medium microbial recycling pool */
	KS3_BASE(0.0014), /* slow microbial recycling pool */
	KS4_BASE(0.0001), /* recalcitrant SOM humus) pool */
	KFRAG_BASE(0.001), /* physical fragmentation of coarse woody debris */

	/*
	 * use this block of constants to exclude the dynamics for slowest soil pool
	 * s4)
	 */
	/* respiration fractions for fluxes between compartments unitless) */
	/* public double RFL1S1 0.39 */ /* transfer from litter 1 to soil 1 */
	/* public double RFL2S2 0.55 */ /* transfer from litter 2 to soil 2 */
	/* public double RFL4S3 0.29 */ /* transfer from litter 4 to soil 3 */
	/* public double RFS1S2 0.28 */ /* transfer from soil 1 to soil 2 */
	/* public double RFS2S3 0.46 */ /* transfer from soil 2 to soil 3 */
	/* public double RFS3S4 1.00 */ /* transfer from soil 3 to soil 4 */
	/* base decomposition rate constants 1/day) */
	/* KL1_BASE 0.7 */ /* labile litter pool */
	/* KL2_BASE 0.07 */ /* cellulose litter pool */
	/* KL4_BASE 0.014 */ /* lignin litter pool */
	/* KS1_BASE 0.07 */ /* fast microbial recycling pool */
	/* KS2_BASE 0.014 */ /* medium microbial recycling pool */
	/* KS3_BASE 0.0005 */ /* slow microbial recycling pool */
	/* KS4_BASE 0.0000 */ /* recalcitrant SOM humus) pool */

	/* precision control */
	/*
	 * This constant determines the lower limit of state variables before they
	 * are set to 0.0 to control rounding and overflow errors
	 */
	CRIT_PREC(1e-20),

	/* spinup control */
	/* maximum allowable trend in slow soil carbon at steady-state kgC/m2/yr) */
	SPINUP_TOLERANCE(0.0005), MODE_INI(0), MODE_SPINUP(1), MODE_MODEL(2), MODE_SPINNGO(3),

	/* output control constants */
	NMAP(700),

	/* For modifying summary output as per pan-arctic bgc */
	SANE(1), INSANE(0),

	/* Verbosity keywords. BV: Bgc Verbosity */
	BV_SILENT(-1), BV_ERROR(0), BV_WARN(1), BV_PROGRESS(2), BV_DETAIL(3), BV_DIAG(4),

	DAYSNDEPLOY(365.0), DAYSCRECOVER(365.0), BULK_DENITRIF_PROPORTION(0.5),
	FLT_COND_TOL(1e-10);

	private double value;

	private Constant(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

}
