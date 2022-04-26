package edu.poniperro.extras;

import edu.poniperro.order.Comanda;

import java.util.Optional;

public abstract class Extra {

    //Atributos
    final String CHEESE = "cheese";
    final String SAUCE = "sauce";
    final String SIZE_LARGE = "large";

    Optional<Extra> nextExtra = Optional.empty();

    //Constructor
    public Extra(){}

    //Métodos

    public void setNextExtra(Extra extra){
        this.nextExtra = Optional.of(extra);
    }
    public abstract void sumExtras(Comanda comanda);
}
