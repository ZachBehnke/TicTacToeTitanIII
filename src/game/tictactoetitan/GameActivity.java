package game.tictactoetitan;

import game.tictactoetitan.TicTacButton.State;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class GameActivity extends FragmentActivity {
	
	public State state;
	int total_moves = 0;
	State[][] tictac;
	boolean game_in_progress = true;
	TicTacButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	Button btnReset;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_game);
		
		initialize();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void initialize()
	{
		tictac = new State[3][3];
		state = State.circle;
		
		btn1 = (TicTacButton) findViewById(R.id.TicTacButton01); btn1.set_x(0); btn1.set_y(0); btn1.activity = this;
		btn2 = (TicTacButton) findViewById(R.id.TicTacButton02); btn2.set_x(0); btn2.set_y(1); btn2.activity = this;
		btn3 = (TicTacButton) findViewById(R.id.TicTacButton03); btn3.set_x(0); btn3.set_y(2); btn3.activity = this;
		btn4 = (TicTacButton) findViewById(R.id.TicTacButton06); btn4.set_x(1); btn4.set_y(0); btn4.activity = this;
		btn5 = (TicTacButton) findViewById(R.id.TicTacButton05); btn5.set_x(1); btn5.set_y(1); btn5.activity = this;
		btn6 = (TicTacButton) findViewById(R.id.TicTacButton04); btn6.set_x(1); btn6.set_y(2); btn6.activity = this;
		btn7 = (TicTacButton) findViewById(R.id.TicTacButton09); btn7.set_x(2); btn7.set_y(0); btn7.activity = this;
		btn8 = (TicTacButton) findViewById(R.id.TicTacButton08); btn8.set_x(2); btn8.set_y(1); btn8.activity = this;
		btn9 = (TicTacButton) findViewById(R.id.TicTacButton07); btn9.set_x(2); btn9.set_y(2); btn9.activity = this;
		
		btnReset = (Button) findViewById(R.id.button1);
		btnReset.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				btn1.reset();
				btn2.reset();
				btn3.reset();
				btn4.reset();
				btn5.reset();
				btn6.reset();
				btn7.reset();
				btn8.reset();
				btn9.reset();
				tictac = new State[3][3];
				game_in_progress = true;
				total_moves = 0;
			}
		});
	}

	public void change_state(int x, int y) {
		total_moves++;
		tictac[x][y] = state;
		if (game_is_over() || total_moves == 9)
		{
			game_in_progress = false;
			if (total_moves == 9 && !game_is_over()) toast("Draw!");
			else toast(state.toString() + " wins!");
		}
		state = (state == State.circle) ? State.cross : State.circle;
	}
	
	public boolean game_is_over()
	{
		int d_ctr=0, d2_ctr=0;
		for (int i=0; i<3; i++)
		{
			if (tictac[i][i] == state) d_ctr++;
			if (tictac[2-i][i] == state) d2_ctr++;
			if (d_ctr==3 || d2_ctr==3) return true;
			for (int j=0; j<3; j++)
			{
				if (tictac[i][j] != state) continue;
				int c_ctr = 0, r_ctr=0;
				for(int k=0; k<3; k++)
				{
					if (tictac[k][j] == state) c_ctr++;
					if (tictac[i][k] == state) r_ctr++;
				}
				
				if (r_ctr == 3 || c_ctr == 3) return true;
			}
		}
		return false;
	}
	
	public void toast(String message){
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
	}
}
