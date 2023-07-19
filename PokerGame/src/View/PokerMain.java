package View;

import java.util.Scanner;

import Controller.Method;
import Controller.PokerController;
import Model.PokerPlayer;

public class PokerMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PokerController con = new PokerController();
		Method method = new Method();
		
	
		
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

				//로고
				
				while (true) {
					System.out.println("============MINI POKER============");
					System.out.print("[1] 시작 [2] 설명 [3]로그인 화면으로");
					int select = sc.nextInt();
					
					if (select == 1) {
						
					}else if (select == 2) {
						System.out.println("설명");
					}else if (select == 3) {
						break;
					}
					
					
					
				}

				
				

				
				
				
				
				
				
				

				//


			}else if (num == 2) {
				
				System.out.print("ID >> ");
				String id = sc.next();
				
				if(id.equals(id)) {
					System.out.println("아이디 중복! 다시 입력해주세요");
					System.out.print("ID >> ");
					id = sc.next();
				}
				
				System.out.print("PW >> ");
				String pw = sc.next();
				
				System.out.print("NAME >> ");
				String name = sc.next();
				
				if(name.equals(name)) {
					System.out.println("닉네임 중복! 다시 입력해주세요");
					System.out.print("NAME >> ");
					name = sc.next();
				}

				PokerPlayer playerdto = new PokerPlayer(id, pw, name,0);

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
