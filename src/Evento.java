import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;

    // Costruttore
    public Evento(String titolo, LocalDate data, int numeroPostiTotali) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere già passata.");
        }
        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;
    }

    // Getter e Setter
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere già passata.");
        }
        this.data = data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    // Metodi public
    public void prenota() {
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Non è possibile prenotare posti per un evento già passato.");
        } else if (numeroPostiPrenotati >= numeroPostiTotali) {
            System.out.println("Non ci sono posti disponibili.");
        } else {
            numeroPostiPrenotati++;
        }
    }

    public void disdici() {
        if (data.isBefore(LocalDate.now())) {
            System.out.println("Non è possibile disdire posti per un evento già passato.");
        } else if (numeroPostiPrenotati <= 0) {
            System.out.println("Non ci sono prenotazioni da disdire.");
        } else {
            numeroPostiPrenotati--;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
        }    
    }