package bgclib;

import classes.CO2Control;

public class Get_CO2 {
	//TODO: Leave as double
	public double get_co2(CO2Control co2, int simyr) {

		int i;
		for (i = 0; i < co2.co2vals; i++) {

            if (co2.co2year_array.get(i) == simyr) {

                return (co2.co2ppm_array.get(i));
			}
		}

		return (-999.9);
	}

}
