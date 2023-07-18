package Controller;

import Model.PokerDAO;
import Model.PokerPlayer;

public class PokerController {
	PokerDAO dao = new PokerDAO();
	int cnt = 0;	
	
	public void insert(PokerPlayer playerdto) {

		cnt = dao.insert(playerdto);

		if (cnt > 0) {
			System.out.println("회원가입이 완료되었습니다!");
		} else {
			System.out.println("회원가입에 실패했습니다. 다시 시도하세요.");
		}
	}
}
