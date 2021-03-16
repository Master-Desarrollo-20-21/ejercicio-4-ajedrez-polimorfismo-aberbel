package itescuela.ajedrez;

public class Game {
	
	private static final int FILAS = 8;
	private static final int COLUMNAS = 8;
	private static final int NUMERO_JUGADORES = 2;
	public static final int WHITE = 0;
	public static final int BLACK = 1;
	


	Square [][] board;
	Player[] players;
	int turno;
	
	Game(){
		board = new Square[COLUMNAS][FILAS];
		this.setPieceEmptyAllBoard();
		this.setPawns();
		this.setKnights();
		this.setKings();
		players = new Player[NUMERO_JUGADORES];
		players[WHITE] = new Player(WHITE);
		players[BLACK] = new Player(BLACK);

	}
	
	private void setPieceEmptyAllBoard() {
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				board[i][j] = new Square(new PieceEmpty());
			}
		}
	}

	private void setKings() {
		King whiteKing = new King('R',WHITE);
		King blackKing = new King('r',BLACK);
		board[Column.D.getPosition()][Row.ONE.getPosition()] = new Square(whiteKing);
		board[Column.D.getPosition()][Row.EIGHT.getPosition()] = new Square(blackKing);	
	}

	private void setKnights() {
		for (int i = 1; i < FILAS; i=i+5) {
			Knight whiteKnight = new Knight('C',WHITE);
			Knight blackKnight = new Knight('c',WHITE);
			board[i][Row.ONE.getPosition()] = new Square(whiteKnight);
			board[i][Row.EIGHT.getPosition()] = new Square(blackKnight);
		}
	}

	private void setPawns() {
		for (int i = 0; i < COLUMNAS; i++) {
			Pawn whitePawn = new Pawn('P',WHITE);
			Pawn blackPawn = new Pawn('p',BLACK); 
			board[i][Row.TWO.getPosition()] = new Square(whitePawn);
			board[i][Row.SEVEN.getPosition()] = new Square(blackPawn);
		}
	}

	public void play() {
		turno = WHITE;
		do {
			this.showBoard();
			this.move();
			this.changeTurn();
		} while (!this.isDeadKing(turno));
		
	}

	private void move() {
			Position origin = Position.getOrigin(turno);
			Piece pieceOrigin = board[origin.getColumn().getPosition()]
					[origin.getRow().getPosition()].getPiece();
			while (pieceOrigin.getTipo() == ' ' 
					|| pieceOrigin.getColor() != players[turno].getColor()) {
				this.showError("No hay ninguna pieza tuya en esa posición");
				origin = Position.getOrigin(turno);
				pieceOrigin = board[origin.getColumn().getPosition()]
						[origin.getRow().getPosition()].getPiece();
			}
			Position target = Position.getTarget(pieceOrigin.tipo);
			Piece pieceTarget = board[target.getColumn().getPosition()]
					[target.getRow().getPosition()].getPiece();
			while (pieceTarget.getColor() == players[turno].getColor()) {
				this.showError("Hay un/a "+pieceTarget.getTipo()+" tuyo en esa posición");
				target = Position.getTarget(pieceOrigin.tipo);
				pieceTarget = board[target.getColumn().getPosition()]
						[target.getRow().getPosition()].getPiece();
			}
			if (this.checkMovement(pieceOrigin,origin,target)) {
				this.move(pieceOrigin,target);
				this.delete(origin);
			}	
	}

	private boolean checkMovement(Piece pieceOrigin, Position origin, Position target) {
		return pieceOrigin.isValidMovement(origin, target) && !this.isTherePathPieces();
	}

	private boolean isTherePathPieces() {
		return false;
	}

	private void delete(Position origin) {
		board[origin.getColumn().getPosition()]
				[origin.getRow().getPosition()] = new Square(new PieceEmpty());
	}

	private void move(Piece pieceOrigin, Position target) {
		board[target.getColumn().getPosition()]
				[target.getRow().getPosition()] = new Square(pieceOrigin);
		
	}

	private void showError(String text) {
		new Console().write(text);
	}

	private boolean isDeadKing(int turno2) {
		return false;
	}

	private void changeTurn() {
		turno = turno == WHITE? BLACK: WHITE;		
	}

	private void showBoard() {
		Console console = new Console();
		showNameColumns(console);
		console.writeSinLn("\n");
		for (int i = 0; i < FILAS; i++) {
			showNumberRows(console, i);
			showPiecesBoard(console, i);
		}
	}

	private void showPiecesBoard(Console console, int i) {
		for (int j = 0; j < COLUMNAS; j++) {
			console.writeSinLn(String
					.valueOf(board[j][i].getPiece().getTipo())+"|");
		}
		console.writeSinLn("\n");
	}

	private void showNumberRows(Console console, int i) {
		console.writeSinLn(i+1+"|");
	}

	private void showNameColumns(Console console) {
		console.writeSinLn("  ");
		for (int i = 0; i < COLUMNAS; i++) {
			console.writeSinLn(Column.values()[i].toString()+" ");
		}
	}
}
