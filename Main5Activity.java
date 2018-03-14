package com.example.rammaheshwari.bmicalculator;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.N)
@RequiresApi(api = Build.VERSION_CODES.N)
public class Main5Activity extends AppCompatActivity {
    Button button1,button2,button3;
    TextView textView;
    EditText editText1,editText2;
    Calendar calendar=Calendar.getInstance();
    Calendar dob=Calendar.getInstance();
    int uDate=calendar.get(Calendar.DAY_OF_MONTH);
    int uDate1=dob.get(Calendar.DAY_OF_MONTH);
    int uMonth=calendar.get(Calendar.MONTH);
    int uMonth1=dob.get(Calendar.MONTH);
    int uYear=calendar.get(Calendar.YEAR);
    int uYear1=dob.get(Calendar.YEAR);
    int uYear2,uMonth2,uDate2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        textView= (TextView) findViewById(R.id.textView);
        editText1= (EditText) findViewById(R.id.editText1);
        editText2= (EditText) findViewById(R.id.editText2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(uDate+"/"+(uMonth+1)+"/"+uYear);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Main5Activity.this,onDateSetListener,uYear1,uMonth1,uDate1).show();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uYear2=uYear-uYear1;
                uMonth2=uMonth-uMonth1;
            if(uMonth2<0)
            {
                uYear2--;
                uMonth2=12+uMonth2;

            }
            uDate2=uDate-uDate1;
                if(uDate2<0)
                {
                    uYear2--;
                    uDate2=30+uDate2;
                }
             textView.setText("Your Age is::"+uDate2+"days  "+uMonth2+"months  "+uYear2+"Years");
            }
        });
    }
    DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfmonth) {
            editText2.setText(dayOfmonth+"/"+month +"/"+year );

          }
    };
}
