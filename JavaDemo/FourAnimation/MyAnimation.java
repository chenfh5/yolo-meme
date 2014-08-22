package com.example.tesy;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Button b1, b2, b3, b4;

	private ImageView image;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Resources res = getResources();
		// Drawable drawable = res.getDrawable(R.drawable.ic_launcher);
		// this.getWindow().setBackgroundDrawable(drawable);

		image = (ImageView) findViewById(R.id.ImageView01);

		b1 = (Button) findViewById(R.id.Button01);
		b2 = (Button) findViewById(R.id.Button02);
		b3 = (Button) findViewById(R.id.Button03);
		b4 = (Button) findViewById(R.id.Button04);

		b1.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// 创建尺寸变化动画
				Animation scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f,
						Animation.RELATIVE_TO_SELF, 0.5f,
						Animation.RELATIVE_TO_SELF, 0.5f);
				// 设置动画持续的时常
				scaleAnimation.setDuration(1000);
				// 开始动画
				image.startAnimation(scaleAnimation);

			}

		});

		b2.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// 创建透明度动画
				Animation alphaAnimation = new AlphaAnimation(1, 0);
				// 设置动画持续的时常
				alphaAnimation.setDuration(1000);

				// 开始动画
				image.startAnimation(alphaAnimation);

				//动画执行完后是否停留在执行完的状态 
				alphaAnimation.setFillAfter(true);

			}

		});
		b3.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// 创建位移动画
				Animation translateAnimation = new TranslateAnimation(10, 100,
						10, 100);
				// 设置动画持续的时常
				translateAnimation.setDuration(1000);
				// 开始动画
				image.startAnimation(translateAnimation);

			}

		});
		b4.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// 创建旋转动画
				Animation rotateAnimation = new RotateAnimation(0f, +360f,
						Animation.RELATIVE_TO_SELF, 0.5f,
						Animation.RELATIVE_TO_SELF, 0.5f);
				// 设置动画持续的时常
				rotateAnimation.setDuration(1000);
				// 开始动画
				image.startAnimation(rotateAnimation);

			}

		});
	}

}
