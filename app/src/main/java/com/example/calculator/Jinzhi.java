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

import static com.example.calculator.MainActivity.activityList;


public class Jinzhi extends AppCompatActivity {

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
                Intent intent = new Intent(Jinzhi.this,MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.length:{
                Intent intent = new Intent(Jinzhi.this,Changdu.class);
                startActivity(intent);
                break;
            }
            case R.id.area:{
                Intent intent = new Intent(Jinzhi.this,Area.class);
                startActivity(intent);
                break;
            }

            case R.id.help:{
                Intent intent = new Intent(Jinzhi.this,Help.class);
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
        setContentView(R.layout.activity_jinzhi);
        activityList.add(this);
        final EditText jinzhiinput = findViewById(R.id.jinzhiinput);
        final EditText jinzhioutput = findViewById(R.id.jinzhioutput);
        final Button zero = findViewById(R.id.jinzhizero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "0");
            }
        });
        final Button one = findViewById(R.id.jinzhione);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "1");
            }
        });
        final Button two = findViewById(R.id.jinzhitwo);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "2");
            }
        });
        final Button three = findViewById(R.id.jinzhithree);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "3");
            }
        });
        final Button four = findViewById(R.id.jinzhifour);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "4");
            }
        });
        final Button five = findViewById(R.id.jinzhifive);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "5");
            }
        });
        final Button six = findViewById(R.id.jinzhisix);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "6");
            }
        });
        final Button seven = findViewById(R.id.jinzhiseven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "7");
            }
        });
        final Button eight = findViewById(R.id.jinzhieight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "8");
            }
        });
        final Button nine = findViewById(R.id.jinzhinine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jinzhiinput.setText(jinzhiinput.getText() + "9");
            }
        });


        final Button a = findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jinzhiinput.setText(jinzhiinput.getText() + "A");
            }
        });
        final Button b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jinzhiinput.setText(jinzhiinput.getText() + "B");
            }
        });
        final Button c = findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jinzhiinput.setText(jinzhiinput.getText() + "C");
            }
        });
        final Button d = findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jinzhiinput.setText(jinzhiinput.getText() + "D");
            }
        });
        final Button e = findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jinzhiinput.setText(jinzhiinput.getText() + "E");
            }
        });
        final Button f = findViewById(R.id.f);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jinzhiinput.setText(jinzhiinput.getText() + "F");
            }
        });
        Button clear = findViewById(R.id.jinzhicls);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editext = findViewById(R.id.jinzhiinput);
                EditText editext2 = findViewById(R.id.jinzhioutput);
                editext.setText("");
                editext2.setText("");
            }
        });
        Button back = findViewById(R.id.jinzhiback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editext = findViewById(R.id.jinzhiinput);
                String str = editext.getText().toString();
                if(str.equals(""))
                    editext.setText("");
                else
                    editext.setText(str.substring(0,str.length()-1));
            }
        });

        forinput = findViewById(R.id.forjinzhiinput);
        foroutput = findViewById(R.id.forjinzhioutput);
        forinput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                f.setEnabled(true);
                e.setEnabled(true);
                d.setEnabled(true);
                c.setEnabled(true);
                b.setEnabled(true);
                a.setEnabled(true);
                zero.setEnabled(true);
                one.setEnabled(true);
                two.setEnabled(true);
                three.setEnabled(true);
                four.setEnabled(true);
                five.setEnabled(true);
                six.setEnabled(true);
                seven.setEnabled(true);
                eight.setEnabled(true);
                nine.setEnabled(true);

                String str = jinzhiinput.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.jinzhiarray);
                flag = 0;
                if(jinzhi[position].equals("二进制")){
                    flag = 2;
                    f.setEnabled(false);
                    e.setEnabled(false);
                    d.setEnabled(false);
                    c.setEnabled(false);
                    b.setEnabled(false);
                    a.setEnabled(false);
                    two.setEnabled(false);
                    three.setEnabled(false);
                    four.setEnabled(false);
                    five.setEnabled(false);
                    six.setEnabled(false);
                    seven.setEnabled(false);
                    eight.setEnabled(false);
                    nine.setEnabled(false);


                }
                else if(jinzhi[position].equals("八进制")){
                    flag = 8;
                    f.setEnabled(false);
                    e.setEnabled(false);
                    d.setEnabled(false);
                    c.setEnabled(false);
                    b.setEnabled(false);
                    a.setEnabled(false);
                    eight.setEnabled(false);
                    nine.setEnabled(false);


                }
                else if(jinzhi[position].equals("十进制")){
                    flag = 10;
                    f.setEnabled(false);
                    e.setEnabled(false);
                    d.setEnabled(false);
                    c.setEnabled(false);
                    b.setEnabled(false);
                    a.setEnabled(false);

                }
                else if(jinzhi[position].equals("十六进制")){
                    flag = 16;


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
                String front = jinzhiinput.getText().toString();
                String str = jinzhiinput.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.jinzhiarray);
                if(front.equals("")){
                    Toast.makeText(Jinzhi.this,"请输入", Toast.LENGTH_LONG).show();
                }
                else{
                    if(jinzhi[position].equals("二进制")){

                        switch(re){
                            case 2:jinzhioutput.setText("2to2:"+front);break;

                            case 8:jinzhioutput.setText("8to2:"+a8to2(front));break;
                            case 10:jinzhioutput.setText("10to2:"+a10to2(front));break;
                            case 16:jinzhioutput.setText("16to2:"+a16to2(front));break;
                        }
                    }
                    else if(jinzhi[position].equals("八进制")){
                        switch(re){
                            case 2:jinzhioutput.setText("2-8:"+a2to8(front));break;
                            case 8:jinzhioutput.setText("8-8:"+front);break;
                            case 10:jinzhioutput.setText("10-8:"+a10to8(front));break;
                            case 16:jinzhioutput.setText("16-8:"+a16to8(front));break;
                        }

                    }
                    else if(jinzhi[position].equals("十进制")){
                        switch(re){
                            case 2:jinzhioutput.setText("2-10:"+a2to10(front));break;
                            case 8:jinzhioutput.setText("8-10:"+a8to10(front));break;
                            case 10:jinzhioutput.setText("10-10:"+front);break;
                            case 16:jinzhioutput.setText("16-10:"+a16to10(front));break;
                        }
                    }
                    else if(jinzhi[position].equals("十六进制")){
                        switch(re){
                            case 2:jinzhioutput.setText("2-16:"+a2to16(front));break;
                            case 8:jinzhioutput.setText("8-16:"+a8to16(front));break;
                            case 10:jinzhioutput.setText("10-16:"+a10to16(front));break;
                            case 16:jinzhioutput.setText("16-16:"+front);break;

                        }
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /**
     * 所有进制转换
     * @param a
     * @return
     */
    public static String a2to8(String a){
        return Integer.toOctalString(Integer.parseInt(a, 2))+"";
    }
    public static String a2to10(String a){
        return Integer.parseInt(a, 2) +"";
    }
    public static String a2to16(String a){
            return Integer.toHexString(Integer.parseInt(a, 2))+"";
    }
    public static String a8to2(String a){
            return Integer.toBinaryString(Integer.parseInt(a, 8));
    }
    public static String a8to10(String a){
            return Integer.toString(Integer.parseInt(a, 8));
    }
    public static String a8to16(String a){
            return Integer.toHexString(Integer.parseInt(a, 8));
    }
    public static String a10to2(String a){
            return Integer.toBinaryString(Integer.parseInt(a));
    }
    public static String a10to8(String a){
        return Integer.toOctalString(Integer.parseInt(a));
    }
    public static String a10to16(String a){
        return Integer.toHexString(Integer.parseInt(a));
    }
    public static String a16to2(String a){
        return Integer.toBinaryString(Integer.parseInt(a,16));
    }
    public static String a16to8(String a){
        return Integer.toOctalString(Integer.parseInt(a,16));
    }
    public static String a16to10(String a){
        return Integer.toString(Integer.parseInt(a,16))+"";
    }
}