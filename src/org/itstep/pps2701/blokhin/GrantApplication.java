package org.itstep.pps2701.blokhin;

import org.itstep.pps2701.blokhin.grantstate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vit on 17.05.2017.
 */
public class GrantApplication {
    private StateNew stateNew;
    private StateConsider stateConsider;
    private StateHold stateHold;
    private StateAccepted stateAccepted;
    private StateRejected stateRejected;
    private StateWithdrawn stateWithdrawn;

    private List<Grant> grantList;

    public GrantApplication() {
        grantList = new ArrayList<>();
        initStates();
    } // GrantApplication

    private void initStates(){
        stateNew = new StateNew();
        stateConsider = new StateConsider();
        stateHold = new StateHold();
        stateAccepted = new StateAccepted();
        stateRejected = new StateRejected();
        stateWithdrawn = new StateWithdrawn();

        // добавляем для каждого статуса возможные переходы
        stateNew.addAvailableState(stateConsider);
        stateNew.addAvailableState(stateHold);
        stateNew.addAvailableState(stateAccepted);
        stateNew.addAvailableState(stateWithdrawn);

        stateConsider.addAvailableState(stateHold);
        stateConsider.addAvailableState(stateAccepted);
        stateConsider.addAvailableState(stateRejected);
        stateConsider.addAvailableState(stateWithdrawn);

        stateHold.addAvailableState(stateConsider);
        stateHold.addAvailableState(stateAccepted);
        stateHold.addAvailableState(stateRejected);
        stateHold.addAvailableState(stateWithdrawn);
    } // initStates


    public List<Grant> getGrantList() {
        return grantList;
    } // getGrantList

    public void addGrant(String name){
        grantList.add(new Grant(name, stateNew));
    }

} // class GrantApplication
