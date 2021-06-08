package com.example.ApplicationFiles;



import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.*;
import java.util.Arrays;

import ru.ubmb.jstribog.StribogProvider;

public class FileActions {
    //Возвращает Хэш файла
    public static String getFileHash(MultipartFile multipartFile) throws NoSuchAlgorithmException, IOException {
        if (Security.getProvider("JStribog") == null) {
            Security.addProvider(new StribogProvider());
        }
        //File jpgFile = new File("C:\\Users\\pumka\\Desktop\\testFile.jpg");
        //byte[] fileContent = Files.readAllBytes(jpgFile.toPath());

        MessageDigest md = MessageDigest.getInstance("Stribog512");
        byte[] digest = md.digest(multipartFile.getBytes());
        //byte[] digest = md.digest(fileContent);
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

    private static File multypartToFile(MultipartFile file){

        return new File("");
    }

}