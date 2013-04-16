package com.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class AcercaDe extends Activity {
	private MediaPlayer mp;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acercade);
		mp = MediaPlayer.create(this, R.raw.audio);
	}
	
	@Override protected void onDestroy() {
		   super.onDestroy();
		   mp.pause();
		}

}
