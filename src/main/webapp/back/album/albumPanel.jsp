<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#albumtabs").datagrid({
            url:'${pageContext.request.contextPath}/album/findAll.do',
            fitColumns:true,//自适应整个容器
            toolbar:'#toolalbum',//添加顶部工具栏
            rownumbers:true,//显示行号
            fit:true,//自适应父容器
            singleSelect: true,
            columns:[[
                {title:'cks',field:'cks',checkbox:true,width:100},
                {title:'ID',field:'id',width:50},
                {title:'专辑主题',field:'title',width:100},
                {title:'章节数量',field:'count',width:100},
                {title:'上传日期',field:'publishDate',width:100},
                {title:'专辑封面',field:'faceImg',width:120},
                {title:'修改操作',field:'options',width:100,
                    formatter:function(value,row,index){
                        return "<a class='options' onclick=\"del('"+row.id+"')\" data-options=\"iconCls:'icon-cross'\">删除</a>";
                    }
                }
            ]],
            view: detailview,
            detailFormatter: function(index, row) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + row.faceImg + '" style="height:100px;"></td>' +
                    '<td><a href="#" class="options" data-options="iconCls:\'icon-edit\'" onclick=\'faceImgUp("'+row.id+'")\'>修改头像</a></td>'+
                    '<td style="border:0">' +
                    '<p>PublishDate: ' + row.publishDate + '</p>' +
                    '<p>Title: ' + row.title + '</p>' +
                    '<p>Count: ' + row.count + '</p>' +
                    '<p>FaceImg: ' + row.faceImg + '</p>' +
                    '</td>' +
                    '</tr></table>'
            },
            onLoadSuccess:function(){
                $(".options").linkbutton({height:20,plain:true})
            }
        })
    })
    /*删除专辑*/
    function del(id){
        $.messager.confirm('确认对话框', '您确定要删除该专辑吗？', function(r){
            if (r){
                $.get('${pageContext.request.contextPath}/album/delAlbum.do?id='+id,function(result){
                    if(result){
                        $.messager.show({title:'提示',msg:'删除成功！！'});
                        $("#albumtabs").datagrid('reload');
                    }else{
                        $.messager.show({title:'提示',msg:'删除失败！！'})
                    }
                });
                $("#albumtabs").datagrid('reload');
            }
        });
        $("#albumtabs").datagrid('reload');
    }

    /*修改封面图片*/
    function faceImgUp(id){
        $("#updateFace").dialog({
            width:300,
            title:'修改轮播图',
            iconCls:'icon-edit',
            href:'${pageContext.request.contextPath}/back/album/faceImgForm.jsp?id='+id,//引入更新表单并传入更新id,
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){
                    $("#updtBannerForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/updt.do',
                        success:function(result){
                            var resultMsg=$.parseJSON(result);
                            if(resultMsg){
                                $.messager.show({title:'提示',msg:'修改成功！！'});
                                $("#albumtabs").datagrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'修改失败！！'})
                            };
                            $("#albumtabs").datagrid('reload');
                        }
                    });
                    $("#albumtabs").datagrid('reload');
                    $("#updateFace").dialog('close');
                }
            },{
                text:'取消',
                iconCls:'icon-decline',
                handler:function(){
                    $("#updateFace").dialog('close');
                }
            }]
        })
    }
    /*添加*/
    function add(){
        $('#addAlbum').dialog({
            title:'添加专辑',
            width:300,
            height:200,
            iconCls:'icon-save',
            href:'${pageContext.request.contextPath}/back/chapter/addAlbum.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){
                    $("#addAlbumForm").form('submit',{
                        url:'${pageContext.request.contextPath}/album/add.do',
                        success:function (result) {
                            var resultMsg=$.parseJSON(result);
                            if(resultMsg){
                                $.messager.show({title:'提示',msg:'添加成功！！'});
                                $("#albumtabs").datagrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'添加失败！！'})
                            };
                        }
                    });
                    $("#albumtabs").datagrid('reload');
                    $("#addAlbum").dialog('close');
                },
            },{
                text:'取消',
                iconCls:'icon-decline',
                handler:function(){
                    $("#addAlbum").dialog('close');
                }
            }],
        })
        $("#albumtabs").datagrid('reload');
    }

</script>
<div id="albumPanel" style="margin-left:5px;width:95%;height:95%;">
    <table id="albumtabs" style="width:600px;height:200px" title="专辑列表" singleSelect="true"></table>
</div>
<%--工具栏--%>
<div id="toolalbum">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:add,iconCls:'icon-add',plain:true">添加</a>
</div>
<%--添加专辑--%>
<div id="addAlbum" style="margin: 50px auto;text-align: center;"></div>
<%--修改封面--%>
<div id="updateFace" style="margin: 50px auto;text-align: center;"></div>
