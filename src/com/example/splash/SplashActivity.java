package com.example.splash;

import com.example.activity.MainActivity;
import com.example.application.ConstellationApplication;
import com.example.constellation.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	public static final String TAG = SplashActivity.class.getSimpleName();

	private ImageView mSplashItem_iv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		DisplayMetrics metrics = new DisplayMetrics(); // 利用DisplayMetrics获取屏幕信息
		getWindowManager().getDefaultDisplay().getMetrics(metrics);// 取得DisplayMetrics对象方法二
		Constants.SCREEN_DENSITY = metrics.density;
		Constants.SCREEN_HEIGHT = metrics.heightPixels;
		Constants.SCREEN_WIDTH = metrics.widthPixels;
		findViewById();
		initView();
	}

	protected void findViewById() {
		mSplashItem_iv = (ImageView) findViewById(R.id.splash_loading_item);
	}

	protected void initView() {
		Animation translate = AnimationUtils.loadAnimation(this, R.anim.splash_loading);
		translate.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {

				Intent intent = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
				SplashActivity.this.finish();
			}
		});
		mSplashItem_iv.setAnimation(translate);
	}

}
