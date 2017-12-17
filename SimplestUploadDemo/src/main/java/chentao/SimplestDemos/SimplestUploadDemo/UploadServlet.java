package chentao.SimplestDemos.SimplestUploadDemo;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先拿到上传的文件夹,如果不存在这个文件夹,则先创建
        String folderPath = req.getServletContext().getRealPath("file-upload");
        File folder = new File(folderPath);
        if(!folder.exists()){
            folder.mkdirs();
        }

        //使用common-upload的组件
        DiskFileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);
        servletFileUpload.setHeaderEncoding("UTF-8");

        //设置缓存大小
        itemFactory.setSizeThreshold(1024*500);
        //设置单个文件最大
        servletFileUpload.setFileSizeMax(1024*1024*10);


        OutputStream outputStream = null;
        InputStream inputStream = null;
        String filePath = null;
        try {
            //将request里闯过来的文件转化为FileItem
            List<FileItem> itemList = servletFileUpload.parseRequest(req);
            for(FileItem item:itemList){
                //如果是表单域,则不做处理;
                //否则既是文件
                if(!item.isFormField()){
                    //文件名
                    String fileName = item.getName();

                    inputStream = item.getInputStream();

                    byte [] buffer = new byte[1024];

                    //生成文件全名(带路径的)
                    filePath = folderPath + "\\" + fileName;
                    //初始化文件
                    File uploadFile = new File(filePath);

                    outputStream = new FileOutputStream(uploadFile);

                    //利用输入输出流将fileItem写入到文件中
                    int len = 0;
                    while ((len = inputStream.read(buffer)) != -1){
                        outputStream.write(buffer,0,len);
                    }

                    PrintWriter writer = resp.getWriter();
                    writer.println("Upload comleted!");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //关掉所有的输入输出流
        finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }
    }
}
