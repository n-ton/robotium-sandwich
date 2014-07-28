package com.appthwack.sandwich.views.classes;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAScrollView;

/**
 * The class AScrollView.
 * <p/>
 * Created by Anton_Ostrenko on 7/21/2014.
 */
@AClass(ScrollView.class)
public class AScrollView extends AViewGroup implements IAScrollView {

    public ViewGroup getChildAt(int index) {
        View view = getAndWaitForView();
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() > index) {
            return (ViewGroup) viewGroup.getChildAt(index);
        }
        return null;
    }
}
