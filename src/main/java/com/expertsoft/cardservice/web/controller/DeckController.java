package com.expertsoft.cardservice.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expertsoft.cardservice.service.SortingStrategy;
import com.expertsoft.cardservice.web.model.Deck;

@Controller
@RequestMapping("/")
public class DeckController {
	
	private Deck deck;
	List<Deck> list = new ArrayList<Deck>();
	
	@Autowired
	public DeckController(Deck deck){
		this.deck = deck;
	}
	
	@Resource(name = "shuffle")	
	SortingStrategy<Deck> shuffle;
	
	@Resource(name = "byValue")	
	SortingStrategy<Deck> byValue;
	
//	@Resource(name = "bySuit")	
//	SortingStrategy<Deck> bySuit;

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView deck(Deck deck) {		
		
		list.add(deck);
		
		ModelAndView model = new ModelAndView("decks");
		model.addObject("lists", list); 
		return model;
	}
	
	
	@RequestMapping(value = "shuffle", method = RequestMethod.GET, params="id")
	public String shuffle() {
		shuffle.doAlgorithm(deck);
		return "shuffled";
	}
	
	
	@RequestMapping(value = "sort", method = RequestMethod.GET)
	public String sort() {
		byValue.doAlgorithm(deck);
		return "sorted";
	}
	
	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	   public String redirect() {
	     
	      return "redirect:create";
	   }
//	@Autowired
//	@RequestMapping(value = "sortBySuit", method = RequestMethod.GET)
//	public String sortBySuit(Deck deck) {
//		bySuit.doAlgorithm(deck);
//		return "suitSort";
//	}	
}
