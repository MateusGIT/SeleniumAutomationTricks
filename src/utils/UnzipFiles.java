/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Mateus Oliveira
 */
public class UnzipFiles {


    public void UnzipFile(String path, String filename) throws FileNotFoundException, IOException, InterruptedException {
        System.out.println("UNZIPING "+path);
        String fileZip = path;
        byte[] buffer = new byte[1024]; //variavel byte para leitura de caracteres
        ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip)); //recebe dados de um arquivo zip
        ZipEntry zipEntry = zis.getNextEntry(); //encontra os arquivos para unzipar
        while (zipEntry != null) {
            File newFile = new File(filename);
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
        System.out.println("UNZIPED!");
        Thread.sleep(3000);
    }

}
