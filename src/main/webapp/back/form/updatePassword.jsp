<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        //验证密码是否一致
        $.extend($.fn.validatebox.defaults.rules, {
            /*必须和某个字段相等*/
            equalTo: { validator: function (value, param) { return $(param[0]).val() == value; }, message: '密码不一致！！' }
        });
    })
</script>
<div style="margin: 20px 70px;">
    <form id="updatePasswordForm" action="" method="post" >
        <table>
            <tbody>
            <tr>
                <th>
                    原始密码:
                </th>
                <td>
                    <input id="oldpassword" name="oldpassword" validType="length[6,18]" class="easyui-validatebox" required="true" type="password" value=""/>
                </td>
            </tr><br>
            <tr>
                <th>
                    修改密码:
                </th>
                <td>
                    <input id="password" name="password" validType="length[6,18]" class="easyui-validatebox" required="true" type="password" value=""/>
                    <%--<input id="newpwd" name="password" type="password" class="easyui-passwordbox" data-options="required:true" maxlength="18"/>--%>
                </td>
            </tr>
            <tr>
                <th>
                    确认密码:
                </th>
                <td>
                    <%--<input type="text" id="okpwd" class="easyui-passwordbox" data-options="showEye:true,validType:['password','length:[6,20]'],prompt:'请输入6~18位新密码'" name="password" maxlength="20" autocomplete="off"/>--%>
                        <%--<input id="okpwd" name="okpwd" type="password" class="easyui-passwordbox" required="required" validType="equals['#newpwd']" />--%>
                        <input type="password" name="repassword" id="repassword" required="true" class="easyui-validatebox"  validType="equalTo['#password']" invalidMessage="两次输入密码不一致！！"/>
                </td>
            </tr><br>
            </tbody>
        </table>
    </form>
</div>
