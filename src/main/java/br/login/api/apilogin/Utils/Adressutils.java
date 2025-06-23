package br.login.api.apilogin.Utils;

import org.springframework.beans.factory.annotation.Value;

public class Adressutils {

    @Value("${link.server.adress}")
    public static String url;


    public static String urlGet () {
        return url;
    }


}
