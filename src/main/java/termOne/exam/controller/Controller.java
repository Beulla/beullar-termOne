package termOne.exam.controller;
import org.springframework.web.bind.annotation.*;
import termOne.exam.Exception.InvalidOperationException;
import termOne.exam.service.CalculatorService;
@RestController
@RequestMapping("/calculate")
public class Controller {
    CalculatorService service=new CalculatorService();
        @GetMapping("/")
        public Double operation(@RequestBody double operand1, @RequestBody double operand2, @RequestBody String operation  ) throws InvalidOperationException {
            Double result = service.doMath(operand1, operand2, operation);
            return result;

        }


    }

