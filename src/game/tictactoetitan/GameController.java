package game.tictactoetitan;

import android.content.Intent;

public class GameController
{

	MainActivity activity;
	GameActivity game_activity;

	public GameController(MainActivity _activity)
	{
		activity = _activity;

		Intent myIntent = new Intent(activity, GameActivity.class);
		activity.startActivity(myIntent);
	}
}
