package vernon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vernon.dao.ProjectDAO;
import vernon.model.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * Our main controller
 * @author Vernon Zidana
 */

@Controller
public class MainController {

	@Autowired
	private ProjectDAO projectDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listProjects(ModelAndView model) throws IOException{
		List<Project> listProjects = projectDAO.list();
		model.addObject("listProjects", listProjects);
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping(value = "/newProject", method = RequestMethod.GET)
	public ModelAndView newProject(ModelAndView model) {
		Project newProject = new Project();
		model.addObject("project", newProject);
		model.setViewName("newProject");
		return model;
	}
	
	
	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public ModelAndView saveProject(@ModelAttribute Project project) {
		projectDAO.saveOrUpdate(project);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
	public ModelAndView deleteProject(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("id"));
		projectDAO.delete(projectId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public ModelAndView editProject(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectDAO.get(projectId);
		ModelAndView model = new ModelAndView("editProject");
		model.addObject("project", project);
		
		return model;
	}
	
	@RequestMapping(value = "/projectDescription", method = RequestMethod.GET)
	public ModelAndView projectDescription(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectDAO.get(projectId);
		ModelAndView model = new ModelAndView("inforPage");
		model.addObject("project", project);
		
		return model;
	}
	
//	@RequestMapping(value="/home")
//	public ModelAndView home(ModelAndView model) throws IOException{
//		List<Contact> listContact = contactDAO.list();
//		model.addObject("listContact", listContact);
//		model.setViewName("home");
//		
//		return model;
//	}
//	
	
}
