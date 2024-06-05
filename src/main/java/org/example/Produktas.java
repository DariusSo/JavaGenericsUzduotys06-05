package org.example;

public class Produktas {
    private int id;
    private String pavadinimas;
    private double kaina;

    public Produktas(int id, String pavadinimas, double kaina) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    @Override
    public String toString() {
        return "Produktas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kaina=" + kaina +
                '}';
    }
}
