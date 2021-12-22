<#import "spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Posting pictures anonimously</title>
</head>
<body>
<h1>Choose a picture (accept only .jpg and .png files )</h1>
<form enctype="multipart/form-data" method="post" action="/addimg">
    <p>
        <input type="file" name="file" accept="image/png,image/jpeg" required>
        <input type="number" name="timer" title="enter an expiration time" placeholder="Expiration time by minutes">
        <input type="submit" value="Отправить"></p>
</form>
<table>
    <h2>Uploaded pictures</h2>
    <tr>
        <th>ID</th>
        <th>Picture</th>
        <th>URL</th>
        <th>Expiration date</th>
    </tr>
    <#list images as image>
        <tr>
            <td>${image.getId()}</td>
            <td><img alt="My image" src="${image.getThumbnail()}"/></td>
            <td>${image.getMUrl()}</td>
            <td>${image.getMTimer()}</td>
        </tr>
    </#list>
</table>
</body>
</html>