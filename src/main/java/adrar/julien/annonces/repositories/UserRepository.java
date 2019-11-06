package adrar.julien.annonces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import adrar.julien.annonces.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
