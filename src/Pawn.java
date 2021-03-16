package itescuela.ajedrez;

public class Pawn extends Piece{

	private static final int MOVE_DOWN = +1;
	private static final int MOVE_UP = -1;

	public Pawn(char tipo, int color) {
		this.tipo = tipo;
		up = IsLowerCase(tipo) ? MOVE_UP: MOVE_DOWN;
		this.color = color;
	}

	private boolean IsLowerCase(char tipo) {
		return (int) tipo >=97 && (int) tipo >=122;
	}



	@Override
	boolean isValidMovement(Position origin, Position target) {
		origin.getRow().getPosition();
		origin.getColumn().getPosition();
		return true;
	}

}
