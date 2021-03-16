package itescuela.ajedrez;

public class Player {
	int color;

	public Player(int color) {
		super();
		this.color = color;
	}


	public int getColor() {
		return color;
	}


	public char getKing() {
		switch(color) {
		case Game.WHITE:
			return 'R';
		case Game.BLACK:
			return 'r';
		default : 
			throw new IllegalStateException("Color no válido de Rey");			
		}
	}
	public char getPawn() {
		switch(color) {
		case Game.WHITE:
			return 'P';
		case Game.BLACK:
			return 'p';
		default : 
			throw new IllegalStateException("Color no válido de Peón");			
		}
	}
	public char getKnight() {
		switch(color) {
		case Game.WHITE:
			return 'C';
		case Game.BLACK:
			return 'c';
		default : 
			throw new IllegalStateException("Color no válido de Caballo");			
		}
	}

	

}
