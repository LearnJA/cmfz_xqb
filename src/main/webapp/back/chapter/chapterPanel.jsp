<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $('#chaptertabs').treegrid({
            url:'${pageContext.request.contextPath}/chapter/findAll.do',
            idField : 'id',
            treeField : 'title',
            rownumbers: true,//显示行号
            toolbar:'#toolchapter',
            striped : false,
            fit : true,
            fitColumns : true,
            border : false,
            singleSelect : true,
            checkOnSelect : true,
            selectOnCheck : true,
            cascadeCheck:true,
            dataPlain : true,
            pagination: true,
            columns:[[
                {title:'cks',field:'cks',width:50,checkbox:true},
                {field:'title',title:'名字',width:100,align:'left'},
                {field:'size',title:'大小',width:100},
                {field:'duration',title:'时长',width:100},
                {field:'downPath',title:'下载路径',width:100},
                {field:'uploadDate',title:'上传日期',width:100},
                {title:'删除章节',field:'options',width:100,
                    formatter:function(value,row,index){
                        return "<a class='options' onclick=\"del('"+row.id+"')\" data-options=\"iconCls:'icon-cross'\">删除</a>";
                    }
                }
            ]],
            onLoadSuccess:function(){
                $(".options").linkbutton({height:20,plain:true})
            }
        });
    })

    /*添加专辑*/
    function addAlbum(){
        $('#addChapterAlbum').dialog({
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
                                $("#chaptertabs").treegrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'添加失败！！'})
                            };
                        }
                    });
                    $("#addChapterAlbum").dialog('close');
                },
            },{
                text:'取消',
                iconCls:'icon-decline',
                handler:function(){
                    $("#addChapterAlbum").dialog('close');
                }
            }],
        })
        $('#chaptertabs').treegrid('reload');
    }
    /*添加章节*/
    function addChapter(){
        var album=$("#chaptertabs").treegrid('getSelected');
        if(album==null){
            $.messager.show({title:'提示',msg:'未选中上传专辑！！'})
        }else{
            alert(album.id)
            // 追加若干节点到选中节点的后面
            $('#addChapter').dialog({
                title:'添加章节',
                width:300,
                height:150,
                iconCls:'icon-save',
                href:'${pageContext.request.contextPath}/back/chapter/addChapter.jsp?id='+album.id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-accept',
                    handler:function(){
                        $("#uploadChapterForm").form('submit',{
                            url:'${pageContext.request.contextPath}/chapter/add.do',
                            success:function (result) {
                                var resultMsg=$.parseJSON(result);
                                if(resultMsg){
                                    $.messager.show({title:'提示',msg:'添加成功！！'});
                                    $("#chaptertabs").treegrid('reload');
                                }else{
                                    $.messager.show({title:'提示',msg:'添加失败！！'})
                                };
                            }
                        });
                        $("#addChapter").dialog('close');
                    },
                },{
                    text:'取消',
                    iconCls:'icon-decline',
                    handler:function(){
                        $("#addChapter").dialog('close');
                    }
                }],
            })
            $('#chaptertabs').treegrid('reload');
        }
    }
    /*删除章节*/
    function del(id){
        if(isNaN(id)){
            $.messager.confirm('确认对话框', '您确定要删除该章节吗？', function(r){
                if (r){
                    $.get('${pageContext.request.contextPath}/chapter/delChapter.do?id='+id,function(result){
                        if(result){
                            $.messager.show({title:'提示',msg:'删除成功！！'});
                            $("#chaptertabs").datagrid('reload');
                        }else{
                            $.messager.show({title:'提示',msg:'删除失败！！'})
                        }
                    });
                    $("#chaptertabs").datagrid('reload');
                }
            });
            $("#chaptertabs").datagrid('reload');
        }else{
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
                    $("#chaptertabs").datagrid('reload');
                }
            });
            $("#chaptertabs").datagrid('reload');
        }
        $("#chaptertabs").datagrid('reload');
    }
    /*专辑详情*/
    function albumMsg(){
        var album=$("#chaptertabs").treegrid('getSelected');
        $("#albumMsg").dialog({
            width:300,
            height:200,
            iconCls:'icon-icon-application_view_icons',
            href:'${pageContext.request.contextPath}/back/chapter/albumMsg.jsp?id='+album.id,
        })
    }
    /*下载音频*/
    function downChapter(){
        var chapter=$("#chaptertabs").treegrid('getSelected');
        var id=chapter.id;
        if(isNaN(id)){
            location.href="${pageContext.request.contextPath}/chapter/down.do?id="+id;
        }else{
            $.messager.show({title:'提示',msg:'请选择一个章节再下载！！'})
        }
    }
</script>
<div id="albumPanel" style="margin-left:5px;width:95%;height:95%;">
    <table id="chaptertabs" style="width:600px;height:200px" title="音频章节详情"></table>
</div>
<%--工具栏--%>
<div id="toolchapter">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:albumMsg,iconCls:'icon-cdr_eject',plain:true">专辑详情</a>|
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:addAlbum,iconCls:'icon-add',plain:true">添加专辑</a>|
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:addChapter,iconCls:'icon-add',plain:true">添加章节</a>|
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:downChapter,iconCls:'icon-20130406125519344_easyicon_net_16',plain:true">下载音频</a>
</div>
<%--添加章节--%>
<div id="addChapter"></div>
<%--添加专辑--%>
<div id="addChapterAlbum"></div>
<div id="albumMsg"></div>
