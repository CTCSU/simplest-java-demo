package chentao.SimplestDemos.SimplestZipJDemo;

import net.lingala.zip4j.exception.ZipException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.*;

public class SimplestZip4JDemoTest {


    @Test
    public void testZip() throws FileNotFoundException, ZipException {
        URL folder = getClass().getClassLoader().getResource("zip");
        String folderPath = folder.getPath();
        SimplestZip4JDemo demo = new SimplestZip4JDemo();
        File file = new File(folderPath);
        printAllFileInFolder(file);

        String filePath = demo.zip(folderPath);
        printAllFileInFolder(file);

        demo.upZip(filePath);
        printAllFileInFolder(file);
    }

    //列出文件夹下的子文件
    public void printAllFileInFolder(File file){
        if(!file.isDirectory()){
            System.out.println("This is not a folder");
        }

        File[] fileList = file.listFiles();
        System.out.println(file.getName()+"路径下有如下文件");
        for(File childFile:fileList){
            System.out.println(childFile.getName());
        }
        System.out.println("-----------------------------------------------------------------");
    }
}