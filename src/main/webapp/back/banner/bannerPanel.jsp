<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#bannertabs").datagrid({
            url:'${pageContext.request.contextPath}/banner/findBanners.do?status=1',
            fitColumns:true,//自适应整个容器
            method:'get',//发送远程请求
            toolbar:'#toolbanner',//添加顶部工具栏
            loadMsg:'正在加载...',
            remoteSort:false,//服务器端排序
            autoRowHeight:true,//自适应高度
            pagination:true,//定义显示分页栏
            rownumbers:true,//显示行号
            pagePosition:'bottom',
            fit:true,//自适应父容器
            pageNumber:1,//初始页面
            pageSize:4,//每页数据条数
            pageList:[4,6,8,10],//定义每页显示条数下拉选项
            columns:[[
                {title:'cks',field:'cks',checkbox:true,width:100},
                {title:'ID',field:'id',width:50},
                {title:'名字',field:'title',width:100},
                {title:'路径',field:'imgPath',width:100},
                {title:'描述',field:'desct',width:100},
                {title:'上传日期',field:'date',width:100},
                {title:'轮播图',field:'pic',width:150,
                    formatter:function (value,row,index) {
                        return "<img style='width:80px;height:55px;' src='${pageContext.request.contextPath}/"+row.imgPath+"'>";
                    }},
                {title:'修改操作',field:'options',width:100,
                    formatter:function(value,row,index){
                        return "<a class='options' onclick=\"updt('"+row.id+"')\" data-options=\"iconCls:'icon-edit'\">修改</a>";
                    }
                }
            ]],
            view: detailview,
            detailFormatter: function(index, row) {
                return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + row.imgPath + '" style="height:100px;"></td>' +
                '<td style="border:0">' +
                '<p>更新日期: ' + row.date + '</p>' +
                '<p>标题: ' + row.title + '</p>' +
                '<p>描述: ' + row.desct + '</p>' +
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
        $("#addBanner").dialog({
            width:300,
            title:'添加轮播图',
            iconCls:'icon-add',
            href:'${pageContext.request.contextPath}/back/form/addBanner.jsp',
            buttons:[{
                text:'保存',
                iconCls:'icon-accept',
                handler:function(){
                    $("#addBannerForm").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/add.do',
                        success:function(result){
                            var resultMsg=$.parseJSON(result);
                            if(resultMsg){
                                $.messager.show({title:'提示',msg:'添加成功！！'});
                                $("#bannertabs").datagrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'添加失败！！'})
                            }
                        }
                    });
                    $("#addBanner").dialog('close');

                }
            },{
                text:'取消',
                iconCls:'icon-decline',
                handler:function(){
                    $("#addBanner").dialog('close');
                }
            }]
        })
    }
    /*修改*/
    function updt(id){
        $("#updateBanner").dialog({
            width:300,
            title:'修改轮播图',
            iconCls:'icon-edit',
            href:'${pageContext.request.contextPath}/back/form/updtBanner.jsp?id='+id,//引入更新表单并传入更新id,
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
                                $("#bannertabs").datagrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'修改失败！！'})
                            }
                        }
                    });
                    $("#updateBanner").dialog('close');

                }
            },{
                text:'取消',
                iconCls:'icon-decline',
                handler:function(){
                    $("#updateBanner").dialog('close');
                }
            }]
        })
    }
    //批量删除
    function delAny(){
        var rows=$("#bannertabs").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({title:'提示',msg:'至少选中一项！'})
        }else{
            var ids=[];
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].id);
            };
            $.messager.confirm('确认对话框', '您确定要删除选中的图片吗？', function(r){
                if (r){
                    $.ajax({
                        url:'${pageContext.request.contextPath}/banner/delAny.do',
                        type:'POST',
                        traditional:true,
                        data:{ids:ids},
                        success:function(result){
                            var resultMsg=$.parseJSON(result);
                            if(resultMsg){
                                $.messager.show({title:'提示',msg:'删除成功！！'});
                                $("#bannertabs").datagrid('reload');
                            }else{
                                $.messager.show({title:'提示',msg:'删除失败！！'})
                            }
                        }
                    });
                    $("#bannertabs").datagrid('reload');
                }
            });
            $("#bannertabs").datagrid('reload');
        }
    }

</script>
<div id="bannerPanel" style="margin-left:5px;width:95%;height:95%;">
    <table id="bannertabs"></table>
</div>
<%--工具栏--%>
<div id="toolbanner">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:add,iconCls:'icon-add',plain:true">添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="onClick:delAny,iconCls:'icon-cross',plain:true">删除</a>
</div>
<%--弹出窗格--%>
<div id="addBanner"></div>
<%--修改窗格--%>
<div id="updateBanner"></div>
