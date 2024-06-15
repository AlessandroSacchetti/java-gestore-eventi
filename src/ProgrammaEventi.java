import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    public List<Evento> getEventiPerData(LocalDate data) {
        return eventi.stream()
                     .filter(evento -> evento.getData().isEqual(data))
                     .collect(Collectors.toList());
    }

    public int getNumeroEventi() {
        return eventi.size();
    }

    public void svuotaEventi() {
        eventi.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(titolo).append("\n");
        eventi.stream()
              .sorted((e1, e2) -> e1.getData().compareTo(e2.getData()))
              .forEach(evento -> sb.append(evento.toString()).append("\n"));
        return sb.toString();
    }
}