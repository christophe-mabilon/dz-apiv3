package fr.dz.maconnerie.repositories;

import fr.dz.maconnerie.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findFirstByEmail(String email);
    UserEntity findByNameOrEmail(String name, String email);
}
