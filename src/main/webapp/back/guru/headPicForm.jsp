<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<form id="uploadPic" action="" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${param.id}"/>
    <div>
        <input type="text"  name="file"  class="easyui-filebox" data-options="buttonText:'选中图片',prompt:'请选择要上传图片'" maxlength="20"/>
    </div>
</form>