package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Change_Contact_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__contact_);
        final RadioGroup radio_group = findViewById(R.id.radio_group);
        for(String s:Myapp.contacts)
        {
            RadioButton radbut = new RadioButton(this);
            radbut.setText(s);
            radbut.setGravity(Gravity.LEFT);
            radbut.setId(View.generateViewId());
            radio_group.addView(radbut);

        }
        Button cancel = findViewById(R.id.button3);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button ok =findViewById(R.id.button4);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radio_group.getCheckedRadioButtonId();
                if(selectedId==-1)
                {
                    Toast.makeText(Change_Contact_Activity.this, "No Click", Toast.LENGTH_LONG).show();
                }
                else
                    {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                        Myapp.current_contact = selectedRadioButton.getText().toString();
                        Intent returnIntent=new Intent();
                        setResult(Change_Contact_Activity.RESULT_OK ,  returnIntent);
                        finish();
                }

            }

        });
    }
}
