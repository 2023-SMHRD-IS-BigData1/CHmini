package Model;

public class Card {
	// pattern이라는 카드의 모양
	// number이라는 카드의 숫자
	private String pattern;
	private int number;
	
	// 생성자 메소드
	public Card(String pattern, int number) {
		super();
		this.pattern = pattern;
		this.number = number;
	}
	
	// getter메소드
	public String getPattern() {
		return pattern;
	}
	public int getNumber() {
		return number;
	}

}
