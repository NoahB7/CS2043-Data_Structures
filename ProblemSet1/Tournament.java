import java.io.BufferedReader;
import java.io.FileReader;

public class Tournament {
	
	private UASmashGame[] games;
	int size;
	
	public Tournament() {
		games = new UASmashGame[30];
	}
	
	public Tournament(int a) {
		games = new UASmashGame[a];
	}
	//
	public UASmashGame[] getGames() {
		return games;
	}
	
	public void setGames(UASmashGame[] games) {
		this.games = games;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean loadArray(String a) {
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(a));

			String line = "";
			int count = 0;
		
			while((line = br.readLine())!= null){
			
				String[] x = line.split(",");
			
				UASmashGame y = new UASmashGame(x[0],x[1], Integer.parseInt(x[3]));
				System.out.println(y.getWinnerName() + y.getWinnerCharacter() + y.getGamesPlayed());
				System.out.println(count);
				games[count] = y;
			
				count++;
			}
			br.close();
			
			return true;
			
		
		} catch (Exception e) {
			
			System.out.println("Error");
		}
		
		return false;
	}
	
	public int addGame(UASmashGame x) {
		
		boolean newArray = false;
		int num = 0;
		for(int i = 0; i < games.length; i++) {
			
			if(games[i] == null) {
				games[i] = x;
				num = i;
			} else if(i == games.length-1) {
				newArray = true;
			}
		}
		if(newArray) {
			UASmashGame[] y = new UASmashGame[(int) (games.length * 1.5)];
			for(int i = 0; i < games.length; i++) {
				y[i] = games[i];
				num = i + 1;
			}
			y[num] = x;
		}
		
		return num;
	}

}
