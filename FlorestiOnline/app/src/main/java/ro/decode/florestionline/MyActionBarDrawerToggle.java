package ro.decode.florestionline;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

/**
 * Created by iuragutu on 06/12/15.
 */
public class MyActionBarDrawerToggle extends android.support.v7.app.ActionBarDrawerToggle {

    public MyActionBarDrawerToggle(Activity activity, final DrawerLayout drawerLayout, Toolbar toolbar, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);

        setHomeAsUpIndicator(R.drawable.ic_action_flon_hamburger);
        setDrawerIndicatorEnabled(false);

        setToolbarNavigationClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }
}
