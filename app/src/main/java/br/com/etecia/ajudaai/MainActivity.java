package br.com.etecia.ajudaai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.idToolBar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.idNavigationView);

        navigationView.setNavigationItemSelectedListener(this);

        //Clique no menu para abrir e fechar o NavigationView
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout,
                toolbar,
                R.string.opennav,
                R.string.closenav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.idContainerNav, new SolicitacoesFragment()).commit();

            navigationView.setCheckedItem(R.id.msolicitacoes);

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.msolicitacoes:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new SolicitacoesFragment()).commit();

                break;
            case R.id.mserviços:
                startActivity(new Intent(getApplicationContext(),
                        HomeMainActivity.class));
                break;
            case R.id.mnotificacoes:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new NotificacaoFragment()).commit();
                break;
            case R.id.mopcoes:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new ConfigFragment()).commit();
            case R.id.mSobre:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.idContainerNav, new SobreFragment()).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
        super.onBackPressed();
    }
}
}