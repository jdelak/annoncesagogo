package adrar.julien.annonces.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import adrar.julien.annonces.entities.Annonce;
import adrar.julien.annonces.repositories.AnnonceRepository;

@Service
public class AnnonceService {
	
	@Autowired
	AnnonceRepository annonceRepository;
	
	
	
	
	

}
