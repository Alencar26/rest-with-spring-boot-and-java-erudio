package code.alencar;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

	private static final String templete = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//Exemplo de RequestParams (parâmetros opcionais)
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "world")
			String name) {
		return new Greeting(counter.incrementAndGet(), String.format(templete, name));
	}

	//Exemplo de PathVariable (parâmetros obrigatórios)
	@RequestMapping(value ="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception("Não é permitido passar valores não numéricos. Verifique os valores informados na URL");
		} 
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return Double.NaN; //TODO: retornar exception custom
		//método deverá aceitar os seguntes formatos: BR 10,32 ou US 10.32
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //regex para validar se é um numero que pode conter ponto.
	}
}
