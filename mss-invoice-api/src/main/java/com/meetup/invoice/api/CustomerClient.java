package com.meetup.invoice.api;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "mss-customer-api", fallback = CustomerClientFallback.class)
public interface CustomerClient {

	@GetMapping(value = "/customer/{id}")
	Customer findOne(@PathVariable("id") UUID id);

	@PostMapping(value = "/customer")
	Customer save(Customer customer);

}

