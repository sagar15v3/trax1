package com.trax.servicess;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trax.entites.Lead;
import com.trax.repositories.LeadRepository;

@Service
public class LeadServicessimpl implements LeadServicess {

	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLeadInfo(Lead lead) throws RuntimeException {
		leadRepo.save(lead);
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
		
	}

	@Override
	public void deleteLeadbyId(long id) {
		leadRepo.deleteById(id);
		
	}

	@Override
	public List<Lead> getAllLead() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

}
