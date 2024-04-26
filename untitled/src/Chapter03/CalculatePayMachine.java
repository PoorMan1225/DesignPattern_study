package Chapter03;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatePayMachine extends Frame implements ActionListener, DocumentListener {

    private PaymentStrategy paymentStrategy;
    private JLabel workingHoursLabel = new JLabel("Working Hours = ", SwingConstants.RIGHT);
    private JLabel overTimeHoursLabel = new JLabel("Overtime Hours = ", SwingConstants.RIGHT);
    private JLabel payAmountLabel = new JLabel("Pay Amount = ", SwingConstants.RIGHT);

    private JTextField tfWorkingHours = new JTextField();
    private JTextField tfOvertimeHours = new JTextField();
    private JTextField tfResult = new JTextField();

    private JButton calcButton = new JButton("Calculate");
    private JButton resetButton = new JButton("Reset");
    private JButton end = new JButton("Stop");

    public CalculatePayMachine(PaymentStrategy paymentStrategy) {
        super("Payment Calculation");
        this.init();
        this.start();
        this.setSize(500, 250);
        this.setVisible(true);
        this.paymentStrategy = paymentStrategy;
    }

    public void init() {
        this.setLayout(new GridLayout(5, 1));
        Panel p = new Panel(new BorderLayout());
        p.add("West", workingHoursLabel);
        p.add("Center", tfWorkingHours);
        this.add(p);

        Panel p1 = new Panel(new BorderLayout());
        p1.add("West", overTimeHoursLabel);
        p1.add("Center", tfOvertimeHours);
        this.add(p1);

        Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        p2.add(calcButton);
        this.add(p2);

        Panel p3 = new Panel(new BorderLayout());
        p3.add("West", payAmountLabel);
        p3.add("Center", tfResult);
        this.add(p3);

        Panel p4 = new Panel(new FlowLayout(FlowLayout.RIGHT));
        p4.add(resetButton);
        p4.add(end);
        this.add(p4);
    }

    public void start() {
        calcButton.addActionListener(this);
        resetButton.addActionListener(this);
        tfWorkingHours.getDocument().addDocumentListener(this);
        tfOvertimeHours.getDocument().addDocumentListener(this);
        end.addActionListener(this);
        calcButton.setEnabled(false);
        resetButton.setEnabled(false);
    }

    public boolean isDataEntered() {
        // 데이터가 들어가는 로직이변경 될 소지가 있다.
        if (tfWorkingHours.getText().trim().length() == 0 ||
                tfOvertimeHours.getText().trim().length() == 0) {
            return false;
        }
        return true;
    }

    private void reset() {
        tfWorkingHours.setText("");
        tfOvertimeHours.setText("");
        tfWorkingHours.requestFocus();
        tfResult.setText("");
        resetButton.setEnabled(false);
    }

    private void checkData() {
        calcButton.setEnabled(isDataEntered());
    }

    private int parseIntToText(JTextField jTextField) {
        int x = 0;
        if (jTextField == null)
            return x;
        try {
            x = Integer.parseInt(jTextField.getText().trim());
        } catch (NumberFormatException e) {
            jTextField.setText("");
            jTextField.requestFocus();
            throw e;
        }
        return x;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == end) {
            System.exit(0);
        } else if (e.getSource() == resetButton) {
            reset();
        } else if (e.getSource() == calcButton) {
           calculate();
        }
    }

    private void calculate() {
        try {
            int x = parseIntToText(tfWorkingHours);
            int y = parseIntToText(tfOvertimeHours);
            int payAmount = paymentStrategy.payment(x, y);
            tfResult.setText(String.valueOf(payAmount));
            resetButton.setEnabled(true);
        } catch (NumberFormatException ex) {
            ex.getStackTrace();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkData();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkData();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkData();
    }
}
