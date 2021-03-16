package itescuela.ajedrez;

public class PieceEmpty extends Piece {

	private static final int VACIA = -1;

	public PieceEmpty() {
		this.tipo = ' ';
		this.color = VACIA;
	}

}
