package itescuela.ajedrez;

public class King  extends Piece{

	public King(char tipo, int color) {
		this.tipo = tipo;
		this.color = color;
	}

	@Override
	boolean isValidMovement(Position origin, Position target) {
		return true;
	}

}
