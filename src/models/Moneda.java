package models;

public class Moneda {

    private String codigo;
    private String pais;

    public Moneda(String codigo, String pais) {
        this.codigo = codigo;
        this.pais = pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return codigo + " - " + pais;
    }
}
