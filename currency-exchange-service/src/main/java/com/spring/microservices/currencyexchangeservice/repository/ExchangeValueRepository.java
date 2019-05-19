package com.spring.microservices.currencyexchangeservice.repository;

import com.spring.microservices.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
