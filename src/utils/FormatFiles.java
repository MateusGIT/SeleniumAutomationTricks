/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

/**
 *
 * @author Mateus Oliveira
 */
public class FormatFiles {

    private Workbook wb; //worbook para trabalhar com apache poi, biblioteca para manipular excel files (xls, xlsx..)
    private XSSFSheet sheet; //"sheet = aba", objeto "aba" onde vou manipular linhas,colunas,etc dos arquivos a ser lido e escrito 
    private Row row;//objeto para manipulação de linhas
    private String readLine; //string onde será aplicado o metodo readline para poder ler as linhas de um arquivo pré existente
    private String[] split;// array que guardará strings comumentes separadas por ; em arquivos csv (coma separated values)
    private int countRow;
    
    public FormatFiles() {
        //construtor
        this.wb = new XSSFWorkbook();
        this.sheet = (XSSFSheet) wb.createSheet("Excel");
        this.readLine = "";

    }

    public void CsvToExcelSP(String pathcsv, String filenameXlsx) throws FileNotFoundException, IOException, InvalidFormatException {
        FileInputStream in = new FileInputStream(pathcsv); //recebe arquivo
        BufferedReader read = new BufferedReader(new InputStreamReader(in)); //cria reader sobre o arquivo
        System.out.println("FORMATING..");

        try {//percore a planilha original copiando os dados para a nova

            while (readLine != null) {
                readLine = read.readLine();
                row = sheet.createRow(countRow);
                split = readLine.split(";");
                countRow++;
            }
        } //  System.out.println(readLine);
        catch (Exception e) {
        }
        FileOutputStream fileOut = new FileOutputStream(filenameXlsx);

        wb.write(fileOut);
        System.out.println("SP FORMATED");
    }

    public void CsvToExcelSC(String pathcsv, String filenameXlsx) throws FileNotFoundException, FileNotFoundException, IOException {
        int countRow = 0;
        int pulaLinhasIndesejaveis = 0;
        FileInputStream in = new FileInputStream(pathcsv);
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        System.out.println("FORMATING..SC");

        try {//percore a planilha original copiando os dados para a nova
            while (readLine != null) {
                readLine = read.readLine();
                if (pulaLinhasIndesejaveis >= 1) { // garante que o while passe pela linha dos headers da planilha antiga, sem escrever nada.
                    Row row = sheet.createRow(countRow);
                    split = readLine.split(",");
                    String dddtel = split[0];
                    String bloqueado = "bloqueado";
                    String ultimaColuna = readLine.substring(readLine.lastIndexOf(',') + 1); // pegando o ultimo split já que o método split não permite
                    row.createCell(0).setCellValue(dddtel);
                    row.createCell(1).setCellValue(ultimaColuna);
                    row.createCell(2).setCellValue(bloqueado);
                    countRow++;
                }
                pulaLinhasIndesejaveis++;
            }

        } //  System.out.println(readLine);
        catch (java.lang.NullPointerException e) {
        }
        FileOutputStream fileOut = new FileOutputStream(filenameXlsx);

        wb.write(fileOut);
        System.out.println("SC FORMATED");
    }

    public void CsvToExcelRS(String pathcsv, String filenameXlsx) throws FileNotFoundException, IOException, InvalidFormatException {

        int countRow = 0;
        int pulaLinhasIndesejaveis = 0;
        FileInputStream in = new FileInputStream(pathcsv);
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        String dddtel = "";
        String cadastrado = "";
        System.out.println("FORMATING..RS");

        try {//percore a planilha original copiando os dados para a nova
            while (readLine != null) {
                readLine = read.readLine();
                if (pulaLinhasIndesejaveis >= 1) { // garante que o while passe pela linha dos headers da planilha antiga, sem escrever nada.
                    Row row = sheet.createRow(countRow);
                    split = readLine.split(";");
                    try {
                        dddtel = split[0] + split[1];
                    } catch (Exception e) {
                    }
                    try {
                        cadastrado = split[2];
                    } catch (Exception e) {
                    }
                    String bloqueado = "bloqueado";
                    String ultimaColuna = readLine.substring(readLine.lastIndexOf(';') + 1); // pegando o ultimo split já que o método split não permite
                    row.createCell(0).setCellValue(dddtel);
                    row.createCell(1).setCellValue(cadastrado);
                    row.createCell(2).setCellValue(bloqueado);
                    row.createCell(3).setCellValue(ultimaColuna);
                    countRow++;
                }
                pulaLinhasIndesejaveis++;
            }

        } //  System.out.println(readLine);
        catch (java.lang.NullPointerException e) {
        }
        FileOutputStream fileOut = new FileOutputStream(filenameXlsx);

        wb.write(fileOut);
        System.out.println("RS FORMATED");
    }

    public void XlsToXlsxRN(String pathxls, String filenameXlsx) throws FileNotFoundException, IOException, InvalidFormatException {
        String page = "";
        String readLine = "";
        int countRow = 0;
        int pulaLinhasIndesejaveis = 0;
        FileInputStream in = new FileInputStream(pathxls);
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        System.out.println("FORMATING..RN");

//        }
        try {//percore a planilha original copiando os dados para a nova

            while (readLine != null) {
                readLine = read.readLine();
                try {
                    readLine = readLine.replace("(", "");
                    readLine = readLine.replace(")", "");
                } catch (Exception e) {
                };
                page += readLine;

            }
            org.jsoup.nodes.Document doc = Jsoup.parse(page);
            Elements links = doc.select("tr");
            for (org.jsoup.nodes.Element tr : links) {

                Elements tds = tr.select("td");
                if (pulaLinhasIndesejaveis >= 1) {
                    Row row = sheet.createRow(countRow);
                    row.createCell(0).setCellValue(tds.get(1).text());
                    row.createCell(1).setCellValue(tds.get(2).text());
                    row.createCell(2).setCellValue("bloqueado");
                    countRow++;
                }
                pulaLinhasIndesejaveis++;
            }

        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
        }
        FileOutputStream fileOut = new FileOutputStream(filenameXlsx);

        wb.write(fileOut);
        System.out.println("RN FORMATED");
    }

    public void TxtToXlsxPR(String pathtxt, String filenameXlsx) throws FileNotFoundException, IOException, InvalidFormatException {
        int countRow = 0;
        FileInputStream in = new FileInputStream(pathtxt);
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        System.out.println("FORMATING..PR");

        int pulaLinhasIndesejaveis = 0;
        try {//percore a planilha original copiando os dados para a nova
            while (readLine != null) {
                readLine = read.readLine();
                if (pulaLinhasIndesejaveis >= 5) {
                    Row row = sheet.createRow(countRow);
                    split = readLine.split(";");
                    String dddtel = split[0];
                    String cadastrado = split[1];
                    String bloqueado = "bloqueado";
                    String ultimaColuna = split[3]; // pegando o ultimo split já que o método split não permite
                    row.createCell(0).setCellValue(dddtel);
                    row.createCell(1).setCellValue(cadastrado);
                    row.createCell(2).setCellValue(bloqueado);
                    row.createCell(3).setCellValue(ultimaColuna);
                    countRow++;
                }
                pulaLinhasIndesejaveis++;
            }
        } catch (Exception e) {
        }
        FileOutputStream fileOut = new FileOutputStream(filenameXlsx);

        wb.write(fileOut);
        System.out.println("PR FORMATED");
    }

    public void CsvToXlsxES(String pathcsv, String filenameXlsx) throws FileNotFoundException, IOException, InvalidFormatException {
        int countRow = 0;
        int pulaLinhasIndesejaveis = 0;
        FileInputStream in = new FileInputStream(pathcsv);
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        System.out.println("FORMATING..ES");

        try {//percore a planilha original copiando os dados para a nova
            while (readLine != null) {
                readLine = read.readLine();
                if (pulaLinhasIndesejaveis >= 4) { // garante que o while passe pela linha dos headers da planilha antiga, sem escrever nada.
                    Row row = sheet.createRow(countRow);
                    split = readLine.split(";");
                    String dddtel = split[0];
                    String cadastrado = split[1];
                    String bloqueado = "bloqueado";
                    String ultimaColuna = readLine.substring(readLine.lastIndexOf(';') + 1); // pegando o ultimo split já que o método split não permite
                    row.createCell(0).setCellValue(dddtel);
                    row.createCell(1).setCellValue(cadastrado);
                    row.createCell(2).setCellValue(bloqueado);
                    row.createCell(3).setCellValue(ultimaColuna);
                    countRow++;
                }
                pulaLinhasIndesejaveis++;
            }

        } //  System.out.println(readLine);
        catch (Exception e) {
            e.printStackTrace();
        }
        FileOutputStream fileOut = new FileOutputStream(filenameXlsx);

        wb.write(fileOut);
        System.out.println("ES FORMATED");
    }

    public void TxtToXlsxAL(String pathtxt, String filenameXlsx) throws FileNotFoundException, IOException, InvalidFormatException {
        int countRow = 0;
        FileInputStream in = new FileInputStream(pathtxt);
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        System.out.println("FORMATING..AL");

        try {//percore a planilha original copiando os dados para a nova
            while (readLine != null) {
                readLine = read.readLine();
                Row row = sheet.createRow(countRow);
                split = readLine.split("\\|");
                String dddtel = split[0];
                String cadastrado = split[1];
                row.createCell(0).setCellValue(dddtel);
                row.createCell(3).setCellValue(cadastrado);
                row.createCell(2).setCellValue("bloqueado");
                countRow++;
            }
        } //  System.out.println(readLine);
        catch (java.lang.NullPointerException e) {
        }
        FileOutputStream fileOut = new FileOutputStream(filenameXlsx);

        wb.write(fileOut);
        System.out.println("AL FORMATED");
    }

    public void DeleteFiles() {
        File dir = new File("planilhas/");
        try {
            for (File file : dir.listFiles()) {
                if (!file.getName().equals("TelefonesBloqueados.xlsx")) {
                    file.delete();
                }
            }
        } catch (Exception e) {
        }
    }
}
