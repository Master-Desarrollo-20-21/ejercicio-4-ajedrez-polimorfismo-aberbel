package itescuela.ajedrez;

public enum Row {
	ONE(0),TWO(1),THREE(2),FOUR(3),FIVE(4),SIX(5),SEVEN(6),EIGHT(7);

	int position;
	Row(int position) {
		this.position = position;
	}
	public int getPosition() {
		return position;
	}
	public static Row getRow(String row) {
		
		for (Row i: Row.values()) {
			if (i.getPosition() == Integer.valueOf(row)) {
				return i;
			}
		}
		return null;
		
	}
	
	
}
