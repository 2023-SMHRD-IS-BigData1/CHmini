package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import Model.Card;
import Model.PokerDealer;
import Model.PokerPlayer;

public class Method {

	Random rd = new Random();

	PokerPlayer pokerPlayer = null;
	PokerDealer pokerDealer = new PokerDealer();

	ArrayList<Card> cards = new ArrayList<Card>(); // 덱
	ArrayList<Card> playerHand = new ArrayList<Card>(); // 플레이어의 패
	ArrayList<Card> dealerHand = new ArrayList<Card>(); // 딜러의 패

	public void getInputName(String name) {// Player의 name을 가져오기 위한 메소드
		pokerPlayer = new PokerPlayer(null, null, name, 50);
	}

	public void getCards(ArrayList<Card> a) {
		for (int i = 0; i < a.size(); i++) {
			cards.add(a.get(i));
		}
	}

	// 1. 플레이어가 카드를 5장 배분받는 메소드
	public ArrayList<Card> dealPlayer5() {

		while (playerHand.size() < 5) {
			playerHand.add(cards.get(rd.nextInt(52)));
			HashSet<Card> hs = new HashSet<Card>(playerHand);
			playerHand.clear();
			playerHand.addAll(hs);

			if (playerHand.size() == 5) {
				break;
			}

		}
		for (int i = 0; i < playerHand.size(); i++) { 
			System.out.print(playerHand.get(i).getNumber());
			System.out.println(playerHand.get(i).getPattern());
		}
		System.out.println("==========플레이어==========");
		return playerHand;
	}

	// 1. 딜러가 카드를 5장 배분받는 메소드
	public ArrayList<Card> dealDealer5() { //반드시 dealPlayer5() 를 먼저 실행 후 실행할 것.
//		 playerHand = dealPlayer5();
		while (dealerHand.size() < 5) {
			while (dealerHand.size() < 5) {
				dealerHand.add(cards.get(rd.nextInt(52)));
				HashSet<Card> hs = new HashSet<Card>(dealerHand);
				dealerHand.clear();
				dealerHand.addAll(hs);
				if (dealerHand.size() == 5) {
					break;
				}
				
			}
			for (int i = 5; i > 0; i--) { // 플레이어 핸드와의 중복 제거
				for (int j = 0; j < playerHand.size(); j++) {
					if (dealerHand.get(i - 1).equals(playerHand.get(j))) {
						dealerHand.remove(i - 1);
					}
				}
			}

			if (dealerHand.size() == 5) {
				break;
			}
		}

		for (int i = 0; i < playerHand.size(); i++) { 
			System.out.print(dealerHand.get(i).getNumber());
			System.out.println(dealerHand.get(i).getPattern());
		}
		System.out.println("==========딜러==========");

		return dealerHand;
	}

// 2. 가진 칩 이하의 칩을 배팅하는 메소드 ( 플레이어만, 딜러는 계속 따라옴 )

// 3. 가진 카드에 한장씩을 추가해 주는 메소드

// 4. 받은 카드의 족보를 확인하는 메소드
	
	public void checkTree(ArrayList<Card> hand) {
		ArrayList<Integer> tempNum = new ArrayList<Integer>(); // 패에서 숫자를 분리한 임시 리스트
		ArrayList<String> tempPattern = new ArrayList<String>(); //패에서 모양을 분리한 임시 리스트
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getNumber().equals("Ace")) {
				tempNum.add(1);
			}else if (hand.get(i).getNumber().equals("Jack")) {
				tempNum.add(11);
			}else if (hand.get(i).getNumber().equals("Queen")) {
				tempNum.add(12);
			}else if (hand.get(i).getNumber().equals("King")) {
				tempNum.add(13);
			}else if (hand.get(i).getNumber().equals("2")) {
				tempNum.add(2);
			}else if (hand.get(i).getNumber().equals("3")) {
				tempNum.add(3);
			}else if (hand.get(i).getNumber().equals("4")) {
				tempNum.add(4);
			}else if (hand.get(i).getNumber().equals("5")) {
				tempNum.add(5);
			}else if (hand.get(i).getNumber().equals("6")) {
				tempNum.add(6);
			}else if (hand.get(i).getNumber().equals("7")) {
				tempNum.add(7);
			}else if (hand.get(i).getNumber().equals("8")) {
				tempNum.add(8);
			}else if (hand.get(i).getNumber().equals("9")) {
				tempNum.add(9);
			}else if (hand.get(i).getNumber().equals("10")) {
				tempNum.add(10);
			}
				
		}

		for (int i = 0; i < hand.size(); i++) {
			tempPattern.add(hand.get(i).getPattern());
		}

		
	}
	
// pot이란 메소드
	public int pot(int beting_chip) { 
		PokerPlayer p_player = new PokerPlayer(beting_chip);
		PokerDealer p_dealer = new PokerDealer();
		p_player.setChip(p_player.getChip()-1); // 플레이어칩 -1
		p_dealer.setChip(p_dealer.getChip()-1); // 딜러칩 -1
		int pot = p_player.getBeting_chip()*2;
		return pot;
		// 추후에 우열을 가려서 승자에게 pot을 지급하면 됨.
	}
	
// 5. 족보의 우열을 판단해 승자를 정하는 메소드

}
