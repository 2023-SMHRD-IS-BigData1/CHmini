package Controller;

import java.util.ArrayList;

import Model.Card;

public class Deck {

	
	
	public static void main(String[] args) {

		Method method = new Method();
		ArrayList<Card> cards = new ArrayList<Card>();//Card자료형의 Arraylist
		
		String[] cardPattern = { "♠" , "♥", "♦", "♣"};//4개의 패턴
		String[] cardNumber = new String[13]; //숫자 13개
		
		for (int i = 0; i < 13; i++) {
			if (i == 0) {
				cardNumber[i] = "Ace";
			}else if (i == 10) {
				cardNumber[i] = "Jack";
			}else if (i == 11) {
				cardNumber[i] = "Queen";
			}else if (i == 12) {
				cardNumber[i] = "King";
			}else {
				cardNumber[i] = String.valueOf(i + 1);
			}
			
		}
		
		for (int i = 0; i < cardPattern.length; i++) {
			for (int j = 0; j < cardNumber.length; j++) {
				Card card = new Card(cardPattern[i], cardNumber[j]);
				cards.add(card);
			}
		}
		method.getCards(cards);
		
		method.dealDealer5();
		
		
		


	}
}
