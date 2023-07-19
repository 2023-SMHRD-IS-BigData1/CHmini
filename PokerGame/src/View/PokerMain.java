package View;

import java.util.Scanner;

import Controller.PokerController;
import Model.PokerPlayer;

public class PokerMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PokerController con = new PokerController();
		
		
		
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

				//

				break;
			}else if (num == 2) {
				
				System.out.print("ID >> ");
				String id = sc.next();
				System.out.print("PW >> ");
				String pw = sc.next();
				System.out.print("NAME >> ");
				String name = sc.next();

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
