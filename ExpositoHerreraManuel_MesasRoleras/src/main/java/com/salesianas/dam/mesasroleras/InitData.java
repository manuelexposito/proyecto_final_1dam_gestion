package com.salesianas.dam.mesasroleras;

import java.time.LocalDate;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;


import com.salesianas.dam.mesasroleras.model.Member;
import com.salesianas.dam.mesasroleras.model.Product;
import com.salesianas.dam.mesasroleras.services.MemberService;
import com.salesianas.dam.mesasroleras.services.ProductService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitData {

	private final MemberService memberservice;
	private final ProductService productservice;
	//private final GameService gameservice;
	
	
	@PostConstruct
	public void init() {
		
		
		//mockup member data
		memberservice.save(new Member("Juan", "Lopez Hidalgo", "48194415P", "juanlopi@gmail.com", "Calle Betis nº3", "+34688192301", "ES0431351875865760908446", "https://uifaces.co/our-content/donated/ukegoVAy.jpg","true", LocalDate.of(2020, 04,01), LocalDate.of(1990, 04, 02) ));
		memberservice.save(new Member("María", "García Galán", "51153428W", "mariagarga@gmail.com", "Calle Albert Einstein nº1", "+34612732819", "ES7531572901742774659264", "https://uifaces.co/our-content/donated/UZ0VIIh3.png","false", LocalDate.of(2020, 04,01), LocalDate.of(1997, 04, 02) ));
		memberservice.save(new Member("Miguel", "Armenta Chavarría", "04262012C", "miguelarmencha@gmail.com", "Calle Meloinvento n20" ,"+34662192034", "ES2731287999285908256471", "https://randomuser.me/api/portraits/men/47.jpg", "true", LocalDate.of(2021, 02, 02), LocalDate.of(1992, 05, 24)));
		memberservice.save(new Member("Lil", "Puente Castro", "95828499B", "lilpuecas@gmail.com", "Calle Salesiano Don Ubaldo nº5", "+34633821910", "ES7531572901742774659264", "https://uifaces.co/our-content/donated/1H_7AxP0.jpg", "false", LocalDate.of(2021, 3, 24), LocalDate.of(1990, 05, 28) ));
		memberservice.save(new Member("Jesica", "Garza Armenta", "66849084K", "jesgarmen@gmail.com", "Calle Juan Bautista nº7", "+34714764446", "ES9231902138706368872439", "https://images.generated.photos/qmdENySIv23bkva-PxTHsoxVbZQdB1Wka0ZPcH5shHY/rs:fit:512:512/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yy/XzAzMDE4MzAuanBn.jpg", "true", LocalDate.of(2020,  6, 10), LocalDate.of(1993, 6, 8)));
		memberservice.save(new Member("Pablo", "Pedraza Merino", "05235601L", "papemeri@gmail.com", "Calle Garcilaso de la Vega nº3", "+34669302019", "ES6901885086966717243705", "https://i.imgur.com/ZI45jIW.jpg", "true", LocalDate.of(2019, 02, 8), LocalDate.of(1995, 6, 10)));
		memberservice.save(new Member("José", "Riojas Prado", "09240017C", "joripra85@gmail.com", "Calle Fortaleza nº12", "+34688192012", "ES5001421043180338164742", "https://i.imgur.com/ZI45jIW.jpg", "true", LocalDate.of(2020, 6, 13), LocalDate.of(1985, 10, 10)));
		memberservice.save(new Member("Ángela", "Guerra Vega", "33757662X", "angelavega@gmail.com", "Calle Betis nº5", "+34655412098", "ES9615340746219811435420", "https://i.imgur.com/SSWYAW4.jpg", "true", LocalDate.of(2020, 12, 24), LocalDate.of(2001, 2, 1)));
		memberservice.save(new Member("Rosa", "Rivas González", "83334906H", "rorigo@gmail.com", "Calle Pitagoras nº1", "+34699120345", "ES9120688078592549055899", "https://i.imgur.com/tl4edXX.jpg", "false", LocalDate.of(2019, 12, 1), LocalDate.of(1989, 1, 23)));
		memberservice.save(new Member("Enrique", "Pérez Hidalgo", "53115910D", "enriquepe@gmail.com", "Calle Arcangel San Miguel nº23", "+34611273819", "ES2810011387016265281289", "https://images.generated.photos/U8cesqJveqJoF1jpSveZNm377GxRQaGr0h82KKl14Cs/rs:fit:512:512/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zLzA5/OTUxNDAuanBn.jpg", "false" ,LocalDate.of(2015, 3, 20), LocalDate.of(1986, 5, 24)));
		memberservice.save(new Member("Lamar", "Arce Serrano", "95367889E", "lamarce@gmail.com", "Calle Troya nº5", "+34733839612", "ES7100130927842828432745", "https://images.generated.photos/tVZdtsXln-D9HXNrWYSUD3gtQQP-VyMrufgsSyIuWJI/rs:fit:512:512/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zL3Yy/XzAyMDMwMDMuanBn.jpg", "true", LocalDate.of(2015, 2, 19), LocalDate.of(1997, 2, 20)));
		memberservice.save(new Member("Lorena", "García Jaramillo", "23858635E", "loregar@gmail.com", "Calle Virgen de las Huertas nº4", "+34665237182","ES9020695776755611223588", "https://images.generated.photos/r0LuX0qWHAWqvG-d8FUhD2yYecpc9aEd6yJjudE8Szo/rs:fit:512:512/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zLzA5/OTk3NTUuanBn.jpg", "false", LocalDate.of(2019, 5, 14), LocalDate.of(2000, 4, 28)));
		memberservice.save(new Member("José Antonio", "Salgado Coronado", "17462284V", "josegado@gmail.com", "Calle Maestro Arrieta nº12", "+34654980123", "ES0931860859816880557981", "https://images.generated.photos/_q3D1rdwLPmcsOHPCb5qndEWHcgOl24c7e2XI9fSmzo/rs:fit:512:512/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zLzA5/OTk1MTIuanBn.jpg", "false", LocalDate.of(2012, 12, 24), LocalDate.of(1979, 6, 21)));
		memberservice.save(new Member("Javier", "Hernández Cabeza", "57494743X", "javierhernan@gmail.com", "Calle Ardilla nº23", "+34633217012", "ES2620465475822155178985", "https://images.generated.photos/PYqJjdWKLiLWW3R0pVQGZRQ6oZWQ5qdPMLkwLCttkJs/rs:fit:512:512/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zLzA5/OTUwMjkuanBn.jpg", "false", LocalDate.of(2020, 6, 20), LocalDate.of(1989, 10, 10)) );
		memberservice.save(new Member("Alejandro", "Barrios Nieves", "28299357L", "alebar@gmail.com", "Calle Pureza nº10", "+34682391000", "ES1330292430910297999345", "https://images.generated.photos/rQ3NjmDfVvwNFBNJFGBq5U1lc3nWWywi7v8gKzSv7KQ/rs:fit:512:512/Z3M6Ly9nZW5lcmF0/ZWQtcGhvdG9zLzAy/NjExNjQuanBn.jpg", "false", LocalDate.of(2021, 2, 14), LocalDate.of(2001, 10, 4)));

		//mockup products data
		Product p1 = new Product("Dungeons & Dragons: Dungeon of the Mad mage", "Wizards of the Coast", "https://www.planetongames.com/23122/dd-waterdeep-dungeon-of-the-mad-mage.jpg", 36.62, 5);
		Product p2 = new Product("Legend of the Five Rings", "Alderac Entertainment Group", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRaMAnCTdA1KtA9lvJRioTybLoFXwtm5YtzEG2Ule5ZvBXj9V7G", 25.38, 7);
		Product p3 = new Product("Trauma Unit", "Nosolorol", "https://www.nosolorol.com/1174-thickbox_default/trauma-unit.jpg", 39.99, 5);
		Product p4 = new Product("Anima: Beyond Fantasy", "Fantasy Flight Games", "https://imgv2-2-f.scribdassets.com/img/document/212961752/original/82591b85f6/1616070278?v=1", 45.32, 6);
		Product p5 = new Product("7th Sea: The New World", "Alderac Entertainment Group", "https://images-na.ssl-images-amazon.com/images/I/51erMHQUglL.jpg", 75.42, 7);
		Product p6 = new Product("FATE", "Evil Hat Productions", "https://m.media-amazon.com/images/S/aplus-media/vc/6bf6f621-14b5-4e25-bedb-56181576936d.__CR0,0,300,300_PT0_SX300_V1___.jpg", 41.80, 7);
		Product p7 = new Product("Pathfinder", "Paizo Publishing", "https://images-na.ssl-images-amazon.com/images/I/816ww2JzYiL.jpg", 60.25, 5);
		Product p8 = new Product("The Call of Cthulhu", "Chaosium", "https://images-na.ssl-images-amazon.com/images/I/91uc2GcyEeL.jpg", 45.30, 4);		
		
		productservice.save(p1);
		productservice.save(p2);
		productservice.save(p3);
		productservice.save(p4);
		productservice.save(p5);
		productservice.save(p6);
		productservice.save(p7);
		productservice.save(p8);
		
	
		
	}
	
	
}
