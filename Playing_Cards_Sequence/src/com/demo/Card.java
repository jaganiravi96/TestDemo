package com.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {

	// Defining the variable
	/* As for final sequence we need to deal with string only so define
	 * string arraylist only for card type and value, which help us to use 
	 * defined method and get the solution with less line of code
	 */
	
	public ArrayList<String> card_types = new ArrayList<>(Arrays.asList("S", "H", "D", "C"));
	public ArrayList<String> card_values = new ArrayList<>(
			Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
	
	// add string here in array for more test case execution 
	public static String[] str_arr = { "H#A,H#2,H#3,H#4", "S#10,S#J,S#Q", "C#Q,C#K,C#A,C#2", "D#5,D#6,H#7" };

	//main method to run our program
	public static void main(String[] args) {
		Card c1 = new Card();
		// iteration
		for (int i = 0; i < str_arr.length; i++) {
			//passing the string sequence
			System.out.println(c1.checkSequence(str_arr[i]));
		}
	}

	//as per business case define the method checkSquence 
	/*
	 * input argument - card sequence with string type
	 * return type - boolean if pass thorugh all the rule define
	 */
	public boolean checkSequence(String cards) {
		boolean flag = false;
		if (cards != null) {
			 //Separation with ','
			String[] temp = cards.split(",");
			
			//get first card type and value
			String first_card_type = temp[0].split("#")[0];
			String first_card_value = temp[0].split("#")[1];
			
			//get first card index in value arraylist to check the next card
			int index_count = card_values.indexOf(first_card_value);
			
			//validate with the rule
			if (card_types.contains(first_card_type) && card_values.contains(first_card_value)) {
				//iteration
				for (int i = 1; i < temp.length; i++) {
					index_count += 1;
					
					/*
					 * 1. split the string and make array of card
					 * 2. checking each card with first card and consequence index
					 * 3. in case of card consist K then next to next card is present then
					 * 	  its false scenario  
					 */
					String[] split_value = temp[i].split("#");
					if (split_value[0].equals(first_card_type) && card_values.indexOf(split_value[1]) == index_count) {
						flag = true;
					} 
					else {
						flag = false;
						return flag;
					}
					if(split_value[1].equals("K") && (i+2 <= temp.length) )	{
							return false;						
					}
				}
			}
		}

		return flag;
	}

}
