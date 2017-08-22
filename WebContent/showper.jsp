<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href=" resource/JQueryeasyUi/themes/ui-pepper-grinder/easyui.css">
    <link rel="stylesheet" type="text/css" href=" resource/JQueryeasyUi/themes/icon.css">

    <script type="text/javascript" src=" resource/JQueryeasyUi/jquery.min.js"></script>
    <script type="text/javascript" src=" resource/JQueryeasyUi/jquery.easyui.min.js"></script>
    <style type="text/css">
        #addsubmit{background:#E0ECFF;width:100px;border-radius:5px;}

    </style>
    <script type="text/javascript">


        //      添加用户
        function adduser() {
            var name=$("#user_name").val();
            $("#winadd").window('open');
            $("#addsubmit").click(function () {
                var ret = window.confirm("确认提交？");
                //当点击确定时 返回 true
                if(ret){
                    //do something 点确定
                    var sex = $('#gender input[name="mans"]:checked ').val();
                    $.ajax({
                        type:"post",
                        url:"BInsertAction",
                        async: false,
                        data: {
                            admin_name: $("#username").val(),
                            Sex: sex,
                            Email:$("#email").val(),
                            Phone:$("#phone").val(),
                            Type:$("#usertype").val(),
                            Password:$("#userpassword").val(),
                        },
                        success:function (data) {
                            var types=data;
                            if(types.toString()!="添加成功"){
                                alert(data);
                                $("#winadd").window('open');
                            }else{
//                                window.location.href="/backgroup.jsp";
                                alert(data);
                                //要刷新的div

//                                $("#winadd").window('close');
                                $('#dg').datagrid('reload');    // 重新载入当前页面数据
                            }
                        }
                    });
                }else{
                    //do otherthing 点取消
                    $("#winadd").window('open');
                }

            });
        };

        //       查询用户
        function usersearch() {
            $("#winserach").window('open');

            $("#usersearch").click(function () {
                if($("#searchname").val()!="") {
                    $.ajax({
                        type: "post",
                        url: "BSeleAdminAction",
                        async: false,
                        data: {
                            Name: $("#searchname").val()
                        },
                        success:function(data){
                            if(data.toString()=="查询失败"){
                                alert("您所查找用户不存在！！！");
                                $("#winserach").window('open');
                            }else{
                                data=JSON.parse(data);
                                $("#showmag").append(
                                        "<table border='1'  border-collapse= 'collapse'  width='94%'  bordercolor='#ccc' ellspacing='0.5' cellspacing='0' style='margin-top: 20px' >"
                                        +"<tr><td>用户ID:</td><td>"+data.admin_id +"</td></tr>"
                                        +"<tr><td>用户名:</td><td>"+data.admin_name+"</td></tr>"
                                        +"<tr><td>等级:</td><td>" + data.admin_type+"</td></tr>"
                                        +"<tr><td>性别:</td><td>"+data.admin_sex+"</td></tr>"
                                        +"<tr><td>邮箱:</td><td>"+data.admin_email+"</td></tr>"
                                        + "<tr><td>电话:</td><td>"+data.admin_phone+"</td></tr>"
                                        +"</table>"
                                )
                            }
                        },
//                        查看错误
//                        error:function(xhr){alert(xhr.responseText)}
                    });

                };

            });
        }
        //       修改用户(完成连接)
        function usermod() {

            $("#winmodify").window('open');
            $("#newsubmit").click(function () {
                if($("#newpassword").val()=="" && $("#newusername").val()=="" && $("#newemail").val()==""&& $("#newphone").val()==""){
                    alert("请注意你的动作！");
                }else{
                    var ret = window.confirm("确定修改？");
                    if(ret){
                        $.ajax({
                            type: "post",
                            url: "BUpdateAction",
                            async: false,
                            data: {

                                admin_pwd:$("#newpassword").val() ,
                                admin_name:$("#newusername").val(),
                                admin_email:$("#newemail").val(),
                                admin_phone:$("#newphone").val(),
                            },
                            success: function (data,status) {
                                //                            判定结果
                                var types = data;
                                if (types.toString() == "修改成功") {
                                    alert(data);
                                    $("#winmodify").window('close');

                                    $('#dg').datagrid('reload');    // 重新载入当前页面数据


                                } else{
                                    alert("修改失败");
                                    $("#winmodify").window('open');
                                }
                            },
                        });
                    }else{
                        $("#winmodify").window('open');
                    }
                }
            });


        }
        //       删除用户
        function userremove() {
            $("#winremove").window('open');
            $("#removeuser").click(function () {
                $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                    if (r){
                        var ret = window.confirm("您确认要删除？");
                        if(ret){
                            var username=$("#cutusername").val;
                            if(username!=""){
                                $.ajax({
                                    type: "post",
                                    url: "BDeleAction",
                                    async: false,
                                    data: {
                                        UserName: $("#cutusername").val(),
                                    },
                                    success: function (data) {
//                            判定结果
                                        var types = data;
                                        if (types.toString() == "删除成功") {
                                            alert(data);
                                            $("#winremove").window('close');
                                            // 重新载入当前页面数据
                                            $('#dg').datagrid('reload');
                                        } else{
                                            alert("删除失败,请仔细检查用户名！！！");
                                            $("#winremove").window('open');
                                        }
                                    },
                                });
                            }else {
                                alert("请注意你的姿势哦！！！");
                            }
                        }else{
                            $("#winremove").window('open');
                        }
                    }

                });
            });
            $("#userclear").click(function () {
                $("#winremove").window('close');
            });
        }




        $(function () {
            $('#dg').datagrid({
                url:'BSeleAllAdminAction',
                pagination:true,
                pageList:[30,60,90],
                pageSize:30,
                width:'100%',
                height:'741%',
                columns:[[
                    {field:'acc_id',title:'账户ID',width:'9%',align:'center'},
                    {field:'acc_name',title:'账户名称',width:'9%',align:'center'},
                    {field:'acc_email',title:'账户邮箱',width:'9%',align:'center'},
                    {field:'acc_mobile',title:'账户电话',width:'9%',align:'center'},
                    {field:'acc_dec',title:'账户描述',width:'9%',align:'center'},
                    {field:'acc_status',title:'账户状态',width:'9%',align:'center'},
                    {field:'acc_created_datatime',title:'创建时间',width:'9%',align:'center'},
                    {field:'acc_created_name',title:'创建人',width:'9%',align:'center'},
                    {field:'acc_updated_datatime',title:'修改时间',width:'9%',align:'center'},
                    {field:'acc_updated_name',title:'修改人',width:'9%',align:'center'},
                    {field:'acc_role_id',title:'账户角色',width:'9%',align:'center'},
                ]],
                rownumbers:true,   //是否显示行号
                nowrap: false,
                striped: true,  //奇偶行是否使用不同的颜色
                method:'get',   //表格数据获取方式,请求地址是上面定义的url
                sortName: 'ID',  //按照ID列的值排序
                sortOrder: 'desc',  //使用倒序排序
                idField: 'id',
                loadMsg:'数据正在努力加载，请稍后...',   //加载数据时显示提示信息
                frozenColumns: [[  //固定在表格左侧的栏
                    {field: 'ck'},
                ]],
                toolbar: [{
                    text: '删除',
                    iconCls: 'icon-remove',
                    handler: function() {
//                    得到复选框选中的数组对象
                        var row=$("#dg").datagrid('getSelections');

                        var i = 0;
                        var string = "";
                        for(i;i<row.length;i++){
                            string += row[i].admin_id;
                            if(i < row.length-1){
                                string += ',';
                            }else{
                                break;
                            }
                        }
//                        判断选中的复选框是否为空
                        if(row.length==0){
                            alert("请选择您要删除的行！！！");
                        }
//                        若数组不为空则执行线面语句并返回结果值
                        if(row.length>0){
                            $.messager.confirm('确认','确认删除吗？？？',function (r) {
//                               值为true或flase，  默认值为true
                                if(r){
                                    $.post('RecycleAction',{admin_id:string},function (result) {
                                        if(result!=1){
                                            $('#dg').datagrid('clearSelections');
                                            $("#dg").datagrid("reload");

                                        }else{
                                            alert("删除失败");
                                        }

                                    })
                                }
                            })
                        };
                    }

                }]
            });
        });

    </script>
</head>
<body >
<%--弹出用户添加信息框--%>
<div id="winadd" align="center" style="display: none" class="easyui-window" title="添加信息" style=" width:500px;height:300px;" data-options="iconCls:'icon-save',modal:true,closed:true, maximizable:false,minimizable:false,collapsible:false">
    <div id="addmaglogin" align="center" style="margin-left: auto;margin-top: 50px;width: 500px;height: 300px">
        <table>
            <tr>
                <td>账户名称：</td>
                <td><input type="text" name="acc_name" id="acc_name" /></td>
            </tr>
            <tr>
                <td>账户密码：</td>
                <td><input type="password" name="acc_password" id="acc_password" value="123456" /></td>
            </tr>
            <tr>
                <td>账户邮箱：</td>
                <td><input type="email" name="acc_email" id="acc_email" /></td>
            </tr>
            <tr>
                <td>账户电话：</td>
                <td><input type="text" name="acc_mobile" id="acc_mobile" /></td>
            </tr>
            <tr>
                <td>账户描述：</td>
                <td><input type="text" name="acc_dec" id="acc_dec" /></td>
            </tr>
            <tr>
                <td>创建日期：</td>
                <td><input type="email" name="acc_created_datatime" id="acc_created_datatime" /></td>
            </tr>
            <tr>
                <td>创建人名：</td>
                <td><input type="email" name="acc_created_name" id="acc_created_name" /></td>
            </tr>
            <tr>
                <td>账户状态：</td>
                <td><input type="email" name="acc_status" id="acc_status" /></td>
            </tr>
            <tr>
                <td>账户角色：</td>
                <td><input type="email" name="acc_role_id" id="acc_role_id" /></td>
            </tr>
            <tr>

                <td colspan="2" align="center">
                    <input type="submit" name="addsubmit" id="addsubmit"/>
                </td>
            </tr>
        </table>

    </div>
</div>
<%--用户搜索--%>
<div id="winserach" align="center" style="display: none" class="easyui-window" title="搜索信息" style=" width:500px;height:300px;" data-options="iconCls:'icon-save',modal:true,closed:true, maximizable:false,minimizable:false,collapsible:false">
    <div id="sarchmaglogin" align="center" style="margin-left: auto;margin-top: 50px;width: 500px;height: 300px">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="searchname" id="searchname"/></td>
                <td colspan="2" align="center">
                    <input type="submit" name="usersearch" id="usersearch" value="搜索" />
                </td>
            </tr>
        </table>
        <div id="showmag"></div>
    </div>
</div>
<%--用户修改信息--%>
<div id="winmodify" align="center" style="display: none" class="easyui-window" title="修改信息" style=" width:500px;height:300px;" data-options="iconCls:'icon-save',modal:true,closed:true, maximizable:false,minimizable:false,collapsible:false">
    <div id="modfiymaglogin" align="center" style="margin-left: auto;margin-top: 50px;width: 500px;height: 300px">
        <table>
            <tr>
                <td>账户ID：</td>
                <td><input type="text" name="newusername" id="newusername" /></td>
            </tr>
            <tr>
                <td> 账户密码：</td>
                <td><input type="password" name="newphone" id="newphone"></td>
            </tr>
            <tr>
                <td> 再次确认账户密码：</td>
                <td><input type="password" name="newphone" id="newphone"></td>
            </tr>
            <tr>
                <td>账户名称：</td>
                <td><input type="password" name="newpassword" id="newpassword"/></td>
            </tr>
            <tr>
                <td> 账户邮箱：</td>
                <td><input type="email" name="newemail" id="newemail"></td>
            </tr>
            <tr>
                <td> 账户电话：</td>
                <td><input type="text" name="newphone" id="newphone"></td>
            </tr>

            <tr>
                <td> 账户电话：</td>
                <td><input type="text" name="newphone" id="newphone"></td>
            </tr>
            <tr>
                <td> 账户电话：</td>
                <td><input type="text" name="newphone" id="newphone"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" name="newsubmit" id="newsubmit"/></td>
            </tr>
        </table>

    </div>
</div>
<%--删除用回收站户信息（放入）--%>
<div id="winremove" align="center" style="display: none" class="easyui-window" title="搜索信息" style=" width:500px;height:300px;" data-options="iconCls:'icon-save',modal:true,closed:true, maximizable:false,minimizable:false,collapsible:false">
    <div id="removemaglogin" align="center" style="margin-left: auto;margin-top: 50px;width: 500px;height: 300px">
        <table>
            <tr>
                <td>账户名称：</td>
                <td><input type="text" name="cutusername" id="cutusername"/></td>
            </tr>


            <tr>
                <td align="center">
                    <input type="submit" name="removeuser" id="removeuser" value="删除" />
                </td>
                <td colspan="2" align="center">
                    <input type="button" name="userclear" id="userclear" value="取消" />
                </td>
            </tr>

        </table>

    </div>
</div>

<div title="人事管理" id="userlist" onclick="myrefresh"  data-options="closable:false">
    <a id="search" onclick="usersearch()" href="#" class="easyui-linkbutton" style="background :#FFFFFF; border: none" data-options="iconCls:'icon-search'">查询</a>
    <a id="useradd" onclick="adduser()" href="#" class="easyui-linkbutton" style="background :#FFFFFF; border: none" data-options="iconCls:'icon-add'">添加</a>
    <a id="userremove" onclick="userremove()" href="#" class="easyui-linkbutton" style="background :#FFFFFF; border: none" data-options="iconCls:'icon-cut'">删除</a>
    <a id="modify" onclick="usermod()" href="#" class="easyui-linkbutton" style="background :#FFFFFF; border: none" data-options="iconCls:'icon-edit'">修改</a>
    <%--<a id="findall" onclick="findall()" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看所有</a>--%>
   	<div>
   		<form action="" method="post">
   			<table algin="middle">
                <tr >
                    <td><label>账户名称:</label><input type="text" name="accountName"></td>
                    <td><label>账户角色:</label><input type="text" name="accountRole"></td>
                    <td><label>账户电话:</label><input type="text" name="accountModeil"></td>
                    <td><label>账户邮箱:</label><input type="text" name="accountEmail"></td>
                </tr>
                <tr>
                     <td colspan="2"><label>创建时间:</label><input type="date" name="createdate1">-----<input type="date" name="createdate2"></td>
                     <td colspan="2"><label>修改时间:</label><input type="date" name="updatedate1">-----<input type="date" name="updatedate2"></td>
                </tr>
                 <tr >
                    <td colspan="4" ><input type="submit" style="background:#FFFFFF" value="查询"></td>
                </tr>
            </table>
   		</form>
   	</div>
    <div  >
        <table id="dg" >

        </table>
    </div>
</div>
</body>
</html>