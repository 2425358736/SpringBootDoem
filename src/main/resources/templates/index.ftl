<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>你好，springboot</title>
</head>
<body style="height:900px">
<div class="wrap">
    ${name!""}
    <#if SysUser??>
        ${SysUser.userName!""}${SysUser.password!""}
    </#if>
    ${redis!""}
</div>
</body>
</html>