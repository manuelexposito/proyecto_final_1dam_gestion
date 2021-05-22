package com.salesianas.dam.mesasroleras.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianas.dam.mesasroleras.model.Member;
import com.salesianas.dam.mesasroleras.services.MemberService;

import lombok.RequiredArgsConstructor;
/**
 * <h1>MemberController</h1>
 * 
 * This class represents the controller for the Member class. It offers a few methods for printing the members on the website.
 * @see Member
 * 
 * 
 * @author Manuel Exposito Herrera
 *
 *@version 1.0
 */
@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberservice;
	
	/**
	 * It shows the list of members on the website.
	 * @param A model so we can use some of its methods.
	 * @return the html page with the list printed on it.
	 */
	@GetMapping("/")
	public String showMembersList(Model model) {
		
		
		
		model.addAttribute("membersList", memberservice.findAll());
		//this will allow us to add a new member with the modal, instead of using a getMapping method specifically for adding the new member
		model.addAttribute("member", new Member());
		
		
		return "index";
	}
	
	/**
	 * It shows the list of members filtered by premium.
	 * @param A model so we can use some of its methods.
	 * @return the html page with the list printed on it.
	 */
	@GetMapping("/premiumList")
	public String showFilterPremiumMembersList(Model model) {
		
		
		
		model.addAttribute("membersList", memberservice.filterByPremiumMembers());
		
		model.addAttribute("member", new Member());
		
		
		return "index";
	}
	
	
	
	/**
	 * It shows the specifications of one member, who is chosen by id.
	 * @param A long that represents the member id.
	 * @param A model so we can use some of its methods.
	 * @return the html page with the details of the member.
	 */
	@GetMapping("/{id}")
	public String showMemberDetails(@PathVariable("id") Long memberId, Model model) {
		
	
		model.addAttribute("member", memberservice.findById(memberId).orElse(null));
		
		return "memberDetails";
		
	}
	
	
	/**
	 * This method allows us to save a new member.
	 * @param the member.
	 * @return redirection to the html page with the list of members printed on it
	 */
	@PostMapping("/submit")
	public String save(@ModelAttribute("member") Member m) {
		
		m.setSubscription(LocalDate.now());
		
		memberservice.save(m);
		return "redirect:/";
	}
	
	/**
	 * This method allows us to edit the attributes of a member chosen by id.
	 * @param A long that represents the member id.
	 * @param A model so we can use some of its methods.
	 * @return redirection to the html page with the list printed on it.
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long memberId, Model model) {
		
		Member editM = memberservice.findById(memberId).orElse(null);
		
		if(editM != null) {
			model.addAttribute("member", editM);
			return "formEdit";
		} else
			return "redirect:/";
		
	}
	
	/**
	 * This method will submit the changes on the member chosen by id.
	 * @param the member.
	 * @return redirection to the html page with the list printed on it.
	 */
	@PostMapping("/edit/submitEdit")
	public String processEdit(@ModelAttribute("member") Member m) {
		
		memberservice.edit(m);
		
		return "redirect:/";
		
	}
	
	/**
	 * This method allows us to delete a member chosen by id.
	 * @param A long that represents the member id.
	 * @return redirection to the html page with the list printed on it.
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long memberId) {
		
		Member m = memberservice.findById(memberId).orElse(null);
		memberservice.delete(m);
		return "redirect:/";
	}
	
	
	
	
}
