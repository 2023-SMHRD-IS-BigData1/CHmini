package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Method;
import Controller.PokerController;
import Model.Card;
import Model.PokerPlayer;

public class PokerMain {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PokerController con = new PokerController();
		PokerPlayer pokerPlayer = new PokerPlayer(null, null, null);
		Method method = new Method();
		int playerChip = 50;
		method.getPlayerChips(playerChip);
		int dealerChip = 10000;
		method.getDealerChips(dealerChip);
		ArrayList<Card> playerHand = new ArrayList<Card>();
		ArrayList<Card> dealerHand = new ArrayList<Card>();
		
		ArrayList<Card> cards = new ArrayList<Card>();//Card자료형의 Arraylist
		
		//덱 제작
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
		//--------------------------------------------------------------------------------

		while(true) {
			
			System.out.print("[1] 로그인 [2] 회원가입 [3]랭킹 [4]종료 >> ");
			int num = sc.nextInt();
			
			if(num == 1) {

				System.out.println("====로그인====");
				System.out.print("ID >> ");
				String id = sc.next();
				System.out.print("PW >> ");
				String pw = sc.next();

				PokerPlayer playerdto = new PokerPlayer(id, pw, null, 0);

				PokerController conn = new PokerController();

				String name = conn.select(playerdto);

				//
				while (true) {

					System.out.println("============MINI POKER============");
					System.out.print("[1] 시작 [2] 설명 [3]로그인 화면으로  >>  ");
					int select = sc.nextInt();
					int round = 1;
					
					if (select == 1) {
					
						playerHand.addAll(method.dealPlayer5());
						dealerHand.addAll(method.dealDealer5());
						
						
						while (true) {
							for (int i = 0; i < dealerHand.size(); i++) {
								System.out.print(dealerHand.get(i).getPattern() + dealerHand.get(i).getNumber() + "  ");
							}
							System.out.println();
							System.out.println("==============DEALER===============");
							System.out.println();
							System.out.println("라운드  :  " + round + "        V                 S       pot : " + method.pot(1) + "                ");
							System.out.println();
							System.out.println("==============PLAYER================");
							System.out.println();
							System.out.println("남은 칩  :  " + method.returnPlayerChips());
							for (int i = 0; i < playerHand.size(); i++) {
								System.out.print(playerHand.get(i).getPattern() + playerHand.get(i).getNumber() + "  ");
							}
							System.out.println();
							System.out.print("[1] 배팅 [2] 폴드  >>  ");
							int betnum = sc.nextInt();
							if (betnum == 1) {
								while (true) {
									
									System.out.print("배팅할 칩 장수를 입력해 주세요  >>  ");
									int bet = sc.nextInt();
									method.pot(bet);
									System.out.println();
									System.out.println("======추가 카드 딜링======");
									
									playerHand.clear();
									dealerHand.clear();
									playerHand.addAll(method.dealPlayer1());
									dealerHand.addAll(method.dealDealer1());
									
									for (int i = 0; i < dealerHand.size(); i++) {
										System.out.print(dealerHand.get(i).getPattern() + dealerHand.get(i).getNumber() + "  ");
									}
									System.out.println();
									System.out.println("==============DEALER===============");
									System.out.println();
									System.out.println("라운드  :  " + round + "        V                 S       pot : " + method.pot(0) + "                ");
									System.out.println();
									System.out.println("==============PLAYER================");
									System.out.println();
									System.out.println("남은 칩  :  " + method.returnPlayerChips());
									for (int i = 0; i < playerHand.size(); i++) {
										System.out.print(playerHand.get(i).getPattern() + playerHand.get(i).getNumber() + "  ");
									}
									System.out.println();
									System.out.print("[1] 배팅 [2] 폴드  >>  ");
									int betnum2 = sc.nextInt();
									
									if (betnum2 == 1) {
										
										System.out.print("배팅할 칩 장수를 입력해 주세요  >>  ");
										int bet2 = sc.nextInt();
										method.pot(bet2);
										System.out.println();
										System.out.println("======추가 카드 딜링======");
										
										playerHand.clear();
										dealerHand.clear();
										playerHand.addAll(method.dealPlayer1());
										dealerHand.addAll(method.dealDealer1());
										
										for (int i = 0; i < dealerHand.size(); i++) {
											System.out.print(dealerHand.get(i).getPattern() + dealerHand.get(i).getNumber() + "  ");
										}
										System.out.println();
										System.out.println("==============DEALER===============");
										System.out.println();
										System.out.println("라운드  :  " + round + "        V                 S       pot : " + method.pot(0) + "                ");
										System.out.println();
										System.out.println("==============PLAYER================");
										System.out.println();
										System.out.println("남은 칩  :  " + method.returnPlayerChips());
										for (int i = 0; i < playerHand.size(); i++) {
											System.out.print(playerHand.get(i).getPattern() + playerHand.get(i).getNumber() + "  ");
										}
										System.out.println();
										
										System.out.println("딜러  :  " + method.checkTree(dealerHand));
										System.out.println("플레이어  :  " + method.checkTree(playerHand));
										
										int result = method.result(method.checkTree(playerHand), method.checkTree(dealerHand));

										if (result == 1) {
											System.out.println("플레이어 승리!");
											playerChip += method.pot(0);
											method.potReset();
										}else if (result == 2) {
											System.out.println("플레이어 패배...");
											dealerChip += method.pot(0);
											method.potReset();
										}else {
											System.out.println("무승부");
											System.out.println("pot의 칩은 다음 승부로 이전됩니다.");
											if (round == 5) {
												System.out.println("마지막 라운드이므로 pot의 칩은 균등 분배됩니다.");
												playerChip += (method.pot(0) / 2) + (method.pot(0) % 2);
												dealerChip += (method.pot(0) / 2) + (method.pot(0) % 2);
											}
										}
										
										playerHand.clear();
										dealerHand.clear();
										
										
										break;
										
									}else if (betnum == 2) {
										System.out.println("pot의 칩을 잃으셨습니다....");
										System.out.println("남은 칩  :  " + method.returnPlayerChips());
									}else {
										System.out.println("올바른 수를 입력해 주세요");
									}
								}

								
							}else if (betnum == 2) {
								System.out.println("pot의 칩을 잃으셨습니다....");
								System.out.println("남은 칩  :  " + method.returnPlayerChips());
							}else {
								System.out.println("올바른 수를 입력해 주세요");
							}
							break;
							
						}
						
						
					}else if (select == 2) {
						System.out.println("설명");
					}else if (select == 3) {
						break;
					}
					
					if (round == 5) {
						System.out.println("랭킹 서버에 점수가 등록됩니다.");
						
					}
					
				}
				//

			}else if (num == 2) {
				
				System.out.print("ID >> ");
				String id = sc.next();
				System.out.print("PW >> ");
				String pw = sc.next();
				System.out.print("NAME >> ");
				String name = sc.next();

				PokerPlayer playerdto = new PokerPlayer(id, pw, name,0);
				method.getInputName(name);
				PokerController conn = new PokerController();

				conn.insert(playerdto);
				
			}else if (num == 3) {
				
				con.conranking();
				
				
			}else if(num == 4) {
				System.out.println("종료");
				break;
			}else {
				System.out.println("다시입력해주세요");
			}
		
			
			
			
			
			
			
		}
		
	}
	

}
