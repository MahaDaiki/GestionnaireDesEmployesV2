package models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Candidate")
public class Candidate extends Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;
    private String skills;
    private String socialSecurityNum;


    public Candidate() {
        super();
    }

    public Candidate(Long candidateId ,String name, String email, String phoneNumber, String password, LocalDate birthdate, String skills, String socialSecurityNum) {
        super(name, email, phoneNumber, password, birthdate);
        this.candidateId = candidateId;
        this.skills = skills;
        this.socialSecurityNum = socialSecurityNum;
    }

    public Long getCandidateId() {
        return candidateId;
    }
    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
    @Override
    public LocalDate getBirthdate() {
        return super.getBirthdate();
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getSocialSecurityNum() {
        return socialSecurityNum;
    }
    public void setSocialSecurityNum(String socialSecurityNum) {
        this.socialSecurityNum = socialSecurityNum;
    }

}

