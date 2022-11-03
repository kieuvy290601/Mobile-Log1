package com.example.mobilelb1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String[] imageList;
    Button prevButton, nextButton;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        nextButton = findViewById(R.id.nextBtn);
        prevButton = findViewById(R.id.prevBtn);

        imageList = getResources().getStringArray(R.array.imageList);

        picassoShowImage(i);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i +=1;
                if(i == imageList.length){
                    i =0;
                    picassoShowImage(i);

                }else{
                    picassoShowImage(i);
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i -=1;
                if(i < 0){
                    i = imageList.length - 1;
                    picassoShowImage(i);
                }else{
                    picassoShowImage(i);
                }
            }
        });
    }

    private void picassoShowImage(int i){
        Picasso.get().load(imageList[i]).into(imageView);
    }




    /*public void Prev(View view) {

        if(i>imgList.length){
            i--;
        }
        Picasso.get().load(imgList[i]).into(imageView);
    }

    public void Next(View view) {
        if(i <= imgList.length - 1){
            i++;
        }else{
            i = 0;
        }
        Picasso.get().load(imgList[i]).into(imageView);
    }*/
}