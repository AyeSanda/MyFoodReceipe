package com.example.aaung.myfoodreceipe;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.aaung.myfoodreceipe.fragment.HomeFragment;

public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView navigation;
    FrameLayout containerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPageLayout();
        setPageView();

        loadFragment(HomeFragment.newInstance());
    }

    private void setPageView(){
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        containerLayout = (FrameLayout)findViewById(R.id.container_layout);
    }

    protected void setPageLayout() {
        setContentView(R.layout.activity_main);
    }

    protected void initNavigationListener(){
        navigation.setOnNavigationItemSelectedListener(this);
    }

    /**
     * To get the content of the page to be displayed
     * @return layout's id.
     */
    protected abstract int getContentPageLayoutId();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = HomeFragment.newInstance();
                    break;
                case R.id.navigation_search:
                    break;
                case R.id.navigation_more:
                    break;
            }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
