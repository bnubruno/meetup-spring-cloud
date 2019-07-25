package com.meetup.customer.service;

import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.meetup.customer.entity.Customer;
import com.meetup.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

	private CustomerRepository repository;

	public Optional<Customer> findOne(UUID uuid) {
		return repository.findById( uuid );
	}

	public Customer save(Customer customer) {
		return repository.save( customer );
	}

}
