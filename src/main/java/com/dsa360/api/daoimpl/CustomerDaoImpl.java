package com.dsa360.api.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.dsa360.api.dao.CustomerDao;
import com.dsa360.api.dto.DocumentDTO;
import com.dsa360.api.entity.CustomerEntity;
import com.dsa360.api.exceptions.SomethingWentWrongException;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createCustomer(CustomerEntity customerEntity) {

		try (Session session = sessionFactory.openSession()) {
			session.save(customerEntity);
			session.beginTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occurred during create customer for {} ", customerEntity.getId());
			throw new SomethingWentWrongException(
					"Exception occurred during create customer for " + customerEntity.getId());
		}
	}

	@Override
	public String checkLoanEligibility(String customerId) {

		return null;
	}

	@Override
	public String customerLoanApplication(CustomerEntity customerEntity) {

		return null;
	}

	@Override
	public List<CustomerEntity> getAllCustomers() {

		return null;
	}

	@Override
	public CustomerEntity getCustomerById(String id) {

		return null;
	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity customerEntity) {

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
