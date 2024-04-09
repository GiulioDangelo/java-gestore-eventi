package org.experis.event;
import java.time.LocalDate;

public class Evento {
    private String titolo;
    private int capienzaMassima;
    private int postiPrenotati;
    LocalDate dataEvento;

    public Evento(String titolo, int capienzaMassima, LocalDate dataEvento) throws IllegalArgumentException {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Il titolo dell'evento non puo' essere vuoto");
        }
        this.titolo = titolo;

        if (capienzaMassima <= 0) {
            throw new IllegalArgumentException("La capienza massima deve essere maggiore o uguale a 0");
        }
        this.capienzaMassima = capienzaMassima;

        this.postiPrenotati = 0;

        if (dataEvento.isBefore(LocalDate.now())){
            System.out.println(LocalDate.now());
            throw new IllegalArgumentException("La data dell'evento deve essere successiva a quella odierna");
        }
        this.dataEvento = dataEvento;
    }

    public void prenotaPosti(int postiDaPrenotare) throws IllegalArgumentException {
        if (postiDaPrenotare + postiPrenotati > capienzaMassima || postiDaPrenotare < 0) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili per prenotare o hai inserito un numero di posti non valido");
        }

        if (dataEvento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento e' gia' passato.");
        }

        postiPrenotati += postiDaPrenotare;
    }

    public void disdiciPosti(int postiDaDisdire) throws IllegalArgumentException {
        if (postiDaDisdire > postiPrenotati || postiDaDisdire < 0) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti prenotati per disdire o hai inserito un numero di posti non valido");
        }

        if (dataEvento.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento e' gia' passato.");
        }

        postiPrenotati -= postiDaDisdire;
        System.out.println("Disdetta effettuata con successo , posti prenotati: " + postiPrenotati);
        System.out.println("Posti disponibili: " + (capienzaMassima - postiPrenotati));
    }

    public String getTitolo() {
        return titolo;
    }

    public int getCapienzaMassima() {
        return capienzaMassima;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    @Override
    public String toString() {
        return "Evento{" + "titolo='" + titolo + '\'' + ", dataEvento=" + dataEvento + '}';
    }
}
