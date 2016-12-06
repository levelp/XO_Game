import javax.swing.*;


public class MainForm {
    private JTextField arg1;
    private JTextField arg2;
    private JTextField result;
    private JButton sumButton;
    private JPanel mainPanel;

    public MainForm() {
        sumButton.addActionListener(e -> {
            int a = Integer.parseInt(arg1.getText());
            int b = Integer.parseInt(arg2.getText());
            int sum = a + b;
            result.setText("Сумма: " + sum);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Сумма двух чисел");
        // Внутренности окна
        frame.setContentPane(new MainForm().mainPanel);
        // Упаковать окно (подровнять все кнопки и другие элементы интерфейса)
        frame.pack();
        // При закрытии этого окна нужно выходить из программы
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Показываем готовое окно
        frame.setVisible(true);
    }

}
