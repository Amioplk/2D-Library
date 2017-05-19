package io.github.dauphine.lejema160.main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.dauphine.lejema160.controller.BookSort;
import io.github.dauphine.lejema160.controller.readFile;
import io.github.dauphine.lejema160.model.Author;
import io.github.dauphine.lejema160.model.Book;
import io.github.dauphine.lejema160.model.Library;
import io.github.dauphine.lejema160.model.Shelf;
import io.github.dauphine.lejema160.model.User;
import io.github.dauphine.lejema160.view.SVGDrawable;

public class Main {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws IOException, ParserConfigurationException {
	
		List<Book> books = io.github.dauphine.lejema160.controller.readFile.read();
		//Library Lib = io.github.dauphine.lejema160.model.User.createLibrary(books, 50, 70);
		Library Lib = new Library(books);
		io.github.dauphine.lejema160.view.SVGDrawable.generate(Lib, true);
		System.out.println("Fait");

		
	}

}
