package com.trax.servicess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.entites.Billing;
import com.trax.repositories.BillingRepositories;

@Service
public class BillingServicessimpl implements BillingServicess {

	@Autowired
	private BillingRepositories billingRepo;
	
	@Override
	public void saveBilling(Billing bill) {
		billingRepo.save(bill);

	}

}
