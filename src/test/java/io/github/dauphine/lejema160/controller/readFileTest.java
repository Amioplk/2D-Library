package io.github.dauphine.lejema160.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.github.dauphine.lejema160.controller.readFile;
import io.github.dauphine.lejema160.model.Author;
import io.github.dauphine.lejema160.model.Book;

public class readFileTest {

	@Test
	public void readFile_Should_Return_A_List_Of_Books_When_Called() {
		// arrange
		List<Book> expected = new ArrayList<>();

		Author a1 = new Author("CHUNG", "Hugo");
		Author a2 = new Author("ROWLING", "JK");
		Author a3 = new Author("BAUDELAIRE", "Charles");

		Book b1 = new Book();
		b1.setAuthor(a1);
		b1.setTitle("Une vie de coccinelle");
		b1.setYear(2015);
		expected.add(b1);

		Book b2 = new Book();
		b2.setAuthor(a2);
		b2.setTitle("Harry Poopper");
		b2.setYear(2005);
		expected.add(b2);

		Book b3 = new Book();
		b3.setAuthor(a3);
		b3.setTitle("Les misérables");
		b3.setYear(1860);
		expected.add(b3);

		// act
		List<Book> actual = new ArrayList<>();
//		try {
			actual = readFile.read();
//		} 
//		catch (IOException e) {
//			fail("IOException " + e);
//		}

		// assert
		boolean correct = compareBook(expected, actual);
		assertEquals(true, correct);
	}
	/**
	 * Compare the two lists of books.
	 * @param expected
	 * @param actual
	 * @return true if both list contains the same books (in the same order).
	 */
	private boolean compareBook(List<Book> expected, List<Book> actual) {
		boolean res = true;
		if (expected.size() == actual.size()) {
			for (int i = 0; i < expected.size(); i++) {
				Book be = expected.get(i);
				Book ba = actual.get(i);
				if(be != null && ba != null){
					Author ae = be.getAuthor();
					Author aa = ba.getAuthor();
					if(ae != null && aa != null){
						if(be.getTitle().equals(ba.getTitle())
								&& be.getYear() == ba.getYear()
								&& ae.getFirstName().equals(aa.getFirstName())
								&& ae.getLastName().equals(aa.getLastName())){
							// both book are identical
						} else {
							res = false;
							break;
						}
					} else {
						res = false;
						break;
					}
				} else {
					res = false;
					break;
				}
			}
		}
		return res;
	}
}
