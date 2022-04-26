package edu.poniperro.extras;

import edu.poniperro.items.RetailPrice;
import edu.poniperro.order.Comanda;

import java.util.Optional;

public class CheeseExtra extends Extra{

    //Constructor
    public CheeseExtra(){}

    //Método
    @Override
    public void sumExtras(Comanda comanda) {
        //Busca de la clase RetailPrice y coge el precio del extra que le pasemos por parámetros
        Double priceCheese = RetailPrice.getRetailPrice(CHEESE);

        Optional<Double> totalCheese = comanda.itemList()
                .stream()
                .filter(item -> item.extra() == CHEESE)
                .map(item -> priceCheese)
                .reduce(Double::sum);

        //Miramos si hay cosas presentes, en el caso de ser que si cogerá la comanda usará la función updateTotal y
        // los irá sumando uno a uno
        totalCheese.ifPresent(price -> comanda.updateTotal(price));

        //Mira si hay algún extra presente
        nextExtra.ifPresent(extra -> extra.sumExtras(comanda));
    }
}
