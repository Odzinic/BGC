package classes;

import java.util.List;

public class PhenArray {

	public List<Integer> remdays_curgrowth; /*
									 * (nmetdays) days left in current growth
									 * season
									 */
	public List<Integer> remdays_transfer; /*
									 * (nmetdays) number of transfer days
									 * remaining
									 */
	public List<Integer> remdays_litfall; /*
									 * (nmetdays) number of litfall days remaining
									 */
	public List<Integer> predays_transfer; /*
									 * (nmetdays) number of transfer days
									 * previous
									 */
	public List<Integer> predays_litfall; /*
									 * (nmetdays) number of litfall days previous
									 */

	public PhenArray(List<Integer> cRemdays_curgrowth, List<Integer> cRemdays_transfer, List<Integer> cRemdays_litfall, List<Integer> cPredays_transfer,
					 List<Integer> cPredays_litfall) {

		this.remdays_curgrowth = cRemdays_curgrowth;
		this.remdays_transfer = cRemdays_transfer;
		this.remdays_litfall = cRemdays_litfall;
		this.predays_transfer = cPredays_transfer;
		this.predays_litfall = cPredays_litfall;

	}

}
