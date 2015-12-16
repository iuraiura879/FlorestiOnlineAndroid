package ro.decode.florestionline;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        //implements NavigationView.OnNavigationItemSelectedListener {
{
        public static int state;
        // 1- Main
        // 2 - Lista de raporturi
        // 3 - Raport Totul
        // 4 - Raporteaza nou
        // 5 - Lista noutati
        // 6 - Noutate
        // 7 - service List
        // 8 - service Detail

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);

        Toolbar toolbarTop = (Toolbar) findViewById(R.id.toolbar);
        setTitle("");

        TextView mTitle = (TextView) toolbarTop.findViewById(R.id.toolbar_title);
        mTitle.setText(this.getString(R.string.main_name));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(view, "Raporteaza un incident nou", Snackbar.LENGTH_LONG)
                        .setAction("AICI", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openNewReport(null);
                            }
                        });

                snackbar.show();
            }
        });

        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        MyActionBarDrawerToggle toggle = new MyActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);


        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        */



        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new MainFragment()).commit();

        state = 1;



    }




    public void openAllReports(View v){

        if( state == 2 )
            return;

        state = 2;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ReportListFragment()).addToBackStack("").commit();

    }

    public void openReportDetail(){

        if( state == 3 )
            return;

        state = 3;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FullReportFragment()).addToBackStack("").commit();

    }


    public void openNewReport(View v){

        if( state == 4 )
            return;

        state = 4;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new AddAReportFragment()).addToBackStack("").commit();

    }


    public void openAllNews(View v){


        if( state == 5 )
            return;

        state = 5;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new NewsListFragment()).addToBackStack("").commit();

    }


    public void openNewsDetail(){

        if( state == 6 )
            return;

        state = 6;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FullNewsArticleFragment()).addToBackStack("").commit();

    }


    public void openAllService(View v){


        if( state == 7 )
            return;

        state = 7;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ServiceListFragment()).addToBackStack("").commit();

    }


    public void openServiceDetail(){

        if( state == 8 )
            return;

        state = 8;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FullServiceFragment()).addToBackStack("").commit();

    }


    public void simulateBack(View v){
        onBackPressed();
    }

    public void callMe(View v){

        String uri = "tel:" + ((Button)v).getText() ;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);

    }

    public void goHome(View v){

        if( state == 1 )
            return;

        state = 1;
        getSupportFragmentManager().popBackStack("", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainFragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    /*
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/



}

