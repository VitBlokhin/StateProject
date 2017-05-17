package org.itstep.pps2701.blokhin;

import org.itstep.pps2701.blokhin.grantstate.GrantState;

/**
 * Created by Vit on 17.05.2017.
 */
public class Grant {
    private String grantName;
    private GrantState currentGrantState;

    public String getGrantName() {
        return grantName;
    }

    public Grant(String grantName, GrantState grantState) {
        this.grantName = grantName;
        currentGrantState = grantState;
    }

    public GrantState getCurrentGrantState() {
        return currentGrantState;
    }

    public void setCurrentGrantState(GrantState newGrantState) {
        if(currentGrantState.getAvailableStates().contains(newGrantState))
            this.currentGrantState = newGrantState;
        else throw new IllegalArgumentException("Данное состояние недоступно для смены");
    } // setCurrentGrantState

    public String getState(){
        return currentGrantState.getState();
    } // getState


    @Override
    public String toString() {
        return "Заказ на имя " + grantName + ", " + currentGrantState.getState();
    } // toString


} // class Grant
