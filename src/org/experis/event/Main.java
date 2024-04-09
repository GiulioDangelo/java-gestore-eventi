package org.experis.event;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il nome dell'evento");
        String nome = scan.nextLine();

        System.out.println("Inserisci il numero massimo di posti");
        int capienza = scan.nextInt();
        scan.nextLine();

        System.out.println("Inserisci la data dell'evento in formato yyyy-mm-dd");
        String dataInput = scan.nextLine();
        LocalDate data = LocalDate.parse(dataInput);

        Evento evento = new Evento(nome,capienza, data);
        System.out.println(evento);

        System.out.println("Inserisci il numero di posti prenotati");
        int prenotati = scan.nextInt();
        scan.nextLine();
        evento.prenotaPosti(prenotati);

        System.out.println("posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("posti disponibili: " + (capienza - evento.getPostiPrenotati()));

        System.out.println("Inserisci il numero di posti da disdire, altrimenti digita 'stop' ");
        String input = scan.nextLine();
        if (Objects.equals(input, "stop")) {
            System.out.println("Programma terminato");
        } else {
            int disdire = Integer.parseInt(input);
            evento.disdiciPosti(disdire);
        }
    }
}
