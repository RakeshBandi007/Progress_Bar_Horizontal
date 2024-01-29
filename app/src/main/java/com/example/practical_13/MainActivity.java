package com.example.practical_13;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int i=0;
    private Handler h1=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar p1=findViewById(R.id.p1);
        Button b1=findViewById(R.id.b1);
        TextView t1=findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=p1.getProgress();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (i<100){
                                i +=1;

                                h1.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        p1.setProgress(i);
                                        t1.setText(i+"/"+p1.getMax());
                                    }
                                });
                                try {
                                    Thread.sleep(100);
                                }
                                catch (InterruptedException e){
                                    e.printStackTrace();
                                }


                            }
                        }
                    }).start();

            }
        });
    }
}