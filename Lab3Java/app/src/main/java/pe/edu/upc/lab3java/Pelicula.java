package pe.edu.upc.lab3java;

public class Pelicula {

    private String titulo;
    private String genero;
    private String año;

    public Pelicula(String titulo, String genero, String año) {
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}