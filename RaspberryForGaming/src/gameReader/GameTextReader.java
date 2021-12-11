package gameReader;

import java.util.ArrayList;

import game.Game;
import reader.IFileReader;
import exceptions.*;

public class GameTextReader implements IGameReader {

	private IFileReader fileReader;

	public GameTextReader(IFileReader fileReader) throws IllegalArgumentException {
		if (fileReader == null)
			throw new IllegalArgumentException("no file reader");
		this.fileReader = fileReader;

	}

	@Override
	public ArrayList<Game> read() throws EmptyListException {
		ArrayList<Game> games = new ArrayList<Game>();

		ArrayList<String> gamesInFile = fileReader.read();

		for (String gameAsString : gamesInFile) {
			String[] partsOfGame = gameAsString.split(";");

			// partsOfGame[1] = name
			// partsOfGame[2] = console
			// partsOfGame[3] = coverPath
			// partsOfGame[4] = gamePath
			if (partsOfGame[2].isEmpty()) {
				games.add(new Game(partsOfGame[0], partsOfGame[1], partsOfGame[3]));
			} else {
				games.add(new Game(partsOfGame[0], partsOfGame[1], partsOfGame[2], partsOfGame[3]));
			}

		}

		if (games.size() == 0)
			throw new EmptyListException("no game found");

		return games;

	}

}
