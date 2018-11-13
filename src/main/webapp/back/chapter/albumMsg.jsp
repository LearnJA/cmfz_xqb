<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#albumMsgForm").form('load','${pageContext.request.contextPath}/album/findOne.do?id='+${param.id});
    })
</script>
<div style="margin:30px auto;text-align: center;">
    <form id="albumMsgForm" action="" method="post" enctype="multipart/form-data">
        <input type="hidden" name="album_id" value="${param.id}"/>
        <%--<div>
            <img src="${pageContext.request.contextPath}/+"{faceImg} style="width:100px;heigth:50px;"/>
        </div>--%>
        <div>
           专辑标题： <input type="text"  name="title"  class="easyui-textbox" data-options="readonly:true" maxlength="20"/>
        </div>
        <div>
            发布日期：<input type="text"  name="publishDate"  class="easyui-datebox" data-options="prompt:'请选择要上传音频'" maxlength="20"/>
        </div>
        <div>
            章节数量：<input type="text"  name="count"  class="easyui-textbox" data-options="readonly:true" maxlength="20"/>
        </div>
        <div>
            封面路径：<input type="text"  name="faceImg"  class="easyui-textbox" data-options="readonly:true" maxlength="20"/>
        </div>
    </form>
</div>