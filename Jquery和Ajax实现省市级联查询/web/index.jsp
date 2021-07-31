<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>使用jQuery以及Ajax实现省市级联查询</title>
    <%--以下代码是设置标签的css样式--%>
    <style type="text/css">
    p {
      color: red;
      background-color: greenyellow;
    }
  </style>
  <%--以下代码是发送ajax局部刷新的请求--%>
  <%--首选引入 jQuery库，因为要使用ajax与jQuery实现省市级联查询的--%>
  <script type="text/javascript" src="jQuery/jquery-3.6.0.js"></script>
  <%--接下来书写 ajax 局部刷新请求，使用jQuery实现--%>
  <script type="text/javascript">

    /*这个$.ajax()请求在按钮单击事件以及页面自动刷新的时候都会用到，会调用好几次ajax请求，此时将这个请求封装到一个函数中*/
    function loadDataAjax(){
      /* 通过id选择器定位dom对象(province)，获取jQuery对象，
        使用 $.ajax() 函数实现ajax请求*/
      /* 获取用户想要查询的信息 */
      // var province = $("#province").val();
      /*重点 ：在这个项目中，因为获取的是所有数据，而不是某一个具体的数据，
      * 所以此时不需要使用以下代码进行获取用户输入的对于某一特定数据的请求
      * var proid = $("#proid").val();
      * 此时在 $.ajax()函数中不用指明 data 参数信息。
      * */
      // 发起ajax请求 ，使用jQuery库中的 ajax()函数实现ajax请求
      $.ajax({
        url : "one",
        dataType : "json",
        /*以下代表请求成功时，需要执行的函数，此时这个函数中的参数resp
        * 就等于 服务端响应回来的 json ,这个resp是自定义的，可以是任意的
        * 此时（resp==json）
        * */
        success : function ( resp ){
          /**
           * 此时已经获取到了这个json格式数据，此时想要获取json的数据,
           * [{id: 1, name: "河北", jiancheng: "冀", shenghui: "石家庄市"},…]
           * 这个json格式的数据此时是一个集合，需要使用循环遍历这个集合，
           * 此时可以使用 jQuery库中的 each()函数，这个时候是一个dom对象，而不是json对象，要使用循环dom对象的 each()函数语法格式。
           * 语法1 ：$.each($(":text"),function(i,arrobj){alert("下标是："+ i + "," + "dom的value值是 ：" + arrobj.value)});
           */
          /**
           * 此时已经将数据库中的数据获取到，此时应该将这些数据插入到 下拉列表中。
           * 也就是向id="province"的这个列表中添加子对象，也就是option标签
           * 添加子dom对象，使用jQuery库中的 append() 函数。
           */
          /**
           * 注意 ：此时这里会存在一个问题，jQuery库中的append函数的作用是像dom对象中添加子dom对象。
           *      每次触发一次按钮事件，就会像这个dom对象中添加子dom对象，这样如果用户多次点击按钮，
           *      多次触发这个按钮事件，就会像这个dom对象中添加多个子对象，这样会造成下拉列表中数据的重复。
           *      为了解决这个问题：此时需要用户触发一次单击事件之前需要进行刷新，删除掉以前的这些子dom对象。
           *      然后在增加新的子dom对象，这样可以使显示在网页上的数据不会累计，而是每次展示的内容都一样。
           */
          // 删除旧的数据，把已经存在的数据清空。
          $("#province").empty();
          $.each(resp , function (i,arrobj){
            // 使用id选择器获取select这个dom对象。
            // 使用 jQuery库中的 append()函数添加 select这个dom对象的子dom对象(option)
            // 这个时候取出数组中的id属性值的value赋值给子dom对象(option)的value
            // 使用 id作为option的value值是因为在city表中有一个外键，
            // 绑定的是这个 province表的id属性。为了接下来的级联查询使用。
            // 取出这个json个数数组中的name属性的value值赋值给子dom对象(option)的文本内容。
            // 取出这个json个数数组中的name属性的value值赋值给子dom对象(option)的文本内容。
            // 将这个name在下拉列表中展示给用户，便于用户进行选择省份。
            // 注意 ：arrobj此时是一个 dom对象，要使用 dom.属性名 来获取该属性名对应的value值。
            $("#province").append("<option value= '" + arrobj.id + "'+ >" + arrobj.name + "</option>");
          })
        }
      })
    }
    /* 首先确保页面中的所有元素加载完毕，设置一个入口函数 */
    $(function(){
      // $(function())在页面的dom对象加载成功后执行的函数，自动发起一个ajax请求
      // 这个请求的作用是自动来获取省份的信息
      /*
        关于这个ajax请求的解释：
         在实际的开发应用中，我们填写地址的时候一般不用点击按钮来获取省份的下拉列表
         而是直接显示在页面上的。在页面刷新完毕之后，此时应该自动发起ajax请求，
         将省份的信息获取到，放置在省份的下拉列表 select中。此时应该自动调用
         显示省份的ajax请求。也就是下边的 $.ajax() 这个ajax请求。
      * */
      // 这个时候页面加载完毕，需要自动刷新关于省份的下拉列表信息，调用 loadDataAjax 函数刷新
      loadDataAjax();
      /* 通过id选择器定位dom对象(btnload)，获取到这个dom对象的 jQuery对象 */
      /* 给获取到的jQuery对象绑定单击事件 */
      $("#btnload").click(function (){
        // 此时要刷新省份信息，调用一次请求省份函数 loadDataAjax
        loadDataAjax();
      });
      // 给省份的select绑定一个change事件，当select内容发生变化时，触发事件。
      // 绑定这个事件的原因 通过获取省份的select中下拉列表的内容来获取该省份中
      // 包含有哪些市区，在第二个 select 列表中显示。
      // 重点：怎么知道选中河北之后会显示关于河北包含的市区信息的？
      /* 在创建市区表的时候我们创建了一个外键，这个外键绑定的就是这个省份对应的id
      * 这样子的话，我们可以通过选定省份的id值来定位到 外键绑定该省份id的市区名称。
      * 这样子就可以实现当用户在第一个下拉列表中选择的省份发生变化时，触发change事件
      * 此时会改变省份的id值，id值发生改变，对应的第二个下拉列表会变为外键为这个id的值
      * 例如：河北的id=1 如果点击河北 此时就会获取到 市区表中外键值为 1 的所有市区名*/
      $("#province").change(function (){
        // 使用 表单对象属性过滤器 ，获取选中列表框的值
        var $obj =  $("#province>option:selected");
        // 获取被选中下拉列表框的value值
        // （注意：这个value值上一步我们给select列表添加子dom对象时手动添加的）
       var provinceId = $obj.val(); // 此时的这个结果就是：省份的id值 1、2、3...
        // 我们这里使用一下 jQuery库中 $.post () 函数来发起ajax请求。
        // 注意：如果这这里使用的是 $.post()函数，在服务端要使用doPost方法
        // 给浏览器返回数据，所以此时应该将服务端的代码写入到 doPost方法体中
        // 如果是 $.get()写到doGet中  $.post()写到doPost中。
        // $.ajax()可以写入到doGet()中。也可以写入到 doPost()中。
        // 做一个ajax请求，获取省份的所有城市信息，这个ajax请求是带有省份id参数的
        // 服务端此时根据这个省份id来查询这个省份对应的城市信息并将其返回给浏览器
        // $.post()语法：语法：$.post(url,data,function(resp),dataType)
        // 以上参数中 data 是一个json格式的数据
        $.post("two",{proid : provinceId},callBack,"json");
      })
    })

    /* 在使用jQuery库中的 $.post()函数的时候，里边的function(resp)参数会显示的很乱 *
    此时可以将这个函数额外的封装起来，用的时候直接调用，可以提高代码的观赏性 */
    /* 此时这个函数中的 resp 就是服务端响应的数据 */
    function callBack(resp){
        // 此时需要后去城市下拉列表中的数据。方式和获取第一个下拉列表中的方式一样，参考上边的
        // 清空城市的select列表
        $("#city").empty();
        $.each(resp , function (i,arrobj){
          $("#city").append("<option value='"+ arrobj.id +"'>"+ arrobj.name +"</option>");
        })
    }
  </script>

</head>
<body>
    <p align="center">使用jQuery与Ajax省市级联查询</p>
    <div>
      <table align="center" border="1px" cellpadding="0">
        <tr>
          <td>
            省份:
          </td>
          <td>
            <select id="province">
              <option value="0">请选择...</option>
            </select>
          </td>
          <td>
            <div align="center">
              <input type="button" value="load数据" id="btnload"/>
            </div>
          </td>
        </tr>
        <tr>
          <td>城市：</td>
          <td>
            <select id="city">
              <option value="0">请选择...</option>
            </select>
          </td>
        </tr>
      </table>
    </div>
</body>
</html>
