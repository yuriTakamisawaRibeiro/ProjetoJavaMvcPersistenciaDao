package Pck_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
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

    private JButton jb_inserir, jb_excluir, jb_selecionar, jb_atualizar;
    private JTextField jt_codigoExclusao, jt_codigoSelecao, jt_codigoAtualizacao;

    private Agenda_04_Control oAgenda_04_Control = new Agenda_04_Control();

    public Agenda_04_View() {
        setTitle("View Agenda_04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(17, 3));

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

        jb_inserir = new JButton("Inserir");
        jb_excluir = new JButton("Excluir");
        jb_selecionar = new JButton("Selecionar");
        jb_atualizar = new JButton("Atualizar");

        jb_inserir.addActionListener(this);
        jb_excluir.addActionListener(this);
        jb_selecionar.addActionListener(this);
        jb_atualizar.addActionListener(this);

        add(jb_inserir);
        add(new JLabel());
        addLabelAndField("Código para Excluir:", jt_codigoExclusao = new JTextField());
        add(new JLabel());
        add(jb_excluir);

        jt_codigoSelecao = new JTextField();
        add(jt_codigoSelecao);
        add(jb_selecionar);

        // Adicione o campo de código para atualização
        addLabelAndField("Código para Atualizar:", jt_codigoAtualizacao = new JTextField());
        add(new JLabel());
        add(jb_atualizar);

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
                Date dataLimite = parseDate(jt_data_limite.getText());
                String resultado = jt_resultado.getText();
                double certezaResultado = Double.parseDouble(jt_certeza_resultado.getText());
                double contradicaoResultado = Double.parseDouble(jt_contradicao_resultado.getText());
                Date dataCadastro = parseDate(jt_data_cadastro.getText());
                Date dataUltimaAlteracao = parseDate(jt_dt_ultima_alteracao.getText());
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
                    // Exiba as informações da agenda selecionada
                    JOptionPane.showMessageDialog(this, getAgendaInfo(agendaSelecionada), "Agenda Selecionada",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Agenda não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_atualizar) {
            try {
                int codigoAtualizacao = Integer.parseInt(jt_codigoAtualizacao.getText());
                Agenda_04 agendaAtualizacao = oAgenda_04_Control.selecionarAgenda(codigoAtualizacao);

                if (agendaAtualizacao != null) {
                    showUpdateDialog(agendaAtualizacao);
                } else {
                    JOptionPane.showMessageDialog(this, "Agenda não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Date parseDate(String dateStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date parsedDate = dateFormat.parse(dateStr);
        return new Date(parsedDate.getTime());
    }

    private String getAgendaInfo(Agenda_04 agenda) {
        // Construa uma string com as informações da agenda
        String infoAgenda = "Título: " + agenda.getA04_titulo() + "\n" +
                "Descrição: " + agenda.getA04_descricao() + "\n" +
                "Status Data Limite: " + agenda.getA04_status_dt_limite() + "\n" +
                "Data Limite: " + agenda.getA04_data_limite() + "\n" +
                "Resultado: " + agenda.getA04_resultado() + "\n" +
                "Certeza Resultado: " + agenda.getA04_certeza_resultado() + "\n" +
                "Contradição Resultado: " + agenda.getA04_contradicao_resultado() + "\n" +
                "Data Cadastro: " + agenda.getA04_dt_cadastro() + "\n" +
                "Data Última Alteração: " + agenda.getA04_dt_ultima_alteracao() + "\n" +
                "A01 Código: " + agenda.getA01_codigo() + "\n" +
                "Status: " + agenda.getA04_status() + "\n";
        return infoAgenda;
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

    private void showUpdateDialog(Agenda_04 agenda) {
        JDialog popup = new JDialog(this, "Atualizar Agenda", true);
        popup.setLayout(new GridLayout(15, 2)); // Ajuste o GridLayout para acomodar os campos adicionais

        // Adicione campos e rótulos para os atributos adicionais
        JTextField jt_titulo = new JTextField(agenda.getA04_titulo());
        JTextField jt_descricao = new JTextField(agenda.getA04_descricao());
        JTextField jt_status_dt_limite = new JTextField(Integer.toString(agenda.getA04_status_dt_limite()));
        JTextField jt_data_limite = new JTextField(agenda.getA04_data_limite().toString());
        JTextField jt_resultado = new JTextField(agenda.getA04_resultado());
        JTextField jt_certeza_resultado = new JTextField(Double.toString(agenda.getA04_certeza_resultado()));
        JTextField jt_contradicao_resultado = new JTextField(Double.toString(agenda.getA04_contradicao_resultado()));
        JTextField jt_data_cadastro = new JTextField(agenda.getA04_dt_cadastro().toString());
        JTextField jt_dt_ultima_alteracao = new JTextField(agenda.getA04_dt_ultima_alteracao().toString());
        JTextField jt_a01_codigo = new JTextField(Integer.toString(agenda.getA01_codigo()));
        JTextField jt_a04_status = new JTextField(Integer.toString(agenda.getA04_status()));

        JButton jb_confirmar = new JButton("Confirmar");
        JButton jb_cancelar = new JButton("Cancelar");

        popup.add(new JLabel("Título:"));
        popup.add(jt_titulo);
        popup.add(new JLabel("Descrição:"));
        popup.add(jt_descricao);
        popup.add(new JLabel("Status Data Limite:"));
        popup.add(jt_status_dt_limite);
        popup.add(new JLabel("Data Limite:"));
        popup.add(jt_data_limite);
        popup.add(new JLabel("Resultado:"));
        popup.add(jt_resultado);
        popup.add(new JLabel("Certeza Resultado:"));
        popup.add(jt_certeza_resultado);
        popup.add(new JLabel("Contradição Resultado:"));
        popup.add(jt_contradicao_resultado);
        popup.add(new JLabel("Data Cadastro:"));
        popup.add(jt_data_cadastro);
        popup.add(new JLabel("Data Última Alteração:"));
        popup.add(jt_dt_ultima_alteracao);
        popup.add(new JLabel("A01 Código:"));
        popup.add(jt_a01_codigo);
        popup.add(new JLabel("Status:"));
        popup.add(jt_a04_status);
        popup.add(jb_confirmar);
        popup.add(jb_cancelar);

        jb_confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Atualize os campos da agenda com os valores inseridos no pop-up
                agenda.setA04_titulo(jt_titulo.getText());
                agenda.setA04_descricao(jt_descricao.getText());
                agenda.setA04_status_dt_limite(Integer.parseInt(jt_status_dt_limite.getText()));
                agenda.setA04_data_limite(Date.valueOf(jt_data_limite.getText()));
                agenda.setA04_resultado(jt_resultado.getText());
                agenda.setA04_certeza_resultado(Double.parseDouble(jt_certeza_resultado.getText()));
                agenda.setA04_contradicao_resultado(Double.parseDouble(jt_contradicao_resultado.getText()));
                agenda.setA04_dt_cadastro(Date.valueOf(jt_data_cadastro.getText()));
                agenda.setA04_dt_ultima_alteracao(Date.valueOf(jt_dt_ultima_alteracao.getText()));
                agenda.setA01_codigo(Integer.parseInt(jt_a01_codigo.getText()));
                agenda.setA04_status(Integer.parseInt(jt_a04_status.getText()));
                try {
                    oAgenda_04_Control.alterarAgenda(agenda);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } // Chame o método de atualização
                popup.dispose();
            }
        });

        jb_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popup.dispose();
            }
        });

        popup.pack();
        popup.setLocationRelativeTo(this);
        popup.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Agenda_04_View obj_interface = new Agenda_04_View();
            obj_interface.setVisible(true);
        });
    }
}
