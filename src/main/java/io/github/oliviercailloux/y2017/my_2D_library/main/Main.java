package io.github.oliviercailloux.y2017.my_2D_library.main;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.oliviercailloux.y2017.my_2D_library.model.Book;
import io.github.oliviercailloux.y2017.my_2D_library.model.Library;
import io.github.oliviercailloux.y2017.my_2D_library.view.Svg2jpg;
import io.github.oliviercailloux.y2017.my_2D_library.view.Window2DLibrary;

public class Main {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws IOException, ParserConfigurationException {
		
		// lire le fichier afin de créer une liste de livres
		List<Book> books = io.github.oliviercailloux.y2017.my_2D_library.controller.readFile.read();
		//Library Lib = io.github.dauphine.lejema160.model.User.createLibrary(books, 50, 70);
		
		// créer une librairie à partir de la liste de livres
		int nbBooksPerShelf = 12;
		Library Lib = new Library(books, nbBooksPerShelf);
		boolean leaning = true;
		
		
		io.github.oliviercailloux.y2017.my_2D_library.view.SVGDrawable.generate(Lib, leaning, "Auto", "Auto", "Auto");
				
		// lancement de l'interface graphique
		try {
			Svg2jpg.convert();
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Window2DLibrary("2D_LIBRARY PROJECT");
	}

}