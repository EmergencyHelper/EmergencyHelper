package com.example.emergencyhelper;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String packageName = this.getClass().getPackage().getName();
        final Context context = this;

        // ScrollView
        ViewGroup contentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.activity_menu, null);

        // Layout containing Buttons
        ViewGroup g = (ViewGroup) contentView.getChildAt(0);
        int count = g.getChildCount();

        for (int i = 0; i < count; i++) {
            Button btn = (Button) g.getChildAt(i);
            final String text = btn.getText().toString();
            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Class c = Class.forName(packageName + "." + text);
                        startActivity(new Intent(context, c));
                    } catch (ClassNotFoundException e) {
                        Toast.makeText(context, String.valueOf(e), 5000).show();
                    }
                }
            });
        }

        setContentView(contentView);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	
}
