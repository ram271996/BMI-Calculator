package com.example.rammaheshwari.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String gender,hts,wts;
    EditText edit1,edit2;
    //String a,b;
    double calc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=(EditText) findViewById(R.id.edit1);
         edit2=(EditText) findViewById(R.id.edit2);
        final TextView text4=(TextView) findViewById(R.id.text4);
        final Button button1=(Button) findViewById(R.id.button1);
        Button button2 =(Button) findViewById(R.id.button2);
        final TextView text5=(TextView) findViewById(R.id.text5);
        RadioGroup RadioGr= (RadioGroup) findViewById(R.id.RadioGr);
        RadioGroup RadioGr1=  (RadioGroup) findViewById(R.id.RadioGr1);
        RadioGroup RadioGr2=  (RadioGroup) findViewById(R.id.RadioGr2);



        RadioGr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
             public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                RadioButton radioButton=(RadioButton) findViewById(checkedId);
                gender= (String) radioButton.getText();

                                               }
                                           }

        );
        RadioGr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                @Override
                                                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int CheckedId1) {
                                                    RadioButton radioButton1=(RadioButton)findViewById(CheckedId1);
                                                    wts= (String) radioButton1.getText();
                                                 //if (hts=="cms")
                                                   // a=1;
                                                    //else a=0;
                                                }
                                            }
        );
                RadioGr2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                        @Override
                                                        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int CheckedId2) {
                                                            RadioButton radioButton2=(RadioButton)findViewById(CheckedId2);
                                                           hts=(String) radioButton2.getText();
                                                      //   if(wts=="kgs")
                                                      //          b=1;
                                                        //    else
                                                          //      b=0;

                                                        }
                                                    }

                );
        button1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v)
        {

            String s1=edit1.getText().toString();
            String s2=edit2.getText().toString();
            double wt,h,ht,wt2,ht2,ht3;
            wt=Double.parseDouble(s1);
            h=Double.parseDouble(s2);
            ht=h/100;
            switch(hts+wts)
            {
                case "cmskgs": {
                    calc = wt / (ht * ht);
                    text4.setVisibility(View.VISIBLE);
                    text4.setText(String.valueOf(calc));
                    //text5.setText("Your gender is::"+gender+"\n");
                    if(calc<=18.5)
                        text5.setText("Your gender is::" + gender + "\n\nYou are underweighed");
                    else if((calc>18.5)&&(calc<=24.9))
                        text5.setText("Your gender is::" + gender + "\n\nYou are Normal");
                    else if((calc>24.9)&&(calc<=29.9))
                        text5.setText("Your gender is::" + gender + "\n\nYou are overweighed");
                    else if(calc>29.9)
                        text5.setText("Your gender is::" + gender + "\n\nyou are obese");

                    break;
                }
                case "inchespounds": {
                    wt2 = wt * 0.4535;
                    ht2 = h * 0.025;
                    ht3=ht2*ht2;
                    calc = (wt2/ht3);
                    text4.setVisibility(View.VISIBLE);
                    text4.setText(String.valueOf(calc));
                    //text5.setText("Your gender is::"+gender+"\n");
                    if(calc<=18.5)
                        text5.setText("Your gender is::" + gender + "\n\nYou are underweighed");
                    else if((calc>18.5)&&(calc<=24.9))
                        text5.setText("Your gender is::" + gender + "\n\nYou are Normal");
                    else if((calc>24.9)&&(calc<=29.9))
                        text5.setText("Your gender is::" + gender + "\n\nYou are overweighed");
                    else if(calc>29.9)
                        text5.setText("Your gender is::" + gender + "\n\nyou are obese");

                    break;

                }
                default:
                {
                    Toast.makeText(MainActivity.this,"Please select",Toast.LENGTH_SHORT).show();
                }
                                }


        }

        });

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if((edit1!=null)||(edit2!=null)||(text4!=null)||(text5!=null))
            {
                edit1.setText("");
                edit2.setText("");
                text4.setText("");
                text5.setText("");

            }
        }
    });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.item1:
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.item2:
                Intent intent1=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent1);
                break;
            case R.id.item4:
                Intent intent3=new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent3);
                break;
            case R.id.item5:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Are You Sure");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
