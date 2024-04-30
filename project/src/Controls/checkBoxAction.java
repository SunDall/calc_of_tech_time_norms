package Controls;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkBoxAction implements ActionListener{
    private final JCheckBox CheckBox1;
    private final JCheckBox CheckBox2;
    private final JCheckBox CheckBox3;
    private final JTextField textField2;
    private final JTextField textField3;
    private final JTextField textField4;
    private final JTextField textField5;
    private final JTextField textField6;
    private final JTextField textField7;
    private final JTextField textField9;
    private final JTextField textField10;
    private final JTextField textField11;
    public checkBoxAction(JCheckBox checkBox1, JCheckBox checkBox2, JCheckBox checkBox3,
                          JTextField textField2,
                          JTextField textField3, JTextField textField4,
                          JTextField textField5, JTextField textField6, JTextField textField7,
                          JTextField textField9,
                          JTextField textField10, JTextField textField11) {
        this.CheckBox1 = checkBox1;
        this.CheckBox2 = checkBox2;
        this.CheckBox3 = checkBox3;
        this.textField2 = textField2;
        this.textField3 = textField3;
        this.textField4 = textField4;
        this.textField5 = textField5;
        this.textField6 = textField6;
        this.textField7 = textField7;
        this.textField9 = textField9;
        this.textField10 = textField10;
        this.textField11 = textField11;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(CheckBox1.isSelected()){
            textField2.setEditable(false);
            textField2.setEnabled(false);
            textField3.setEditable(true);
            textField3.setEnabled(true);
            textField7.setEditable(true);
            textField7.setEnabled(true);
            CheckBox2.setEnabled(true);
        } else{
            textField2.setEditable(true);
            textField2.setEnabled(true);
            textField3.setEditable(false);
            textField3.setEnabled(false);
            textField7.setEditable(false);
            textField7.setEnabled(false);
            CheckBox2.setEnabled(false);
            CheckBox2.setSelected(false);
        }

        if(CheckBox2.isSelected()) {
            textField3.setEditable(false);
            textField3.setEnabled(false);
            textField4.setEditable(true);
            textField4.setEnabled(true);
            textField5.setEditable(true);
            textField5.setEnabled(true);
            textField6.setEditable(true);
            textField6.setEnabled(true);
        } else{
            textField4.setEditable(false);
            textField4.setEnabled(false);
            textField5.setEditable(false);
            textField5.setEnabled(false);
            textField6.setEditable(false);
            textField6.setEnabled(false);
        }

        if(CheckBox3.isSelected()) {
            textField9.setEditable(false);
            textField9.setEnabled(false);
            textField10.setEditable(true);
            textField10.setEnabled(true);
            textField11.setEditable(true);
            textField11.setEnabled(true);
        } else{
            textField9.setEditable(true);
            textField9.setEnabled(true);
            textField10.setEditable(false);
            textField10.setEnabled(false);
            textField11.setEditable(false);
            textField11.setEnabled(false);
        }
    }
}
