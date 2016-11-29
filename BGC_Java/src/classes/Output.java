package classes;

import java.io.File;

public class Output {

	public int onscreen;
	public String outprefix;
	public int dodaily;
	public int domonavg; /* flag for monthly average output */
	public int doannavg; /* flag for annual average output */
	public int doannual; /* flag for annual output */
	public int ndayout; /* number of custom daily outputs */
	public int nannout; /* number of custom annual outputs */
	public int[] daycodes; /* array of indices for daily outputs */
	public int[] anncodes; /* array of indices for annual outputs */
	public File dayout; /* daily output File */
	public File monavgout; /* monthly average output File */
	public File annavgout; /* annual average output File */
	public File annout; /* annual output File */
	public File anntext; /* simple annual text output */
	public File dayoutascii; /* ASCII daily output File */
	public File monoutascii; /* ASCII monthly output File */
	public File annoutascii; /* ASCII annual output File */
	public int bgc_ascii;

	public Output(int iOnscreen, String sOutprefix, int iDodaily, int iDomonavg, int iDoannavg, int iDoannual,
			int iNdayout, int iNannout, int[] iDaycodes, int[] iAnncodes, File fDayout, File fMonavgout, File fAnnavgout,
			File fAnnout, File fAnntext, File fDayoutascii, File fMonoutascii, File fAnnoutascii, int sBgc_ascii) {

		this.onscreen = iOnscreen;
		this.outprefix = sOutprefix;
		this.dodaily = iDodaily;
		this.domonavg = iDomonavg;
		this.doannavg = iDoannavg;
		this.doannual = iDoannual;
		this.ndayout = iNdayout;
		this.nannout = iNannout;
		this.daycodes = iDaycodes;
		this.anncodes = iAnncodes;
		this.dayout = fDayout;
		this.monavgout = fMonavgout;
		this.annavgout = fAnnavgout;
		this.annout = fAnnout;
		this.anntext = fAnntext;
		this.dayoutascii = fDayoutascii;
		this.monoutascii = fMonoutascii;
		this.annoutascii = fAnnoutascii;
		this.bgc_ascii = sBgc_ascii;

	}

}
