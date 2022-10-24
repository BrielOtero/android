package com.example.a05_exercise;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private String TAG ="TAG";
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
        ImageButton imgBtn2 = findViewById(R.id.imageButton2);
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

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    float s = intent.getFloatExtra("stars",0);
                    ratingBar.setRating(s);
                    textView5.setText(s+"");
                    Log.v(TAG,s+"");


                }
            }
        });

        imgBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText personName = findViewById(R.id.editTextTextPersonName5);
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("edittext", personName.getText().toString());
                intent.putExtra("stars", ratingBar.getRating());
                launcher.launch(intent);

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

        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number="688940501";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" +number));
                startActivity(intent);

                //Para llamar Intent.Action_CALL y añadir el permiso en el manifest
            }
        });


    }

    public void pulseBtnToogle(View view) {
        ToggleButton tgbChangeChk = findViewById(R.id.toggleButton);
        CheckBox chkFirst = findViewById(R.id.checkBox);

        chkFirst.setChecked(!tgbChangeChk.isChecked());
    }


}