## 最简程序之上传下载
### 运行说明:
本项目使用maven搭建.您可以直接使用maven引入项目;  
如果您不使用maven,请将本项目需要的jar包加入项目运行的环境中.
包括;
- commons-fileupload
- commons-io
- javax:servlet-api

###创建步骤:
---
#### 上传模块
上传模块使用commons-upload的技术,这个也是web项目最常用的上传的技术.  
***步骤;***
1. 创建jsp页面,创建一个表单,使表单的action对应上servlet的路径:
    ```
    <form action="/upload" method="post" enctype="multipart/form-data">
           <label>上传:</label>
           <input type="file" name="file">
           <input type="submit" value="确定">
    </form>
    ```
2. 创建uploadServlet;
    1. 初始化 DiskFileItemFactory.
    2. 使用DiskFileItemFactory对象初始化一个ServletFileUpload
    3. 调用servletFileUplaod对象的parse(Request)方法将Request中的文件转化为FileItem对象List
    4. 根据FileItem对象获取其输入流,并创建一个文件的输出流,使用输入输出流将传过来的数据写入文件.
    
3. 在web.xml中增加servlet和servlet-mapping使对应路径能连接到uploadeServlet;

---
####下载模块
1. 拿到文件;根据文件创建输入流;
2. 拿到response对象,设置response的Header属性使浏览器在解析结果时将内容解析问下载文件而不是直接展示在页面上;
    ```
    resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

    ```
3. 拿到repsonse对象的OutputStream对象,并使用输入输出流将文件写到reponse的输出流中.浏览器将会自动解析下载文件.

### 其他说明;
本项目使用servlet的技术,读者需要对这方面的知识有一个大致的了解,
至少要明确tomcat在启动后读取web.xml之后,是如何通过地址找到对应的Servlet.

另外,如果使用SpringMVC来搭建的web环境,Spring MVC有自己更为简单的上传下载模块,这不在本项目的讨论范围之内,就不展开叙述了,有兴趣的小伙伴可查阅相关资料,

