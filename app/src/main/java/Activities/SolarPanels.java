package Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.technosolution.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import Adapters.BateryAdapter;
import Adapters.PanelAdapter;

public class SolarPanels extends AppCompatActivity {
    FirebaseStorage storage;
    ArrayList<StorageReference> imageURLs = new ArrayList<StorageReference>();
    PanelAdapter adapter;
    RecyclerView recycle_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_panels);
        storage = FirebaseStorage.getInstance();
        setupStorage();
    }
    public void set_up_recycle_view(){
        ArrayList<String> imageURLs1 = new ArrayList<>();
        adapter = new PanelAdapter(this, imageURLs1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recycle_view = findViewById(R.id.recycle_view_panels);
        recycle_view.setAdapter(adapter);
        recycle_view.setLayoutManager(gridLayoutManager);
        for (StorageReference sr:
                imageURLs) {
            sr.getDownloadUrl().addOnSuccessListener(uri -> {
                //get urls
                Log.i("TAG-URLs", "set_up_recycle_view: --> " + uri.toString());
                adapter.add(uri.toString());
            });
        }


    }

    private void setupStorage() {
        StorageReference listRef = storage.getReference().child("panels");
        listRef.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference prefix : listResult.getPrefixes()) {
                            // All the prefixes under listRef.
                            // You may call listAll() recursively on them.
                        }

                        for (StorageReference item : listResult.getItems()) {
                            // All the items under listRef.
                            Log.i("TAGIMG", "onSuccess: ---> " +item.toString());
                            imageURLs.add(item);
                        }
                        Log.i("SAIF", "onSuccess: ");
                        set_up_recycle_view();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Uh-oh, an error occurred!
                        Log.e("TAG-IMG", "onFailure: ",e );
                    }
                });
    }
}