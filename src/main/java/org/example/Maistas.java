package org.example;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
    public <T >List<Maistas> gautiProduktusArtiGaliojimoPabaigos(int dienos, List<T> produktasList){
        List<Maistas> newList = new ArrayList<>();
        for(T t : produktasList){
            if(t instanceof Maistas){
                LocalDate ld = LocalDate.now();
                int days = (int) ChronoUnit.DAYS.between(ld, ((Maistas) t).galiojimoData);
                if(days < 7){
                    newList.add((Maistas) t);
                }
//                ld = ld.minusYears(((Maistas) t).galiojimoData.getYear());
//                ld = ld.minusMonths(((Maistas) t).galiojimoData.getMonthValue());
//                ld = ld.minusDays(((Maistas) t).galiojimoData.getDayOfMonth());
//                if(ld.getYear() == 0 && ld.getMonthValue() == 0 && ld.getDayOfMonth() < 7){
//                    newList.add((Maistas) t);
//                }
            }
        }
        return newList;
    }
}
