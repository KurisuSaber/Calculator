import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Stack;
import java.math.*;

public class Main {
    private DecimalFormat df = new DecimalFormat("0.00000000");

    public String Calculate(String input) {
        //Scanner sc = new Scanner(System.in);
        String str1 = input;
        Stack<String> operatorStack = new Stack<String>();
        Stack<String> elementStack = new Stack<String>();

        ArrayList<String> strList = new ArrayList<String>();

        String str2 = "";
        int flag = 1;
        for (int i = 0; i < str1.length();i++)
            if (Character.isDigit(str1.charAt(i))) {
                flag = 0;
                str2 += String.valueOf(str1.charAt(i));
                if (i == str1.length() - 1)
                    strList.add(str2);
            }
            else if (str1.charAt(i) == 'e'){
                strList.add("2.718281828");
                flag = 1;
            }
            else if (str1.charAt(i) == 'π'){
                strList.add("3.141592654");
                flag = 1;
            }
            else if (str1.charAt(i) == 'a' && str1.charAt(i+2) == '-'){
                if (flag == 0){
                    strList.add(str2);
                    str2 = "";
                }
                strList.add("0");
                strList.add("a");
                strList.add("(");
                i+=1;
                flag = 1;
            }
            else if (str1.charAt(i) == '.'){

                StringBuffer temp = new StringBuffer();
                /*int k=i;
                while(Character.isDigit(strList.get(k).charAt(0))){
                  temp.append(strList.get(k));
                  strList.remove(k);
                  k--;
                }
                temp.reverse();*/
                temp.append(str2);
                temp.append('.');
                int j=i+1;
                for(j=i+1;j<str1.length() && Character.isDigit(str1.charAt(j));j++){
                  temp.append(str1.charAt(j));
                }
                strList.add(temp.toString());
                i=j-1;
                str2="";
                flag=1;
            }
            else{
                if (flag == 0){
                    strList.add(str2);
                    str2 = "";
                    flag = 1;
                }
                strList.add(String.valueOf(str1.charAt(i)));
            }

        System.out.println(strList);
        //遍历strList集合,生成逆波兰表达式的过程

        for (String s:strList){
            if (Character.isDigit(s.charAt(0)))
                elementStack.push(s);
            else if (s.equals("("))
                operatorStack.push(s);
            else if (s.equals(")")) {
                String temp = "";
                do {
                    temp = operatorStack.pop();
                    if (!temp.equals("("))
                        elementStack.push(temp);
                } while (!temp.equals("("));
            }
            else{
                if (operatorStack.empty())
                    operatorStack.push(s);
                else if (operatorStack.peek().equals("(") || operatorStack.peek().equals(")"))
                    operatorStack.push(s);
                else if (priority(s,operatorStack.peek()))
                    operatorStack.push(s);
                else {
                    while((!operatorStack.empty()) && (!priority(s,operatorStack.peek())))
                    {
                        elementStack.push(operatorStack.pop());
                    }
                    operatorStack.push(s);
                }
            }
        }
        System.out.println(operatorStack);
        System.out.println(elementStack);

        while (!operatorStack.empty()) {
            elementStack.push(operatorStack.pop());
        }
        ArrayList<String> str2List = new ArrayList<String>();
        Stack<String> swapStack = new Stack<String>();

        while(!elementStack.empty()){
            swapStack.push(elementStack.pop());
        }
        while (!swapStack.empty()){
            str2List.add(swapStack.pop());
        }
        System.out.println(operatorStack);
        System.out.println(elementStack);

        System.out.println(str2List);
        Stack<String> st1 = new Stack<String>();
        for (String s:str2List){
            if (Character.isDigit(s.charAt(0))){
                st1.push(s);
            }
            else if (s.equals(".")){
                String left = st1.pop();
                //System.out.println(left);
                String right = st1.pop();
                //System.out.println(right);
                double leftDTemp = Double.valueOf(left);
                int leftInt = (int) leftDTemp;
                String cntStr = Integer.toString(leftInt);
                Double ret = Double.valueOf(right) + (Double.valueOf(left)/Math.pow(10,cntStr.length()));
                //System.out.println(ret);
                st1.push(Double.toString(ret));
            }
            else if (s.equals("+")){
                String left = st1.pop();
                double ret = 0;
                String right = "";
                try{
                    right = st1.pop();
                }catch(Exception e){
                    right = "0";
                }
                ret = Double.valueOf(left) + Double.valueOf(right);
                st1.push(df.format(ret));
            }
            else if (s.equals("-")){
                //boolean err = false;
                String left = st1.pop();
                double ret = 0;
                String right = "";
                //try{
                    right = st1.pop();
                //}catch(Exception e){
                    //right = "0";
                //}
                //if (!err){
                    ret = Double.valueOf(right) - Double.valueOf(left);
                //}
                st1.push(df.format(ret));
                //err = false;
            }
            else if (s.equals("*")){
                String left = st1.pop();
                String right = st1.pop();
                Double ret = Double.valueOf(right) * Double.valueOf(left);
                st1.push(df.format(ret));
            }
            else if (s.equals("/")){
                String left = st1.pop();
                String right = st1.pop();
                Double ret = Double.valueOf(right) / Double.valueOf(left);
                st1.push(df.format(ret));
            }
            else if (s.equals("l")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.log10(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("n")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.log(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("a")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.abs(Double.valueOf(right));
                st1.push(df.format(ret));
            }
            else if (s.equals("s")){
                //String left = st1.pop();
                String right = st1.pop();
                //System.out.println(Double.valueOf(right));
                //System.out.println(Math.toDegrees(Double.valueOf(right)));
                Double ret = Math.sin(Double.valueOf(right));
                //System.out.println(ret);
                //System.out.println(Math.sin(Math.PI));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(Double.toString(ret));
            }
            else if (s.equals("c")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.cos(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("t")){
                //String left = st1.pop();
                String right = st1.pop();
                //System.out.println(right);
                if(Double.valueOf(right)%1.570796327==0){
                    return "输入错误！";
                }
                Double ret = Math.tan(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("q")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.asin(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("w")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.acos(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("m")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.atan(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("p")){
                //String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.sqrt(Double.valueOf(right));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else if (s.equals("^")){
                String left = st1.pop();
                String right = st1.pop();
                Double ret = Math.pow(Double.valueOf(right),Double.valueOf(left));
                if(Math.abs(ret) <= 1E-9){
                    ret=0.0;
                }
                st1.push(df.format(ret));
            }
            else
                System.exit(-1);
        }
        String ss = st1.pop();
        System.out.println(ss);
        return ss;
        //System.out.println("true");
    }

    public static boolean priority(String str1,String str2){
        if (str2.equals(".") && str1.equals("^"))
            return false;
        if (str1.equals("l")  ||str1.equals("n")  ||str1.equals("a")  ||str1.equals("s")  ||
        str1.equals("c")  ||str1.equals("t")  ||str1.equals("q")  ||str1.equals("w")  ||
        str1.equals("e")  ||str1.equals("p") || str1.equals("^"))
            return true;
        if ((str1.equals("*")  || str1.equals("/")) &&(str2.equals("+") || str2.equals("-")))
            return true;
        else if (str1.equals(str2))
            return false;
        else if ((str1.equals("+") || str1.equals("-")) && ((str2.equals("+") || str2.equals("-"))))
            return false;
        else if ((str1.equals("*") || str1.equals("/")) && ((str2.equals("*") || str2.equals("/"))))
            return false;
        else
            return false;
    }
}
