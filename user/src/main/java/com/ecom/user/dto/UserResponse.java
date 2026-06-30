package com.ecom.user.dto;

import com.ecom.user.models.UserRole;
import lombok.Data;

@Data
public class UserResponse {
    private String id;
    //ketcloak id is optional here, may not be necessary to show
    private String keycloakId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role;
    private AddressDTO address;
}
