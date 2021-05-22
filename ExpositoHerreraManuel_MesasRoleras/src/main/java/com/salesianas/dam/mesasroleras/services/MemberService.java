package com.salesianas.dam.mesasroleras.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.salesianas.dam.mesasroleras.model.Member;
import com.salesianas.dam.mesasroleras.repository.MemberRepository;
import com.salesianas.dam.mesasroleras.services.base.BaseService;
/**
 * <h1>MemberService</h1>
 * 
 * This class represents the service of the POJO class Member. It will allow us to use the CRUD methods inherited by BaseService.
 * @see BaseService
 * @see MemberRepository
 * @see Member
 * @author Manuel Exposito Herrera
 *
 *@version 1.0
 */
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
	
	/**
	 * This method returns a list of premium members.
	 * 
	 * @return a list of premium members.
	 */
	public List<Member> filterByPremiumMembers(){
		
		return this.repository.findAll()
							  .stream()
							  .filter(x -> x.getIsPremium().equalsIgnoreCase("true"))
							  .collect(Collectors.toList());
		
	}
	
	
	
}
