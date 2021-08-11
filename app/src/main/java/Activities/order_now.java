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

public class order_now extends AppCompatActivity {
    TextView address;
    TextView quantity;
    TextView product_code;
    TextView contact_number;
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);
        order=findViewById(R.id.button_order_done);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOrder();
            }
        });
    }
    private void setOrder() {
        address = (TextView) findViewById(R.id.address_postal_products);
        quantity = (TextView) findViewById(R.id.product_quantity);
        product_code = (TextView) findViewById(R.id.product_code);
        contact_number = (TextView) findViewById(R.id.contact_number_product);
        ModelBookNow object= new ModelBookNow(address.getText().toString(),quantity.getText().toString(),product_code.getText().toString(),contact_number.getText().toString());
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("OrderNow").child(contact_number.getText().toString());
        myRef.setValue(object);
        Toast.makeText(getApplicationContext(),"Order Done",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(order_now.this, Products.class);
        startActivity(intent);
        finish();
    }
}