package fr.dz.maconnerie.repositories;

import fr.dz.maconnerie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);
    User findByNameOrEmail(String name,String email);
}
