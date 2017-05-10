package phonebook.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Sasha on 16.03.2017.
 */
public class Contact implements Serializable {
     private String firstname;
     private String larstname;
     private String email;
     private LocalDate birthday;
     private String address;

    public Contact(String firstname, String larstname, String email, LocalDate birthday, String address) {
        this.firstname = firstname;
        this.larstname = larstname;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
    }

    public Contact() {

    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstname='" + firstname + '\'' +
                ", larstname='" + larstname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String larstname) {
        this.larstname = larstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return larstname;
    }


}
