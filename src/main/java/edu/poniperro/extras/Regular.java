package edu.poniperro.extras;

import edu.poniperro.order.Comanda;

import java.util.Optional;

public class Regular extends Extra{

    //Contructor
    public Regular(){}

    //Método
    @Override
    public void sumExtras(Comanda comanda) {
        Optional<Double> totalRegular = comanda.itemList()
                .stream()
                .map(item -> item.price())
                .reduce(Double::sum);
        //Miramos si hay cosas presentes, en el caso de ser que si cogerá la comanda usará la función updateTotal y
        // los irá sumando uno a uno
        totalRegular.ifPresent(price -> comanda.updateTotal(price));

        //Mira si hay algún extra presente
        nextExtra.ifPresent(extra -> extra.sumExtras(comanda));
    }
}
