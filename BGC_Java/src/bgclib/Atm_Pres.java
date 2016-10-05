package bgclib;

import classes.Constant;

public class Atm_Pres {

	public int atm_pres(double elev, double pa) {

		double t1;
		double t2;

		double LR_STD = Constant.LR_STD.getValue();
		double T_STD = Constant.T_STD.getValue();
		double G_STD = Constant.G_STD.getValue();
		double R = Constant.R.getValue();
		double MA = Constant.MA.getValue();
		double P_STD = Constant.P_STD.getValue();

		t1 = 1.0 - (LR_STD * elev) / T_STD;
		t2 = G_STD / (LR_STD * (R / MA));
		pa = P_STD * Math.pow(t1, t2);

		return 0;
	}

}
