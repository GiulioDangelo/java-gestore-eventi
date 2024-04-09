package org.experis.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramEvento {
    private String title;
    private List<Evento> lista;

    public ProgramEvento(String title) {
        this.title = title;
        this.lista = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento){
        lista.add(evento);
    }

    public void cercaPerData(LocalDate data){
        for (Evento evento : lista) {
            if(evento.getDataEvento().equals(data)){
                System.out.println(evento);
            }
        }
    }

    public int lunghezzaLista(){
        return lista.size();
    }

    public void svuotaLista(){
        lista.clear();
    }

    public void listaFormattata(){
        for (Evento evento : lista) {
            System.out.println(evento.dataEvento + " - " + evento.getTitolo() + "\n");
        }
    }

}
