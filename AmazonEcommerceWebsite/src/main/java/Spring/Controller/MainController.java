package Spring.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
@Controller
public class MainController {
	
	
		
		
		@RequestMapping("/login")
		public String login()
		{
			return "login";
			
		}
		
		@RequestMapping("/loginData")
		public String loginData(HttpServletRequest req, Map<String, String> m)
		{
			String name = req.getParameter("username");
			m.put("name", name);
			return "dispaly";	
		}
		
		@RequestMapping("/register")
		public String register()
		{
			return "register";	
		}
		
	}