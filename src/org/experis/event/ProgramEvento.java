package org.experis.event;

import java.time.LocalDate;
import java.util.*;
import java.util.Collections;

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

    public void listaOrdinata(){
        Collections.sort(this.lista, new Comparator<Evento>() {
            @Override
            public int compare(Evento o1, Evento o2) {
                return o1.getDataEvento().compareTo(o2.getDataEvento());
            }
        });

        for (Evento evento : lista) {
            System.out.println(evento.getDataEvento() + " - " + evento.getTitolo() + "\n");
        }
    }
}
