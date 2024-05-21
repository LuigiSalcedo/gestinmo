package com.inmobicasaventas.gestinmo.api.offers.infrastructure.mappers.formatter;

import java.text.NumberFormat;
import java.util.Locale;

public class COPCurrentyFormater {
    public static String format(Long price) {
        Locale locale = new Locale("es", "CO");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.format(price);
        return numberFormat.toString();
    }
}
