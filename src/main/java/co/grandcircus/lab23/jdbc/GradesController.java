package co.grandcircus.lab23.jdbc;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.jdbcintro.entity.Grades;
import co.grandcircus.lab23.jdbc.dao.GradesDao;

@Controller
public class GradesController {
	
	// Autowired tells spring to fill in the dao variable automatically
	// when the application starts.
	@Autowired
	private GradesDao dao;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/grades";
	}

	@RequestMapping("/grades")
	public String list(Model model) {
		List<Grades> grades = dao.findAll();
		model.addAttribute("grades", grades);
		return "list";
	}
	
	@RequestMapping("/grades/detail")
	public String detail(@RequestParam("id") Long id, Model model) {
		Grades grades = dao.findById(id);
		model.addAttribute("grades", grades);
		return "detail";
	}
	
	@RequestMapping("/grades/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Grades grades = dao.findById(id);
		model.addAttribute("grades", grades);
		return "edit";
	}
	
	@PostMapping("/grades/edit")
	public String save(@RequestParam("id") Long id, Grades grades) {
		dao.update(grades);
		return "redirect:/grades/detail?id=" + id;
	}
	
	@RequestMapping("/grades/add")
	public String showAdd() {		
		return "add";
	}
	
	@PostMapping("/grades/add")
	public String submitAdd(Grades grades) {	
		dao.create(grades);
		return "redirect:/grades";
	}
	
	@RequestMapping("/grades/delete")
	public String remove(@RequestParam("id") Long id) {
		dao.delete(id);
		return "redirect:/grades";
	}
	@RequestMapping("/grades/newgrade")
	public String newGrade() {		
		return "newgrade";
	}
}