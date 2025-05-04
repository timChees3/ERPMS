package com.toinfinityandbeyong.ERPMS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse
{
    private Long id;
    private String fName;
    private String lName;
    private String username;
    private String email;
    private String phoneNumber;
    private char gender;
    private LocalDate dob;
    private String address;
    private String role;
    private LocalDateTime accountCreationDate;
}
