package code.alencar;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import code.alencar.exceptions.UnsupportedMathOperationException;

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
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		} 
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	@RequestMapping(value ="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}

	@RequestMapping(value ="/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}

	@RequestMapping(value ="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}

	@RequestMapping(value ="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	}

	@RequestMapping(value ="/raiz/{numberOne}", method = RequestMethod.GET)
	public Double raiz(	@PathVariable(value = "numberOne") String numberOne) throws Exception {
		if (!isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return Math.sqrt(convertToDouble(numberOne));
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
