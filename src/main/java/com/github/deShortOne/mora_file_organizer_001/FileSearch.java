package com.github.deShortOne.mora_file_organizer_001;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to hold get file and search for string in it.
 * 
 * @author deShortOne
 *
 */
public class FileSearch {

	/**
	 * Contents of the files, each is a line in the file.
	 */
	private final ArrayList<String> fileContents;

	/**
	 * 
	 * @param filename Name of file
	 * @throws FileNotFoundException File not found
	 */
	public FileSearch(String filename) throws FileNotFoundException {
		fileContents = getContentsFromFile(filename);
	}

	/**
	 * Returns list of line numbers for which the string is found in file.
	 * 
	 * @param stringToFind String to search in file
	 * @return List of line numbers
	 */
	public ArrayList<Integer> searchString(String stringToFind)
			throws FileNotFoundException {
		return findStringInLines(stringToFind);
	}

	/**
	 * Takes in filename and returns list of lines from file.
	 * 
	 * @param file Name of file
	 * @throws FileNotFoundException File not found
	 */
	private ArrayList<String> getContentsFromFile(String filename)
			throws FileNotFoundException {
		File inputFile = new File(filename);
		Scanner in = new Scanner(inputFile);

		ArrayList<String> listedContentsFromFile = new ArrayList<>();
		while (in.hasNextLine()) {
			listedContentsFromFile.add(in.nextLine());
		}

		in.close();
		return listedContentsFromFile;
	}

	/**
	 * Finds and returns list of line numbers the string is found on.
	 * 
	 * @param stringToFind String to find in file lines
	 * @return List of line numbers
	 */
	private ArrayList<Integer> findStringInLines(String stringToFind) {
		ArrayList<Integer> lineNumberStringFoundOn = new ArrayList<>();
		for (int i = 0; i < fileContents.size(); i++) {
			if (fileContents.get(i).contains(stringToFind)) {
				lineNumberStringFoundOn.add(i);
			}
		}
		return lineNumberStringFoundOn;
	}
}
