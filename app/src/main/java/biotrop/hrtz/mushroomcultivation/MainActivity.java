package biotrop.hrtz.mushroomcultivation;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View alertView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_placeholder, new FragmentF0());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft.commit();

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        if (id == R.id.nav_f0) {
            ft.replace(R.id.fragment_placeholder, new FragmentF0());
        } else if (id == R.id.nav_f1) {
            ft.replace(R.id.fragment_placeholder, new FragmentF1());
        } else if (id == R.id.nav_f2) {
            ft.replace(R.id.fragment_placeholder, new FragmentF2());
        } else if (id == R.id.nav_baglog) {
            ft.replace(R.id.fragment_placeholder, new FragmentBaglog());
        } else if (id == R.id.nav_baglog_treatment) {
            ft.replace(R.id.fragment_placeholder, new FragmentBaglogTreatment());
        } else if (id == R.id.nav_harvest) {
            ft.replace(R.id.fragment_placeholder, new FragmentHarvest());
        }

        ft.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void cvClicked(View v) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_placeholder);
        if (fragment != null && fragment.isVisible()) {
            if (fragment instanceof FragmentF0) {
                ((FragmentF0) fragment).cvClicked(v);
            }
            if (fragment instanceof FragmentF1) {
                ((FragmentF1) fragment).cvClicked(v);
            }
            if (fragment instanceof FragmentF2) {
                ((FragmentF2) fragment).cvClicked(v);
            }
            if (fragment instanceof FragmentBaglog) {
                ((FragmentBaglog) fragment).cvClicked(v);
            }
            if (fragment instanceof FragmentBaglogTreatment) {
                ((FragmentBaglogTreatment) fragment).cvClicked(v);
            }
            if (fragment instanceof FragmentHarvest) {
                ((FragmentHarvest) fragment).cvClicked(v);
            }
        }
    }

    public void galleryClicked(View v) {
        //TODO gallery optimalization
        dialog = new AlertDialog.Builder(this);
        inflater = ((Activity) this).getLayoutInflater();
        alertView = inflater.inflate(R.layout.dialog_image_gallery, null);
        dialog.setView(alertView);

        final AlertDialog alertDialog = dialog.show();

        ImageView iv = (ImageView) alertDialog.findViewById(R.id.iv_dialog_gallery);
        ImageView clicked = (ImageView) v;

        iv.setImageDrawable(((ImageView) v).getDrawable());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}
