<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login2" method="get">
    user：<input type="text" name="name" id="name"><br>
    password：<input type="password" name="password" id="password"><br>
    爱好：
    <input type="checkbox" name="hobbys" value="妹子">妹子
    <input type="checkbox" name="hobbys" value="涩涩">涩涩
    <input type="submit" value="submit">
</form>
</body>
</html>