package com.dsa360.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dsa360.api.dto.CustomerDTO;
import com.dsa360.api.dto.DocumentDTO;
import com.dsa360.api.service.CustomerService;

@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private CustomerService service;

	@PreAuthorize("hasRole('ROLE_AGENT')")
	@PostMapping("/create-customer")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
		String customerId = service.createCustomer(customerDTO);

		return new ResponseEntity<>(customerId, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_AGENT')")
	@PostMapping("/customer-loan-application")
	public ResponseEntity<CustomerDTO> customerLoanApplication(@Valid @RequestBody CustomerDTO customerDTO) {
		String customerId = service.customerLoanApplication(customerDTO);

		return null;
	}

	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		List<CustomerDTO> customers = service.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
		CustomerDTO customer = service.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable String id,
			@Valid @RequestBody CustomerDTO customerDTO) {
		CustomerDTO updatedCustomer = service.updateCustomer(customerDTO);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelCustomerLoanApplication(@PathVariable String id) {
		service.cancelCustomerLoanApplication(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/{customerId}/documents/upload")
	public ResponseEntity<String> uploadDocument(@PathVariable String customerId,
			@RequestBody DocumentDTO documentDTO) {
		MultipartFile file = documentDTO.getFile();
		service.uploadDocument(customerId, documentDTO, file);
		return ResponseEntity.ok("Document uploaded successfully for customer ID: " + customerId);
	}

	@GetMapping("/{customerId}/documents")
	public ResponseEntity<List<DocumentDTO>> getDocumentsByCustomerId(@PathVariable String customerId) {
		List<DocumentDTO> documents = service.getDocumentsByCustomerId(customerId);
		return ResponseEntity.ok(documents);
	}

	@GetMapping("/{customerId}/documents/{documentId}")
	public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable String customerId,
			@PathVariable String documentId) {
		DocumentDTO document = service.getDocumentById(customerId, documentId);
		return ResponseEntity.ok(document);
	}

	@DeleteMapping("/{customerId}/documents/{documentId}")
	public ResponseEntity<Void> deleteDocument(@PathVariable String customerId, @PathVariable String documentId) {
		service.deleteDocument(customerId, documentId);
		return ResponseEntity.noContent().build();
	}

}
