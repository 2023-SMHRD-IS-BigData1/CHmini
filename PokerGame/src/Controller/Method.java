package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import Model.Card;
import Model.PokerDealer;
import Model.PokerPlayer;

public class Method {

	Random rd = new Random();

	PokerPlayer pokerPlayer = null;
	PokerDealer pokerDealer = new PokerDealer();
	int playerchip;
	int dealerchip;
	int pot = 0;
	
	ArrayList<Card> cards = new ArrayList<Card>(); // 덱
	ArrayList<Card> playerHand = new ArrayList<Card>(); // 플레이어의 패
	ArrayList<Card> dealerHand = new ArrayList<Card>(); // 딜러의 패
	public void handClear() {
		playerHand.clear();
		dealerHand.clear();
	}

	public void getInputName(String name) {// Player의 name을 가져오기 위한 메소드
		pokerPlayer = new PokerPlayer(null, null, name, 50);
	}

	public void getCards(ArrayList<Card> a) { // Main의 Cards 를 가져오기 위한 메소드
		for (int i = 0; i < a.size(); i++) {
			cards.add(a.get(i));
		}
	}

	public void getPlayerChips(int a) {
		playerchip = a;
	}

	public void getDealerChips(int a) {
		dealerchip = a;
	}
	
	public int returnPlayerChips() {
		return playerchip;
	}
	
	public int returnDealerChips() {
		return dealerchip;
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
//		for (int i = 0; i < playerHand.size(); i++) {
//			System.out.print(playerHand.get(i).getNumber());
//			System.out.println(playerHand.get(i).getPattern());
//		}
//		System.out.println("==========플레이어==========");
		return playerHand;
	}

	// 1. 딜러가 카드를 5장 배분받는 메소드
	public ArrayList<Card> dealDealer5() { // 반드시 dealPlayer5() 를 먼저 실행 후 실행할 것.
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

//		for (int i = 0; i < playerHand.size(); i++) {
//			System.out.print(dealerHand.get(i).getNumber());
//			System.out.println(dealerHand.get(i).getPattern());
//		}
//		System.out.println("==========딜러==========");

		return dealerHand;
	}

// 2. 가진 칩 이하의 칩을 배팅하는 메소드 ( 플레이어만, 딜러는 계속 따라옴 )

	public int pot(int beting_chip) {
		playerchip -= beting_chip;
		dealerchip -= beting_chip;
		pot += beting_chip * 2;
		return pot;
		// 추후에 우열을 가려서 승자에게 pot을 지급하면 됨.
	}
	
	public void potReset() {
		pot = 0;
	}

// 3. 가진 카드에 한장씩을 추가해 주는 메소드

	public ArrayList<Card> dealPlayer1() { // 플레이어에게 1장

		while (true) {
			playerHand.add(cards.get(rd.nextInt(52)));
			int count = playerHand.size();
			HashSet<Card> hs = new HashSet<Card>(playerHand);
			playerHand.clear();
			playerHand.addAll(hs);

			for (int j = 0; j < dealerHand.size(); j++) { // 가장 최근 추가된 값이 딜러 패와 중복이라면 지우는 코드.
				if (playerHand.get(playerHand.size() - 1).equals(dealerHand.get(j))) {
					playerHand.remove(playerHand.size() - 1);
				}
			}

			if (playerHand.size() == count) { // 1장 추가된 상태 그대로라면 break
				break;
			}
		}
//		for (int i = 0; i < playerHand.size(); i++) {
//			System.out.print(playerHand.get(i).getNumber());
//			System.out.println(playerHand.get(i).getPattern());
//		}
//		System.out.println("==========플레이어==========");
		return playerHand;

	}

	public ArrayList<Card> dealDealer1() { // 딜러에게 1장

		while (true) {
			dealerHand.add(cards.get(rd.nextInt(52)));
			int count = dealerHand.size();
			HashSet<Card> hs = new HashSet<Card>(dealerHand);
			dealerHand.clear();
			dealerHand.addAll(hs);

			for (int j = 0; j < playerHand.size(); j++) { // 가장 최근 추가된 값이 플레이어 패와 중복이라면 지우는 코드.
				if (dealerHand.get(dealerHand.size() - 1).equals(playerHand.get(j))) {
					dealerHand.remove(dealerHand.size() - 1);
				}
			}

			if (dealerHand.size() == count) { // 1장 추가된 상태 그대로라면 break
				break;
			}
		}
//		for (int i = 0; i < playerHand.size(); i++) {
//			System.out.print(dealerHand.get(i).getNumber());
//			System.out.println(dealerHand.get(i).getPattern());
//		}
//		System.out.println("==========딜러==========");

		return dealerHand;
	}

// 4. 받은 카드의 족보를 확인하는 메소드

	public String checkTree(ArrayList<Card> hand) {
		ArrayList<Integer> tempNum = new ArrayList<Integer>(); // 패에서 숫자를 분리한 임시 리스트
		ArrayList<String> tempPattern = new ArrayList<String>(); // 패에서 모양을 분리한 임시 리스트
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getNumber().equals("Ace")) {
				tempNum.add(1);
			} else if (hand.get(i).getNumber().equals("Jack")) {
				tempNum.add(11);
			} else if (hand.get(i).getNumber().equals("Queen")) {
				tempNum.add(12);
			} else if (hand.get(i).getNumber().equals("King")) {
				tempNum.add(13);
			} else if (hand.get(i).getNumber().equals("2")) {
				tempNum.add(2);
			} else if (hand.get(i).getNumber().equals("3")) {
				tempNum.add(3);
			} else if (hand.get(i).getNumber().equals("4")) {
				tempNum.add(4);
			} else if (hand.get(i).getNumber().equals("5")) {
				tempNum.add(5);
			} else if (hand.get(i).getNumber().equals("6")) {
				tempNum.add(6);
			} else if (hand.get(i).getNumber().equals("7")) {
				tempNum.add(7);
			} else if (hand.get(i).getNumber().equals("8")) {
				tempNum.add(8);
			} else if (hand.get(i).getNumber().equals("9")) {
				tempNum.add(9);
			} else if (hand.get(i).getNumber().equals("10")) {
				tempNum.add(10);
			}

		}

		for (int i = 0; i < hand.size(); i++) {
			tempPattern.add(hand.get(i).getPattern());
		}

		// 우선순위에 따라 정렬
		Collections.sort(tempNum);

		// 플러시 여부 체크
		boolean isFlush = tempPattern.stream().distinct().count() == 1;

		// 스트레이트 여부 체크
		boolean isStraight = true;
		for (int i = 1; i < tempNum.size(); i++) {
			if (tempNum.get(i) != tempNum.get(i - 1) + 1) {
				isStraight = false;
				break;
			}
		}

		// 우선순위에 따라 패 판단
		if (isFlush && isStraight) {
			// 패턴이 모두 같고 연속된 숫자인 경우: 스트레이트 플러쉬
			if (tempNum.contains(1) && tempNum.contains(10) && tempNum.contains(11) && tempNum.contains(12)
					&& tempNum.contains(13)) {
				// 10, J, Q, K, A로 구성된 경우: 로얄 플러쉬
				return "로얄 플러쉬";
			} else {
				return "스트레이트 플러쉬";
			}
		} else if (isFlush) {
			// 패턴이 모두 같은 경우: 플러쉬
			return "플러쉬";
		} else if (isStraight) {
			// 연속된 숫자인 경우: 스트레이트
			return "스트레이트";
		} else {
			// 동일한 숫자의 개수를 체크하여 판단
			Map<Integer, Long> numCountMap = tempNum.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			if (numCountMap.containsValue(4L)) {
				// 동일한 숫자가 4장인 경우: 포카드
				return "포카드";
			} else if (numCountMap.containsValue(3L) && numCountMap.containsValue(2L)) {
				// 동일한 숫자가 3장과 2장인 경우: 풀하우스
				return "풀하우스";
			} else if (numCountMap.containsValue(3L)) {
				// 동일한 숫자가 3장인 경우: 트리플
				return "트리플";
			} else if (numCountMap.containsValue(2L)) {
				long numOfPairs = numCountMap.values().stream().filter(count -> count == 2L).count();
				if (numOfPairs == 2 || numOfPairs == 3) {
					// 동일한 숫자가 2장인 경우가 2개: 투페어
					return "투페어";
				} else {
					// 동일한 숫자가 2장인 경우가 1개: 원페어
					return "원페어";
				}
			} else {
				// 위의 모든 경우에 해당하지 않는 경우: 하이카드
				return "하이카드";
			}
		}
	}

// 5. 족보의 우열을 판단해 승자를 정하는 메소드

	// 메인 탭에서 족보가 출력되면 그 족보를 받아와서 판별만 해주면 됨.
	// 대신 플레이어의 족보를 받아오는 것과 딜러의 족보를 각각받아와
	// 어떤 게 더 우열이 높은지를 판단해야함.

	public int result(String player_result, String dealer_result) {
		
		int player_point;
		int dealer_point;
		
		if (player_result.equals("로열플래쉬")) {// 플레이어의 패에 따른 포인트 부여
			player_point = 10;
		}else if(player_result.equals("스트레이트 플러쉬")) {
			player_point = 9;
		}else if(player_result.equals("포카드")) {
			player_point = 8;
		}else if(player_result.equals("풀하우스")) {
			player_point = 7;
		}else if(player_result.equals("플러쉬")) {
			player_point = 6;
		}else if(player_result.equals("스트레이트")) {
			player_point = 5;
		}else if(player_result.equals("트리플")) {
			player_point = 4;
		}else if(player_result.equals("투페어")) {
			player_point = 3;
		}else if(player_result.equals("원페어")) {
			player_point = 2;
		}else {
			player_point = 1;
		}
		
		if (dealer_result.equals("로열플래쉬")) {// 딜러의 패에 따른 포인트 부여
			dealer_point = 10;
		}else if(dealer_result.equals("스트레이트 플러쉬")) {
			dealer_point = 9;
		}else if(dealer_result.equals("포카드")) {
			dealer_point = 8;
		}else if(dealer_result.equals("풀하우스")) {
			dealer_point = 7;
		}else if(dealer_result.equals("플러쉬")) {
			dealer_point = 6;
		}else if(dealer_result.equals("스트레이트")) {
			dealer_point = 5;
		}else if(dealer_result.equals("트리플")) {
			dealer_point = 4;
		}else if(dealer_result.equals("투페어")) {
			dealer_point = 3;
		}else if(dealer_result.equals("원페어")) {
			dealer_point = 2;
		}else {
			dealer_point = 1;
		}
		
		// 플레어와 딜러의 우열가리고 출력하기.
		if(player_point > dealer_point) {
			return 1;
		}else if(player_point < dealer_point) {
			return 2;
		}else {
			return 3;
		}
		
	}

}
