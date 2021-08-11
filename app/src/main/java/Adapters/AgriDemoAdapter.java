package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.technosolution.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AgriDemoAdapter extends RecyclerView.Adapter<AgriDemoAdapter.ViewHolder> {
    Context context;
    ArrayList<String> imageURLs;

    public AgriDemoAdapter(Context context, ArrayList<String> imageURLs) {
        this.context = context;
        this.imageURLs = imageURLs;
    }
    public void add_agri(String url){
        imageURLs.add(url);
        Log.i("TAG-RecIMG", "add: "+url);
        notifyDataSetChanged();
    }
    @Override
    public AgriDemoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_demos_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( AgriDemoAdapter.ViewHolder holder, int position) {
        Picasso.with(holder.imageView.getContext()).load(imageURLs.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageURLs.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView item_holder;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_demo_home);
            item_holder = itemView.findViewById(R.id.item_homes_demos);
        }
    }
}
