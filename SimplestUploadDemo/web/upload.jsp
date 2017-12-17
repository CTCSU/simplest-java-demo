<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/17
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传页面</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <label>上传:</label>
        <input type="file" name="file">
        <input type="submit" value="确定">
    </form>

    下载请点击:<a href="/download">下载</a>
</body>
</html>
