package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	String line = br.readLine();
	String [] data = line.split(" ");
	int [] valueData = new int[line.length()];
	
	String line2 = br.readLine();
	String [] prices = line2.split(" ");
	int [] valuePrices = new int[line2.length()];
	
	String line3 = br.readLine();
	int money = Integer.parseInt(line3);
	
	Arrays.sort(valuePrices);

	
	}

}
