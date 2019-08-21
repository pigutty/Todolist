package com.pigutty.springboot.Todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;


import com.pigutty.springboot.Todolist.repositories.TodoRepository;

@Controller
public class NewController {
	@Autowired
	TodoRepository repository;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index(@ModelAttribute TodoData tododata, ModelAndView mav){
		mav.setViewName("index");
		List<TodoData> sprint = repository.findByStatus(1);
		List<TodoData> doing = repository.findByStatus(2);
		List<TodoData> completed = repository.findByStatus(3);
		mav.addObject("sprint",sprint);
		mav.addObject("doing",doing);
		mav.addObject("completed",completed);
		return mav;
	}
	
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
		@RequestParam(value="status_id",required=false)int status,ModelAndView mav) {
		tododata.status=status;
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
		@ModelAttribute TodoData tododata,BindingResult result,
		@RequestParam(value="status_id",required=false)int status,ModelAndView mav) {
		tododata.status=status;
		repository.saveAndFlush(tododata);
		return new ModelAndView("redirect:/new");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView remove(@RequestParam long id,
			ModelAndView mav){
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	@PostConstruct
	public void init() {
		TodoData d1 = new TodoData();
		d1.setName("言語の理解");
		d1.setText("まずはJavaの構文を理解する。");
		d1.setStatus((int)3);
		repository.saveAndFlush(d1);
		
		TodoData d2 = new TodoData();
		d2.setName("フレームワークの理解");
		d2.setText("Spring Bootの基本的な使い方について学習する。");
		d2.setStatus((int)3);
		repository.saveAndFlush(d2);
		
		TodoData d3 = new TodoData();
		d3.setName("アプリ設計");
		d3.setText("作成するアプリのデータベースを設計する。");
		d3.setStatus((int)3);
		repository.saveAndFlush(d3);
		
		TodoData d4 = new TodoData();
		d4.setName("ビュー作成");
		d4.setText("アプリで使用するビューを作成する。");
		d4.setStatus((int)2);
		repository.saveAndFlush(d4);
		
		TodoData d5 = new TodoData();
		d5.setName("コントローラ作成");
		d5.setText("ビューで表示するのに必要なコントローラを作成する。");
		d5.setStatus((int)1);
		repository.saveAndFlush(d5);
		
		TodoData d6 = new TodoData();
		d6.setName("パスの整備");
		d6.setText("パスを設定して一つのアプリとして動くようにする。");
		d6.setStatus((int)1);
		repository.saveAndFlush(d6);
		
	}
}

