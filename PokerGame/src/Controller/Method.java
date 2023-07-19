package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import Model.Card;
import Model.PokerDealer;
import Model.PokerPlayer;

public class Method {

	Random rd = new Random();

	PokerPlayer pokerPlayer = null;
	PokerDealer pokerDealer = new PokerDealer();

	ArrayList<Card> cards = new ArrayList<Card>();
	ArrayList<Card> playerHand = new ArrayList<Card>();
	ArrayList<Card> dealerHand = new ArrayList<Card>();

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
//			for (int i = 0; i < playerHand.size(); i++) { //
//				System.out.print(playerHand.get(i).getNumber());
//				System.out.println(playerHand.get(i).getPattern());
//			}
			if (playerHand.size() == 5) {
				break;
			}

		}
		return playerHand;
	}

	// 1. 딜러가 카드를 5장 배분받는 메소드
	public ArrayList<Card> dealDealer5() {
		playerHand = dealPlayer5();
		ArrayList<Card> resultList = new ArrayList<Card>();
		
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
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < playerHand.size(); j++) {
				if (dealerHand.get(i - 1).equals(playerHand.get(j))) {
					dealerHand.remove(i - 1);
				}
			}
		}
		
//		for (int i = 0; i < dealerHand.size(); i++) {
//		System.out.print(dealerHand.get(i).getNumber());
//		System.out.println(dealerHand.get(i).getPattern());
//		}
//		System.out.println("=================");
		
		for (int i = 0; i < dealerHand.size(); i++) {
			if (!resultList.contains(dealerHand.get(i))) {
				resultList.add(dealerHand.get(i));
			}
		}
		
		dealerHand.clear();
		dealerHand.addAll(resultList);
		
		if (dealerHand.size() == 5) {
			break;
		}
		}

		return dealerHand;
	}
	
// 2. 가진 칩 이하의 칩을 배팅하는 메소드 ( 플레이어만, 딜러는 계속 따라옴 )
	
	
// 3. 가진 카드에 한장씩을 추가해 주는 메소드

	
	
	
	
// 4. 받은 카드의 족보를 확인하는 메소드
// 5. 족보의 우열을 판단해 승자를 정하는 메소드
	
}



