package io.github.diegoss.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static Date convertDate(String textDate, Date defaultValue){
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(textDate);
        } catch (Exception ex){
            return defaultValue;
        }
    }
}
