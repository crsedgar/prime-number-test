package uk.org.cobaltdevelopment.prime;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.print("Please enter number of primes or -1 to exit:");
			int numberOfPrimes = sc.nextInt();
			if (numberOfPrimes == -1) {
				running = false;
			} else {
				new App().run(numberOfPrimes);
			}
		}

		sc.close();

	}

	public void run(int numberOfPrimes) {
		PrimeGenerator primeGenerator = new PrimeGenerator();
		int[] primes = primeGenerator.generatePrimes(numberOfPrimes);
		PrimeTable primeTable = new PrimeTable(primes);
		primeTable.setFormatter(new TwoDimensionalPrimeTableFormatter());
		System.out.println(primeTable.formatTable());
	}

}
