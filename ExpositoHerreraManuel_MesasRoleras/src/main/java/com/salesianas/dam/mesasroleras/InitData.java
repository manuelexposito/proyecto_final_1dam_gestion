package com.salesianas.dam.mesasroleras;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianas.dam.mesasroleras.model.Game;
import com.salesianas.dam.mesasroleras.model.Member;
import com.salesianas.dam.mesasroleras.model.Product;
import com.salesianas.dam.mesasroleras.services.GameService;
import com.salesianas.dam.mesasroleras.services.MemberService;
import com.salesianas.dam.mesasroleras.services.ProductService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {

	private final MemberService memberservice;
	private final ProductService productservice;
	private final GameService gameservice;
	
	
	@PostConstruct
	public void init() {
		
		//con el atributo de imagen
//		Member m = new Member("Juan", "Lopez Hidalgo", "43292013J", "juanlopi@gmail.com", "Calle Falsa nº23", "+342435653", "IBAN432213314", "https://uifaces.co/our-content/donated/ukegoVAy.jpg","true", LocalDate.of(2020, 04,01), LocalDate.of(1990, 04, 02) );
//		Member m2 = new Member("Maria", "Garcia Galan", "54321345X", "mariagarga@gmail.com", "Calle Falsa nº21", "+345465432", "IBAN456432234", "https://uifaces.co/our-content/donated/UZ0VIIh3.png","false", LocalDate.of(2020, 04,01), LocalDate.of(1997, 04, 02) );
//	
		
		memberservice.save(new Member("Juan", "Lopez Hidalgo", "43292013J", "juanlopi@gmail.com", "Calle Falsa nº23", "+342435653", "IBAN432213314", "https://uifaces.co/our-content/donated/ukegoVAy.jpg","true", LocalDate.of(2020, 04,01), LocalDate.of(1990, 04, 02) ));
		memberservice.save(new Member("Maria", "Garcia Galan", "54321345X", "mariagarga@gmail.com", "Calle Falsa nº21", "+345465432", "IBAN456432234", "https://uifaces.co/our-content/donated/UZ0VIIh3.png","false", LocalDate.of(2020, 04,01), LocalDate.of(1997, 04, 02) ));
		
		Product p1 = new Product("Dungeons & Dragons: Dungeon of the Mad mage", "Wizards of the Coast", "https://www.planetongames.com/23122/dd-waterdeep-dungeon-of-the-mad-mage.jpg", 36.62, 5, 50);
		Product p2 = new Product("Legends of the Five Rings", "Alderac Entertainment Group", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRaMAnCTdA1KtA9lvJRioTybLoFXwtm5YtzEG2Ule5ZvBXj9V7G", 25.38, 7, 50);
		
		productservice.save(p1);
		productservice.save(p2);
		
		
		List<Member> players = memberservice.findAll();
		
//		List <Member> players_grupados = Arrays.asList(
//				new Member("Miguel", "Armenta Chavarr�a", "478382910L", "miguelarmencha@gmail.com", "Calle Meloinvento n20" ,"+34736 528 522", "IBAN384839210021", "https://randomuser.me/api/portraits/men/47.jpg", "true", LocalDate.of(2021, 02, 02), LocalDate.of(1992, 05, 24) );
//				
//		);
		
		List<Member> playersGrupoDos = List.of(
				new Member("Miguel", "Armenta Chavarr�a", "478382910L", "miguelarmencha@gmail.com", "Calle Meloinvento n20" ,"+34736 528 522", "IBAN384839210021", "https://randomuser.me/api/portraits/men/47.jpg", "true", LocalDate.of(2021, 02, 02), LocalDate.of(1992, 05, 24))
				
				);
		
		Game g1 = new Game(LocalDateTime.of(LocalDate.of(2021, 6, 20), LocalTime.of(17, 30)), p2);
		Game g2 = new Game(LocalDateTime.of(LocalDate.of(2021, 6, 20), LocalTime.of(19, 30)), p1);
		gameservice.save(g1);
		gameservice.save(g2);
		
		//g1.addProduct(p1);
		for (Member m : players) {
			
			g1.addMember(m);
			m.setGame(g1);
			memberservice.edit(m);
			
		}
		
		for (Member m : playersGrupoDos) {
		
			g1.addMember(m);
			m.setGame(g2);
			memberservice.edit(m);
			
		}
		
		
		
	}
	
	
}
