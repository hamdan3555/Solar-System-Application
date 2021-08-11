package Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.technosolution.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout d_Layout;
    NavigationView navigationView;
    Toolbar tool_bar;
    ActionBarDrawerToggle toggle;
    CardView btn_projects;
    CardView btn_products;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_up_views();
        // Setting on Click
        btn_products = (CardView) findViewById(R.id.product_card_view);
        btn_projects = (CardView) findViewById(R.id.project_card_view);
        btn_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Products.class);
                startActivity(intent);
            }
        });
        btn_projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Projects.class);
                startActivity(intent);
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.R)
    public void set_up_views() {

        set_up_drawer_layout();
    }
    public void set_up_drawer_layout(){
        navigationView = findViewById(R.id.navigation_id);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        DrawerLayout dr = findViewById(R.id.main_drawer);
        toggle = new ActionBarDrawerToggle(this, dr, R.string.app_name, R.string.app_name);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.btnFollowUs) {
                    //
                } else if(id == R.id.btnProfile) {
                    Intent intent = new Intent(MainActivity.this, Admin.class);
                    startActivity(intent);
                } else if(id == R.id.btnRateUs) {
                    Intent intent = new Intent(MainActivity.this, AboutUs.class);
                    startActivity(intent);
                }
                dr.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}