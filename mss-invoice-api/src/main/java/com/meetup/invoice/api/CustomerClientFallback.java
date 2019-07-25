package com.meetup.invoice.api;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class CustomerClientFallback implements CustomerClient {

	@Override
	public Customer findOne(UUID id) {
		return new Customer();
	}

	@Override
	public Customer save(Customer customer) {
		return null;
	}
}
