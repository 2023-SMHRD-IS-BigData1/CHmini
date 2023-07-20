package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Method;
import Controller.PokerController;
import Model.Card;
import Model.PokerDAO;
import Model.PokerPlayer;

public class PokerMain {

	private static void printHorizontalCards(ArrayList<Card> cards) {
	    if (cards.isEmpty()) {
	        System.out.println("No cards to display.");
	        return;
	    }

	    int cardHeight = 9; // Height of a card
	    int numOfCards = cards.size();

	    for (int i = 0; i < cardHeight; i++) {
	        for (int j = 0; j < numOfCards; j++) {
	            Card card = cards.get(j);

	            if (card == null) {
	                // If the card is null, print empty spaces of the same width
	                System.out.print("            ");
	            } else {
	                String pattern = card.getPattern();
	                String number = card.getNumber();

	                if (i == 0) {
	                    System.out.print("┌─────────┐ ");
	                } else if (i == 1 || i == 4 || i == 5) {
	                    System.out.print("│         │ ");
	                } else if (i == 2) {
	                    System.out.print("│         │ ");
	                } else if (i == 3) {
	                    System.out.print("│   " + pattern+number + "    │ ");
	                } else if (i == 6) {
	                	System.out.print("└─────────┘ ");
	                }
	            }
	        }
	        // Check if this is the last row of a card, if not, move to the next line
	        if (i != cardHeight - 1) {
	            System.out.println();
	        }
	    }
	}





	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PokerController con = new PokerController();

		Method method = new Method();
		PokerDAO pokerDAO = new PokerDAO();
		int round = 0;
		int playerChip = 100; // 플레이어의 초기 칩
		method.getPlayerChips(playerChip);
		int dealerChip = 10000;
		method.getDealerChips(dealerChip);
		ArrayList<Card> playerHand = new ArrayList<Card>();
		ArrayList<Card> dealerHand = new ArrayList<Card>();

		ArrayList<Card> cards = new ArrayList<Card>();// Card자료형의 Arraylist

		// 덱 제작
		String[] cardPattern = { "♠", "♥", "♦", "♣" };// 4개의 패턴
		String[] cardNumber = new String[13]; // 숫자 13개

		for (int i = 0; i < 13; i++) {
			if (i == 0) {
				cardNumber[i] = "A";
			} else if(i==9) {
				cardNumber[i] = "⑩";
			} else if (i == 10) {
				cardNumber[i] = "J";
			} else if (i == 11) {
				cardNumber[i] = "Q";
			} else if (i == 12) {
				cardNumber[i] = "K";
			} else {
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
		// --------------------------------------------------------------------------------

		while (true) {
			System.out.println("\n\n\n");
			System.out.println("\t███╗   ███╗██╗███╗   ██╗██╗    ██████╗  ██████╗ ██╗  ██╗███████╗██████╗ ");
			System.out.println("\t████╗ ████║██║████╗  ██║██║    ██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝██╔══██╗");
			System.out.println("\t██╔████╔██║██║██╔██╗ ██║██║    ██████╔╝██║   ██║█████╔╝ █████╗  ██████╔╝");
			System.out.println("\t██║╚██╔╝██║██║██║╚██╗██║██║    ██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██╔══██╗");
			System.out.println("\t██║ ╚═╝ ██║██║██║ ╚████║██║    ██║     ╚██████╔╝██║  ██╗███████╗██║  ██║");
			System.out.println("\t╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚═╝    ╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝");
			System.out.println("");
			System.out.print("[1] 로그인 [2] 회원가입 [3]랭킹 [4]종료 >> ");
			int num = sc.nextInt();
			method.handClear();
			playerHand.clear();
			dealerHand.clear();

			if (num == 1) {

				System.out.println("┌─────────Login──────────┐");
				System.out.print(" ID 입력 : ");
				String id = sc.next();
				System.out.print(" PW 입력 : ");
				String pw = sc.next();
				System.out.println("└────────────────────────┘");

				PokerPlayer playerdto = new PokerPlayer(id, pw, null, method.returnPlayerChips());

				PokerController conn = new PokerController();

				String name = conn.select(playerdto);

				//
				while (true) {

					System.out.println("");
					System.out.println("\t██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗██╗");
					System.out.println("\t██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝██║");
					System.out.println("\t██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  ██║");
					System.out.println("\t██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  ╚═╝");
					System.out.println("\t╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗██╗");
					System.out.println("\t ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝");
					System.out.println("");                                                       
					System.out.print("\t[1] 게임시작\t[2] 게임설명\t[3]로그인 화면으로  >>  ");
					int select = sc.nextInt();
					round = 0;

					if (select == 1) {

						while (true) {
							if (method.returnPlayerChips() < 0) {
								break;
							}
							playerHand.addAll(method.dealPlayer5());
							dealerHand.addAll(method.dealDealer5());
							round += 1;
							System.out.println("==============DEALER===============");
							printHorizontalCards(dealerHand);
							System.out.println();
							System.out.println("라운드  :  " + round + "        V                 S       pot : "
									+ method.pot(1) + "                ");
							System.out.println();
							System.out.println("==============PLAYER================");
							System.out.println("시작 시 기본 칩 1장을 배팅합니다");
							if (method.returnPlayerChips() < 0) {
								System.out.println("플레이어 칩이 0장 이하가 되어 패배하였습니다.");
								break;
							}
							System.out.println("남은 칩  :  " + method.returnPlayerChips());
							printHorizontalCards(playerHand);
							System.out.println();
							System.out.print("[1] 배팅 [2] 폴드  >>  ");
							int betnum = sc.nextInt();
							if (betnum == 1) {
								while (true) {

									System.out.print("배팅할 칩 장수를 입력해 주세요  >>  ");
									int bet = sc.nextInt();
									method.pot(bet);
									if (method.returnPlayerChips() < 0) {
										System.out.println("플레이어 칩이 0장 이하가 되어 패배하였습니다.");
										break;
									}
									System.out.println();
									System.out.println("======추가 카드 딜링======");

									playerHand.clear();
									dealerHand.clear();
									playerHand.addAll(method.dealPlayer1());
									dealerHand.addAll(method.dealDealer1());

									System.out.println("==============DEALER===============");
									printHorizontalCards(dealerHand);
									System.out.println();
									System.out.println("라운드  :  " + round + "        V                 S       pot : "
											+ method.pot(0) + "                ");
									System.out.println();
									System.out.println("==============PLAYER================");
									System.out.println();
									System.out.println("남은 칩  :  " + method.returnPlayerChips());
									printHorizontalCards(playerHand);
									System.out.println();
									System.out.print("[1] 배팅 [2] 폴드  >>  ");
									int betnum2 = sc.nextInt();

									if (betnum2 == 1) {

										System.out.print("배팅할 칩 장수를 입력해 주세요  >>  ");
										int bet2 = sc.nextInt();
										method.pot(bet2);
										if (method.returnPlayerChips() < 0) {
											System.out.println("플레이어 칩이 0장 이하가 되어 패배하였습니다.");
											break;
										}
										System.out.println();
										System.out.println("======추가 카드 딜링======");

										playerHand.clear();
										dealerHand.clear();
										playerHand.addAll(method.dealPlayer1());
										dealerHand.addAll(method.dealDealer1());

										System.out.println("==============DEALER===============");
										printHorizontalCards(dealerHand);
										System.out.println();
										System.out
												.println("라운드  :  " + round + "        V                 S       pot : "
														+ method.pot(0) + "                ");
										System.out.println();
										System.out.println("==============PLAYER================");
										System.out.println();
										System.out.println("남은 칩  :  " + method.returnPlayerChips());
										printHorizontalCards(playerHand);
										System.out.println();

										System.out.println("딜러  :  " + method.checkTree(dealerHand));
										System.out.println("플레이어  :  " + method.checkTree(playerHand));

										int result = method.result(method.checkTree(playerHand),
												method.checkTree(dealerHand));

										if (result == 1) {
											System.out.println("플레이어 승리!");
											method.playerWin();
											method.potReset();
											method.handClear();
											playerHand.clear();
											dealerHand.clear();
										} else if (result == 2) {
											System.out.println("플레이어 패배...");
											method.dealerWin();
											method.potReset();
											method.handClear();
											playerHand.clear();
											dealerHand.clear();
										} else {
											System.out.println("무승부");
											System.out.println("pot의 칩은 다음 승부로 이전됩니다.");
											method.handClear();
											playerHand.clear();
											dealerHand.clear();
											if (round == 5) {
												System.out.println("마지막 라운드이므로 pot의 칩은 균등 분배됩니다.");
												playerChip += (method.pot(0) / 2) + (method.pot(0) % 2);
												dealerChip += (method.pot(0) / 2) + (method.pot(0) % 2);
												method.potReset();
												method.handClear();
												playerHand.clear();
												dealerHand.clear();
											}
										}

										break;

									} else if (betnum2 == 2) {
										System.out.println("pot의 칩을 잃으셨습니다....");
										System.out.println("남은 칩  :  " + method.returnPlayerChips());
										method.potReset();
										method.handClear();
										playerHand.clear();
										dealerHand.clear();
										break;
									} else {
										System.out.println("올바른 수를 입력해 주세요");

									}

								}

							} else if (betnum == 2) {
								System.out.println("pot의 칩을 잃으셨습니다....");
								System.out.println("남은 칩  :  " + method.returnPlayerChips());
								method.potReset();
								method.handClear();
								playerHand.clear();
								dealerHand.clear();
							} else {
								System.out.println("올바른 수를 입력해 주세요");
							}

							if (round == 5) {
								System.out.println("랭킹 서버에 점수가 등록됩니다.");
								playerdto = new PokerPlayer(id, pw, null, method.returnPlayerChips());
								pokerDAO.upload(playerdto);
								round = 0;
								method.getPlayerChips(100);
								break;
							}
						}

					} else if (select == 2) {
						System.out.println("=====================MINI POKER 룰 설명========================");
						System.out.println();
						System.out.println("MINI POKER는 간략화된 딜러와의 1대 1 포커 승부입니다!");
						System.out.println("플레이어와 딜러는 처음에 각각 5장의 카드를 받습니다.");
						System.out.println("처음에 판돈으로 칩 한 장을 테이블에 배팅합니다. 테이블에 있는 칩의 합을 pot이라 합니다.");
						System.out.println();
						System.out.println("플레이어는 딜러의 패와 자신의 패를 비교해 칩을 배팅해 주세요!");
						System.out.println("딜러는 당신의 배팅에 반드시 따라 배팅해 줍니다.");
						System.out.println("배팅 후 카드를 한 장씩 더 받게 됩니다.");
						System.out.println();
						System.out.println("그 후에는 다시 배팅 혹은 폴드(포기)를 선택하게 되고 여기서 배팅을 다시 하신다면 족보 비교로 넘어갑니다.");
						System.out.println("딜러와 플레이어의 족보를 비교해 더 강한 족보인 쪽이 pot의 칩을 가져가게 됩니다.");
						System.out.println("이것을 5라운드까지 반복하게 되고 5라운드 종료 시 남아 있는 칩이 랭킹에 등록됩니다.");
						System.out.println();
						System.out.println("************************주의*****************************");
						System.out.println("어떤 이유에서든 소지 칩이 0장 이하가 될 경우 즉시 패배하게 됩니다.");
					} else if (select == 3) {
						System.out.println("게임을 종료합니다.");
						break;
					}

					method.handClear();
					playerHand.clear();
					dealerHand.clear();

				}
				//

			} else if (num == 2) {

				System.out.print("ID >> ");
				String id = sc.next();
				System.out.print("PW >> ");
				String pw = sc.next();
				System.out.print("NAME >> ");
				String name = sc.next();

				PokerPlayer playerdto = new PokerPlayer(id, pw, name, 0);
				method.getInputName(name);
				PokerController conn = new PokerController();

				conn.insert(playerdto);

			} else if (num == 3) {

				con.conranking();

			} else if (num == 4) {
				System.out.println("");
				System.out.println("██████╗ ██╗   ██╗███████╗    ██████╗ ██╗   ██╗███████╗   ");
				System.out.println("██╔══██╗╚██╗ ██╔╝██╔════╝    ██╔══██╗╚██╗ ██╔╝██╔════╝   ");
				System.out.println("██████╔╝ ╚████╔╝ █████╗      ██████╔╝ ╚████╔╝ █████╗     ");
				System.out.println("██╔══██╗  ╚██╔╝  ██╔══╝      ██╔══██╗  ╚██╔╝  ██╔══╝     ");
				System.out.println("██████╔╝   ██║   ███████╗    ██████╔╝   ██║   ███████╗██╗");
				System.out.println("╚═════╝    ╚═╝   ╚══════╝    ╚═════╝    ╚═╝   ╚══════╝╚═╝");
				System.out.println("");                                                         
				break;
			} else {
				System.out.println("다시 입력해주세요");
			}

		}

	}

}
