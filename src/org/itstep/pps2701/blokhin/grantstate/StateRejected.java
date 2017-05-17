package org.itstep.pps2701.blokhin.grantstate;

/**
 * Created by Vit on 17.05.2017.
 */
public class StateRejected extends GrantState {

    public StateRejected() {
        super();
    }

    @Override
    public String getState() {
        return "Отклонён";
    }
} // class StateRejected
