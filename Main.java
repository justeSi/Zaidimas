package Zaidimas;

import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		final int MAX = 100;
		boolean teisingai = false;
		Scanner in = new Scanner(System.in);
		System.out.println("Atspėkite skaičių nuo 1 iki 100: ");
		int spejimas = 0;
		Random rand = new Random();
		int sk = rand.nextInt(MAX) + 1;
//		System.out.println(sk);
		int count = 1;
		TreeSet<Integer> spejimai = new TreeSet<>();
		
		while (!teisingai) {
			System.out.print(count+"-as spęjimas: ");
			spejimas = in.nextInt();
			if (spejimai.contains(spejimas)) {
				System.out.println("Tokį skaičių jau spėjote!");
			} else if (sk>spejimas) {
						System.out.println("Spėjamas skaičius per mažas.");
					} 
				else if (sk<spejimas) {
						System.out.println("Spėjamas skaičius per didelis.");
					}
				else {
					System.out.println("Atspėjote!");
					teisingai = true;
				}
			spejimai.add(spejimas);
			count++;
			}
			
			
			in.close();
		}
	}


