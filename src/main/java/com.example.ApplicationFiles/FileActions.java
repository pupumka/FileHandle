package com.example.ApplicationFiles;



import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.*;
import ru.fsb.gost.GOSTProvider;
import ru.ubmb.jstribog.StribogProvider;

public class FileActions {
    //Возвращает Хэш файла по госту 2018 года
    public static String getFile2018Hash(MultipartFile multipartFile) throws NoSuchAlgorithmException, IOException {
        if (Security.getProvider("JStribog") == null) {
            Security.addProvider(new StribogProvider());
        }
        MessageDigest md = MessageDigest.getInstance("Stribog512");
        byte[] digest = md.digest(multipartFile.getBytes());
        return printHex(digest);
    }

    //Возвращает Хэш файла по госту 2012 года
    public static String getFile2012Hash(MultipartFile multipartFile) throws NoSuchAlgorithmException, IOException {
        if (Security.getProvider("GOST") == null) {
            Security.addProvider(new GOSTProvider());
        }
        MessageDigest md = MessageDigest.getInstance("GOST3411-2012.512");
        byte[] digest = md.digest(multipartFile.getBytes());
        return printHex(digest);
    }

    private static String printHex(byte[] digest) {
        String result = "";
        for (byte b : digest) {
            int iv = (int) b & 0xFF;
            if (iv < 0x10) {
                System.out.print('0');
            }
            result = result + Integer.toHexString(iv).toUpperCase();
        }
        return result;
    }

}
