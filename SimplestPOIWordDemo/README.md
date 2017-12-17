## 最简程序之POI处理word程序
### 项目运行说明:
本项目使用maven搭建.您可以直接使用maven引入项目;  
如果您不使用maven,请将本项目需要的jar包加入项目运行的环境中.
包括;
- junit 4以上版本
- xmlbeans 2.60
- poi  
- poi-ooxml
- poi-ooxml-schema
- poi-scratchpad  

poi相关的jar包本项目中使用的版本是3.17  
项目搭建好之后运行SimplestXWPFDemoTest这个测试类即可看到效果了


### 项目编写步骤:  
**将文字写入document:**
1. 拿到文件全路径,根据文件路径创建一个文件,并生成一个文件输出流;
2. 创建一个XWPFDocument,写入相应的内容
    1. 使用xwpfdocument创建一个xwpfparagraph对象,也就是段落;
    2. 使用xwpfparagraph创建一个xwpfrun对象,这个对象是段落中具有相同样式的内容;
    3. 设置xwpfRun对象的text值属性,将内容填入进去,就相当于在docx文档中写值了.
3. 调用document的write方法就可以将文件写入到输出流,也就是写到相应的文件了

----

**将文字从文档中读出来:**
1. 根据文档路径创建文档输入流;
2. 根据输入流创建document对象;
3. 调用document的getParagraph方法,得到所有的paragraph对象,这是一个list;
4. 便利paragraphList,对每一个paragraph调用其getText()方法会得到段落内的所有文字;

### 一些扩展:
office word文档目前分为两种格式,一种是2003的以".dox"结尾的文档,这个文档是使用二进制保存内容和样式;
另一种则是2007版以后的以".docx"后缀结尾的文档,这中文档是使用xml来定义文档中的内容和样式;


本项目中使用的POI中的XWPF系列的技术,只能解析以".docx"类型的文档;而另一种".doc"结尾的文档,可以使用HWPF系列的几乎
去解析,这个也是POI中的技术.但是由于二进制文件本来解析起来就比xml解析起来要困难,而且负责HWPF的主程小哥于2005年就已经
离开了apche基金会,导致HWPF只能说的一个半成品,功能上可能没有XWPF强大(当然本人也没有正式研究过HWPF技术,都是从别处扒来的八卦,不过
poi官方网站上确实证实了在2005年以后,项目的主程已经不在项目组工作),所以本人项目中一直都使用XWPF来处理文档.
至于".doc"文档,可以使用POI转换doc到docx的方法去转化,然后再解析就好了......有点慢,但是也能用不是.

另外处理word文档的也有doc4j这样的技术,使用起来也不错,有兴趣的读者可以自行研究,本项目就不展开叙述了.
