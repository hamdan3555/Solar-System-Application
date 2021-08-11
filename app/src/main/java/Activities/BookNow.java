package Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.technosolution.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Models.ModelBookNow;

public class BookNow extends AppCompatActivity {
    TextView address;
    TextView type;
    TextView project_power;
    TextView contact_number;
    Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);
        book=findViewById(R.id.button_book_done);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            setBook();
            }
        });

    }
    private void setBook() {
        address = (TextView) findViewById(R.id.address_postal);
        type = (TextView) findViewById(R.id.project_type);
        project_power = (TextView) findViewById(R.id.project_power);
        contact_number = (TextView) findViewById(R.id.contact_number);
        ModelBookNow object= new ModelBookNow(address.getText().toString(),type.getText().toString(),project_power.getText().toString(),contact_number.getText().toString());
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("BookNow").child(contact_number.getText().toString());
        myRef.setValue(object);
        Toast.makeText(getApplicationContext(),"Booking Done",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(BookNow.this, Projects.class);
        startActivity(intent);
        finish();

    }
}