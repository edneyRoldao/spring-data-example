package com.edn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edn.model.Shop;
import com.edn.service.ShopService;

@RestController
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@GetMapping("/shops")
	public List<Shop> list() {
		return service.findAll();
	}

}
