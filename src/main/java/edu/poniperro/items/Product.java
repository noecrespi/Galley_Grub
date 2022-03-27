package edu.poniperro.items;

public interface Product {

    //Metodo
    // interfaces vacia, es decir tiene que tener funnciones pero no la lógica
    public String name();
    public Double price();
    public String extra();
    public Boolean isRegular();

}
