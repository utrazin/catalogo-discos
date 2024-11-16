import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Album {
    private List<Disco> faixas;
    private Set<Artista> artistas;

    public Album() {
        this.faixas = new ArrayList<>();
        this.artistas = new HashSet<>();
    }

    public List<Disco> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<Disco> faixas) {
        this.faixas = faixas;
    }

    public void addDisco(Disco disco) {
        faixas.add(disco);
    }

    public void removeDisco(Disco disco) {
        faixas.remove(disco);
    }

    public Set<Artista> getArtistas() {
        return artistas;
    }

    public void addArtista(Artista artista) {
        artistas.add(artista);
    }

    public void removeArtista(Artista artista) {
        artistas.remove(artista);
    }

    public void mostrarAlbum() {
        for (Disco disco : faixas) {
            System.out.println("\nDisco: " + disco.getTitulo()
            + "\nArtista: " + disco.getArtista().getNome()
            + "\nGênero: " + disco.getArtista().getGeneroMusical()
            + "\nAno: " + disco.getAnoLancamento());
        }
    }
}
