
public class UASmashGame {
	
	private String winnerName;
	private String winnerCharacter;
	private int gamesPlayed;
	
	public UASmashGame() {
		
	}
	
	public UASmashGame(String a, String b, int c) {
		
		this.winnerName = a;
		this.winnerCharacter = b;
		this.gamesPlayed = c;
	}
	
	
	public String getWinnerName() {
		return winnerName;
	}
	
	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}
	
	public String getWinnerCharacter() {
		return winnerCharacter;
	}
	
	public void setWinnerCharacter(String winnerCharacter) {
		this.winnerCharacter = winnerCharacter;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	

}
