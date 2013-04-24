package game.tictactoetitan;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class TicTacButton extends ImageButton {
	
	enum State {cross, circle}

	GameActivity activity;
	private int _x,_y;
	private boolean is_assigned = false;
	
	public TicTacButton(Context context) {
		super(context);
		initialize();
	}
	
	public TicTacButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	public TicTacButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}	
	
	public void initialize()
	{
		setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (!is_assigned && activity.game_in_progress) setBackgroundResource(R.drawable.btn_pressed);
				return false;
			}
		});
		
		setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (!is_assigned && activity.game_in_progress) { change_state(); is_assigned = true; }
			}
		});
	}
	
	public void change_state()
	{
		if (activity.state == State.circle) setBackgroundResource(R.drawable.btn_circle);
		if (activity.state == State.cross) setBackgroundResource(R.drawable.btn_cross);
		
		activity.change_state(_x,_y);
	}
	
	public void reset()
	{
		setBackgroundResource(R.drawable.btn);
		is_assigned = false;
	}
	
	public void set_x(int x) {_x=x;}
	public void set_y(int y) {_y=y;}
	public int get_x() {return _x;}
	public int get_y() {return _y;}
}
