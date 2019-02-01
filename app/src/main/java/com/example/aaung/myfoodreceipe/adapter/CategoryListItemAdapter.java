package com.example.aaung.myfoodreceipe.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aaung.myfoodreceipe.R;
import com.example.aaung.myfoodreceipe.constantdata.HomeItemConstant;
import com.example.aaung.myfoodreceipe.model.HomeItem;

import java.util.List;

public class CategoryListItemAdapter extends RecyclerView.Adapter<CategoryListItemAdapter.MyViewHolder> {

    public Context mContext;
    public List<HomeItem> mHomeItemList;
    private CategoryItemClickListener mListener;


    public CategoryListItemAdapter(Context mContext, List<HomeItem> homeItemList, CategoryItemClickListener listener){
        this.mListener = listener;
        this.mContext = mContext;
        setFilter(homeItemList);
    }

    public void setFilter(List<HomeItem> filterItemList){

        if(mHomeItemList != null && mHomeItemList.size() > 0){
            this.mHomeItemList.clear();
            this.mHomeItemList.addAll(filterItemList);
        }else {
            this.mHomeItemList = filterItemList;
        }

        Log.e("ItemCount Before", mHomeItemList.size()+"");
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_list_items,parent,false);
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
                mListener.onCategoryItemClickListener(mHomeItem);
            }
        });
    }

    public interface CategoryItemClickListener{
        void onCategoryItemClickListener(HomeItem item);
    }

    @Override
    public int getItemCount() {
        Log.e("ItemCount After", mHomeItemList.size()+"");
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
            mHomeItemView.setClipToOutline(true);
        }
    }
}

