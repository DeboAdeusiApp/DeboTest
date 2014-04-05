package com.deboapps.Debotest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import static android.view.View.OnClickListener;

public class MyActivity extends Activity implements CompoundButton.OnCheckedChangeListener{
    /**
     * Called when the activity is first created.
     */
    private Button btnSelected;
    private ImageView imageViewSelected;
    private TextView textViewSelected;
    private OnClickListener tapListener;
    private int counter = 0;
    public String MessageText = "DEFAULT";

    public void onCreate(Bundle savedInstanceState) {
        /** does this load before layout is drawn?**/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initializeApp();

        Switch s = (Switch) findViewById(R.id.switch1);
        if (s != null) {
            s.setOnCheckedChangeListener(this);
        }

        btnSelected = (Button) findViewById(R.id.btnToast);
        btnSelected.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msgText = MessageText;
                Toast.makeText(getApplication(),
                        msgText, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initializeApp() {
        imageViewSelected = (ImageView) findViewById(R.id.imageView); //image being used for module 3
        textViewSelected = (TextView) findViewById(R.id.textView);

        tapListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                touchdroid();
            }
        };
        imageViewSelected.setOnClickListener(tapListener);
    }

    private void touchdroid() {
        counter++;
        String temp;

        temp = String.format("%d times",counter);
        //temp = "GO!";
        //Toast.makeText(getApplicationContext(),temp, Toast.LENGTH_SHORT).show();
        temp = ("you have clicked "+ temp);
        textViewSelected.setText(temp);

    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //Toast.makeText(this, "Monitored switch is " + (isChecked ? "on" : "off"),
               // Toast.LENGTH_SHORT).show();
        MessageText = (isChecked ? "on" : "off");
    }
}