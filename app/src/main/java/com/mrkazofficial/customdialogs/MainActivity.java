package com.mrkazofficial.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.mrkazofficial.kdialogs.KAlertDialog;
import com.mrkazofficial.kdialogs.KAnimation;
import com.mrkazofficial.kdialogs.KBottomSheetDialog;
import com.mrkazofficial.kdialogs.KSimpleDialog;

public class MainActivity extends AppCompatActivity {

    /*
     *
     * When You Set Lottie Animation, If You Are Using Lottie Animation File Name?,
     * You Need To Placed Your Animation File Into Your assets Folder
     * When You Set Lottie Animation, If You Are Using Lottie Animation @IntegerRes
     * You Can Placed It Into Your raw Folder
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        this.findViewById(R.id.btnBottomDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initiate KazDialog
                new KBottomSheetDialog.Builder(MainActivity.this)
                        //.setTitle(R.string.delete_title) // Set Title Use @StringRes Or @IntegerRes
                        .setMessage(R.string.delete_message) // Set Message Use @StringRes Or @IntegerRes
                        //.setTitle("Delete?") // Set Title Use @StringRes Or @IntegerRes
                        //.setMessage("Are you sure want to delete this files!?") // Set Message Use @StringRes Or @IntegerRes
                        .setCancelable(false) // Set Dialog Cancelable
                        /*Set Buttons Icons*/
                        //.setNegativeButtonIcon(R.drawable.ic_dialog) // Negative Button Icon
                        //.setPositiveButtonIcon(R.drawable.ic_dialog) // Positive Button Icon
                        /*Set Buttons Backgrounds*/
                        .setNegativeButtonBackground(false, R.drawable.red_shape_for_dialog_button)
                        .setPositiveButtonBackground(false, R.drawable.red_shape_for_dialog_button)
                        /*Set Buttons Icons Tint*/
                        .setNegativeIconTint(true, R.color.mrkazRed)
                        .setPositiveIconTint(true, R.color.white)
                        /*Set Font To Dialog*/
                        //.setFont(true, R.font.popin) // Set Custom Font
                        /*Set Animation & Dialog Effects*/
                        .setAnimation(true) // Show Animation To Dialog > Boolean == true / false
                        .setAnimationFile("delete_bubble.json") // Set Custom Lottie Animation File Use @StringRes Or @IntegerRes
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Setting Dialog Opening Effects
                        /* Setting Click Listener Buttons*/
                        .setPositiveButton("Delete", new KBottomSheetDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Cancel", new KBottomSheetDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.cancel();
                            }
                        })
                       /*.setPositiveButton(R.string.button_positive, new KBottomSheetDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton(R.string.button_negative, new KBottomSheetDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })*/
                        .show(); // Show Dialog

            }
        });

        this.findViewById(R.id.btnSimpleDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initiate KazDialog
                new KSimpleDialog.Builder(MainActivity.this)
                        //.setTitle(R.string.delete_title) // Set Title Use @StringRes Or @IntegerRes
                        .setMessage(R.string.delete_message) // Set Message Use @StringRes Or @IntegerRes
                        .setCancelable(false) // Set Dialog Cancelable
                        .setNegativeButtonIcon(R.drawable.ic_dialog) // Negative Button Icon
                        .setPositiveButtonIcon(R.drawable.ic_dialog) // Positive Button Icon
                        .setAnimation(true) // Show Animation To Dialog > Boolean == true / false
                        .setAnimationFile("delete_bubble.json") // Set Custom Lottie Animation File Use @StringRes Or @IntegerRes
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Setting Dialog Opening Effects
                        .setFont(true, R.font.popin) // Set Custom Font
                        .setGravity(KSimpleDialog.CENTER) // Set Gravity Use KSimpleDialog.{YOUR_GRAVITY} Or Use Gravity.{YOUR_GRAVITY}
                        .setPositiveButton("Delete", new KSimpleDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Cancel", new KSimpleDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });

        this.findViewById(R.id.btnAlertDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initiate KazDialog
                new KAlertDialog.Builder(MainActivity.this)
                         .setTitle(R.string.alert_title) // Set Title Use @StringRes Or @IntegerRes
                        .setMessage(R.string.alert_message) // Set Message Use @StringRes Or @IntegerRes
                        .setCancelable(false) // Set Dialog Cancelable
                        .setNegativeButtonIcon(R.drawable.ic_dialog) // Negative Button Icon
                        .setPositiveButtonIcon(R.drawable.ic_dialog) // Positive Button Icon
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Setting Dialog Opening Effects
                        .setFont(true, R.font.popin) // Set Custom Font
                        .setPositiveButton("OK", new KAlertDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Cancel", new KAlertDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }
        });

        this.findViewById(R.id.btnSuccessDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new KSimpleDialog.Builder(MainActivity.this)
                        .setTitle(R.string.success_title) // Set Title Use @StringRes Or @IntegerRes
                        .setMessage(R.string.success_message) // Set Message Use @StringRes Or @IntegerRes
                        .setAnimation(true) // Set Animation > Boolean == true / false
                        /*If You Are Using Animation File Name You Need To Placed Your Animation File into assets Folder*/
                        .setAnimationFile(R.raw.success) // Set Lottie Animation File > From raw Resource
                        .setCancelable(false) // Set Cancelable
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Set Dialog Effect
                        /*Setting Button Backgrounds*/
                        .setNegativeButtonBackground(true, R.drawable.white_shape_for_button)
                        .setPositiveButtonBackground(true, R.drawable.success_shape_for_dialog_button)
                        /*Setting Button Icons*/
                        //.setNegativeButtonIcon(R.drawable.ic_ok)
                        .setPositiveButtonIcon(R.drawable.ic_ok)
                        /*Setting Button Colors*/
                        .setNegativeTextColor(R.color.mrkazGreen)
                        /*Setting Buttons*/
                        .setPositiveButton("Exit", new KSimpleDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        /*.setNegativeButton("OK", new KSimpleDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })*/
                        .show(); // Show Dialog
            }
        });

        this.findViewById(R.id.btnWarningDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new KSimpleDialog.Builder(MainActivity.this)
                        .setTitle(R.string.warning_title) // Set Title Use @StringRes Or @IntegerRes
                        .setMessage(R.string.warning_message) // Set Message Use @StringRes Or @IntegerRes
                        .setAnimation(true) // Set Animation > Boolean == true / false
                        /*If You Are Using Animation File Name You Need To Placed Your Animation File into assets Folder*/
                        .setAnimationFile(R.raw.warning)  // Set Lottie Animation File > From raw Resource
                        .setCancelable(false) // Set Cancelable
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Set Dialog Effect
                        /*Setting Button Backgrounds*/
                        .setNegativeButtonBackground(true, R.drawable.white_shape_for_button)
                        .setPositiveButtonBackground(true, R.drawable.warning_shape_for_dialog_button)
                        /*Setting Button Icons*/
                        //.setNegativeButtonIcon(R.drawable.ic_dialog)
                        //.setPositiveButtonIcon(R.drawable.ic_dialog)
                        .setNegativeTextColor(R.color.orange)
                        //.setPositiveTextColor(R.color.orange)
                        .setPositiveButton("Exit", new KSimpleDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        /*.setNegativeButton("OK", new KSimpleDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })*/
                        .show();
            }
        });

        this.findViewById(R.id.btnErrorDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new KSimpleDialog.Builder(MainActivity.this)
                        //.setTitle("Error Dialog!")
                        //.setMessage("Error Dialog Message")
                        .setTitle(R.string.error_title)
                        .setMessage(R.string.error_message)
                        .setAnimation(true)
                        .setAnimationFile(R.raw.error)
                        .setCancelable(false)
                        .setEffect(KAnimation.Animation_FADE_IN_OUT)
                        .setNegativeButtonBackground(true, R.drawable.white_shape_for_button)
                        .setPositiveButtonBackground(true, R.drawable.red_shape_for_dialog_button)
                        //.setNegativeButtonIcon(R.drawable.ic_dialog)
                        //.setPositiveButtonIcon(R.drawable.ic_dialog)
                        .setNegativeTextColor(R.color.mrkazRed)
                        /*.setNegativeButton("OK", new KSimpleDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })*/
                        .setPositiveButton("Exit", new KSimpleDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

    }
}