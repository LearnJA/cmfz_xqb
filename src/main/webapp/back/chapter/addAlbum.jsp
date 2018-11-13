<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<div style="margin:30px auto;text-align: center;">
    <form id="addAlbumForm" action="" method="post" enctype="multipart/form-data">
        <div>
            <input type="text"  name="title"  class="easyui-textbox" data-options="prompt:'请输入专辑主题'" maxlength="20"/>
        </div><br>
        <div>
            <input type="text"  name="file"  class="easyui-filebox" data-options="buttonText:'选中图片',prompt:'请选择要上传的封面'" maxlength="20"/>
        </div>
    </form>
</div>
