<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<!doctype html>
<html lang="userLogin">
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.etree.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
    <div>
        <h1 style="text-align: center">用户注册</h1>
        <div style="width:300px;margin: 20px auto;text-align: center;">
            <form id="userRegist" action="${pageContext.request.contextPath}/user/regist.do" method="post" enctype="multipart/form-data">
                <table>
                    <tbody>
                    <tr>
                        <th>
                            用户名:
                        </th>
                        <td>
                            <input type="text" class="easyui-textbox" data-options="prompt:'请输入用户昵称'," name="username" maxlength="20" autocomplete="off"/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            用户头像:
                        </th>
                        <td>
                            <input type="text"  name="file"  class="easyui-filebox" data-options="buttonText:'选中图片',prompt:'请选择要上传图片'" maxlength="20"/>
                        </td>
                    </tr><br>
                    <tr>
                        <th>
                            用户手机:
                        </th>
                        <td>
                            <input type="text" class="easyui-textbox" data-options="prompt:'请输入手机号'," name="phone" maxlength="20" autocomplete="off"/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            用户密码:
                        </th>
                        <td>
                            <input type="password" class="easyui-passwordbox" data-options="required:true,showEye:true,height:100" name="password" maxlength="20" autocomplete="off"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <input type="submit" class="easyui-linkbutton" data-options="required:true,showEye:true,height:30,width:60,textButton:'登录'"/>
            </form>
        </div>
    </div>
</body>
</html>