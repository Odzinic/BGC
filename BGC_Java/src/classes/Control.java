package classes;

public class Control {

	public int metyears; /* # years of met data */
	public int simyears; /* # years of simulation */
	public int simstartyear; /* first year of simulation */
	public int spinup; /* (flag) 1=spinup run, 0=normal run */
	public int maxspinyears; /* maximum number of years for spinup run */
	public int dodaily; /* flag for daily output */
	public int domonavg; /* flag for monthly average of daily outputs */
	public int doannavg; /* flag for annual average of daily outputs */
	public int doannual; /* flag for annual output */
	public int ndayout; /* number of daily outputs */
	public int nannout; /* number of annual outputs */
	public int[] daycodes; /* array of indices for daily outputs */
	public int[] anncodes; /* array of indices for annual outputs */
	public int read_restart; /* flag to read restart file */
	public int write_restart; /* flag to write restart file */
	public int keep_metyr; /* (flag) 1=retain restart metyr, 0=reset metyr */
	public int onscreen; /* (flag) 1=show progress on-screen 0=don't */

	public Control(int iMetyears, int iSimyears, int iSimstartyear, int iSpinup, int iMaxspinyears, int iDodaily,
			int iDomonavg, int iDoannavg, int iDoannual, int iNdayout, int iNannout, int[] iDaycodes, int[] iAnncodes,
			int iRead_restart, int iWrite_restart, int iKeep_metyr, int iOnscreen) {

		this.metyears = iMetyears;
		this.simyears = iSimyears;
		this.simstartyear = iSimstartyear;
		this.spinup = iSpinup;
		this.maxspinyears = iMaxspinyears;
		this.dodaily = iDodaily;
		this.domonavg = iDomonavg;
		this.doannavg = iDoannavg;
		this.doannual = iDoannual;
		this.ndayout = iNdayout;
		this.nannout = iNannout;
		this.daycodes = iDaycodes;
		this.anncodes = iAnncodes;
		this.read_restart = iRead_restart;
		this.write_restart = iWrite_restart;
		this.keep_metyr = iKeep_metyr;
		this.onscreen = iOnscreen;
	}
}
