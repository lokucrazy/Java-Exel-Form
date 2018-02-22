/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaexel.exel;

import com.javaexel.SurplusItem;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author relc7d
 */
public class ExelWriter {
    private List<SurplusItem> items;
    private Workbook wb;
    private CreationHelper ch;
    private Sheet sheet;
    private Font header;
    private CellStyle headerCell;
    private int rowNumber;
    
    public ExelWriter(ArrayList<SurplusItem> items){
        this.items = items;
        wb = new XSSFWorkbook();
        ch = wb.getCreationHelper();
        sheet = wb.createSheet("Surplus");
        header = wb.createFont();
        headerCell = wb.createCellStyle();
        
        header.setBold(true);
        headerCell.setFont(header);
        rowNumber = 0;
    }
    
    public void write() throws Exception {
        int size = items.get(0).getAttributes().length;
        for(SurplusItem item: items){
            Row row = sheet.createRow(rowNumber);
            for (int i = 0; i < size; i++){
                row.createCell(i).setCellValue(item.getAttributes()[i]);
                
            }
            rowNumber++;
        }
        for (int i = 0; i < size; i++){
            sheet.autoSizeColumn(i);
        }
        
        FileOutputStream out = new FileOutputStream("generatedFile.xlsx");
        wb.write(out);
        out.close();
    }
}
