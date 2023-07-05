package fr.webforce3.mycdiapp.utils;

import java.util.Scanner;

public class Scan {

	private static Scanner instance;

	private Scan() {
	}

	public static Scanner get() {
		if (instance == null) {
			instance = new Scanner(System.in);
		}
		instance.reset();
		return instance;
	}
}
