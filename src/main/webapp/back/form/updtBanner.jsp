<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#updtBannerForm").form('load','${pageContext.request.contextPath}/banner/findOne.do?id='+${param.id});
    })
</script>
<div style="margin: 20px auto;">
    <form id="updtBannerForm" action="" method="post" enctype="multipart/form-data">
        <input type="hidden" value="${param.id}" name="id">
        <table>
            <tbody>
            <tr>
                <th>
                    图片标题:
                </th>
                <td>
                    <input type="text" class="easyui-textbox" data-options="prompt:'请输入主题图片标题'," name="title" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            <tr>
                <th>
                    图片状态:
                </th>
                <td>
                    <input type="text" class="easyui-textbox" data-options="prompt:'0:不显示；1:显示'," name="status" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            <tr>
                <th>
                    图片描述:
                </th>
                <td>
                    <input type="text" class="easyui-textbox" data-options="height:100" name="desct" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
