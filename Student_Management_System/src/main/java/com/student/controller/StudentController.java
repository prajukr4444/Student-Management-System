package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.dao.StudentDao;
import com.student.dto.Student;

@Controller
public class StudentController 
{
	// Dependency Injection --> Injecting bean/object of StudentDao
	@Autowired 	// it injects the object of studentDao into controller class (creates object of 
				// StudentDao without using new keyword)
	private StudentDao studentDao;
	
	
	// It is the base mapping of our project, whenever we run our project the request will
	// and hit this particular method all the time.
	
	// Here, we have set a view for "home.jsp" so that file will be rendered on my browser
	// and no object/model is added in this method
	@RequestMapping("/")
	public ModelAndView homepage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}
	
	// When the user clicks on "Add student" link, it will be redirected to this method.
	
	// 	 A view is set for "register.jsp" so that it will be rendered on the browser, 
	// and a null object "new Student()" will be added and sent to the jsp file
	@RequestMapping("/register")
	public ModelAndView registerStudent()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", new Student());
		modelAndView.setViewName("register.jsp");
		return modelAndView;
	}
	
	
	// After adding values to the null object, the request will and come and hit this method.
	
	// @ModelAttribute --> here, we are receiving the same object that we sent from the "register.jsp" file 
	// (with values)
	
	// In this particular method, we are saving data by using the method, ("studentDao.saveStudent()").
	
	// here, we are setting a view for "home.jsp"
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student)
	{
		ModelAndView modelAndView = new ModelAndView();
		studentDao.saveStudent(student);
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}
	
	// When we click on (View Student Details) link, it will come and hit this method
	
	// 	Here, we have set a view for view.jsp and adding an object of List<Student> 
	// fetched from the database using ("studentDao.getAllStudent()") with a key("students").
	@RequestMapping("/view")
	public ModelAndView getAllStudents()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view.jsp");
		modelAndView.addObject("student",studentDao.getAllStudents());
		return modelAndView;
	}
	
	// When we click on EDIT link for any student present in the table, it will redirect us
	// to this particular method.
	
	// @RequestParam --> Here, we are receiving the id of the particular student object 
	// from the "view.jsp" file
	
	// After that, we are finding that student object from the database using the method
	// ("studentDao.getStudent(id)") and giving a key for that as("student") and adding that object
	// and setting a view for update.jsp file.
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.addObject("student", studentDao.getStudent(id));
		return modelAndView;
	}
	
	//  When we click on submit after updating the data inside "update.jsp", it will come and hit this method
	// where we are updating the data inside the database using("studentDao.updateStudent(student)").
	
	// Then we are setting a view for (view.jsp)
	
	// And adding an object of List<Student> ("studentDao.getAllStudent()") with a key("students").
	@RequestMapping("/saveUpdatedStudent")
	public ModelAndView saveUpdatedStudent(@ModelAttribute Student student)
	{
		ModelAndView modelAndView = new ModelAndView();
		studentDao.updateStudent(student);
		modelAndView.setViewName("view.jsp");
		modelAndView.addObject("student",studentDao.getAllStudents());
		return modelAndView;
	}
	
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		Student student = studentDao.getStudent(id);
		studentDao.deleteStudent(student);
		modelAndView.setViewName("view.jsp");
		modelAndView.addObject("student", studentDao.getAllStudents()); 
		return modelAndView;
	}
}
