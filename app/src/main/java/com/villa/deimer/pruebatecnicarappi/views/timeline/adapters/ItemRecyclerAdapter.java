package com.villa.deimer.pruebatecnicarappi.views.timeline.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;
import com.villa.deimer.pruebatecnicarappi.R;
import com.villa.deimer.pruebatecnicarappi.model.entities.Item;
import com.villa.deimer.pruebatecnicarappi.views.details.DetailActivity;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("LongLogTag, SetTextI18n, InflateParams")
public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.AdapterView> {

    private Context context;
    private List<Item> items;
    private String baseUrlImage;
    private boolean isMovie;

    public ItemRecyclerAdapter(Context context, List<Item> items, String baseUrlImage, boolean isMovie) {
        this.context = context;
        this.items = items;
        this.baseUrlImage = baseUrlImage;
        this.isMovie = isMovie;
    }

    @NonNull
    @Override
    public AdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_card_item, parent, false);
        return new AdapterView(layoutView);
    }

    public int getItemCount() {
        return items.size();
    }

    class AdapterView extends RecyclerView.ViewHolder {
        @BindView(R.id.card_item)
        CardView cardItem;
        @BindView(R.id.img_item)
        ImageView imgItem;
        @BindView(R.id.lbl_name)
        TextView lblName;
        @BindView(R.id.lbl_date)
        TextView lblDate;
        AdapterView(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterView holder, int position) {
        Item item = items.get(position);
        setLabels(holder, item);
        setImageItem(holder, item.getPoster_path());
        String title = ((isMovie)) ? item.getTitle() : item.getName();
        clickOpenDetailsItem(holder, item.getId(), title);
        animateRecycler(holder);
    }

    private void setLabels(AdapterView holder, Item item) {
        if(isMovie) {
            holder.lblName.setText(item.getTitle());
            holder.lblDate.setText(item.getRelease_date());
        } else {
            holder.lblName.setText(item.getName());
            holder.lblDate.setText(item.getFirst_air_date());
        }
    }

    private void setImageItem(AdapterView holder, String path) {
        Picasso.with(context)
                .load(baseUrlImage + path)
                .placeholder(R.drawable.ic_movie_primary)
                .error(R.drawable.ic_movie_primary)
                .fit()
                .into(holder.imgItem);
    }

    private void clickOpenDetailsItem(AdapterView holder, final int itemId, final String title) {
        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("itemId", itemId);
                intent.putExtra("isMovie", isMovie);
                intent.putExtra("title", title);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    private void animateRecycler(AdapterView holder) {
        YoYo.with(Techniques.FadeInUp)
                .duration(700)
                .playOn(holder.cardItem);
    }

}
