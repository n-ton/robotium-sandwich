package com.appthwack.sandwich.views.interfaces;

/**
 * Created by Anton_Ostrenko on 7/24/14.
 */
public interface IAScrollView extends IAViewGroup {

    /**
     * Gets the item at.
     *
     * @param index
     * @return the child at
     */
    public IAView getChildAt(int index);
}
