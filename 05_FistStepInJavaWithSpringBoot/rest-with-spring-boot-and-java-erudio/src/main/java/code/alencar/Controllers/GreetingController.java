package code.alencar.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import code.alencar.Greeting;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import code.alencar.exceptions.UnsupportedMathOperationException;
import code.alencar.utils.Converter.NumberConverter;
import code.alencar.utils.Math.SimpleMath;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

	private static final String templete = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
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
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		} 
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value ="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value ="/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value ="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value ="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(	@PathVariable(value = "numberOne") String numberOne,
						@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value ="/raiz/{numberOne}", method = RequestMethod.GET)
	public Double raiz(	@PathVariable(value = "numberOne") String numberOne) throws Exception {
		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Por favor, informe um valor numérico.");
		}
		return math.raiz(NumberConverter.convertToDouble(numberOne));
	}
}
