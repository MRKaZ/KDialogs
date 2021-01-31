# KDialogs, Custom Material UI Dialogs for Android Developers
![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg)

<div align="center">
	<img src="app/src/main/ic_launcher-playstore.png" width="128">
</div>

Custom Material UI Dialogs For Develeopers! 😇

## Prerequisites

Add this in your root `build.gradle` file (**not** in your `build.gradle.app` add it into your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
	...
	 // Lottie Animation > For Animations
    implementation 'com.airbnb.android:lottie:3.3.0'
    // KDialogs
    implementation 'com.github.MRKaZ:KDialogs:1.0'
}
```

## Usage

KDialog Library uses Builder to Initiate Dialogs. `KDialogs` always returns to a `Builder`, After building add show() 
method to Show KDialogs. You can display 3 types of Dialogs

- **Alert Dialog**
- **Simple Dialog**
- **Bottom Sheet Dialog**

 **DON'T FORGET THE `.show()` METHOD!**

```java
.show() // Required KDialogs
```


Display a **Alert KDialog** :

``` java
// Initiate KazDialog
                new KAlertDialog.Builder(MainActivity.this)
                        /*
                         * @Set Title & Message
                         * Use @StringRes Or @IntegerRes To Set Title & Message
                         * Example @StringRes;
                         *.setTitle("YOUR_TITLE") // Set Title Use @StringRes
                         *.setMessage("YOUR_MESSAGE") // Set Message Use @StringRes
                         *
                         * Example @IntegerRes;
                         *.setTitle(R.string.YOUR_TITLE) // Set Title Use @IntegerRes
                         *.setMessage(R.string.YOUR_MESSAGE) // Set Message Use @IntegerRes
                         */
                        .setTitle(R.string.YOUR_TITLE)
                        .setMessage(R.string.YOUR_MESSAGE)
                        .setCancelable(false) // Set Dialog Cancelable
                        /*
                         * @Set Buttons Icons
                         * Use @IntegerRes To Set Icon Tint (Color)
                         * Example;
                         *.setNegativeButtonIcon(R.drawable.YOUR_ICON)
                         *.setPositiveButtonIcon(R.drawable.YOUR_ICON)
                         *
                         * @Set Buttons Backgrounds
                         * Use @IntegerRes To Set Backgrounds
                         * Example;
                         *.setNegativeButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                         *.setPositiveButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                         *
                         * @Set Buttons Icons Tint
                         * Use @IntegerRes To Set Icon Tint (Color)
                         * Example;
                         *.setNegativeIconTint(true, R.color.YOUR_COLOR)
                         *.setPositiveIconTint(true, R.color.YOUR_COLOR)
                         */          
                        .setNegativeButtonIcon(R.drawable.YOUR_ICON)
                        .setPositiveButtonIcon(R.drawable.YOUR_ICON)
                         /*
                         * @Set Custom Font
                         * Use @IntegerRes To Set Custom Font Whole Dialog
                         * Example;
                         *.setFont(true, R.font.YOUR_FONT)
                         *
                         * @Set Dialog Effects
                         * Use KAnimation To Set Dialog Opening Effects
                         * KAnimations = Animation_FADE_IN_OUT, Animation_DOWN, Animation_ZOOM_IN_OUT, Animation_SHAKE
                         * .setEffect(KAnimation.Animation_FADE_IN_OUT)
                         */
                        .setFont(true, R.font.popin) // Set Custom Font
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Setting Dialog Opening Effects
                        /*
                         * @Set Gravity
                         * Use KSimpleDialog.{YOUR_GRAVITY} Or Use Gravity.{YOUR_GRAVITY}
                         * Example KSimpleDialog.{YOUR_GRAVITY};
                         *.setGravity(KSimpleDialog.CENTER)
                         *
                         * Example Gravity.{YOUR_GRAVITY};
                         *.setGravity(Gravity.CENTER)
                         */
                        .setGravity(Gravity.CENTER)
                        /*
                         * @Setting Buttons
                         * Use @IntegerRes Or @StringRes To Set Button Title
                         * Example;
                         * @StringRes
                         *.setPositiveButton("ACTION", new KBottomSheetDialog.OnPositiveButtonListener()
                         *.setNegativeButton("ACTION", new KBottomSheetDialog.OnNegativeButtonListener()
                         *
                         * @IntegerRes
                         *.setPositiveButton(R.string.YOUR_DIALOG_TITLE, new KBottomSheetDialog.OnPositiveButtonListener()
                         *.setNegativeButton(R.string.YOUR_DIALOG_TITLE, new KBottomSheetDialog.OnNegativeButtonListener()
                         */
                        .setPositiveButton("ACTION", new KBottomSheetDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.cancel(); // Or dialog.dismiss();
                            }
                        })
                        .setNegativeButton("ACTION", new KBottomSheetDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.cancel(); // Or dialog.dismiss();
                            }
                        })
                        .show(); // Show Dialog
```

To Display a **Simple KDialog** :

``` java
// Initiate KazDialog
                new KSimpleDialog.Builder(MainActivity.this)
                        /*
                         * @Set Title & Message
                         * Use @StringRes Or @IntegerRes To Set Title & Message
                         * Example @StringRes;
                         *.setTitle("YOUR_TITLE") // Set Title Use @StringRes
                         *.setMessage("YOUR_MESSAGE") // Set Message Use @StringRes
                         *
                         * Example @IntegerRes;
                         *.setTitle(R.string.YOUR_TITLE) // Set Title Use @IntegerRes
                         *.setMessage(R.string.YOUR_MESSAGE) // Set Message Use @IntegerRes
                         */
                        .setTitle(R.string.YOUR_TITLE)
                        .setMessage(R.string.YOUR_MESSAGE)
                        .setCancelable(false) // Set Dialog Cancelable
                        /*
                         * @Set Buttons Icons
                         * Use @IntegerRes To Set Icons
                         * Example;
                         *.setNegativeButtonIcon(R.drawable.YOUR_ICON) // Negative Button Icon
                         *.setPositiveButtonIcon(R.drawable.YOUR_ICON) // Positive Button Icon
                         *
                         * @Set Buttons Backgrounds
                         * Use @IntegerRes To Set Backgrounds
                         * Example;
                         *.setNegativeButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                         *.setPositiveButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                         */
                        .setNegativeButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                        .setPositiveButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                        /*
                         * @Set Buttons Icons
                         * Use @IntegerRes To Set Icon Tint (Color)
                         * Example;
                         *.setNegativeButtonIcon(R.drawable.YOUR_ICON)
                         *.setPositiveButtonIcon(R.drawable.YOUR_ICON)
                         *
                         * @Set Buttons Icons Tint
                         * Use @IntegerRes To Set Icon Tint (Color)
                         * Example;
                         *.setNegativeIconTint(true, R.color.YOUR_COLOR)
                         *.setPositiveIconTint(true, R.color.YOUR_COLOR)
                         */          
                        .setNegativeButtonIcon(R.drawable.YOUR_ICON)
                        .setPositiveButtonIcon(R.drawable.YOUR_ICON)
                        /*
                         * @Set Custom Font
                         * Use @IntegerRes To Set Custom Font Whole Dialog
                         * Example;
                         *.setFont(true, R.font.YOUR_FONT)
                         *
                         * @Show Animations
                         * Use Boolean true / false
                         * Example;
                         *.setAnimation(true) // Set Animation To Dialog > Boolean == true / false
                         */
                        .setFont(true, R.font.YOUR_FONT)
                        .setAnimation(true)
                        /*
                         * @Lottie Animation Use Note;
                         * When You Set Your Lottie Animation, If You Are Using Lottie Animation File Name? 
                         * eg: .setAnimationFile("delete_bubble.json") Use .json Extension,
                         * You Need To Placed Your Aimation File Into Your assets Folder
                         * When You Set Your Lottie Animation, If You Are Using Lottie Animation @IntegerRes
                         * eg : .setAnimationFile(R.raw.delete_bubble)
                         * You Can Placed It Into Your raw Folder
                         *
                         * Examples;
                         * .setAnimationFile(R.raw.YOUR_ANIMATION)
                         * .setAnimationFile("YOUR_ANIMATION.json")
                         *
                         * @Set Dialog Effects
                         * Use KAnimation To Set Dialog Opening Effects
                         * KAnimations = Animation_FADE_IN_OUT, Animation_DOWN, Animation_ZOOM_IN_OUT, Animation_SHAKE
                         * .setEffect(KAnimation.Animation_FADE_IN_OUT)
                         */
                        .setAnimationFile("YOUR_ANIMATION.json") // Set Custom Lottie Animation File Use @StringRes Or @IntegerRes
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Setting Dialog Opening Effects
                        /*
                         * @Set Gravity
                         * Use KSimpleDialog.{YOUR_GRAVITY} Or Use Gravity.{YOUR_GRAVITY}
                         * Example KSimpleDialog.{YOUR_GRAVITY};
                         *.setGravity(KSimpleDialog.CENTER)
                         *
                         * Example Gravity.{YOUR_GRAVITY};
                         *.setGravity(Gravity.CENTER)
                         */
                        .setGravity(Gravity.CENTER)
                        /*
                         * @Setting Buttons
                         * Use @IntegerRes Or @StringRes To Set Button Title
                         * Example;
                         * @StringRes
                         *.setPositiveButton("ACTION", new KBottomSheetDialog.OnPositiveButtonListener()
                         *.setNegativeButton("ACTION", new KBottomSheetDialog.OnNegativeButtonListener()
                         *
                         * @IntegerRes
                         *.setPositiveButton(R.string.YOUR_DIALOG_TITLE, new KBottomSheetDialog.OnPositiveButtonListener()
                         *.setNegativeButton(R.string.YOUR_DIALOG_TITLE, new KBottomSheetDialog.OnNegativeButtonListener()
                         */
                        .setPositiveButton("ACTION", new KBottomSheetDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.cancel(); // Or dialog.dismiss();
                            }
                        })
                        .setNegativeButton("ACTION", new KBottomSheetDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.cancel(); // Or dialog.dismiss();
                            }
                        })
                        .show(); // Show Dialog
```

To Display a **Bottom Sheet KDialog** :

``` java
 // Initiate KazDialog
                new KBottomSheetDialog.Builder(MainActivity.this)
                        /*
                         * @Set Title & Message
                         * Use @StringRes Or @IntegerRes To Set Title & Message
                         * Example @StringRes;
                         *.setTitle("YOUR_TITLE") // Set Title Use @StringRes
                         *.setMessage("YOUR_MESSAGE") // Set Message Use @StringRes
                         *
                         * Example @IntegerRes;
                         *.setTitle(R.string.YOUR_TITLE) // Set Title Use @IntegerRes
                         *.setMessage(R.string.YOUR_MESSAGE) // Set Message Use @IntegerRes
                         */
                        .setTitle(R.string.YOUR_TITLE)
                        .setMessage(R.string.YOUR_MESSAGE)
                        .setCancelable(false) // Set Dialog Cancelable
                        /*
                         * @Set Buttons Icons
                         * Use @IntegerRes To Set Icons
                         * Example;
                         *.setNegativeButtonIcon(R.drawable.YOUR_ICON) // Negative Button Icon
                         *.setPositiveButtonIcon(R.drawable.YOUR_ICON) // Positive Button Icon
                         *
                         * @Set Buttons Backgrounds
                         * Use @IntegerRes To Set Backgrounds
                         * Example;
                         *.setNegativeButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                         *.setPositiveButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                         */
                        .setNegativeButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                        .setPositiveButtonBackground(false, R.drawable.YOUR_DRAWABLE)
                        /*
                         * @Set Buttons Icons
                         * Use @IntegerRes To Set Icon Tint (Color)
                         * Example;
                         *.setNegativeButtonIcon(R.drawable.YOUR_ICON)
                         *.setPositiveButtonIcon(R.drawable.YOUR_ICON)
                         *
                         * @Set Buttons Icons Tint
                         * Use @IntegerRes To Set Icon Tint (Color)
                         * Example;
                         *.setNegativeIconTint(true, R.color.YOUR_COLOR)
                         *.setPositiveIconTint(true, R.color.YOUR_COLOR)
                         */         
                        .setNegativeIconTint(true, R.color.YOUR_COLOR)
                        .setPositiveIconTint(true, R.color.YOUR_COLOR)
                        /*
                         * @Set Custom Font
                         * Use @IntegerRes To Set Custom Font Whole Dialog
                         * Example;
                         *.setFont(true, R.font.YOUR_FONT)
                         *
                         * @Show Animations
                         * Use Boolean true / false
                         * Example;
                         *.setAnimation(true) // Set Animation To Dialog > Boolean == true / false
                         */
                        .setAnimation(true)
                        /*
                         * @Lottie Animation Use Note;
                         * When You Set Your Lottie Animation, If You Are Using Lottie Animation File Name? 
                         * eg: .setAnimationFile("delete_bubble.json") Use .json Extension,
                         * You Need To Placed Your Aimation File Into Your assets Folder
                         * When You Set Your Lottie Animation, If You Are Using Lottie Animation @IntegerRes
                         * eg : .setAnimationFile(R.raw.delete_bubble)
                         * You Can Placed It Into Your raw Folder
                         *
                         * Examples;
                         * .setAnimationFile(R.raw.YOUR_ANIMATION)
                         * .setAnimationFile("YOUR_ANIMATION.json")
                         *
                         * @Set Dialog Effects
                         * Use KAnimation To Set Dialog Opening Effects
                         * KAnimations = Animation_FADE_IN_OUT, Animation_DOWN, Animation_ZOOM_IN_OUT, Animation_SHAKE
                         * .setEffect(KAnimation.Animation_FADE_IN_OUT)
                         */
                        .setAnimationFile("YOUR_ANIMATION.json") // Set Custom Lottie Animation File Use @StringRes Or @IntegerRes
                        .setEffect(KAnimation.Animation_FADE_IN_OUT) // Setting Dialog Opening Effects
                        /*
                         * @Setting Buttons
                         * Use @IntegerRes Or @StringRes To Set Button Title
                         * Example;
                         * @StringRes
                         *.setPositiveButton("ACTION", new KBottomSheetDialog.OnPositiveButtonListener()
                         *.setNegativeButton("ACTION", new KBottomSheetDialog.OnNegativeButtonListener()
                         *
                         * @IntegerRes
                         *.setPositiveButton(R.string.YOUR_DIALOG_TITLE, new KBottomSheetDialog.OnPositiveButtonListener()
                         *.setNegativeButton(R.string.YOUR_DIALOG_TITLE, new KBottomSheetDialog.OnNegativeButtonListener()
                         */
                        .setPositiveButton("ACTION", new KBottomSheetDialog.OnPositiveButtonListener() {
                            @Override
                            public void OnPositiveButtonClick(Dialog dialog) {
                                dialog.cancel(); // Or dialog.dismiss();
                            }
                        })
                        .setNegativeButton("ACTION", new KBottomSheetDialog.OnNegativeButtonListener() {
                            @Override
                            public void OnNegativeButtonClick(Dialog dialog) {
                                dialog.cancel(); // Or dialog.dismiss();
                            }
                        })
                        .show(); // Show Dialog
```


# Default Drawable Button Background

**KDialogs Default Drawable Button Background**

``` xml 
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="@color/YOUR_COLOR"/> <!--Color-->
    <corners android:radius="8dp"/> <!--Corners-->
</shape>
````
## Preview

**Quick Preview GIF**

<div align="center">
	<img src="GIF%20Preview/KDialogs-Preview.gif">
</div>

<a name="credits"></a>
## Credits
This library is built with using a Animation open-source libraries
Called **Lottie Animation**.
- [Lottie Animations](https://github.com/airbnb/lottie-android)


## License
This Open Source is available under the **Apache 2.0** LICENSE.
