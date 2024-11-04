package com.dsa360.api.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dsa360.api.dto.CustomerDTO;
import com.dsa360.api.dto.DocumentDTO;

public interface CustomerService {
	public abstract String createCustomer( CustomerDTO customerDTO);

	public abstract String checkLoanEligibility(String customerId);

	public abstract String customerLoanApplication(CustomerDTO customerDTO);

	public abstract List<CustomerDTO> getAllCustomers();

	public abstract CustomerDTO getCustomerById(String id);

	public abstract CustomerDTO updateCustomer(CustomerDTO customerDTO);

	public abstract void cancelCustomerLoanApplication(String id);

	public abstract void uploadDocument(String customerId, DocumentDTO documentDTO, MultipartFile file);

	public abstract List<DocumentDTO> getDocumentsByCustomerId(String customerId);

	public abstract DocumentDTO getDocumentById(String customerId, String documentId);

	public abstract void deleteDocument(String customerId, String documentId);

}
