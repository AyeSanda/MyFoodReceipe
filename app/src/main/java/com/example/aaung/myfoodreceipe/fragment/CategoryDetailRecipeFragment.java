package com.example.aaung.myfoodreceipe.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aaung.myfoodreceipe.R;
import com.example.aaung.myfoodreceipe.constantdata.HomeItemConstant;
import com.example.aaung.myfoodreceipe.model.HomeItem;

public class CategoryDetailRecipeFragment extends Fragment {

    private static final String ARG_RECIPE_ID = "recipe_id";
    private String mRecipeId;

    private ImageView mRecipeImage;
    private TextView mIngredientAmount;
    private TextView mIngredientName;
    private TextView mRecipeSteps;

    public CategoryDetailRecipeFragment() {

    }

    public static CategoryDetailRecipeFragment newInstance(String recipeId) {
        CategoryDetailRecipeFragment fragment = new CategoryDetailRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_RECIPE_ID, recipeId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecipeId = getArguments().getString(ARG_RECIPE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_detail_recipe, container, false);
        initView(view);
        setData();
        return view;
    }

    public void initView(View view){
        mRecipeImage = view.findViewById(R.id.img_recipe);
        mIngredientAmount = view.findViewById(R.id.txt_ingredient_amount);
        mIngredientName = view.findViewById(R.id.txt_ingredient_name);
        mRecipeSteps = view.findViewById(R.id.txt_recipe_steps);
    }

    public HomeItem getRecipeData(){

        for(HomeItem item : HomeItemConstant.homeItems){
            if(item.getCategoryId().equals(mRecipeId))
                return item;
        }
        return null;
    }

    public void setData(){
        HomeItem item = getRecipeData();

        if(item != null){
            int imageId = getContext().getResources().getIdentifier(item.getCategoryImage(), "drawable",getContext().getPackageName());
            Drawable drawable = getContext().getResources().getDrawable(imageId);
            mRecipeImage.setBackground(drawable);
        }
    }
}
