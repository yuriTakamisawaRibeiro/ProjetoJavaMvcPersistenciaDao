package Pck_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    private JTextField jt_codigoExclusao; // Campo de texto para inserir o código da agenda a ser excluída
    private JButton jb_excluir; // Botão de exclusão

    private JButton jb_selecionar;
    private JTextField jt_codigoSelecao;

    Date sqlDate = null;

    private Agenda_04_Control oAgenda_04_Control = new Agenda_04_Control();

    public Agenda_04_View() {
        setTitle("Exemplo MVC + DAO Simplificado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(17, 3)); // Ajuste o GridLayout para acomodar os campos adicionais

        addLabelAndField("Título:", jt_titulo = new JTextField());
        addLabelAndField("Descrição:", jt_descricao = new JTextField());
        addLabelAndField("Status Data Limite:", jt_status_dt_limite = new JTextField());
        addLabelAndField("Data Limite (dd-MM-yyyy):", jt_data_limite = new JTextField());
        addLabelAndField("Resultado:", jt_resultado = new JTextField());
        addLabelAndField("Certeza Resultado:", jt_certeza_resultado = new JTextField());
        addLabelAndField("Contradição Resultado:", jt_contradicao_resultado = new JTextField());
        addLabelAndField("Data Cadastro (dd-MM-yyyy):", jt_data_cadastro = new JTextField());
        addLabelAndField("Data Última Alteração (dd-MM-yyyy):", jt_dt_ultima_alteracao = new JTextField());
        addLabelAndField("A01 Código:", jt_a01_codigo = new JTextField());
        addLabelAndField("Status:", jt_a04_status = new JTextField());

        // Adicione o campo de código para exclusão

        jb_inserir = new JButton("Inserir");
        jb_excluir = new JButton("Excluir"); // Adicione o botão de exclusão
        jb_inserir.addActionListener(this);
        jb_excluir.addActionListener(this); // Adicione um único ActionListener para ambos os botões

        // Adicione os botões à interface
        add(jb_inserir);
        add(new JLabel()); // Adicione um rótulo vazio para preencher a grade
        addLabelAndField("Código para Excluir:", jt_codigoExclusao = new JTextField());
        add(new JLabel()); // Adicione uma linha vazia para separar visualmente
        add(jb_excluir);

        // Adicione o campo de código para seleção
        jt_codigoSelecao = new JTextField();
        jb_selecionar = new JButton("Selecionar");
        jb_selecionar.addActionListener(this);
        addLabelAndField("Código para Selecionar:", jt_codigoSelecao);
        add(new JLabel()); // Adicione uma linha vazia para separar visualmente
        add(jb_selecionar);

        pack();
        setLocationRelativeTo(null);
    }

    private void addLabelAndField(String labelText, JTextField field) {
        add(new JLabel(labelText));
        add(field);

        // Adicione um código para converter o texto da data para o formato
        // java.sql.Date.
        if (labelText.equals("Data Limite (dd-MM-yyyy)") || labelText.equals("Data Cadastro (dd-MM-yyyy)") ||
                labelText.equals("Data Última Alteração (dd-MM-yyyy)")) {
            field.addActionListener(e -> {
                String text = field.getText();
                try {
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    java.util.Date parsedDate = dateFormat.parse(text);
                    sqlDate = new Date(parsedDate.getTime());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb_inserir) {
            try {
                // Obtenha os valores dos campos da interface.
                String titulo = jt_titulo.getText();
                String descricao = jt_descricao.getText();
                int statusDtLimite = Integer.parseInt(jt_status_dt_limite.getText());
                java.util.Date parsedDataLimite = new SimpleDateFormat("dd-MM-yyyy").parse(jt_data_limite.getText());
                sqlDate = new Date(parsedDataLimite.getTime());
                String resultado = jt_resultado.getText();
                double certezaResultado = Double.parseDouble(jt_certeza_resultado.getText());
                double contradicaoResultado = Double.parseDouble(jt_contradicao_resultado.getText());
                java.util.Date parsedDataCadastro = new SimpleDateFormat("dd-MM-yyyy")
                        .parse(jt_data_cadastro.getText());
                Date sqlDateDataCadastro = new Date(parsedDataCadastro.getTime());
                java.util.Date parsedDataUltimaAlteracao = new SimpleDateFormat("dd-MM-yyyy")
                        .parse(jt_dt_ultima_alteracao.getText());
                Date sqlDateDataUltimaAlteracao = new Date(parsedDataUltimaAlteracao.getTime());
                int a01Codigo = Integer.parseInt(jt_a01_codigo.getText());
                int a04Status = Integer.parseInt(jt_a04_status.getText());

                // Crie um objeto Agenda_04 com os dados apropriados.
                Agenda_04 agenda = new Agenda_04();
                agenda.setA04_titulo(titulo);
                agenda.setA04_descricao(descricao);
                agenda.setA04_status_dt_limite(statusDtLimite);
                agenda.setA04_data_limite(sqlDate);
                agenda.setA04_resultado(resultado);
                agenda.setA04_certeza_resultado(certezaResultado);
                agenda.setA04_contradicao_resultado(contradicaoResultado);
                agenda.setA04_dt_cadastro(sqlDateDataCadastro);
                agenda.setA04_dt_ultima_alteracao(sqlDateDataUltimaAlteracao);
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
        } else if (e.getSource() == jb_excluir) {
            try {
                // Obtenha o código da agenda a ser excluída do campo de texto.
                int codigoExclusao = Integer.parseInt(jt_codigoExclusao.getText());

                // Chame o método para excluir a agenda com o código fornecido.
                Agenda_04 agendaExclusao = new Agenda_04();
                agendaExclusao.setA04_codigo(codigoExclusao);

                oAgenda_04_Control.deletarAgenda(agendaExclusao);

                // Limpe o campo de texto após a exclusão.
                jt_codigoExclusao.setText("");

                JOptionPane.showMessageDialog(this, "Agenda excluída com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_selecionar) {
            try {
                int codigoSelecao = Integer.parseInt(jt_codigoSelecao.getText());
                Agenda_04 agendaSelecionada = oAgenda_04_Control.selecionarAgenda(codigoSelecao);

                if (agendaSelecionada != null) {
                    String infoAgenda = "Título: " + agendaSelecionada.getA04_titulo() + "\n" +
                            "Descrição: " + agendaSelecionada.getA04_descricao() + "\n" +
                            "Status Data Limite: " + agendaSelecionada.getA04_status_dt_limite() + "\n" +
                            "Data Limite: " + agendaSelecionada.getA04_data_limite() + "\n" +
                            "Resultado: " + agendaSelecionada.getA04_resultado() + "\n" +
                            "Certeza Resultado: " + agendaSelecionada.getA04_certeza_resultado() + "\n" +
                            "Contradição Resultado: " + agendaSelecionada.getA04_contradicao_resultado() + "\n" +
                            "Data Cadastro: " + agendaSelecionada.getA04_dt_cadastro() + "\n" +
                            "Data Última Alteração: " + agendaSelecionada.getA04_dt_ultima_alteracao() + "\n" +
                            "A01 Código: " + agendaSelecionada.getA01_codigo() + "\n" +
                            "Status: " + agendaSelecionada.getA04_status() + "\n";

                    JOptionPane.showMessageDialog(this, infoAgenda, "Agenda Selecionada",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Agenda não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar: " + ex.getMessage(), "Erro",
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
