package org.itstep.pps2701.blokhin.grantstate;

/**
 * Created by Vit on 17.05.2017.
 */
public class StateWithdrawn extends GrantState {

    public StateWithdrawn() {
        super();
    }

    @Override
    public String getState() {
        return "Отозван";
    }
} // class StateWithdrawn
