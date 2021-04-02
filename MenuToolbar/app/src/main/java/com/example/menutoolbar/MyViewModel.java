package com.example.menutoolbar;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private static String _speed;
    private static String _themeColor;

    public static String getSpeed() {
        return _speed;
    }

    public static void setSpeed(String _speed) {
        MyViewModel._speed = _speed;
    }

    public static String getThemeColor() {
        return _themeColor;
    }

    public static void setThemeColor(String _themeColor) {
        MyViewModel._themeColor = _themeColor;
    }

}
