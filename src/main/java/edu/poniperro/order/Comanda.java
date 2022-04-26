package edu.poniperro.order;

import edu.poniperro.items.Item;

import java.util.List;

public interface Comanda {




    //Metodos
    public void addItem(String nombre, Double precio);

    //No se si está bien puesto los str
    public void addItem (String nombre,Double precio, String extra);

    //No se como poner lo de la lista
    public List<Item> itemList();
    public Double getTotal();

    public void  updateTotal(Double total);
    public void display();




}
