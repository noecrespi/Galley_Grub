package edu.poniperro.receipt;

import edu.poniperro.order.Comanda;
import edu.poniperro.extras.Extra;
public class Receipt implements Ticket{

    //Atributos
    private Double total = 0d;
    private Comanda comanda;
    private Extra chain;

    //Constructor
    public Receipt(Comanda comanda){
        this.comanda = comanda;
    };

    //Métodos
    public Comanda getOrder(){
        return this.comanda;
    }
    @Override
    public Extra getChain(){
        return this.chain;
    }

    public void setChain(Extra extra){
        this.chain = extra;
    }

    @Override
    public Double total() {
        if(this.chain != null){
            sumExtrasCharge();
        }
        return this.total;
    }

    @Override
    public void sumExtrasCharge() {
        chain.sumExtras(comanda);
        this.total = comanda.getTotal();
    }

    @Override
    public void print() {
        this.comanda.display();
        System.out.println("TOTAL --------> " + this.total.toString());
    }

}