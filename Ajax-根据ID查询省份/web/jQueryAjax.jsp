
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery实现Ajax请求</title>
</head>
<body>

<script src="jQuery/jquery-3.6.0.js" type="text/javascript"></script>
<script>
    /*使用jQuery实现ajax请求，先等待页面全部元素加载完毕*/
    $(function (){
        /*通过id选择器定位dom对新(btn)，获取jQuery对象*/
        $("#btn").click(function (){
            // 获取用户输入dom对象的value值
            // 使用id选择器定dom对象，获取jQuery对象
            // 调用 jQuery库的 val()函数 获取该属性的value值。
            // 此时获取的是数据库中的某一个或者某一组数据，
            // 需要向服务端表明访问的此时需要访问的具体请求参数
            // 如果是访问数据库中全部的信息，就不用获取这个请求参数，
            // 并且在 $.ajax() 函数中不用表明 data 参数信息。
            var proid = $("#proid").val();
            // 发起 ajax请求，使用ajax()函数实现ajax请求
            $.ajax({
                /*注意：url是一个String类型的数据，要加双引号或者单引号*/
                /*这个里边省略了好多的参数信息，比如请求方式 type 默认是get，此时就省略不写了 */
                /*String类型在js代码中也可以使用单引号括起来*/
                url : 'two',
                data : {
                    /*json格式下的key双引号可加可不加 */
                    "proid" : proid
                },
                dataType : "json",
                /*以下这个参数表示请求成功后要执行的函数*/
                success:function (resp){
                    /*resp是服务端返回的数据*/
                    /* resp这个数据就相当于ajax中最后的那个返回responseText
                    * 并且这个 resp是经过 jQuery加工的。
                    * 使用id选择器定位需要改变的dom对象，获取他们的jQuery对象
                    * 使用jQuery库中的 val("值")，改变其中的value值。
                    * */
                    $("#proname").val(resp.name);
                    $("#projiancheng").val(resp.jiancheng);
                    $("#proshenghui").val(resp.shenghui);
                }
            })
        });
    })
</script>
<p align="center" style="color: red;">JQuery实现ajax请求</p>
<table border="2px" align="center">
    <tr>
        <td>省份id：</td>
        <td><input type="text" id="proid"></td>
        <td><input type="button" value="查询" id="btn"></td>
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
