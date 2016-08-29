package com.leapfrog_list.nikil.viewpageree;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Nikil on 8/29/2016.
 */
public class CustomPagerAdapter extends PagerAdapter {

    private  int[] image_resources={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomPagerAdapter(Context context)
    {
         this.context=context;


    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object) ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
    layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView= (ImageView)item_view.findViewById(R.id.image_view);
        TextView textView=(TextView)item_view.findViewById(R.id.image_count);

        imageView.setImageResource(image_resources[position]);
        textView.setText("Image  :" + position);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}


