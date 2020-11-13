package com.expertsoft.cardservice.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expertsoft.cardservice.service.ByValueSortingStrategy;
import com.expertsoft.cardservice.service.ShuffleSortingStrategy;
import com.expertsoft.cardservice.web.model.Deck;

@RestController
@RequestMapping("/")
public class RestDeckController {		
	private Deck deck;

	@Autowired
	public RestDeckController(Deck deck) {
		this.deck = deck;
	}
	
	@RequestMapping(value = "jsonCreate", method = RequestMethod.GET)
	public Deck create() {		
		return new Deck();
	}
	
	@RequestMapping(value = "jsonShuffle", method = RequestMethod.GET)
	public Deck shuffle(ShuffleSortingStrategy sss) {
		sss.doAlgorithm(deck);
		return deck;
	}
	
	@RequestMapping(value = "jsonSort", method = RequestMethod.GET)
	public Deck sort(ByValueSortingStrategy<Deck> bvss) {
		bvss.doAlgorithm(deck);
		return deck;
	}
}

