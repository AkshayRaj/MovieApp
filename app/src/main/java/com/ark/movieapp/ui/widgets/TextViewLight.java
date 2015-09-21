package com.ark.movieapp.ui.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewLight extends TextView {

    public TextViewLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public TextViewLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public TextViewLight(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "Roboto-Light.ttf");
        setTypeface(myTypeface);
    }

}
