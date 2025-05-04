package com.toinfinityandbeyong.ERPMS.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest
{
    @NotBlank @Size(min = 2, max = 50)
    private String fName;

    @NotBlank @Size(min = 2, max = 50)
    private String lName;

    @NotBlank
    private String username;

    @NotBlank @Email
    private String email;

    @NotBlank @Size(min = 8)
    private String password;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phoneNumber;

    @NotBlank
    private LocalDate dob;

    @NotBlank
    private String address;

    @NotBlank
    private char gender;

    @NotBlank @Pattern(regexp = "^(PATIENT|DOCTOR|ADMIN)$")
    private String userType;

    // Patient:
    private String bloodType;
    private Double height;
    private Double weight;
    private String allergies;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // Doctor:
    private String specialization;
    private String licenseNumber;
    private String degrees;
    private int yearsOfExperience;
    private String workingHours;

    // Admin:
    private String department;
    private String position;
    private String adminLevel;
}
