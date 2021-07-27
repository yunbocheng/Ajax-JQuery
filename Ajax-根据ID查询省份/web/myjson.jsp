
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用json格式的数据实现查询多个数据</title>
</head>
<body>

<script>
    function search(){
        // 发起ajax请求，向服务端传递参数信息，服务端返回数据
        // 1.获取异步对象
        var xmlHttp = new XMLHttpRequest();
        // 2.绑定事件
        xmlHttp.onreadystatechange = function (){
            // alert("配置成功");
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                // 此时服务端返回的数据不是一个，而是好多个数据，此时不能直接赋值，需要先将数据存放在一个数组中
                // 此时的 data是一个数组
                var data = xmlHttp.responseText;
                // 更新 dom 对象，此时通过responseText来更改省份id、省份名称、省份简称、省会名称的value值
                // 以后能会一次接收到多个数据，这时候收到的是一个json格式的字符串，此时需要将这个json字符串在JS中转化为一个json对象
                // 转换完之后 id、name、jiancheng、shenghui就是json的属性，通过属性可以就可以获取value(即 1 河北 冀 石家庄)
                // 创建一个 json对象 eval是执行括号中的代码，把json字符串转化为json对象
                // 这个方法了解就可以，后期会使用 JQuery 代替
                var jsonobj = eval("(" + data + ")");
                // 调用处理服务器返回数据的函数，更新dom对象，完成局部刷新。
                dataProcessing(jsonobj);
            }
        }
        // 3.初始化异步对象
        // 使用 dom获取用户请求的参数信息
        var proid = document.getElementById("proid").value;
        xmlHttp.open("get","two?proid="+ proid,true);
        // 发起请求
        xmlHttp.send();

        // 定义一个函数，处理服务器返回的数据，更新dom对象，完成局部刷新
        function dataProcessing(json){
            // 更新dom对象，局部刷新页面 此时通过josn对象的属性获取其value
            // 此时的属性就是 id、name、jiancheng、shenghui 通过这些来获取value
            document.getElementById("proname").value = json.name;
            document.getElementById("projiancheng").value = json.jiancheng;
            document.getElementById("proshenghui").value = json.shenghui;
        }
    }
</script>
<p align="center" style="color: red;">ajax请求使用json格式的数据</p>
<table border="2px" align="center">
    <tr>
        <td>省份id：</td>
        <td><input type="text" id="proid"></td>
        <td><input type="button" value="查询" onclick="search()"></td>
    </tr>
    <tr>
        <td>省份名称：</td>
        <td><input type="text" id="proname"></td>
    </tr>
    <tr>
        <td>省份简称：</td>
        <td><input type="text" id="projiancheng"></td>
    </tr>
    <tr>
        <td>省会名称：</td>
        <td><input type="text" id="proshenghui"></td>
    </tr>
</table>
</body>
</html>
