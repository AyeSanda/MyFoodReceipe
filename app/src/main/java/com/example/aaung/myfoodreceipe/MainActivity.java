package com.example.aaung.myfoodreceipe;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.aaung.myfoodreceipe.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment homeFragment = HomeFragment.newInstance();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, homeFragment, homeFragment.getClass().getSimpleName()).addToBackStack(null).commit();
                    return true;
                case R.id.navigation_search:
                    return true;
                case R.id.navigation_more:
                    return true;
            }
        return false;
    }
}
