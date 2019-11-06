package adrar.julien.annonces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import adrar.julien.annonces.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
