package classes;

import classes.Sub_CFlux;

public class CFlux {

	public double m_leafc_to_litr1c; /* (kgC/m2/d) */
	public double m_leafc_to_litr2c; /* (kgC/m2/d) */
	public double m_leafc_to_litr3c; /* (kgC/m2/d) */
	public double m_leafc_to_litr4c; /* (kgC/m2/d) */
	public double m_frootc_to_litr1c; /* (kgC/m2/d) */
	public double m_frootc_to_litr2c; /* (kgC/m2/d) */
	public double m_frootc_to_litr3c; /* (kgC/m2/d) */
	public double m_frootc_to_litr4c; /* (kgC/m2/d) */
	public double m_leafc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_frootc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_livestemc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_deadstemc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_livecrootc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_deadcrootc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_leafc_transfer_to_litr1c; /* (kgC/m2/d) */
	public double m_frootc_transfer_to_litr1c; /* (kgC/m2/d) */
	public double m_livestemc_transfer_to_litr1c; /* (kgC/m2/d) */
	public double m_deadstemc_transfer_to_litr1c; /* (kgC/m2/d) */
	public double m_livecrootc_transfer_to_litr1c;/* (kgC/m2/d) */
	public double m_deadcrootc_transfer_to_litr1c;/* (kgC/m2/d) */
	public double m_livestemc_to_cwdc; /* (kgC/m2/d) */
	public double m_deadstemc_to_cwdc; /* (kgC/m2/d) */
	public double m_livecrootc_to_cwdc; /* (kgC/m2/d) */
	public double m_deadcrootc_to_cwdc; /* (kgC/m2/d) */
	public double m_gresp_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_gresp_transfer_to_litr1c; /* (kgC/m2/d) */
	/* fire fluxes */
	public double m_leafc_to_fire; /* (kgC/m2/d) */
	public double m_frootc_to_fire; /* (kgC/m2/d) */
	public double m_leafc_storage_to_fire; /* (kgC/m2/d) */
	public double m_frootc_storage_to_fire; /* (kgC/m2/d) */
	public double m_livestemc_storage_to_fire; /* (kgC/m2/d) */
	public double m_deadstemc_storage_to_fire; /* (kgC/m2/d) */
	public double m_livecrootc_storage_to_fire; /* (kgC/m2/d) */
	public double m_deadcrootc_storage_to_fire; /* (kgC/m2/d) */
	public double m_leafc_transfer_to_fire; /* (kgC/m2/d) */
	public double m_frootc_transfer_to_fire; /* (kgC/m2/d) */
	public double m_livestemc_transfer_to_fire; /* (kgC/m2/d) */
	public double m_deadstemc_transfer_to_fire; /* (kgC/m2/d) */
	public double m_livecrootc_transfer_to_fire; /* (kgC/m2/d) */
	public double m_deadcrootc_transfer_to_fire; /* (kgC/m2/d) */
	public double m_livestemc_to_fire; /* (kgC/m2/d) */
	public double m_deadstemc_to_fire; /* (kgC/m2/d) */
	public double m_livecrootc_to_fire; /* (kgC/m2/d) */
	public double m_deadcrootc_to_fire; /* (kgC/m2/d) */
	public double m_gresp_storage_to_fire; /* (kgC/m2/d) */
	public double m_gresp_transfer_to_fire; /* (kgC/m2/d) */
	public double m_litr1c_to_fire; /* (kgC/m2/d) */
	public double m_litr2c_to_fire; /* (kgC/m2/d) */
	public double m_litr3c_to_fire; /* (kgC/m2/d) */
	public double m_litr4c_to_fire; /* (kgC/m2/d) */
	public double m_cwdc_to_fire; /* (kgC/m2/d) */
	/* phenology fluxes from transfer pool */
	public double leafc_transfer_to_leafc; /* (kgC/m2/d) */
	public double frootc_transfer_to_frootc; /* (kgC/m2/d) */
	public double livestemc_transfer_to_livestemc; /* (kgC/m2/d) */
	public double deadstemc_transfer_to_deadstemc; /* (kgC/m2/d) */
	public double livecrootc_transfer_to_livecrootc;/* (kgC/m2/d) */
	public double deadcrootc_transfer_to_deadcrootc;/* (kgC/m2/d) */
	/* leaf and fine root litterfall */
	public double leafc_to_litr1c; /* (kgC/m2/d) */
	public double leafc_to_litr2c; /* (kgC/m2/d) */
	public double leafc_to_litr3c; /* (kgC/m2/d) */
	public double leafc_to_litr4c; /* (kgC/m2/d) */
	public double frootc_to_litr1c; /* (kgC/m2/d) */
	public double frootc_to_litr2c; /* (kgC/m2/d) */
	public double frootc_to_litr3c; /* (kgC/m2/d) */
	public double frootc_to_litr4c; /* (kgC/m2/d) */
	/* maintenance respiration fluxes */
	public double leaf_day_mr; /* (kgC/m2/d) */
	public double leaf_night_mr; /* (kgC/m2/d) */
	public double froot_mr; /* (kgC/m2/d) */
	public double livestem_mr; /* (kgC/m2/d) */
	public double livecroot_mr; /* (kgC/m2/d) */
	/* photosynthesis flux */
	public double psnsun_to_cpool; /* (kgC/m2/d) */
	public double psnshade_to_cpool; /* (kgC/m2/d) */
	/* litter decomposition fluxes */
	public double cwdc_to_litr2c; /* (kgC/m2/d) */
	public double cwdc_to_litr3c; /* (kgC/m2/d) */
	public double cwdc_to_litr4c; /* (kgC/m2/d) */
	public double litr1_hr; /* (kgC/m2/d) */
	public double litr1c_to_soil1c; /* (kgC/m2/d) */
	public double litr2_hr; /* (kgC/m2/d) */
	public double litr2c_to_soil2c; /* (kgC/m2/d) */
	public double litr3c_to_litr2c; /* (kgC/m2/d) */
	public double litr4_hr; /* (kgC/m2/d) */
	public double litr4c_to_soil3c; /* (kgC/m2/d) */
	public double soil1_hr; /* (kgC/m2/d) */
	public double soil1c_to_soil2c; /* (kgC/m2/d) */
	public double soil2_hr; /* (kgC/m2/d) */
	public double soil2c_to_soil3c; /* (kgC/m2/d) */
	public double soil3_hr; /* (kgC/m2/d) */
	public double soil3c_to_soil4c; /* (kgC/m2/d) */
	public double soil4_hr; /* (kgC/m2/d) */
	/* daily allocation fluxes from current GPP */
	public double cpool_to_leafc; /* (kgC/m2/d) */
	public double cpool_to_leafc_storage; /* (kgC/m2/d) */
	public double cpool_to_frootc; /* (kgC/m2/d) */
	public double cpool_to_frootc_storage; /* (kgC/m2/d) */
	public double cpool_to_livestemc; /* (kgC/m2/d) */
	public double cpool_to_livestemc_storage; /* (kgC/m2/d) */
	public double cpool_to_deadstemc; /* (kgC/m2/d) */
	public double cpool_to_deadstemc_storage; /* (kgC/m2/d) */
	public double cpool_to_livecrootc; /* (kgC/m2/d) */
	public double cpool_to_livecrootc_storage; /* (kgC/m2/d) */
	public double cpool_to_deadcrootc; /* (kgC/m2/d) */
	public double cpool_to_deadcrootc_storage; /* (kgC/m2/d) */
	public double cpool_to_gresp_storage; /* (kgC/m2/d) */
	/* daily growth respiration fluxes */
	public double cpool_leaf_gr; /* (kgC/m2/d) */
	public double cpool_leaf_storage_gr; /* (kgC/m2/d) */
	public double transfer_leaf_gr; /* (kgC/m2/d) */
	public double cpool_froot_gr; /* (kgC/m2/d) */
	public double cpool_froot_storage_gr; /* (kgC/m2/d) */
	public double transfer_froot_gr; /* (kgC/m2/d) */
	public double cpool_livestem_gr; /* (kgC/m2/d) */
	public double cpool_livestem_storage_gr; /* (kgC/m2/d) */
	public double transfer_livestem_gr; /* (kgC/m2/d) */
	public double cpool_deadstem_gr; /* (kgC/m2/d) */
	public double cpool_deadstem_storage_gr; /* (kgC/m2/d) */
	public double transfer_deadstem_gr; /* (kgC/m2/d) */
	public double cpool_livecroot_gr; /* (kgC/m2/d) */
	public double cpool_livecroot_storage_gr; /* (kgC/m2/d) */
	public double transfer_livecroot_gr; /* (kgC/m2/d) */
	public double cpool_deadcroot_gr; /* (kgC/m2/d) */
	public double cpool_deadcroot_storage_gr; /* (kgC/m2/d) */
	public double transfer_deadcroot_gr; /* (kgC/m2/d) */
	/* annual turnover of storage to transfer pools */
	public double leafc_storage_to_leafc_transfer; /* (kgC/m2/d) */
	public double frootc_storage_to_frootc_transfer; /* (kgC/m2/d) */
	public double livestemc_storage_to_livestemc_transfer; /* (kgC/m2/d) */
	public double deadstemc_storage_to_deadstemc_transfer; /* (kgC/m2/d) */
	public double livecrootc_storage_to_livecrootc_transfer; /* (kgC/m2/d) */ /*
																			 * CHANGED
																			 * TO
																			 * INT
																			 * TO
																			 * PREVENT
																			 * ERROR
																			 */
	public double deadcrootc_storage_to_deadcrootc_transfer; /* (kgC/m2/d) */ /*
																			 * CHANGED
																			 * TO
																			 * INT
																			 * TO
																			 * PREVENT
																			 * ERROR
																			 */
	public double gresp_storage_to_gresp_transfer; /* (kgC/m2/d) */ /*
																	 * CHANGED TO
																	 * INT TO
																	 * PREVENT
																	 * ERROR
																	 */
	/* turnover of live wood to dead wood */ /*
												 * CHANGED TO INT TO PREVENT ERROR
												 */
	public double livestemc_to_deadstemc; /* (kgC/m2/d) */ /*
															 * CHANGED TO INT TO
															 * PREVENT ERROR
															 */
	public double livecrootc_to_deadcrootc; /* (kgC/m2/d) */ /*
																 * CHANGED TO INT
																 * TO PREVENT
																 * ERROR
																 */

	public CFlux(double dM_leafc_to_litr1c, double dM_leafc_to_litr2c, double dM_leafc_to_litr3c,
                 double dM_leafc_to_litr4c, double dM_frootc_to_litr1c, double dM_frootc_to_litr2c,
                 double dM_frootc_to_litr3c, double dM_frootc_to_litr4c, double dM_leafc_storage_to_litr1c,
                 double dM_frootc_storage_to_litr1c, double dM_livestemc_storage_to_litr1c,
                 double dM_deadstemc_storage_to_litr1c, double dM_livecrootc_storage_to_litr1c,
                 double dM_deadcrootc_storage_to_litr1c, double dM_leafc_transfer_to_litr1c,
                 double dM_frootc_transfer_to_litr1c, double dM_livestemc_transfer_to_litr1c,
                 double dM_deadstemc_transfer_to_litr1c, double dM_livecrootc_transfer_to_litr1c,
                 double dM_deadcrootc_transfer_to_litr1c, double dM_livestemc_to_cwdc, double dM_deadstemc_to_cwdc,
                 double dM_livecrootc_to_cwdc, double dM_deadcrootc_to_cwdc, double dM_gresp_storage_to_litr1c,
                 double dM_gresp_transfer_to_litr1c, double dM_leafc_to_fire, double dM_frootc_to_fire,
                 double dM_leafc_storage_to_fire, double dM_frootc_storage_to_fire, double dM_livestemc_storage_to_fire,
                 double dM_deadstemc_storage_to_fire, double dM_livecrootc_storage_to_fire,
                 double dM_deadcrootc_storage_to_fire, double dM_leafc_transfer_to_fire, double dM_frootc_transfer_to_fire,
                 double dM_livestemc_transfer_to_fire, double dM_deadstemc_transfer_to_fire,
                 double dM_livecrootc_transfer_to_fire, double dM_deadcrootc_transfer_to_fire, double dM_livestemc_to_fire,
                 double dM_deadstemc_to_fire, double dM_livecrootc_to_fire, double dM_deadcrootc_to_fire,
                 double dM_gresp_storage_to_fire, double dM_gresp_transfer_to_fire, double dM_litr1c_to_fire,
                 double dM_litr2c_to_fire, double dM_litr3c_to_fire, double dM_litr4c_to_fire, double dM_cwdc_to_fire,
                 double dLeafc_transfer_to_leafc, double dFrootc_transfer_to_frootc, double dLivestemc_transfer_to_livestemc,
                 double dDeadstemc_transfer_to_deadstemc, double dLivecrootc_transfer_to_livecrootc,
                 double dDeadcrootc_transfer_to_deadcrootc, double dLeafc_to_litr1c, double dLeafc_to_litr2c,
                 double dLeafc_to_litr3c, double dLeafc_to_litr4c, double dFrootc_to_litr1c, double dFrootc_to_litr2c,
                 double dFrootc_to_litr3c, double dFrootc_to_litr4c, Sub_CFlux subCFlux
    ) {

		this.m_leafc_to_litr1c = dM_leafc_to_litr1c;
		this.m_leafc_to_litr2c = dM_leafc_to_litr2c;
		this.m_leafc_to_litr3c = dM_leafc_to_litr3c;
		this.m_leafc_to_litr4c = dM_leafc_to_litr4c;
		this.m_frootc_to_litr1c = dM_frootc_to_litr1c;
		this.m_frootc_to_litr2c = dM_frootc_to_litr2c;
		this.m_frootc_to_litr3c = dM_frootc_to_litr3c;
		this.m_frootc_to_litr4c = dM_frootc_to_litr4c;
		this.m_leafc_storage_to_litr1c = dM_leafc_storage_to_litr1c;
		this.m_frootc_storage_to_litr1c = dM_frootc_storage_to_litr1c;
		this.m_livestemc_storage_to_litr1c = dM_livestemc_storage_to_litr1c;
		this.m_deadstemc_storage_to_litr1c = dM_deadstemc_storage_to_litr1c;
		this.m_livecrootc_storage_to_litr1c = dM_livecrootc_storage_to_litr1c;
		this.m_deadcrootc_storage_to_litr1c = dM_deadcrootc_storage_to_litr1c;
		this.m_leafc_transfer_to_litr1c = dM_leafc_transfer_to_litr1c;
		this.m_frootc_transfer_to_litr1c = dM_frootc_transfer_to_litr1c;
		this.m_livestemc_transfer_to_litr1c = dM_livestemc_transfer_to_litr1c;
		this.m_deadstemc_transfer_to_litr1c = dM_deadstemc_transfer_to_litr1c;
		this.m_livecrootc_transfer_to_litr1c = dM_livecrootc_transfer_to_litr1c;
		this.m_deadcrootc_transfer_to_litr1c = dM_deadcrootc_transfer_to_litr1c;
		this.m_livestemc_to_cwdc = dM_livestemc_to_cwdc;
		this.m_deadstemc_to_cwdc = dM_deadstemc_to_cwdc;
		this.m_livecrootc_to_cwdc = dM_livecrootc_to_cwdc;
		this.m_deadcrootc_to_cwdc = dM_deadcrootc_to_cwdc;
		this.m_gresp_storage_to_litr1c = dM_gresp_storage_to_litr1c;
		this.m_gresp_transfer_to_litr1c = dM_gresp_transfer_to_litr1c;
		this.m_leafc_to_fire = dM_leafc_to_fire;
		this.m_frootc_to_fire = dM_frootc_to_fire;
		this.m_leafc_storage_to_fire = dM_leafc_storage_to_fire;
		this.m_frootc_storage_to_fire = dM_frootc_storage_to_fire;
		this.m_livestemc_storage_to_fire = dM_livestemc_storage_to_fire;
		this.m_deadstemc_storage_to_fire = dM_deadstemc_storage_to_fire;
		this.m_livecrootc_storage_to_fire = dM_livecrootc_storage_to_fire;
		this.m_deadcrootc_storage_to_fire = dM_deadcrootc_storage_to_fire;
		this.m_leafc_transfer_to_fire = dM_leafc_transfer_to_fire;
		this.m_frootc_transfer_to_fire = dM_frootc_transfer_to_fire;
		this.m_livestemc_transfer_to_fire = dM_livestemc_transfer_to_fire;
		this.m_deadstemc_transfer_to_fire = dM_deadstemc_transfer_to_fire;
		this.m_livecrootc_transfer_to_fire = dM_livecrootc_transfer_to_fire;
		this.m_deadcrootc_transfer_to_fire = dM_deadcrootc_transfer_to_fire;
		this.m_livestemc_to_fire = dM_livestemc_to_fire;
		this.m_deadstemc_to_fire = dM_deadstemc_to_fire;
		this.m_livecrootc_to_fire = dM_livecrootc_to_fire;
		this.m_deadcrootc_to_fire = dM_deadcrootc_to_fire;
		this.m_gresp_storage_to_fire = dM_gresp_storage_to_fire;
		this.m_gresp_transfer_to_fire = dM_gresp_transfer_to_fire;
		this.m_litr1c_to_fire = dM_litr1c_to_fire;
		this.m_litr2c_to_fire = dM_litr2c_to_fire;
		this.m_litr3c_to_fire = dM_litr3c_to_fire;
		this.m_litr4c_to_fire = dM_litr4c_to_fire;
		this.m_cwdc_to_fire = dM_cwdc_to_fire;
		this.leafc_transfer_to_leafc = dLeafc_transfer_to_leafc;
		this.frootc_transfer_to_frootc = dFrootc_transfer_to_frootc;
		this.livestemc_transfer_to_livestemc = dLivestemc_transfer_to_livestemc;
		this.deadstemc_transfer_to_deadstemc = dDeadstemc_transfer_to_deadstemc;
		this.livecrootc_transfer_to_livecrootc = dLivecrootc_transfer_to_livecrootc;
		this.deadcrootc_transfer_to_deadcrootc = dDeadcrootc_transfer_to_deadcrootc;
		this.leafc_to_litr1c = dLeafc_to_litr1c;
		this.leafc_to_litr2c = dLeafc_to_litr2c;
		this.leafc_to_litr3c = dLeafc_to_litr3c;
		this.leafc_to_litr4c = dLeafc_to_litr4c;
		this.frootc_to_litr1c = dFrootc_to_litr1c;
		this.frootc_to_litr2c = dFrootc_to_litr2c;
		this.frootc_to_litr3c = dFrootc_to_litr3c;
		this.frootc_to_litr4c = dFrootc_to_litr4c;
        this.leaf_day_mr = subCFlux.leaf_day_mr;
        this.leaf_night_mr = subCFlux.leaf_night_mr;
        this.froot_mr = subCFlux.froot_mr;
        this.livestem_mr = subCFlux.livestem_mr;
        this.livecroot_mr = subCFlux.livecroot_mr;
        this.psnsun_to_cpool = subCFlux.psnsun_to_cpool;
        this.psnshade_to_cpool = subCFlux.psnshade_to_cpool;
        this.cwdc_to_litr2c = subCFlux.cwdc_to_litr2c;
        this.cwdc_to_litr3c = subCFlux.cwdc_to_litr3c;
        this.cwdc_to_litr4c = subCFlux.cwdc_to_litr4c;
        this.litr1_hr = subCFlux.litr1_hr;
        this.litr1c_to_soil1c = subCFlux.litr1c_to_soil1c;
        this.litr2_hr = subCFlux.litr2_hr;
        this.litr2c_to_soil2c = subCFlux.litr2c_to_soil2c;
        this.litr3c_to_litr2c = subCFlux.litr3c_to_litr2c;
        this.litr4_hr = subCFlux.litr4_hr;
        this.litr4c_to_soil3c = subCFlux.litr4c_to_soil3c;
        this.soil1_hr = subCFlux.soil1_hr;
        this.soil1c_to_soil2c = subCFlux.soil1c_to_soil2c;
        this.soil2_hr = subCFlux.soil2_hr;
        this.soil2c_to_soil3c = subCFlux.soil2c_to_soil3c;
        this.soil3_hr = subCFlux.soil3_hr;
        this.soil3c_to_soil4c = subCFlux.soil3c_to_soil4c;
        this.soil4_hr = subCFlux.soil4_hr;
        this.cpool_to_leafc = subCFlux.cpool_to_leafc;
        this.cpool_to_leafc_storage = subCFlux.cpool_to_leafc_storage;
        this.cpool_to_frootc = subCFlux.cpool_to_frootc;
        this.cpool_to_frootc_storage = subCFlux.cpool_to_frootc_storage;
        this.cpool_to_livestemc = subCFlux.cpool_to_livestemc;
        this.cpool_to_livestemc_storage = subCFlux.cpool_to_livestemc_storage;
        this.cpool_to_deadstemc = subCFlux.cpool_to_deadstemc;
        this.cpool_to_deadstemc_storage = subCFlux.cpool_to_deadstemc_storage;
        this.cpool_to_livecrootc = subCFlux.cpool_to_livecrootc;
        this.cpool_to_livecrootc_storage = subCFlux.cpool_to_livecrootc_storage;
        this.cpool_to_deadcrootc = subCFlux.cpool_to_deadcrootc;
        this.cpool_to_deadcrootc_storage = subCFlux.cpool_to_deadcrootc_storage;
        this.cpool_to_gresp_storage = subCFlux.cpool_to_gresp_storage;
        this.cpool_leaf_gr = subCFlux.cpool_leaf_gr;
        this.cpool_leaf_storage_gr = subCFlux.cpool_leaf_storage_gr;
        this.transfer_leaf_gr = subCFlux.transfer_leaf_gr;
        this.cpool_froot_gr = subCFlux.cpool_froot_gr;
        this.cpool_froot_storage_gr = subCFlux.cpool_froot_storage_gr;
        this.transfer_froot_gr = subCFlux.transfer_froot_gr;
        this.cpool_livestem_gr = subCFlux.cpool_livestem_gr;
        this.cpool_livestem_storage_gr = subCFlux.cpool_livestem_storage_gr;
        this.transfer_livestem_gr = subCFlux.transfer_livestem_gr;
        this.cpool_deadstem_gr = subCFlux.cpool_deadstem_gr;
        this.cpool_deadstem_storage_gr = subCFlux.cpool_deadstem_storage_gr;
        this.transfer_deadstem_gr = subCFlux.transfer_deadstem_gr;
        this.cpool_livecroot_gr = subCFlux.cpool_livecroot_gr;
        this.cpool_livecroot_storage_gr = subCFlux.cpool_livecroot_storage_gr;
        this.transfer_livecroot_gr = subCFlux.transfer_livecroot_gr;
        this.cpool_deadcroot_gr = subCFlux.cpool_deadcroot_gr;
        this.cpool_deadcroot_storage_gr = subCFlux.cpool_deadcroot_storage_gr;
        this.transfer_deadcroot_gr = subCFlux.transfer_deadcroot_gr;
        this.leafc_storage_to_leafc_transfer = subCFlux.leafc_storage_to_leafc_transfer;
        this.frootc_storage_to_frootc_transfer = subCFlux.frootc_storage_to_frootc_transfer;
        this.livestemc_storage_to_livestemc_transfer = subCFlux.livestemc_storage_to_livestemc_transfer;
        this.deadstemc_storage_to_deadstemc_transfer = subCFlux.deadstemc_storage_to_deadstemc_transfer;
        this.livecrootc_storage_to_livecrootc_transfer = subCFlux.livecrootc_storage_to_livecrootc_transfer;
        this.deadcrootc_storage_to_deadcrootc_transfer = subCFlux.deadcrootc_storage_to_deadcrootc_transfer;
        this.gresp_storage_to_gresp_transfer = subCFlux.gresp_storage_to_gresp_transfer;
        this.livestemc_to_deadstemc = subCFlux.livestemc_to_deadstemc;
        this.livecrootc_to_deadcrootc = subCFlux.livecrootc_to_deadcrootc;

	}

}
