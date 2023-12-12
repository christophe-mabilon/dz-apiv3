package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.dto.AuthenticationDTO;
import fr.dz.maconnerie.dto.AuthenticationResponse;
import fr.dz.maconnerie.services.jwt.UserDetailsServiceImpl;
import fr.dz.maconnerie.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword()));
        } catch (BadCredentialsException | DisabledException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Incorrect username, password, or user is not activated");
            return null;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return new AuthenticationResponse(authenticationDTO.getUsername(), "ADMIN", jwt,jwt);
    }

}
