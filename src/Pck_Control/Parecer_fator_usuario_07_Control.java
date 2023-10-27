package Pck_Control;

import Pck_Model.Parecer_fator_usuario_07;
import Pck_Persistencia.Parecer_fator_usuario_07_Persistencia;

public class Parecer_fator_usuario_07_Control {
    private Parecer_fator_usuario_07_Persistencia persistencia;

    public Parecer_fator_usuario_07_Control() {
        persistencia = new Parecer_fator_usuario_07_Persistencia();
    }

    public void inserirParecerFatorUsuario07(Parecer_fator_usuario_07 parecer) {
        // Invoque o método de persistência para inserir o parecer
        persistencia.insertParecerFatorUsuario07(parecer);
    }

    public void atualizarParecerFatorUsuario07(Parecer_fator_usuario_07 parecer) {
        // Invoque o método de persistência para atualizar o parecer
        persistencia.updateParecerFatorUsuario07(parecer);
    }

    public void excluirParecerFatorUsuario07(int a07_codigo) {
        // Invoque o método de persistência para excluir o parecer
        persistencia.deleteParecerFatorUsuario07(a07_codigo);
    }

    public Parecer_fator_usuario_07 selecionarParecerFatorUsuario07(int a07_codigo) {
        // Invoque o método de persistência para selecionar o parecer
        return persistencia.selectParecerFatorUsuario07(a07_codigo);
    }
}