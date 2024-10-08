package models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Recruiter")
public class Recruiter extends Users {


    public Recruiter() {
        super();
    }


    public Recruiter(String name, String email, String phoneNumber, String password, LocalDate birthdate) {
        super(name, email, phoneNumber, password, birthdate);
    }

}
