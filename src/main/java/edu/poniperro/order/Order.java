package edu.poniperro.order;

import edu.poniperro.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Order implements Comanda{

    //Atributos
    private Double total = 0d;
    private List<Item> comandaItems = new ArrayList<>();

    //Constructor
    public Order(){}

    //Métodos
    @Override
    public void addItem(String nombre, Double precio) {
        Item nuevoItem = new Item(nombre, precio);
        this.comandaItems.add(nuevoItem);
    }

    @Override
    public void addItem(String nombre, Double precio, String extra) {
        Item nuevoItem = new Item(nombre, precio, extra);
        this.comandaItems.add(nuevoItem);
    }

    @Override
    public List<Item> itemList() {
        return comandaItems;
    }

    @Override
    public Double getTotal() {
        return total;
    }

    @Override
    public void updateTotal(Double precio) {
        total += precio;
    }

    @Override
    public void display() {
        System.out.println("\n\t ---ORDER---");
        itemList().stream().forEach(item -> {
            itemDisplay(item);
        });
    }

    private void itemDisplay(Item item){
        System.out.println("\t" + item );
    }

    private int size (){
        //size es talla pero he mirado el tuyo y no sé porque has hecho la lista.size como has llegado a la conclusión?
        return comandaItems.size();
    }
}
