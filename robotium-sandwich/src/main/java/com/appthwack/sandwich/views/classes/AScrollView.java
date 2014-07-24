package com.appthwack.sandwich.views.classes;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.appthwack.sandwich.identifiers.AClass;
import com.appthwack.sandwich.views.interfaces.IAScrollView;
import com.appthwack.sandwich.views.interfaces.IAView;

import java.text.MessageFormat;

/**
 * The class AScrollView.
 * <p/>
 * Created by Anton_Ostrenko on 7/21/2014.
 */
@AClass(ScrollView.class)
public class AScrollView extends AViewGroup implements IAScrollView {
    @Override
    public IAView getChildAt(int index) {
        View view = getAndWaitForView();
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() > index) {
            View child = viewGroup.getChildAt(index);
            AView childAView = new AView();
            childAView.initialize(child, mScreen, MessageFormat.format("{0}.{1}{2}", mName, "Item", index));
            return childAView;
        }
        return null;
    }
}
