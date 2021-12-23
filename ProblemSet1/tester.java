
public class tester {
	
	public static void main(String[] args) {
		
		Tournament a = new Tournament();
		a.loadArray("stuff");
		
		UASmashGame[] x = a.getGames();
		
		//System.out.println(x[0].getGamesPlayed());
		//System.out.println(x[1].getGamesPlayed());
	}
}
