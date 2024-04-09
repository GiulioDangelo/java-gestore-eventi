package org.experis.event;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Concerto extends Evento{
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, int capienzaMassima, LocalDate dataEvento ,LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(titolo, capienzaMassima, dataEvento);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalDateTime formatDataOra() {
        return LocalDateTime.of(getDataEvento(), ora);
    }

    public String formatPrezzo() {
        DecimalFormat formato = new DecimalFormat("##,##0.00€");
        return formato.format(prezzo);
    }

    public LocalTime getOra() {
        return ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Concerto{" + "ora=" + ora + ", prezzo=" + prezzo + ", dataEvento=" + dataEvento + '}';
    }
}
