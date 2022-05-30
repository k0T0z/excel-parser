import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {
    private String path;
    static int apis;

    ReadExcel(String path) throws IOException {
        this.path = path;
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        int rows = xssfSheet.getLastRowNum();

        for (int i = 0 ; i < rows ; i++) {
            XSSFRow xssfRow = xssfSheet.getRow(i);
            try {
                XSSFCell xssfCell = xssfRow.getCell(0);
                String temp = xssfCell.getStringCellValue();
                int index = temp.indexOf('(');
                if(index != -1) {
                    temp = temp.substring(0,index-1);
                    if(temp.equals("REST Operation Mapping")) {
                        apis++;
                    }
                }
            }
            catch (NullPointerException ignored) {}
        }
    }

    ArrayList<Integer> find() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        int rows = xssfSheet.getLastRowNum();

        ArrayList<Integer> firstLast = new ArrayList<>();
        boolean start = false;

        for (int i = 0 ; i <= rows+1 ; i++) {
            XSSFRow xssfRow = xssfSheet.getRow(i);
            try {
                XSSFCell xssfCell = xssfRow.getCell(0);
                String temp = xssfCell.getStringCellValue();
                if(temp.equals("I/o")) {
                    assert false;
                    firstLast.add(i);
                    start = true;
                }
            }
            catch (NullPointerException ignored) {
                if (start) {
                    assert false;
                    firstLast.add(i-1);
                    start = false;
                }
            }
        }
        return firstLast;
    }

    ArrayList<ArrayList<ArrayList<String>>> read(ArrayList<Integer> firstLast) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        int index = 0;

        ArrayList<ArrayList<ArrayList<String>>> fullData = new ArrayList<>();


        for (int i = 0 ; i < apis ; i++) {
            ArrayList<ArrayList<String>> apiLevel = new ArrayList<>();
            for (int j = 0 ; j < firstLast.get(index+1) - firstLast.get(index) + 1 ; j++) {
                try {
                    ArrayList<String> rowLevel = new ArrayList<>();
                    XSSFRow xssfRow = xssfSheet.getRow(firstLast.get(index) + j);
                    int columns = xssfRow.getLastCellNum();
                    for (int k = 0 ; k < columns ; k++) {
                        XSSFCell xssfCell = xssfRow.getCell(k);
                        rowLevel.add(xssfCell.getStringCellValue());
                    }
                    apiLevel.add(rowLevel);
                }
                catch (NullPointerException ignored) {}
            }
            fullData.add(apiLevel);
            index+=2;
        }

        return fullData;
    }
}
