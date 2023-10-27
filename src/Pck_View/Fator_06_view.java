package Pck_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import Pck_Control.Fator_06_Control;
import Pck_Model.Fator_06;

public class Fator_06_view extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField jt_titulo, jt_descricao, jt_num_sequencia, jt_a04_codigo, jt_certeza_resultante_fator,
            jt_contradicao_resultante_fator, jt_resultado_fator, jt_dt_cadastro, jt_dt_ultima_alteracao;
    private JButton jb_inserir, jb_excluir, jb_selecionar, jb_atualizar;
    private JTextField jt_codigoExclusao, jt_codigoSelecao, jt_codigoAtualizacao;

    private Fator_06_Control oFator_06_Control = new Fator_06_Control();

    public Fator_06_view() {
        setTitle("View Fator_06");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(17, 2));

        addLabelAndField("Título:", jt_titulo = new JTextField());
        addLabelAndField("Descrição:", jt_descricao = new JTextField());
        addLabelAndField("Número de Sequência:", jt_num_sequencia = new JTextField());
        addLabelAndField("Código A04:", jt_a04_codigo = new JTextField());
        addLabelAndField("Certeza Resultante do Fator:", jt_certeza_resultante_fator = new JTextField());
        addLabelAndField("Contradição Resultante do Fator:", jt_contradicao_resultante_fator = new JTextField());
        addLabelAndField("Resultado do Fator:", jt_resultado_fator = new JTextField());
        addLabelAndField("Data de Cadastro (dd-MM-yyyy):", jt_dt_cadastro = new JTextField());
        addLabelAndField("Data de Última Alteração (dd-MM-yyyy):", jt_dt_ultima_alteracao = new JTextField());

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
               
                String titulo = jt_titulo.getText();
                String descricao = jt_descricao.getText();
                int numSequencia = Integer.parseInt(jt_num_sequencia.getText());
                int a04Codigo = Integer.parseInt(jt_a04_codigo.getText());
                double certezaResultanteFator = Double.parseDouble(jt_certeza_resultante_fator.getText());
                double contradicaoResultanteFator = Double.parseDouble(jt_contradicao_resultante_fator.getText());
                double resultadoFator = Double.parseDouble(jt_resultado_fator.getText());
                Date dtCadastro = parseDate(jt_dt_cadastro.getText());
                Date dtUltimaAlteracao = parseDate(jt_dt_ultima_alteracao.getText());

                
                Fator_06 fator = new Fator_06();
                fator.setA06_titulo(titulo);
                fator.setA06_descricao(descricao);
                fator.setA06_num_sequencia(numSequencia);
                fator.setA04_codigo(a04Codigo);
                fator.setA06_certeza_resultante_fator(certezaResultanteFator);
                fator.setA06_contradicao_resultante_fator(contradicaoResultanteFator);
                fator.setA06_resultado_fator(resultadoFator);
                fator.setA06_dt_cadastro(dtCadastro);
                fator.setA06_dt_ultima_alteracao(dtUltimaAlteracao);

                oFator_06_Control.inserirFator(fator);

                
                clearFields();
                JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_excluir) {
            try {
                
                int codigoExclusao = Integer.parseInt(jt_codigoExclusao.getText());
                oFator_06_Control.deletarFator(codigoExclusao);

                
                jt_codigoExclusao.setText("");

                JOptionPane.showMessageDialog(this, "Fator excluído com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_selecionar) {
            try {
                int codigoSelecao = Integer.parseInt(jt_codigoSelecao.getText());
                Fator_06 fatorSelecionado = oFator_06_Control.selecionarFator(codigoSelecao);

                if (fatorSelecionado != null) {
                   
                    JOptionPane.showMessageDialog(this, getFatorInfo(fatorSelecionado), "Fator Selecionado",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Fator não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_atualizar) {
            try {
                int codigoAtualizacao = Integer.parseInt(jt_codigoAtualizacao.getText());
                Fator_06 fatorAtualizacao = oFator_06_Control.selecionarFator(codigoAtualizacao);

                if (fatorAtualizacao != null) {
                    showUpdateDialog(fatorAtualizacao);
                } else {
                    JOptionPane.showMessageDialog(this, "Fator não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
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

    private String getFatorInfo(Fator_06 fator) {
        
        String infoFator = "Título: " + fator.getA06_titulo() + "\n" +
                "Descrição: " + fator.getA06_descricao() + "\n" +
                "Número de Sequência: " + fator.getA06_num_sequencia() + "\n" +
                "Código A04: " + fator.getA04_codigo() + "\n" +
                "Certeza Resultante do Fator: " + fator.getA06_certeza_resultante_fator() + "\n" +
                "Contradição Resultante do Fator: " + fator.getA06_contradicao_resultante_fator() + "\n" +
                "Resultado do Fator: " + fator.getA06_resultado_fator() + "\n" +
                "Data de Cadastro: " + fator.getA06_dt_cadastro() + "\n" +
                "Data de Última Alteração: " + fator.getA06_dt_ultima_alteracao() + "\n";
        return infoFator;
    }

    private void clearFields() {
        jt_titulo.setText("");
        jt_descricao.setText("");
        jt_num_sequencia.setText("");
        jt_a04_codigo.setText("");
        jt_certeza_resultante_fator.setText("");
        jt_contradicao_resultante_fator.setText("");
        jt_resultado_fator.setText("");
        jt_dt_cadastro.setText("");
        jt_dt_ultima_alteracao.setText("");
    }

    private void showUpdateDialog(Fator_06 fator) {
        JDialog popup = new JDialog(this, "Atualizar Fator", true);
        popup.setLayout(new GridLayout(17, 2));

        JTextField jt_titulo = new JTextField(fator.getA06_titulo());
    JTextField jt_descricao = new JTextField(fator.getA06_descricao());
    JTextField jt_num_sequencia = new JTextField(String.valueOf(fator.getA06_num_sequencia()));
    JTextField jt_a04_codigo = new JTextField(String.valueOf(fator.getA04_codigo()));
    JTextField jt_certeza_resultante_fator = new JTextField(
            String.valueOf(fator.getA06_certeza_resultante_fator()));
    JTextField jt_contradicao_resultante_fator = new JTextField(
            String.valueOf(fator.getA06_contradicao_resultante_fator()));
    JTextField jt_resultado_fator = new JTextField(String.valueOf(fator.getA06_resultado_fator()));
    JTextField jt_dt_cadastro = new JTextField(fator.getA06_dt_cadastro().toString());
    JTextField jt_dt_ultima_alteracao = new JTextField(fator.getA06_dt_ultima_alteracao().toString());

        JButton jb_confirmar = new JButton("Confirmar");
        JButton jb_cancelar = new JButton("Cancelar");

        popup.add(new JLabel("Título:"));
        popup.add(jt_titulo);
        popup.add(new JLabel("Descrição:"));
        popup.add(jt_descricao);
        popup.add(new JLabel("Número de Sequência:"));
        popup.add(jt_num_sequencia);
        popup.add(new JLabel("Código A04:"));
        popup.add(jt_a04_codigo);
        popup.add(new JLabel("Certeza Resultante do Fator:"));
        popup.add(jt_certeza_resultante_fator);
        popup.add(new JLabel("Contradição Resultante do Fator:"));
        popup.add(jt_contradicao_resultante_fator);
        popup.add(new JLabel("Resultado do Fator:"));
        popup.add(jt_resultado_fator);
        popup.add(new JLabel("Data de Cadastro (dd-MM-yyyy):"));
        popup.add(jt_dt_cadastro);
        popup.add(new JLabel("Data de Última Alteração (dd-MM-yyyy):"));
        popup.add(jt_dt_ultima_alteracao);
        popup.add(jb_confirmar);
        popup.add(jb_cancelar);

        jb_confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fator.setA06_titulo(jt_titulo.getText());
            fator.setA06_descricao(jt_descricao.getText());
            fator.setA06_num_sequencia(Integer.parseInt(jt_num_sequencia.getText()));
            fator.setA04_codigo(Integer.parseInt(jt_a04_codigo.getText()));
            fator.setA06_certeza_resultante_fator(Double.parseDouble(jt_certeza_resultante_fator.getText()));
            fator.setA06_contradicao_resultante_fator(
                    Double.parseDouble(jt_contradicao_resultante_fator.getText()));
            fator.setA06_resultado_fator(Double.parseDouble(jt_resultado_fator.getText()));
            fator.setA06_dt_cadastro(Date.valueOf(jt_dt_cadastro.getText()));
            fator.setA06_dt_ultima_alteracao(Date.valueOf(jt_dt_ultima_alteracao.getText()));

                
                popup.dispose();
            }
        });

        popup.pack();
        popup.setLocationRelativeTo(this);
        popup.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Fator_06_view obj_interface = new Fator_06_view();
            obj_interface.setVisible(true);
        });
    }
}
