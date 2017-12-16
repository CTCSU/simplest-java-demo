## 最简POI处理Excel的程序
### 介绍POI
Apache的POI技术是apache基金会下的一个专门用来处理office文档的开源项目,能够解析和创建word、excel和power point；
在word处理领域，也有一些能和POI相抗衡的项目，例如doc4j、java2word，原因是POI的word项目确实不是很好用。
但是在excel处理上，poi是绝对意义上的主流。

### 项目说明
本项目采用Maven构建而成；所以要运行本项目，直接使用maven导入就行了。
如果您还未开始maven，那么请注意将项目所需的jar包引入项目中，本项目所需要jar包为：
- junit-4；  
- poi;
- poi-ooxml;
- poi--ooxml-schemas;
- xmlbeans

运行入口为 POIDemoTest中的测试方法：testPOIDemo(); 

### POI项目编写步骤:
**创建excel文档**
1. 加入jar包
2. 创建工作簿对象:Workbook
3. 在工作簿对象中创建一个sheet页对象:Sheet
4. 在Sheet对象中创建一个行对象:Row
5. 在行对象中创建一个单元格对象:Cell
6. 在单元格对象中写入对应的值;
7. 调用工作簿对象的write方法将文档写到某输出流;  

本文档中:
```$xslt
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
```



**读取excel文档**
1. 获取输入流
2. 根据输入流打开excel文件,得到工作簿对象
3. 根据工作簿对象得到行对象;
4. 根据行对象获取单元格对象;
5. 根据单元格对象获取单元格中内容.
本项目中:
```
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
```

### 最后的话
excel文件分为两个版本,一种是以".xls"结尾的97-2003的excel文档;而另一种则是以".xlsx"结尾的2007的excel文档.
".xls"的excel文档使用二进制存储内容和格式,而".xlsx"则是用xml的形式存储;所以它们解析起来是不一样的.
在POI中".xls"文档需要用HSSWokdBook来读取,而".xlsx"则使用XSSWWorkbook来读取,但是它们都实现了Workbook接口,
所以在声明变量的时候尽量用接口去声明,具体适配的时候,传入需要的workbook对象就好了.这就是java多态的优势了.








