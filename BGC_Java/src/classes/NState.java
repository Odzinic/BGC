package classes;

public class NState {
	
    public double leafn;              /* (kgN/m2) leaf N */
    public double leafn_storage;      /* (kgN/m2) leaf N */
    public double leafn_transfer;     /* (kgN/m2) leaf N */
    public double frootn;             /* (kgN/m2) fine root N */ 
    public double frootn_storage;     /* (kgN/m2) fine root N */ 
    public double frootn_transfer;    /* (kgN/m2) fine root N */ 
    public double livestemn;          /* (kgN/m2) live stem N */
    public double livestemn_storage;  /* (kgN/m2) live stem N */
    public double livestemn_transfer; /* (kgN/m2) live stem N */
    public double deadstemn;          /* (kgN/m2) dead stem N */
    public double deadstemn_storage;  /* (kgN/m2) dead stem N */
    public double deadstemn_transfer; /* (kgN/m2) dead stem N */
    public double livecrootn;         /* (kgN/m2) live coarse root N */
    public double livecrootn_storage; /* (kgN/m2) live coarse root N */
    public double livecrootn_transfer;/* (kgN/m2) live coarse root N */
    public double deadcrootn;         /* (kgN/m2) dead coarse root N */
    public double deadcrootn_storage; /* (kgN/m2) dead coarse root N */
    public double deadcrootn_transfer;/* (kgN/m2) dead coarse root N */
    public double cwdn;               /* (kgN/m2) coarse woody debris N */
    public double litr1n;             /* (kgN/m2) litter labile N */
    public double litr2n;             /* (kgN/m2) litter unshielded cellulose N */
    public double litr3n;             /* (kgN/m2) litter shielded cellulose N */
    public double litr4n;             /* (kgN/m2) litter lignin N */
    public double soil1n;             /* (kgN/m2) microbial recycling pool N (fast) */
    public double soil2n;             /* (kgN/m2) microbial recycling pool N (medium) */
    public double soil3n;             /* (kgN/m2) microbial recycling pool N (slow) */
    public double soil4n;             /* (kgN/m2) recalcitrant SOM N (humus, slowest) */
    public double sminn;              /* (kgN/m2) soil mineral N */
	public double retransn;           /* (kgN/m2) plant pool of retranslocated N */
	public double npool;              /* (kgN/m2) temporary plant N pool */
    public double nfix_src;           /* (kgN/m2) SUM of biological N fixation */
    public double ndep_src;           /* (kgN/m2) SUM of N deposition inputs */
    public double nleached_snk;       /* (kgN/m2) SUM of N leached */
    public double nvol_snk;           /* (kgN/m2) SUM of N lost to volatilization */
	public double fire_snk;           /* (kgN/m2) SUM of N lost to fire */
	
	public NState(double dLeafn,double dLeafn_storage,double dLeafn_transfer,double dFrootn,double dFrootn_storage,
			double dFrootn_transfer,double dLivestemn,double dLivestemn_storage,double dLivestemn_transfer,double dDeadstemn,
			double dDeadstemn_storage,double dDeadstemn_transfer,double dLivecrootn,double dLivecrootn_storage,
			double dLivecrootn_transfer,double dDeadcrootn,double dDeadcrootn_storage,double dDeadcrootn_transfer,double dCwdn,
			double dLitr1n,double dLitr2n,double dLitr3n,double dLitr4n,double dSoil1n,double dSoil2n,double dSoil3n,double dSoil4n,
			double dSminn,double dRetransn,double dNpool,double dNfix_src,double dNdep_src,double dNleached_snk,double dNvol_snk,double dFire_snk){
		
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
		this.nfix_src = dNfix_src;
		this.ndep_src = dNdep_src;
		this.nleached_snk = dNleached_snk;
		this.nvol_snk = dNvol_snk;
		this.fire_snk = dFire_snk;
		
	}

}
