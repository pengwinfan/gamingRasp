package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileReader implements IFileReader {

	private File textFile;

	public TextFileReader(String path) throws IllegalArgumentException {
		validatePath(path);
		textFile = new File(path);

	}

	@Override
	public ArrayList<String> read() throws EmptyListException {
		ArrayList<String> linesInText = new ArrayList<String>();

		Scanner textScanner;
		try {
			textScanner = new Scanner(textFile);

			while (textScanner.hasNext()) {
				linesInText.add(textScanner.next());

			}

			textScanner.close();

		} catch (FileNotFoundException e) {
			throw new EmptyListException("file not found");
		}

		if (linesInText.size() == 0)
			throw new EmptyListException("no textline found");

		return linesInText;
	}

	private void validatePath(String path) throws IllegalArgumentException {
		File textFile = new File(path);
		isFileExisting(textFile);
		isFileText(textFile);

	}

	private void isFileExisting(File fileToCheck) throws IllegalArgumentException {
		if (!fileToCheck.exists())
			throw new IllegalArgumentException("file not exists");

	}

	private void isFileText(File fileToCheck) throws IllegalArgumentException {
		String filename = fileToCheck.getName();
		String extension = filename.substring(filename.length() - 4);

		if (!extension.equals(".txt"))
			throw new IllegalArgumentException("no text file");
	}

}
