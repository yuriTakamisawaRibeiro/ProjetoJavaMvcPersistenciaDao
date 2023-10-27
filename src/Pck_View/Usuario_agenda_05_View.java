package Pck_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Pck_Control.Usuario_agenda_05_Control;
import Pck_Model.Usuario_agenda_05;

public class Usuario_agenda_05_View extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField jt_a04Codigo, jt_a02Codigo, jt_a05NumSequencia, jt_a05PerfilTitular, jt_a05PerfilFacilitador,
            jt_a05PerfilEspecialista, jt_a05PerfilAnalista, jt_a05DtCadastro, jt_a05DtUltimaAlteracao;
    private JButton jb_inserir, jb_excluir, jb_selecionar, jb_atualizar;
    private JTextField jt_codigoExclusao, jt_codigoSelecao, jt_codigoAtualizacao;

    private Usuario_agenda_05_Control usuarioAgenda05Control = new Usuario_agenda_05_Control();

    public Usuario_agenda_05_View() {
        setTitle("View UsuarioAgenda05");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(17, 2));

        addLabelAndField("A04 Código:", jt_a04Codigo = new JTextField());
        addLabelAndField("A02 Código:", jt_a02Codigo = new JTextField());
        addLabelAndField("A05 Número Sequência:", jt_a05NumSequencia = new JTextField());
        addLabelAndField("A05 Perfil Titular:", jt_a05PerfilTitular = new JTextField());
        addLabelAndField("A05 Perfil Facilitador:", jt_a05PerfilFacilitador = new JTextField());
        addLabelAndField("A05 Perfil Especialista:", jt_a05PerfilEspecialista = new JTextField());
        addLabelAndField("A05 Perfil Analista:", jt_a05PerfilAnalista = new JTextField());
        addLabelAndField("A05 Data de Cadastro (dd-MM-yyyy):", jt_a05DtCadastro = new JTextField());
        addLabelAndField("A05 Data de Última Alteração (dd-MM-yyyy):", jt_a05DtUltimaAlteracao = new JTextField());

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
                int a04Codigo = Integer.parseInt(jt_a04Codigo.getText());
                int a02Codigo = Integer.parseInt(jt_a02Codigo.getText());
                int a05NumSequencia = Integer.parseInt(jt_a05NumSequencia.getText());
                int a05PerfilTitular = Integer.parseInt(jt_a05PerfilTitular.getText());
                int a05PerfilFacilitador = Integer.parseInt(jt_a05PerfilFacilitador.getText());
                int a05PerfilEspecialista = Integer.parseInt(jt_a05PerfilEspecialista.getText());
                int a05PerfilAnalista = Integer.parseInt(jt_a05PerfilAnalista.getText());
                Date a05DtCadastro = parseDate(jt_a05DtCadastro.getText());
                Date a05DtUltimaAlteracao = parseDate(jt_a05DtUltimaAlteracao.getText());

                // Crie um objeto UsuarioAgenda05 com os dados apropriados.
                Usuario_agenda_05 usuario = new Usuario_agenda_05();
                usuario.setA04_codigo(a04Codigo);
                usuario.setA02_codigo(a02Codigo);
                usuario.setA05_num_sequencia(a05NumSequencia);
                usuario.setA05_perfil_agenda_usuario_titular(a05PerfilTitular);
                usuario.setA05_perfil_agenda_facilitador(a05PerfilFacilitador);
                usuario.setA05_perfil_agenda_especialista(a05PerfilEspecialista);
                usuario.setA05_perfil_agenda_analista(a05PerfilAnalista);
                usuario.setA05_dt_cadastro(a05DtCadastro);
                usuario.setA05_dt_ultima_alteracao(a05DtUltimaAlteracao);

                usuarioAgenda05Control.inserirUsuarioAgenda05(usuario);

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
                usuarioAgenda05Control.excluirUsuarioAgenda05(codigoExclusao);

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
                Usuario_agenda_05 usuarioSelecionado = usuarioAgenda05Control.selecionarUsuarioAgenda05(codigoSelecao);

                if (usuarioSelecionado != null) {
                    // Exiba as informações do usuário selecionado
                    JOptionPane.showMessageDialog(this, getUsuarioAgenda05Info(usuarioSelecionado),
                            "Usuário Selecionado",
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
                Usuario_agenda_05 usuarioAtualizacao = usuarioAgenda05Control
                        .selecionarUsuarioAgenda05(codigoAtualizacao);

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date parsedDate = dateFormat.parse(dateStr);
        return new Date(parsedDate.getTime());
    }

    private String getUsuarioAgenda05Info(Usuario_agenda_05 usuario) {
        // Construa uma string com as informações do usuário
        String infoUsuario = "A04 Código: " + usuario.getA04_codigo() + "\n" +
                "A02 Código: " + usuario.getA02_codigo() + "\n" +
                "A05 Número Sequência: " + usuario.getA05_num_sequencia() + "\n" +
                "A05 Perfil Titular: " + usuario.getA05_perfil_agenda_usuario_titular() + "\n" +
                "A05 Perfil Facilitador: " + usuario.getA05_perfil_agenda_facilitador() + "\n" +
                "A05 Perfil Especialista: " + usuario.getA05_perfil_agenda_especialista() + "\n" +
                "A05 Perfil Analista: " + usuario.getA05_perfil_agenda_analista() + "\n" +
                "A05 Data de Cadastro: " + usuario.getA05_dt_cadastro() + "\n" +
                "A05 Data de Última Alteração: " + usuario.getA05_dt_ultima_alteracao() + "\n";
        return infoUsuario;
    }

    private void clearFields() {
        jt_a04Codigo.setText("");
        jt_a02Codigo.setText("");
        jt_a05NumSequencia.setText("");
        jt_a05PerfilTitular.setText("");
        jt_a05PerfilFacilitador.setText("");
        jt_a05PerfilEspecialista.setText("");
        jt_a05PerfilAnalista.setText("");
        jt_a05DtCadastro.setText("");
        jt_a05DtUltimaAlteracao.setText("");
    }

    private void showUpdateDialog(Usuario_agenda_05 usuario) {
        JDialog popup = new JDialog(this, "Atualizar Usuário", true);
        popup.setLayout(new GridLayout(9, 2));

        JTextField jt_a04Codigo = new JTextField(Integer.toString(usuario.getA04_codigo()));
        JTextField jt_a02Codigo = new JTextField(Integer.toString(usuario.getA02_codigo()));
        JTextField jt_a05NumSequencia = new JTextField(Integer.toString(usuario.getA05_num_sequencia()));
        JTextField jt_a05PerfilTitular = new JTextField(
                Integer.toString(usuario.getA05_perfil_agenda_usuario_titular()));
        JTextField jt_a05PerfilFacilitador = new JTextField(
                Integer.toString(usuario.getA05_perfil_agenda_facilitador()));
        JTextField jt_a05PerfilEspecialista = new JTextField(
                Integer.toString(usuario.getA05_perfil_agenda_especialista()));
        JTextField jt_a05PerfilAnalista = new JTextField(Integer.toString(usuario.getA05_perfil_agenda_analista()));
        JTextField jt_a05DtCadastro = new JTextField(usuario.getA05_dt_cadastro().toString());
        JTextField jt_a05DtUltimaAlteracao = new JTextField(usuario.getA05_dt_ultima_alteracao().toString());

        JButton jb_confirmar = new JButton("Confirmar");
        JButton jb_cancelar = new JButton("Cancelar");

        popup.add(new JLabel("A04 Código:"));
        popup.add(jt_a04Codigo);
        popup.add(new JLabel("A02 Código:"));
        popup.add(jt_a02Codigo);
        popup.add(new JLabel("A05 Número Sequência:"));
        popup.add(jt_a05NumSequencia);
        popup.add(new JLabel("A05 Perfil Titular:"));
        popup.add(jt_a05PerfilTitular);
        popup.add(new JLabel("A05 Perfil Facilitador:"));
        popup.add(jt_a05PerfilFacilitador);
        popup.add(new JLabel("A05 Perfil Especialista:"));
        popup.add(jt_a05PerfilEspecialista);
        popup.add(new JLabel("A05 Perfil Analista:"));
        popup.add(jt_a05PerfilAnalista);
        popup.add(new JLabel("A05 Data de Cadastro (dd-MM-yyyy):"));
        popup.add(jt_a05DtCadastro);
        popup.add(new JLabel("A05 Data de Última Alteração (dd-MM-yyyy):"));
        popup.add(jt_a05DtUltimaAlteracao);
        popup.add(jb_confirmar);
        popup.add(jb_cancelar);

        jb_confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setA04_codigo(Integer.parseInt(jt_a04Codigo.getText()));
                usuario.setA02_codigo(Integer.parseInt(jt_a02Codigo.getText()));
                usuario.setA05_num_sequencia(Integer.parseInt(jt_a05NumSequencia.getText()));
                usuario.setA05_perfil_agenda_usuario_titular(Integer.parseInt(jt_a05PerfilTitular.getText()));
                usuario.setA05_perfil_agenda_facilitador(Integer.parseInt(jt_a05PerfilFacilitador.getText()));
                usuario.setA05_perfil_agenda_especialista(Integer.parseInt(jt_a05PerfilEspecialista.getText()));
                usuario.setA05_perfil_agenda_analista(Integer.parseInt(jt_a05PerfilAnalista.getText()));

                try {
                    usuario.setA05_dt_cadastro(parseDate(jt_a05DtCadastro.getText()));
                    usuario.setA05_dt_ultima_alteracao(parseDate(jt_a05DtUltimaAlteracao.getText()));
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(popup, "Erro ao converter datas. Use o formato dd-MM-yyyy", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Atualize o usuário no banco de dados
                usuarioAgenda05Control.atualizarUsuarioAgenda05(usuario);

                // Feche a janela de atualização
                popup.dispose();

                JOptionPane.showMessageDialog(Usuario_agenda_05_View.this, "Usuário atualizado com sucesso!");
            }
        });

        jb_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Feche a janela de atualização sem fazer alterações
                popup.dispose();
            }
        });

        popup.pack();
        popup.setLocationRelativeTo(this);
        popup.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Usuario_agenda_05_View().setVisible(true);
            }
        });
    }
}
