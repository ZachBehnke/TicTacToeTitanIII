package game.tictactoetitan;

import java.net.MalformedURLException;

import android.content.Intent;

public class GameController {
	
	MainActivity activity;
	GameActivity game_activity;
	
	public GameController(MainActivity _activity)
	{
		activity = _activity;
		
		Intent myIntent = new Intent(activity, GameActivity.class);
		activity.startActivity(myIntent);
		
		try {
			SocketController socket_controller = new SocketController();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
