package Pck_Control;

import Pck_Model.Usuario_agenda_05;
import Pck_Persistencia.Usuario_Agenda_05_Persistencia;

public class Usuario_agenda_05_Control {

    private Usuario_Agenda_05_Persistencia persistencia;

    public Usuario_agenda_05_Control() {
        this.persistencia = new Usuario_Agenda_05_Persistencia();
    }

    public void inserirUsuarioAgenda05(Usuario_agenda_05 usuario) {
        persistencia.insertUsuarioAgenda05(usuario);
    }

    public void atualizarUsuarioAgenda05(Usuario_agenda_05 usuario) {
        persistencia.updateUsuarioAgenda05(usuario);
    }

    public void excluirUsuarioAgenda05(int a05Codigo) {
        persistencia.deleteUsuarioAgenda05(a05Codigo);
    }

    public Usuario_agenda_05 selecionarUsuarioAgenda05(int a05Codigo) {
        return persistencia.selectUsuarioAgenda05(a05Codigo);
    }
}
