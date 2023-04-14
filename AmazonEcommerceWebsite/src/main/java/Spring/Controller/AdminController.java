package Spring.Controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import Spring.Service.CategoryService;
import Spring.Model.Category;


@Controller
public class AdminController {
	
	
	@Autowired
	CategoryService categoryService;
	
	
	
	@GetMapping("/admin")
	public String adminhome()
	{
		return "adminHome";
	}
	
	@GetMapping("/manage")
	public String admi(Model model)
	{
		model.addAttribute("categories", categoryService.getAllCategory());
		return "manage";
	}
	
	@GetMapping("/admin/categories")
	public String cat( Model model)
	{
	
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String catadd(Model model)
	{
		model.addAttribute("category", new Category( ) );
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postcatadd(@ModelAttribute("category") Category category)
	{
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deletcat(@PathVariable int id)
	{
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
		
	}
	
	
	
	@GetMapping("/admin/categories/update/{id}") 
	  public String updatecat(@PathVariable int id, Model model) 
		{
		  Optional<Category> category=categoryService.getCategoryById(id);
		  if(category.isPresent()) 
		  {
			  model.addAttribute("category",category.get());  
		  }
		  else 
		  {
			return "404";
		  }
		  return "categoriesAdd";
		}
	
	
	}