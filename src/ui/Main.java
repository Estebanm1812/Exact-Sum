package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	int [] positions = new int[2];
	int money = 0;
	int valueData;
	int [] valuePrices;
	String result = "";
	
	String line = ""; 
			
	while((line=br.readLine())!=null) {
	
	valueData = booksAmount(line); 
	
	String line2 = br.readLine();
	
	valuePrices = booksPrices(line2);
	
	String line3 = br.readLine();
	
	money = calculateMoney(line3);
	
	line = br.readLine();
	
	Arrays.sort(valuePrices);
	
	positions = findDifference(valuePrices, money);
		
	result+= "Peter should buy books whose prices are " + positions[0] + " and " + positions[1]+ "."+"\n"+"\n";	
	

	
	}		
		bw.write(result);
		
		br.close();
		bw.close();
		
	}
	public static int  binarySearch(int [] prices, int money) {
		
		
		int i= 0;
		
		int j = prices.length-1;
		
		int found = -1;
		
		int m = 0;
		
		while(found<0 && i<=j) {
		
			m = (i+j)/2;
			
			if(prices[m]==money) {
			
				found = m;
				
		
			}else if(prices[m]>money) {
				
				j= m-1;
				
			}else if(prices[m]<money) {
				
				i=m+1;
				
			}
		}
		return found;
	}
	public static int [] findDifference(int [] prices, int money) {
		
		int diff = 0;
		
		int temporaryDiff = Integer.MAX_VALUE;
		
		int [] positions = new int[2];
		
		for(int i=0; i < prices.length;i++) {
		
			
			
		if(binarySearch(prices,(money-prices[i]))>=0) {
			
			if(prices[i]-prices[binarySearch(prices,(money-prices[i]))]<Integer.MAX_VALUE) {
			
				diff = Math.abs(prices[i]-prices[binarySearch(prices,(money-prices[i]))]);
								
				if((temporaryDiff)>(diff)) {
				
				temporaryDiff = diff;
			
					
				positions[0] = prices[i];
				positions[1] = prices[binarySearch(prices,(money-prices[i]))];
				}
			}
			
		}
			
		}
		
		return positions; 
	}
	public static int booksAmount(String line) {
		
		int quantity = Integer.parseInt(line);
		
		return quantity;
	}
	public static int [] booksPrices(String line2) {
	
	int [] prices;
	
	String [] noNumericPrices = line2.split(" ");
	
	prices = new int[noNumericPrices.length];
	
	for(int i=0; i < noNumericPrices.length;i++) {
	
		prices[i] = Integer.parseInt(noNumericPrices[i]);
		
	}	
	return prices;
	}
	public static int calculateMoney(String line3) {
		
		int money = Integer.parseInt(line3);
		
		return money;
	}
}
