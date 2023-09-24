
package sistemadefaturamentoapp;

import javax.swing.SwingUtilities;

public class SistemaDeFaturamentoApp {
    public static void main(String[] args) {
        // Inicie o aplicativo aqui, por exemplo, a autenticação do usuário, etc.
        // Você pode chamar a classe FaturaGUI a partir daqui.
        SwingUtilities.invokeLater(() -> {
            FaturaGUI faturaGUI = new FaturaGUI();
            faturaGUI.setVisible(true);
        });
    }
}
