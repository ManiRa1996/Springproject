package Spring.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Spring.Model.Category;
import Spring.Repository.CategoryRepository;



@Service
public class CategoryService {

	@Autowired 
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id)
	{
		categoryRepository.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id)
	{
		return categoryRepository.findById(id);
	}
}