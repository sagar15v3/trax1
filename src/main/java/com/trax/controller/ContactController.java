package com.trax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entites.Contact;
import com.trax.entites.Lead;
import com.trax.servicess.ContactServices;
import com.trax.servicess.LeadServicess;

@Controller
public class ContactController {
	
	@Autowired
	private LeadServicess leadServicess;
	
	@Autowired
	private ContactServices contactservices;
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadServicess.findLeadById(id);
		
		Contact contact  = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setLeadSource(lead.getLeadSource());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		
		contactservices.saveContact(contact);
		
		leadServicess.deleteLeadbyId(id);
		
		List<Contact> contacts = contactservices.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "contact_search_result";
	}
	@RequestMapping("/contactInfo")
	public String leadInfo(@RequestParam("id")long id, ModelMap model) {
		Contact contact = contactservices.findContactById(id);
		model.addAttribute("contact", contact);
		return"contact_info";
	}
	
	@RequestMapping("listallcontacts")
	public String listAllcontacts(ModelMap model) {
		List<Contact> contacts = contactservices.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "contact_search_result";
	}
}
