package Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.technosolution.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Utils.code_picker;
import Utils.price_picker;

public class PanelAdapter extends RecyclerView.Adapter<PanelAdapter.ViewHolder> {
    Context context;
    ArrayList<String> imageURLs;

    public PanelAdapter(Context context, ArrayList<String> imageURLs) {
        this.context = context;
        this.imageURLs = imageURLs;
    }
    public void add(String url){
        imageURLs.add(url);
        Log.i("TAG-RecIMG", "add: "+url);
        notifyDataSetChanged();
    }

    @Override
    public PanelAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_demos_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PanelAdapter.ViewHolder holder, int position) {
        price_picker select_price = new price_picker();
        String final_price = select_price.get_price();
        code_picker select_code = new code_picker();
        String final_code = select_code.get_code();
        Picasso.with(holder.imageView.getContext()).load(imageURLs.get(position)).into(holder.imageView);
        holder.price_text.setText(final_price);
        holder.code_text.setText(final_code);
    }

    @Override
    public int getItemCount() {
        return imageURLs.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView price_text;
        TextView code_text;
        CardView item_holder;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_product_demo);
            price_text = itemView.findViewById(R.id.price_product);
            code_text = itemView.findViewById(R.id.code_product);
            item_holder = itemView.findViewById(R.id.item_homes_demos);
        }
    }
}
