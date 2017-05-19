package io.github.dauphine.lejema160.controller;

import java.awt.Color;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.dauphine.lejema160.model.Book;
import io.github.dauphine.lejema160.model.Library;
import io.github.dauphine.lejema160.model.Shelf;

public class Options {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(Options.class);
	/**
	 * changes the color of all the book of the library
	 * @param lib
	 * @param color
	 * @return
	 */
	public Library ChangeColorBooks(Library lib, Color color){
		
		for(int i = 0; i < lib.getShelves().size(); i++){
			
			Shelf shelf = lib.getShelves().get(i);
			
			for(int j = 0; j < shelf.getBooks().size(); j++){
				
				Book book = shelf.getBooks().get(j);
				book.setColor(color);
				
			}
			
		}
		
		return lib;
	}
	
}
