package itescuela.ajedrez;

public class Ajedrez {
	
	Console console;
	
	Ajedrez(){
		console = new Console();
	}

	public static void main(String[] args) {
		new Ajedrez().play();

	}

	private void play() {
		do {
			Game game = new Game();
			game.play();
		} while (this.isResumed());

	}

	private boolean isResumed() {
		String resume = console.readString("RESUME? (y/n):");
		return "y".equalsIgnoreCase(resume);
	}

}
