package chentao.SimplestDemos.SimplestPOIExcelDemo;

import jdk.internal.util.xml.impl.Input;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;

public class POIDemo {
    /**
     * 创建一个excel文档,在文档第一个单元格中填入"Hello World"字段
     */
    public String writeToExcel() throws IOException {
        //创建一个新的工作簿
        Workbook workbook = new XSSFWorkbook();

        //在工作簿中创建一个sheet页
        Sheet sheet = workbook.createSheet("First Sheet");

        //在sheet页创建一行Row
        Row row= sheet.createRow(0);

        //在该Row第一列的位置创建一个单元格
        Cell cell = row.createCell(0);

        //单元格中填入文字
        cell.setCellValue("Hello World! ");

        //拿到类的路径
        URL fileFolderURL = getClass().getResource("");
        String FolderPath = fileFolderURL.getFile();

        //自己创建的新文件的路径
        String filePath = FolderPath + "POIDemo" + ".xlsx";

        //输出流
        OutputStream stream = new FileOutputStream(filePath);

        //将工作簿写到文件输出流中
        try {
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            //必须关闭workbook,否则常驻内存
            if(workbook != null) {
                workbook.close();
            }
        }

        System.out.println("File saved successfully!The Path is: "+ filePath );
        return filePath;
    }

    public void readExcel(String filePath) throws IOException {
        //根据文件路径创建输入流
        InputStream stream = new FileInputStream(filePath);

        //根据输入流打开工作簿
        Workbook workbook = new XSSFWorkbook(stream);

        //得到sheet页
        Sheet sheet = workbook.getSheetAt(0);

        //得到行对象
        Row row = sheet.getRow(0);

        //得到单元格对象
        Cell cell = row.getCell(0);

        //拿到单元格中的值
        System.out.println(cell.getStringCellValue());

    }

}
