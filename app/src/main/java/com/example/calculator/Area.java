package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class Area extends AppCompatActivity {
    private Spinner forinput = null;
    private Spinner foroutput = null;
    int flag = 0;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.zhu:{
                Intent intent = new Intent(Area.this,MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.length:{
                Intent intent = new Intent(Area.this,Changdu.class);
                startActivity(intent);
                break;
            }
            case R.id.help:{
                Intent intent = new Intent(Area.this,Help.class);
                startActivity(intent);
                break;
            }

            case R.id.jinzhi:{
                Intent intent = new Intent(Area.this,Jinzhi.class);
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
        setContentView(R.layout.activity_area);
        activityList.add(this);
        final EditText ainput = findViewById(R.id.Ainput);
        final EditText aoutput = findViewById(R.id.Aoutput);
        final Button zero = findViewById(R.id.Azero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "0");
            }
        });
        final Button one = findViewById(R.id.Aone);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "1");
            }
        });
        final Button two = findViewById(R.id.Atwo);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "2");
            }
        });
        final Button three = findViewById(R.id.Athree);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "3");
            }
        });
        final Button four = findViewById(R.id.Afour);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "4");
            }
        });
        final Button five = findViewById(R.id.Afive);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "5");
            }
        });
        final Button six = findViewById(R.id.Asix);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "6");
            }
        });
        final Button seven = findViewById(R.id.Aseven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "7");
            }
        });
        final Button eight = findViewById(R.id.Aeight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "8");
            }
        });
        final Button nine = findViewById(R.id.Anine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ainput.setText(ainput.getText() + "9");
            }
        });
        final Button dot = findViewById(R.id.Adot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = ainput.getText().toString();
                if(str.length() == 0 ){
                    ainput.setText("0.");
                }
                else
                    ainput.setText(ainput.getText()+".");
            }
        });
        final Button pi = findViewById(R.id.Abin);
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ainput.setText(ainput.getText() + "3.14");
            }
        });

        Button clear = findViewById(R.id.Acls);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editext = findViewById(R.id.Ainput);
                EditText editext2 = findViewById(R.id.Aoutput);
                editext.setText("");
                editext2.setText("");
            }
        });
        Button back = findViewById(R.id.Aback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editext = findViewById(R.id.Ainput);
                String str = editext.getText().toString();
                if(str.equals(""))
                    editext.setText("");
                else
                    editext.setText(str.substring(0,str.length()-1));
            }
        });

        forinput = findViewById(R.id.forAinput);
        foroutput = findViewById(R.id.forAoutput);
        forinput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = ainput.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.mianji);
                flag = 0;
                if(jinzhi[position].equals("平方米")){
                    flag = 1;
                }
                else if(jinzhi[position].equals("英亩")){
                    flag = 2;
                }
                else if(jinzhi[position].equals("平方英尺")){
                    flag = 3;
                }
                else if(jinzhi[position].equals("顷")){
                    flag = 4;
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
                String front = ainput.getText().toString();
                String str = ainput.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.mianji);
                if(front.equals("")){
                    Toast.makeText(Area.this,"请输入", Toast.LENGTH_LONG).show();
                }
                else{
                    if(jinzhi[position].equals("平方米")){

                        switch(re){
                            case 1:aoutput.setText(front);break;
                            case 2:aoutput.setText(a2to1(front));break;
                            case 3:aoutput.setText(a3to1(front));break;
                            case 4:aoutput.setText(a4to1(front));break;
                        }
                    }
                    else if(jinzhi[position].equals("英亩")){
                        switch(re){
                            case 1:aoutput.setText(a1to2(front));break;
                            case 2:aoutput.setText(front);break;
                            case 3:aoutput.setText(a3to2(front));break;
                            case 4:aoutput.setText(a4to2(front));break;
                        }

                    }
                    else if(jinzhi[position].equals("平方英尺")){
                        switch(re){
                            case 1:aoutput.setText(a1to3(front));break;
                            case 2:aoutput.setText(a2to3(front));break;
                            case 3:aoutput.setText(front);break;
                            case 4:aoutput.setText(a4to3(front));break;
                        }
                    }
                    else if(jinzhi[position].equals("顷")){
                        switch(re){
                            case 1:aoutput.setText(a1to4(front));break;
                            case 2:aoutput.setText(a2to4(front));break;
                            case 3:aoutput.setText(a3to4(front));break;
                            case 4:aoutput.setText(front);break;

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
        return b*0.0002471054+"";
    }
    public static String a1to3(String a){
        double b = Double.parseDouble(a);
        return b*1.07639104167+"";
    }
    public static String a1to4(String a){
        double b = Double.parseDouble(a);
        return b*0.000015 +"";
    }


    public static String a2to1(String a){
        double b = Double.parseDouble(a);
        return b*4046.856 + "";
    }
    public static String a2to3(String a){
        double b = Double.parseDouble(a);
        return b*43559.9954533242 + "";
    }
    public static String a2to4(String a){
        double b = Double.parseDouble(a);
        return b*0.06070284 + "";
    }



    public static String a3to1(String a){
        double b = Double.parseDouble(a);
        return b*0.09290304 + "";
    }
    public static String a3to2(String a){
        double b = Double.parseDouble(a);
        return b*0.00002295684 + "";
    }
    public static String a3to4(String a){
        double b = Double.parseDouble(a);
        return b*0.0000013935456 + "";
    }


    public static String a4to1(String a){
        double b = Double.parseDouble(a);
        return b*66666.6666666 + "";
    }
    public static String a4to2(String a){
        double b = Double.parseDouble(a);
        return b*16.4736938 + "";
    }
    public static String a4to3(String a){
        double b = Double.parseDouble(a);
        return b*717594.0277806 + "";
    }





}
