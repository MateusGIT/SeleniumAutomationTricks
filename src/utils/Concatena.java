/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author yank
 */
public class Concatena { //cria os atributos do objeto

    Workbook wb;

    SXSSFSheet sheet;
    int countRow;
    FileOutputStream fileOut;

    public Concatena() throws FileNotFoundException { //método para juntar as planilhas
//this. seta os valores
        this.wb = new SXSSFWorkbook();
        this.sheet = (SXSSFSheet) wb.createSheet("Excel");
        this.countRow = 0;
        this.fileOut = new FileOutputStream("planilhas/TelefonesBloqueados.xlsx");
        sheet = (SXSSFSheet) wb.getSheetAt(0);
    }

    public void concatenar() throws FileNotFoundException, IOException {
        String caminhoSP = "planilhas/proconSP.xlsx";
        String caminhoRN = "planilhas/proconRN.xlsx";
        String caminhoSC = "planilhas/proconSC.xlsx";
        String caminhoRS = "planilhas/proconRS.xlsx";
        String caminhoAL = "planilhas/proconAL.xlsx";
        String caminhoES = "planilhas/proconES.xlsx";
        String caminhoPR = "planilhas/proconPR.xlsx";

        try {
            leituraPlanilha(caminhoSP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            leituraPlanilha(caminhoRN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            leituraPlanilha(caminhoSC);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            leituraPlanilha(caminhoRS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            leituraPlanilha(caminhoAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            leituraPlanilha(caminhoES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            leituraPlanilha(caminhoPR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leituraPlanilha(String caminhoArquivo) throws FileNotFoundException, IOException {

        InputStream ExcelFileToRead = new FileInputStream(caminhoArquivo);
        XSSFWorkbook wb2 = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet2 = wb2.getSheetAt(0);
        Iterator<Row> rowIterator = sheet2.iterator();
        Iterator<Cell> cellIterator = null;
        int aux;
        Row rowPrincipal;
        String leCampos;
        Cell cell;
        Row row;
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            // For each row, iterate through each columns
            cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                rowPrincipal = sheet.createRow(countRow);
                for (int i = 0; i <= 3; i++) {
                    try {
                        cell = cellIterator.next();
                        leCampos = cell.getStringCellValue();
                        rowPrincipal.createCell(i).setCellValue(leCampos);
                    } catch (Exception e) {
                    }
                }
                countRow++;
            }
            cellIterator = null;
        }
        ExcelFileToRead.close();
        rowIterator = null;
        System.out.println(caminhoArquivo + "Salvo com sucesso");
    }
}
