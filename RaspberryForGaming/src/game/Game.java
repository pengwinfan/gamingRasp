package game;

public class Game {

	private String name;
	private Console console;
	private String coverPath;
	private String gamePath;

	public Game(String name, String console, String coverPath, String gamePath) throws IllegalArgumentException {
		if (name.isEmpty())
			throw new IllegalArgumentException("empty name");

		if (console.isEmpty())
			throw new IllegalArgumentException("empty console");

		if (coverPath.isEmpty())
			throw new IllegalArgumentException("empty cover path");

		if (gamePath.isEmpty())
			throw new IllegalArgumentException("empty game path");

		this.name = name;
		this.console = getConsoleFromString(console);
		this.coverPath = coverPath;
		this.gamePath = gamePath;

	}

	public Game(String name, String console, String gamePath) throws IllegalArgumentException {
		if (name.isEmpty())
			throw new IllegalArgumentException("empty name");
		if (console.isEmpty())
			throw new IllegalArgumentException("empty console");
		if (gamePath.isEmpty())
			throw new IllegalArgumentException("empty game path");

		this.name = name;
		this.console = getConsoleFromString(console);
		this.gamePath = gamePath;
	}

	public String getName() {
		return name;

	}

	public Console getConsole() {
		return console;

	}

	public String getGamePath() {
		return gamePath;

	}

	public String getCoverPath() {
		return coverPath;
	}

	private Console getConsoleFromString(String console) throws IllegalArgumentException {
		switch (console) {
		case "GBC":
			return Console.GameBoyColor;

		case "GBA":
			return Console.GameBoyAdvance;

		case "NDS":
			return Console.NintenoDS;

		case "GC":
			return Console.GameCube;

		default:
			throw new IllegalArgumentException("invalid console");
		}
	}

}
