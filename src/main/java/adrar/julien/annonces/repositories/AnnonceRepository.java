package adrar.julien.annonces.repositories;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import adrar.julien.annonces.entities.Annonce;


@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

	@OrderBy("annonce_id DESC")
	List<Annonce> findByTitleContainingIgnoreCase(String title);
	

	Page<Annonce> findByActiveTrue(Pageable pageable);
	
	List<Annonce> findByActiveFalse();
	
	
}
