package bdd.models.ui;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class Address {

    private String company;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    private String alias;

    public Address(String company, String address, String city, String state, String postalCode, String country, String phone, String alias) {
        this.company = company;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.alias = alias;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getAlias() {
        return alias;
    }

    public static Address initAddress() {
        return new Address(
                "HepsiBurada",
                "Pasific Beach",
                "San Diego",
                "California",
                "34460",
                "United States",
                "5555555",
                randomAlphanumeric(5));

    }
}
