import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Inserimento dettagli evento
            System.out.print("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la data dell'evento (dd/MM/yyyy): ");
            String dataInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataInput, formatter);

            System.out.print("Inserisci il numero di posti totali: ");
            int numeroPostiTotali = scanner.nextInt();

            // Creazione evento
            Evento evento = new Evento(titolo, data, numeroPostiTotali);

            // Prenotazioni
            System.out.print("Quante prenotazioni vuoi fare? ");
            int prenotazioni = scanner.nextInt();
            for (int i = 0; i < prenotazioni; i++) {
                evento.prenota();
            }

            System.out.println("Numero di posti prenotati: " + evento.getNumeroPostiPrenotati());
            System.out.println("Numero di posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));

            // Disdette
            System.out.print("Quante prenotazioni vuoi disdire? ");
            int disdette = scanner.nextInt();
            for (int i = 0; i < disdette; i++) {
                evento.disdici();
            }

            System.out.println("Numero di posti prenotati: " + evento.getNumeroPostiPrenotati());
            System.out.println("Numero di posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}