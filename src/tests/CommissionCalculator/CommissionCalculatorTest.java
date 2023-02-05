package tests.CommissionCalculator;

import entities.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rules.NorthCommissionRule;
import services.CommissionCalculator;

import static org.junit.jupiter.api.Assertions.*;

class CommissionCalculatorTest {

    @Test
    void northSaleCommissionShouldEqualTwentyPercent() {

        CommissionCalculator calculator = new CommissionCalculator();

        Sale sale = new Sale(1000, "NORTH", false);

        calculator.calculate(sale);

        Assertions.assertEquals(0.2, sale.getCommissionPercentage());
    }


    @Test
    void primeCustomerShouldHaveDiscount() {

        final double PRIME_CUSTOMER_DISCOUNT_PERCENT = 0.1;

        CommissionCalculator calculator = new CommissionCalculator();

        Sale sale = new Sale(1000, "NORTH", true);

        calculator.calculate(sale);

        Assertions.assertEquals(PRIME_CUSTOMER_DISCOUNT_PERCENT, sale.getDiscountPercentage());
    }
}