package Interface;

import Controls.buttonAction;
import Controls.checkBoxAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main extends JFrame{
    private final int WINDOW_X = 1660;
    private final int WINDOW_Y = 600;
    //private final int BOARD_PADDING = 50;
    //private final int BOARD_X_AND_Y = 576;
    //private final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0, 150, 136);
    //private final Color BOARD_BACKGROUND_COLOR = Color.rgb(224, 242, 241);
    private final String TITLE = "Розрахунок технічно-обґрунтованих норм часу";
    private JPanel mainPanel;
    private JLabel Label1;
    private JLabel Label2;
    private JButton button1;
    private JCheckBox CheckBox1;
    private JCheckBox CheckBox2;
    private JCheckBox CheckBox3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JLabel weight_label;
    private JTextField asec;
    private JTextField pasec;
    private JTextField amin;
    private JTextField pamin;
    private JTextField ahrs;
    private JTextField pahrs;
    private JTextField textField14;

    private JMenuBar menuBar = new JMenuBar();

    public Main() { //Constructor
        init();
        CheckBox1.addActionListener(new checkBoxAction(CheckBox1, CheckBox2, CheckBox3,
                textField2,
                textField3, textField4,
                textField5, textField6, textField7,
                textField9,
                textField10, textField11));
        CheckBox2.addActionListener(new checkBoxAction(CheckBox1, CheckBox2, CheckBox3,
                textField2,
                textField3, textField4,
                textField5, textField6, textField7,
                textField9,
                textField10, textField11));
        CheckBox3.addActionListener(new checkBoxAction(CheckBox1, CheckBox2, CheckBox3,
                textField2,
                textField3, textField4,
                textField5, textField6, textField7,
                textField9,
                textField10, textField11));
        button1.addActionListener(new buttonAction(CheckBox1, CheckBox2, CheckBox3,
                textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8,
                textField9, textField10, textField11, textField12, textField13, textField14,
                pasec, pamin, pahrs, asec, amin, ahrs, comboBox1, comboBox2, comboBox3));

        comboBox1.addItem("Default");
        comboBox1.addItem("Безключовий патрон");
        comboBox1.addItem("Самоцентруючий патрон із пневматичним кріпленням");
        comboBox1.addItem("Самоцентруючий патрон із ключовим кріпленням");
        comboBox1.addItem("Цанговий патрон із пневматичним зажимом");
        comboBox1.addItem("Цанговий патрон із рукояткою важеля");
        comboBox1.addItem("Лещата із пневматичним затиском");
        comboBox1.addItem("Лещата із ексцентриковим затиском");
        comboBox1.addItem("Оправка, гладка, без кріплення");
        comboBox1.addItem("Оправка, гладка, кріплення швидкоз'ємної шайби");
        comboBox1.addItem("Оправка, різьбова");
        comboBox1.addItem("До зубу долбяка, із підводом інструмента до деталі");
        comboBox1.addItem("В горизонтальну площину або призму");
        comboBox1.addItem("В горизонтальну площину або два пальці та вертикальну площину");
        comboBox1.addItem("Пруток в патрон із пневматичним зажимом");
        comboBox1.addItem("Пруток в патрон із рукояткою важеля");

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    textField8.setEditable(comboBox1.getSelectedItem().toString().equals("Default"));
                    comboBox2.setVisible(!comboBox1.getSelectedItem().toString().equals("Default"));
                    weight_label.setVisible(!comboBox1.getSelectedItem().toString().equals("Default"));

                    if (comboBox1.getSelectedItem().toString().equals("Пруток в патрон із пневматичним зажимом") ||
                            comboBox1.getSelectedItem().toString().equals("Пруток в патрон із рукояткою важеля")) {
                        comboBox2.removeAllItems();
                        comboBox2.addItem("12");
                        comboBox2.addItem("20");
                        comboBox2.addItem("30");
                        weight_label.setText("Діаметр прутка, до, мм");
                    } else {
                        comboBox2.removeAllItems();
                        comboBox2.addItem("0.25");
                        comboBox2.addItem("0.5");
                        comboBox2.addItem("1");
                        comboBox2.addItem("3");
                        weight_label.setText("Вага деталі, до, кг");
                    }
                }
            }
        });
        comboBox3.addItem("Default");
        comboBox3.addItem("Custom");
        comboBox3.addItem("Зубошліфувальні станки");
        comboBox3.addItem("Шліцешліфувальні станки");
        comboBox3.addItem("Хонінгувальні станки");
        comboBox3.addItem("Суперфінішні  станки");

        comboBox3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    textField14.setEditable("Custom".equals(comboBox3.getSelectedItem().toString()));
                }
            }
        });
    }
    private Additional menuListener = new Additional();
    private void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = new Dimension(WINDOW_X, WINDOW_Y);

        setContentPane(mainPanel);
        setBounds(screenSize.width / 2 - frameSize.width / 2,
                screenSize.height / 2 - frameSize.height / 2,
                frameSize.width, frameSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(TITLE);

        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("Файл");
        menuBar.add(fileMenu);
        JMenuItem fileMenuAbout = new JMenuItem("Про програму");
        fileMenuAbout.setActionCommand("PROGRAM");
        fileMenuAbout.addActionListener(menuListener);
        JMenuItem fileMenuAuthor = new JMenuItem("Про автора");
        fileMenuAuthor.setActionCommand("AUTHOR");
        fileMenuAuthor.addActionListener(menuListener);
        fileMenu.add(fileMenuAbout);
        fileMenu.add(fileMenuAuthor);

        setVisible(true);
        setResizable(false);
        comboBox2.setVisible(false);
        weight_label.setVisible(false);
    }
}