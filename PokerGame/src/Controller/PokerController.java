package Controller;

import java.util.ArrayList;

import Model.PokerDAO;
import Model.PokerPlayer;

public class PokerController {
	
	PokerDAO dao = new PokerDAO();
	
	int cnt = 0;	
	
	// 로그인	
		public String select(PokerPlayer playerdto) {
			
			String data = dao.select(playerdto);
			
			if (data.equals("")) {
				System.out.println("아이디와 비밀번호가 일치하지 않습니다");
				System.exit(1);
			} else {
				System.out.println("로그인 성공!");
				
				System.out.println( data + "님 환영합니다!");
				
			}
			return data;
		}
		
	// 회원가입	
	public void insert(PokerPlayer playerdto) {

		cnt = dao.insert(playerdto);

		if (cnt > 0) {
			System.out.println("회원가입이 완료되었습니다!");
		} else {
			System.out.println("회원가입에 실패했습니다. 다시 시도하세요.");
		}
	}
	
	// 포커 조회하기 - 박수완
	
	public void conranking() {

		   ArrayList<PokerPlayer> list = dao.ranking();

		   		for(int i = 0 ; i < list.size(); i++) {
					String id = list.get(i).getId();
					String name = list.get(i).getName();
					int chip = list.get(i).getChip();
					
					System.out.println(i+1+"등 ID : " + id + " 닉네임 : " + name + " 보유 칩 : " + chip);
				
			
					
					
		   		}



	}
}
