package rules;

import entities.Sale;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule(name = "prime-customer-rule", priority = 1)
public class PrimeCustomerRule {

    private double discount;
    public PrimeCustomerRule(){
        this.discount = 0.10;
    }

    @Condition
    public boolean isApplicable(Facts facts) {
        Sale sale = facts.get("sale");
        return sale.getIsPrimeCustomer();
    }

    @Action
    public void calculateDiscount(Facts facts) {
        Sale sale = facts.get("sale");
        sale.setDiscountPercentage(discount);
        double newAmount = sale.getAmount() - sale.getAmount()*discount;
        sale.setAmount(newAmount);
    }
}
