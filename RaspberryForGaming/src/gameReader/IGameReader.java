package gameReader;

import java.util.ArrayList;
import game.Game;
import exceptions.*;

public interface IGameReader {
	ArrayList<Game> read() throws EmptyListException;
}
