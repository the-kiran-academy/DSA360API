package com.dsa360.api.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dsa360.api.dao.CustomerDao;
import com.dsa360.api.dto.CustomerDTO;
import com.dsa360.api.dto.DocumentDTO;
import com.dsa360.api.entity.CustomerEntity;
import com.dsa360.api.service.CustomerService;
import com.dsa360.api.utility.DynamicID;
import com.dsa360.api.utility.ObjectConverter;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ObjectConverter converter;

	@Override
	public String createCustomer(CustomerDTO customerDTO) {
		String customerId = DynamicID.getDynamicId();
		customerDTO.setId(customerId);

		customerDao.createCustomer((CustomerEntity) converter.dtoToEntity(customerDTO));

		return customerId;
	}

	@Override
	public String checkLoanEligibility(String customerId) {

		return null;
	}

	@Override
	public String customerLoanApplication(CustomerDTO customerDTO) {

		return null;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {

		return null;
	}

	@Override
	public CustomerDTO getCustomerById(String id) {

		return null;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {

		return null;
	}

	@Override
	public void cancelCustomerLoanApplication(String id) {

	}

	@Override
	public void uploadDocument(String customerId, DocumentDTO documentDTO, MultipartFile file) {

	}

	@Override
	public List<DocumentDTO> getDocumentsByCustomerId(String customerId) {

		return null;
	}

	@Override
	public DocumentDTO getDocumentById(String customerId, String documentId) {

		return null;
	}

	@Override
	public void deleteDocument(String customerId, String documentId) {

	}

}
