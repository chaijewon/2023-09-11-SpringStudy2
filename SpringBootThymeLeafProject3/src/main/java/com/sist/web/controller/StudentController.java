package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.entity.Student;

import jakarta.persistence.EntityManager;
import java.util.*;
@Controller
public class StudentController {
   @Autowired
   private EntityManager em;
   
   @GetMapping("/student/list")
   public String student_list(Model model)
   {
	   Student std=em.find(Student.class, 1);
	   model.addAttribute("std", std);
	   return "student/list";
   }
}
