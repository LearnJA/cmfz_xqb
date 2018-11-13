<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<div style="margin: 20px auto;">
    <form id="addBannerForm" action="" method="post" enctype="multipart/form-data">
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
                    选择图片:
                </th>
                <td>
                    <input type="text"  name="file"  class="easyui-filebox" data-options="buttonText:'选中图片',prompt:'请选择要上传图片'" maxlength="20"/>
                </td>
            </tr><br>
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
                    <input type="text" class="easyui-textbox" data-options="required:true,prompt:'请输入图片描述',height:100" name="desct" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
