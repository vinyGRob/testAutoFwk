package tests;

import framework.core.BaseTest;
import org.testng.annotations.Test;
import calculator.ScientificPage;

public class LaunchCalcTest extends BaseTest {

    @Test
    public void launchCalcTest() throws InterruptedException {
        ScientificPage scientificPage = new ScientificPage(getDriver());


    }
}