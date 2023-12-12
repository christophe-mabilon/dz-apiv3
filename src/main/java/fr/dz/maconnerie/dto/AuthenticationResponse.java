package fr.dz.maconnerie.dto;


public record AuthenticationResponse(String username, String role, String access_token,String refresh_token ) {

}