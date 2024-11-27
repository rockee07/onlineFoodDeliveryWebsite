<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.tap.dao.MenuDAO, com.tap.model.Menu, com.tap.daoimpl.MenuDAOImpl" %>
<%
    // Get the restId from the request parameter
   HttpSession s = request.getSession();
    Integer restId = (Integer) s.getAttribute("restId");

    
    // Create an instance of MenuDAO and fetch the menu items for the given restId
    MenuDAO menuDAO = new MenuDAOImpl();
    List<Menu> menuItems = menuDAO.fetchMenuById(restId);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TAP's PARADISE</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(120deg, #6A11CB, #2575FC);
        color: #fff;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 1000px;
        margin: 20px auto;
        padding: 20px;
        background: rgba(255, 255, 255, 0.1); /* Semi-transparent background */
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
    }
    h1 {
        text-align: center;
        margin-bottom: 30px;
        animation: fadeIn 1s ease-in-out;
    }
    .menu-items {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
    }
    .menu-item-card {
        background: rgba(255, 255, 255, 0.1);
        border-radius: 10px;
        width: 200px;
        padding: 10px;
        text-align: center;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .menu-item-card:hover {
        transform: scale(1.05); /* Zoom effect on hover */
        box-shadow: 0 6px 10px rgba(0, 0, 0, 0.3);
    }
    .menu-item-card img {
        width: 100%;
        height: 150px;
        object-fit: cover;
        border-radius: 10px;
        transition: transform 0.3s ease;
    }
    .menu-item-card img:hover {
        transform: scale(1.1); /* Slight zoom effect on image */
    }
    .menu-item-card h3 {
        margin-top: 10px;
        font-size: 1.2rem;
        transition: color 0.3s ease;
    }
    .menu-item-card p {
        margin-top: 5px;
        font-size: 1rem;
    }
    .menu-item-card span {
        color: #FFD700;
        font-weight: bold;
    }
    .add-to-cart {
        display: block;
        margin-top: 10px;
        padding: 5px 10px;
        background: #2575FC;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
        transition: background 0.3s, transform 0.2s;
    }
    .add-to-cart:hover {
        background: #6A11CB;
        transform: translateY(-5px); /* Slight lift effect */
    }

    /* Keyframe Animation */
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }
</style>
    
</head>
<body>
    <div class="container">
        <h1>Menu</h1>
        <div class="menu-items">
            <% if (menuItems != null && !menuItems.isEmpty()) { %>
                <% for (Menu menuItem : menuItems) { %>
                    <div class="menu-item-card">
                        <img src="<%= menuItem.getImgPath() %>" alt="<%= menuItem.getMenuName() %>">
                        <h3><%= menuItem.getMenuName() %></h3>
                        <p><%= menuItem.getDescription() %></p>
                        <span>Price : 
                        <%= menuItem.getPrice() %></span>
                        <form action="cart" method="post">
    						<input type="hidden" name="action" value="add">
    						<input type="hidden" name="itemId" value="<%= menuItem.getMenuId() %>">
    						<input type="number" name="quantity" value="1" min="1" required>
    						<button type="submit" class="add-to-cart">Add to Cart</button>
</form>
                        
                    </div>
                <% } %>
            <% } else { %>
                <p style="text-align: center;">No menu items available</p>
            <% } %>
        </div>
    </div>
</body>
</html>

