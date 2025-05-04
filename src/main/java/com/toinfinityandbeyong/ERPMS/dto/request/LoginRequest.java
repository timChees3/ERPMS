package com.toinfinityandbeyong.ERPMS.dto.request;


import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest
{
    @NotBlank
    private String username;

    @NotBlank  @Size(min = 8)
    private String password;
}
