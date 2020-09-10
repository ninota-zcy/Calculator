package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Iterator;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDaoshu(View view) {
    }



    public void onClickjiecheng(View view) {
    }

    public void onClickClear(View view) {
    }

    public void onClickBack(View view) {
    }

    public void onClickKaigenhao(View view) {
    }

    public void onClickPingfang(View view) {
    }

    public void onClickMod(View view) {
    }

    public void onClickBaifenhao(View view) {
    }


    public void onClickLn(View view) {
    }

    /**
     * 数字
     * @param view
     */
    public void onClick0(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"0");
    }
    public void onClick1(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"1");
    }
    public void onClick2(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"2");
    }
    public void onClick3(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"3");
    }
    public void onClick4(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"4");
    }
    public void onClick5(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"5");
    }
    public void onClick6(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"6");
    }
    public void onClick7(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"7");
    }
    public void onClick8(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"8");
    }
    public void onClick9(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"9");
    }
    public void onClickDot(View view) {
        EditText edittext = findViewById(R.id.input);
        String str = edittext.getText().toString();
        if(str.length() == 0){
            edittext.setText("0.");
        }
        else
            edittext.setText(edittext.getText()+".");

    }

    /**
     * 基本运算符
     * @param view
     */
    public void onClickChu(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"/");
    }
    public void onClickCheng(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"*");
    }
    public void onClickJia(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"+");
    }
    public void onClickJian(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"-");
    }
    public void onClickXN(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"^");
    }

    public void onClickLog(View view) {
    }

    public void onClickSin(View view) {
    }

    public void onClickCos(View view) {
    }

    public void onClickPai(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"3.14");
    }


    public void onClickDengyu(View view) {
        EditText edittext = findViewById(R.id.input);
        String str = edittext.getText().toString();
        Log.i(TAG,str);
        int flag = 0;
        for(int i=0; i<str.length()-1; i++){
            if((str.charAt(i)<'0' || str.charAt(i)>'9')&& (str.charAt(i+1)<'0' || str.charAt(i+1)>'9')){
                flag = 1;
            }
        }
        Log.i(TAG,str+flag+str.length());
        if(str.length() == 0)
            Toast.makeText(MainActivity.this,"不能为空", Toast.LENGTH_LONG).show();
        if(flag == 1)
            Toast.makeText(MainActivity.this,"不能连续输入运算符", Toast.LENGTH_LONG).show();
        if(str.charAt(0)<'0' && str.charAt(0)>'9')
            Toast.makeText(MainActivity.this,"首字符不能为运算符", Toast.LENGTH_LONG).show();
        else{
            LinkedList<String> list=new LinkedList<>();
            for(int i=0; i<str.length(); i++) {
                list.add(str.charAt(i)+"");
            }
            String result = transferToPostfix(list);
            EditText outputt = findViewById(R.id.output);
            outputt.setText(result);

        }

    }

    //用于记录操作符
    private static LinkedList<String> operators=new LinkedList<>();
    //用于记录输出
    private static LinkedList<String> output=new LinkedList<>();
    //用于展示后缀表达式
    private static StringBuilder sb=new StringBuilder();



    //中缀表达式转为后缀表达式
    private static String transferToPostfix(LinkedList<String> list){
        Iterator<String> it=list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (isOperator(s)) {
                sb.append("#");
                if(operators.isEmpty()) {
                    operators.push(s);
                }
                else {
                    //如果读入的操作符为非")"且优先级比栈顶元素的优先级高或一样，则将操作符压入栈
                    if (priority(operators.peek())<=priority(s)&&!s.equals(")")) {
                        operators.push(s);
                    }
                    else if(!s.equals(")")&&priority(operators.peek())>priority(s)){
                        while (operators.size()!=0&&priority(operators.peek())>=priority(s)
                                &&!operators.peek().equals("(")) {
                            if (!operators.peek().equals("(")) {
                                String operator=operators.pop();
                                sb.append(operator).append("#");
                                output.push(operator);
                            }
                        }
                        operators.push(s);
                    }
                    //如果读入的操作符是")"，则弹出从栈顶开始第一个"("及其之前的所有操作符
                    else if (s.equals(")")) {
                        while (!operators.peek().equals("(")) {
                            String operator=operators.pop();
                            sb.append(operator).append("#");
                            output.push(operator);
                        }
                        //弹出"("
                        operators.pop();
                    }
                }
            }
            else if(!it.hasNext()) {
                sb.append(s).append("#");
                output.push(s);
            }
            //读入的为非操作符
            else {
                sb.append(s);
                output.push(s);
            }
        }
        if (!operators.isEmpty()) {
            Iterator<String> iterator=operators.iterator();
            while (iterator.hasNext()) {
                String operator=iterator.next();
                sb.append(operator).append(" ");
                output.push(operator);
                iterator.remove();
            }
        }
        StringBuilder sb2 = new StringBuilder();


        System.out.println("后缀： "+sb+"end");

        String[] strs=sb.toString().split("#");


        for(int i=0; i<strs.length; i++) {


                sb2.append(strs[i]).append(" ");


                sb2.append(strs[i]).append(" ");
            //Character.isDigit(strs[i]);
        }
        sb = sb2;
        return calculate();
        //Collections.reverse(output);
    }

    //根据后缀表达式计算结果
    private static String calculate(){
        LinkedList<String> mList=new LinkedList<>();
        String[] postStr=sb.toString().split(" ");

        for (String s:postStr) {
            if (isOperator(s)){
                if (!mList.isEmpty()){
                    double num1=Double.valueOf(mList.pop());
                    System.out.println("num1:"+ num1);
                    double num2=Double.valueOf(mList.pop());
                    System.out.println("num2:"+ num2);
                    if (s.equals("/")&&num1==0){
                        System.out.println("除数不能为0");

                    }
                    double newNum=cal(num2,num1,s);
                    System.out.println("中途："+newNum);
                    mList.push(String.valueOf(newNum));
                }
            }
            else {
                //数字则压入栈中
                mList.push(s);
                System.out.println(s);
            }
        }

        return mList.pop();

    }

    //判断是否操作符
    private static boolean isOperator(String oper){
        if (oper.equals("+")||oper.equals("-")||oper.equals("/")||oper.equals("*")
                ||oper.equals("(")||oper.equals(")")) {
            return true;
        }
        return false;
    }
    //计算操作符的优先级
    private static int priority(String s){
        switch (s) {
            case "+":return 1;
            case "-":return 1;
            case "*":return 2;
            case "/":return 2;
            case "(":return 3;
            case ")":return 3;
            default :return 0;
        }
    }

    private static double cal(double num2,double num1,String operator){
        switch (operator){
            case "+":return (double)(num2+num1);
            case "-":return (double)(num2-num1);
            case "*":return (double)(num2*num1);
            case "/":return (double)(num2/num1);
            default :return 0;
        }
    }



}
