package com.example.aaung.myfoodreceipe.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aaung.myfoodreceipe.CategorySearchActivity;
import com.example.aaung.myfoodreceipe.R;
import com.example.aaung.myfoodreceipe.constantdata.HomeItemConstant;
import com.example.aaung.myfoodreceipe.fragment.CategoryListFragment;
import com.example.aaung.myfoodreceipe.model.HomeItem;

import org.w3c.dom.Text;

import java.util.List;

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.MyViewHolder> {

    public Context mContext;
    public List<HomeItem> mHomeItemList;
    private HomeItemClickListener mListener;


    public HomeItemAdapter(Context mContext, HomeItemClickListener listener){
        this.mListener = listener;
        this.mContext = mContext;
        this.mHomeItemList = HomeItemConstant.homeItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_recipe_items,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final HomeItem mHomeItem = mHomeItemList.get(position);

        //https://stackoverflow.com/questions/21856260/how-can-i-convert-string-to-drawable
        int imageId = mContext.getResources().getIdentifier(mHomeItem.getCategoryImage(), "drawable",mContext.getPackageName());
        Drawable drawable = mContext.getResources().getDrawable(imageId);
        holder.mHomeItemImage.setBackground(drawable);
        holder.mHomeItemName.setText(mHomeItem.getCategoryName());

        holder.mHomeItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onHomeItemClickListener(mHomeItem);
            }
        });
    }

    public interface HomeItemClickListener{
        void onHomeItemClickListener(HomeItem item);
    }

    @Override
    public int getItemCount() {
        return mHomeItemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mHomeItemName;
        private LinearLayout mHomeItemImage;
        private View mHomeItemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mHomeItemImage = (LinearLayout)itemView.findViewById(R.id.layout_item_image);
            mHomeItemName = (TextView)itemView.findViewById(R.id.txt_item_name);
            mHomeItemView = itemView;
        }
    }
}

