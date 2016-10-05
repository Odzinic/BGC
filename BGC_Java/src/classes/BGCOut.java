package classes;

import java.io.File;
import classes.Restart_Data;

public class BGCOut {

	Restart_Data restart_output;
	File dayout; /* File containing daily output */
	File monavgout; /* File containing monthly average output */
	File annavgout; /* File containing annual average output */
	File annout; /* File containing annual output */
	File anntext; /* File containing simple annual text output */
	File dayoutascii; /* File containing daily ascii output */
	File monoutascii; /* File containing monthly ascii output */
	File annoutascii; /* File containing annual ascii output */
	double spinup_resid_trend; /* kgC/m2/yr remaining trend after spinup */
	int spinup_years; /* number of years before reaching steady-state */
	char bgc_ascii; /* ASCII output flag */

	public BGCOut(Restart_Data rRestart_output, File fDayout, File fMonavgout, File fAnnavgout, File fAnnout,
			File fAnntext, File fDayoutascii, File fMonoutascii, File fAnnoutascii, double dSpinup_resid_trend,
			int iSpinup_years, char cBgc_ascii) {

		this.restart_output = rRestart_output;
		this.dayout = fDayout;
		this.monavgout = fMonavgout;
		this.annavgout = fAnnavgout;
		this.annout = fAnnout;
		this.anntext = fAnntext;
		this.dayoutascii = fDayoutascii;
		this.monoutascii = fMonoutascii;
		this.annoutascii = fAnnoutascii;
		this.spinup_resid_trend = dSpinup_resid_trend;
		this.spinup_years = iSpinup_years;
		this.bgc_ascii = cBgc_ascii;
	}

}
