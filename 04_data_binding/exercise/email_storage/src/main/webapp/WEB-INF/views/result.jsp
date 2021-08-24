<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h3>Language: ${settingEmail.language}</h3>
<h3>Page size: ${settingEmail.pageSize}</h3>
<h3>Spams filter: ${settingEmail.enableSpamFilter}</h3>
<h3>Signature: ${settingEmail.signature}</h3>
</body>
</html>
