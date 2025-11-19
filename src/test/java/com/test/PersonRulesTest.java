package com.test;

import com.model.*;
import com.example.ruleunit.PersonUnit;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonRulesTest {

    @Test
    public void testThatBothRulesTriggered() {
        PersonUnit personUnit = new PersonUnit();
        Person person = new Person();
        person.getChildren().add(new Child(25));
        personUnit.getPeople().add(person);
        personUnit.getHouses().add(new House());
        int rulesFired;

        try (RuleUnitInstance<PersonUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(personUnit)) {
            rulesFired = instance.fire();
        } catch (Exception e) {
            throw new IllegalStateException("Failed to execute rule unit.", e);
        }

        System.out.println("Number of rules fired: " + rulesFired);
        System.out.println("Names of rules fired: " + personUnit.getRulesFired());
        assertTrue(personUnit.getRulesFired().contains("rule1"), "Rule 1 should have fired");
        assertTrue(personUnit.getRulesFired().contains("rule2"), "Rule 2 should have fired");
    }
}

