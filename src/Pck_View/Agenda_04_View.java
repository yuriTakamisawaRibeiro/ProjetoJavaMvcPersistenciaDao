package Pck_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Pck_Control.Agenda_04_Control;
import Pck_Model.Agenda_04;

public class Agenda_04_View extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField jt_titulo, jt_descricao, jt_status_dt_limite, jt_data_limite, jt_resultado,
            jt_certeza_resultado, jt_contradicao_resultado, jt_data_cadastro, jt_dt_ultima_alteracao,
            jt_a01_codigo, jt_a04_status;

    private JButton jb_inserir;

    Date sqlDate = null;

    private Agenda_04_Control oAgenda_04_Control = new Agenda_04_Control();

    public Agenda_04_View() {
        setTitle("Exemplo MVC + DAO Simplificado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2));

        addLabelAndField("Título:", jt_titulo = new JTextField());
        addLabelAndField("Descrição:", jt_descricao = new JTextField());
        addLabelAndField("Status Data Limite:", jt_status_dt_limite = new JTextField());
        addLabelAndField("Data Limite (dd/MM/yyyy):", jt_data_limite = new JTextField());
        addLabelAndField("Resultado:", jt_resultado = new JTextField());
        addLabelAndField("Certeza Resultado:", jt_certeza_resultado = new JTextField());
        addLabelAndField("Contradição Resultado:", jt_contradicao_resultado = new JTextField());
        addLabelAndField("Data Cadastro (dd/MM/yyyy):", jt_data_cadastro = new JTextField());
        addLabelAndField("Data Última Alteração (dd/MM/yyyy):", jt_dt_ultima_alteracao = new JTextField());
        addLabelAndField("A01 Código:", jt_a01_codigo = new JTextField());
        addLabelAndField("Status:", jt_a04_status = new JTextField());

        jb_inserir = new JButton("Inserir");
        jb_inserir.addActionListener(this);
        add(new JLabel()); // Espaço vazio para alinhar com os campos
        add(jb_inserir);

        pack();
        setLocationRelativeTo(null);
    }

    private void addLabelAndField(String labelText, JTextField field) {
        add(new JLabel(labelText));
        add(field);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb_inserir) {
            try {
                // Obtenha os valores dos campos da interface.
                String titulo = jt_titulo.getText();
                String descricao = jt_descricao.getText();
                int statusDtLimite = Integer.parseInt(jt_status_dt_limite.getText());
                LocalDate dataLimite = LocalDate.parse(jt_data_limite.getText(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String resultado = jt_resultado.getText();
                double certezaResultado = Double.parseDouble(jt_certeza_resultado.getText());
                double contradicaoResultado = Double.parseDouble(jt_contradicao_resultado.getText());
                LocalDate dataCadastro = LocalDate.parse(jt_data_cadastro.getText(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate dataUltimaAlteracao = LocalDate.parse(jt_dt_ultima_alteracao.getText(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int a01Codigo = Integer.parseInt(jt_a01_codigo.getText());
                int a04Status = Integer.parseInt(jt_a04_status.getText());

                // Crie um objeto Agenda_04 com os dados apropriados.
                Agenda_04 agenda = new Agenda_04();
                agenda.setA04_titulo(titulo);
                agenda.setA04_descricao(descricao);
                agenda.setA04_status_dt_limite(statusDtLimite);
                agenda.setA04_data_limite(dataLimite);
                agenda.setA04_resultado(resultado);
                agenda.setA04_certeza_resultado(certezaResultado);
                agenda.setA04_contradicao_resultado(contradicaoResultado);
                agenda.setA04_dt_cadastro(dataCadastro);
                agenda.setA04_dt_ultima_alteracao(dataUltimaAlteracao);
                agenda.setA01_codigo(a01Codigo);
                agenda.setA04_status(a04Status);

                oAgenda_04_Control.inserirAgenda(agenda);

                // Limpe os campos da interface após a inserção.
                clearFields();
                JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearFields() {
        jt_titulo.setText("");
        jt_descricao.setText("");
        jt_status_dt_limite.setText("");
        jt_resultado.setText("");
        jt_certeza_resultado.setText("");
        jt_contradicao_resultado.setText("");
        jt_data_limite.setText("");
        jt_data_cadastro.setText("");
        jt_dt_ultima_alteracao.setText("");
        jt_a01_codigo.setText("");
        jt_a04_status.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Agenda_04_View obj_interface = new Agenda_04_View();
            obj_interface.setVisible(true);
        });
    }
}
