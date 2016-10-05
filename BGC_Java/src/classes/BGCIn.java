package classes;

import classes.Restart_Data;
import classes.Control;
import classes.Ramp_Ndep;
import classes.CO2Control;
import classes.NDepControl;
import classes.MetArr;
import classes.WState;
import classes.CInit;
import classes.CState;
import classes.NState;
import classes.Siteconst;
import classes.Epconst;

public class BGCIn {

	public Restart_Data restart_input;
	public Control ctrl;
	public Ramp_Ndep ramp_ndep;
	public CO2Control co2;
	public NDepControl ndepctrl;
	public MetArr metarr;
	public WState ws;
	public CInit cinit;
	public CState cs;
	public NState ns;
	public Siteconst sitec;
	public Epconst epc;

	public BGCIn(Restart_Data rdRestart_input, Control cCtrl, Ramp_Ndep rnRamp_ndep, CO2Control cCo2,
			NDepControl nNdepctrl, MetArr mMetarr, WState wWs, CInit cCinit, CState cCs, NState nNs, Siteconst sSitec,
			Epconst eEpc) {

		this.restart_input = rdRestart_input;
		this.ctrl = cCtrl;
		this.ramp_ndep = rnRamp_ndep;
		this.co2 = cCo2;
		this.ndepctrl = nNdepctrl;
		this.metarr = mMetarr;
		this.ws = wWs;
		this.cinit = cCinit;
		this.cs = cCs;
		this.ns = nNs;
		this.sitec = sSitec;
		this.epc = eEpc;

	}

}
