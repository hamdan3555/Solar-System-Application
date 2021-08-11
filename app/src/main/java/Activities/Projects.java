package Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.technosolution.R;

public class Projects extends AppCompatActivity {
    CardView btn_offices;
    CardView btn_homes;
    CardView btn_agriculture;
    Button btn_book_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        btn_homes = (CardView) findViewById(R.id.card_view_homes);
        btn_offices = (CardView) findViewById(R.id.card_view_offices);
        btn_agriculture = (CardView) findViewById(R.id.card_view_agriculture);
        btn_book_now = (Button) findViewById(R.id.button_book_now);

        btn_homes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Projects.this, HomeProjectDemos.class);
                startActivity(intent);
            }
        });
        btn_offices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Projects.this, OfficesProjectDemos.class);
                startActivity(intent);
            }
        });
        btn_agriculture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Projects.this, AgriProjectDemos.class);
                startActivity(intent);
            }
        });
        btn_book_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Projects.this, BookNow.class);
                startActivity(intent);
            }
        });
    }
}