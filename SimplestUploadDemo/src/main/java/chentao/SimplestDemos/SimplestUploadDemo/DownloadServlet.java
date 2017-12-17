package chentao.SimplestDemos.SimplestUploadDemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

public class DownloadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿到上传的文件夹
        String folderPath = req.getServletContext().getRealPath("file-upload");
        resp.setCharacterEncoding("UTF-8");

        //如果文件夹不存在,则还未上传过,
        File folder = new File(folderPath);
        if(!folder.exists()){
            PrintWriter writer = resp.getWriter();
            writer.append("You haven't upload any file,please upload one file first!");
            writer.flush();
            return;
        }

        //拿到文件夹下的所有文件
        File [] fileList = folder.listFiles();
        //获取第一个文件
        File file = fileList[0];
        //设置response的文件属性
        resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

        //拿到response里的输出流
        OutputStream out = resp.getOutputStream();
        //使用文件创建输入流
        InputStream inputStream = new FileInputStream(file);

        byte [] buffer = new byte[1024];

        //将输入流的数据写到response中,浏览器会自动进行下载
        int len = 0;
        while((len=inputStream.read(buffer)) != -1){
            out.write(buffer,0,len);
        }

        //关掉所有输入输出流
        out.close();
        inputStream.close();
    }
}
