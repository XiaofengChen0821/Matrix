package com.laioffer.matrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.laioffer.martrix.R;

public class EventGridActivity extends AppCompatActivity {

    int pos = 0;
    GridFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_grid);

        Intent intent = getIntent();
        pos = intent.getIntExtra("position", 0);
        fragment = new GridFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.grid_container, fragment).commit();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        fragment.onItemSelected(pos);
    }

}
