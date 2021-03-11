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

	
	int i = 0;
	int j= valuePrices.length-1;
	int found = -1;
	int [] options = new int[2];
	
	
	while(found<0 && i<=j) {
	
		int m=(j+i)/2;
		
		if((valuePrices[i]+valuePrices[j])==money){
		
			options[0] = valuePrices[i];
			options[1] = valuePrices[j];
			found = 1;
			
			}else if(valuePrices[j]+valuePrices[m]>=money) {
				
				j= m-1;
				
			}else if(valuePrices[i]+valuePrices[m]<money) {
		
				i = m+1;	
				
			}
			
		}
		bw.write("Peter should buy books whose prices are " + options[0] +" and " + options[1] + "\n");
		br.close();
		bw.close();
	}
	
	

}
