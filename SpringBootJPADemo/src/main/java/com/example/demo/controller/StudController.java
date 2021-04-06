package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Controller
public class StudController {
	@Autowired
	StudentDao repo;

	@RequestMapping(path = "/home")
	public String home() {
		return "loginPage";
	}

	@RequestMapping(path = "/login")
	public ModelAndView login(@RequestParam("sid") int sid, @RequestParam("password") String password) {
		Student stud = repo.getOne(sid);
		List<Student> listStud = repo.findAll();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentHome");
		if (stud != null) {
			if (password.equals(stud.getPassword())) {
				mv.addObject("allStudent", listStud);
			} else {
				mv.addObject("allStudent", null);
			}
		}
		return mv;
	}

	@RequestMapping(path = "/addStudentInfo")
	public ModelAndView addStudentInfo(Student stud) {
		repo.save(stud);

		List<Student> listStud = repo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentHome");
		mv.addObject("allStudent", listStud);
		return mv;
	}

	@RequestMapping(path = "/addStudent")
	public ModelAndView addStudent() {
		Student stud = new Student();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addStudentInfo");
		mv.addObject("student", stud);
		return mv;
	}

	@RequestMapping("/getAllStudent")
	public ModelAndView getAllStudent() {
		ModelAndView mv = new ModelAndView();
		List<Student> listStud = repo.findAll();
		mv.setViewName("studentHome");
		mv.addObject("allStudent", listStud);
		return mv;
	}

	@RequestMapping("/editStud/{sid}")
	public String editStudent(@PathVariable("sid") int sid, Model mv) {
		Student stud = repo.getOne(sid);
		mv.addAttribute("student", stud);
		return "editInfoPage";
	}

	@RequestMapping("/update")
	public String update(Student stud) {
		
		repo.saveAndFlush(stud);		
		return "redirect:/getAllStudent";
	}

	@RequestMapping("/deleteStud/{sid}")
	public String deleteStudent(@PathVariable("sid") int sid) {
		repo.deleteById(sid);
		return "redirect:/getAllStudent";
	}
	
	
	@RequestMapping(path = "/registrationForm")
	public String registerStudent() {
		return "registrationPage";
	}
	@RequestMapping(path = "/registerStud")
	public String registerStudent(Student stud) {
		repo.save(stud);
		return "redirect:/home";
	}
	
	@RequestMapping(path = "/studentHome")
	public ModelAndView studentHome() {
		List<Student> listStud = repo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("studentHome");
		mv.addObject("allStudent", listStud);
		return mv;
	}
	
}
