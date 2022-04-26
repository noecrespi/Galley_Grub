package edu.poniperro.items;

public class Item implements Product {
    //Métodos
    //package , no es necesario poner nada
    String name;
    Double price;
    String extra;

    // Contructor suelen ser públicos
    public Item(String contructorName, Double contructoPrice){
        this.name = contructorName;
        this.price = contructoPrice;
    }
    public Item(String contructorName, Double contructoPrice, String contructorExtra){
        this.name = contructorName;
        this.price = contructoPrice;
        this.extra = contructorExtra;
    }

    //Sobreescribe
    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Double price() {
        return this.price;
    }

    @Override
    public String extra() {
        return this.extra;
    }

    @Override
    public Boolean isRegular() {
        return extra() == null;
    }

    //@Override con el toString siempre tienen que ir unido
    @Override
    public String toString(){

        return isRegular()
                ? name() + "...." + price().toString() + "$"
                : name() + " w/ " + extra() + "...." + price().toString() + "$ + " + RetailPrice.getRetailPrice(extra()).toString() + "$";
    }
}
