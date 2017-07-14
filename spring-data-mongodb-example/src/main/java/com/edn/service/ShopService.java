package com.edn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edn.model.Shop;
import com.edn.repository.ShopRepository;

@Service
@Transactional
public class ShopService {

	@Autowired
	ShopRepository repository;
	
	public List<Shop> findAll() {
		return repository.findAll();
	}

}
