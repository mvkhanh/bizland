package com.javaweb.utils;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class FileUtil {
    private static final String FILE_NAME = "image.jpg";
    public static byte[] FileToByte(MultipartFile file){
        try {
            return file != null ? file.getBytes() : null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static MultipartFile ByteToFile(byte[] bytes){
        return new MockMultipartFile(FILE_NAME, bytes);
    }
    public static String FileToImage(MultipartFile file) {
        try {
            return Base64.getEncoder().encodeToString(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
