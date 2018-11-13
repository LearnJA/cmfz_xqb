<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#coursetabs").datagrid({
            url:'${pageContext.request.contextPath}/course/must.do',
            fitColumns:true,//自适应整个容器
            method:'get',//发送远程请求
            toolbar:'#toolCourse',//添加顶部工具栏
            loadMsg:'正在加载...',
            remoteSort:false,//服务器端排序
            autoRowHeight:true,//自适应高度
            singleSelect:true,
            rownumbers:true,//显示行号
            pagePosition:'bottom',
            fit:true,//自适应父容器
            columns:[[
                {title:'cks',field:'cks',checkbox:true,width:100},
                {title:'ID',field:'id',width:50},
                {title:'名字',field:'title',width:100},
                {title:'课时',field:'flag',width:100},
                {title:'开设时间',field:'creatTime',width:150}
            ]],
            view: detailview,
            detailFormatter: function(index, row) {
                return '<table><tr>' +
                    '<td style="border:0">' +
                    '<p>开设时间: ' + row.creatTime + '</p>' +
                    '<p>课程名: ' + row.title + '</p>' +
                    '<p>课时: ' + row.flag + '</p>' +
                    '</td>' +
                    '</tr></table>'
            }
        })
    })

    /*添加*/
    function add(){
        $("#addCourse").dialog({
            width:300,
            title:'添加必选课',
            iconCls:'icon-add',
            href:'${pageContext.request.contextPath}/back/course/addCourse.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){
                    $("#addCourseForm").form('submit',{
                        url:'${pageContext.request.contextPath}/course/addCourse.do',
                        success:function(result){
                            var resultMsg=$.parseJSON(result);
                            if(resultMsg){
                                $.messager.show({title:'提示',msg:'添加成功！！'});
                                $("#coursetabs").datagrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'添加失败！！'})
                            }
                        }
                    });
                    $("#addCourse").dialog('close');

                }
            },{
                text:'取消',
                iconCls:'icon-decline',
                handler:function(){
                    $("#addCourse").dialog('close');
                }
            }]
        })
    }
    //删除
    function del(){
        var rows=$("#coursetabs").datagrid('getSelected');
        alert(rows.id);
        if(rows.length<=0){
            $.messager.show({title:'提示',msg:'未选中要删除项！'})
        }else{
            $.messager.confirm('确认对话框', '您确定要删除选中的必选课吗？', function(r){
                if (r){
                    $.get('${pageContext.request.contextPath}/course/delCourse.do?id='+rows.id,function(result){
                        if(result){
                            $.messager.show({title:'提示',msg:'删除成功！！'});
                            $("#coursetabs").datagrid('reload');
                        }else{
                            $.messager.show({title:'提示',msg:'删除失败！！'})
                        }
                    });
                    $("#coursetabs").datagrid('reload');
                }
            });
            $("#coursetabs").datagrid('reload');
        }
    }

</script>
<div id="coursePanel" style="margin-left:5px;width:95%;height:95%;">
    <table id="coursetabs"></table>
</div>
<%--工具栏--%>
<div id="toolCourse">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:add,iconCls:'icon-add',plain:true">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:del,iconCls:'icon-cross',plain:true">删除</a>
</div>
<%--弹出窗格--%>
<div id="addCourse"></div>
