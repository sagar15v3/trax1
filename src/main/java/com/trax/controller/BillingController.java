package com.trax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trax.entites.Billing;
import com.trax.entites.Contact;
import com.trax.servicess.BillingServicess;
import com.trax.servicess.ContactServices;

@Controller
public class BillingController {

	@Autowired
	private ContactServices contactServices;
	
	@Autowired
	private BillingServicess billservicess;
	
	@RequestMapping("/createBill")
	public String createBill(@RequestParam("bid")long id,ModelMap model) {
		Contact contact = contactServices.findContactById(id);
		model.addAttribute("contact", contact);
		return"create_bill";
	}
	
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("bill")Billing bill) {
		billservicess.saveBilling(bill);
		return"  ";
	}
}
