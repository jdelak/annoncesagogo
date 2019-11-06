package adrar.julien.annonces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import adrar.julien.annonces.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
