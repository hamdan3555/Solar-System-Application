package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.technosolution.R;

public class LaunchScreen extends AppCompatActivity {
    Button btn_get_started;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_screen);
        btn_get_started = (Button) findViewById(R.id.get_started);
        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}