package com.example.pinball2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {

	// screen
	private int tableWidht, tableHeight;
	// racket
	private int racketX, racketY, racketWidht, racketHeight;
	// ball
	private int[] ballX =null;
	private int[] ballY =null;
	private int ballSize,xSpeed, ySpeed;
	private int ballX0 = 0, ballY0 = 0;
	// some flag
	private boolean isLost = false;
	private int falseNum = 3;
	private boolean beginFlag = false;
	private Vibrator vibrator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// open Vibrator
		vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		// full screen show
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// get GameView
		final GameView gameView = new GameView(this);
		setContentView(gameView);
		// get screen size
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		tableWidht = dm.widthPixels;
		tableHeight = dm.heightPixels;
		// set racket size
		Random randn = new Random(System.currentTimeMillis());
		racketX = randn.nextInt((int) (tableWidht * 0.5));
		racketY = (int) (tableHeight * 0.98);
		racketWidht = (int) (tableWidht * 0.18);// /
		racketHeight = (int) (tableHeight * 0.8);
		// set ball size
		ballX0 = randn.nextInt((int) (tableWidht * 0.5));
		ballY0 = randn.nextInt(randn.nextInt(20));
		
		ballX[1] = randn.nextInt((int) (tableWidht * 0.5));
		ballY[1] = randn.nextInt(randn.nextInt(20));
		
		ballX[2] = (int) (ballX[1] * (randn.nextFloat() - 0.5) * 2);
		ballY[2] = randn.nextInt(randn.nextInt(20));
		
		ballX[3] = (int) (ballX[1] * (randn.nextFloat() - 0.5) * 2);
		ballY[3] = randn.nextInt(randn.nextInt(20));
		
		ballSize = (int) (racketWidht / 3.0);
		ySpeed = (int) (tableHeight * 0.04);
		xSpeed = (int) (ySpeed * (randn.nextFloat() - 0.5) * 2);
		// handle
		final Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				if (msg.what == 1) {
					gameView.invalidate();
				}
				if (msg.what == 2)
					Toast.makeText(MainActivity.this, String.valueOf(falseNum),
							Toast.LENGTH_SHORT).show();
			}
		};
		// gameView listener
		gameView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (beginFlag) {
					if (event.getX() > tableWidht - racketWidht) {
						racketX = tableWidht - racketWidht;
					} else
						racketX = (int) event.getX();
					gameView.invalidate();

				} else {
					beginFlag = true;
					final Timer timer = new Timer();
					timer.schedule(new TimerTask() {

						@Override
						public void run() {
								// over left and right
								if (ballX0 <= 0 + ballSize
										|| ballX0 >= tableWidht - ballSize) {
									xSpeed = -xSpeed;
								}
								// touch the racket
								if (ballY0 <= 0
										|| (ballY0 >= racketY - ballSize * 2
												&& ballX0 >= racketX && ballX0 <= racketX
												+ racketWidht)) {
									ySpeed = -ySpeed;

								}
								// touch the bottom
								else if (ballY0 >= racketY - ballSize * 2
										&& (ballX0 < racketX || ballX0 > racketX
												+ racketWidht)) {
									ySpeed = -ySpeed;
									vibrator.vibrate(new long[] { 100, 400,
											100, 400 }, -1);
									falseNum--;
									handler.sendEmptyMessage(2);
									if (falseNum == 0) {
										timer.cancel();
										vibrator.cancel();
										isLost = true;
									}
								}
								// all refresh
								ballY0 += ySpeed;
								ballX0 += xSpeed;
//								ballY0 = ballY0;
//								ballX0 = ballX0;
								handler.sendEmptyMessage(1);
							}

					}, 0, 100);
				}
				return true;
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class GameView extends View {

		public GameView(Context context) {
			super(context);
		}

		Paint paint = new Paint();

		public void onDraw(Canvas canvas) {
			paint.setStyle(Paint.Style.FILL);
			// anti-alias
			paint.setAntiAlias(true);
			// if game is over
			if (isLost) {
				paint.setColor(Color.RED);
				canvas.drawText("gameover", tableWidht / 3, tableHeight / 2,
						paint);
			} else {
				// ball
				paint.setColor(Color.rgb(240, 240, 10));
				canvas.drawCircle(ballX0, ballY0, ballSize, paint);
				// racket
				paint.setColor(Color.rgb(10, 10, 240));
				canvas.drawRect(racketX, racketY, racketX + racketWidht,
						racketY + racketHeight, paint);

			}

		}

	}
}
