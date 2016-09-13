package classes;

public class NFlux {
	/* mortality fluxes */
	public double m_leafn_to_litr1n; /* (kgN/m2/d) */
	public double m_leafn_to_litr2n; /* (kgN/m2/d) */
	public double m_leafn_to_litr3n; /* (kgN/m2/d) */
	public double m_leafn_to_litr4n; /* (kgN/m2/d) */
	public double m_frootn_to_litr1n; /* (kgN/m2/d) */
	public double m_frootn_to_litr2n; /* (kgN/m2/d) */
	public double m_frootn_to_litr3n; /* (kgN/m2/d) */
	public double m_frootn_to_litr4n; /* (kgN/m2/d) */
	public double m_leafn_storage_to_litr1n; /* (kgN/m2/d) */
	public double m_frootn_storage_to_litr1n; /* (kgN/m2/d) */
	public double m_livestemn_storage_to_litr1n; /* (kgN/m2/d) */
	public double m_deadstemn_storage_to_litr1n; /* (kgN/m2/d) */
	public double m_livecrootn_storage_to_litr1n; /* (kgN/m2/d) */
	public double m_deadcrootn_storage_to_litr1n; /* (kgN/m2/d) */
	public double m_leafn_transfer_to_litr1n; /* (kgN/m2/d) */
	public double m_frootn_transfer_to_litr1n; /* (kgN/m2/d) */
	public double m_livestemn_transfer_to_litr1n; /* (kgN/m2/d) */
	public double m_deadstemn_transfer_to_litr1n; /* (kgN/m2/d) */
	public double m_livecrootn_transfer_to_litr1n;/* (kgN/m2/d) */
	public double m_deadcrootn_transfer_to_litr1n;/* (kgN/m2/d) */
	public double m_livestemn_to_litr1n; /* (kgN/m2/d) */
	public double m_livestemn_to_cwdn; /* (kgN/m2/d) */
	public double m_deadstemn_to_cwdn; /* (kgN/m2/d) */
	public double m_livecrootn_to_litr1n; /* (kgN/m2/d) */
	public double m_livecrootn_to_cwdn; /* (kgN/m2/d) */
	public double m_deadcrootn_to_cwdn; /* (kgN/m2/d) */
	public double m_retransn_to_litr1n; /* (kgN/m2/d) */
	/* fire fluxes */
	public double m_leafn_to_fire; /* (kgN/m2/d) */
	public double m_frootn_to_fire; /* (kgN/m2/d) */
	public double m_leafn_storage_to_fire; /* (kgN/m2/d) */
	public double m_frootn_storage_to_fire; /* (kgN/m2/d) */
	public double m_livestemn_storage_to_fire; /* (kgN/m2/d) */
	public double m_deadstemn_storage_to_fire; /* (kgN/m2/d) */
	public double m_livecrootn_storage_to_fire; /* (kgN/m2/d) */
	public double m_deadcrootn_storage_to_fire; /* (kgN/m2/d) */
	public double m_leafn_transfer_to_fire; /* (kgN/m2/d) */
	public double m_frootn_transfer_to_fire; /* (kgN/m2/d) */
	public double m_livestemn_transfer_to_fire; /* (kgN/m2/d) */
	public double m_deadstemn_transfer_to_fire; /* (kgN/m2/d) */
	public double m_livecrootn_transfer_to_fire; /* (kgN/m2/d) */
	public double m_deadcrootn_transfer_to_fire; /* (kgN/m2/d) */
	public double m_livestemn_to_fire; /* (kgN/m2/d) */
	public double m_deadstemn_to_fire; /* (kgN/m2/d) */
	public double m_livecrootn_to_fire; /* (kgN/m2/d) */
	public double m_deadcrootn_to_fire; /* (kgN/m2/d) */
	public double m_retransn_to_fire; /* (kgN/m2/d) */
	public double m_litr1n_to_fire; /* (kgN/m2/d) */
	public double m_litr2n_to_fire; /* (kgN/m2/d) */
	public double m_litr3n_to_fire; /* (kgN/m2/d) */
	public double m_litr4n_to_fire; /* (kgN/m2/d) */
	public double m_cwdn_to_fire; /* (kgN/m2/d) */
	/* phenology fluxes from transfer pool */
	public double leafn_transfer_to_leafn; /* (kgN/m2/d) */
	public double frootn_transfer_to_frootn; /* (kgN/m2/d) */
	public double livestemn_transfer_to_livestemn; /* (kgN/m2/d) */
	public double deadstemn_transfer_to_deadstemn; /* (kgN/m2/d) */
	public double livecrootn_transfer_to_livecrootn; /* (kgN/m2/d) */
	public double deadcrootn_transfer_to_deadcrootn; /* (kgN/m2/d) */
	/* litterfall fluxes */
	public double leafn_to_litr1n; /* (kgN/m2/d) */
	public double leafn_to_litr2n; /* (kgN/m2/d) */
	public double leafn_to_litr3n; /* (kgN/m2/d) */
	public double leafn_to_litr4n; /* (kgN/m2/d) */
	public double leafn_to_retransn; /* (kgN/m2/d) */
	public double frootn_to_litr1n; /* (kgN/m2/d) */
	public double frootn_to_litr2n; /* (kgN/m2/d) */
	public double frootn_to_litr3n; /* (kgN/m2/d) */
	public double frootn_to_litr4n; /* (kgN/m2/d) */
	/* deposition flux */
	public double ndep_to_sminn; /* (kgN/m2/d) */
	public double nfix_to_sminn; /* (kgN/m2/d) */
	/* litter and soil decomposition fluxes */
	public double cwdn_to_litr2n; /* (kgN/m2/d) */
	public double cwdn_to_litr3n; /* (kgN/m2/d) */
	public double cwdn_to_litr4n; /* (kgN/m2/d) */
	public double litr1n_to_soil1n; /* (kgN/m2/d) */
	public double sminn_to_soil1n_l1; /* (kgN/m2/d) */
	public double litr2n_to_soil2n; /* (kgN/m2/d) */
	public double sminn_to_soil2n_l2; /* (kgN/m2/d) */
	public double litr3n_to_litr2n; /* (kgN/m2/d) */
	public double litr4n_to_soil3n; /* (kgN/m2/d) */
	public double sminn_to_soil3n_l4; /* (kgN/m2/d) */
	public double soil1n_to_soil2n; /* (kgN/m2/d) */
	public double sminn_to_soil2n_s1; /* (kgN/m2/d) */
	public double soil2n_to_soil3n; /* (kgN/m2/d) */
	public double sminn_to_soil3n_s2; /* (kgN/m2/d) */
	public double soil3n_to_soil4n; /* (kgN/m2/d) */
	public double sminn_to_soil4n_s3; /* (kgN/m2/d) */
	public double soil4n_to_sminn; /* (kgN/m2/d) */
	/* denitrification (volatilization) fluxes */
	public double sminn_to_nvol_l1s1; /* (kgN/m2/d) */
	public double sminn_to_nvol_l2s2; /* (kgN/m2/d) */
	public double sminn_to_nvol_l4s3; /* (kgN/m2/d) */
	public double sminn_to_nvol_s1s2; /* (kgN/m2/d) */
	public double sminn_to_nvol_s2s3; /* (kgN/m2/d) */
	public double sminn_to_nvol_s3s4; /* (kgN/m2/d) */
	public double sminn_to_nvol_s4; /* (kgN/m2/d) */
	public double sminn_to_denitrif; /* (kgN/m2/d) */

	/* leaching flux */
	public double sminn_leached; /* (kgN/m2/d) */
	/* daily allocation fluxes */
	public double retransn_to_npool; /* (kgN/m2/d) */
	public double sminn_to_npool; /* (kgN/m2/d) */
	public double npool_to_leafn; /* (kgN/m2/d) */
	public double npool_to_leafn_storage; /* (kgN/m2/d) */
	public double npool_to_frootn; /* (kgN/m2/d) */
	public double npool_to_frootn_storage; /* (kgN/m2/d) */
	public double npool_to_livestemn; /* (kgN/m2/d) */
	public double npool_to_livestemn_storage; /* (kgN/m2/d) */
	public double npool_to_deadstemn; /* (kgN/m2/d) */
	public double npool_to_deadstemn_storage; /* (kgN/m2/d) */
	public double npool_to_livecrootn; /* (kgN/m2/d) */
	public double npool_to_livecrootn_storage; /* (kgN/m2/d) */
	public double npool_to_deadcrootn; /* (kgN/m2/d) */
	public double npool_to_deadcrootn_storage; /* (kgN/m2/d) */
	/* annual turnover of storage to transfer */
	public double leafn_storage_to_leafn_transfer; /* (kgN/m2/d) */
	public double frootn_storage_to_frootn_transfer; /* (kgN/m2/d) */
	public double livestemn_storage_to_livestemn_transfer; /* (kgN/m2/d) */
	public double deadstemn_storage_to_deadstemn_transfer; /* (kgN/m2/d) */
	public double livecrootn_storage_to_livecrootn_transfer; /* (kgN/m2/d) */
	public double deadcrootn_storage_to_deadcrootn_transfer; /* (kgN/m2/d) */
	/* turnover of live wood to dead wood, with retranslocation */
	public double livestemn_to_deadstemn; /* (kgN/m2/d) */
	public double livestemn_to_retransn; /* (kgN/m2/d) */
	public double livecrootn_to_deadcrootn; /* (kgN/m2/d) */
	public double livecrootn_to_retransn; /* (kgN/m2/d) */

	public NFlux(double dM_leafn_to_litr1n, double dM_leafn_to_litr2n, double dM_leafn_to_litr3n,
			double dM_leafn_to_litr4n, double dM_frootn_to_litr1n, double dM_frootn_to_litr2n,
			double dM_frootn_to_litr3n, double dM_frootn_to_litr4n, double dM_leafn_storage_to_litr1n,
			double dM_frootn_storage_to_litr1n, double dM_livestemn_storage_to_litr1n,
			double dM_deadstemn_storage_to_litr1n, double dM_livecrootn_storage_to_litr1n,
			double dM_deadcrootn_storage_to_litr1n, double dM_leafn_transfer_to_litr1n,
			double dM_frootn_transfer_to_litr1n, double dM_livestemn_transfer_to_litr1n,
			double dM_deadstemn_transfer_to_litr1n, double dM_livecrootn_transfer_to_litr1n,
			double dM_deadcrootn_transfer_to_litr1n, double dM_livestemn_to_litr1n, double dM_livestemn_to_cwdn,
			double dM_deadstemn_to_cwdn, double dM_livecrootn_to_litr1n, double dM_livecrootn_to_cwdn,
			double dM_deadcrootn_to_cwdn, double dM_retransn_to_litr1n, double dM_leafn_to_fire,
			double dM_frootn_to_fire, double dM_leafn_storage_to_fire, double dM_frootn_storage_to_fire,
			double dM_livestemn_storage_to_fire, double dM_deadstemn_storage_to_fire,
			double dM_livecrootn_storage_to_fire, double dM_deadcrootn_storage_to_fire,
			double dM_leafn_transfer_to_fire, double dM_frootn_transfer_to_fire, double dM_livestemn_transfer_to_fire,
			double dM_deadstemn_transfer_to_fire, double dM_livecrootn_transfer_to_fire,
			double dM_deadcrootn_transfer_to_fire, double dM_livestemn_to_fire, double dM_deadstemn_to_fire,
			double dM_livecrootn_to_fire, double dM_deadcrootn_to_fire, double dM_retransn_to_fire,
			double dM_litr1n_to_fire, double dM_litr2n_to_fire, double dM_litr3n_to_fire, double dM_litr4n_to_fire,
			double dM_cwdn_to_fire, double dLeafn_transfer_to_leafn, double dFrootn_transfer_to_frootn,
			double dLivestemn_transfer_to_livestemn, double dDeadstemn_transfer_to_deadstemn,
			double dLivecrootn_transfer_to_livecrootn, double dDeadcrootn_transfer_to_deadcrootn,
			double dLeafn_to_litr1n, double dLeafn_to_litr2n, double dLeafn_to_litr3n, double dLeafn_to_litr4n,
			double dLeafn_to_retransn, double dFrootn_to_litr1n, double dFrootn_to_litr2n, double dFrootn_to_litr3n,
			double dFrootn_to_litr4n, double dNdep_to_sminn, double dNfix_to_sminn, double dCwdn_to_litr2n,
			double dCwdn_to_litr3n, double dCwdn_to_litr4n, double dLitr1n_to_soil1n, double dSminn_to_soil1n_l1,
			double dLitr2n_to_soil2n, double dSminn_to_soil2n_l2, double dLitr3n_to_litr2n, double dLitr4n_to_soil3n,
			double dSminn_to_soil3n_l4, double dSoil1n_to_soil2n, double dSminn_to_soil2n_s1, double dSoil2n_to_soil3n,
			double dSminn_to_soil3n_s2, double dSoil3n_to_soil4n, double dSminn_to_soil4n_s3, double dSoil4n_to_sminn,
			double dSminn_to_nvol_l1s1, double dSminn_to_nvol_l2s2, double dSminn_to_nvol_l4s3,
			double dSminn_to_nvol_s1s2, double dSminn_to_nvol_s2s3, double dSminn_to_nvol_s3s4,
			double dSminn_to_nvol_s4, double dSminn_to_denitrif, double dSminn_leached, double dRetransn_to_npool,
			double dSminn_to_npool, double dNpool_to_leafn, double dNpool_to_leafn_storage, double dNpool_to_frootn,
			double dNpool_to_frootn_storage, double dNpool_to_livestemn, double dNpool_to_livestemn_storage,
			double dNpool_to_deadstemn, double dNpool_to_deadstemn_storage, double dNpool_to_livecrootn,
			double dNpool_to_livecrootn_storage, double dNpool_to_deadcrootn, double dNpool_to_deadcrootn_storage,
			double dLeafn_storage_to_leafn_transfer, double dFrootn_storage_to_frootn_transfer,
			double dLivestemn_storage_to_livestemn_transfer, double dDeadstemn_storage_to_deadstemn_transfer,
			double dLivecrootn_storage_to_livecrootn_transfer, double dDeadcrootn_storage_to_deadcrootn_transfer,
			double dLivestemn_to_deadstemn, double dLivestemn_to_retransn, double dLivecrootn_to_deadcrootn,
			double dLivecrootn_to_retransn) {

		this.m_leafn_to_litr1n = dM_leafn_to_litr1n;
		this.m_leafn_to_litr2n = dM_leafn_to_litr2n;
		this.m_leafn_to_litr3n = dM_leafn_to_litr3n;
		this.m_leafn_to_litr4n = dM_leafn_to_litr4n;
		this.m_frootn_to_litr1n = dM_frootn_to_litr1n;
		this.m_frootn_to_litr2n = dM_frootn_to_litr2n;
		this.m_frootn_to_litr3n = dM_frootn_to_litr3n;
		this.m_frootn_to_litr4n = dM_frootn_to_litr4n;
		this.m_leafn_storage_to_litr1n = dM_leafn_storage_to_litr1n;
		this.m_frootn_storage_to_litr1n = dM_frootn_storage_to_litr1n;
		this.m_livestemn_storage_to_litr1n = dM_livestemn_storage_to_litr1n;
		this.m_deadstemn_storage_to_litr1n = dM_deadstemn_storage_to_litr1n;
		this.m_livecrootn_storage_to_litr1n = dM_livecrootn_storage_to_litr1n;
		this.m_deadcrootn_storage_to_litr1n = dM_deadcrootn_storage_to_litr1n;
		this.m_leafn_transfer_to_litr1n = dM_leafn_transfer_to_litr1n;
		this.m_frootn_transfer_to_litr1n = dM_frootn_transfer_to_litr1n;
		this.m_livestemn_transfer_to_litr1n = dM_livestemn_transfer_to_litr1n;
		this.m_deadstemn_transfer_to_litr1n = dM_deadstemn_transfer_to_litr1n;
		this.m_livecrootn_transfer_to_litr1n = dM_livecrootn_transfer_to_litr1n;
		this.m_deadcrootn_transfer_to_litr1n = dM_deadcrootn_transfer_to_litr1n;
		this.m_livestemn_to_litr1n = dM_livestemn_to_litr1n;
		this.m_livestemn_to_cwdn = dM_livestemn_to_cwdn;
		this.m_deadstemn_to_cwdn = dM_deadstemn_to_cwdn;
		this.m_livecrootn_to_litr1n = dM_livecrootn_to_litr1n;
		this.m_livecrootn_to_cwdn = dM_livecrootn_to_cwdn;
		this.m_deadcrootn_to_cwdn = dM_deadcrootn_to_cwdn;
		this.m_retransn_to_litr1n = dM_retransn_to_litr1n;
		this.m_leafn_to_fire = dM_leafn_to_fire;
		this.m_frootn_to_fire = dM_frootn_to_fire;
		this.m_leafn_storage_to_fire = dM_leafn_storage_to_fire;
		this.m_frootn_storage_to_fire = dM_frootn_storage_to_fire;
		this.m_livestemn_storage_to_fire = dM_livestemn_storage_to_fire;
		this.m_deadstemn_storage_to_fire = dM_deadstemn_storage_to_fire;
		this.m_livecrootn_storage_to_fire = dM_livecrootn_storage_to_fire;
		this.m_deadcrootn_storage_to_fire = dM_deadcrootn_storage_to_fire;
		this.m_leafn_transfer_to_fire = dM_leafn_transfer_to_fire;
		this.m_frootn_transfer_to_fire = dM_frootn_transfer_to_fire;
		this.m_livestemn_transfer_to_fire = dM_livestemn_transfer_to_fire;
		this.m_deadstemn_transfer_to_fire = dM_deadstemn_transfer_to_fire;
		this.m_livecrootn_transfer_to_fire = dM_livecrootn_transfer_to_fire;
		this.m_deadcrootn_transfer_to_fire = dM_deadcrootn_transfer_to_fire;
		this.m_livestemn_to_fire = dM_livestemn_to_fire;
		this.m_deadstemn_to_fire = dM_deadstemn_to_fire;
		this.m_livecrootn_to_fire = dM_livecrootn_to_fire;
		this.m_deadcrootn_to_fire = dM_deadcrootn_to_fire;
		this.m_retransn_to_fire = dM_retransn_to_fire;
		this.m_litr1n_to_fire = dM_litr1n_to_fire;
		this.m_litr2n_to_fire = dM_litr2n_to_fire;
		this.m_litr3n_to_fire = dM_litr3n_to_fire;
		this.m_litr4n_to_fire = dM_litr4n_to_fire;
		this.m_cwdn_to_fire = dM_cwdn_to_fire;
		this.leafn_transfer_to_leafn = dLeafn_transfer_to_leafn;
		this.frootn_transfer_to_frootn = dFrootn_transfer_to_frootn;
		this.livestemn_transfer_to_livestemn = dLivestemn_transfer_to_livestemn;
		this.deadstemn_transfer_to_deadstemn = dDeadstemn_transfer_to_deadstemn;
		this.livecrootn_transfer_to_livecrootn = dLivecrootn_transfer_to_livecrootn;
		this.deadcrootn_transfer_to_deadcrootn = dDeadcrootn_transfer_to_deadcrootn;
		this.leafn_to_litr1n = dLeafn_to_litr1n;
		this.leafn_to_litr2n = dLeafn_to_litr2n;
		this.leafn_to_litr3n = dLeafn_to_litr3n;
		this.leafn_to_litr4n = dLeafn_to_litr4n;
		this.leafn_to_retransn = dLeafn_to_retransn;
		this.frootn_to_litr1n = dFrootn_to_litr1n;
		this.frootn_to_litr2n = dFrootn_to_litr2n;
		this.frootn_to_litr3n = dFrootn_to_litr3n;
		this.frootn_to_litr4n = dFrootn_to_litr4n;
		this.ndep_to_sminn = dNdep_to_sminn;
		this.nfix_to_sminn = dNfix_to_sminn;
		this.cwdn_to_litr2n = dCwdn_to_litr2n;
		this.cwdn_to_litr3n = dCwdn_to_litr3n;
		this.cwdn_to_litr4n = dCwdn_to_litr4n;
		this.litr1n_to_soil1n = dLitr1n_to_soil1n;
		this.sminn_to_soil1n_l1 = dSminn_to_soil1n_l1;
		this.litr2n_to_soil2n = dLitr2n_to_soil2n;
		this.sminn_to_soil2n_l2 = dSminn_to_soil2n_l2;
		this.litr3n_to_litr2n = dLitr3n_to_litr2n;
		this.litr4n_to_soil3n = dLitr4n_to_soil3n;
		this.sminn_to_soil3n_l4 = dSminn_to_soil3n_l4;
		this.soil1n_to_soil2n = dSoil1n_to_soil2n;
		this.sminn_to_soil2n_s1 = dSminn_to_soil2n_s1;
		this.soil2n_to_soil3n = dSoil2n_to_soil3n;
		this.sminn_to_soil3n_s2 = dSminn_to_soil3n_s2;
		this.soil3n_to_soil4n = dSoil3n_to_soil4n;
		this.sminn_to_soil4n_s3 = dSminn_to_soil4n_s3;
		this.soil4n_to_sminn = dSoil4n_to_sminn;
		this.sminn_to_nvol_l1s1 = dSminn_to_nvol_l1s1;
		this.sminn_to_nvol_l2s2 = dSminn_to_nvol_l2s2;
		this.sminn_to_nvol_l4s3 = dSminn_to_nvol_l4s3;
		this.sminn_to_nvol_s1s2 = dSminn_to_nvol_s1s2;
		this.sminn_to_nvol_s2s3 = dSminn_to_nvol_s2s3;
		this.sminn_to_nvol_s3s4 = dSminn_to_nvol_s3s4;
		this.sminn_to_nvol_s4 = dSminn_to_nvol_s4;
		this.sminn_to_denitrif = dSminn_to_denitrif;
		this.sminn_leached = dSminn_leached;
		this.retransn_to_npool = dRetransn_to_npool;
		this.sminn_to_npool = dSminn_to_npool;
		this.npool_to_leafn = dNpool_to_leafn;
		this.npool_to_leafn_storage = dNpool_to_leafn_storage;
		this.npool_to_frootn = dNpool_to_frootn;
		this.npool_to_frootn_storage = dNpool_to_frootn_storage;
		this.npool_to_livestemn = dNpool_to_livestemn;
		this.npool_to_livestemn_storage = dNpool_to_livestemn_storage;
		this.npool_to_deadstemn = dNpool_to_deadstemn;
		this.npool_to_deadstemn_storage = dNpool_to_deadstemn_storage;
		this.npool_to_livecrootn = dNpool_to_livecrootn;
		this.npool_to_livecrootn_storage = dNpool_to_livecrootn_storage;
		this.npool_to_deadcrootn = dNpool_to_deadcrootn;
		this.npool_to_deadcrootn_storage = dNpool_to_deadcrootn_storage;
		this.leafn_storage_to_leafn_transfer = dLeafn_storage_to_leafn_transfer;
		this.frootn_storage_to_frootn_transfer = dFrootn_storage_to_frootn_transfer;
		this.livestemn_storage_to_livestemn_transfer = dLivestemn_storage_to_livestemn_transfer;
		this.deadstemn_storage_to_deadstemn_transfer = dDeadstemn_storage_to_deadstemn_transfer;
		this.livecrootn_storage_to_livecrootn_transfer = dLivecrootn_storage_to_livecrootn_transfer;
		this.deadcrootn_storage_to_deadcrootn_transfer = dDeadcrootn_storage_to_deadcrootn_transfer;
		this.livestemn_to_deadstemn = dLivestemn_to_deadstemn;
		this.livestemn_to_retransn = dLivestemn_to_retransn;
		this.livecrootn_to_deadcrootn = dLivecrootn_to_deadcrootn;
		this.livecrootn_to_retransn = dLivecrootn_to_retransn;

	}

}
