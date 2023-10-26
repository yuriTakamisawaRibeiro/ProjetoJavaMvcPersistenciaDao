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
import Pck_Control.Empresa_01_Control;
import Pck_Model.Empresa_01;

public class Empresa_01_View extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField jt_nome, jt_descricao, jt_status, jt_dt_cadastro, jt_dt_ultima_alteracao;
    private JButton jb_inserir, jb_excluir, jb_selecionar, jb_atualizar;
    private JTextField jt_codigoExclusao, jt_codigoSelecao, jt_codigoAtualizacao;

    private Empresa_01_Control oEmpresa_01_Control = new Empresa_01_Control();

    public Empresa_01_View() {
        setTitle("View Empresa_01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 2, 5, 5));

        addLabelAndField("Nome:", jt_nome = new JTextField());
        addLabelAndField("Descrição:", jt_descricao = new JTextField());
        addLabelAndField("Status:", jt_status = new JTextField());
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
                String nome = jt_nome.getText();
                String descricao = jt_descricao.getText();
                int status = Integer.parseInt(jt_status.getText());
                Date dtCadastro = parseDate(jt_dt_cadastro.getText());
                Date dtUltimaAlteracao = parseDate(jt_dt_ultima_alteracao.getText());

                // Crie um objeto Empresa_01 com os dados apropriados.
                Empresa_01 empresa = new Empresa_01();
                empresa.setA01_nome(nome);
                empresa.setA01_descricao(descricao);
                empresa.setA01_status(status);
                empresa.setA01_dt_cadastro(dtCadastro);
                empresa.setA01_dt_ultima_alteracao(dtUltimaAlteracao);

                oEmpresa_01_Control.inserirEmpresa(empresa);

                // Limpe os campos da interface após a inserção.
                clearFields();
                JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_excluir) {
            try {
                // Obtenha o código da empresa a ser excluída do campo de texto.
                int codigoExclusao = Integer.parseInt(jt_codigoExclusao.getText());
                oEmpresa_01_Control.deletarEmpresa(codigoExclusao);

                // Limpe o campo de texto após a exclusão.
                jt_codigoExclusao.setText("");

                JOptionPane.showMessageDialog(this, "Empresa excluída com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_selecionar) {
            try {
                int codigoSelecao = Integer.parseInt(jt_codigoSelecao.getText());
                Empresa_01 empresaSelecionada = oEmpresa_01_Control.selecionarEmpresa(codigoSelecao);

                if (empresaSelecionada != null) {
                    // Exiba as informações da empresa selecionada
                    JOptionPane.showMessageDialog(this, getEmpresaInfo(empresaSelecionada), "Empresa Selecionada",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Empresa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_atualizar) {
            try {
                int codigoAtualizacao = Integer.parseInt(jt_codigoAtualizacao.getText());
                Empresa_01 empresaAtualizacao = oEmpresa_01_Control.selecionarEmpresa(codigoAtualizacao);

                if (empresaAtualizacao != null) {
                    showUpdateDialog(empresaAtualizacao);
                } else {
                    JOptionPane.showMessageDialog(this, "Empresa não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
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

    private String getEmpresaInfo(Empresa_01 empresa) {
        // Construa uma string com as informações da empresa
        String infoEmpresa = "Nome: " + empresa.getA01_nome() + "\n" +
                "Descrição: " + empresa.getA01_descricao() + "\n" +
                "Status: " + empresa.getA01_status() + "\n" +
                "Data de Cadastro: " + empresa.getA01_dt_cadastro() + "\n" +
                "Data de Última Alteração: " + empresa.getA01_dt_ultima_alteracao() + "\n";
        return infoEmpresa;
    }

    private void clearFields() {
        jt_nome.setText("");
        jt_descricao.setText("");
        jt_status.setText("");
        jt_dt_cadastro.setText("");
        jt_dt_ultima_alteracao.setText("");
    }

    private void showUpdateDialog(Empresa_01 empresa) {
        JDialog popup = new JDialog(this, "Atualizar Empresa", true);
        popup.setLayout(new GridLayout(9, 2));

        JTextField jt_nome = new JTextField(empresa.getA01_nome());
        JTextField jt_descricao = new JTextField(empresa.getA01_descricao());
        JTextField jt_status = new JTextField(Integer.toString(empresa.getA01_status()));
        JTextField jt_dt_cadastro = new JTextField(empresa.getA01_dt_cadastro().toString());
        JTextField jt_dt_ultima_alteracao = new JTextField(empresa.getA01_dt_ultima_alteracao().toString());

        JButton jb_confirmar = new JButton("Confirmar");
        JButton jb_cancelar = new JButton("Cancelar");

        popup.add(new JLabel("Nome:"));
        popup.add(jt_nome);
        popup.add(new JLabel("Descrição:"));
        popup.add(jt_descricao);
        popup.add(new JLabel("Status:"));
        popup.add(jt_status);
        popup.add(new JLabel("Data de Cadastro (dd-MM-yyyy):"));
        popup.add(jt_dt_cadastro);
        popup.add(new JLabel("Data de Última Alteração (dd-MM-yyyy):"));
        popup.add(jt_dt_ultima_alteracao);
        popup.add(jb_confirmar);
        popup.add(jb_cancelar);

        jb_confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empresa.setA01_nome(jt_nome.getText());
                empresa.setA01_descricao(jt_descricao.getText());
                empresa.setA01_status(Integer.parseInt(jt_status.getText()));
                empresa.setA01_dt_cadastro(Date.valueOf(jt_dt_cadastro.getText()));
                empresa.setA01_dt_ultima_alteracao(Date.valueOf(jt_dt_ultima_alteracao.getText()));
                try {
                    oEmpresa_01_Control.alterarEmpresa(empresa);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
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
            Empresa_01_View obj_interface = new Empresa_01_View();
            obj_interface.setVisible(true);
        });
    }
}
