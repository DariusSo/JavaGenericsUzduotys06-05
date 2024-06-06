package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ProduktuKatalogas <T extends Produktas>{
    private List<T> productList = new ArrayList<>();

    public List<T> getProductList() {
        return productList;
    }

    public void setProductList(List<T> productList) {
        this.productList = productList;
    }

    public void pridetiProdukta(T produktas){
        boolean f = false;
        for(T t : productList){
            if(t.getId() == produktas.getId()){
                f = true;
            }
        }if(f == true){
            System.out.println("Id turi buti unikalus");
        }else{
            productList.add(produktas);
        }
    }
    public void pasalintiProdukta(int id){
        T v = null;
        boolean f = false;
        for(T t : productList){
            if(t.getId() == id){
                v = t;
                f = true;
            }
        }if(f == true){
            productList.remove(v);
        }else{
            System.out.println("Toks produktas nerastas");
        }
    }
    public List<T> gautiProduktusPagalKaina(double minKaina, double maxKaina){
        List<T> newList = new ArrayList<>();
        for(T t : productList){
            if(minKaina <= t.getKaina() && t.getKaina() <= maxKaina){
                newList.add(t);
            }
        }
        return newList;
    }
    public void spausdintiVisusProduktus(){
        for(T t : productList){
            System.out.println(t);
        }
    }
    public T gautiProduktaPagalPavadinima(String pavadinimas){
        for(T t : productList){
            if(Objects.equals(t.getPavadinimas(), pavadinimas)){
                return t;
            }
        }
        return null;
    }
    public void rusiuotiPagalPavadinima(){
        Collections.sort(productList, new Comparator<T>() {
            @Override
            public int compare(T t, T t1) {
                return t.getPavadinimas().compareTo(t1.getPavadinimas());
            }
        });
    }
    public void rusiuotiPagalKaina(){
        Collections.sort(productList, Comparator.comparing(T::getKaina));
    }
    public void issaugotiProduktus(String failoVardas) throws IOException {
        String path = "C:\\Users\\Darius\\IdeaProjects\\JavaGenericsUzduotys06-05\\src\\main\\java\\org\\example\\" + failoVardas;
        FileWriter fileWriter = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(T t : productList){
            bufferedWriter.write(t.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }


}
