package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Additional implements ActionListener {
    private static final int I_GAP = 5;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), "PROGRAM")) {
            JFrame nFrame = new JFrame("Про програму");
            nFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(25, 40, 10, 40));

            JLabel label1 = new JLabel("Застосунок \"Розрахунок технічно обґрунтованих норм часу\"");
            JTextArea label2 = new JTextArea("""
                    \tПрограмний продукт виготовлено на основі мови програмування Java Swing, використовуючи Open JDK\s
                    версії 20.0.2.
                    \tЗастосунок обчислює норми часу, отримуючи інформацію від користувача або для визначених полів\s
                    передбачена можливість занесення результатів із бази даних відповідно до вибраного елемента.
                    \tОсновними вважаються результати штучно-калькуляційного часу та норми часу на розбірно-складальні\s
                    роботи, але обчислення відбувається для кожного параметра, що не є дочірнім до визначених меж.\s
                    Наприклад, для основного часу не будуть визначатися дочірні елементи довжини шляху різання, \s
                    аналогічно як і дочірні елементи останнього.
                    \tЩодо полів із випадаючим списком - проводиться записування часу у відповідні поля у випадках\s
                    вибору визначених елементів або проводиться читання із рядка, що активується відповідним параметром.""");
            JLabel label4 = new JLabel("Всі права захищено © 2024");

            label1.setHorizontalAlignment(JLabel.CENTER);
            label4.setHorizontalAlignment(JLabel.CENTER);
            Font title = new Font("Serif", Font.ITALIC, 20);
            Font copyright = new Font("Serif", Font.BOLD, 11);
            label1.setFont(title);
            label2.setBackground(Color.decode("#EEEEEE"));
            label4.setFont(copyright);
            panel.add(label1, createGbc(0, 0));
            panel.add(label2, createGbc(0, 1));
            panel.add(label4, createGbc(0, 2));
            nFrame.getContentPane().add(BorderLayout.CENTER, panel);
            nFrame.pack();
            nFrame.setLocationByPlatform(true);
            nFrame.setVisible(true);
            nFrame.setResizable(false);
        } else{ // (Objects.equals(e.getActionCommand(), "AUTHOR")) {
            JOptionPane.showMessageDialog(null, "Застосунок розробив студент 3-го курсу групи ПМ-11,\nЧеберяк Олександр",
                    "Інформація про автора", JOptionPane.PLAIN_MESSAGE);
        }
    }
    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.HORIZONTAL; // stretch components horizontally
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; // increase to stretch vert
        gbc.insets = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);
        gbc.anchor = x % 2 == 0 ? GridBagConstraints.WEST : GridBagConstraints.EAST;// if the x value is odd, anchor to the left, otherwise if even to the right
        return gbc;
    }
}
