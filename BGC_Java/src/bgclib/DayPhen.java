package bgclib;

import classes.PhenArray;
import classes.Phenology;

public class DayPhen {

	public int dayphen(final PhenArray phenarr, Phenology phen, int metday) {

		phen.remdays_curgrowth = (double) (phenarr.remdays_curgrowth[metday]);
		phen.remdays_transfer = (double) (phenarr.remdays_transfer[metday]);
		phen.remdays_litfall = (double) (phenarr.remdays_litfall[metday]);
		phen.predays_transfer = (double) (phenarr.predays_transfer[metday]);
		phen.predays_litfall = (double) (phenarr.predays_litfall[metday]);

		return 0;
	}

}
