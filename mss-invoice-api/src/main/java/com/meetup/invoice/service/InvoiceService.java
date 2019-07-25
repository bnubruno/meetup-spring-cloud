package com.meetup.invoice.service;

import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.meetup.invoice.api.Customer;
import com.meetup.invoice.api.CustomerClient;
import com.meetup.invoice.dto.InvoiceDTO;
import com.meetup.invoice.entity.Invoice;
import com.meetup.invoice.repository.InvoiceRepository;

@Service
@Validated
@AllArgsConstructor
public class InvoiceService {

	private InvoiceRepository invoiceRepository;
	private CustomerClient customerApi;

	public Invoice create(InvoiceDTO invoiceDTO) {
		return invoiceRepository.save( Invoice.builder()
				.customerEmail( findEmail( invoiceDTO ) )
				.value( invoiceDTO.getValue() )
				.build() );
	}

	private String findEmail(InvoiceDTO invoiceDTO) {
		Customer customer = customerApi.findOne( UUID.fromString( invoiceDTO.getCustomerId() ) );
		return Optional.ofNullable( customer )
				.map( Customer::getEmail )
				.orElse( null );
	}
}
