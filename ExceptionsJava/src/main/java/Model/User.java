package Model;

import java.time.LocalDate;
import java.util.Date;

public class User {

    private String Name;
    private String LastName;
    private String SurName;
    private LocalDate DateOfBirth;
    private long PhoneNumber;
    private  GenderEnum Gender;

    public User(String name, String lastName, String surName, LocalDate dateOfBirth, long phoneNumber, GenderEnum gender) {
        Name = name;
        LastName = lastName;
        SurName = surName;
        DateOfBirth = dateOfBirth;
        PhoneNumber = phoneNumber;
        Gender = gender;
    }


    public String getName() {
        return Name;
    }

    public String getLastName() {
        return LastName;
    }

    public String getSurName() {
        return SurName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public GenderEnum getGender() {
        return Gender;
    }
}
