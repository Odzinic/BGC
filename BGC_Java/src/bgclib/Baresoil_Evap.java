package bgclib;

import classes.MetVar;
import classes.WFlux;
import classes.PMet;
import bgclib.Canopy_Et;

public class Baresoil_Evap {

    public boolean baresoil_evap(final MetVar metv, WFlux wf, double dsr_ptr) {

		double dsr;
		double rbl;
        double pot_evap;
		double evap;
		PMet pmet_in;
		double rcorr;
		double ratio;

		Canopy_Et ce = new Canopy_Et();

		/* assign days since rain */
		dsr = dsr_ptr;

		/*
		 * correct conductances for temperature and pressure based on Jones
		 * (1992) with standard conditions assumed to be 20 deg C, 101300 Pa
		 */
		rcorr = 1.0 / (Math.pow(((metv.tday + 273.15) / 293.15), 1.75) * (101300 / metv.pa));

		/* new bare-soil evaporation routine */
		/*
		 * first calculate potential evaporation, assuming the resistance for
		 * vapor transport is equal to the resistance for sensible heat
		 * transport. That is, no additional resistance for vapor transport to
		 * the soil surface. This represents evaporation from a wet surface with
		 * a specified aerodynamic resistance (= boundary layer resistance). The
		 * aerodynamic resistance is for now set as a constant, and is taken
		 * from observations over bare soil in tiger-bush in south-west Niger:
		 * rbl = 107 s m-1 (Wallace and Holwill, 1997).
		 */
		rbl = 107.0 * rcorr;

		/* fill the pmet_in structure */
		pmet_in = new PMet(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
		pmet_in.ta = metv.tday;
		pmet_in.pa = metv.pa;
		pmet_in.vpd = metv.vpd;
		pmet_in.irad = metv.swtrans;
		pmet_in.rv = rbl;
        pmet_in.rh = rbl;


        //TODO: Find if pot_evap actually gets calculated
		/* calculate pot_evap in kg/m2/s */
        pot_evap = ce.penmon(pmet_in, 0);

		/* convert to daily total kg/m2 */
		pot_evap *= metv.dayl;

		/* consider only the precipitation flux reaching the soil */
		/* check for precipitation >= potential evaporation */
		if (wf.prcp_to_soilw >= pot_evap) {
			/* reset days-since-rain parameter */
			dsr = 0.0;

			/* soil evaporation proceeds at potential rate */
			evap = 0.6 * pot_evap;
		} else {
			/* increment the days since rain */
			dsr += 1.0;

			/*
			 * calculate the realized proportion of potential evaporation as a
			 * function of the days since rain
			 */
			ratio = 0.3 / Math.pow(dsr, 2.0);

			/* calculate evaporation for dry days */
			evap = ratio * pot_evap;

			/*
			 * for rain events that are smaller than required to reset dsr
			 * counter, but larger than dry-day evaporation, all rain is
			 * evaporated. In this case, do not advance the drying curve
			 * counter. For rain events that are too small to trigger dsr reset,
			 * and which are smaller than dry-day evap, there will be more
			 * evaporation than rainfall. In this case the drying curve counter
			 * is advanced.
			 */
			if (wf.prcp_to_soilw > evap) {
				evap = wf.prcp_to_soilw;
				dsr -= 1.0;
			}
		}

		wf.soilw_evap = evap;
		dsr_ptr = dsr;

        return true;
	}

}
