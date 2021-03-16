package itescuela.ajedrez;

public class Knight extends Piece{

	public Knight(char tipo,int color) {
		this.tipo = tipo;
		this.color = color;
	}

	@Override
	boolean isValidMovement(Position origin, Position target) {
		return true;
	}

}
