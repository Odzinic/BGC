package bgclib;

import classes.MetVar;
import classes.MetArr;

public class DayMet {

	public int daymet(final MetArr metarr, MetVar metv, int metday) {

		/* generates daily meteorological variables from the metarray struct */
		double tmax;
		double tmin;
		double tavg;
		double tday;

		/* convert prcp from cm -. kg/m2 */
		metv.prcp = metarr.prcp[metday];

		/* air temperature calculations (all temperatures deg C) */
		metv.tmax = tmax = metarr.tmax[metday];
		metv.tmin = tmin = metarr.tmin[metday];
		metv.tavg = tavg = metarr.tavg[metday];
		metv.tday = tday = 0.45 * (tmax - tavg) + tavg;
		metv.tnight = (tday + tmin) / 2.0;

		/*
		 * for this version, an 11-day running weighted average of daily average
		 * temperature is used as the soil temperature at 10 cm. For days 1-10,
		 * a 1-10 day running weighted average is used instead. The tail of the
		 * running average is weighted linearly from 1 to 11. There are no
		 * corrections for snowpack or vegetation cover.
		 */
		metv.tsoil = metarr.tavg_ra[metday];

		/* daylight average vapor pressure deficit (Pa) */
		metv.vpd = metarr.vpd[metday];

		/* daylight average shortwave flux density (W/m2) */
		metv.swavgfd = metarr.swavgfd[metday];

		/* PAR (W/m2) */
		metv.par = metarr.par[metday];

		/* daylength (s) */
		metv.dayl = metarr.dayl[metday];

		return 0;
	}

}
