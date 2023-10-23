package Pck_Control;

import java.sql.SQLException;

import Pck_Model.Agenda_04;
import Pck_Persistencia.Agenda_04_Persistencia;

public class Agenda_04_Control {

    private Agenda_04_Persistencia agendaPersistencia = new Agenda_04_Persistencia();

    public Agenda_04 selecionarAgenda(int a04_codigo) throws SQLException {
        return agendaPersistencia.selectAgenda_04(a04_codigo);
    }

    public void inserirAgenda(Agenda_04 agenda) throws SQLException {
        agendaPersistencia.insertAgenda_04(agenda);
    }

    public void alterarAgenda(Agenda_04 agenda) throws SQLException {
        agendaPersistencia.updateAgenda_04(agenda);
    }

    public void deletarAgenda(Agenda_04 agenda) throws SQLException {
        int a04_codigo = agenda.getA04_codigo(); // Obtém o código da agenda
        agendaPersistencia.deleteAgenda_04(a04_codigo); // Chama a função de exclusão com o código da agenda
    }

}
