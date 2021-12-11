package reader;

import java.util.ArrayList;

import exceptions.EmptyListException;

public interface IFileReader {
	ArrayList<String> read() throws EmptyListException;
}
