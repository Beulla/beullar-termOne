package termOne.exam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import termOne.exam.Exception.InvalidOperationException;
import termOne.exam.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTests {
    private CalculatorService _calculatorService = new CalculatorService();

    @Test
    void doAdditionSuccess() throws InvalidOperationException {
        assertEquals(10,_calculatorService.doMath(5,5,"+"));
    }

    @Test
    void doAdditionFild() throws InvalidOperationException {
        assertEquals(3, _calculatorService.doMath(20,30,"+"));
    }

    @Test
    void doSubtraction() throws InvalidOperationException {
        assertEquals(4,_calculatorService.doMath(5,1,"-"));
    }

    @Test
    void doDivision() throws InvalidOperationException {
        assertEquals(2,_calculatorService.doMath(4,2,"/"));
    }

    @Test
    void faileddivision() throws InvalidOperationException {
        assertEquals(2,_calculatorService.doMath(10,2,"/"));
    }

    @Test
    void doMultiplication() throws InvalidOperationException {
        assertEquals(18,_calculatorService.doMath(3,6,"*"));
    }
    @Test
    void Multiplicationfailed() throws InvalidOperationException {
        assertEquals(10,_calculatorService.doMath(3,3,"*"));
    }
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void failed_404() {
        ResponseEntity result = this.restTemplate.getForEntity("/calculate", new int[]{2, 3, "+"});

        assertTrue(result.getStatusCode().is2xxSuccessful());
        assertEquals(5, result.getBody());
    }


}