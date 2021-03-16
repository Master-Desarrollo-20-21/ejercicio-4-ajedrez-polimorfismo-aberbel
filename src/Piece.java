package itescuela.ajedrez;

public abstract class Piece{
	char tipo;
	int color;
	int up = 1;
	
	public char getTipo() {
		return tipo;
	}
	public int getColor() {
		return color;
	}
	boolean isValidMovement(Position origin, Position target) {
		return true;
	}
}
