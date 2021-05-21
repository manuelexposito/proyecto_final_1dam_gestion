package com.salesianas.dam.mesasroleras.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Product product;
	private LocalDateTime date;
	
	@OneToMany(mappedBy="game", fetch=FetchType.EAGER)
	private List<Member> players = new ArrayList<>();
	
	public Game(LocalDateTime date) {
		super();
		this.date = date;
	}
	
	public Game(LocalDateTime date, Product product) {
		super();
		this.date = date;
		this.product = product;
	}
	
	//HELPERS
	public void addMember(Member m) {
		players.add(m);
		m.setGame(this);
	}
	
	public void removeMember(Member m) {
		
		players.remove(m);
		m.setGame(null);
		
	}
	


	
}
