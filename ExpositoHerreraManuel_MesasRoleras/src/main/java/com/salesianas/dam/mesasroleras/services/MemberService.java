package com.salesianas.dam.mesasroleras.services;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.salesianas.dam.mesasroleras.model.Member;
import com.salesianas.dam.mesasroleras.repository.MemberRepository;
import com.salesianas.dam.mesasroleras.services.base.BaseService;

@Service
public class MemberService extends BaseService<Member, Long, MemberRepository>{

	public MemberService(MemberRepository repository) {
		super(repository);
	
	}
	
	/**
	 * This method allow us to find someone by their DNI
	 * 
	 * @param dni
	 * @return the member if they are found. Else returns null.
	 * 
	 */
	public Member findByDni(String dni){
		
		
		return this.repository.findAll()
							  .stream()
							  .filter(x -> x.getDni().equalsIgnoreCase(dni))
							  .findFirst()
							  .orElse(null);
		
	}
	
	public List<Member> filterByPremiumMembers(){
		
		return this.repository.findAll()
							  .stream()
							  .filter(x -> x.getIsPremium().equalsIgnoreCase("true"))
							  .collect(Collectors.toList());
		
	}
	
	
	
}
