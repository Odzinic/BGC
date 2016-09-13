package classes;

public class Epvar {
	
	public double day_leafc_litfall_increment;      /* (kgC/m2/d) rate leaf litfall */
	public double day_frootc_litfall_increment;     /* (kgC/m2/d) rate froot litfall */
	public double day_livestemc_turnover_increment; /* (kgC/m2/d) rate livestem turnover */
	public double day_livecrootc_turnover_increment;/* (kgC/m2/d) rate livecroot turnover */
	public double annmax_leafc;      /* (kgC/m2) annual maximum daily leaf C */
	public double annmax_frootc;     /* (kgC/m2) annual maximum daily froot C */
	public double annmax_livestemc;  /* (kgC/m2) annual maximum daily livestem C */
	public double annmax_livecrootc; /* (kgC/m2) annual maximum daily livecroot C */
	public double dsr;            /* (days) number of days since rain, for soil evap */
    public double proj_lai;       /* (DIM) live projected leaf area index */
    public double all_lai;        /* (DIM) live all-sided leaf area index */
    public double plaisun;        /* (DIM) sunlit projected leaf area index */
    public double plaishade;      /* (DIM) shaded projected leaf area index */
    public double sun_proj_sla;   /* (m2/kgC) sunlit projected SLA */
    public double shade_proj_sla; /* (m2/kgC) shaded projected SLA */
    public double psi;            /* (MPa) water potential of soil and leaves */
    public double vwc;            /* (DIM) volumetric water content */
    public double dlmr_area_sun;  /* (umolC/m2projected leaf area/s) sunlit leaf MR */
    public double dlmr_area_shade;/* (umolC/m2projected leaf area/s) shaded leaf MR */
    public double gl_t_wv_sun;   /* (m/s) leaf-scale conductance to transpired water */
    public double gl_t_wv_shade; /* (m/s) leaf-scale conductance to transpired water */
    public double assim_sun;      /* (umol/m2/s) sunlit assimilation per unit pLAI */
    public double assim_shade;    /* (umol/m2/s) shaded assimilation per unit pLAI */
    /* decomp variables */
    public double t_scalar;       /* (DIM) decomp temperature scalar */
    public double w_scalar;       /* (DIM) decomp water scalar */
    public double rate_scalar;    /* (DIM) decomp combined scalar */
	public double daily_gross_nmin; /* (kgN/m2/d) daily gross N mineralization */
	public double daily_gross_nimmob; /* (kgN/m2/d) daily gross N immobilization */ 
	public double daily_net_nmin; /* (kgN/m2/d) daily net N mineralization */
	public double fpi;            /* (DIM) fraction of potential immobilization */

    /* the following are optional outputs, usually set if the appropriate
    functions are called with the flag verbose = 1 */
	public double m_tmin;         /* (DIM) freezing night temperature multiplier */
	public double m_psi;          /* (DIM) water potential multiplier */
	public double m_co2;          /* (DIM) atmospheric [CO2] multiplier */
	public double m_ppfd_sun;         /* (DIM) PAR flux density multiplier */
	public double m_ppfd_shade;         /* (DIM) PAR flux density multiplier */
	public double m_vpd;          /* (DIM) vapor pressure deficit multiplier */
	public double m_final_sun;        /* (DIM) product of all other multipliers */
	public double m_final_shade;        /* (DIM) product of all other multipliers */
	public double gl_bl;          /* (m/s) leaf boundary layer conductance */
    public double gl_c;           /* (m/s) leaf cuticular conductance */
    public double gl_s_sun;           /* (m/s) leaf-scale stomatal conductance */
    public double gl_s_shade;           /* (m/s) leaf-scale stomatal conductance */
	public double gl_e_wv;        /* (m/s) leaf conductance to evaporated water */
	public double gl_sh;          /* (m/s) leaf conductance to sensible heat */
    public double gc_e_wv;        /* (m/s) canopy conductance to evaporated water */
    public double gc_sh;          /* (m/s) canopy conductance to sensible heat */
	
	/* diagnostic variables for ouput purposes only */
	public double ytd_maxplai;    /* (DIM) year-to-date maximum projected LAI */
	
	public Epvar(double dDay_leafc_litfall_increment,double dDay_frootc_litfall_increment,double dDay_livestemc_turnover_increment,
			double dDay_livecrootc_turnover_increment,double dAnnmax_leafc,double dAnnmax_frootc,double dAnnmax_livestemc,
			double dAnnmax_livecrootc,double dDsr,double dProj_lai,double dAll_lai,double dPlaisun,double dPlaishade,
			double dSun_proj_sla,double dShade_proj_sla,double dPsi,double dVwc,double dDlmr_area_sun,double dDlmr_area_shade,
			double dGl_t_wv_sun,double dGl_t_wv_shade,double dAssim_sun,double dAssim_shade,double dT_scalar,double dW_scalar,
			double dRate_scalar,double dDaily_gross_nmin,double dDaily_gross_nimmob,double dDaily_net_nmin,double dFpi,double dM_tmin,
			double dM_psi,double dM_co2,double dM_ppfd_sun,double dM_ppfd_shade,double dM_vpd,double dM_final_sun,double dM_final_shade,
			double dGl_bl,double dGl_c,double dGl_s_sun,double dGl_s_shade,double dGl_e_wv,double dGl_sh,double dGc_e_wv,double dGc_sh,double dYtd_maxplai){
		
		this.day_leafc_litfall_increment = dDay_leafc_litfall_increment;
		this.day_frootc_litfall_increment = dDay_frootc_litfall_increment;
		this.day_livestemc_turnover_increment = dDay_livestemc_turnover_increment;
		this.day_livecrootc_turnover_increment = dDay_livecrootc_turnover_increment;
		this.annmax_leafc = dAnnmax_leafc;
		this.annmax_frootc = dAnnmax_frootc;
		this.annmax_livestemc = dAnnmax_livestemc;
		this.annmax_livecrootc = dAnnmax_livecrootc;
		this.dsr = dDsr;
		this.proj_lai = dProj_lai;
		this.all_lai = dAll_lai;
		this.plaisun = dPlaisun;
		this.plaishade = dPlaishade;
		this.sun_proj_sla = dSun_proj_sla;
		this.shade_proj_sla = dShade_proj_sla;
		this.psi = dPsi;
		this.vwc = dVwc;
		this.dlmr_area_sun = dDlmr_area_sun;
		this.dlmr_area_shade = dDlmr_area_shade;
		this.gl_t_wv_sun = dGl_t_wv_sun;
		this.gl_t_wv_shade = dGl_t_wv_shade;
		this.assim_sun = dAssim_sun;
		this.assim_shade = dAssim_shade;
		this.t_scalar = dT_scalar;
		this.w_scalar = dW_scalar;
		this.rate_scalar = dRate_scalar;
		this.daily_gross_nmin = dDaily_gross_nmin;
		this.daily_gross_nimmob = dDaily_gross_nimmob;
		this.daily_net_nmin = dDaily_net_nmin;
		this.fpi = dFpi;
		this.m_tmin = dM_tmin;
		this.m_psi = dM_psi;
		this.m_co2 = dM_co2;
		this.m_ppfd_sun = dM_ppfd_sun;
		this.m_ppfd_shade = dM_ppfd_shade;
		this.m_vpd = dM_vpd;
		this.m_final_sun = dM_final_sun;
		this.m_final_shade = dM_final_shade;
		this.gl_bl = dGl_bl;
		this.gl_c = dGl_c;
		this.gl_s_sun = dGl_s_sun;
		this.gl_s_shade = dGl_s_shade;
		this.gl_e_wv = dGl_e_wv;
		this.gl_sh = dGl_sh;
		this.gc_e_wv = dGc_e_wv;
		this.gc_sh = dGc_sh;
		this.ytd_maxplai = dYtd_maxplai;
		
	}

	
	

}
