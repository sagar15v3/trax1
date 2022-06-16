package com.trax.servicess;

import java.util.List;

import com.trax.entites.Lead;

public interface LeadServicess {
	
	public void saveLeadInfo(Lead lead);
	public Lead findLeadById(long id);
	public void deleteLeadbyId(long id);
	public List<Lead> getAllLead();

}
