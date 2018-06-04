package alifianadexe.unomi.baseactivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import alifianadexe.unomi.R;

/**
 * Created by adexe on 5/31/18.
 */

public abstract class AppBaseActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

    private FrameLayout frameLayout;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Menu menu;

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        super.setContentView(R.layout.app_base_layout);

        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0,0);
        drawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        menu = navigationView.getMenu();
        for(int i = 0 ; i < menu.size();i++){
            menu.getItem(i).setOnMenuItemClickListener(this);
        }
    }



    @Override
    protected  void onPostCreate(Bundle savedInstance){
        super.onPostCreate(savedInstance);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration config){
        super.onConfigurationChanged(config);
        mDrawerToggle.onConfigurationChanged(config);
    }


    @Override
    public void setContentView(int resLayoutId){
        if(frameLayout  != null){
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            View stubView = inflater.inflate(resLayoutId, frameLayout, false);
            frameLayout.addView(stubView, layoutParams);
        }
    }

    @Override
    public void setContentView(View view){
        if(frameLayout != null){
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            frameLayout.addView(view, layoutParams);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        if(mDrawerToggle.onOptionsItemSelected(menu)){
            return true;
        }
        return super.onOptionsItemSelected(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.unomi:
                Snackbar.make(drawerLayout, "uNomi is Here!",Snackbar.LENGTH_SHORT).show();
                break;
        }
        return false;
    }




}
