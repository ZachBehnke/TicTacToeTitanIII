package game.tictactoetitan;

import game.tictactoetitan.LoginDialogFragment.LoginDialogListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends FragmentActivity implements LoginDialogListener {
	
	GameController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		DialogFragment dialog = new LoginDialogFragment();
        dialog.show(getSupportFragmentManager(), "Login");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		controller = new GameController(this);
	}
}
