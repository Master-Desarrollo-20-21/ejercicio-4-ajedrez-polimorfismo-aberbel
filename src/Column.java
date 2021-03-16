package itescuela.ajedrez;

public enum Column {
	A(0),B(1),C(2),D(3),E(4),F(5),G(6),H(7);

	int position;
	Column(int position) {
		this.position = position;
	}
	public int getPosition() {
		return position;
	}
	

}
