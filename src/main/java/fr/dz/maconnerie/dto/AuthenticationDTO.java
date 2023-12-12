package fr.dz.maconnerie.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String username;
    private String email;
    private String password;

}
