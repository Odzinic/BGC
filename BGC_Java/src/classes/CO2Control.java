package classes;

public class CO2Control {

	public int varco2;
	public double co2ppm;
	public double[] co2ppm_array;
	public int[] co2year_array;
	public int co2vals;

	public CO2Control(int iVarco2, double dCo2ppm, double[] dCo2ppm_array, int[] dCo2year_array, int iCo2vals) {
		
		this.varco2 = iVarco2;
		this.co2ppm = dCo2ppm;
		this.co2ppm_array = dCo2ppm_array;
		this.co2year_array = dCo2year_array;
		this.co2vals = iCo2vals;
	}

}
