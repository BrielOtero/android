package com.example.a05_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.FormatException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        TextView textView = findViewById(R.id.textView8);
        CheckBox chkFirst = findViewById(R.id.checkBox);
        CheckBox chkSecond = findViewById(R.id.checkBox2);
        CheckBox chkThird = findViewById(R.id.checkBox3);
        ToggleButton tgbChangeChk = findViewById(R.id.toggleButton);
        Switch switch1 = findViewById(R.id.switch1);
        RadioButton rd1 = findViewById(R.id.radioButton);
        RadioButton rd2 = findViewById(R.id.radioButton2);
        Button btn2 = findViewById(R.id.button2);
        TextView textView5 = findViewById(R.id.textView5);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String value = seekBar.getProgress() + "";
                textView.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (switch1.isChecked()) {
                    switch1.setText("Activo");
                } else {
                    switch1.setText("No Activo");
                }
            }
        });

        Button btnClear = findViewById(R.id.button);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkFirst.setChecked(false);
                chkSecond.setChecked(false);
                chkThird.setChecked(false);
                tgbChangeChk.setChecked(false);
                switch1.setChecked(false);
                rd1.setChecked(false);
                rd2.setChecked(false);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int value = Integer.parseInt(textView5.getText() + "");
                    if (chkSecond.isChecked()) {
                        value--;
                    } else {
                        value++;
                    }

                    textView5.setText(value + "");
                } catch (NumberFormatException f) {

                    textView5.setText("0");
                }
            }

        });

        rd1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Radiobutton 1", Toast.LENGTH_SHORT).show();
            }
        });

        rd2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Radiobutton 2", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void pulseBtnToogle(View view) {
        ToggleButton tgbChangeChk = findViewById(R.id.toggleButton);
        CheckBox chkFirst = findViewById(R.id.checkBox);

        chkFirst.setChecked(!tgbChangeChk.isChecked());
    }


}