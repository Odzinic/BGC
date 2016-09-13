package classes;

public class Phenology {

	public double remdays_curgrowth; /* days left in current growth season */
	public double remdays_transfer; /* number of transfer days remaining */
	public double remdays_litfall; /* number of litfall days remaining */
	public double predays_transfer; /* number of transfer days previous */
	public double predays_litfall; /* number of litfall days previous */

	public Phenology(double dRemdays_curgrowth, double dRemdays_transfer, double dRemdays_litfall,
			double dPredays_transfer, double dPredays_litfall) {

		this.remdays_curgrowth = dRemdays_curgrowth;
		this.remdays_transfer = dRemdays_transfer;
		this.remdays_litfall = dRemdays_litfall;
		this.predays_transfer = dPredays_transfer;
		this.predays_litfall = dPredays_litfall;

	}

}
