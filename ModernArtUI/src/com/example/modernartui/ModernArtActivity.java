package com.example.modernartui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class ModernArtActivity extends ActionBarActivity implements
		SeekBar.OnSeekBarChangeListener {

	SeekBar mSeekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modern_art);

		mSeekBar = (SeekBar) findViewById(R.id.seekBar);
		mSeekBar.setOnSeekBarChangeListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.modern_art_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.action_settings) {
			openAlert(item);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromTouch) {

		TextView txt1 = (TextView) findViewById(R.id.text1);
		TextView txt2 = (TextView) findViewById(R.id.text2);
		TextView txt3 = (TextView) findViewById(R.id.text3);
		TextView txt4 = (TextView) findViewById(R.id.text4);
		TextView txt5 = (TextView) findViewById(R.id.text5);

		txt1.setBackgroundColor(getResources().getColor(R.color.txtColor1) + progress);
		txt2.setBackgroundColor(getResources().getColor(R.color.txtColor2) + progress);
		txt3.setBackgroundColor(getResources().getColor(R.color.txtColor3) + progress);
		txt4.setBackgroundColor(getResources().getColor(R.color.txtColor4));
		txt5.setBackgroundColor(getResources().getColor(R.color.txtColor5) + progress);
	}

	private void openAlert(MenuItem item) {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				ModernArtActivity.this);

		alertDialogBuilder.setTitle(this.getTitle() + " decision");

		alertDialogBuilder
				.setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicholson. \n\nClick below to learn more!");

		alertDialogBuilder.setNegativeButton("Not Now",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		
		alertDialogBuilder.setPositiveButton("Visit MOMA",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Uri uri = Uri.parse("http://www.moma.org");
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(intent);
					}
				});

		AlertDialog alertDialog = alertDialogBuilder.create();

		alertDialog.show();
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}
}
