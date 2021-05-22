package com.salesianas.dam.mesasroleras.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * <h1>Member</h2>
 *This class represents the registered members of Mesas Roleras. 
 * 
 * @author Manuel Exposito Herrera
 *
 *@version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

	@Id
	@GeneratedValue
	private long id;
	
	private String name, lastName, dni, email, address, phone, bankNum;
	private String image;
	private String isPremium;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate subscription;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;

	

	public Member(String name, String lastName, String dni, String email, String address, String phone, String bankNum,
			String image, String isPremium, LocalDate subscription, LocalDate birthdate) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.bankNum = bankNum;
		this.image = image;
		this.isPremium = isPremium;
		this.subscription = subscription;
		this.birthdate = birthdate;
	}



	/**
	 * This method will return the member's age.
	 * 
	 * @return member's age
	 */
	public long getAge() {
		return ChronoUnit.YEARS.between(this.birthdate, LocalDate.now() );
	}


	
	
}
