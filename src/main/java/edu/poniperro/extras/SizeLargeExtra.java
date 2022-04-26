package edu.poniperro.extras;

import edu.poniperro.items.RetailPrice;
import edu.poniperro.order.Comanda;

import java.util.Optional;

public class SizeLargeExtra extends Extra {

    //Constructor
    public SizeLargeExtra(){}

    //Método
    @Override
    public void sumExtras(Comanda comanda) {
        //Busca de la clase RetailPrice y coge el precio del extra que le pasemos por parámetros
        Double priceLarge = RetailPrice.getRetailPrice(SIZE_LARGE);

        Optional<Double> totalSize = comanda.itemList()
                .stream()
                .filter(item -> item.extra() == SIZE_LARGE)
                .map(item -> priceLarge)
                .reduce(Double::sum);

        //Miramos si hay cosas presentes, en el caso de ser que si cogerá la comanda usará la función updateTotal y
        // los irá sumando uno a uno
        totalSize.ifPresent(price -> comanda.updateTotal(price));

        //Mira si hay algún extra present
        nextExtra.ifPresent(extra -> extra.sumExtras(comanda));
    }
}
