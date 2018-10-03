package com.sample.activitylifecycledemo;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationDrawerCallbacks {

    public Toolbar mToolbar;
    public NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_topdrawer);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer);
        mNavigationDrawerFragment.setup(R.id.fragment_drawer, (DrawerLayout) findViewById(R.id.drawer), mToolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, MainLayout.newInstance(),
                        MainLayout.TAG).commit();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, MainLayout.newInstance(),
                                MainLayout.TAG).commit();
                break;

            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, MyProfile.newInstance(),
                                MyProfile.TAG).commit();

                break;

            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, PreviousRequest.newInstance(),
                                PreviousRequest.TAG).commit();
                break;

            case 3:

                break;

            case 4:

                break;

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawerFragment.isDrawerOpen())
            mNavigationDrawerFragment.closeDrawer();
        else
            super.onBackPressed();
    }
}
