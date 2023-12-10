package fr.dz.maconnerie.services.auth;

import fr.dz.maconnerie.dto.SignupDTO;
import fr.dz.maconnerie.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
