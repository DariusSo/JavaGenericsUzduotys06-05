package org.example;

import java.time.LocalDate;

public class Maistas extends Produktas{
    private LocalDate galiojimoData;

    public Maistas(int id, String pavadinimas, double kaina, LocalDate galiojimoData) {
        super(id, pavadinimas, kaina);
        this.galiojimoData = galiojimoData;
    }

    public LocalDate getGaliojimoData() {
        return galiojimoData;
    }

    public void setGaliojimoData(LocalDate galiojimoData) {
        this.galiojimoData = galiojimoData;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + ", Pavadinimas: " + getPavadinimas() + ", Kaina: " + getKaina() + ", Galiojimo data: " + galiojimoData;
    }
}
