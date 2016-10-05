package classes;

public class PhenArray {

	public int[] remdays_curgrowth; /*
									 * (nmetdays) days left in current growth
									 * season
									 */
	public int[] remdays_transfer; /*
									 * (nmetdays) number of transfer days
									 * remaining
									 */
	public int[] remdays_litfall; /*
									 * (nmetdays) number of litfall days remaining
									 */
	public int[] predays_transfer; /*
									 * (nmetdays) number of transfer days
									 * previous
									 */
	public int[] predays_litfall; /*
									 * (nmetdays) number of litfall days previous
									 */

	public PhenArray(int[] cRemdays_curgrowth, int[] cRemdays_transfer, int[] cRemdays_litfall, int[] cPredays_transfer,
			int[] cPredays_litfall) {

		this.remdays_curgrowth = cRemdays_curgrowth;
		this.remdays_transfer = cRemdays_transfer;
		this.remdays_litfall = cRemdays_litfall;
		this.predays_transfer = cPredays_transfer;
		this.predays_litfall = cPredays_litfall;

	}

}
