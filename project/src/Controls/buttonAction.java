package Controls;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonAction implements ActionListener {
    private final JCheckBox CheckBox1;
    private final JCheckBox CheckBox2;
    private final JCheckBox CheckBox3;
    private final JTextField textField1;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JTextField textField4;
    private final JTextField textField5;
    private final JTextField textField6;
    private final JTextField textField7;
    private final JTextField textField8;
    private final JTextField textField9;
    private final JTextField textField10;
    private final JTextField textField11;
    private final JTextField textField12;
    private final JTextField textField13;
    private final JTextField textField14;
    private final JComboBox<String> comboBox1;
    private final JComboBox<String> comboBox2;
    private final JComboBox<String> comboBox3;
    private final JTextField pasec;
    private final JTextField pamin;
    private final JTextField pahrs;
    private final JTextField asec;
    private final JTextField amin;
    private final JTextField ahrs;


    double Top = 0, To = 0, Li = 0, Lvr = 0, L = 0, Lsh = 0, Sob = 0, Tpz,
            Tdop = 0, Tdod = 0, Torg, Tt = 0, Tp = 0, n = 1;

    public buttonAction(JCheckBox checkBox1, JCheckBox checkBox2, JCheckBox checkBox3,
                        JTextField textField1, JTextField textField2, JTextField textField3,
                        JTextField textField4, JTextField textField5, JTextField textField6, JTextField textField7,
                        JTextField textField8, JTextField textField9, JTextField textField10, JTextField textField11,
                        JTextField textField12, JTextField textField13, JTextField textField14,
                        JTextField pasec, JTextField pamin, JTextField pahrs, JTextField asec, JTextField amin, JTextField ahrs,
                        JComboBox<String> comboBox1, JComboBox<String> comboBox2, JComboBox<String> comboBox3){
        this.textField1 = textField1;
        this.textField2 = textField2;
        this.textField3 = textField3;
        this.textField4 = textField4;
        this.textField5 = textField5;
        this.textField6 = textField6;
        this.textField7 = textField7;
        this.textField8 = textField8;
        this.textField9 = textField9;
        this.textField10 = textField10;
        this.textField11 = textField11;
        this.textField12 = textField12;
        this.textField13 = textField13;
        this.textField14 = textField14;
        this.pasec = pasec;
        this.pamin = pamin;
        this.pahrs = pahrs;
        this.asec = asec;
        this.amin = amin;
        this.ahrs = ahrs;
        this.CheckBox1 = checkBox1;
        this.CheckBox2 = checkBox2;
        this.CheckBox3 = checkBox3;
        this.comboBox1 = comboBox1;
        this.comboBox2 = comboBox2;
        this.comboBox3 = comboBox3;
    }
    public double isProper(String line){
        try {
            return(Double.parseDouble(line));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Перевірте правильність значення в рядках\nError: " + e.getMessage(),
                    "Некоректно внесений елемент", JOptionPane.INFORMATION_MESSAGE);
            return(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (CheckBox2.isSelected()){
            Lvr = isProper(textField4.getText());
            L = isProper(textField5.getText());
            Lsh = isProper(textField6.getText());
            Li = Lvr + L + Lsh;
            textField3.setText(String.valueOf(Li));
            Sob = isProper(textField7.getText());
            To = Li/Sob;
            textField2.setText(String.valueOf(To));
        } else if (CheckBox1.isSelected()){
            Li = isProper(textField3.getText());
            Sob = isProper(textField7.getText());
            To = Li/Sob;
            textField2.setText(String.valueOf(To));
        } else{
            To = isProper(textField2.getText());
        }

        if (CheckBox3.isSelected()){
            Torg = isProper(textField10.getText());
            Tt = isProper(textField11.getText());
            Tdod = Torg + Tt;
            textField9.setText(String.valueOf(Tdod));
        } else {
            Tdod = isProper(textField9.getText());
        }
        try{
            n = Double.parseDouble(textField13.getText());
        } catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Кількість деталей n рівна 1. Перевірте правильність внесеної інформації",
                    "Некоректно внесений елемент", JOptionPane.INFORMATION_MESSAGE);
            n = 1;
        }


        double[][] arr = {
                //{0.25   0.5    1   3}   //маса, кг
                {0.05, 0.06, 0.06, 0.08}, //безключовий патрон
                {0.06, 0.07, 0.08, 0.1}, //самоцентруючий патрон із пневматичним кріпленням
                {0, 0.15, 0.17, 0.23}, //самоцентруючий патрон із ключовим кріпленням
                {0.07, 0.08, 0.09, 0.12}, //цанговий патрон із пневматичним зажимом
                {0.06, 0.08, 0.08, 0.12},  //цанговий патрон із рукояткою важеля
                {0.06+0.03*(n-1), 0.07+0.035*(n-1), 0.07+0.04*(n-1), 0.08+0.05*(n-1)}, //лещата із пневматичним затиском
                {0.06+0.03*(n-1), 0.07+0.035*(n-1), 0.08+0.04*(n-1), 0.09+0.05*(n-1)}, //лещата із ексцентриковим затиском
                {0.06+0.06*(n-1), 0.08+0.06*(n-1), 0.08+0.06*(n-1), 0.12+0.06*(n-1)}, //оправка, гладка, без кріплення
                {0.11+0.036+0.06*(n-1), 0.13+0.036+0.06*(n-1), 0.15+0.036+0.06*(n-1), 0.2+0.036+0.06*(n-1)}, //оправка, гладка, кріплення швидкоз'ємної шайби
                {0.1+0.06*(n-1), 0.12+0.06*(n-1), 0.13+0.06*(n-1), 0.19+0.06*(n-1)}, //оправка, різьбова
                {0.04, 0.04, 0.04, 0.04}, //до зубу долбяка, із підводом інструмента до деталі
                {0.040+0.026*(n-1), 0.045+0.029*(n-1), 0.05+0.033*(n-1), 0.06+0.04*(n-1)}, //в горизонтальну площину або призму
                {0.053+0.037*(n-1), 0.059+0.041*(n-1), 0.066+0.046*(n-1), 0.082+0.082*(n-1)}, //в горизонтальну площину або два пальці та вертикальну площину
                //робота з прутком
                //{    12 мм           20 мм          30 мм}        //діаметр прутка
                {0.2+0.11+0.01, 0.24+0.18+0.01, 0.3+0.28+0.01}, //пруток в патрон із пневматичним зажимом
                {0.2+0.12+0.12, 0.24+0.2+0.2, 0.3+0.3+0.3},  //пруток в патрон із рукояткою важеля
        };
        double[] arr2 = {160 + 4, 20.5+4, 5+2, 10+2};
        if ("Default".equals(comboBox1.getSelectedItem())){
            Tdop = isProper(textField8.getText());
        } else Tdop = arr[comboBox1.getSelectedIndex() - 1][comboBox2.getSelectedIndex()];
        Top = To + Tdop;
        textField1.setText(String.valueOf(Top));
        Tp = Top * 2 / 100;
        textField12.setText(String.valueOf(Tp));
        textField1.setText(String.valueOf(Top));
        if ("Default".equals(comboBox3.getSelectedItem())){
            Tpz = Top * 0.05;
        } else if("Custom".equals(comboBox3.getSelectedItem())){
            try {
                Tpz = isProper(textField14.getText());
            } catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Перевірте правильність внесеного значення в рядку\nError: " + exception.getMessage(),
                        "Некоректно введено елемент підготовчо-заключного часу", JOptionPane.INFORMATION_MESSAGE);
                Tpz = Top * 0.05;
            }
        }
        else {
            Tpz = arr2[comboBox3.getSelectedIndex() - 2];
        }
        double Trsk = Top * 1.2,
                Tn = Top + Tdod + Tp + Tpz / n;
        textField14.setText(String.valueOf(Tpz));
        pasec.setText(String.valueOf(Math.ceil((Trsk - (int)Trsk) * 60)));
        pamin.setText(String.valueOf((int)Trsk - 60 * (int)(Trsk / 60.0)));
        pahrs.setText(String.valueOf((int)Trsk / 60));
        asec.setText(String.valueOf(Math.ceil((Tn - (int)Tn) * 60)));
        amin.setText(String.valueOf((int)Tn - 60 * (int)(Tn / 60.0)));
        ahrs.setText(String.valueOf((int)Tn / 60));
    }
}