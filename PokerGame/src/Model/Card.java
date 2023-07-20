package Model;

public class Card {
	// pattern이라는 카드의 모양
	// number이라는 카드의 숫자
	private String pattern;
	private String number;
	
	// 생성자 메소드
	public Card(String pattern, String cardNumber) {
		super();
		this.pattern = pattern;
		this.number = cardNumber;
	}
	
	// getter메소드
	public String getPattern() {
		return pattern;
	}
	public String getNumber() {
		return number;
	}
	
}
