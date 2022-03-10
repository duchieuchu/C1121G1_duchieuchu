<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      body{
        background-image: url("https://images.unsplash.com/photo-1581431886211-6b932f8367f2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bm90ZWJvb2t8ZW58MHx8MHx8&w=1000&q=80");
      }
      .form{
        width: 150px;
        height: 300px;
        margin: auto;
        padding: 20px;
        border: 2px brown;
       background-image: url("https://images.unsplash.com/photo-1581431886211-6b932f8367f2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bm90ZWJvb2t8ZW58MHx8MHx8&w=1000&q=80");
      }
      .form input {
        width: 150px;
        height: 20px;
      }
    </style>
  </head>
  <body>
  <form action="/calculator" method="post">
    <div class="form">
      <p> Product Description </p>
      <input type="text" name="product_description" placeholder="Product Description"><br>
      <p> List Price </p>
      <input type="text" name="list_price" placeholder="List Price"><br>
      <p> Discount Percent </p>
      <input type="text" name="discount_percent" placeholder="Discount Percent"><br>
      <p></p>
      <input type="submit" name="Submit">
    </div>
  </form>
  </body>
</html>
