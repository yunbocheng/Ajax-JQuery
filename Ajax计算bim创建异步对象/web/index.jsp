<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/7/25
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全局刷新计算bim</title>
</head>
<body>

<%--javScript可以在任意地方书写，头、身体、脚都可以--%>
<script type="text/javascript">
    // 使用内存中的异步对象，代替浏览器发起请求，异步对象使用js创建和管理
        function doAjax(){
        // 1. 创建异步对象
        var xmlHttp = new XMLHttpRequest();
        // 2. 绑定事件
        xmlHttp.onreadystatechange = function (){
            // 处理服务端返回的数据，更新当前页面
            // alert("readyState数值：" + xmlHttp.readyState + "status状态值 ：" + xmlHttp.status);
            // 如果以下条件都满足，说明此时可以获取到页面的属性值，并且可以进行更新数据。
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                // alert(xmlHttp.responseText);
                // 获取计算之后的数据，将他赋值给一个新的变量
                // 此时的这个 responseText == result
                var changeData = xmlHttp.responseText;
                // 通过id获取dom对象，更新原来dom对象的数据，
                // innerText可获取或设置指定元素标签内的文本值,将里边的文本值换为changeData数据进行最终的输出。
                // 此时只是改变 id="changeData" 这个标签里文本的内容，不改变其他地方的内容 局部刷新。
                document.getElementById('changeData').innerText = changeData;
            }
        }
        // 3.初始请求数据
        // 通过id获取dom对象的value属性值
        var name = document.getElementById("name").value;
        var weight = document.getElementById("weight").value;
        var height = document.getElementById("height").value;
        // 重点：此时需要拼接出一个URL格式的参数信息 ?name=cyb&weight=60&height=1.75 这种格式
        // true代表此时这个xmlHttp是一个异步对象
        var param = "name="+name + "&weight=" + weight +"&height="+height;
        // alert("param" + param);
        /*?name=name&weight=weight&height=height*/
        xmlHttp.open("get","one?"+param,true);
        // 4.发起请求
        // 这里存在回调函数的原理，回调 xmlHttp.onreadystatechange = function ()进行数据的更改
        xmlHttp.send();
    }

</script>
<p align="center">全局刷新计算bim</p>
        <%--没有使用form--%>
        <div align="center">
        <%--这里使用id属性，这样便于dom对象使用 document.getElementById("name").value 获取元素的value值--%>
        姓名 ：<input type="text" id="name"/><br/>
        体重（公斤）：<input type="text" id="weight"/><br/>
        身高（米）：<input type="text" id="height"/><br/>
        <div align="center">
            <%--这里使用butten不会进行提交表单，不会造成全局刷新，这样是保证局部刷新的前提--%>
            <%--点击按钮会触发 doAjax() 事件，在doAjax()事件中创建了异步对象，并且更改了页面的内容，进行了局部刷新--%>
            <input type="button" value="计算bim" onclick="doAjax()"/>
        </div>
            <br/>
            <br/>
            <%--局部刷新会改变这个数据，变为bim计算结果--%>
            <div id="changeData">计算结果中，请稍等.....</div>
</div>
</body>
</html>
