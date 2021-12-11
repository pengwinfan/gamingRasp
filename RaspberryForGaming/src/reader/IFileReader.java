package reader;

import java.util.ArrayList;

public interface IFileReader {
	ArrayList<String> read() throws EmptyListException;
}
