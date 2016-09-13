package classes;

public class CState {

	public double leafc; /* (kgC/m2) leaf C */
	public double leafc_storage; /* (kgC/m2) leaf C storage */
	public double leafc_transfer; /* (kgC/m2) leaf C transfer */
	public double frootc; /* (kgC/m2) fine root C */
	public double frootc_storage; /* (kgC/m2) fine root C storage */
	public double frootc_transfer; /* (kgC/m2) fine root C transfer */
	public double livestemc; /* (kgC/m2) live stem C */
	public double livestemc_storage; /* (kgC/m2) live stem C storage */
	public double livestemc_transfer; /* (kgC/m2) live stem C transfer */
	public double deadstemc; /* (kgC/m2) dead stem C */
	public double deadstemc_storage; /* (kgC/m2) dead stem C storage */
	public double deadstemc_transfer; /* (kgC/m2) dead stem C transfer */
	public double livecrootc; /* (kgC/m2) live coarse root C */
	public double livecrootc_storage; /* (kgC/m2) live coarse root C storage */
	public double livecrootc_transfer;/* (kgC/m2) live coarse root C transfer */
	public double deadcrootc; /* (kgC/m2) dead coarse root C */
	public double deadcrootc_storage; /* (kgC/m2) dead coarse root C storage */
	public double deadcrootc_transfer;/* (kgC/m2) dead coarse root C transfer */
	public double gresp_storage; /* (kgC/m2) growth respiration storage */
	public double gresp_transfer; /* (kgC/m2) growth respiration transfer */
	public double cwdc; /* (kgC/m2) coarse woody debris C */
	public double litr1c; /* (kgC/m2) litter labile C */
	public double litr2c; /* (kgC/m2) litter unshielded cellulose C */
	public double litr3c; /* (kgC/m2) litter shielded cellulose C */
	public double litr4c; /* (kgC/m2) litter lignin C */
	public double soil1c; /* (kgC/m2) microbial recycling pool C (fast) */
	public double soil2c; /* (kgC/m2) microbial recycling pool C (medium) */
	public double soil3c; /* (kgC/m2) microbial recycling pool C (slow) */
	public double soil4c; /* (kgC/m2) recalcitrant SOM C (humus, slowest) */
	public double cpool; /* (kgC/m2) temporary photosynthate C pool */
	public double psnsun_src; /* (kgC/m2) SUM of gross PSN from sulit canopy */
	public double psnshade_src; /*
								 * (kgC/m2) SUM of gross PSN from shaded canopy
								 */
	public double leaf_mr_snk; /* (kgC/m2) SUM of leaf maint resp */
	public double leaf_gr_snk; /* (kgC/m2) SUM of leaf growth resp */
	public double froot_mr_snk; /* (kgC/m2) SUM of fine root maint resp */
	public double froot_gr_snk; /* (kgC/m2) SUM of fine root growth resp */
	public double livestem_mr_snk; /* (kgC/m2) SUM of live stem maint resp */
	public double livestem_gr_snk; /* (kgC/m2) SUM of live stem growth resp */
	public double deadstem_gr_snk; /* (kgC/m2) SUM of dead stem growth resp */
	public double livecroot_mr_snk; /*
									 * (kgC/m2) SUM of live coarse root maint
									 * resp
									 */
	public double livecroot_gr_snk; /*
									 * (kgC/m2) SUM of live coarse root growth
									 * resp
									 */
	public double deadcroot_gr_snk; /*
									 * (kgC/m2) SUM of dead coarse root growth
									 * resp
									 */
	public double litr1_hr_snk; /* (kgC/m2) SUM of labile litr microbial resp */
	public double litr2_hr_snk; /*
								 * (kgC/m2) SUM of cellulose litr microbial resp
								 */
	public double litr4_hr_snk; /* (kgC/m2) SUM of lignin litr microbial resp */
	public double soil1_hr_snk; /* (kgC/m2) SUM of fast microbial respiration */
	public double soil2_hr_snk; /*
								 * (kgC/m2) SUM of medium microbial respiration
								 */
	public double soil3_hr_snk; /* (kgC/m2) SUM of slow microbial respiration */
	public double soil4_hr_snk; /*
								 * (kgC/m2) SUM of recalcitrant SOM respiration
								 */
	public double fire_snk; /* (kgC/m2) SUM of fire losses */

	public CState(double dLeafc, double dLeafc_storage, double dLeafc_transfer, double dFrootc, double dFrootc_storage,
			double dFrootc_transfer, double dLivestemc, double dLivestemc_storage, double dLivestemc_transfer,
			double dDeadstemc, double dDeadstemc_storage, double dDeadstemc_transfer, double dLivecrootc,
			double dLivecrootc_storage, double dLivecrootc_transfer, double dDeadcrootc, double dDeadcrootc_storage,
			double dDeadcrootc_transfer, double dGresp_storage, double dGresp_transfer, double dCwdc, double dLitr1c,
			double dLitr2c, double dLitr3c, double dLitr4c, double dSoil1c, double dSoil2c, double dSoil3c,
			double dSoil4c, double dCpool, double dPsnsun_src, double dPsnshade_src, double dLeaf_mr_snk,
			double dLeaf_gr_snk, double dFroot_mr_snk, double dFroot_gr_snk, double dLivestem_mr_snk,
			double dLivestem_gr_snk, double dDeadstem_gr_snk, double dLivecroot_mr_snk, double dLivecroot_gr_snk,
			double dDeadcroot_gr_snk, double dLitr1_hr_snk, double dLitr2_hr_snk, double dLitr4_hr_snk,
			double dSoil1_hr_snk, double dSoil2_hr_snk, double dSoil3_hr_snk, double dSoil4_hr_snk, double dFire_snk) {

		this.leafc = dLeafc;
		this.leafc_storage = dLeafc_storage;
		this.leafc_transfer = dLeafc_transfer;
		this.frootc = dFrootc;
		this.frootc_storage = dFrootc_storage;
		this.frootc_transfer = dFrootc_transfer;
		this.livestemc = dLivestemc;
		this.livestemc_storage = dLivestemc_storage;
		this.livestemc_transfer = dLivestemc_transfer;
		this.deadstemc = dDeadstemc;
		this.deadstemc_storage = dDeadstemc_storage;
		this.deadstemc_transfer = dDeadstemc_transfer;
		this.livecrootc = dLivecrootc;
		this.livecrootc_storage = dLivecrootc_storage;
		this.livecrootc_transfer = dLivecrootc_transfer;
		this.deadcrootc = dDeadcrootc;
		this.deadcrootc_storage = dDeadcrootc_storage;
		this.deadcrootc_transfer = dDeadcrootc_transfer;
		this.gresp_storage = dGresp_storage;
		this.gresp_transfer = dGresp_transfer;
		this.cwdc = dCwdc;
		this.litr1c = dLitr1c;
		this.litr2c = dLitr2c;
		this.litr3c = dLitr3c;
		this.litr4c = dLitr4c;
		this.soil1c = dSoil1c;
		this.soil2c = dSoil2c;
		this.soil3c = dSoil3c;
		this.soil4c = dSoil4c;
		this.cpool = dCpool;
		this.psnsun_src = dPsnsun_src;
		this.psnshade_src = dPsnshade_src;
		this.leaf_mr_snk = dLeaf_mr_snk;
		this.leaf_gr_snk = dLeaf_gr_snk;
		this.froot_mr_snk = dFroot_mr_snk;
		this.froot_gr_snk = dFroot_gr_snk;
		this.livestem_mr_snk = dLivestem_mr_snk;
		this.livestem_gr_snk = dLivestem_gr_snk;
		this.deadstem_gr_snk = dDeadstem_gr_snk;
		this.livecroot_mr_snk = dLivecroot_mr_snk;
		this.livecroot_gr_snk = dLivecroot_gr_snk;
		this.deadcroot_gr_snk = dDeadcroot_gr_snk;
		this.litr1_hr_snk = dLitr1_hr_snk;
		this.litr2_hr_snk = dLitr2_hr_snk;
		this.litr4_hr_snk = dLitr4_hr_snk;
		this.soil1_hr_snk = dSoil1_hr_snk;
		this.soil2_hr_snk = dSoil2_hr_snk;
		this.soil3_hr_snk = dSoil3_hr_snk;
		this.soil4_hr_snk = dSoil4_hr_snk;
		this.fire_snk = dFire_snk;
	}

}
