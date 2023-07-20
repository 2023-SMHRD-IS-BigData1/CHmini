package Model;

public class MP3 {

		private String title;
		private int playTime;
		private String path;
		
		
		// 생성자 메소드
		
		public MP3(String title, int playTime, String path) {
			super();

			this.title = title;
			this.playTime = playTime;
			this.path = path;
		}

		// getter 메소드
		

		public String getTitle() {
			return title;
		}
		
		public int getPlayTime() {
			return playTime;
		}
		
		public String getpath() {
			return path;
		}
		
		
	}