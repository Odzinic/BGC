package bgclib;

import classes.NDepControl;

public class Get_NDep {

	public double get_ndep(NDepControl ndepctrl, int simyr) {

		int i;

		for (i = 0; i < ndepctrl.ndepvals; i++) {

            if (ndepctrl.ndepyear_array.get(i) == simyr) {

                return (ndepctrl.ndep_array.get(i));
			}
		}

		return (-999.9);
	}

}
