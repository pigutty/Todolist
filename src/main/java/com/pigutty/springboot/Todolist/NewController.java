package com.pigutty.springboot.Todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import com.pigutty.springboot.Todolist.repositories.TodoRepository;

@Controller
public class NewController {
	@Autowired
	TodoRepository repository;
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public ModelAndView index(
		@ModelAttribute("formModel") TodoData tododata,BindingResult result,
		ModelAndView mav) {
		mav.setViewName("new");
		mav.addObject("msg","this is sample content.");
		Iterable<TodoData> list = repository.findAll();
		mav.addObject("datalist",list);
		return mav;
	}
	@RequestMapping(value="/new",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView form(
		@ModelAttribute("formModel")TodoData tododata,BindingResult result,
		ModelAndView mav) {
		repository.saveAndFlush(tododata);
		return new ModelAndView("redirect:/new");
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute TodoData tododata,BindingResult result,
			@PathVariable int id, ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit TodoData");
		Optional<TodoData> data = repository.findById((long)id);
		mav.addObject("formModel", data.get());
		return mav;
	}
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView update(
		@ModelAttribute TodoData tododata,BindingResult result
		,ModelAndView mav) {
		repository.saveAndFlush(tododata);
		return new ModelAndView("redirect:/new");
	}
}

