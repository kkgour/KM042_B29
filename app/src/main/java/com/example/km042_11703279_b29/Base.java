package com.example.km042_11703279_b29;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Base extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        BottomNavigationView botnav=findViewById(R.id.BottomNavigation);
        botnav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.dynamicFragmentContainer,new fragmentHome()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment=null;
                    switch(menuItem.getItemId()){
                        case R.id.home:
                            selectedFragment=new fragmentHome();
                            break;
                        case R.id.favorite:
                            selectedFragment=new fragmentFavorite();
                            break;
                        case R.id.search:
                            selectedFragment=new fragmentSearch();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.dynamicFragmentContainer,selectedFragment).commit();
                    return true;
                }
            };
}
