package fr.dz.maconnerie.controllers;

import fr.dz.maconnerie.dto.SignupDTO;
import fr.dz.maconnerie.dto.UserDTO;
import fr.dz.maconnerie.entities.UserEntity;
import fr.dz.maconnerie.repositories.UserRepository;
import fr.dz.maconnerie.services.auth.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    private AuthService authService;

    private final UserRepository userRepository;

    public SignupController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
        try {
            UserEntity userEntityAlreadyExist = userRepository.findByNameOrEmail(signupDTO.getName(), signupDTO.getEmail());
            if (userEntityAlreadyExist != null) {
                return new ResponseEntity<>("Name or Email already exist!", HttpStatus.BAD_REQUEST);
            }

            UserDTO createdUser = authService.createUser(signupDTO);
            if (createdUser == null) {
                return new ResponseEntity<>("UserEntity not created, please try again later!", HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error during user signup", e);
            return new ResponseEntity<>("An error occurred during user signup.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}