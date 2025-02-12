package com.generics.aidrivenresumescreeningsystem;

public class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    public boolean isEligible() {
        return getExperience() >= 5;
    }
}
