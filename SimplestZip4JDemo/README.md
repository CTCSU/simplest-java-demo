## 最简程序之ZIP4J压缩与解压:
### 运行说明:
本项目使用maven搭建.您可以直接使用maven引入项目;  
如果您不使用maven,请将本项目需要的jar包加入项目运行的环境中.
包括;
- JUnit4
- zip4j 1.3.2

### 项目编写步骤:
**压缩:**
 1. 得到文件或文件路径,如果是文件路径,拿到路径下所有文件
 2. 将上一步获取的文件加入到一个ArrayList<File>中去.
 3. 根据要生成的zip文件的路径创建一个ZIPFile的对象;
 4. 初始化一个zipParameters对象,默认就好;
 5. 调用zipFile的addFiles方法,即压缩完成;
 
 **解压:**
 1. 根据zip文件的路径创建ZIPFile对象;
 2. 生成一个需要解压的目录
 3. 调用zipFile的extractAll方法即可以将文件解压到目录中.
 
 ### 扩展
 windows下压缩zip文件时对文件名采用GBK编码;
 linux下压缩zip文件时则使用UTF-8编码;  
 所以如果处理的是windows下的zip文件,最好在解压和压缩时都指明压缩编码为GBK,否则可能会造成文件名乱码.
 




