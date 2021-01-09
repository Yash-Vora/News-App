package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.newsapp.Fragments.FoxNewsFragment;
import com.example.newsapp.Fragments.SkyNewsFragment;
import com.example.newsapp.Fragments.bbcFragment;
import com.example.newsapp.Fragments.cnnFragment;
import com.example.newsapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Binding is used instead of findViewById
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Custom Toolbar
        Toolbar customToolbar = binding.mainCustomToolbar.customToolbar;
        // OR
        // Toolbar customToolbar = findViewById(R.id.mainCustomToolbar);
        setSupportActionBar(customToolbar);
        // OR
        // setSupportActionBar(binding.mainCustomToolbar.customToolbar);


        // Setting title of custom toolbar
        getSupportActionBar().setTitle("News App");



        /*     Navigation Drawer Menu     */



        // Adding toggle button to the left side of toolbar which will open and close custom navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, customToolbar, R.string.open_nav_drawer, R.string.close_nav_drawer);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // By default bbcFragment is loaded in the MainActivity
        bbcFragment bbcFragment = new bbcFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentLinearLayout, bbcFragment);
        transaction.commit();


        // This function is used to show what will happen after selecting any item from navigation drawer
        binding.navDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()) {

                    case R.id.bbc:
                        bbcFragment bbcFragment = new bbcFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragmentLinearLayout, bbcFragment);
                        transaction.commit();
                        // Closing navigation drawer
                        binding.drawerLayout.closeDrawers();
                        break;

                    case R.id.cnn:
                        cnnFragment cnnFragment = new cnnFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragmentLinearLayout, cnnFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        // Closing navigation drawer
                        binding.drawerLayout.closeDrawers();
                        break;

                    case R.id.foxNews:
                        FoxNewsFragment foxNewsFragment = new FoxNewsFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragmentLinearLayout, foxNewsFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        // Closing navigation drawer
                        binding.drawerLayout.closeDrawers();
                        break;

                    case R.id.skyNews:
                        SkyNewsFragment skyNewsFragment = new SkyNewsFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragmentLinearLayout, skyNewsFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        // Closing navigation drawer
                        binding.drawerLayout.closeDrawers();
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();

                }
                return true;

            }
        });

    }


    // This method is called when we press back button in our mobile from main activity page
    @Override
    public void onBackPressed() {

        // Here we are closing the drawer if drawer is open when we press back button in our mobile
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawers();

        else
            super.onBackPressed();

    }

}
