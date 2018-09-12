package classes;

/* This sub class was created due to the original CFlux class having too many parameters
to be compiled in Java. The sub class will be passed into CFlux as a parameter and contain
a subset of the original CFlux variables.
 */

public class Sub_CFlux {

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

    public Sub_CFlux(double dLeaf_day_mr, double dLeaf_night_mr,
                     double dFroot_mr, double dLivestem_mr, double dLivecroot_mr, double dPsnsun_to_cpool,
                     double dPsnshade_to_cpool, double dCwdc_to_litr2c, double dCwdc_to_litr3c, double dCwdc_to_litr4c,
                     double dLitr1_hr, double dLitr1c_to_soil1c, double dLitr2_hr, double dLitr2c_to_soil2c,
                     double dLitr3c_to_litr2c, double dLitr4_hr, double dLitr4c_to_soil3c, double dSoil1_hr,
                     double dSoil1c_to_soil2c, double dSoil2_hr, double dSoil2c_to_soil3c, double dSoil3_hr,
                     double dSoil3c_to_soil4c, double dSoil4_hr, double dCpool_to_leafc, double dCpool_to_leafc_storage,
                     double dCpool_to_frootc, double dCpool_to_frootc_storage, double dCpool_to_livestemc,
                     double dCpool_to_livestemc_storage, double dCpool_to_deadstemc, double dCpool_to_deadstemc_storage,
                     double dCpool_to_livecrootc, double dCpool_to_livecrootc_storage, double dCpool_to_deadcrootc,
                     double dCpool_to_deadcrootc_storage, double dCpool_to_gresp_storage, double dCpool_leaf_gr,
                     double dCpool_leaf_storage_gr, double dTransfer_leaf_gr, double dCpool_froot_gr,
                     double dCpool_froot_storage_gr, double dTransfer_froot_gr, double dCpool_livestem_gr,
                     double dCpool_livestem_storage_gr, double dTransfer_livestem_gr, double dCpool_deadstem_gr,
                     double dCpool_deadstem_storage_gr, double dTransfer_deadstem_gr, double dCpool_livecroot_gr,
                     double dCpool_livecroot_storage_gr, double dTransfer_livecroot_gr, double dCpool_deadcroot_gr,
                     double dCpool_deadcroot_storage_gr, double dTransfer_deadcroot_gr, double dLeafc_storage_to_leafc_transfer,
                     double dFrootc_storage_to_frootc_transfer, double dLivestemc_storage_to_livestemc_transfer,
                     double dDeadstemc_storage_to_deadstemc_transfer, double dLivecrootc_storage_to_livecrootc_transfer,
                     double dDeadcrootc_storage_to_deadcrootc_transfer, double dGresp_storage_to_gresp_transfer,
                     double dLivestemc_to_deadstemc, double dLivecrootc_to_deadcrootc
    ) {

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
