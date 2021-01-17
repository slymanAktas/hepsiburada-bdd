package bdd.models.ui;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class Buyer {
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Buyer(String title, String firstName, String lastName, String email, String password) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static Buyer initBuyer() {
        return new Buyer(
                "Mr",
                "suleyman",
                "aktas",
                "" + randomAlphanumeric(15) + "@hepsiburada.com",
                randomAlphanumeric(5));

    }
}
