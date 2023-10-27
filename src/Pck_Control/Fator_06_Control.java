package Pck_Control;

import java.sql.SQLException;

import Pck_Model.Fator_06;
import Pck_Persistencia.Fator_06_Persistencia;

public class Fator_06_Control {

    private Fator_06_Persistencia fatorPersistencia = new Fator_06_Persistencia();

    public Fator_06 selecionarFator(int a06_codigo) throws SQLException {
        return fatorPersistencia.selectFator(a06_codigo);
    }

    public void inserirFator(Fator_06 fator06) throws SQLException {
        fatorPersistencia.insertFator(fator06);
    }

    public void alterarFator(Fator_06 fator06) throws SQLException {
        fatorPersistencia.updateFator(fator06);
    }

    public void deletarFator(int a06_codigo) throws SQLException {
        fatorPersistencia.deleteFator(a06_codigo);
    }
}
