package bgclib;

import java.lang.reflect.Field;
import java.text.MessageFormat;

import classes.Epconst;
import classes.Epvar;
import bgclib.Annual_Rates;

public class Test_Class {

	public static void main(String[] args) {
		Control epv = new Control();
		Field[] s = epv.getClass().getDeclaredFields();

		StringBuilder name = new StringBuilder();

		for (Field field : s) {
			String sFieldName = field.getName();
			String sUpperName = sFieldName.substring(0, 1).toUpperCase() + sFieldName.substring(1); // Make
																									// first
																									// letter
																									// uppercase
			Class<?> sFieldType = field.getType();
			String sTypeLetter = sFieldType.toString().substring(0, 1);

			name.append(MessageFormat.format("{0} {1}{2},", sFieldType, sTypeLetter, sUpperName));
			System.out.println(MessageFormat.format("this.{0} = {1}{2};", sFieldName, sTypeLetter, sUpperName));
		}
		System.out.println(name.toString());
		
//		Epconst epc = new Epconst(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//		Epvar epv = new Epvar(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//	
//		epc.evergreen = 1;
//		epv.day_frootc_litfall_increment = 1.0;
//		Annual_Rates ar = new Annual_Rates();
//		
//		System.out.println(epv.day_frootc_litfall_increment);
//		
//		
//		ar.annual_rates(epc, epv);
//		
//		System.out.println(epv.day_frootc_litfall_increment);
//	
	}

}
