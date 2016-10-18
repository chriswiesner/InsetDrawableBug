package com.example.insetdrawablebug;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	private int iconSizePixel;
	private int iconInsetPixel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageView imageView = (ImageView) findViewById(R.id.imageview);

		iconSizePixel = getResources().getDimensionPixelSize(R.dimen.icon_size);
		iconInsetPixel = getResources().getDimensionPixelSize(R.dimen.icon_inset);

		Drawable dr = ContextCompat.getDrawable(this, R.drawable.ic_brightness);
		Bitmap bitmap = ((BitmapDrawable) dr).getBitmap();
		dr = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, iconSizePixel, iconSizePixel, true));

		InsetDrawable customIcon = new InsetDrawable(dr, iconInsetPixel, 0, iconInsetPixel, 0);

		imageView.setImageDrawable(customIcon);
	}
}
