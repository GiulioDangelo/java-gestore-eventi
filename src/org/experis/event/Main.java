package org.experis.event;
import sun.util.resources.LocaleData;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProgramEvento lista = new ProgramEvento("Elenco eventi");

        do {
            try {
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

                System.out.println("Inserisci il numero di posti da disdire, altrimenti digita 'continua' ");
                String input = scan.nextLine();
                if (Objects.equals(input, "continua")) {
                    System.out.println("*************************************");
                } else {
                    int disdire = Integer.parseInt(input);
                    evento.disdiciPosti(disdire);
                }

                System.out.println("vuoi aggiungere l'evento alla lista? y/n");
                String risposta = scan.nextLine().toLowerCase();
                if (Objects.equals(risposta,"y")){
                    lista.aggiungiEvento(evento);
                    lista.listaFormattata();
                } else {
                    System.out.println("Programma terminato");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Inserire una data nel formato yyyy-MM-dd.");
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Assicurati di inserire un numero.");
            }

            System.out.println("vuoi creare un nuovo evento? y/n");
        } while (scan.nextLine().equalsIgnoreCase("y"));

    }
}
