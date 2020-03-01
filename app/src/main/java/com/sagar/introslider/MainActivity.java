package com.sagar.introslider;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sagar.introslider.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ImageView pointer1,pointer2,pointer3;

    Button imgLeftArrow,imgRightArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        arrowClick();
        setAdapter();
        setSelectedImg(viewPager);


    }


    public void initWidgets(){
        viewPager = findViewById(R.id.viewPager);

        pointer1 = findViewById(R.id.pointer1);
        pointer2 = findViewById(R.id.pointer2);
        pointer3 = findViewById(R.id.pointer3);

        imgLeftArrow = findViewById(R.id.imgLeftArrow);
        imgRightArrow = findViewById(R.id.imgRightArrow);
    }

    public void arrowClick(){
        imgLeftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewPager.getCurrentItem();
                if (pos == 0){
                    viewPager.setCurrentItem(2);
                }else if (pos == 1){
                    viewPager.setCurrentItem(0);
                }else if (pos == 2){
                    viewPager.setCurrentItem(1);
                }
            }
        });

        imgRightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = viewPager.getCurrentItem();
                if (pos == 0){
                    viewPager.setCurrentItem(1);
                }else if (pos == 1){
                    viewPager.setCurrentItem(2);
                    imgRightArrow.setText("Go");

                }else if (pos == 2){
                    //viewPager.setCurrentItem(0);
                }

                if (pos == 2){
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void setAdapter(){
        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), 3);
        viewPager.setAdapter(adapter);
    }

    public void setSelectedImg(ViewPager viewPager){

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        pointer1.setImageResource(R.drawable.ic_selected);
                        pointer2.setImageResource(R.drawable.ic_notselected);
                        pointer3.setImageResource(R.drawable.ic_notselected);
                        break;
                    case 1:
                        pointer1.setImageResource(R.drawable.ic_notselected);
                        pointer2.setImageResource(R.drawable.ic_selected);
                        pointer3.setImageResource(R.drawable.ic_notselected);
                        break;
                    case 2:
                        pointer1.setImageResource(R.drawable.ic_notselected);
                        pointer2.setImageResource(R.drawable.ic_notselected);
                        pointer3.setImageResource(R.drawable.ic_selected);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
