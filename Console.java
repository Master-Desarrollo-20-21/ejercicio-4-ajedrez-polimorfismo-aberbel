package itescuela.ajedrez;

import java.util.Scanner;

public class Console {

	private Scanner scanner;
	private static Console instance;
	public static Console getInstance() {
		if(instance == null){
			instance = new Console();
		}
		return instance;
	}
	public Console() {
		this.scanner = new Scanner(System.in);
	}

	public String readString(String message) {
		System.out.print(message);
		return this.scanner.nextLine();
	}

	public void write(String message) {
		System.out.println(message);
	}
	public void writeSinLn(String message) {
		System.out.print(message);
	}

}

