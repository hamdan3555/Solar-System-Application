package Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.technosolution.R;

public class Products extends AppCompatActivity {
    CardView btn_batteries;
    CardView btn_panels;
    CardView btn_inverters;
    CardView btn_wires;
    CardView btn_lights;
    CardView btn_fans;
    Button btn_order_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        btn_batteries = (CardView) findViewById(R.id.card_view_batteries);
        btn_panels = (CardView) findViewById(R.id.card_view_panels);
        btn_inverters = (CardView) findViewById(R.id.card_view_inverters);
        btn_wires = (CardView) findViewById(R.id.card_view_wires);
        btn_lights = (CardView) findViewById(R.id.card_view_lights);
        btn_fans = (CardView) findViewById(R.id.card_view_fans);
        btn_order_now = (Button) findViewById(R.id.button_order_now);
        btn_order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this, order_now.class);
                startActivity(intent);
            }
        });
        btn_batteries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this, batteries.class);
                startActivity(intent);
            }
        });
        btn_fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this, Fans.class);
                startActivity(intent);
            }
        });
        btn_lights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this, Lights.class);
                startActivity(intent);
            }
        });
        btn_wires.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this, Wires.class);
                startActivity(intent);
            }
        });
        btn_inverters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this, Inverters.class);
                startActivity(intent);
            }
        });
        btn_panels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Products.this, SolarPanels.class);
                startActivity(intent);
            }
        });
    }
}