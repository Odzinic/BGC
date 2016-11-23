package classes;

public class ClimChange {
	
	public double s_tmax;
	public double s_tmin;
	public double s_prcp;
	public double s_vpd;
	public double s_swavgfd;
	
	public ClimChange(double dS_tmax, double dS_tmin, double dS_prcp, double dS_vpd, double dS_swavgfd){
		
		this.s_tmax = dS_tmax;
		this.s_tmin = dS_tmin;
		this.s_prcp = dS_prcp;
		this.s_vpd = dS_vpd;
		this.s_swavgfd = dS_swavgfd;
	}

}
