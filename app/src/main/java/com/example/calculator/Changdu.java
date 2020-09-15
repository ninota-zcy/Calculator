package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.BigDecimal;

import static com.example.calculator.MainActivity.activityList;


public class Changdu extends AppCompatActivity {

    private Spinner forinput = null;
    private Spinner foroutput = null;
    int flag = 0;
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.zhu:{
                Intent intent = new Intent(Changdu.this,MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.area:{
                Intent intent = new Intent(Changdu.this,Area.class);
                startActivity(intent);
                break;
            }
            case R.id.help:{
                Intent intent = new Intent(Changdu.this,Help.class);
                startActivity(intent);
                break;
            }

            case R.id.jinzhi:{
                Intent intent = new Intent(Changdu.this,Jinzhi.class);
                startActivity(intent);
                break;
            }
            case R.id.exit:{
                exit();
            }
        }
        return false;
    }
    public void exit(){

        for(Activity act:activityList){

            act.finish();

        }

        System.exit(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changdu);
        activityList.add(this);
        final EditText hinput = findViewById(R.id.Hinput);
        final EditText houtput = findViewById(R.id.Houtput);
        final Button zero = findViewById(R.id.Hzero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "0");
            }
        });
        final Button one = findViewById(R.id.Hone);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "1");
            }
        });
        final Button two = findViewById(R.id.Htwo);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "2");
            }
        });
        final Button three = findViewById(R.id.Hthree);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "3");
            }
        });
        final Button four = findViewById(R.id.Hfour);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "4");
            }
        });
        final Button five = findViewById(R.id.Hfive);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "5");
            }
        });
        final Button six = findViewById(R.id.Hsix);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "6");
            }
        });
        final Button seven = findViewById(R.id.Hseven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "7");
            }
        });
        final Button eight = findViewById(R.id.Height);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "8");
            }
        });
        final Button nine = findViewById(R.id.Hnine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hinput.setText(hinput.getText() + "9");
            }
        });
        final Button dot = findViewById(R.id.Hdot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = hinput.getText().toString();
                if(str.length() == 0 ){
                    hinput.setText("0.");
                }
                else
                    hinput.setText(hinput.getText()+".");
            }
        });
        final Button pi = findViewById(R.id.Hbin);
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hinput.setText(hinput.getText() + "3.14");
            }
        });

        Button clear = findViewById(R.id.Hcls);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editext = findViewById(R.id.Hinput);
                EditText editext2 = findViewById(R.id.Houtput);
                editext.setText("");
                editext2.setText("");
            }
        });
        Button back = findViewById(R.id.Hback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editext = findViewById(R.id.Hinput);
                String str = editext.getText().toString();
                if(str.equals(""))
                    editext.setText("");
                else
                    editext.setText(str.substring(0,str.length()-1));
            }
        });

        forinput = findViewById(R.id.forHinput);
        foroutput = findViewById(R.id.forHoutput);
        forinput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = hinput.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.changdu);
                flag = 0;
                if(jinzhi[position].equals("纳米")){
                    flag = 1;
                }
                else if(jinzhi[position].equals("微米")){
                    flag = 2;
                }
                else if(jinzhi[position].equals("米")){
                    flag = 3;
                }
                else if(jinzhi[position].equals("千米")){
                    flag = 4;
                }
                else if(jinzhi[position].equals("英里")){
                    flag = 5;
                }
                else if(jinzhi[position].equals("英尺")){
                    flag = 6;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        foroutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int re = flag;
                String front = hinput.getText().toString();
                String str = hinput.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.changdu);
                if(front.equals("")){
                    Toast.makeText(Changdu.this,"请输入", Toast.LENGTH_LONG).show();
                }
                else{
                    if(jinzhi[position].equals("纳米")){

                        switch(re){
                            case 1:houtput.setText(front);break;
                            case 2:houtput.setText(a2to1(front));break;
                            case 3:houtput.setText(a3to1(front));break;
                            case 4:houtput.setText(a4to1(front));break;
                            case 5:houtput.setText(a5to1(front));break;
                            case 6:houtput.setText(a6to1(front));break;
                        }
                    }
                    else if(jinzhi[position].equals("微米")){
                        switch(re){
                            case 1:houtput.setText(a1to2(front));break;
                            case 2:houtput.setText(front);break;
                            case 3:houtput.setText(a3to2(front));break;
                            case 4:houtput.setText(a4to2(front));break;
                            case 5:houtput.setText(a5to2(front));break;
                            case 6:houtput.setText(a6to2(front));break;
                        }

                    }
                    else if(jinzhi[position].equals("米")){
                        switch(re){
                            case 1:houtput.setText(a1to3(front));break;
                            case 2:houtput.setText(a2to3(front));break;
                            case 3:houtput.setText(front);break;
                            case 4:houtput.setText(a4to3(front));break;
                            case 5:houtput.setText(a5to3(front));break;
                            case 6:houtput.setText(a6to3(front));break;
                        }
                    }
                    else if(jinzhi[position].equals("千米")){
                        switch(re){
                            case 1:houtput.setText(a1to4(front));break;
                            case 2:houtput.setText(a2to4(front));break;
                            case 3:houtput.setText(a3to4(front));break;
                            case 4:houtput.setText(front);break;
                            case 5:houtput.setText(a5to4(front));break;
                            case 6:houtput.setText(a6to4(front));break;

                        }
                    }
                    else if(jinzhi[position].equals("英里")){
                        switch(re){
                            case 1:houtput.setText(a1to5(front));break;
                            case 2:houtput.setText(a2to5(front));break;
                            case 3:houtput.setText(a3to5(front));break;
                            case 4:houtput.setText(a4to5(front));break;
                            case 5:houtput.setText(front);break;
                            case 6:houtput.setText(a6to5(front));break;

                        }
                    }
                    else if(jinzhi[position].equals("英尺")){
                        switch(re){
                            case 1:houtput.setText(a1to6(front));break;
                            case 2:houtput.setText(a2to6(front));break;
                            case 3:houtput.setText(a3to6(front));break;
                            case 4:houtput.setText(a4to6(front));break;
                            case 5:houtput.setText(a5to6(front));break;
                            case 6:houtput.setText(front);break;

                        }
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public static String a1to2(String a){
        double b = Double.parseDouble(a);
        return b/1000+"";
    }
    public static String a1to3(String a){
        double b = Double.parseDouble(a);
        return b/1000000000+"";
    }
    public static String a1to4(String a){
        double b = Double.parseDouble(a);
        return b*0.000000000001+"";
    }
    public static String a1to5(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }
    public static String a1to6(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }

    public static String a2to1(String a){
        double b = Double.parseDouble(a);
        return b*1000 + "";
    }
    public static String a2to3(String a){
        double b = Double.parseDouble(a);
        return b/1000000 + "";
    }
    public static String a2to4(String a){
        double b = Double.parseDouble(a);
        return b*0.000000001+"";
    }
    public static String a2to5(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }
    public static String a2to6(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }

    public static String a3to1(String a){
        double b = Double.parseDouble(a);
        return b*1000000000 + "";
    }
    public static String a3to2(String a){
        double b = Double.parseDouble(a);
        return b*1000000 + "";
    }
    public static String a3to4(String a){
        double b = Double.parseDouble(a);
        return b/1000 + "";
    }
    public static String a3to5(String a){
        double b = Double.parseDouble(a);
        return b*0.00062137 + "";
    }
    public static String a3to6(String a){
        double b = Double.parseDouble(a);
        return 3.2808398950 + "";
    }

    public static String a4to1(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }
    public static String a4to2(String a){
        double b = Double.parseDouble(a);
        return b/1000000 + "";
    }
    public static String a4to3(String a){
        double b = Double.parseDouble(a);
        return b/1000 + "";
    }
    public static String a4to5(String a){
        double b = Double.parseDouble(a);
        return b*0.621371192237 + "";
    }
    public static String a4to6(String a){
        double b = Double.parseDouble(a);
        return b * 3280 + "";
    }

    public static String a5to1(String a){
        double b = Double.parseDouble(a);
        return"两单位相差量度太大" ;
    }
    public static String a5to2(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }
    public static String a5to3(String a){
        double b = Double.parseDouble(a);
        return b*1609.344 + "";
    }
    public static String a5to4(String a){
        double b = Double.parseDouble(a);
        return b*1.609344 + "";
    }
    public static String a5to6(String a){
        double b = Double.parseDouble(a);
        return 5280 + "";
    }

    public static String a6to1(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }
    public static String a6to2(String a){
        double b = Double.parseDouble(a);
        return "两单位相差量度太大";
    }
    public static String a6to3(String a){
        double b = Double.parseDouble(a);
        return b*0.3048+"";
    }
    public static String a6to4(String a){
        double b = Double.parseDouble(a);
        return b*0.0003048 + "";
    }
    public static String a6to5(String a){
        double b = Double.parseDouble(a);
        return b * 0.00018939 + "";
    }





}
