package ispracs;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
public class Des {
    private static Cipher encrypt;
    private static Cipher decrypt;
    private static final byte[] initialization_vector = { 22, 33, 11, 44, 55, 99, 66, 77 };    
    public static void main(String[] args) {
        int choice;
        String clearFile,encryptedFile,decryptedFile;
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to encrypt 1.text file using CFB  2.text file using OFB  3. Image CFB 4. Image OFB" 
                + "\nEnter your choice(1/2):");
        choice=sc.nextInt();
        switch(choice){
            case 1:      clearFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\input.txt";
                         encryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\enc.txt";
                         decryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\dec.txt";
                        try {
                               SecretKey secret_key = KeyGenerator.getInstance("DES").generateKey();
                               AlgorithmParameterSpec alogrithm_specs = new IvParameterSpec( initialization_vector);
                           // set encryption mode ...
                               encrypt = Cipher.getInstance("DES/CFB/PKCS5Padding");
                               encrypt.init(Cipher.ENCRYPT_MODE, secret_key, alogrithm_specs);
                           // set decryption mode
                                decrypt = Cipher.getInstance("DES/CFB/PKCS5Padding");
                                decrypt.init(Cipher.DECRYPT_MODE, secret_key, alogrithm_specs);
                            // encrypt file
                                encrypt(new FileInputStream(clearFile), new FileOutputStream(encryptedFile));
                             // decrypt file
                                decrypt(new FileInputStream(encryptedFile), new FileOutputStream(decryptedFile)); 
                                System.out.println("Successfull!");
                        } 
                         catch (Exception e) {
                         e.printStackTrace();
                        }
                       break;
             case 2:      clearFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\input.txt";
                         encryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\enc.txt";
                         decryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\dec.txt";
                        try {
                               SecretKey secret_key = KeyGenerator.getInstance("DES").generateKey();
                               AlgorithmParameterSpec alogrithm_specs = new IvParameterSpec( initialization_vector);
                           // set encryption mode ...
                               encrypt = Cipher.getInstance("DES/OFB/PKCS5Padding");
                               encrypt.init(Cipher.ENCRYPT_MODE, secret_key, alogrithm_specs);
                           // set decryption mode
                                decrypt = Cipher.getInstance("DES/OFB/PKCS5Padding");
                                decrypt.init(Cipher.DECRYPT_MODE, secret_key, alogrithm_specs);
                            // encrypt file
                                encrypt(new FileInputStream(clearFile), new FileOutputStream(encryptedFile));
                             // decrypt file
                                decrypt(new FileInputStream(encryptedFile), new FileOutputStream(decryptedFile)); 
                                System.out.println("Successfull!");
                        } 
                         catch (Exception e) {
                         e.printStackTrace();
                        }
                       break;
                       
            case 3:      clearFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\img1.jpeg";
                         encryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\img2.png";
                         decryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\img3.png";
                        try {
                               SecretKey secret_key = KeyGenerator.getInstance("DES").generateKey();
                               AlgorithmParameterSpec alogrithm_specs = new IvParameterSpec( initialization_vector);
                           // set encryption mode ...
                               encrypt = Cipher.getInstance("DES/CFB/PKCS5Padding");
                               encrypt.init(Cipher.ENCRYPT_MODE, secret_key, alogrithm_specs);
                           // set decryption mode
                                decrypt = Cipher.getInstance("DES/CFB/PKCS5Padding");
                                decrypt.init(Cipher.DECRYPT_MODE, secret_key, alogrithm_specs);
                            // encrypt file
                                encrypt(new FileInputStream(clearFile), new FileOutputStream(encryptedFile));
                             // decrypt file
                                decrypt(new FileInputStream(encryptedFile), new FileOutputStream(decryptedFile)); 
                                System.out.println("Successfull!");
                        } 
                         catch (Exception e) {
                         e.printStackTrace();
                        }
                       break; 
           case 4:      clearFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\img1.jpeg";
                         encryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\img2.png";
                         decryptedFile = "C:\\Users\\vision\\Documents\\NetBeansProjects\\ISPRACS\\src\\img3.png";
                        try {
                               SecretKey secret_key = KeyGenerator.getInstance("DES").generateKey();
                               AlgorithmParameterSpec alogrithm_specs = new IvParameterSpec( initialization_vector);
                           // set encryption mode ...
                               encrypt = Cipher.getInstance("DES/OFB/PKCS5Padding");
                               encrypt.init(Cipher.ENCRYPT_MODE, secret_key, alogrithm_specs);
                           // set decryption mode
                                decrypt = Cipher.getInstance("DES/OFB/PKCS5Padding");
                                decrypt.init(Cipher.DECRYPT_MODE, secret_key, alogrithm_specs);
                            // encrypt file
                                encrypt(new FileInputStream(clearFile), new FileOutputStream(encryptedFile));
                             // decrypt file
                                decrypt(new FileInputStream(encryptedFile), new FileOutputStream(decryptedFile)); 
                                System.out.println("Successfull!");
                        } 
                         catch (Exception e) {
                         e.printStackTrace();
                        }
                       break; 
                       
        }

    }
    private static void encrypt(InputStream input, OutputStream output) throws IOException {
        output = new CipherOutputStream(output, encrypt);
        writeBytes(input, output);
    }
    
    private static void decrypt(InputStream input, OutputStream output) throws IOException {
        input = new CipherInputStream(input, decrypt);
        writeBytes(input, output);
    }
    private static void writeBytes(InputStream input, OutputStream output)    throws IOException {
        byte[] writeBuffer = new byte[512];
        int readBytes = 0;
        while ((readBytes = input.read(writeBuffer)) >= 0) {
            output.write(writeBuffer, 0, readBytes);
           }
        output.close();
        input.close();
       }
    }
