<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#userNontabs").datagrid({
            url:'${pageContext.request.contextPath}/user/findAllUser.do?status=0',
            fitColumns:true,//自适应整个容器
            method:'get',//发送远程请求
            loadMsg:'正在加载...',
            remoteSort:false,//服务器端排序
            autoRowHeight:true,//自适应高度
            singleSelect:true,
            rownumbers:true,//显示行号
            pagePosition:'bottom',
            fit:true,//自适应父容器
            pageNumber:1,//初始页面
            pageSize:6,//每页数据条数
            pageList:[6,8,10,12],//定义每页显示条数下拉选项
            columns:[[
                {title:'cks',field:'cks',checkbox:true,width:100},
                {title:'ID',field:'id',width:50},
                {title:'名字',field:'username',width:100},
                {title:'电话',field:'phone',width:50},
                {title:'密码',field:'password',width:100},
                {title:'省份',field:'province',width:100},
                {title:'城市',field:'city',width:100},
                {title:'法名',field:'nickName',width:100},
                {title:'性别',field:'sex',width:100},
                {title:'头像',field:'headPic',width:100},
                {title:'注册日期',field:'date',width:100},
                {title:'状态',field:'status',width:100},
                {title:'修改状态',field:'options',width:100,
                    formatter:function(value,row,index){
                        return "<a class='options' onclick=\"updt('"+row.id+"')\" data-options=\"iconCls:'icon-edit'\">修改状态</a>";
                    }
                }
            ]],
            view: detailview,
            detailFormatter: function(index, row) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + row.headPic + '" style="height:100px;"></td>' +
                    '<td style="border:0">' +
                    '<p>法名: ' + row.nickName + '</p>' +
                    '<p>地址: ' + row.province+'.'+row.city+ '</p>' +
                    '<p>签名: ' + row.sign + '</p>' +
                    '</td>' +
                    '</tr></table>'
            },
            onLoadSuccess:function(){
                $(".options").linkbutton({height:20,plain:true})
            },
        })
    })

    /*修改*/
    function updt(id){
        $.get("${pageContext.request.contextPath}/user/updtStatus.do?id="+id,function (result) {
            var resultMsg=$.parseJSON(result);
            if(resultMsg){
                $.messager.show({title:'提示',msg:'添加成功！！'});
                $("#userNontabs").datagrid('reload');
            }else{
                $.messager.show({title:'提示',msg:'添加失败！！'})
            };
            $("#userNontabs").datagrid('reload');
        })
        $("#userNontabs").datagrid('reload');
        $("#usertabs").datagrid('reload');
    }
</script>
<div id="coursePanel" style="margin-left:5px;width:95%;height:95%;">
    <table id="userNontabs"></table>
</div>
