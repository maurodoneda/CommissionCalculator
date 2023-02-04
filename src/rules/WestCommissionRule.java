package rules;

import entities.Sale;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;

@Rule(name = "west-region-rule")
public class WestCommissionRule {
    private double commissionPercentage;
    private String region;

    public WestCommissionRule(double commissionPercentage, String region) {

        this.commissionPercentage = commissionPercentage;
        this.region = region;
    }

    @Condition
    public boolean isApplicable(Facts facts) {
        Sale sale = facts.get("sale");
        return sale.getRegion().equals(region);
    }

    @Action
    public void calculateCommission(Facts facts) {
        Sale sale = facts.get("sale");
        double commission = sale.getAmount() * commissionPercentage;
        sale.setCommission(commission);
        sale.setCommissionPercentage(commissionPercentage);
    }
}
