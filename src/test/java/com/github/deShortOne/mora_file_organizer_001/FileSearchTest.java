package com.github.deShortOne.mora_file_organizer_001;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple FileSearch.
 */
public class FileSearchTest {

	/**
	 * Searches for just one word.
	 * @throws FileNotFoundException	File not found
	 */
	@Test
	public void searchOneWord() throws FileNotFoundException {
		FileSearch fs = new FileSearch("files/quotes.txt");

		ArrayList<Integer> i = fs.searchString("You");
		assertTrue(i.equals(Arrays.asList(5, 20, 24)));

		i = fs.searchString("you");
		assertTrue(i.equals(Arrays.asList(5, 11, 13, 16, 24, 26, 27, 28, 29, 30,
				34, 36, 37, 38, 39, 40, 41, 42, 43, 46)));
	}
	
	/**
	 * Searches for word that isn't in list.
	 * @throws FileNotFoundException	File not found
	 */
	@Test
	public void cannotFindWord() throws FileNotFoundException {
		FileSearch fs = new FileSearch("files/quotes.txt");
		
		ArrayList<Integer> i = fs.searchString("ASDFASDF");
		assertTrue(i.isEmpty());
	}

}
