import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class trickyCalculator extends JDialog {
    private JPanel contentPane;
    private JButton a7Button;
    private JButton ACButton;
    private JButton a8Button;
    private JButton a9Button;
    private JButton DELButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton addbutton;
    private JButton devidebutton;
    private JButton EXEButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton mutiplybutton;
    private JButton minusbutton;
    private JButton πButton;
    private JButton pointbutton;
    private JButton a0Button;
    //private JTextField
    // textPane1;
    private JButton logButton;
    private JButton lnButton;
    private JButton sinButton;
    private JButton cosButton;
    private JButton tanButton;
    private JButton squareButton;
    private JButton fabsButton;
    private JButton lsftbutton;
    private JButton rightbutton;
    private JButton x2Button;
    private JButton arctanButton;
    private JButton arccosButton;
    private JButton arcsinButton;
    //private JButton xsqrtButton;
    private JButton sqrtButton;
    private JButton eButton;
    private JButton ANSButton;
    private JTextPane textPane1;
    private JButton DECButton;
    private JButton integralButton;
    private JButton BINButton;
    private JButton OCTButton;
    private JButton HEXButton;
    private JButton aButton;
    private JButton fButton;
    private JButton cButton;
    private JButton eButton1;
    private JButton bButton;
    private JButton dButton;
    private JButton xButton1;
    private JPanel extraPanel;
    private JButton button1;
    private String store = new String();
    private String ans = new String();
    private String temp = new String();



    public trickyCalculator() {
        ans="0+";
        setContentPane(contentPane);
        setModal(true);
        setResizable(false);
        //contentPane.setName("trickyCalculator");
        textPane1.setEditable(false);
        textPane1.setPreferredSize(new Dimension(300,50));
        /*textPane1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                store+=e.getKeyText(e.getKeyCode());
                textPane1.setText(store);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });*/
        πButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="π";
                ans+="π";
                textPane1.setText(store);
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="1";
                ans+="1";
                textPane1.setText(store);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="2";
                ans+="2";
                textPane1.setText(store);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="3";
                ans+="3";
                textPane1.setText(store);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="4";
                ans+="4";
                textPane1.setText(store);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="5";
                ans+="5";
                textPane1.setText(store);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="6";
                ans+="6";
                textPane1.setText(store);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="7";
                ans+="7";
                textPane1.setText(store);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="8";
                ans+="8";
                textPane1.setText(store);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="9";
                ans+="9";
                textPane1.setText(store);
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="0";
                ans+="0";
                textPane1.setText(store);
            }
        });
        ACButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store="";
                ans="0+";
                textPane1.setText(store);
            }
        });
        DELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(store.length()>=6 && store.substring(store.length()-6,store.length()).equals("arcsin")){
                    store = store.substring(0,store.length()-6);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>=6 && store.substring(store.length()-6,store.length()).equals("arccos")){
                    store = store.substring(0,store.length()-6);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>=6 && store.substring(store.length()-6,store.length()).equals("arctan")){
                    store = store.substring(0,store.length()-6);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>=4 && store.substring(store.length()-4,store.length()).equals("abs(")){
                    store = store.substring(0,store.length()-4);
                    ans = ans.substring(0,ans.length()-2);
                }
                else if(store.length()>=3 && store.substring(store.length()-3,store.length()).equals("sin")){
                    store = store.substring(0,store.length()-3);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>=3 && store.substring(store.length()-3,store.length()).equals("cos")){
                    store = store.substring(0,store.length()-3);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>=3 && store.substring(store.length()-3,store.length()).equals("tan")){
                    store = store.substring(0,store.length()-3);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>=3 && store.substring(store.length()-3,store.length()).equals("log")){
                    store = store.substring(0,store.length()-3);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>=2 && store.substring(store.length()-2,store.length()).equals("ln")){
                    store = store.substring(0,store.length()-2);
                    ans = ans.substring(0,ans.length()-1);
                }
                else if(store.length()>0){
                    store = store.substring(0,store.length()-1);
                    ans = ans.substring(0,ans.length()-1);
                }
                textPane1.setText(store);
            }
        });
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="+";
                ans+="+";
                textPane1.setText(store);
            }
        });
        minusbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="-";
                ans+="-";
                textPane1.setText(store);
            }
        });
        mutiplybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="×";
                ans+="*";
                textPane1.setText(store);
            }
        });
        devidebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="÷";
                ans+="/";
                textPane1.setText(store);
            }
        });
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="log";
                ans+="l";
                textPane1.setText(store);
            }
        });
        lnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="ln";
                ans+="n";
                textPane1.setText(store);
            }
        });
        sinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="sin";
                ans+="s";
                textPane1.setText(store);
            }
        });
        cosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="cos";
                ans+="c";
                textPane1.setText(store);
            }
        });
        tanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="tan";
                ans+="t";
                textPane1.setText(store);
            }
        });
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="^";
                ans+="^";
                textPane1.setText(store);
            }
        });
        fabsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="abs(";
                ans+="a(";
                textPane1.setText(store);
            }
        });
        lsftbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="(";
                ans+="(";
                textPane1.setText(store);
            }
        });
        rightbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+=")";
                ans+=")";
                textPane1.setText(store);
            }
        });
        x2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="^2";
                ans+="^2";
                textPane1.setText(store);
            }
        });
        arccosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="arccos";
                ans+="w";
                textPane1.setText(store);
            }
        });
        arcsinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="arcsin";
                ans+="q";
                textPane1.setText(store);
            }
        });
        arctanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="arctan";
                ans+="m";
                textPane1.setText(store);
            }
        });
        sqrtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="√";
                ans+="p";
                textPane1.setText(store);
            }
        });
        eButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="e";
                ans+="e";
                textPane1.setText(store);
            }
        });
        EXEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean judge = false;
                Main calc = new Main();
                String answer = new String();
                try{
                    answer = calc.Calculate(ans);
                }catch (Exception fuck){
                    textPane1.setText("您的输入非法！");
                    System.out.println("error");
                    store="";
                    ans="";
                    judge = true;
                }
                if(!judge) {
                    textPane1.setText(store + "\n=" + answer);
                    judge = false;
                }
                temp = answer;
                store = "";
                ans = "0+";

            }
        });
        pointbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+=".";
                ans+=".";
                textPane1.setText(store);
            }
        });
        ANSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPane1.setText(temp);
                //System.out.println(temp);
                store+=temp;
                ans+=temp;
            }
        });
        OCTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberBaseConversion trans = new numberBaseConversion(ans);
                try{
                    textPane1.setText(store + "\n=" + trans.convert(10,8));
                    temp = trans.convert(10,8);
                }catch (Exception tran){
                    textPane1.setText("您的输入非法！");
                }
                store = "";
                ans = "";
            }
        });
        BINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberBaseConversion trans = new numberBaseConversion(ans);
                try{
                    textPane1.setText(store + "\n=" + trans.convert(10,2));
                    temp = trans.convert(10,2);
                }catch (Exception tran){
                    textPane1.setText("您的输入非法！");
                }
                store = "";
                ans = "";
            }
        });
        HEXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberBaseConversion trans = new numberBaseConversion(ans);
                try{
                    textPane1.setText(store + "\n=" + trans.convert(10,16));
                    temp = trans.convert(10,2);
                }catch (Exception tran){
                    textPane1.setText("您的输入非法！");
                }
                store = "";
                ans = "";
            }
        });
        DECButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ans.charAt(1) == ',') {
                    char t = ans.charAt(0);
                    ans = ans.substring(2, ans.length());
                    numberBaseConversion trans = new numberBaseConversion(ans);
                    //System.out.println((int)ans.charAt(0)-'0');
                    try {
                        textPane1.setText(store + "\n=" + trans.convert((int)(t)-'0',10));
                        temp = trans.convert((int)(t)-'0',10);
                    } catch (Exception tran) {
                        textPane1.setText("您的输入非法！");
                    }
                    store = "";
                    ans = "";
                }
                else{
                    char t  = ans.charAt(1);
                    ans = ans.substring(3, ans.length());
                    numberBaseConversion trans = new numberBaseConversion(ans);
                    try {
                        textPane1.setText(store + "\n=" + trans.convert(10+(int)(t)-'0', 10));
                        temp = trans.convert(10+(int)(t)-'0', 10);
                    } catch (Exception tran) {
                        textPane1.setText("您的输入非法！");
                    }
                    store = "";
                    ans = "";
                }
            }
        });
        integralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                definiteIntegral integ = new definiteIntegral(ans);
                try{
                    textPane1.setText(store + "\n=" + integ.cal());
                    temp = integ.cal();
                }catch (Exception un){
                    textPane1.setText("您的输入非法！");
                }
                store = "";
                ans = "";
            }
        });
        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="A";
                ans+="A";
                textPane1.setText(store);
            }
        });
        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="B";
                ans+="B";
                textPane1.setText(store);
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="C";
                ans+="C";
                textPane1.setText(store);
            }
        });
        dButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="D";
                ans+="D";
                textPane1.setText(store);
            }
        });
        eButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="E";
                ans+="E";
                textPane1.setText(store);
            }
        });
        fButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="F";
                ans+="F";
                textPane1.setText(store);
            }
        });
        xButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+="x";
                ans+="x";
                textPane1.setText(store);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                store+=",";
                ans+=",";
                textPane1.setText(store);
            }
        });
    }

    public static void main(String[] args) {
        trickyCalculator dialog = new trickyCalculator();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
