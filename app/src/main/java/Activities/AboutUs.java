package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.technosolution.R;

public class AboutUs extends AppCompatActivity {
    Button btn_more_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        btn_more_info = (Button) findViewById(R.id.button_more);
        btn_more_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUs.this, MoreInfo.class);
                startActivity(intent);
            }
        });
    }
}