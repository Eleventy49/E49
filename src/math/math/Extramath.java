package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.SwingUtilities;

public class Extramath {
	/**
	 * 
	 * @param howRandom Sets the number of internal random number generators. Values are clamped 1-10
	 */
	
	private Random[] generators;
	
	public Extramath(int howRandom) {
		int toBeUsed = howRandom;
		if(howRandom > 10)
			howRandom = 10;
		toBeUsed = 11 - toBeUsed;
		this.generators = new Random[toBeUsed];
		for (int i = 0; i < generators.length; i++) {
			generators[i] = new Random();
		}
	}
	
	public double genNumberBetween(int num1, int num2) {
		double random = genBellCurve();
		int range = num2 - num1;
		return (random * range) + num1;
	}
	
	//Generates a value between 0 and 1, which should fall approximately on a ball curve.
	//This means that values near 0.5 are overwhelmingly likely with a low number of random number generators
	public double genBellCurve() {
		
		//Hold the added up value of the random number generator
		double returnVal = 0.0;
		//Run for each RNG used (determined by the constructor)
		for(Random r: this.generators) {
			//Generate an integer
			int j = r.nextInt(11);
			//Add result to the return value
			returnVal += j;
			}
		
		return returnVal / (generators.length * 10);
	}
	/*
	public static double chanceBetweenNumbers(int num1, int num2) {
		
	}
*/
}
