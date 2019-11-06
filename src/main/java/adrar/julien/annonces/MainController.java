package adrar.julien.annonces;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import adrar.julien.annonces.entities.Annonce;
import adrar.julien.annonces.entities.Category;
import adrar.julien.annonces.repositories.AnnonceRepository;
import adrar.julien.annonces.repositories.CategoryRepository;
import adrar.julien.annonces.services.AnnonceService;






@Controller
public class MainController {
	
	@Autowired
	AnnonceRepository annonceRepo;
	@Autowired
	CategoryRepository catRepo; 
	@Autowired
	AnnonceService annonceService;
		
	
	@GetMapping("/")
	
	public String list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, value = 6)  Pageable pageable , Model model) {
		//pageable = PageRequest.of(0, 6, Sort.by(Order.desc("id")));
		System.out.println(pageable);
		Page<Annonce> annonces = annonceRepo.findByActiveTrue(pageable);
		model.addAttribute("annonces", annonces);
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
	
	
	
	/*
	@GetMapping("add")
    public ModelAndView showForm() {
		Annonce annonce = new Annonce();
		List <Category> categories = catRepo.findAll();
		ModelAndView view = new ModelAndView("ajout");
		view.addObject("annonce", annonce);
		view.addObject("categories", categories);
        return view;
    }
	
	@PostMapping("add")
    public String submit(@Valid @ModelAttribute("annonce")Annonce annonce, 
      BindingResult result, ModelMap model) {
		System.out.println(result);
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("title", annonce.getTitle());
        model.addAttribute("description", annonce.getDescription());
        model.addAttribute("dateParution", annonce.getDateParution());
        model.addAttribute("categoryAnnonce", annonce.getCategoryAnnonce());
        return "ajout";
    }*/

}
