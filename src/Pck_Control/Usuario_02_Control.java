package Pck_Control;

import Pck_Model.Usuario_02;
import Pck_Persistencia.Usuario_02_Persistencia;

public class Usuario_02_Control {

    private Usuario_02_Persistencia persistencia;

    public Usuario_02_Control() {
        persistencia = new Usuario_02_Persistencia();
    }

    public void inserirUsuario(Usuario_02 usuario) {
        persistencia.insertUsuario_02(usuario);
    }

    public void atualizarUsuario(Usuario_02 usuario) {
        persistencia.updateUsuario_02(usuario);
    }

    public void excluirUsuario(int a02_codigo) {
        persistencia.deleteUsuario_02(a02_codigo);
    }

    public Usuario_02 selecionarUsuario(int a02_codigo) {
        return persistencia.selectUsuario_02(a02_codigo);
    }
}
