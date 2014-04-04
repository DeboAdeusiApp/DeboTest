package com.deboapps.Debotest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private Button btnSelected;
    private Switch switchSelected;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        /** does this load before layout is drawn?**/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final SharedPreferences myPrefs = getSharedPreferences("myPrefs", MODE_PUBLIC);
        switchSelected = (Switch) findViewById(R.id.switch1);
        switchSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    //Toast.makeText(getApplicationContext(),
                            //"VALUE ON!", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor e = myPrefs.edit();
                    e.putString("MessageText", "Thanks For Everything DIDI!"); // add or overwrite someValue
                    e.commit(); // this saves to disk and notifies observers

                } else {
                    // The toggle is disabled
                    //Toast.makeText(getApplicationContext(),
                            //"VALUE OFF! ITS OFF!", Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor e = myPrefs.edit();
                    e.putString("MessageText", "Thanks!"); // add or overwrite someValue
                    e.commit(); // this saves to disk and notifies observers
                }
            }
        });
        btnSelected = (Button) findViewById(R.id.btnToast);
        btnSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msgText = myPrefs.getString("MessageText","");
                Toast.makeText(getApplicationContext(),
                        msgText, Toast.LENGTH_LONG).show();

            }
        });

    }
}
