package code.alencar.utils.Converter;

public class NumberConverter {
    
    public static Double convertToDouble(String strNumber) {
		if (strNumber == null) return Double.NaN; //TODO: retornar exception custom
		//método deverá aceitar os seguntes formatos: BR 10,32 ou US 10.32
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //regex para validar se é um numero que pode conter ponto.
	}
}