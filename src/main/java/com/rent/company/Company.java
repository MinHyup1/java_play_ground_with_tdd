package com.rent.company;
public interface Company {

    static RantCompany createRantCompany() {
        return new RantCompany();
    }

    String generateReport();
}
