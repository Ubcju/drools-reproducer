package com.example.ruleunit;

import com.model.*;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

import java.util.ArrayList;
import java.util.List;

public class PersonUnit implements RuleUnitData {

    private final DataStore<Person> people;
    private final DataStore<House> houses;
    private final DataStore<School> schools;
    private final List<String> rulesFired;

    public PersonUnit() {
        this.people = DataSource.createStore();
        this.houses = DataSource.createStore();
        this.schools = DataSource.createStore();
        this.rulesFired = new ArrayList<>();
    }

    public DataStore<Person> getPeople() {
        return people;
    }

    public DataStore<House> getHouses() {
        return houses;
    }

    public DataStore<School> getSchools() {
        return schools;
    }

    public List<String> getRulesFired() {
        return rulesFired;
    }
}

