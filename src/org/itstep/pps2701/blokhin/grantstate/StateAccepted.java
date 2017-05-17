package org.itstep.pps2701.blokhin.grantstate;

/**
 * Created by Vit on 17.05.2017.
 */
public class StateAccepted extends GrantState {

    public StateAccepted() {
        super();
    }

    @Override
    public String getState() {
        return "Подтверждён";
    }
} // class StateAccepted
