package com.salesianas.dam.mesasroleras.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Game</h2>
 * This class represents the Game Sessions, with the product which will be used by one specific list of members. 
 *As attributes, it has the {@link Product}, the list of {@link Members} and the date which show us when is going to take place the specific session.
 *
 * 
 * @author Manuel Exposito Herrera
 *
 *@version 1.0
 */
@Data
@NoArgsConstructor
@Entity
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Product product;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private LocalTime time;
	
	//mappedBy="game", 
	@OneToMany(fetch=FetchType.EAGER)
	private List<Member> players = new ArrayList<>();
	
	public Game(LocalDate date, LocalTime time) {
		
		this.date = date;
		this.time = time;
	}
	
	
	public Game(LocalDate date, LocalTime time, Product product) {
		super();
		this.date = date;
		this.time = time;
		this.product = product;
	}
	
	/**
	 * This Helper Method will add a new member to the session list.
	 * @param the new member
	 */
	public void addMember(Member m) {
		players.add(m);
	}
	
	/**
	 *  This Helper Method will ad a new member to the session list.
	 * @param the member to remove
	 */
	public void removeMember(Member m) {
		
		players.remove(m);
		
	}
	


	
}
