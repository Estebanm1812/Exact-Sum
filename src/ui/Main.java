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
	
	//while((br.readLine()!=null)) {	
	String line = br.readLine();
	String [] data = line.split(" ");
	int [] valueData = new int[data.length];
	for(int i=0; i < data.length;i++ ) {
		valueData[i] = Integer.parseInt(data[i]);
		
	}
	String line2 = br.readLine();
	String [] prices = line2.split(" ");
	int [] valuePrices = new int[prices.length];
	for(int i=0; i < prices.length;i++) {
		valuePrices[i] = Integer.parseInt(prices[i]);
		
	}	
	String line3 = br.readLine();
	int money = Integer.parseInt(line3);
	
	Arrays.sort(valuePrices);

		int [] positions = findDifference(valuePrices, money);
		
		
	
	
			
		bw.write("Peter should buy books whose prices are " + positions[0] +" and " + positions[1] + ".\n");
		br.readLine();
		
		br.close();
		bw.close();
		//}
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
	
	

}
