package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Change_Sound_Activity extends AppCompatActivity {

    int selected_sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__sound_);
        Spinner spinner = findViewById(R.id.spinner);
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this,R.layout.support_simple_spinner_dropdown_item, Myapp.sounds);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        // przyciski ok i cancel
        Button ok = findViewById(R.id.ok_Sound);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner=findViewById(R.id.spinner);
                Myapp.current_sound=spinner.getSelectedItem().toString();
                Intent a = new Intent();
                setResult(Change_Sound_Activity.RESULT_OK , a);
                finish();
            }
        });
        Button cancel = findViewById(R.id.Cancel_Sound);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //cancel finish
        //Myapp.current_sound = spinner.getseecteditem().toString /// OK
        //wlaczenie intenntu jak dla kontakt
    }
}
