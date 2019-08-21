//package com.pigutty.springboot.Todolist;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import java.util.Optional;
//
//import com.pigutty.springboot.Todolist.repositories.TodoRepository;
//
//@Controller
//public class TopPageController {
//	@Autowired
//	TodoRepository repository;
//	
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public ModelAndView index(@ModelAttribute TodoData tododata, ModelAndView mav){
//		mav.setViewName("index");
//		Optional<TodoData> sprint = repository.findByStatusId((int)1);
//		Optional<TodoData> doing = repository.findByStatusId((int)2);
//		Optional<TodoData> completed = repository.findByStatusId((int)3);
//		mav.addObject("sprint",sprint.get());
//		mav.addObject("sprint",doing.get());
//		mav.addObject("sprint",completed.get());
//		return mav;
//	}
//}
