<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<div style="margin:30px auto;text-align: center;">
    <form id="uploadChapterForm" action="" method="post" enctype="multipart/form-data">
        <input type="hidden" name="album_id" value="${param.id}"/>
        <div>
            <input type="text"  name="file"  class="easyui-filebox" data-options="buttonText:'选中音频',prompt:'请选择要上传音频'" maxlength="20"/>
        </div>
    </form>
</div>
