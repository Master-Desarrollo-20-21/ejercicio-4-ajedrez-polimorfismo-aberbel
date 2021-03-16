package itescuela.ajedrez;

public class Position {
	private Column column;
	private Row row;
	public Position(Column column, Row row) {
		super();
		this.column = column;
		this.row = row;
	}
	public Column getColumn() {
		return column;
	}
	public Row getRow() {
		return row;
	}
	public static Position getOrigin(int turno) {
		String colorPieza = turno == Game.WHITE ? "blanca":"negra";
		return getPosition("Dame la columna [A-H] y la fila [1-8] de la Pieza "+colorPieza+" a mover:");
	}


	public static Position getTarget(char tipo) {
		return getPosition("Dame la columna [A-H] y la fila [1-8] donde poner "+tipo+" :");
	}

	private static Position getPosition(String text) {
		Console console = new Console();
		String coordenate = console.readString(text);		
		return new Position(
				Column.valueOf(coordenate.substring(0, 1).toUpperCase()), 
				Row.getRow(String.valueOf(
						Integer.parseInt(coordenate.substring(1))-1)));
	}
	
}
