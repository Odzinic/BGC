package classes;

public class PSn {

	public int c3; /* (flag) set to 1 for C3 model, 0 for C4 model */
	public double pa; /* (Pa) atmospheric pressure */
	public double co2; /* (ppm) atmospheric [CO2] */
	public double t; /* (deg C) temperature */
	public double lnc; /* (kg Nleaf/m2) leaf N per unit sunlit leaf area */
	public double flnr; /* (kg NRub/kg Nleaf) fract. of leaf N in Rubisco */
	public double ppfd; /* (umol/m2/s) PAR flux per unit sunlit leaf area */
	public double g; /* (umol/m2/s/Pa) conductance to CO2 */
	public double dlmr; /* (umol/m2/s) day leaf m. resp, proj. area basis */
	public double Ci; /* (Pa) public intercellular [CO2] */
	public double O2; /* (Pa) atmospheric [O2] */
	public double Ca; /* (Pa) atmospheric [CO2] */
	public double gamma; /* (Pa) CO2 compensation popublic int, no Rd */
	public double Kc; /* (Pa) MM constant carboxylation */
	public double Ko; /* (Pa) MM constant oxygenation */
	public double Vmax; /* (umol/m2/s) max rate carboxylation */
	public double Jmax; /* (umol/m2/s) max rate electron transport */
	public double J; /* (umol/m2/s) rate of RuBP regeneration */
	public double Av; /* (umol/m2/s) carboxylation limited assimilation */
	public double Aj; /* (umol/m2/s) RuBP regen limited assimilation */
	public double A; /* (umol/m2/s) final assimilation rate */

	public PSn(int iC3, double dPa, double dCo2, double dT, double dLnc, double dFlnr, double dPpfd, double dG,
			double dDlmr, double dCi, double dO2, double dCa, double dGamma, double dKc, double dKo, double dVmax,
			double dJmax, double dJ, double dAv, double dAj, double dA) {

		this.c3 = iC3;
		this.pa = dPa;
		this.co2 = dCo2;
		this.t = dT;
		this.lnc = dLnc;
		this.flnr = dFlnr;
		this.ppfd = dPpfd;
		this.g = dG;
		this.dlmr = dDlmr;
		this.Ci = dCi;
		this.O2 = dO2;
		this.Ca = dCa;
		this.gamma = dGamma;
		this.Kc = dKc;
		this.Ko = dKo;
		this.Vmax = dVmax;
		this.Jmax = dJmax;
		this.J = dJ;
		this.Av = dAv;
		this.Aj = dAj;
		this.A = dA;

	}

}
