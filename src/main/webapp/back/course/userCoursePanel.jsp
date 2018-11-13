<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<script>
    $(function(){
        $("#usercoursetabs").datagrid({
            url:'${pageContext.request.contextPath}/course/allUserCourse.do',
            fitColumns:true,//自适应整个容器
            method:'get',//发送远程请求
            loadMsg:'正在加载...',
            remoteSort:false,//服务器端排序
            autoRowHeight:true,//自适应高度
            singleSelect:true,
            pagination:true,//定义显示分页栏
            rownumbers:true,//显示行号
            pagePosition:'bottom',
            fit:true,//自适应父容器
            pageNumber:1,//初始页面
            pageSize:6,//每页数据条数
            pageList:[6,8,10,12],//定义每页显示条数下拉选项
            fit:true,//自适应父容器
            columns:[[
                {title:'cks',field:'cks',checkbox:true,width:100},
                {title:'ID',field:'id',width:50},
                {title:'名字',field:'title',width:100},
                {title:'课时',field:'flag',width:100},
                {title:'用户ID',field:'user_id',width:100},
                {title:'开设时间',field:'creatTime',width:150}
            ]],
            view: detailview,
            detailFormatter: function(index, row) {
                return '<table><tr>' +
                    '<td style="border:0">' +
                    '<p>开设时间: ' + row.creatTime + '</p>' +
                    '<p>课程名: ' + row.title + '</p>' +
                    '<p>课时: ' + row.flag + '</p>' +
                    '<p>用户ID: ' + row.user_id + '</p>' +
                    '</td>' +
                    '</tr></table>'
            }
        })
    })

</script>
<div id="userCoursePanel" style="margin-left:5px;width:95%;height:95%;">
    <table id="usercoursetabs"></table>
</div>
