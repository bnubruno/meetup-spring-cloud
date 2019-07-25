package com.meetup.invoice.controller;

import javax.validation.Valid;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetup.invoice.dto.InvoiceDTO;
import com.meetup.invoice.entity.Invoice;
import com.meetup.invoice.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
@AllArgsConstructor
public class InvoiceController {

	private InvoiceService invoiceService;

	@PostMapping
	public Invoice create(@Valid @RequestBody InvoiceDTO invoiceDTO) {
		return invoiceService.create( invoiceDTO );
	}

}
