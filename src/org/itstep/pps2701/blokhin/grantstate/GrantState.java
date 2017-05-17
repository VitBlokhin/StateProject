package org.itstep.pps2701.blokhin.grantstate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vit on 17.05.2017.
 */
abstract public class GrantState {
    protected List<GrantState> availableStates; // список возможных состояний для перехода

    public GrantState() {
        availableStates = new ArrayList<>();
        availableStates.add(this);
    } // GrantState

    public void addAvailableState(GrantState state){
        availableStates.add(state);
    } // addAvailableState

    public List<GrantState> getAvailableStates() {
        return availableStates;
    } // getAvailableStates

    @Override
    public String toString() {
        return getState();
    }

    // метод, который выводит разные значения, в зависимости от состояния ¯\_(ツ)_/¯
    abstract public String getState();

} // class GrantState
