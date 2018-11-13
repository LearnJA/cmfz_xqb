<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#gurutabs").edatagrid({
            url:'${pageContext.request.contextPath}/guru/findGurus.do?status=1',
            fitColumns:true,//自适应整个容器
            toolbar:'#toolguru',//添加顶部工具栏
            rownumbers:true,//显示行号
            fit:true,//自适应父容器
            singleSelect: true,
            pagination: true,
            autoSave:true,
            saveUrl:'${pageContext.request.contextPath}/guru/add.do',
            updateUrl:'${pageContext.request.contextPath}/guru/update.do',
            destroyUrl:'${pageContext.request.contextPath}/guru/del.do',
            destroyMsg:{
                norecord:{    // 在没有记录选择的时候执行
                    title:'Warning',
                    msg:'没有选中！！'
                },
                confirm:{       // 在选择一行的时候执行
                    msg:'确定要删除吗？'
                }
            },


            view: detailview,
            detailFormatter: function(index, row) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + row.headPic + '" style="height:100px;"></td>' +
                    '<td><a href="#" class="options" data-options="iconCls:\'icon-edit\'" onclick=\'uploadHead("'+row.id+'")\'>修改头像</a></td>'+
                    '<td style="border:0">' +
                    '<p>Date: ' + row.status + '</p>' +
                    '<p>Title: ' + row.name + '</p>' +
                    '<p>Path: ' + row.headPic + '</p>' +
                    '</td>' +
                    '</tr></table>'
            },
            onLoadSuccess:function(){
                $(".options").linkbutton({height:20,plain:true})
            }
        })
    })
    /*添加*/
    function add(){
        $("#gurutabs").edatagrid('addRow',0);
        //$("#gurutabs").edatagrid('reload');
    }

    /*删除*/
    function del(){
        $("#gurutabs").edatagrid('destroyRow');
       // $("#gurutabs").edatagrid('reload');
    }
    /*上传头像*/
    function uploadHead(id){
        $("#headPic").dialog({
            height:100,
            width:300,
            title:'上传头像',
            iconCls:'icon-upload',
            href:'${pageContext.request.contextPath}/back/guru/headPicForm.jsp?id='+id,
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){
                    $("#uploadPic").form('submit',{
                        url:'${pageContext.request.contextPath}/guru/uploadHead.do',
                        success:function(result){
                            var resultMsg=$.parseJSON(result);
                            if(resultMsg){
                                $.messager.show({title:'提示',msg:'添加成功！！'});
                                $("#gurutabs").edatagrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'添加失败！！'})
                            }
                        }
                    });
                    $("#gurutabs").edatagrid('reload');
                    $("#headPic").dialog('close');
                }
            },{
                text:'取消',
                iconCls:'icon-decline',
                handler:function(){
                    $("#headPic").dialog('close');
                }
            }]
        })
    }
</script>
<div id="guruPanel" style="margin-left:5px;width:95%;height:95%;">
    <table id="gurutabs" style="width:600px;height:200px" title="上师列表" singleSelect="true">
        <thead>
        <tr>
            <th field="check" checkbox="true" width="50"></th>
            <th field="id" width="50" editor="text">注册编号</th>
            <th field="name" width="100" editor="{type:'validatebox',options:{required:true}}">上师姓名</th>
            <th field="headPic" width="100" align="left" editor="{type:'textbox',options:{precision:1}}">头像</th>
            <th field="status" width="50" editor="{type:'validatebox',options:{required:true,prompt:'1:为在线上师,0:为冻结上师'}}">状态</th>
        </tr>
        </thead>
    </table>
</div>
<%--工具栏--%>
<div id="toolguru">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:add,iconCls:'icon-add',plain:true">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:del,iconCls:'icon-cross',plain:true">删除</a>
</div>
<%--头像上传--%>
<div id="headPic" style="margin: 50px auto;text-align: center;"></div>
