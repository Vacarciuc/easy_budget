package com.example.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table (name = "tabel_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty(message = "The first name cannot be empty")
    @Size(min = 3, message = "The first name field must greater the 3 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "The last name cannot be empty")
    @Size(min = 3, message = "The first name field must greater the 3 characters")
    @Column(name = "last_name")
    private String lastName;

    @Email
    @NotEmpty
    @Pattern(regexp = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})",
            message = "Please Insert a Valid Email")
    @Column(name = "email")
    private String email;

    @NotEmpty
    @NotNull
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "data_of_birth")
    private LocalDate dateOfBirth;


    public UUID getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
