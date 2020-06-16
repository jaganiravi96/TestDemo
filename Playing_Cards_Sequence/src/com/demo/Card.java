package com.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {

	public ArrayList<String> card_types = new ArrayList<>(Arrays.asList("S", "H", "D", "C"));
	public ArrayList<String> card_values = new ArrayList<>(
			Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
	public static String[] str_arr = { "H#A,H#2,H#3,H#4", "S#10,S#J,S#Q", "C#Q,C#K,C#A,C#2", "D#5,D#6,H#7" };

	public static void main(String[] args) {
		Card c1 = new Card();
		// iteration
		for (int i = 0; i < str_arr.length; i++) {
			System.out.println(c1.checkSequence(str_arr[i]));
		}
	}

	public boolean checkSequence(String cards) {
		boolean flag = false;
		if (cards != null) {
			String[] temp = cards.split(",");
			String first_card_type = temp[0].split("#")[0];
			String first_card_value = temp[0].split("#")[1];
			int index_count = card_values.indexOf(first_card_value);
			int counter = 0;
			int arr_size = temp.length;
						
			if (card_types.contains(first_card_type) && card_values.contains(first_card_value)) {
				for (int i = 1; i < temp.length; i++) {
					index_count += 1;
					String[] split_value = temp[i].split("#");
					if (split_value[0].equals(first_card_type) && card_values.indexOf(split_value[1]) == index_count) {
						flag = true;
					} 
					else {
						flag = false;
						return flag;
					}
					if(split_value[1].equals("K") && (i+2 <= temp.length) )
					{
						index_count = 0;
						if(temp[i+2].split("#").equals("2"))
							return false;
						
					}
				}
			}
		}

		return flag;
	}

}
