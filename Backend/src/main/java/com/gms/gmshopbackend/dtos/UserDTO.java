package com.gms.gmshopbackend.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
//    private Long id;

    @JsonProperty(value = "fullname")
    private String fullName;

    @JsonProperty(value = "phone_number")
    @Size(max = 10)
    @NotEmpty(message = "phone number is required")
    private String phoneNumber;

    @Size(max = 200)
    private String address;

    @Size(max = 100)
    private String password;

    @JsonProperty(value = "is_active")
    private boolean isActive;

    @JsonProperty(value = "date_of_birth")
    private LocalDate dateOfBirth;

    @JsonProperty(value = "facebook_account_id")
    private Long facebookAccountId;

    @JsonProperty(value = "google_account_id")
    private Long googleAccountId;

    @JsonProperty(value = "role_id")
    private Long roleId;

    private String email;

}
