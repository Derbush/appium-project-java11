package projectName.uitests.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import projectName.uitests.pages.CalculatorPage;

public class CalculatorPageObjectTest {

    CalculatorPage calculatorPage = new CalculatorPage();

    @Test
    public void multiplyTest(){
        calculatorPage.clickSingleDigit(3);
        calculatorPage.multiply.click();
        calculatorPage.clickSingleDigit(6);


    }

    @Test
    public void multiplyTest2(){
        /*
        8*5 = 40
         */
        calculatorPage.clickSingleDigit(8);
        calculatorPage.multiply.click();
        calculatorPage.clickSingleDigit(5);
        calculatorPage.equals.click();

        Assertions.assertEquals(40, Integer.parseInt(calculatorPage.result.getText()));



    }
}
