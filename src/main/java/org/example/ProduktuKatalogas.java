package org.example;

import java.util.ArrayList;
import java.util.List;

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
            if(minKaina <= t.getKaina() || t.getKaina() <= maxKaina){
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

}
