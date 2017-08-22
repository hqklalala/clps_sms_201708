<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
  <link rel="stylesheet" type="text/css"
          href=" resource/JQueryeasyUi/themes/metro-green/easyui.css"> 
         
    <link rel="stylesheet" type="text/css"
          href=" resource/JQueryeasyUi/themes/icon.css">
    
    <script type="text/javascript"
            src=" resource/JQueryeasyUi/jquery.min.js"></script>
    <script type="text/javascript"
            src=" resource/JQueryeasyUi/jquery.easyui.min.js"></script>
    <style type="text/css">
        #Mlogin{
            font-size: large; float: right;
        }
        #goodsmag a {
            width: 100%;
        }
    </style>
    <script type="text/javascript">
   		

        //       登录验证
        function loginyz() {
            var name = $("#user_name").val();
            var pwd = $("#user_password").val();
            if (name == "") {
                alert("用户名不能为空");
                return false;
            } else if (pwd == "") {
                alert("密码不能为空");
                return false;
            } else {
                $.ajax({
                    type : "post",
                    url : "MagAction",
                    async : false,
                    data : {
                        UserName : name,
                        PWD : pwd,
                    },
                    success : function(data, status) {
                        //                            判定结果
                        var types = data;
                        if (types.toString() == "登录成功") {
                            alert(data);
                            $("#win").window('close');
                            //                            更换显示用户名
                            $("#Mlogin").append("欢迎尊敬的" + name);

                        } else {
                            alert("登录失败");
                            $("#win").window('open');
                        }
                    },
                    error : function() {
                        alert("用户名密码验证失败");
                        $('#win').window('open')

                    }
                });
            }
        }

        //       打开选项卡
        function openTab(text, url) {
        	 if($("#tt").tabs('exists',text)){
                 $("#tt").tabs('exists',text);
             }else{
                 $("#tt").tabs('add',{
                     title:text,
                     closable:true,
                     content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"+url+"'></iframe>"
                 })
             }
           
        	/*  $.ajax({
                        type : "post",
                        url : "PowerAction",
                        async : false,
                        data : {
                            UserName : $("#user_name").val(),
                        },
                        success : function(data) {
                            var types = data;
                            if($("#tt").tabs('exists',text)){
                                $("#tt").tabs('exists',text);
                            }else{
                                $("#tt").tabs('add',{
                                    title:text,
                                    closable:true,
                                    content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='"+url+"'></iframe>"
                                })
                            }
                            
                        }
                    }); */

        }

    </script>
</head>

<body>


<div class="easyui-layout" style="width: 100%; height: 622px;">
    <%--上--%>
   <%--  <div data-options="region:'north'"
         style="height: 40px; background-color: #E0ECFF">

        用户名
        <table style="float:right";  align="bottom">
            <tr>
                <td id="Mlogin" >用户名</td>
                <td>用户名</td>
                <td>用户名</td>
                <td>用户名</td>
            </tr>
        </table>
    </div> --%>
     <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
     ihuhi
     </div>   
    

    

    <%--左--%>
    <div data-options="region:'west',split:true" title="功能列表"
         style="width: 200px;">

        <div id="aa" class="easyui-accordion" style="width:193px;height:99.6%;">

            <div title="系统管理" >
                <ul style="style-list:none">
                    <li>
                    
                      <a href="javascript:openTab('人事管理','showper.jsp')">人事管理</a>
                        <ul>
                            <li><a href="#">添加用户</a></li>
                            <li><a href="#">删除用户</a></li>
                            <li><a href="#">修改用户</a></li>
                            <li><a href="#">查询用户</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">菜单管理</a>
                        <ul>
                            <li><a href="#">添加菜单</a></li>
                            <li><a href="#">删除菜单</a></li>
                            <li><a href="#">查询菜单</a></li>
                            <li><a href="#">修改菜单</a></li>
                            <li><a href="#">添加权限</a></li>
                            <li><a href="#">修改权限</a></li>
                            <li><a href="#">删除权限</a></li>
                            <li><a href="#">查询权限</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">角色权限管理</a>
                        <ul>
                            <li><a href="#">添加角色</a></li>
                            <li><a href="#">删除角色</a></li>
                            <li><a href="#">修改角色</a></li>
                            <li><a href="#">查询角色</a></li>
                           
                        </ul>
                    </li>


                </ul>
            </div>
            <div title="会议管理" >
                content2
            </div>
            <div title="菜单管理">
                content3
            </div>
        </div>
    </div>

    <%--中间--%>
    <div id="zhong"
         data-options="region:'center',title:'',iconCls:'icon-ok'"
         onload="opener.location.reload()">

        <div id="tt" onclick="fresh()" class="easyui-tabs"
             data-options="closable:true" style="width: 100%; height: 100%;">
            <%--首页--%>
            <div title="首页" id="goodslist"
                 style="overflow: auto; padding: 20px;">
                 <!-- 首页图片 -->
                <%--<img src="${pageContext.request.contextPath}/source/img/backshouye.jpg" style="width: 100%;height: 100%"/>--%>
               
            </div>

    </div>
</div>
 <%--下--%>
    <div data-options="region:'south',split:true"
         style="height: 50px; background-color: #E0ECFF;" align="center">
        <div align="center" style="margin-top: 15px">2017-7-17Right
            &copy;3组啦啦啦</div>
    </div>

</body>
</html>

