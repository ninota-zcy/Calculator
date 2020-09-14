package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {



    private static final String TAG = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickDaoshu(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{


            double result = Double.parseDouble(str);

            editext2.setText(format(1/result));
        }

    }



    public void onClickjiecheng(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            if(!isInteger(str)){
                Toast.makeText(MainActivity.this,"请输入整数", Toast.LENGTH_LONG).show();
            }else{
                int re = Integer.parseInt(str);
                System.out.println(re);
                int count = re;
                int result = 1;
                for(int i=0; i<re; i++){
                    result *= count;
                    count --;
                }
                editext2.setText(result+"");
            }

        }

    }

    public void onClickClear(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        editext.setText("");
        editext2.setText("");
    }

    public void onClickBack(View view) {
        EditText editext = findViewById(R.id.input);
        String str = editext.getText().toString();
        if(str.equals(""))
            editext.setText("");
        else
            editext.setText(str.substring(0,str.length()-1));
    }

    public void onClickKaigenhao(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);

            editext2.setText(Math.sqrt(re)+"");
        }

    }


    public void onClickPingfang(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);

            editext2.setText(format(re*re));
        }

    }

    public double abs(double a){
        return a>0?a:-a;
    }
    public void onClickMod(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);

            editext2.setText(abs(re)+"");
        }

    }

    public void onClickBaifenhao(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);

            editext2.setText(re*100+"%");
        }

    }


    public void onClickLn(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);
            if(re == 0){
                Toast.makeText(MainActivity.this,"不能为0", Toast.LENGTH_LONG).show();
            }else{
                editext2.setText(Math.log(re)+"");
            }
        }

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
    public void onClickZuo(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"(");
    }
    public void onClickYou(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+")");
    }
    public void onClickXN(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"^");
    }

    public void onClickLog(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);
            if(re == 0){
                Toast.makeText(MainActivity.this,"不能为0", Toast.LENGTH_LONG).show();
            }else{
                editext2.setText(Math.log10(re)+"");
            }
        }

    }

    public void onClickSin(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);

            double a = Math.toRadians(re);
            editext2.setText(Math.sin(a)+"");
        }


    }

    public void onClickCos(View view) {
        EditText editext = findViewById(R.id.input);
        EditText editext2 = findViewById(R.id.output);
        String str = editext.getText().toString();
        if(str.equals("") || str.length() == 0) {

            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
        }else{
            double re = Double.parseDouble(str);
            double a = Math.toRadians(re);
            editext2.setText(Math.cos(a)+"");
        }

    }

    public void onClickPai(View view) {
        EditText edittext = findViewById(R.id.input);
        edittext.setText(edittext.getText()+"3.14");
    }


    public void onClickDengyu(View view) {
        EditText edittext = findViewById(R.id.input);
        EditText edittext2 = findViewById(R.id.output);
        String str = edittext.getText().toString();
        Log.i(TAG,str);
        int flag = 0;
        if(str.length() >= 2){
            for(int i=0; i<str.length()-1; i++){
                if(((str.charAt(i)<'0' || str.charAt(i)>'9')&& (str.charAt(i+1)<'0' || str.charAt(i+1)>'9')) && ((str.charAt(i) != '(' && str.charAt(i) != ')') &&(str.charAt(i+1) != '(' && str.charAt(i+1) != ')'))){
                    flag = 1;
                    break;
                }
            }
        }
        try{
        Log.i(TAG,str+flag+str.length());

            if(str.equals("") || str.length() == 0) {
                edittext.setText("");
                Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_LONG).show();
            }
            else if(flag == 1)
                Toast.makeText(MainActivity.this,"不能连续输入运算符", Toast.LENGTH_LONG).show();
            else if(!Character.isDigit(str.charAt(0)) && str.charAt(0) != '(' && str.charAt(0) != ')')
                Toast.makeText(MainActivity.this,"首字符不能为运算符", Toast.LENGTH_LONG).show();
            else if(str.contains("#")){
                String[] list = str.split("#");
                double num1 = Double.parseDouble(list[0]);
                double num2 = Double.parseDouble(list[1]);
                edittext2.setText(format(Math.pow(num1, num2))+"");
            }
            else{

                LinkedList<String> list=new LinkedList<>();
                for(int i=0; i<str.length(); i++) {
                    list.add(str.charAt(i)+"");
                }
                String result = transferToPostfix(list);
                double ree = Double.parseDouble(result);
                String re = format(ree);

                edittext2.setText(re);
                }

            }
        catch(Exception e){
            Toast.makeText(MainActivity.this,"ERROR", Toast.LENGTH_LONG).show();
        }


    }



    /**
     * 使用BigDecimal，保留小数点后两位
     */
    public static String format(double value) {

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }

    //用于记录操作符
    private static LinkedList<String> operators=new LinkedList<>();
    //用于记录输出
    private static LinkedList<String> output=new LinkedList<>();
    //用于展示后缀表达式
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        for(int i=0; i<str.length(); i++) {
            list.add(str.charAt(i)+"");
        }
        String result = transferToPostfix(list);
        System.out.println(result);
    }

    //中缀表达式转为后缀表达式
    private static String transferToPostfix(LinkedList<String> list){
        Iterator<String> it=list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (isOperator(s)) {
                sb.append("#");
                if (operators.isEmpty()) {
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
                sb.append(operator).append("#");
                output.push(operator);
                iterator.remove();
            }
        }
        System.out.println("后缀： "+sb);
        StringBuilder sb2 = new StringBuilder();



        String[] strs=sb.toString().split("#");
        for(int i=0; i<strs.length; i++) {
            System.out.println(strs[i]);
        }

        for(int i=0; i<strs.length; i++) {

            if(!strs[i].equals("")) {
                System.out.print(strs[i]+"||");
                sb2.append(strs[i]).append(" ");
            }


        }
        System.out.print("sb2: "+sb2);
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
                    double num1=Double.parseDouble(mList.pop());
                    BigDecimal num111 = new BigDecimal(num1);
                    System.out.println("num1:"+ num1);
                    double num2=Double.parseDouble(mList.pop());
                    BigDecimal num222 = new BigDecimal(num2);
                    System.out.println("num2:"+ num2);
                    if (s.equals("/")&&num1==0){
                        System.out.println("除数不能为0");

                    }
                    double newNum=cal(num222,num111,s);
                    System.out.println("中途："+newNum);
                    mList.push(String.valueOf(newNum));
                }
            }
            else {
                //数字则压入栈中
                mList.push(s);
            }
        }
        return mList.pop();
    }

    //判断是否操作符
    private static boolean isOperator(String oper){
        if (oper.equals("+")||oper.equals("-")||oper.equals("/")||oper.equals("*")
                ||oper.equals("(")||oper.equals(")")||oper.equals("^")) {
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
            case "^":return 4;
            default :return 0;
        }
    }
    //判断字符串是否为整数
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    private static double cal(BigDecimal num222,BigDecimal num111,String operator){
        switch (operator){
            case "+":return num222.add(num111).doubleValue();
            case "-":return num222.subtract(num111).doubleValue();
            case "*":return num111.multiply(num222).doubleValue();
            case "/":return num222.divide(num111,10,BigDecimal.ROUND_HALF_UP).doubleValue();
            case "^":return Math.pow(num222.doubleValue(), num111.doubleValue());
            default :return 0;
        }
    }



}
