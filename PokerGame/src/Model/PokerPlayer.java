package Model;

public class PokerPlayer {

	int chip;
	private String name; // 이름은 View에 회원가입 시의 이름이다.
	private String id;
	private String pw;
	private int beting_chip;
	


	public PokerPlayer( String id, String pw, String name, int chip) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.chip = chip;
	}


	public PokerPlayer(int beting_chip) {
		super();
		this.beting_chip = beting_chip;
	}

	public int getBeting_chip() {
		return beting_chip;
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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
