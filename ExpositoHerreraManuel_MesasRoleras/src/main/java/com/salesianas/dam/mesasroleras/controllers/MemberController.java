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

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberservice;
	
	@GetMapping("/")
	public String membersList(Model model) {
		
		
		
		model.addAttribute("membersList", memberservice.findAll());
		model.addAttribute("member", new Member());
		
		
		return "index";
	}
	
	@GetMapping("/premiumList")
	public String premiumMembersList(Model model) {
		
		
		
		model.addAttribute("membersList", memberservice.filterByPremiumMembers());
		
		model.addAttribute("member", new Member());
		
		
		return "index";
	}
	
	
	
	
	@GetMapping("/{id}")
	public String memberDetails(@PathVariable("id") Long memberId, Model model) {
		
	
		model.addAttribute("member", memberservice.findById(memberId).orElse(null));
		
		return "memberDetails";
		
	}
	
	
	
	@PostMapping("/submit")
	public String save(@ModelAttribute("member") Member m, Model model) {
		
		m.setSubscription(LocalDate.now());
		
		memberservice.save(m);
		return "redirect:/";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long memberId, Model model) {
		
		Member editM = memberservice.findById(memberId).orElse(null);
		
		if(editM != null) {
			model.addAttribute("member", editM);
			return "formEdit";
		} else
			return "redirect:/";
		
	}
	
	@PostMapping("/edit/submitEdit")
	public String processEdit(@ModelAttribute("member") Member m) {
		
		memberservice.edit(m);
		
		return "redirect:/";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long memberId) {
		
		Member m = memberservice.findById(memberId).orElse(null);
		memberservice.delete(m);
		return "redirect:/";
	}
	
	
	
	
}
