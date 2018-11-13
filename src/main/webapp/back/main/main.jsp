<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
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
	/*菜单处理*/
    $(function(){
        $.ajax({
            url:'${pageContext.request.contextPath}/menu/findMenus.do',
            type:'POST',
            dataType:'json',
            success:function (menus) {
                //遍历一级菜单
                $.each(menus,function (index,menu) {
                    console.log(menu);
                    //遍历二级菜单  定义新的选项栏
                    var content="<div style='text-align: center'>";
                    $.each(menu.childs,function(idx,child){
                        content+="<a onclick=\"addpanle('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" " +
                            "style='width:95%;margin:10px 0px;border:1px #037D80 solid;' class='easyui-linkbutton'" +
                            " data-options=\"plain:true,iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>"
                    })
                    content+="</div>";
                    //添加菜单
                    $("#aa").accordion('add',{
                        title:menu.title,
                        iconCls:menu.iconCls,
                        content:content
                    })
                })
            },
            error:function () {
                location.href="${pageContext.request.contextPath}/login.jsp";
            }
        })
    })

    /*修改密码*/
    function updatePassword(){
        $("#updtpwd").dialog({
            width:400,
            title:'修改密码',
            iconCls:'icon-1012333',
            href:'${pageContext.request.contextPath}/back/form/updatePassword.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){
                    $("#updatePasswordForm").form('submit',{
                        url:'${pageContext.request.contextPath}/admain/updtPassword.do',
                        success:function(result){
                            var resultMsg=$.parseJSON(result);
                            if(resultMsg){
                                $.messager.show({title:'提示',msg:'更新成功！'});
                                $("#updtpwd").dialog('close');
                            }else{
                                $.messager.show({title:'提示',msg:'更新失败！'})
                            }
                        }
                    });
                }
            },{
                text:'取消',
                iconCls:'icon-cross',
                handler:function(){
                    $("#updtpwd").dialog('close');
                }
            }]
        });
    }
    /*退出登录*/
    function downLoad(){
            $.messager.confirm('确认对话框', '您想要退出该系统吗？', function(r){
            if (r){
                location.href='${pageContext.request.contextPath}/admain/downLoad.do';
            }
        });
    }
    /*菜单栏功能*/
    function addpanle(title,iconCls,href) {
        /*点击菜单按钮 打开选项卡*/
        var exists=$("#tabPanle").tabs('exists',title);
        /*判断当前点击选项卡是否已打开*/
        if(!exists){
            //否则 未打开 则打开
            $("#tabPanle").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                fit:true,
                href:'${pageContext.request.contextPath}/back/'+href
            })

        }else{
            //已经打开，则
            $("#tabPanle").tabs('select',title);
        }
    }
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.admain.name} &nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',onClick:updatePassword">修改密码</a>&nbsp;&nbsp;<a href="javascript:void(0)" id="download" class="easyui-linkbutton" data-options="iconCls:'icon-01',onClick:downLoad">退出系统</a></div>
        <div id="updtpwd" style="text-align: center"></div><div id='down'></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;">
                <%--添加选项卡--%>
                <div id="tabPanle" class="easyui-tabs" data-options="fit:true"></div>
            </div>
		</div>  
    </div>   
</body> 
</html>