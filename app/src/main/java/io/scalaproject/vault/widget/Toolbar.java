/*
 * Copyright (c) 2017 m2049r
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// based on https://code.tutsplus.com/tutorials/creating-compound-views-on-android--cms-22889

package io.scalaproject.vault.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import io.scalaproject.vault.R;
import timber.log.Timber;

public class Toolbar extends androidx.appcompat.widget.Toolbar {
    public interface OnButtonListener {
        void onButton(int type);
    }

    OnButtonListener onButtonListener;

    public void setOnButtonListener(OnButtonListener listener) {
        onButtonListener = listener;
    }

    TextView toolbarTitle;
    TextView toolbarSubtitle;
    ImageButton bMainLogo;

    public Toolbar(Context context) {
        super(context);
        initializeViews(context);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public Toolbar(Context context,
                   AttributeSet attrs,
                   int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    /**
     * Inflates the views in the layout.
     *
     * @param context the current context for the view.
     */
    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_toolbar, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarSubtitle = findViewById(R.id.toolbarSubtitle);

        bMainLogo = findViewById(R.id.bMainLogo);
        bMainLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (onButtonListener != null) {
                    onButtonListener.onButton(buttonType);
                }
            }
        });
    }

    public void setTitle(String title, String subtitle) {
        setTitle(title);
        setSubtitle(subtitle);
    }

    public final static int BUTTON_NONE = 0;
    public final static int BUTTON_BACK = 1;
    public final static int BUTTON_CLOSE = 2;
    public final static int BUTTON_CREDITS = 3;
    public final static int BUTTON_CANCEL = 4;

    int buttonType = BUTTON_CREDITS;

    public void setButton(int type) {
        switch (type) {
            case BUTTON_BACK:
                Timber.d("BUTTON_BACK");
                bMainLogo.setBackground(getResources().getDrawable(R.drawable.ic_arrow_back_white_24dp));
                //bMainLogo.setText(null);
                bMainLogo.setVisibility(View.VISIBLE);
                break;
            case BUTTON_CLOSE:
                Timber.d("BUTTON_CLOSE");
                bMainLogo.setBackground(getResources().getDrawable(R.drawable.ic_close_white_24dp));
                //bCredits.setText(R.string.label_close);
                bMainLogo.setVisibility(View.VISIBLE);
                break;
            case BUTTON_CREDITS:
                Timber.d("BUTTON_CREDITS");
                bMainLogo.setBackground(getResources().getDrawable(R.mipmap.ic_logo_colors));
                //bCredits.setText(R.string.label_credits);
                bMainLogo.setVisibility(View.VISIBLE);
                break;
            case BUTTON_CANCEL:
                Timber.d("BUTTON_CANCEL");
                bMainLogo.setBackground(getResources().getDrawable(R.drawable.ic_close_white_24dp));
                //bCredits.setText(R.string.label_cancel);
                bMainLogo.setVisibility(View.VISIBLE);
                break;
            case BUTTON_NONE:
            default:
                Timber.d("BUTTON_NONE");
                bMainLogo.setBackground(getResources().getDrawable(R.mipmap.ic_logo_colors));
                //bCredits.setText(null);
                bMainLogo.setVisibility(View.VISIBLE);
        }
        buttonType = type;
    }
}