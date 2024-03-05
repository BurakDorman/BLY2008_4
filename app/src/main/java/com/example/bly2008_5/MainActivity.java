package com.example.bly2008_5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonImage, buttonIstanbul, buttonAnkara, buttonIzmir;
    private ImageView imageView;

    private List<Integer> imageList = Arrays.asList(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3
    );

    private int correctImageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonImage = findViewById(R.id.buttonImage);
        buttonIstanbul = findViewById(R.id.buttonIstanbul);
        buttonAnkara = findViewById(R.id.buttonAnkara);
        buttonIzmir = findViewById(R.id.buttonIzmir);
        Button buttonBackToMain = findViewById(R.id.buttonBackToMain);
        imageView = findViewById(R.id.imageView);

        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(imageList);
                imageView.setImageResource(imageList.get(0));
                correctImageIndex = imageList.indexOf(R.drawable.image1);
                buttonIstanbul.setVisibility(View.VISIBLE);
                buttonAnkara.setVisibility(View.VISIBLE);
                buttonIzmir.setVisibility(View.VISIBLE);
            }
        });

        buttonIstanbul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageList.get(correctImageIndex) == R.drawable.image1) {
                    setContentView(R.layout.layout_istanbul);
                } else {
                    Toast.makeText(MainActivity.this, "Yanlış cevap!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonAnkara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageList.get(correctImageIndex) == R.drawable.image2) {
                    setContentView(R.layout.layout_ankara);
                } else {
                    Toast.makeText(MainActivity.this, "Yanlış cevap!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonIzmir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageList.get(correctImageIndex) == R.drawable.image3) {
                    setContentView(R.layout.layout_izmir);
                } else {
                    Toast.makeText(MainActivity.this, "Yanlış cevap!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);
            }
        });


        // Ankara ve İzmir butonlarını oluşturmak ve onları düğmeye tıklama olayı eklenebilir.
        // Ancak bu kısım size bırakılmıştır.
    }
}
