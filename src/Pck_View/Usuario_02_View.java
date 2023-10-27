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
import Pck_Control.Usuario_02_Control;
import Pck_Model.Usuario_02;

public class Usuario_02_View extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField jt_nome, jt_usuario, jt_senha, jt_codigo_link, jt_email, jt_status, jt_dt_cadastro,
            jt_dt_ultima_alteracao;
    private JButton jb_inserir, jb_excluir, jb_selecionar, jb_atualizar;
    private JTextField jt_codigoExclusao, jt_codigoSelecao, jt_codigoAtualizacao;

    private Usuario_02_Control oUsuario_02_Control = new Usuario_02_Control();

    public Usuario_02_View() {
        setTitle("View Usuario_02");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(15, 2));

        addLabelAndField("Nome:", jt_nome = new JTextField());
        addLabelAndField("Usuário:", jt_usuario = new JTextField());
        addLabelAndField("Senha:", jt_senha = new JTextField());
        addLabelAndField("Código Link:", jt_codigo_link = new JTextField());
        addLabelAndField("Email:", jt_email = new JTextField());
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
                String usuario = jt_usuario.getText();
                String senha = jt_senha.getText();
                String codigoLink = jt_codigo_link.getText();
                String email = jt_email.getText();
                int status = Integer.parseInt(jt_status.getText());
                Date dtCadastro = parseDate(jt_dt_cadastro.getText());
                Date dtUltimaAlteracao = parseDate(jt_dt_ultima_alteracao.getText());

                // Crie um objeto Usuario_02 com os dados apropriados.
                Usuario_02 oUsuario = new Usuario_02();
                oUsuario.setA02_nome(nome);
                oUsuario.setA02_usuario(usuario);
                oUsuario.setA02_senha(senha);
                oUsuario.setA02_codigo_link(codigoLink);
                oUsuario.setA02_email(email);
                oUsuario.setA02_status(status);
                oUsuario.setA02_dt_cadastro(dtCadastro);
                oUsuario.setA02_dt_ultima_alteracao(dtUltimaAlteracao);

                oUsuario_02_Control.inserirUsuario(oUsuario);

                // Limpe os campos da interface após a inserção.
                clearFields();
                JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_excluir) {
            try {
                // Obtenha o código do usuário a ser excluído do campo de texto.
                int codigoExclusao = Integer.parseInt(jt_codigoExclusao.getText());
                oUsuario_02_Control.excluirUsuario(codigoExclusao);

                // Limpe o campo de texto após a exclusão.
                jt_codigoExclusao.setText("");

                JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_selecionar) {
            try {
                int codigoSelecao = Integer.parseInt(jt_codigoSelecao.getText());
                Usuario_02 usuarioSelecionado = oUsuario_02_Control.selecionarUsuario(codigoSelecao);

                if (usuarioSelecionado != null) {
                    // Exiba as informações do usuário selecionado
                    JOptionPane.showMessageDialog(this, getUsuarioInfo(usuarioSelecionado), "Usuário Selecionado",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_atualizar) {
            try {
                int codigoAtualizacao = Integer.parseInt(jt_codigoAtualizacao.getText());
                Usuario_02 usuarioAtualizacao = oUsuario_02_Control.selecionarUsuario(codigoAtualizacao);

                if (usuarioAtualizacao != null) {
                    showUpdateDialog(usuarioAtualizacao);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuário não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
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

    private String getUsuarioInfo(Usuario_02 usuario) {
        // Construa uma string com as informações do usuário
        String infoUsuario = "Nome: " + usuario.getA02_nome() + "\n" +
                "Usuário: " + usuario.getA02_usuario() + "\n" +
                "Senha: " + usuario.getA02_senha() + "\n" +
                "Código Link: " + usuario.getA02_codigo_link() + "\n" +
                "Email: " + usuario.getA02_email() + "\n" +
                "Status: " + usuario.getA02_status() + "\n" +
                "Data de Cadastro: " + usuario.getA02_dt_cadastro() + "\n" +
                "Data de Última Alteração: " + usuario.getA02_dt_ultima_alteracao() + "\n";
        return infoUsuario;
    }

    private void clearFields() {
        jt_nome.setText("");
        jt_usuario.setText("");
        jt_senha.setText("");
        jt_codigo_link.setText("");
        jt_email.setText("");
        jt_status.setText("");
        jt_dt_cadastro.setText("");
        jt_dt_ultima_alteracao.setText("");
    }

    private void showUpdateDialog(Usuario_02 oUsuario) {
        JDialog popup = new JDialog(this, "Atualizar Usuário", true);
        popup.setLayout(new GridLayout(9, 2));

        JTextField jt_nome = new JTextField(oUsuario.getA02_nome());
        JTextField jt_usuario = new JTextField(oUsuario.getA02_usuario());
        JTextField jt_senha = new JTextField(oUsuario.getA02_senha());
        JTextField jt_codigo_link = new JTextField(oUsuario.getA02_codigo_link());
        JTextField jt_email = new JTextField(oUsuario.getA02_email());
        JTextField jt_status = new JTextField(Integer.toString(oUsuario.getA02_status()));
        JTextField jt_dt_cadastro = new JTextField(oUsuario.getA02_dt_cadastro().toString());
        JTextField jt_dt_ultima_alteracao = new JTextField(oUsuario.getA02_dt_ultima_alteracao().toString());

        JButton jb_confirmar = new JButton("Confirmar");
        JButton jb_cancelar = new JButton("Cancelar");

        popup.add(new JLabel("Nome:"));
        popup.add(jt_nome);
        popup.add(new JLabel("Usuário:"));
        popup.add(jt_usuario);
        popup.add(new JLabel("Senha:"));
        popup.add(jt_senha);
        popup.add(new JLabel("Código Link:"));
        popup.add(jt_codigo_link);
        popup.add(new JLabel("Email:"));
        popup.add(jt_email);
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
                oUsuario.setA02_nome(jt_nome.getText());
                oUsuario.setA02_usuario(jt_usuario.getText());
                oUsuario.setA02_senha(jt_senha.getText());
                oUsuario.setA02_codigo_link(jt_codigo_link.getText());
                oUsuario.setA02_email(jt_email.getText());
                oUsuario.setA02_status(Integer.parseInt(jt_status.getText()));
                oUsuario.setA02_dt_cadastro(Date.valueOf(jt_dt_cadastro.getText()));
                oUsuario.setA02_dt_ultima_alteracao(Date.valueOf(jt_dt_ultima_alteracao.getText()));
                oUsuario_02_Control.atualizarUsuario(oUsuario);
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
            Usuario_02_View obj_interface = new Usuario_02_View();
            obj_interface.setVisible(true);
        });
    }
}
