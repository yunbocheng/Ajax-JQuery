<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/7/26
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax根据省份id获取名称</title>

    <script>
      function search(){
        // 发起ajax请求，传递参数给服务端，服务器返回数据
        // 1.创建异步对象
        var xmlHttp = new XMLHttpRequest();
        // 2.绑定事件
        xmlHttp.onreadystatechange = function (){
          // alert(xmlHttp.readyState);
          if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
            // 输出数据 以上下代码进行的是全局刷新
            // alert(xmlHttp.responseText);
            // 以下代码操作 ajax 进行局部刷新 更新页面，就是更次dom对象 将查询的结果赋值给省份名称 改变其value值
            // 此时 xmlHttp.responseTex 只是获取了一个 返回数据 直接将这个数据赋值即可
            // 以后能会一次接收到多个数据，这时候收到的是一个json格式的字符串，此时需要将这个json字符串在JS中转化为一个json对象
            // 转换完之后 id、name、jiancheng、shenghui就是json的属性，通过属性可以就可以获取value(即 1 河北 冀 石家庄)
            document.getElementById("proname").value = xmlHttp.responseText;
          }
        }
        // 3.初始异步对象
        // 使用document对象获取id="proid"文本框的值(即用户查询的id)
        var id = document.getElementById("proid").value;
        xmlHttp.open("get","one?proid="+id,true);
        // 4.发送请求
        xmlHttp.send();
      }
    </script>
  </head>
  <body>
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
  </table>
  </body>
</html>
