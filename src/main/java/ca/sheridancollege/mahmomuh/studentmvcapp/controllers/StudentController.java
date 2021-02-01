package ca.sheridancollege.mahmomuh.studentmvcapp.controllers;

import ca.sheridancollege.mahmomuh.studentmvcapp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    String programs[] = {"Network Engineer","Computer Engineer", "System Analyst"};
    List<Student> students = new ArrayList<Student>();
    @RequestMapping("/helloAll")
    public String greet(){

        return ("redirect:/StudentAPI/greeting");
    }
    //GetMapping makes it a URL
    @GetMapping(value = {"/","/index.do"})
    public String index(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        model.addAttribute("programs", programs);
        return "input";     //input is name of page under template
    }
    @GetMapping("/goToYahoo")
    public String test(){
        return "redirect:http://yahoo.com";
    }

    @PostMapping("/processInput1")
    public String display(Model model,@ModelAttribute Student student){

        students.add(student);
        model.addAttribute("myStudents",students);
        return "output";
    }

    @PostMapping("/processInput")
    public ModelAndView display1(Model model, @ModelAttribute Student student){

        students.add(student);
        ModelAndView modelAView = new ModelAndView("ouput","mySudents",students);
        return modelAView;
    }
}
