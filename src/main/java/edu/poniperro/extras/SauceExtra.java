package edu.poniperro.extras;

import edu.poniperro.items.RetailPrice;
import edu.poniperro.order.Comanda;

import java.util.Optional;

public class SauceExtra extends Extra{

    //Constructor
    public SauceExtra(){}

    //Método
    @Override
    public void sumExtras(Comanda comanda) {
        //Busca de la clase RetailPrice y coge el precio del extra que le pasemos por parámetros
        Double priceSauce = RetailPrice.getRetailPrice(SAUCE);

        Optional<Double> totalSauce = comanda.itemList()
                .stream()
                .filter(item -> item.extra() == SAUCE)
                .map(item -> priceSauce)
                .reduce(Double::sum);

        //Miramos si hay cosas presentes, en el caso de ser que si cogerá la comanda usará la función updateTotal y
        // los irá sumando uno a uno
        totalSauce.ifPresent(price -> comanda.updateTotal(price));

        //Mira si hay algún extra presente
        nextExtra.ifPresent(extra -> extra.sumExtras(comanda));
    }
}
