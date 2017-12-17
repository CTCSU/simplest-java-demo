package chentao.SimplestDemos.SimplestZipJDemo;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimplestZip4JDemo {
    public void upZip(String filePath) throws ZipException {
        //根据zip文件的路径,拿到文件所在文件夹的路径,作为zip文件解压路径
        String folderPath = filePath.substring(0,filePath.lastIndexOf("\\"));
        //根据当前时间生成一个子文件夹
        String generateFolderPath = folderPath + "\\" + System.currentTimeMillis();
        //根据文件路径创建zpiFile对象
        ZipFile zipFile = new ZipFile(filePath);

        //windows下所有压缩文件的文件名使用GBK编码,而zip4j默认为UTF-8,解决windows下的乱码问题
        //另外,linux压缩文件默认为utf-8编码,所以linux下运行可能会乱码,需要适配,本项目就不扩展了
        zipFile.setFileNameCharset("GBK");

        //解压:
        zipFile.extractAll(generateFolderPath);
    }

    public String zip(String folderPath) throws FileNotFoundException, ZipException {
        //拿到文件夹名称,作为zip文件的文件名:
        File folder= new File(folderPath);
        if(!folder.exists() || !folder.isDirectory()){
            throw new FileNotFoundException("请输入一个正确的路径");
        }
        String folderName = folder.getName();
        //在folder下创建zip文件:
        String zipFilePath = folderPath + "\\" + folderName + ".zip";

        //得到文件夹下的所有文件:
        File [] filesInFolder = folder.listFiles();

        //需要压缩的所有文件:
        ArrayList<File> files = new ArrayList<File>();
        Collections.addAll(files,filesInFolder);

        //执行压缩
        ZipFile zipFile = new ZipFile(zipFilePath);
        zipFile.setFileNameCharset("GBK");
        //压缩必须创建一个parameter的对象,使用默认设置即可
        ZipParameters zipParameters = new ZipParameters();
        //压缩起来
        zipFile.addFiles(files,zipParameters);
        return zipFilePath;
    }
}
