<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<div style="margin: 20px auto;">
    <form id="addCourseForm" action="" method="post">
        <table>
            <tbody>
            <tr>
                <th>
                    功课标题:
                </th>
                <td>
                    <input type="text" class="easyui-textbox" data-options="prompt:'请输入功课标题'," name="title" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            <tr>
                <th>
                    功课课时:
                </th>
                <td>
                    <input type="text" class="easyui-textbox" data-options="prompt:'输入功课课时'," name="flag" maxlength="20" autocomplete="off"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
