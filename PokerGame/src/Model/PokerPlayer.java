package Model;

public class PokerPlayer {

	int chip;
	String name; // 이름은 View에 회원가입 시의 이름이다.
	
	
	public PokerPlayer(int chip, String name) {
		super();
		this.chip = chip;
		this.name = name;
	}


	public int getChip() {
		return chip;
	}


	public void setChip(int chip) {
		this.chip = chip;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
