package com.edn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edn.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
