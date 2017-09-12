package classes;

import java.util.ArrayList;
import java.util.List;

//Converted double arrays to double ArrayLists
public class MetArr {

    public List<Double> tmax; /* (deg C) daily maximum air temperature */
    public List<Double> tmin; /* (deg C) daily minimum air temperature */
    public List<Double> prcp; /* (cm) precipitation */
    public List<Double> vpd; /* (Pa) vapor pressure deficit */
    public List<Double> swavgfd; /* (W/m2) daylight avg shortwave flux density */
    public List<Double> par; /* (W/m2) photosynthetically active radiation */
    public List<Double> dayl; /* (s) daylength */
    public List<Double> tavg; /* (deg C) daily average temperature */
    public List<Double> tavg_ra; /* (deg C) 11-day running avg of daily avg temp */

    public MetArr(List<Double> cTmax, List<Double> cTmin, List<Double> cPrcp, List<Double> cVpd, List<Double> cSwavgfd, List<Double> cPar,
                  List<Double> cDayl, List<Double> cTavg, List<Double> cTavg_ra) {

        this.tmax = cTmax;
        this.tmin = cTmin;
        this.prcp = cPrcp;
        this.vpd = cVpd;
        this.swavgfd = cSwavgfd;
        this.par = cPar;
        this.dayl = cDayl;
        this.tavg = cTavg;
        this.tavg_ra = cTavg_ra;
    }

}
