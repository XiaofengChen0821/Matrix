package com.laioffer.matrix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;;

import com.laioffer.martrix.R;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectListener,
        GridFragment.OnItemSelectListener{
    private GridFragment gridFragment;
    private  ListFragment listFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //add list view
        if (getSupportFragmentManager().findFragmentById(R.id.list_container) == null) {
            ListFragment listFragment = new ListFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.list_container, listFragment).commit();
        }

        //add Gridview
        if (getSupportFragmentManager().findFragmentById(R.id.grid_container) == null && isTablet()) {
            GridFragment gridFragment = new GridFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.grid_container, gridFragment).commit();
        }

    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    public void onItemSelected(int position) {
        if (!isTablet()) {
            Fragment fragment = GridFragment.newInstance(position);
            getSupportFragmentManager().beginTransaction().replace(R.id.list_container,
                    fragment).addToBackStack(null).commit();

        } else {
            gridFragment.onItemSelected(position);
        }
    }

    @Override
    public void onCommentSelected(int position) {
        listFragment.onItemSelected(position);
    }

}
