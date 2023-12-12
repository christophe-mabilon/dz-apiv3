package fr.dz.maconnerie.services.auth;

import fr.dz.maconnerie.dto.SignupDTO;
import fr.dz.maconnerie.dto.UserDTO;
import fr.dz.maconnerie.entities.UserEntity;
import fr.dz.maconnerie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupDTO signupDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(signupDTO.getName());
        userEntity.setEmail(signupDTO.getEmail());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        UserEntity createdUserEntity = userRepository.save(userEntity);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUserEntity.getId());
        userDTO.setEmail(createdUserEntity.getEmail());
        userDTO.setName(createdUserEntity.getName());
        return userDTO;
    }
}
