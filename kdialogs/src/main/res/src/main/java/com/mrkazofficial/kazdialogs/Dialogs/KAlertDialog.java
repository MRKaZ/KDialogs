package com.mrkazofficial.kazdialogs.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.mrkazofficial.kazdialogs.R;
import com.mrkazofficial.kdialogs.KAnimation;


/**
 * @author MRKaZ
 * @since 6:37 PM, 1/27/2021, 2021
 */

public class KAlertDialog {

    public static final int TOP = 48;
    public static final int CENTER = 17;
    public static final int BOTTOM = 80;


    public KAlertDialog(final Builder builder) {

        final Dialog dialog = new Dialog(builder.mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.alert_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        Window window = dialog.getWindow();
        // Getting Attributes for Set Gravity > Default GRAVITY.BOTTOM
        WindowManager.LayoutParams setGravity = window.getAttributes();
        // Set Gravity Bottom
        setGravity.gravity = Gravity.CENTER;
        // Set Gravity Bottom
        setGravity.gravity = builder.setGravity;

        // animation
        if (builder.animType == KAnimation.Animation_DOWN) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.AnimDown;

        } else if (builder.animType == KAnimation.Animation_FADE_IN_OUT) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.AnimFadeInOut;

        } else if (builder.animType == KAnimation.Animation_ZOOM_IN_OUT) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.AnimZoomInOut;
        }

        TextView setTitle = dialog.findViewById(R.id.textTitleAlert);
        TextView setMessage = dialog.findViewById(R.id.textMessageAlert);

        TextView setNegativeBtnText = dialog.findViewById(R.id.btnTextNegativeAlert);
        TextView setPositiveBtnText = dialog.findViewById(R.id.btnTextPositiveAlert);

        LinearLayout btnPositive = (LinearLayout) dialog.findViewById(R.id.btnAlertDelete);
        LinearLayout btnNegative = (LinearLayout) dialog.findViewById(R.id.btnAlertCancel);

        /* Negative == Cancel > Dismiss / Positive == Delete > Action*/
        // Negative == Cancel Button Image
        ImageView imageNegative = dialog.findViewById(R.id.imageNegative);
        // Positive == Delete Button Image
        ImageView imagePositive = dialog.findViewById(R.id.imagePositive);

        if (builder.negativeIcon <= 0){
            imageNegative.setVisibility(View.GONE);
        } else {
            imageNegative.setVisibility(View.GONE);
            imageNegative.setVisibility(View.VISIBLE);
            imageNegative.setBackgroundResource(builder.negativeIcon);
        }

        if (builder.positiveIcon <= 0){
            imagePositive.setVisibility(View.GONE);
        } else {
            imagePositive.setVisibility(View.VISIBLE);
            imagePositive.setBackgroundResource(builder.positiveIcon);
        }

        if (builder.txtTitle == null || builder.txtTitle.trim().equals("null") || builder.txtTitle.trim().length() <= 0){
            setTitle.setText("Your Title Here!");
            setTitle.setVisibility(View.GONE);
            if (builder.intTxtTitle <= 0){
                setTitle.setText("Your Title Here!");
                setTitle.setVisibility(View.GONE);
            } else {
                setTitle.setText(builder.intTxtTitle);
                setTitle.setVisibility(View.VISIBLE);
            }
        } else {
            setTitle.setText(builder.txtTitle);
            setTitle.setVisibility(View.VISIBLE);
        }

        if (builder.textMessage == null || builder.textMessage.trim().equals("null") || builder.textMessage.trim().length() <= 0){
            setMessage.setText("Your Message Here!");
            setMessage.setVisibility(View.GONE);
            if (builder.intTxtMessage <= 0){
                setMessage.setText("Your Message Here!");
                setMessage.setVisibility(View.GONE);
            } else {
                setMessage.setText(builder.intTxtMessage);
                setMessage.setVisibility(View.VISIBLE);
            }
        } else {
            setMessage.setText(builder.textMessage);
            setMessage.setVisibility(View.VISIBLE);
        }

        if (builder.txtNegativeButton == null || builder.txtNegativeButton.trim().equals("null")
                || builder.txtNegativeButton.trim().length() <= 0){
            btnNegative.setVisibility(View.GONE);
        } else {
            if (builder.intNegativeButtonTitle <= 0){
                btnNegative.setVisibility(View.GONE);
            } else {
                btnNegative.setVisibility(View.VISIBLE);
                // Set Negative Button Text
                setNegativeBtnText.setText(builder.intPositiveButtonTitle);
            }
            btnNegative.setVisibility(View.VISIBLE);
            setNegativeBtnText.setText(builder.txtNegativeButton);
        }

        if (builder.txtPositiveButton == null || builder.txtPositiveButton.trim().equals("null")
                || builder.txtPositiveButton.trim().length() <= 0){
            btnPositive.setVisibility(View.GONE);
        } else {
            if (builder.intPositiveButtonTitle <= 0){
                btnPositive.setVisibility(View.GONE);
            } else {
                btnPositive.setVisibility(View.VISIBLE);
                // Set Negative Button Text
                setPositiveBtnText.setText(builder.intPositiveButtonTitle);
            }
            btnPositive.setVisibility(View.VISIBLE);
            setPositiveBtnText.setText(builder.txtPositiveButton);
        }

        btnPositive.setClickable(true);
        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.onPositiveListener.OnPositiveButtonClick(dialog);
            }
        });

        btnNegative.setClickable(true);
        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.onNegativeListener.OnNegativeButtonClick(dialog);
            }
        });

        // Set Cancelable
        dialog.setCancelable(builder.isCancelable);
        // Show Dialog
        dialog.show();

        //Set Negative Button Background
        if (builder.setNegativeBackground){
            // If VERSION.SDK_INT >= LOLLIPOP == 21
            if(android.os.Build.VERSION.SDK_INT >= 21) {
                // Set Drawable Background
                btnNegative.setBackgroundDrawable(ContextCompat.getDrawable(builder.mContext, builder.negativeBackground) );
            } else {
                // Set Drawable Background
                btnNegative.setBackground(ContextCompat.getDrawable(builder.mContext, builder.negativeBackground));
            }
        } else{
            Drawable defaultBackground = btnNegative.getBackground();
            btnNegative.setBackgroundDrawable(defaultBackground);
        }
        // Set Positive Button background
        if (builder.setPositiveBackground){
            // If VERSION.SDK_INT >= LOLLIPOP == 21
            if(android.os.Build.VERSION.SDK_INT >= 21) {
                // Set Drawable Background
                btnPositive.setBackgroundDrawable(ContextCompat.getDrawable(builder.mContext, builder.positiveBackground) );
            } else {
                // Set Drawable Background
                btnPositive.setBackground(ContextCompat.getDrawable(builder.mContext, builder.positiveBackground));
            }
        } else {
            Drawable defaultBackground = btnNegative.getBackground();
            btnNegative.setBackgroundDrawable(defaultBackground);
        }
        // Set Negative Button Icon
        if (builder.setNegativeIcon){
            if(android.os.Build.VERSION.SDK_INT >= 21) {
                // Set Drawable Background
                imageNegative.setBackgroundTintList(
                        builder.mContext.getResources().getColorStateList(builder.negativeBackgroundTint));
            }
        } else {
            Drawable getDefaultIcon = imageNegative.getDrawable();
            imageNegative.setImageDrawable(getDefaultIcon);
        }
        // Set Positive Button Icon
        if (builder.setPositiveIcon){
            if(android.os.Build.VERSION.SDK_INT >= 21) {
                // Set Drawable Background
                imagePositive.setBackgroundTintList(
                        builder.mContext.getResources().getColorStateList(builder.positiveBackgroundTint));
            }
        } else {
            Drawable getDefaultIcon = imagePositive.getDrawable();
            imageNegative.setImageDrawable(getDefaultIcon);
        }
        // Set Custom Font
        if (builder.setFont){
            Typeface typeface = ResourcesCompat.getFont(builder.mContext, builder.fontInit);
            setTitle.setTypeface(typeface);
            setMessage.setTypeface(typeface);
            setNegativeBtnText.setTypeface(typeface);
            setPositiveBtnText.setTypeface(typeface);
        } else {
            setTitle.getTypeface();
            setMessage.getTypeface();
            setNegativeBtnText.getTypeface();
            setPositiveBtnText.getTypeface();
        }
        // Set Negative Button Text Color
        if (builder.negativeTextColor <= 0){
            setNegativeBtnText.getTextColors();
        } else {
            // If VERSION.SDK_INT >= LOLLIPOP == 21
            if(android.os.Build.VERSION.SDK_INT >= 21) {
                // Set Text Color
                setNegativeBtnText.setTextColor(ContextCompat.getColor(builder.mContext, builder.negativeTextColor) );
            } else {
                // Set Text Color
                setNegativeBtnText.setBackground(ContextCompat.getDrawable(builder.mContext, builder.negativeTextColor));
            }
        }
        // Set Positive Button Text Color
        if (builder.positiveTextColor <= 0){
            setPositiveBtnText.getTextColors();
        } else {
            // If VERSION.SDK_INT >= LOLLIPOP == 21
            if(android.os.Build.VERSION.SDK_INT >= 21) {
                // Set Text Color
                setPositiveBtnText.setTextColor(ContextCompat.getColor(builder.mContext, builder.positiveTextColor) );
            } else {
                // Set Text Color
                setPositiveBtnText.setBackground(ContextCompat.getDrawable(builder.mContext, builder.positiveTextColor));
            }
        }


    }


    public static class Builder {

        // Default Values
        private final Context mContext;
        private String txtTitle = null;
        private String textMessage = null;
        private int intTxtTitle, intTxtMessage;
        private int intNegativeButtonTitle, intPositiveButtonTitle;
        private boolean isCancelable, isAnimation = true;
        private int fontInit;
        private @DrawableRes int negativeBackground, positiveBackground;
        private boolean setNegativeBackground, setPositiveBackground = false;
        private boolean setFont = false;
        private @ColorRes int negativeBackgroundTint, positiveBackgroundTint;
        private @ColorRes int negativeTextColor, positiveTextColor;
        private @DrawableRes int negativeIcon, positiveIcon;
        private boolean setNegativeIcon, setPositiveIcon = false;
        private int setGravity;

        private String txtPositiveButton, txtNegativeButton = null;

        private OnPositiveButtonListener onPositiveListener = new OnPositiveButtonListener() {
            @Override
            public void OnPositiveButtonClick(Dialog dialog) {

            }
        };
        private OnNegativeButtonListener onNegativeListener = new OnNegativeButtonListener() {
            @Override
            public void OnNegativeButtonClick(Dialog dialog) {

            }
        };

        private int animType = 0;

        public Builder(@NonNull Context context) {
            this.mContext = context;
        }

        public KAlertDialog show() {
            return new KAlertDialog(this);
        }

        /*
        dialog title
        */
        public Builder setTitle(String title) {
            this.txtTitle = title;
            return this;
        }

        /*
        dialog content message
        */
        public Builder setMessage(String Message) {
            this.textMessage = Message;
            return this;
        }

        /*
        dialog title
        */
        public Builder setTitle(int Title) {
            this.intTxtTitle = Title;
            return this;
        }

        /*
        dialog content message
        */
        public Builder setMessage(int Message) {
            this.intTxtMessage = Message;
            return this;
        }

        /*
        dialog cancelable flag
        */
        public Builder setCancelable(boolean isCancelable) {
            this.isCancelable = isCancelable;
            return this;
        }

        /*
        dialog positive button and click event handler
        */
        public Builder setPositiveButton(String positiveText, OnPositiveButtonListener onPositiveListener) {
            this.txtPositiveButton = positiveText;
            this.onPositiveListener = onPositiveListener;
            return this;
        }

        /*
        dialog negative button and click event handler
        */
        public Builder setNegativeButton(String negativeText, OnNegativeButtonListener onNegativeListener) {
            this.txtNegativeButton = negativeText;
            this.onNegativeListener = onNegativeListener;
            return this;
        }

        /*
       dialog positive button and click event handler
       */
        public Builder setPositiveButton(int positiveText, OnPositiveButtonListener onPositiveListener) {
            this.intPositiveButtonTitle = positiveText;
            this.onPositiveListener = onPositiveListener;
            return this;
        }

        /*
        dialog negative button and click event handler
        */
        public Builder setNegativeButton(int negativeText, OnNegativeButtonListener onNegativeListener) {
            this.intNegativeButtonTitle = negativeText;
            this.onNegativeListener = onNegativeListener;
            return this;
        }

        /** It sets the json file to the {@link Dialog} from raw folder.
         * @param setIconTint boolean to show Dialog Background == true / false {@link Dialog}.
         * @param Tint set Tint from the resource folder {@link Dialog}.
         * @return this, for chaining.
         */
        public Builder setNegativeIconTint(boolean setIconTint, int Tint){
            this.negativeBackgroundTint = Tint;
            this.setNegativeIcon = setIconTint;
            return this;
        }

        /** It sets the json file to the {@link Dialog} from raw folder.
         * @param setIconTint boolean to show Dialog Background == true / false {@link Dialog}.
         * @param Tint set Tint from the resource folder {@link Dialog}.
         * @return this, for chaining.
         */
        public Builder setPositiveIconTint(boolean setIconTint, int Tint){
            this.positiveBackgroundTint = Tint;
            this.setPositiveIcon = setIconTint;
            return this;
        }

        /** It sets the json file to the {@link Dialog} from raw folder.
         * @param setBackground boolean to show Dialog Background == true / false {@link Dialog}.
         * @param Background set Background from the resource folder {@link Dialog}.
         * @return this, for chaining.
         */
        public Builder setNegativeButtonBackground(boolean setBackground, int Background) {
            this.negativeBackground = Background;
            this.setNegativeBackground = setBackground;
            return this;
        }

        /** It sets the json file to the {@link Dialog} from raw folder.
         * @param setBackground boolean to show Dialog Background == true / false {@link Dialog}.
         * @param Background set Background from the resource folder {@link Dialog}.
         * @return this, for chaining.
         */
        public Builder setPositiveButtonBackground(boolean setBackground, int Background) {
            this.positiveBackground = Background;
            this.setPositiveBackground = setBackground;
            return this;
        }

        /** It sets the json file to the {@link Dialog} from raw folder.
         * @param animType set Animation to Dialog {@link Dialog}.
         * @return this, for chaining.
         */
        public Builder setEffect(int animType) {
            this.animType = animType;
            return this;
        }

        /** It sets the json file to the {@link ImageView} from raw folder.
         * @param Icon set Icon to Negative Button from the resource {@link ImageView}.
         * @return this, for chaining.
         */
        public Builder setNegativeButtonIcon(int Icon){
            this.negativeIcon = Icon;
            return this;
        }

        /** It sets the json file to the {@link ImageView} from raw folder.
         * @param Icon set Icon to Positive Button from the resource {@link ImageView}.
         * @return this, for chaining.
         */
        public Builder setPositiveButtonIcon(int Icon){
            this.positiveIcon = Icon;
            return this;
        }


        /** It sets the .otf / .ttf file to the {@link Typeface} from font / assets folders.
         * @param setFont Boolean == true / false
         * @param Font set font from / assets
         * @return this, for chaining.
         */
        public Builder setFont(boolean setFont, int Font) {
            this.setFont = setFont;
            this.fontInit = Font;
            return this;
        }

        public Builder setNegativeTextColor(@ColorRes int Color){
            this.negativeTextColor = Color;
            return this;
        }

        public Builder setPositiveTextColor(@ColorRes int Color){
            this.positiveTextColor = Color;
            return this;
        }

        public Builder setGravity(int Gravity){
            this.setGravity = Gravity;
            return this;
        }
    }

    public interface OnPositiveButtonListener {
        void OnPositiveButtonClick(Dialog dialog);
    }

    public interface OnNegativeButtonListener {
        void OnNegativeButtonClick(Dialog dialog);
    }
}
