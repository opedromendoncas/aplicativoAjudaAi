package br.com.etecia.ajudaai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeMainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ServicosFragment servicosFragment = new ServicosFragment();
    ContatosFragment contatosFragment = new ContatosFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main_layout);

        bottomNavigationView = findViewById(R.id.bottomNavView);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.frmContainer, servicosFragment).commit();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.mcontatosuteis);
        badgeDrawable.setVisible(true);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.mservicoos:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.frmContainer, servicosFragment).commit();
                        return true;
                    case R.id.mcontatosuteis:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.frmContainer, contatosFragment).commit();
                        return true;
                }

                return false;
            }
        });

    }
}