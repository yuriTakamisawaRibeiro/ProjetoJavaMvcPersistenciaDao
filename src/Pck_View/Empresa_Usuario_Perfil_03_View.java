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
import Pck_Control.Empresa_Usuario_Perfil_03_Control;
import Pck_Model.Empresa_usuario_perfil_03;

public class Empresa_Usuario_Perfil_03_View extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private JTextField jt_a01_codigo, jt_a03_dt_cadastro, jt_a03_dt_ultima_alteracao, jt_a03_perfil_praviverbem,
            jt_a03_perfil_administrador, jt_a03_perfil_chefe, jt_a03_perfil_padrao;
    private JButton jb_inserir, jb_excluir, jb_selecionar, jb_atualizar;
    private JTextField jt_a02_codigoExclusao, jt_a02_codigoSelecao, jt_a02_codigoAtualizacao;

    private Empresa_Usuario_Perfil_03_Control oEmpresa_Usuario_Perfil_03_Control = new Empresa_Usuario_Perfil_03_Control();

    public Empresa_Usuario_Perfil_03_View() {
        setTitle("View Empresa_Usuario_Perfil_03");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(17, 3));

        addLabelAndField("Código A01:", jt_a01_codigo = new JTextField());
        addLabelAndField("Data de Cadastro (dd-MM-yyyy):", jt_a03_dt_cadastro = new JTextField());
        addLabelAndField("Data de Última Alteração (dd-MM-yyyy):",
                jt_a03_dt_ultima_alteracao = new JTextField());
        addLabelAndField("Perfil Para Viver Bem (0 ou 1):", jt_a03_perfil_praviverbem = new JTextField());
        addLabelAndField("Perfil Administrador (0 ou 1):", jt_a03_perfil_administrador = new JTextField());
        addLabelAndField("Perfil Chefe (0 ou 1):", jt_a03_perfil_chefe = new JTextField());
        addLabelAndField("Perfil Padrão (0 ou 1):", jt_a03_perfil_padrao = new JTextField());

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
        addLabelAndField("Código A02 para Excluir:", jt_a02_codigoExclusao = new JTextField());
        add(new JLabel());
        add(jb_excluir);

        jt_a02_codigoExclusao = new JTextField();
        jt_a02_codigoSelecao = new JTextField();
        jt_a02_codigoAtualizacao = new JTextField();

        addLabelAndField("Código A02 para Selecionar:", jt_a02_codigoSelecao);
        add(jb_selecionar);
        addLabelAndField("Código A02 para Atualizar:", jt_a02_codigoAtualizacao);
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
                
                int a01_codigo = Integer.parseInt(jt_a01_codigo.getText());
                Date a03_dt_cadastro = parseDate(jt_a03_dt_cadastro.getText());
                Date a03_dt_ultima_alteracao = parseDate(jt_a03_dt_ultima_alteracao.getText());
                int a03_perfil_praviverbem = Integer.parseInt(jt_a03_perfil_praviverbem.getText());
                int a03_perfil_administrador = Integer.parseInt(jt_a03_perfil_administrador.getText());
                int a03_perfil_chefe = Integer.parseInt(jt_a03_perfil_chefe.getText());
                int a03_perfil_padrao = Integer.parseInt(jt_a03_perfil_padrao.getText());

                
                Empresa_usuario_perfil_03 empresaUsuarioPerfil03 = new Empresa_usuario_perfil_03(a01_codigo,
                        a03_perfil_padrao, a03_dt_cadastro, a03_dt_ultima_alteracao, a03_perfil_praviverbem,
                        a03_perfil_administrador, a03_perfil_chefe, a03_perfil_padrao);

                oEmpresa_Usuario_Perfil_03_Control.inserirEmpresaUsuarioPerfil03(empresaUsuarioPerfil03);

                
                clearFields();
                JOptionPane.showMessageDialog(this, "Inserido com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_excluir) {
            try {
                
                int a02_codigoExclusao = Integer.parseInt(jt_a02_codigoExclusao.getText());
                oEmpresa_Usuario_Perfil_03_Control.deletarEmpresaUsuarioPerfil03(a02_codigoExclusao);

               
                jt_a02_codigoExclusao.setText("");

                JOptionPane.showMessageDialog(this, "Empresa excluída com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == jb_selecionar) {
            try {
                int a02_codigoSelecao = Integer.parseInt(jt_a02_codigoSelecao.getText());
                Empresa_usuario_perfil_03 empresaSelecionada = oEmpresa_Usuario_Perfil_03_Control
                        .selecionarEmpresaUsuarioPerfil03(a02_codigoSelecao);

                if (empresaSelecionada != null) {
                    
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
                int a02_codigoAtualizacao = Integer.parseInt(jt_a02_codigoAtualizacao.getText());
                Empresa_usuario_perfil_03 empresaAtualizacao = oEmpresa_Usuario_Perfil_03_Control
                        .selecionarEmpresaUsuarioPerfil03(a02_codigoAtualizacao);

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

    private String getEmpresaInfo(Empresa_usuario_perfil_03 empresa) {
        
        String infoEmpresa = "Código A01: " + empresa.getA01_codigo() + "\n" +
                "Código A02: " + empresa.getA02_codigo() + "\n" +
                "Data de Cadastro: " + empresa.getA03_dt_cadastro() + "\n" +
                "Data de Última Alteração: " + empresa.getA03_dt_ultima_alteracao() + "\n" +
                "Perfil Para Viver Bem: " + empresa.getA03_perfil_praviverbem() + "\n" +
                "Perfil Administrador: " + empresa.getA03_perfil_administrador() + "\n" +
                "Perfil Chefe: " + empresa.getA03_perfil_chefe() + "\n" +
                "Perfil Padrão: " + empresa.getA03_perfil_padrao() + "\n";
        return infoEmpresa;
    }

    private void clearFields() {
        jt_a01_codigo.setText("");
        jt_a03_dt_cadastro.setText("");
        jt_a03_dt_ultima_alteracao.setText("");
        jt_a03_perfil_praviverbem.setText("");
        jt_a03_perfil_administrador.setText("");
        jt_a03_perfil_chefe.setText("");
        jt_a03_perfil_padrao.setText("");
    }

    private void showUpdateDialog(Empresa_usuario_perfil_03 empresa) {
        JDialog popup = new JDialog(this, "Atualizar Empresa", true);
        popup.setLayout(new GridLayout(9, 2));

        JTextField jt_a01_codigo = new JTextField(Integer.toString(empresa.getA01_codigo()));
        JTextField jt_a03_dt_cadastro = new JTextField(empresa.getA03_dt_cadastro().toString());
        JTextField jt_a03_dt_ultima_alteracao = new JTextField(empresa.getA03_dt_ultima_alteracao().toString());
        JTextField jt_a03_perfil_praviverbem = new JTextField(Integer.toString(empresa.getA03_perfil_praviverbem()));
        JTextField jt_a03_perfil_administrador = new JTextField(
                Integer.toString(empresa.getA03_perfil_administrador()));
        JTextField jt_a03_perfil_chefe = new JTextField(Integer.toString(empresa.getA03_perfil_chefe()));
        JTextField jt_a03_perfil_padrao = new JTextField(Integer.toString(empresa.getA03_perfil_padrao()));

        JButton jb_confirmar = new JButton("Confirmar");
        JButton jb_cancelar = new JButton("Cancelar");

        popup.add(new JLabel("Código A01:"));
        popup.add(jt_a01_codigo);
        popup.add(new JLabel("Data de Cadastro (dd-MM-yyyy):"));
        popup.add(jt_a03_dt_cadastro);
        popup.add(new JLabel("Data de Última Alteração (dd-MM-yyyy):"));
        popup.add(jt_a03_dt_ultima_alteracao);
        popup.add(new JLabel("Perfil Para Viver Bem (0 ou 1):"));
        popup.add(jt_a03_perfil_praviverbem);
        popup.add(new JLabel("Perfil Administrador (0 ou 1):"));
        popup.add(jt_a03_perfil_administrador);
        popup.add(new JLabel("Perfil Chefe (0 ou 1):"));
        popup.add(jt_a03_perfil_chefe);
        popup.add(new JLabel("Perfil Padrão (0 ou 1):"));
        popup.add(jt_a03_perfil_padrao);
        popup.add(jb_confirmar);
        popup.add(jb_cancelar);

        jb_confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empresa.setA01_codigo(Integer.parseInt(jt_a01_codigo.getText()));
                empresa.setA03_dt_cadastro(Date.valueOf(jt_a03_dt_cadastro.getText()));
                empresa.setA03_dt_ultima_alteracao(Date.valueOf(jt_a03_dt_ultima_alteracao.getText()));
                empresa.setA03_perfil_praviverbem(Integer.parseInt(jt_a03_perfil_praviverbem.getText()));
                empresa.setA03_perfil_administrador(Integer.parseInt(jt_a03_perfil_administrador.getText()));
                empresa.setA03_perfil_chefe(Integer.parseInt(jt_a03_perfil_chefe.getText()));
                empresa.setA03_perfil_padrao(Integer.parseInt(jt_a03_perfil_padrao.getText()));
                try {
                    oEmpresa_Usuario_Perfil_03_Control.alterarEmpresaUsuarioPerfil03(empresa);
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
            Empresa_Usuario_Perfil_03_View obj_interface = new Empresa_Usuario_Perfil_03_View();
            obj_interface.setVisible(true);
        });
    }
}
