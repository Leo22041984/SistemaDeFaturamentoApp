
package sistemadefaturamentoapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FaturaGUI extends JFrame implements ActionListener {
    private JTextField itemNameField, priceField, quantityField;
    private JButton addItemButton, calculateButton;
    private JTextArea faturaTextArea;
    private Fatura fatura;

    public FaturaGUI() {
        setTitle("Sistema de Faturamento");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        fatura = new Fatura();

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nome do Item:"));
        itemNameField = new JTextField();
        inputPanel.add(itemNameField);

        inputPanel.add(new JLabel("Preço por Unidade:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Quantidade:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        addItemButton = new JButton("Adicionar Item");
        addItemButton.addActionListener(this);
        inputPanel.add(addItemButton);

        calculateButton = new JButton("Calcular Fatura");
        calculateButton.addActionListener(this);
        inputPanel.add(calculateButton);

        faturaTextArea = new JTextArea();
        faturaTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(faturaTextArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItemButton) {
            try {
                String itemName = itemNameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());

                Item item = new Item(itemName, price, quantity);
                fatura.addItem(item);
                faturaTextArea.append(item.toString() + "\n");

                itemNameField.setText("");
                priceField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro nos campos de entrada.");
            }
        } else if (e.getSource() == calculateButton) {
            double total = fatura.getTotal();
            faturaTextArea.append("\nTotal da Fatura: R$" + total);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FaturaGUI faturaGUI = new FaturaGUI();
            faturaGUI.setVisible(true);
        });
    }
}
