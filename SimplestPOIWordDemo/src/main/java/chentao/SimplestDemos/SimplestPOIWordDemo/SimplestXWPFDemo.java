package chentao.SimplestDemos.SimplestPOIWordDemo;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.net.URL;
import java.util.List;

public class SimplestXWPFDemo {
    public static final String fileName = "示例.docx";

    public String writeToDocxDocument() throws IOException {
        //得到类的路径地址，将在该路径创建word文档
        URL folder = getClass().getResource("");
        String folderPath = folder.getPath();

        //生成文件路径全名；
        String filePath = folderPath + "\\" + fileName;
        File file = new File(filePath);

        //初始化XWPF文档
        XWPFDocument document = new XWPFDocument();

        //创建一个paragraph
        XWPFParagraph paragraph = document.createParagraph();

        //设置paragraph的文字：
        //run是paragraph中相同style的一段内容：
        XWPFRun run = paragraph.createRun();
        run.setText("Hello World");

        //将文档写入到输出流
        OutputStream stream =null;
        try {
            stream = new FileOutputStream(file);
            document.write(stream);
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(stream != null){
                stream.close();
            }
        }
        return filePath;
    }

    public String readFromWordDocument(String filePath) throws IOException {
        //返回结果
        StringBuffer result = new StringBuffer();

        InputStream in = null;
        try {
            //根据传进来的filePath初始化一个XWPFDocument
            in = new FileInputStream(filePath);
            XWPFDocument document = new XWPFDocument(in);

            //得到文档中所有的Paragraph
            List<XWPFParagraph> paragraphList = document.getParagraphs();

            //将所有paragraph中的文字添加到result中
            for(XWPFParagraph paragraph:paragraphList){
                result.append(paragraph.getText());
                result.append("\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally{
            if(in != null){
                in.close();
            }
        }
        return result.toString();
    }
}
