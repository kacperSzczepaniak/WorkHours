package com.example.kacper.workhours;

import java.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import com.example.kacper.godzinypracy.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    String res= getString(R.string.inalidTime);
    String minus= getString(R.string.minusTime);
    TextView resul=(TextView)findViewById(R.id.result);
    EditText endH =  (EditText) findViewById(R.id.endH);
    EditText endMin =  (EditText) findViewById(R.id.endMin);
    EditText startMin =  (EditText) findViewById(R.id.startMin);
    EditText startH =  (EditText) findViewById(R.id.startH);
    double startHour=0;
    double startMinutes =0;
    double endMinutes=0;
    double endHour=0;

    public void btnCalcFire(View view) {



        try {
            startHour = Double.parseDouble(startH.getText().toString());
            startMinutes = Double.parseDouble(startMin.getText().toString());
            endMinutes = Double.parseDouble(endMin.getText().toString());
            endHour = Double.parseDouble(endH.getText().toString());
        }catch(NumberFormatException e){
            resul.setText(res);
        }
        if(startMinutes>=0 && startMinutes<15){
            startMinutes=0;
        }
        else if(startMinutes>=15&& startMinutes<30){
            startMinutes=0.25;
        }
        else if(startMinutes>=30 && startMinutes<45){
            startMinutes=0.5;
        }
        else if(startMinutes>=45&& startMinutes<60){
            startMinutes=0.75;
        }
        else{
            resul.setText(res);
            return;
        }

        if(endMinutes>=0 && endMinutes<15){
            endMinutes=0;
        }
        else if(endMinutes>=15&& endMinutes<30){
            endMinutes=0.25;
        }
        else if(endMinutes>=30 && endMinutes<45){
            endMinutes=0.5;
        }
        else if(endMinutes>=45&& endMinutes<60){
            endMinutes=0.75;
        }
        else{
            resul.setText(res);
            return;
        }

        if(startHour>24||endHour>24){
            resul.setText(res);
            return;
        }

        double last=(endHour+endMinutes)-(startHour+startMinutes);

        if(last<0){
            resul.setText(minus);
            return;
        }

        resul.setText(Double.toString(last));

    }
}
