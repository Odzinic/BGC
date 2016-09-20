package classes;

public class CFlux {
	
	public double m_leafc_to_litr1c;              /* (kgC/m2/d) */            
	public double m_leafc_to_litr2c;              /* (kgC/m2/d) */
	public double m_leafc_to_litr3c;              /* (kgC/m2/d) */
	public double m_leafc_to_litr4c;              /* (kgC/m2/d) */
	public double m_frootc_to_litr1c;             /* (kgC/m2/d) */
	public double m_frootc_to_litr2c;             /* (kgC/m2/d) */
	public double m_frootc_to_litr3c;             /* (kgC/m2/d) */
	public double m_frootc_to_litr4c;             /* (kgC/m2/d) */
	public double m_leafc_storage_to_litr1c;      /* (kgC/m2/d) */
	public double m_frootc_storage_to_litr1c;     /* (kgC/m2/d) */
	public double m_livestemc_storage_to_litr1c;  /* (kgC/m2/d) */
	public double m_deadstemc_storage_to_litr1c;  /* (kgC/m2/d) */
	public double m_livecrootc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_deadcrootc_storage_to_litr1c; /* (kgC/m2/d) */
	public double m_leafc_transfer_to_litr1c;     /* (kgC/m2/d) */
	public double m_frootc_transfer_to_litr1c;    /* (kgC/m2/d) */
	public double m_livestemc_transfer_to_litr1c; /* (kgC/m2/d) */
	public double m_deadstemc_transfer_to_litr1c; /* (kgC/m2/d) */
	public double m_livecrootc_transfer_to_litr1c;/* (kgC/m2/d) */
	public double m_deadcrootc_transfer_to_litr1c;/* (kgC/m2/d) */
	public double m_livestemc_to_cwdc;            /* (kgC/m2/d) */
	public double m_deadstemc_to_cwdc;            /* (kgC/m2/d) */
	public double m_livecrootc_to_cwdc;           /* (kgC/m2/d) */
	public double m_deadcrootc_to_cwdc;           /* (kgC/m2/d) */
	public double m_gresp_storage_to_litr1c;      /* (kgC/m2/d) */
	public double m_gresp_transfer_to_litr1c;     /* (kgC/m2/d) */
	/* fire fluxes */
	public double m_leafc_to_fire;                /* (kgC/m2/d) */
	public double m_frootc_to_fire;               /* (kgC/m2/d) */
	public double m_leafc_storage_to_fire;        /* (kgC/m2/d) */
	public double m_frootc_storage_to_fire;       /* (kgC/m2/d) */
	public double m_livestemc_storage_to_fire;    /* (kgC/m2/d) */
	public double m_deadstemc_storage_to_fire;    /* (kgC/m2/d) */
	public double m_livecrootc_storage_to_fire;   /* (kgC/m2/d) */
	public double m_deadcrootc_storage_to_fire;   /* (kgC/m2/d) */
	public double m_leafc_transfer_to_fire;       /* (kgC/m2/d) */
	public double m_frootc_transfer_to_fire;      /* (kgC/m2/d) */
	public double m_livestemc_transfer_to_fire;   /* (kgC/m2/d) */
	public double m_deadstemc_transfer_to_fire;   /* (kgC/m2/d) */
	public double m_livecrootc_transfer_to_fire;  /* (kgC/m2/d) */
	public double m_deadcrootc_transfer_to_fire;  /* (kgC/m2/d) */
	public double m_livestemc_to_fire;            /* (kgC/m2/d) */
	public double m_deadstemc_to_fire;            /* (kgC/m2/d) */
	public double m_livecrootc_to_fire;           /* (kgC/m2/d) */
	public double m_deadcrootc_to_fire;           /* (kgC/m2/d) */
	public double m_gresp_storage_to_fire;        /* (kgC/m2/d) */
	public double m_gresp_transfer_to_fire;       /* (kgC/m2/d) */
	public double m_litr1c_to_fire;               /* (kgC/m2/d) */
	public double m_litr2c_to_fire;               /* (kgC/m2/d) */
	public double m_litr3c_to_fire;               /* (kgC/m2/d) */
	public double m_litr4c_to_fire;               /* (kgC/m2/d) */
	public double m_cwdc_to_fire;                 /* (kgC/m2/d) */
	/* phenology fluxes from transfer pool */
	public double leafc_transfer_to_leafc;          /* (kgC/m2/d) */
	public double frootc_transfer_to_frootc;        /* (kgC/m2/d) */
	public double livestemc_transfer_to_livestemc;  /* (kgC/m2/d) */
	public double deadstemc_transfer_to_deadstemc;  /* (kgC/m2/d) */
	public double livecrootc_transfer_to_livecrootc;/* (kgC/m2/d) */
	public double deadcrootc_transfer_to_deadcrootc;/* (kgC/m2/d) */
	/* leaf and fine root litterfall */
	public double leafc_to_litr1c;              /* (kgC/m2/d) */
	public double leafc_to_litr2c;              /* (kgC/m2/d) */
	public double leafc_to_litr3c;              /* (kgC/m2/d) */
	public double leafc_to_litr4c;              /* (kgC/m2/d) */
	public double frootc_to_litr1c;             /* (kgC/m2/d) */
	public double frootc_to_litr2c;             /* (kgC/m2/d) */
	public double frootc_to_litr3c;             /* (kgC/m2/d) */
	public double frootc_to_litr4c;             /* (kgC/m2/d) */
	/* maintenance respiration fluxes */
	public double leaf_day_mr;                  /* (kgC/m2/d) */
	public double leaf_night_mr;                /* (kgC/m2/d) */
	public double froot_mr;                     /* (kgC/m2/d) */
	public double livestem_mr;                  /* (kgC/m2/d) */
	public double livecroot_mr;                 /* (kgC/m2/d) */
	/* photosynthesis flux */
	public double psnsun_to_cpool;              /* (kgC/m2/d) */
	public double psnshade_to_cpool;            /* (kgC/m2/d) */
	/* litter decomposition fluxes */
	public double cwdc_to_litr2c;               /* (kgC/m2/d) */
	public double cwdc_to_litr3c;               /* (kgC/m2/d) */
	public double cwdc_to_litr4c;               /* (kgC/m2/d) */
	public double litr1_hr;                     /* (kgC/m2/d) */
	public double litr1c_to_soil1c;             /* (kgC/m2/d) */
	public double litr2_hr;                     /* (kgC/m2/d) */
	public double litr2c_to_soil2c;             /* (kgC/m2/d) */
	public double litr3c_to_litr2c;             /* (kgC/m2/d) */
	public double litr4_hr;                     /* (kgC/m2/d) */
	public double litr4c_to_soil3c;             /* (kgC/m2/d) */
	public double soil1_hr;                     /* (kgC/m2/d) */
	public double soil1c_to_soil2c;             /* (kgC/m2/d) */
	public double soil2_hr;                     /* (kgC/m2/d) */
	public double soil2c_to_soil3c;             /* (kgC/m2/d) */
	public double soil3_hr;                     /* (kgC/m2/d) */
	public double soil3c_to_soil4c;             /* (kgC/m2/d) */
	public double soil4_hr;                     /* (kgC/m2/d) */
	/* daily allocation fluxes from current GPP */
	public double cpool_to_leafc;               /* (kgC/m2/d) */
	public double cpool_to_leafc_storage;       /* (kgC/m2/d) */
	public double cpool_to_frootc;              /* (kgC/m2/d) */
	public double cpool_to_frootc_storage;      /* (kgC/m2/d) */
	public double cpool_to_livestemc;           /* (kgC/m2/d) */
	public double cpool_to_livestemc_storage;   /* (kgC/m2/d) */
	public double cpool_to_deadstemc;           /* (kgC/m2/d) */
	public double cpool_to_deadstemc_storage;   /* (kgC/m2/d) */
	public double cpool_to_livecrootc;          /* (kgC/m2/d) */
	public double cpool_to_livecrootc_storage;  /* (kgC/m2/d) */
	public double cpool_to_deadcrootc;          /* (kgC/m2/d) */
	public double cpool_to_deadcrootc_storage;  /* (kgC/m2/d) */
	public double cpool_to_gresp_storage;       /* (kgC/m2/d) */
	/* daily growth respiration fluxes */
	public double cpool_leaf_gr;                /* (kgC/m2/d) */
	public double cpool_leaf_storage_gr;        /* (kgC/m2/d) */
	public double transfer_leaf_gr;             /* (kgC/m2/d) */
	public double cpool_froot_gr;               /* (kgC/m2/d) */
	public double cpool_froot_storage_gr;       /* (kgC/m2/d) */
	public double transfer_froot_gr;            /* (kgC/m2/d) */
	public double cpool_livestem_gr;            /* (kgC/m2/d) */
	public double cpool_livestem_storage_gr;    /* (kgC/m2/d) */
	public double transfer_livestem_gr;         /* (kgC/m2/d) */
	public double cpool_deadstem_gr;            /* (kgC/m2/d) */
	public double cpool_deadstem_storage_gr;    /* (kgC/m2/d) */
	public double transfer_deadstem_gr;         /* (kgC/m2/d) */
	public double cpool_livecroot_gr;           /* (kgC/m2/d) */
	public double cpool_livecroot_storage_gr;   /* (kgC/m2/d) */
	public double transfer_livecroot_gr;        /* (kgC/m2/d) */
	public double cpool_deadcroot_gr;           /* (kgC/m2/d) */
	public double cpool_deadcroot_storage_gr;   /* (kgC/m2/d) */
	public double transfer_deadcroot_gr;        /* (kgC/m2/d) */
	/* annual turnover of storage to transfer pools */
	public double leafc_storage_to_leafc_transfer;           /* (kgC/m2/d) */
	public double frootc_storage_to_frootc_transfer;         /* (kgC/m2/d) */
	public double livestemc_storage_to_livestemc_transfer;    /* (kgC/m2/d) */
	public double deadstemc_storage_to_deadstemc_transfer;    /* (kgC/m2/d) */
	public double livecrootc_storage_to_livecrootc_transfer; /* (kgC/m2/d) */ /*  CHANGED TO INT TO PREVENT ERROR */
	public int deadcrootc_storage_to_deadcrootc_transfer; /* (kgC/m2/d) */ /*  CHANGED TO INT TO PREVENT ERROR */
	public int gresp_storage_to_gresp_transfer;           /* (kgC/m2/d) */ /*  CHANGED TO INT TO PREVENT ERROR */
	/* turnover of live wood to dead wood */ /*  CHANGED TO INT TO PREVENT ERROR */
	public int livestemc_to_deadstemc;        /* (kgC/m2/d) */
	public int livecrootc_to_deadcrootc;      /* (kgC/m2/d) */
	
	public CFlux(double dM_leafc_to_litr1c,double dM_leafc_to_litr2c,double dM_leafc_to_litr3c,double dM_leafc_to_litr4c,double dM_frootc_to_litr1c,double dM_frootc_to_litr2c,double dM_frootc_to_litr3c,double dM_frootc_to_litr4c,double dM_leafc_storage_to_litr1c,double dM_frootc_storage_to_litr1c,double dM_livestemc_storage_to_litr1c,double dM_deadstemc_storage_to_litr1c,double dM_livecrootc_storage_to_litr1c,double dM_deadcrootc_storage_to_litr1c,double dM_leafc_transfer_to_litr1c,double dM_frootc_transfer_to_litr1c,double dM_livestemc_transfer_to_litr1c,double dM_deadstemc_transfer_to_litr1c,double dM_livecrootc_transfer_to_litr1c,double dM_deadcrootc_transfer_to_litr1c,double dM_livestemc_to_cwdc,double dM_deadstemc_to_cwdc,double dM_livecrootc_to_cwdc,double dM_deadcrootc_to_cwdc,double dM_gresp_storage_to_litr1c,double dM_gresp_transfer_to_litr1c,double dM_leafc_to_fire,double dM_frootc_to_fire,double dM_leafc_storage_to_fire,double dM_frootc_storage_to_fire,double dM_livestemc_storage_to_fire,double dM_deadstemc_storage_to_fire,double dM_livecrootc_storage_to_fire,double dM_deadcrootc_storage_to_fire,double dM_leafc_transfer_to_fire,double dM_frootc_transfer_to_fire,double dM_livestemc_transfer_to_fire,double dM_deadstemc_transfer_to_fire,double dM_livecrootc_transfer_to_fire,double dM_deadcrootc_transfer_to_fire,double dM_livestemc_to_fire,double dM_deadstemc_to_fire,double dM_livecrootc_to_fire,double dM_deadcrootc_to_fire,double dM_gresp_storage_to_fire,double dM_gresp_transfer_to_fire,double dM_litr1c_to_fire,double dM_litr2c_to_fire,double dM_litr3c_to_fire,double dM_litr4c_to_fire,double dM_cwdc_to_fire,double dLeafc_transfer_to_leafc,double dFrootc_transfer_to_frootc,double dLivestemc_transfer_to_livestemc,double dDeadstemc_transfer_to_deadstemc,double dLivecrootc_transfer_to_livecrootc,double dDeadcrootc_transfer_to_deadcrootc,double dLeafc_to_litr1c,double dLeafc_to_litr2c,double dLeafc_to_litr3c,double dLeafc_to_litr4c,double dFrootc_to_litr1c,double dFrootc_to_litr2c,double dFrootc_to_litr3c,double dFrootc_to_litr4c,double dLeaf_day_mr,double dLeaf_night_mr,double dFroot_mr,double dLivestem_mr,double dLivecroot_mr,double dPsnsun_to_cpool,double dPsnshade_to_cpool,double dCwdc_to_litr2c,double dCwdc_to_litr3c,double dCwdc_to_litr4c,double dLitr1_hr,double dLitr1c_to_soil1c,double dLitr2_hr,double dLitr2c_to_soil2c,double dLitr3c_to_litr2c,double dLitr4_hr,double dLitr4c_to_soil3c,double dSoil1_hr,double dSoil1c_to_soil2c,double dSoil2_hr,double dSoil2c_to_soil3c,double dSoil3_hr,double dSoil3c_to_soil4c,double dSoil4_hr,double dCpool_to_leafc,double dCpool_to_leafc_storage,double dCpool_to_frootc,double dCpool_to_frootc_storage,double dCpool_to_livestemc,double dCpool_to_livestemc_storage,double dCpool_to_deadstemc,double dCpool_to_deadstemc_storage,double dCpool_to_livecrootc,double dCpool_to_livecrootc_storage,double dCpool_to_deadcrootc,double dCpool_to_deadcrootc_storage,double dCpool_to_gresp_storage,double dCpool_leaf_gr,double dCpool_leaf_storage_gr,double dTransfer_leaf_gr,double dCpool_froot_gr,double dCpool_froot_storage_gr,double dTransfer_froot_gr,double dCpool_livestem_gr,double dCpool_livestem_storage_gr,double dTransfer_livestem_gr,double dCpool_deadstem_gr,double dCpool_deadstem_storage_gr,double dTransfer_deadstem_gr,double dCpool_livecroot_gr,double dCpool_livecroot_storage_gr,double dTransfer_livecroot_gr,double dCpool_deadcroot_gr,double dCpool_deadcroot_storage_gr,double dTransfer_deadcroot_gr,double dLeafc_storage_to_leafc_transfer,double dFrootc_storage_to_frootc_transfer,double dLivestemc_storage_to_livestemc_transfer,double dDeadstemc_storage_to_deadstemc_transfer,double dLivecrootc_storage_to_livecrootc_transfer,int dDeadcrootc_storage_to_deadcrootc_transfer,int dGresp_storage_to_gresp_transfer,int dLivestemc_to_deadstemc,int dLivecrootc_to_deadcrootc){
		
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
		this.leaf_day_mr = dLeaf_day_mr;
		this.leaf_night_mr = dLeaf_night_mr;
		this.froot_mr = dFroot_mr;
		this.livestem_mr = dLivestem_mr;
		this.livecroot_mr = dLivecroot_mr;
		this.psnsun_to_cpool = dPsnsun_to_cpool;
		this.psnshade_to_cpool = dPsnshade_to_cpool;
		this.cwdc_to_litr2c = dCwdc_to_litr2c;
		this.cwdc_to_litr3c = dCwdc_to_litr3c;
		this.cwdc_to_litr4c = dCwdc_to_litr4c;
		this.litr1_hr = dLitr1_hr;
		this.litr1c_to_soil1c = dLitr1c_to_soil1c;
		this.litr2_hr = dLitr2_hr;
		this.litr2c_to_soil2c = dLitr2c_to_soil2c;
		this.litr3c_to_litr2c = dLitr3c_to_litr2c;
		this.litr4_hr = dLitr4_hr;
		this.litr4c_to_soil3c = dLitr4c_to_soil3c;
		this.soil1_hr = dSoil1_hr;
		this.soil1c_to_soil2c = dSoil1c_to_soil2c;
		this.soil2_hr = dSoil2_hr;
		this.soil2c_to_soil3c = dSoil2c_to_soil3c;
		this.soil3_hr = dSoil3_hr;
		this.soil3c_to_soil4c = dSoil3c_to_soil4c;
		this.soil4_hr = dSoil4_hr;
		this.cpool_to_leafc = dCpool_to_leafc;
		this.cpool_to_leafc_storage = dCpool_to_leafc_storage;
		this.cpool_to_frootc = dCpool_to_frootc;
		this.cpool_to_frootc_storage = dCpool_to_frootc_storage;
		this.cpool_to_livestemc = dCpool_to_livestemc;
		this.cpool_to_livestemc_storage = dCpool_to_livestemc_storage;
		this.cpool_to_deadstemc = dCpool_to_deadstemc;
		this.cpool_to_deadstemc_storage = dCpool_to_deadstemc_storage;
		this.cpool_to_livecrootc = dCpool_to_livecrootc;
		this.cpool_to_livecrootc_storage = dCpool_to_livecrootc_storage;
		this.cpool_to_deadcrootc = dCpool_to_deadcrootc;
		this.cpool_to_deadcrootc_storage = dCpool_to_deadcrootc_storage;
		this.cpool_to_gresp_storage = dCpool_to_gresp_storage;
		this.cpool_leaf_gr = dCpool_leaf_gr;
		this.cpool_leaf_storage_gr = dCpool_leaf_storage_gr;
		this.transfer_leaf_gr = dTransfer_leaf_gr;
		this.cpool_froot_gr = dCpool_froot_gr;
		this.cpool_froot_storage_gr = dCpool_froot_storage_gr;
		this.transfer_froot_gr = dTransfer_froot_gr;
		this.cpool_livestem_gr = dCpool_livestem_gr;
		this.cpool_livestem_storage_gr = dCpool_livestem_storage_gr;
		this.transfer_livestem_gr = dTransfer_livestem_gr;
		this.cpool_deadstem_gr = dCpool_deadstem_gr;
		this.cpool_deadstem_storage_gr = dCpool_deadstem_storage_gr;
		this.transfer_deadstem_gr = dTransfer_deadstem_gr;
		this.cpool_livecroot_gr = dCpool_livecroot_gr;
		this.cpool_livecroot_storage_gr = dCpool_livecroot_storage_gr;
		this.transfer_livecroot_gr = dTransfer_livecroot_gr;
		this.cpool_deadcroot_gr = dCpool_deadcroot_gr;
		this.cpool_deadcroot_storage_gr = dCpool_deadcroot_storage_gr;
		this.transfer_deadcroot_gr = dTransfer_deadcroot_gr;
		this.leafc_storage_to_leafc_transfer = dLeafc_storage_to_leafc_transfer;
		this.frootc_storage_to_frootc_transfer = dFrootc_storage_to_frootc_transfer;
		this.livestemc_storage_to_livestemc_transfer = dLivestemc_storage_to_livestemc_transfer;
		this.deadstemc_storage_to_deadstemc_transfer = dDeadstemc_storage_to_deadstemc_transfer;
		this.livecrootc_storage_to_livecrootc_transfer = dLivecrootc_storage_to_livecrootc_transfer;
		this.deadcrootc_storage_to_deadcrootc_transfer = dDeadcrootc_storage_to_deadcrootc_transfer;
		this.gresp_storage_to_gresp_transfer = dGresp_storage_to_gresp_transfer;
		this.livestemc_to_deadstemc = dLivestemc_to_deadstemc;
		this.livecrootc_to_deadcrootc = dLivecrootc_to_deadcrootc;
	}

}
