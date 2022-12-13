package termOne.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class CalculatorDto {
    @Data
    @AllArgsConstructor
    public class DoMathRequest{
        private double operand1;
        private double operand2;
        private double operand3;
    }
}
