# jQuery

## 1.jQuery介绍

**JS中支持使用 $ 这个标识符**

- 引入：我们以前使用DOM对象来改变或者获取相关属性的value值，DOM对象的方法都特别的长，不容易记住，
       而且代码的观赏性较差，因此就出现了一种新的技术JQuery。
   
- jQuery:是一款跨主流浏览器的 JavaScript 库，封装了 JavaScript 相关方法调用，简化
  JavaScript 对 HTML DOM 操作
  
- jQuery是一个Java的工具类，库是存放东西的，JQuery是存放js代码的地方。

   放的是用js代码写的function() --> (函数)  

- jQuery官网介绍 ：jQuery是一个快速、小且功能丰富的JavaScript库。它使HTML文档遍历和操作、事件处理、动画和Ajax等工作变得更加简单，并提供了一个跨多种浏览器的易于使用的API。jQuery结合了多功能性和可扩展性，改变了数百万人编写JavaScript的方式。

   **write less , do more**

## 2. 为什么使用 jQuery

- 它能够兼容市面上主流的浏览器， IE 和 FireFox，Google 浏览器 处理 AJAX，创建异步对象是不同的，而 jQuery 能够使用一种方式在不同的浏览器创建 AJAX 异步对象。

## 3. jQuery的特点

（1）写少代码,做多事情【write less do more】 

（2）免费，开源且轻量级的 js 库，容量很小 

（3）兼容市面上主流浏览器，例如 IE，Firefox，Chrome 

（4）能够处理 HTML/JSP/XML、CSS、DOM、事件、实现动画效果，也能提供异步 AJAX 功能  （5）文档手册很全，很详细 

（6）成熟的插件可供选择，多种 js 组件，例如日历组件（点击按钮显示下来日期） 

（7）出错后，有一定的提示信息 

（8）不用再在 html 里面通过<script>标签插入一大堆 js 来调用命令了

>  例如：使用 JavaScript 定位 DOM 对象常用的三种方式：

> （1）通过 ID 属性：document.getElementById() 

> （2）通过 class 属性：getElementsByClassName() 

> （3）通过标签名：document.getElementsByTagName() 

上面代码可以看出 JavaScript 方法名太长了，大小写的组合太多了，编写代码效率容易出错。

**jQuery 分别使用$(“#id”) , $(“.class 名”) , $(“标签名") 封装了上面的 js 方法。**

## 4.关于jQuery的下载

- 官网地址：[jQuery](https://jquery.com/)，在官网地址点击要下载的版本，会发现是一堆代码，直接将这个网页保存即可。（Ctrl+S 直接进行保存到本地即可）

  - 官网名称：

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727162739.png" style="zoom:80%;" />

  - 本地下载完的名称

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727162706.png)

- 开发时使用的是 ：uncompressed 未压缩版

- 工作时使用的是 ：compressed （min）压缩版

- 压缩版与未压缩版的区别：

  - 压缩版压缩掉了代码原来的空白以及注释，代码紧密的凑在一起。
  - 未压缩版就是开发人员书写时的格式，不会去除空白地方和注释。

## 5. DOM对象

- DOM 对象 文档对象模型（Document Object Model，简称 DOM），是 W3C 组织推荐的处理可扩展 标志语言的标准编程接口。 通过 DOM 对 HTML 页面的解析，可以将页面元素解析为元素节点、属性节点和文本节 点，这些解析出的节点对象，即 DOM 对象。DOM 对象可以使用 JavaScript 中的方法。比如：网页中的按钮、文本、盒子等等...

## 6. JavaScript 对象和 jQuery 对象 

- 用 JavaScript 语法创建的对象叫做 JavaScript 对象, JavaScript 对象只能调用 JavaScript 对 象的 API。 用 JQuery 语法创建的对象叫做 JQuery 对象, jQuery 对象只能调用 jQuery 对象的 API。
-  jQuery 对象是一个数组。在数组中存放本次定位的 DOM 对象。 JQuery 对象与 JavaScript 对象是可以互相转化的，一般地，由于 Jquery 用起来更加方便， 我们都是将 JavaScript 对象转化成 Jquery 对象

## 7.DOM 对象和 jQuery 对象

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727173814.png)

## 8. DOM 对象与 jQuery 对象之间的转换

### 8.1  DOM 对象转换 jQuery 对象

- 使用$(DOM 对象) 方式，可以 DOM 对象转换为 jQuery 对象， 转换为 jQuery 对象才可以 使用 jQuery 中的提供的方法，操作 DOM 对象。一般情况下，在命名 jQuery 对象时，为了 与 DOM 对象进行区分，习惯性的以$ 开头，这不是必须的。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727190935.png" style="zoom:67%;" />

### 8.2 jQuery 对象转换DOM对象

- jQuery 对象本身为数组对象，该数组中的第 0 个元素即为该 jQuery 对象对应的 DOM 对象。所以有两种方式可以获取到 DOM 对象：get(0) 方式与下标[0]

 ## 9.选择器（非常重要）

- 选择器就是一个<mark>字符串</mark>，是用来定位dom对象的。定位了dom对象，就可以通过jquery的函数操作dom对象。
- 通过选择器定位获取的<mark>dom对象</mark>，此时会转变为 <mark>jQuery对象</mark>

### 9.1 基本选择器

- id选择器：通过dom对象的id定位dom对象，通过id找对象，id在当前页面中是唯一的。

  >  $("#dom对象的id值") 

- class选择器：class表示css中的样式，使用样式的名称定位dom对象。

  > $(".class样式名")

- 标签选择器：使用标签的名称定位dom对象。

  > $("标签名称")

### 9.2 所有选择器

- 所有选择器：选取页面中所有的DOM对象

  > $("*") 

### 9.3 组合选择器

- 组合选择器是多个被选中对象间使用逗号隔开后形成的选择器，可以组合 id、class、标签名等

- 可以任意组合，一个、两个、三个都可以。

  > $("#id,.class,标签名")

**jQuery基础知识总结**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727205244.png)

## 10.表单选择器

- 表单相关元素选择器是指文本框、单选框、复选框、下拉列表等元素的选择方式。该方法<mark>无论是否存在表单，均可做出相应选择。</mark>表单选择器是为了能更加容易地操作表单， 表单选择器是根据元素类型来定义的   

  **注意：无论是否存在表单，表单选择器都会根据相应的type属性值做出选择。**

  **表单选择器主要是根据 type值进行定位的**

  **只有type属性的标签才具有 表单选择器**

```javascript
<input type="text">
<input type="password">
<input type="radio">
<input type="checkbox">
<input type="button">
<input type="file">
<input type="submit">
<input type="reset">
    
$(":tr"): 不能用，tr 不是 input 标签
```

<mark>表单选择器</mark>: 使用 <input> 标签的type属性值，定位dom对象的方法。

>  语法格式 :  $(":type属性值")

```
例如：
$(":text")选取所有的单行文本框
$(":password")选取所有的密码框
$(":radio")选取所有的单选框
$(":checkbox")选取所有的多选框
$(":file")选取所有的上传按钮
$(":butten")选取所有的按钮
```

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727221628.png" style="zoom:80%;" />

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210727221651.png)

## 11.过滤器

注意 ： jQuery 对象中存储的 DOM 对象顺序与页面标签声明位置关系

**jQuery对象数组中dom对象的顺序和声明dom对象时的顺序保持一致**

```
<div>1</div> dom1
<div>2</div> dom2
<div>3</div> dom3
$("div") == [dom1,dom2,dom3]
```

- 过滤器就是过滤条件，对已经定位到数组中 DOM 对象进行过滤筛选，过滤条件不能独立 出现在 jquery 函数，如果使用只能出现在选择器后方。

- 在定位了dom对象之后，根据一些条件筛选dom对象。
- 过滤器也是一个<mark>字符串</mark>，用来筛选dom对象。
- 过滤器不能单独使用，必须和选择器一起使用。

### 11.1基本过滤器

- 选择第一个 first，保留数组中的第一个dom对象

  > 语法：$("选择器:first")

- 选择最后一个 last，保留数组中的最后一个dom对象

  > 语法：$("选择器:last")

- 选择数组中的指定对象

  > 语法：$("选择器:eq(数组索引)")

- 选择数组中小于指定索引的所有dom对象

  > 语法：$("选择器:lt(数组索引)")

- 选择数组中大于指定索引的所有dom对象

  > 语法：$("选择器:gt(数组索引)")

### 11.2 表单对象属性过滤器

**:txet 和 :checkbox 代表的是表单选择器 代表的是表单中的type属性**

- 选择可用的文本框

  > $(":text:enabled")   
  >
  > var $obj = $(":text:enabled");

- 选择不可用文本框

  > $(":text:disabled")

- 复选框选中的元素  

  > $(":checkbox:checked")
  >
  > var $obj = $(":checkbox:checked");

- 选择指定下拉列表的被选中元素

  > $("选择器 > option:selected")
  >
  > var $obj = $("#select1>option:selected");

## 12.jQuery中绑定事件

### 12.1 定义元素监听事件

> 语法：$(选择器).事件名称(事件的处理函数)

- $(选择器) ：定位dom对象，dom对象可以有很多个，这些dom对象都绑定了这个事件

- 事件名称 ： 就是js中的事件去掉on的部分，例如：js中的单击事件 onclick(),

  ​					jQuery中的事件名称，就是click，都是小写的。

- 事件处理函数 ：就是一个function，当事件发生时，执行这个函数的内容。

  例如：给id是btn的按绑定单击事件

  > $("#btn").click(function(){
  >
  > ​	alert("btn按钮单击了");
  >
  > })

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210728163940.png)

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210728164059.png)

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210728164213.png)

### 12.2  on 事件绑定

- on()  方法在被选元素上添加事件处理程序。该方法给 API 带来很多便利，推荐使用该方法

> 语法 ：$("选择器").on( "事件名称" ，事件的处理函数)
>
> 事件名称 ： 就是js事件中去掉on的部分 （js中onclick  on事件中 click）
>
> 事件的处理函数： function 定义。

例如：

```javascript
<input type="butten" id="btn">
$("#btn").on("click" , function(){ 处理按钮单击事件 })
```

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210729172341.png)

## 13.函数

### 13.1 第一组

#### 13.1.1 val函数 （常用）

- 操作数组中 DOM 对象的 【value 属性】 

> $(选择器).val() ：无参数调用形式， 读取数组中**第一个 DOM 对象**的 value 属性值 

>  $(选择器).val(值)：有参形式调用;对数组中**所有 DOM 对象**的 value 属性值进行统一赋值

#### 13.1.2 text函数

- 操作数组中所有 DOM 对象的【文字显示内容属性】

> $(选择器).text() : 无参数调用，读取数组中所有 DOM 对象的文字显示内容，将得到内容拼接 为一个**字符串*返回 。

> $(选择器).text(值) : 有参数方式，对数组中所有 DOM 对象的文字显示内容进行**统一赋值**。

#### 13.1.3 attr函数

- 对 val, text 之外的【其他属性操作】

> $(选择器).attr(“属性名”) :  获取 DOM 数组第一个对象的**属性值** 。

> $(选择器).attr(“属性名”,“值”) :  对数组中所有 DOM 对象的属性设为**新值**。

### 13.2 第二组

#### 13.2.1 hide函数

>  $(选择器).hide()  : 将jQuery对象数组中所有 DOM 对象**隐藏**起来

#### 13.2.2 show函数

> $(选择器).show() : 将jQuery对象数组中所有 DOM 对象**在浏览器中显示起来**

#### 13.2.3 remove函数

>  $(选择器).remove() : 将jQuery对象数组中所有 **DOM 对象及其子对象**一并删除

#### 13.2.4 empty函数

>  $(选择器).empty() ：将jQuery对象数组中所有 **DOM 对象的子对象**删除，不删除本身这个dom对象

#### 13.2.5 append函数（常用）

- 为数组中所有 DOM 对象添加子对象

> $(选择器).append("<div>我动态添加的 div</div>")  可以增加任意的页面元素 

#### 13.2.6 html函数

- 设置或返回被选元素的内容（相当于JS中innerHTML）。
- 注意：以下设置的内容是书写代码时标签中的在网页显示文本内容，而不是设置网页上显示的内容。
- 注意：在代码中的写的<b></b>等标签不会在页面中显示，而是会在页面中执行，但是获取的文本内容中含有这个<b></b>

> $(选择器).html()：无参数调用方法，获取 DOM 数组第一个dom对象的在网页上显示的文本内容。

> $(选择器).html(值)：有参数调用，用于设置 DOM 数组中所有元素的在网页上显示的文本内容。

#### 13.2.7 each函数（常用）

- each 是对数组、json对象 和 dom 对象等的遍历,对每个元素调用一次函数。

- JQuery提供了 each() 方法用于遍历匹配的元素信

- element: 数组的对象 ：

  > 这个是自定义的数组中的元素的标识符，这个元素可以是<mark>普通元素(直接获取)</mark>、<mark>json对象的value(直接获取)</mark>、
  >
  > <mark>dom对象的value(使用dom.value获取)</mark>，

- index: 数组的下标  ： 这个下标自定义，且会自动增长，知道与数组中的元素个数一致的时候，停止增长，例如：数组中元素有5个，则这个i为 0~4，当执行完4的时候，会停止调用each()函数。)
- 重点：可以将普通数组对象、dom对象转换为 jQuery对象来使用 each()的语法二进行遍历。
  			但是 json对象不可以转变为 jQuery对象，只能使用语法一遍历，不可以使用语法二。

> var arr = new Array("数字天堂",true,3.14,10,'A');
>
> 语法 1：$.each( 要遍历的对象, function(index,element) { 处理程序 } )

> 语法 2：jQuery 对象.each( function( index, element ) { 处理程序 } )

- 遍历数组写法 ：

>  语法1 ： $.each(arr,function(i,arrobj){alert("数组的下标为：" + i + "," + "成员是：" + arrobj)});
>
> 语法2 ：$(arr).each(function(i,arrobj){alert("数组的下标为：" + i + "," + "成员是：" + arrobj)});
>
> arr : 要遍历的对象   $(arr) : 是由普通数组对象(arr)转换为的jQuery对象 	i：数组的下标     arrobj : 自定义的数组中元素的标识符。

- 遍历json写法：

> var arr = {name:"zhangsan",age:20};
>
> 语法1 ：$.each(arr,function(i,arrobj){alert("json的key是：" + i + "," + "json的value是：" + arrobj)});
>
> 语法2 ：不建议使用，会报错。

- 遍历dom对象写法：

> 遍历 text 这个dom对象
>
> ```
> <input type="text" value="张飞" /><br/>
> <input type="text" value="刘备" /><br/>
> <input type="text" value="关羽" /><br/>
> ```
>
> 语法1 ：$.each($(":text"),function(i,arrobj){alert("下标是："+ i + "," + "dom的value值是 ：" + arrobj.value)});
>
> 语法2 ： $(":text").each(function(i,arrobj){alert("下标是："+ i + "," + "dom的value值是 ：" + arrobj.value)});

## 14.按钮的区别 （补充）

```html
		<input type="button" value="我是一个按钮"/><br/>
		<input type="button" />我是一个按钮<br/>
		<button type="button">我是一个按钮</button><br/>
		<button >我是一个按钮</button>
```

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210729165314408.png)



## 15. 使用jQuery函数，实现Ajax请求。 

### 15.1 关于jQuery函数使用Ajax请求的介绍。

- jQuery 提供多个与 AJAX 有关的方法。通过 jQuery AJAX 方法，您能够使用 HTTP Get  和 HTTP Post 从远程服务器上请求文本、HTML、XML 或 JSON 同时能够把接收的数据更新 到 DOM 对象。

- 使用jQuery的函数，实现Ajax的请求。
- 没有jQuery之前，使用XMLHttpRequest做Ajax，有四个步骤，很麻烦。jQuery简化了ajax请求的处理。使用三个函数就可以实现ajax的请求处理。
- 处理ajax请求的三个函数：
  - $.ajax()  :  jQuery中实现ajax的核心参数。
  - $.post()  :  使用post方式发送ajax请求。
  - $.get()  :  使用get方式发送ajax请求。

**在$.get() 与$.post()  他们在内部都是调用的 $.ajax() **

### 15.2 $.ajax() 函数 （实现Ajax请求的核心函数）

- $.ajax() 是 jQuery 中 AJAX 请求的核心方法，所有的其他方法都是在内部使用此方法。

- > 语法： $.ajax( { name:value, name:value, ... } )
  >
  > 注意 ：这个name可以不加双引号，但是value值要根据请求参数的类型加或者不加双引号

- 说明：参数是 json 的数据，包含请求方式、数据、回调方法等

**下边介绍的是 $.ajax() 函数中参数**

- async ： 布尔值，表示请求是否异步处理。默认是 true  （可以不写async这个配置项 ）

    			 （这个相当于 XMLHttp.open(get,url,true)，中的第三个参数。

  > 语法格式 : $.ajax( { async : true} );
  >
  > 注意 ：此时请求参数 async 是一个布尔类型，对应的value不用加双引号。

- contentType ：一个字符串，表示从浏览器发送到服务器的请求参数的类型。可以不写。

  ​						   默认是： "application/x-www-form-urlencoded"。

  ​						   例如：表示请求的参数是json格式的，可以写 application/json

  > 语法格式：$.ajax( {async : true ，contentType ："application/json"} );
  >
  > 注意 ： 此时的请求参数 contentType 是一个字符串类型，对应的value值要加双引号 

- data：规定要发送到服务器的数据，可以是：string、数组、多数是 json；

  > 语法格式 ：$.ajax({ data : {name : "lisi" ,  age :  20} });
  >
  > 注意 ：此时发送的数据是 json。

- dataType：表示<mark>期望</mark>从服务端返回的数据格式。当我们使用 $.ajax() 发送请求时，会把 

  ​					dataType的值发送给服务端。那么我们的 Servler 能够读取到这个 dataType

  ​					的值，就知道我们此时浏览器需要的是 json 或者是 xml 格式的数据，那么服务器					就可以返回你需要的数据格式。我们主要用的是 json的值。

  **jQuery 从 xml, json, text,, html 这些中测试最可能的类型。**

  ```javascript
  "xml"  - 一个 XML 文档
  "html" - HTML 作为纯文本
  "text" - 纯文本字符串
  "json" - 以 JSON 运行响应，并以对象返回
  ```

  > 语法格式：$.ajax({ data : {name : "lisi" ,  age :  20} ，dataType : "json"});
  >
  > 注意 ： 此时的请求参数 dataType 是一个字符串类型，对应的value值要加双引号 

- error ： 一个function函数，表示请求发生错误时，执行的函数。

  > 定义方式 ： error:function() { 发生错误时执行 }; 

  > 语法格式 ： $.ajax( { async : true ，error:function(){请求发生错误时，执行的函数} });

- success : 一个function函数，代表请求成功时，从服务端返回了数据，执行的seccess指定函数

  ​				相当于之前使用 XMLHttpRequest对象，当readyState==4 && status ==200的时候				执行的函数。

  > 语法格式 ： $.ajax( { async : true ，success:function( data ){ 请求成功，执行的函数 } });
  >
  > 注意 ：这个参数 data 是服务端返回的数据，就是ajax中的 responseText，并且这个数据			是jQuery处理后的数据。

- url：规定发送请求的 URL。

  > 语法格式 ： $.ajax( { async : true , url : "bmiAjax" });  
  >
  > 注意 ： 此时的请求参数 url是一个字符串类型，对应的value值要加双引号 

- type：规定请求的类型（GET 或 POST 等），默认是 GET， get，post 不用区分大小写。

  > 语法格式 ： $.ajax( { async : true ,  type : "get" });  
  >
  > 注意 ： 此时的请求参数 type 是一个字符串类型，对应的value值要加双引号 ;

**实际开发中，主要使用：url , data , dataType , success.**

### 15.2 $.get() 函数

- $.get() 方法使用 HTTP GET 请求从服务器加载数据。

> 语法：$.get(url,data,function(resp),dataType)

- **注意：这里边的参数顺序不可以改变，一定要按照这个顺序，且不能缺省**

- **注意：这里的语法格式不同于 $.ajax({name:value,name:value..})，**

  **这里不是和他一样的json格式，这接传递value值即可。**

**语法中的参数信息：**

- url 必需。规定您需要请求的 URL。 

- data 可选。规定连同请求发送到服务器的数据。 

- success : 一个function函数，代表请求成功时，从服务端返回了数据，执行的seccess指定函数

  ​				相当于之前使用 XMLHttpRequest对象，当readyState==4 && status ==200的时候				执行的函数。

**这些参数与上边 $.ajax()  函数的参数信息是一样的**

### 15.3 $.post() 函数

- $.post() 方法使用 HTTP POST 请求从服务器加载数据。

> 语法：$.post(url,data,function(resp),dataType)

- 参数信息与 $.get() 参数信息完全相同



## 16. 使用jQuery以及Ajax实现省市级联查询

- **使用的地方：比如填写淘宝收货地址的时候，在省份来点击河北省，下一个市区栏会自动变为河北省以下的市区名，选择好市区名下一栏会出现该市区内的街道等信息**

- **我们这里使用一下 jQuery库中 $.post() 函数来发起ajax请求。
    注意：如果这这里使用的是 $.post()函数，在服务端要使用doPost方法
    给浏览器返回数据，所以此时应该将服务端的代码写入到 doPost方法体中
    如果是 $.get()写到doGet中  $.post()写到doPost中。
    $.ajax()可以写入到doGet()中。也可以写入到 doPost()中。**

- 这个项目在这个文件中。
  
- 这个例子中测试的两级查询，在实际生活中，会存在多个级别一起查询，<mark>方法一样</mark>，通过一级查询二级，通过二级查询三级，以此类推。