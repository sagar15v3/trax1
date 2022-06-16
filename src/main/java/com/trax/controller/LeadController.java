package com.trax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entites.Lead;
import com.trax.servicess.LeadServicess;

@Controller
public class LeadController {
	
	@Autowired
	private LeadServicess leadservices;
	
	@RequestMapping("/viewCreateLead")
	public String viewCreateLeadPage() {
		return "create_lead";
		
	}
	
	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		try {
			leadservices.saveLeadInfo(lead);
			model.addAttribute("lead", lead);
		} catch (Exception e) {
			model.addAttribute("emailerror", "this email id exist");
			return"create_lead";
		}
		return"lead_info";
	}

	@RequestMapping("/composeEmail")
	public String composeEmail(@RequestParam("email")String email, ModelMap model) {
		model.addAttribute("email", email);
		return"compose_email";
	}
	
	@RequestMapping("listall")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadservices.getAllLead();
		model.addAttribute("leads", leads);
		return"lead_search_result";
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id")long id, ModelMap model) {
		Lead lead = leadservices.findLeadById(id);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
	
	
}
