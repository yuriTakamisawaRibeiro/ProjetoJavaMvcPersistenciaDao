package Pck_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import Pck_Control.Parecer_fator_usuario_07_Control;
import Pck_Model.Parecer_fator_usuario_07;

public class Parecer_fator_usuario_07_View extends JFrame implements ActionListener {
    private JTextField jt_a07_codigo, jt_a06_codigo, jt_a02_codigo, jt_a07_num_sequencia, jt_a07_certeza,
            jt_a07_contradicao,
            jt_a07_dt_cadastro, jt_a07_dt_ultima_alteracao;
    private JButton jb_inserir, jb_excluir, jb_selecionar, jb_atualizar;
    private JTextField jt_codigoExclusao, jt_codigoSelecao, jt_codigoAtualizacao;

    private Parecer_fator_usuario_07_Control parecerControl = new Parecer_fator_usuario_07_Control();

    public Parecer_fator_usuario_07_View() {
        setTitle("View Parecer Fator Usuário 07");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(17, 2));

        addLabelAndField("Código A06:", jt_a06_codigo = new JTextField());
        addLabelAndField("Código A02:", jt_a02_codigo = new JTextField());
        addLabelAndField("Número de Sequência:", jt_a07_num_sequencia = new JTextField());
        addLabelAndField("Certeza:", jt_a07_certeza = new JTextField());
        addLabelAndField("Contradição:", jt_a07_contradicao = new JTextField());
        addLabelAndField("Data de Cadastro (dd-MM-yyyy):", jt_a07_dt_cadastro = new JTextField());
        addLabelAndField("Data de Última Alteração (dd-MM-yyyy):", jt_a07_dt_ultima_alteracao = new JTextField());

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
                int a06Codigo = Integer.parseInt(jt_a06_codigo.getText());
                int a02Codigo = Integer.parseInt(jt_a02_codigo.getText());
                int a07NumSequencia = Integer.parseInt(jt_a07_num_sequencia.getText());
                double a07Certeza = Double.parseDouble(jt_a07_certeza.getText());
                double a07Contradicao = Double.parseDouble(jt_a07_contradicao.getText());
                Date a07DtCadastro = parseDate(jt_a07_dt_cadastro.getText());
                Date a07DtUltimaAlteracao = parseDate(jt_a07_dt_ultima_alteracao.getText());

                // Crie um objeto Parecer_fator_usuario_07 com os dados apropriados.
                Parecer_fator_usuario_07 parecer = new Parecer_fator_usuario_07();
                parecer.setA06_codigo(a06Codigo);
                parecer.setA02_codigo(a02Codigo);
                parecer.setA07_num_sequencia(a07NumSequencia);
                parecer.setA07_certeza(a07Certeza);
                parecer.setA07_contradicao(a07Contradicao);
                parecer.setA07_dt_cadastro(a07DtCadastro);
                parecer.setA07_dt_ultima_alteracao(a07DtUltimaAlteracao);

                parecerControl.inserirParecerFatorUsuario07(parecer);

                // Limpe os campos da interface após a inserção.
                clearFields();
                JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_excluir) {
            try {
                // Obtenha o código do parecer a ser excluído do campo de texto.
                int codigoExclusao = Integer.parseInt(jt_codigoExclusao.getText());
                parecerControl.excluirParecerFatorUsuario07(codigoExclusao);

                // Limpe o campo de texto após a exclusão.
                jt_codigoExclusao.setText("");

                JOptionPane.showMessageDialog(this, "Parecer excluído com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_selecionar) {
            try {
                int codigoSelecao = Integer.parseInt(jt_codigoSelecao.getText());
                Parecer_fator_usuario_07 parecerSelecionado = parecerControl
                        .selecionarParecerFatorUsuario07(codigoSelecao);

                if (parecerSelecionado != null) {
                    // Exiba as informações do parecer selecionado
                    JOptionPane.showMessageDialog(this, getParecerInfo(parecerSelecionado), "Parecer Selecionado",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Parecer não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_atualizar) {
            try {
                int codigoAtualizacao = Integer.parseInt(jt_codigoAtualizacao.getText());
                Parecer_fator_usuario_07 parecerAtualizacao = parecerControl
                        .selecionarParecerFatorUsuario07(codigoAtualizacao);

                if (parecerAtualizacao != null) {
                    showUpdateDialog(parecerAtualizacao);
                } else {
                    JOptionPane.showMessageDialog(this, "Parecer não encontrado para atualização", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar para atualização: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Date parseDate(String dateStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date parsedDate = dateFormat.parse(dateStr);
        return new Date(parsedDate.getTime());
    }

    private void clearFields() {
        jt_a06_codigo.setText("");
        jt_a02_codigo.setText("");
        jt_a07_num_sequencia.setText("");
        jt_a07_certeza.setText("");
        jt_a07_contradicao.setText("");
        jt_a07_dt_cadastro.setText("");
        jt_a07_dt_ultima_alteracao.setText("");
    }

    private String getParecerInfo(Parecer_fator_usuario_07 parecer) {
        String info = "Informações do Parecer:\n\n";
        info += "Código A07: " + parecer.getA07_codigo() + "\n";
        info += "Código A06: " + parecer.getA06_codigo() + "\n";
        info += "Código A02: " + parecer.getA02_codigo() + "\n";
        info += "Número de Sequência: " + parecer.getA07_num_sequencia() + "\n";
        info += "Certeza: " + parecer.getA07_certeza() + "\n";
        info += "Contradição: " + parecer.getA07_contradicao() + "\n";
        info += "Data de Cadastro: " + parecer.getA07_dt_cadastro() + "\n";
        info += "Data de Última Alteração: " + parecer.getA07_dt_ultima_alteracao() + "\n";

        return info;
    }

    private void showUpdateDialog(Parecer_fator_usuario_07 parecer) {
        JDialog updateDialog = new JDialog(this, "Atualizar Parecer", true);
        updateDialog.setLayout(new GridLayout(9, 2));

        // Campos para edição
        JTextField jt_a06_codigo = new JTextField(String.valueOf(parecer.getA06_codigo()));
        JTextField jt_a02_codigo = new JTextField(String.valueOf(parecer.getA02_codigo()));
        JTextField jt_a07_num_sequencia = new JTextField(String.valueOf(parecer.getA07_num_sequencia()));
        JTextField jt_a07_certeza = new JTextField(String.valueOf(parecer.getA07_certeza()));
        JTextField jt_a07_contradicao = new JTextField(String.valueOf(parecer.getA07_contradicao()));
        JTextField jt_a07_dt_cadastro = new JTextField(parecer.getA07_dt_cadastro().toString());
        JTextField jt_a07_dt_ultima_alteracao = new JTextField(parecer.getA07_dt_ultima_alteracao().toString());

        JButton jb_atualizarParecer = new JButton("Atualizar");

        jb_atualizarParecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Atualize o objeto parecer com os valores dos campos editáveis
                    parecer.setA06_codigo(Integer.parseInt(jt_a06_codigo.getText()));
                    parecer.setA02_codigo(Integer.parseInt(jt_a02_codigo.getText()));
                    parecer.setA07_num_sequencia(Integer.parseInt(jt_a07_num_sequencia.getText()));
                    parecer.setA07_certeza(Double.parseDouble(jt_a07_certeza.getText()));
                    parecer.setA07_contradicao(Double.parseDouble(jt_a07_contradicao.getText()));
                    parecer.setA07_dt_cadastro(parseDate(jt_a07_dt_cadastro.getText()));
                    parecer.setA07_dt_ultima_alteracao(parseDate(jt_a07_dt_ultima_alteracao.getText()));

                    // Chame o método de controle para atualizar o parecer
                    parecerControl.atualizarParecerFatorUsuario07(parecer);

                    // Feche o diálogo após a atualização
                    updateDialog.dispose();

                    // Atualize a interface ou notifique o usuário, se necessário
                    JOptionPane.showMessageDialog(Parecer_fator_usuario_07_View.this,
                            "Parecer atualizado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Parecer_fator_usuario_07_View.this,
                            "Erro ao atualizar o parecer: " + ex.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        updateDialog.add(new JLabel("Código A06:"));
        updateDialog.add(jt_a06_codigo);
        updateDialog.add(new JLabel("Código A02:"));
        updateDialog.add(jt_a02_codigo);
        updateDialog.add(new JLabel("Número de Sequência:"));
        updateDialog.add(jt_a07_num_sequencia);
        updateDialog.add(new JLabel("Certeza:"));
        updateDialog.add(jt_a07_certeza);
        updateDialog.add(new JLabel("Contradição:"));
        updateDialog.add(jt_a07_contradicao);
        updateDialog.add(new JLabel("Data de Cadastro (dd-MM-yyyy):"));
        updateDialog.add(jt_a07_dt_cadastro);
        updateDialog.add(new JLabel("Data de Última Alteração (dd-MM-yyyy):"));
        updateDialog.add(jt_a07_dt_ultima_alteracao);
        updateDialog.add(new JLabel()); // Espaço em branco
        updateDialog.add(jb_atualizarParecer);

        updateDialog.pack();
        updateDialog.setLocationRelativeTo(this);
        updateDialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Parecer_fator_usuario_07_View view = new Parecer_fator_usuario_07_View();
            view.setVisible(true);
        });
    }
}
