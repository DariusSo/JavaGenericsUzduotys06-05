package org.example;

public class BuitineTechnika extends Produktas{
    private int garantija;
    private String energijosKlase;

    public BuitineTechnika(int id, String pavadinimas, double kaina, int garantija, String energijosKlase) {
        super(id, pavadinimas, kaina);
        this.garantija = garantija;
        this.energijosKlase = energijosKlase;
    }

    public int getGarantija() {
        return garantija;
    }

    public void setGarantija(int garantija) {
        this.garantija = garantija;
    }

    public String getEnergijosKlase() {
        return energijosKlase;
    }

    public void setEnergijosKlase(String energijosKlase) {
        this.energijosKlase = energijosKlase;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Pavadinimas: " + getPavadinimas() + ", Kaina: " + getKaina() + ", Garantija: " + garantija + ", Energijos klase: " + energijosKlase;
    }
}
