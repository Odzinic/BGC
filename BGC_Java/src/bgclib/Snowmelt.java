package bgclib;

import classes.MetVar;
import classes.WFlux;

public class Snowmelt {

	public int snowmelt(final MetVar metv, WFlux wf, double snoww) {

		final double sn_abs = 0.6;
		final double lh_fus = 335.0;
		final double lh_sub = 2845.0;
		final double tcoef = 0.65;
		double rn;
		double melt, tmelt, rmelt, rsub;

		/* canopy transmitted radiation: convert from W/m2 -. KJ/m2/d */
		rn = metv.swtrans * metv.dayl * sn_abs * 0.001;
		tmelt = rmelt = rsub = 0.0;

		if (metv.tavg > 0.0) /* temperature and radiaiton melt from snowpack */

		{
			tmelt = tcoef * metv.tavg;
			rmelt = rn / lh_fus;
			melt = tmelt + rmelt;

			if (melt > snoww)
				melt = snoww;

			wf.snoww_to_soilw = melt;
		} else /* sublimation from snowpack */
		{
			rsub = rn / lh_sub;

			if (rsub > snoww)
				rsub = snoww;

			wf.snoww_subl = rsub;
		}

		return 0;
	}

}
