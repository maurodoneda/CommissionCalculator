package services;

import entities.Sale;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import rules.*;

public class CommissionCalculator {
    private RulesEngine rulesEngine;
    private Rules rules;

    public CommissionCalculator() {
        rulesEngine = new DefaultRulesEngine();
        rules = new Rules();

        NorthCommissionRule northRegionRule = new NorthCommissionRule(0.20,"NORTH");
        rules.register(northRegionRule);

        SouthCommissionRule southRegionRule = new SouthCommissionRule(0.15, "SOUTH");
        rules.register(southRegionRule);

        EastCommissionRule eastRegionRule = new EastCommissionRule(0.10, "EAST");
        rules.register(eastRegionRule);

        WestCommissionRule westRegionRule = new WestCommissionRule(0.05, "WEST");
        rules.register(westRegionRule);

        PrimeCustomerRule primeCustomerRule = new PrimeCustomerRule();
        rules.register(primeCustomerRule);
    }

    public void calculate(Sale sale) {
        Facts facts = new Facts();
        facts.put("sale", sale);

        //find rule for region
        rulesEngine.fire(rules, facts);
    }
}






