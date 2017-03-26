package com.example.alise.keyshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view);

        scrollView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
                int heightOfLinearLayout = linearLayout.getHeight();

                ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view);
                int heightOfTheApp = scrollView.getHeight();

                //calculate the height that would the image have filling the remaining space
                //on the screen if there was no scrolling
                int calculatedHeight = heightOfTheApp - heightOfLinearLayout;

                ImageView imageView = (ImageView) findViewById(R.id.image_view);

                //get screen width
                float screenWidth = scrollView.getWidth();

                //calculate height base on the screen size (screenWidth * 557 / 1486)
                //and then set 88% of the calculated height to minHeight (88 / 100)
                int minHeight = Math.round(screenWidth * 557 / 1486 * 88 / 100);

                if (calculatedHeight < minHeight) {
                    imageView.getLayoutParams().height = minHeight;
                } else {
                    imageView.getLayoutParams().height = calculatedHeight;
                }
            }
        });
    }
}
