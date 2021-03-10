package com.example.clock.Utils;

import android.annotation.SuppressLint;

public class TimeFormat {
    @SuppressLint("DefaultLocale")
    public String formatString(int time) {
        String format = "";
        int mills = time % 100;
        int second = (time / 100) % 60;
        int minut = ((time - mills) / 100 - second) / 60;
        format = String.format("%02d:%02d.%02d", minut, second, mills);
        return format;
    }

    @SuppressLint("DefaultLocale")
    public String numberFormatString(int number) {
        return String.format("%02d", number);
    }
}
