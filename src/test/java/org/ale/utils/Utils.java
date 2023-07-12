package org.ale.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    public static String lerConteudoSQL(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\A");
        String sql = sc.hasNext() ? sc.next() : "";
        sc.close();
        return sql;
    }

    public static ArrayList<String> lerSQL(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter(";");
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()) {
            arrayList.add(sc.next());
        }
        sc.close();
        return arrayList;
    }

    public static String timeStamp() {
        LocalDateTime dataAtual = LocalDateTime.now();
        String timestamp = String.valueOf(dataAtual.toEpochSecond(java.time.ZoneOffset.UTC));
        return timestamp;
    }

    public static String limpaUrlEmail(String email) {
        String url = null;

        /* Expressão regular para encontrar a URL
        http:// literalmente
        \w qualquer caracter alfanumerico e sublinhado _
        \d qualquer digito
        /:.?=&_- caracter que podem existir em uma url
         */

        String regex = "http://[\\w\\d/:.?=&_-]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            url = matcher.group();
        }

        return url;
    }


    public static String hashPassword(String password) {
        try {
            // Obter instância do algoritmo de hash SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Converter a senha em bytes
            byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);

            // Aplicar o hash na senha
            byte[] hashedBytes = digest.digest(passwordBytes);

            // Converter o hash em uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        return password;
    }

    public static int getDataEpochTime(){
        return Integer.parseInt(String.valueOf((new Date().getTime()/1000)));
    }
}