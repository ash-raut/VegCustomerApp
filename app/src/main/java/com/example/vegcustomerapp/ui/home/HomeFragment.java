package com.example.vegcustomerapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.vegcustomerapp.ProductActivity;
import com.example.vegcustomerapp.R;

import java.util.HashMap;

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private HomeViewModel homeViewModel;
    SliderLayout sliderLayout;
    HashMap<String, Integer> HashMapForLocal;
    CardView cardView,vegetablecardview;
    public static String condition="1";

    public static String getCondition() {
        return condition;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        cardView = root.findViewById(R.id.fruitcard);
        vegetablecardview=root.findViewById(R.id.vegcardview);
        vegetablecardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = "product_category_id = 2";
                Intent intent = new Intent(getContext(),ProductActivity.class);
                startActivity(intent);
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition = "product_category_id = 1";
                Intent intent=new Intent(getContext(), ProductActivity.class);
                startActivity(intent);
            }
        });


        AddImageUrlLocal();
        sliderLayout = root.findViewById(R.id.slider);




        for (String name : HashMapForLocal.keySet()) {
            TextSliderView textSliderView = new TextSliderView(root.getContext());

            textSliderView.description(name).image(HashMapForLocal.get(name)).setScaleType(BaseSliderView.ScaleType.CenterCrop).setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(HomeFragment.this);

        return root;
    }
    @Override
    public void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    private void AddImageUrlLocal() {
        HashMapForLocal = new HashMap<String, Integer>();

        HashMapForLocal.put("FRUITS", R.drawable.onlyfruits);
        HashMapForLocal.put("FRUITS AND VEGETABLS", R.drawable.onlyvegetables);
        HashMapForLocal.put("VEGETABLES", R.drawable.onlyveg);
        HashMapForLocal.put("FRESH FRUITS", R.drawable.onlyfrut1);


    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Log.e("silder clicked:", slider.getBundle().get("extra") + "");

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Change:" + position);


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}