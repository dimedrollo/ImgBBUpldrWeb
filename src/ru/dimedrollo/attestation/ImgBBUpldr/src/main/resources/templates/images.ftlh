<#import "spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Uploaded pictures</title>
</head>
<body>
<table>
<tr>
    <th>ID</th>
    <th>Picture</th>
    <th>URL</th>
    <th>Expiration date</th>
</tr>
<#list images as image>
    <tr>
        <td>${image.getId()}</td>
        <td><img alt="My image" src="${image.getBase64()}" /></td>
        <td>${image.getMUrl()}</td>
        <td>${image.getMTimer()}</td>
    </tr>
</#list>
</table>
</body>
</html>