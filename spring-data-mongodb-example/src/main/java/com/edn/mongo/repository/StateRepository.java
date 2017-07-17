package com.edn.mongo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edn.mongo.model.State;

public interface StateRepository extends PagingAndSortingRepository<State, BigInteger> {

	public List<State> findByCapitalSinceGreaterThan(int since, Pageable pageable);

	public List<State> findByDateOfStatehoodGreaterThan(int since, Sort sort);

}