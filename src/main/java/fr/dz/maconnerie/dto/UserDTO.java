package fr.dz.maconnerie.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String email;
    private String role;

}
