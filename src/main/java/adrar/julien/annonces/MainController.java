package adrar.julien.annonces;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import adrar.julien.annonces.entities.Annonce;
import adrar.julien.annonces.entities.Category;
import adrar.julien.annonces.entities.User;
import adrar.julien.annonces.repositories.AnnonceRepository;
import adrar.julien.annonces.repositories.CategoryRepository;
import adrar.julien.annonces.repositories.UserRepository;
import adrar.julien.annonces.services.AnnonceService;




@Controller
public class MainController {
	
	@Autowired
	AnnonceRepository annonceRepo;
	@Autowired
	CategoryRepository catRepo; 
	@Autowired
	AnnonceService annonceService;
	@Autowired
	UserRepository userRepo;
		
	
	@GetMapping("/")
	
	public String list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, value = 6)  Pageable pageable , Model model) {
		//pageable = PageRequest.of(0, 6, Sort.by(Order.desc("id")));
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

		String username = loggedInUser.getName();
		User user = userRepo.findByUsername(username);
		long userId = user.getId();
		
		Object customUser = loggedInUser.getPrincipal().toString();
		
		System.out.println(customUser);

		Page<Annonce> annonces = annonceRepo.findByActiveTrue(pageable);
		model.addAttribute("annonces", annonces);
		model.addAttribute("username", username);
		model.addAttribute("id", userId);
		return "annonces";
	}
	

	
	@PostMapping("/")
	public ModelAndView search (HttpServletRequest request) {
		String search = "";
		ModelAndView view = new ModelAndView("index");
         
        search = (String) request.getParameter("search");
        System.out.println(search);
        List<Annonce> annonces = annonceRepo.findByTitleContainingIgnoreCase(search);
        System.out.println(annonces);
        view.addObject("annonces", annonces);
		return view;
			
	}
	
	@GetMapping("/annonces/add")
	public ModelAndView formulaireAnnonce() {
		List <Category> categories = catRepo.findAll();
		ModelAndView view = new ModelAndView("ajoutannonce");
		view.addObject("categories", categories);
		return view;
	}
	
	@PostMapping("/annonces/add")
	public ModelAndView ajouterAnnonce(HttpServletRequest request, Annonce a) {
		
		int categoryId = Integer.parseInt(request.getParameter("category_annonce"));
		Category category = catRepo.getOne(categoryId);
		a.setCategoryAnnonce(category);
		
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		User user = userRepo.findByUsername(username);
		a.setUserAnnonce(user);
		
		annonceRepo.save(a);
		
		List<Annonce> annonces = annonceRepo.findAll();
		ModelAndView view = new ModelAndView("index");
		view.addObject("annonces", annonces);
		return view;
	}
	
	@GetMapping("annonces/{id}")
	public ModelAndView showAnnonce(@PathVariable long id) {
		ModelAndView view = new ModelAndView("annonce");

		Annonce annonce = annonceRepo.getOne(id);
		
		view.addObject("annonce", annonce);
		
		
		return view;
	}
	
	
	@GetMapping("annonces/edit/{id}")
	public ModelAndView formEditAnnonce(@PathVariable long id) {
		ModelAndView view = new ModelAndView("editannonce");
		List <Category> categories = catRepo.findAll();
		Annonce annonce = annonceRepo.getOne(id);
		view.addObject("categories", categories);
		view.addObject("annonce", annonce);
		
		return view;
	}
	
	@PostMapping("annonces/edit/{id}")
	public ModelAndView editAnnonce(HttpServletRequest request, Annonce a) {
		
		int categoryId = Integer.parseInt(request.getParameter("category_annonce"));
		Category category = catRepo.getOne(categoryId);
		a.setCategoryAnnonce(category);
		
		annonceRepo.save(a);
		
		List<Annonce> annonces = annonceRepo.findAll();
		ModelAndView view = new ModelAndView("index");
		view.addObject("annonces", annonces);
		return view;
	}
	
	@GetMapping("/annonces/moderate")
    public ModelAndView activerAnnonce() {
		List<Annonce> annonces = annonceRepo.findByActiveFalse();
		ModelAndView view = new ModelAndView("moderate");
		view.addObject("annonces", annonces);
		return view;
    }
	
	@GetMapping("/annonces/activate/{id}")	
	public void activate(@PathVariable Long id){
		Annonce annonce = annonceRepo.getOne(id);
		annonce.setActive(true);
		annonceRepo.save(annonce);

	}
	
	
	
	

}
