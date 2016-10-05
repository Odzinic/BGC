package classes;

public class Restart_Data {

	public double soilw;
	public double snoww;
	public double canopyw;
	public double leafc;
	public double leafc_storage;
	public double leafc_transfer;
	public double frootc;
	public double frootc_storage;
	public double frootc_transfer;
	public double livestemc;
	public double livestemc_storage;
	public double livestemc_transfer;
	public double deadstemc;
	public double deadstemc_storage;
	public double deadstemc_transfer;
	public double livecrootc;
	public double livecrootc_storage;
	public double livecrootc_transfer;
	public double deadcrootc;
	public double deadcrootc_storage;
	public double deadcrootc_transfer;
	public double gresp_storage;
	public double gresp_transfer;
	public double cwdc;
	public double litr1c;
	public double litr2c;
	public double litr3c;
	public double litr4c;
	public double soil1c;
	public double soil2c;
	public double soil3c;
	public double soil4c;
	public double cpool;
	public double leafn;
	public double leafn_storage;
	public double leafn_transfer;
	public double frootn;
	public double frootn_storage;
	public double frootn_transfer;
	public double livestemn;
	public double livestemn_storage;
	public double livestemn_transfer;
	public double deadstemn;
	public double deadstemn_storage;
	public double deadstemn_transfer;
	public double livecrootn;
	public double livecrootn_storage;
	public double livecrootn_transfer;
	public double deadcrootn;
	public double deadcrootn_storage;
	public double deadcrootn_transfer;
	public double cwdn;
	public double litr1n;
	public double litr2n;
	public double litr3n;
	public double litr4n;
	public double soil1n;
	public double soil2n;
	public double soil3n;
	public double soil4n;
	public double sminn;
	public double retransn;
	public double npool;
	public double day_leafc_litfall_increment;
	public double day_frootc_litfall_increment;
	public double day_livestemc_turnover_increment;
	public double day_livecrootc_turnover_increment;
	public double annmax_leafc;
	public double annmax_frootc;
	public double annmax_livestemc;
	public double annmax_livecrootc;
	public double dsr;
	public int metyr;

	public Restart_Data(double dSoilw, double dSnoww, double dCanopyw, double dLeafc, double dLeafc_storage,
			double dLeafc_transfer, double dFrootc, double dFrootc_storage, double dFrootc_transfer, double dLivestemc,
			double dLivestemc_storage, double dLivestemc_transfer, double dDeadstemc, double dDeadstemc_storage,
			double dDeadstemc_transfer, double dLivecrootc, double dLivecrootc_storage, double dLivecrootc_transfer,
			double dDeadcrootc, double dDeadcrootc_storage, double dDeadcrootc_transfer, double dGresp_storage,
			double dGresp_transfer, double dCwdc, double dLitr1c, double dLitr2c, double dLitr3c, double dLitr4c,
			double dSoil1c, double dSoil2c, double dSoil3c, double dSoil4c, double dCpool, double dLeafn,
			double dLeafn_storage, double dLeafn_transfer, double dFrootn, double dFrootn_storage,
			double dFrootn_transfer, double dLivestemn, double dLivestemn_storage, double dLivestemn_transfer,
			double dDeadstemn, double dDeadstemn_storage, double dDeadstemn_transfer, double dLivecrootn,
			double dLivecrootn_storage, double dLivecrootn_transfer, double dDeadcrootn, double dDeadcrootn_storage,
			double dDeadcrootn_transfer, double dCwdn, double dLitr1n, double dLitr2n, double dLitr3n, double dLitr4n,
			double dSoil1n, double dSoil2n, double dSoil3n, double dSoil4n, double dSminn, double dRetransn,
			double dNpool, double dDay_leafc_litfall_increment, double dDay_frootc_litfall_increment,
			double dDay_livestemc_turnover_increment, double dDay_livecrootc_turnover_increment, double dAnnmax_leafc,
			double dAnnmax_frootc, double dAnnmax_livestemc, double dAnnmax_livecrootc, double dDsr, int iMetyr) {

		this.soilw = dSoilw;
		this.snoww = dSnoww;
		this.canopyw = dCanopyw;
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
		this.leafn = dLeafn;
		this.leafn_storage = dLeafn_storage;
		this.leafn_transfer = dLeafn_transfer;
		this.frootn = dFrootn;
		this.frootn_storage = dFrootn_storage;
		this.frootn_transfer = dFrootn_transfer;
		this.livestemn = dLivestemn;
		this.livestemn_storage = dLivestemn_storage;
		this.livestemn_transfer = dLivestemn_transfer;
		this.deadstemn = dDeadstemn;
		this.deadstemn_storage = dDeadstemn_storage;
		this.deadstemn_transfer = dDeadstemn_transfer;
		this.livecrootn = dLivecrootn;
		this.livecrootn_storage = dLivecrootn_storage;
		this.livecrootn_transfer = dLivecrootn_transfer;
		this.deadcrootn = dDeadcrootn;
		this.deadcrootn_storage = dDeadcrootn_storage;
		this.deadcrootn_transfer = dDeadcrootn_transfer;
		this.cwdn = dCwdn;
		this.litr1n = dLitr1n;
		this.litr2n = dLitr2n;
		this.litr3n = dLitr3n;
		this.litr4n = dLitr4n;
		this.soil1n = dSoil1n;
		this.soil2n = dSoil2n;
		this.soil3n = dSoil3n;
		this.soil4n = dSoil4n;
		this.sminn = dSminn;
		this.retransn = dRetransn;
		this.npool = dNpool;
		this.day_leafc_litfall_increment = dDay_leafc_litfall_increment;
		this.day_frootc_litfall_increment = dDay_frootc_litfall_increment;
		this.day_livestemc_turnover_increment = dDay_livestemc_turnover_increment;
		this.day_livecrootc_turnover_increment = dDay_livecrootc_turnover_increment;
		this.annmax_leafc = dAnnmax_leafc;
		this.annmax_frootc = dAnnmax_frootc;
		this.annmax_livestemc = dAnnmax_livestemc;
		this.annmax_livecrootc = dAnnmax_livecrootc;
		this.dsr = dDsr;
		this.metyr = iMetyr;

	}

}
