package com.cookandroid.mydateapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity{
    Chronometer chrono;
    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute,tvYear1, tvMonth1, tvDay1, tvHour1, tvMinute1;
    Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약 어플리케이션");

        btnEnd = (Button) findViewById(R.id.btnEnd);

        chrono = (Chronometer) findViewById(R.id.chronometer1);
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        dPicker = (DatePicker) findViewById(R.id.datePicker);
        tPicker = (TimePicker) findViewById(R.id.timePicker1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);
        tvYear1 = (TextView) findViewById(R.id.tvYear1);
        tvMonth1 = (TextView) findViewById(R.id.tvMonth1);
        tvDay1 = (TextView) findViewById(R.id.tvDay1);
        tvHour1 = (TextView) findViewById(R.id.tvHour1);
        tvMinute1 = (TextView) findViewById(R.id.tvMinute1);

        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rdoCal.setVisibility(View.VISIBLE);
        rdoTime.setVisibility(View.VISIBLE);

        btnEnd.setVisibility(View.INVISIBLE);
        tvYear.setVisibility(View.INVISIBLE);
        tvMonth.setVisibility(View.INVISIBLE);
        tvDay.setVisibility(View.INVISIBLE);
        tvHour.setVisibility(View.INVISIBLE);
        tvMinute.setVisibility(View.INVISIBLE);
        tvYear1.setVisibility(View.INVISIBLE);
        tvMonth1.setVisibility(View.INVISIBLE);
        tvDay1.setVisibility(View.INVISIBLE);
        tvHour1.setVisibility(View.INVISIBLE);
        tvMinute1.setVisibility(View.INVISIBLE);


        rdoCal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);

                btnEnd.setVisibility(View.VISIBLE);
                tvYear.setVisibility(View.VISIBLE);
                tvMonth.setVisibility(View.VISIBLE);
                tvDay.setVisibility(View.VISIBLE);
                tvHour.setVisibility(View.VISIBLE);
                tvMinute.setVisibility(View.VISIBLE);
                tvYear1.setVisibility(View.VISIBLE);
                tvMonth1.setVisibility(View.VISIBLE);
                tvDay1.setVisibility(View.VISIBLE);
                tvHour1.setVisibility(View.VISIBLE);
                tvMinute1.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });


        btnEnd.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View arg0){
                chrono.stop();
                chrono.setTextColor(Color.BLUE);


                tvYear.setText(Integer.toString(dPicker.getYear()));
                tvMonth.setText(Integer.toString(1 + dPicker.getMonth()));
                tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));
                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.INVISIBLE);

                return  false;
            }
        });

    }

}
