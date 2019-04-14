import java.text.DecimalFormat;

//定积分
class definiteIntegral {
    private Main calc = new Main();
    private double left;
    private double right;
    private String OriEqu = new String();
    private String equation;
    public definiteIntegral(String OriEqu) {
        this.OriEqu = OriEqu;
    }

    private void saperate() {
        StringBuffer tempEqu = new StringBuffer("");                //不能像String那样直接 类型名 对象名 = ""，要按照创建实例化对象的格式实例化StringBuffer对象
        int countComma = 0;
        for (int i = 0; i < OriEqu.length(); i++) {               //左区间
            if (countComma == 0 && OriEqu.charAt(i) == ',') {
                left = Double.valueOf(calc.Calculate(tempEqu.toString()));
                tempEqu.delete(0, tempEqu.length());            //清空字符串数组
                countComma = 1;
            } else if (countComma == 0 && OriEqu.charAt(i) != ',') {
                tempEqu.append(OriEqu.charAt(i));
            } else if (countComma == 1 && OriEqu.charAt(i) == ',') {  //识别右区间
                right = Double.valueOf(calc.Calculate(tempEqu.toString()));
                tempEqu.delete(0, tempEqu.length());            //清空字符串数组
                countComma = 2;
            } else if (countComma == 1 && OriEqu.charAt(i) != ',') {
                tempEqu.append(OriEqu.charAt(i));
            } else {                                                     //方程式本体
                tempEqu = tempEqu.append(OriEqu.charAt(i));
            }
        }
        equation = tempEqu.toString();
    }

    public String convert(double x) {                              //将方程代入参数
        DecimalFormat df = new DecimalFormat("0.00000");        //将数字格式化，避免科学计数法的出现
        StringBuffer tempEqu = new StringBuffer();                  //不能像String那样直接 类型名 对象名 = ""，要按照创建实例化对象的格式实例化StringBuffer对象
        String tempNum = df.format(x);
        for (int i = 0; i < equation.length(); i += 1) {               //左区间
            if (equation.charAt(i) == 'x') {                        //方程式本体
                tempEqu.append(tempNum);
            } else if (equation.charAt(i) != 'x') {
                tempEqu.append(equation.charAt(i));
            }
        }
        return tempEqu.toString();  //当数字比较小的时候（如0.0000001），他会采用科学计数法计数，1.0E-4,放进calc里运算当然会出错
    }

    public String cal() throws Exception {                                  //辛普森近似，(b-a)/(3*n)*(y[0]+y[n]+4*(y[1]+y[3]+...+y[n-1])+2*(y[2]+y[4]+...+y[n-2]))
        saperate();                                                         //separate()之后才可以用到正确值的left和right
        int count = 100000;
        double STEP = (right - left) / count;
        if (right - left < 0) {
            throw new Exception();
        } else if (right == left) {
            return "0.0";
        } else {
            double answer = 0;

            double[] x = new double[count];

            x[0] = left;
            for (int i = 1; i < x.length; i++) {
                x[i] = x[i-1] + STEP;
            }
            for (int i = 0; i < x.length; i++) {
                if (i == 0 || i == x.length - 1) {                                      //y[0]+y[n]
                    answer += Double.valueOf(calc.Calculate(convert(x[i])));
                } else if (i % 2 == 0) {                                                //2*(y[2]+y[4]+...+y[n-2])
                    answer += 2 * Double.valueOf(calc.Calculate(convert(x[i])));
                } else {                                                                //4*(y[1]+y[3]+...+y[n-1])
                    answer += 4 * Double.valueOf(calc.Calculate(convert(x[i])));
                }
            }
            answer *= STEP / 3;
            return String.format("%.4f", answer);
        }
    }
}


//进制转换

class numberBaseConversion {
    private String equation = "";

    public numberBaseConversion(String equation) {
        this.equation = equation;
    }

    public long Decimal(char x) {
        switch (x) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return 999;                           //其他字符则令其值大于ToBase，抛出异常
        }
    }

    public String convert(long OriBase, long ToBase) throws Exception {        //OriBase是原进制，ToBase是要转换成的进制
        long OriNum = 0;
        StringBuffer answer = new StringBuffer("");
        if (OriBase <= 1 || OriBase > 16) {                                     //不合法的进制
            throw new Exception();
        }
        for (int i = 0; i < equation.length(); i++) {
            if (Decimal(equation.charAt(i)) >= OriBase) {                     //不合法的输入
                throw new Exception();
            } else {
                OriNum = OriNum * OriBase + Decimal(equation.charAt(i));
            }
        }
        if (OriNum == 0) return "0";
        else {
            while (OriNum > 0) {
                if (OriNum % ToBase < 10) {
                    answer.append((char) (OriNum % ToBase + 48));
                } else {
                    answer.append((char) (OriNum % ToBase + 55));
                }
                OriNum /= ToBase;
            }
            answer.reverse();
            return answer.toString();
        }
    }
}
