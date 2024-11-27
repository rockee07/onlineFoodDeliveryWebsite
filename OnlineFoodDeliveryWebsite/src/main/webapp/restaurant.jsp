<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.tap.dao.RestaurantDAO, com.tap.model.Restaurant, com.tap.daoimpl.RestaurantDAOImpl" %>
<%
    RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
    List<Restaurant> restaurants = restaurantDAO.fetchAllRes();
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
        background: rgba(255, 255, 255, 0.1);
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        animation: fadeIn 1s ease-in-out;
    }
    h1 {
        text-align: center;
        margin-bottom: 30px;
        animation: fadeIn 1s ease-in-out;
    }
    .restaurant-list {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        margin-top: 20px;
    }
    .restaurant-card {
        background: rgba(255, 255, 255, 0.1);
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        width: calc(50% - 20px); /* Two cards per row */
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .restaurant-card:hover {
        transform: scale(1.05); /* Slight zoom on hover */
        box-shadow: 0 8px 15px rgba(0, 0, 0, 0.3); /* Enhanced shadow */
    }
    .restaurant-card img {
        width: 100%;
        height: 150px;
        object-fit: cover;
    }
    .restaurant-info {
        padding: 15px;
        text-align: center;
    }
    .restaurant-info h2 {
        margin: 10px 0;
        font-size: 1.5rem;
    }
    .restaurant-info p {
        margin: 5px 0;
        font-size: 1rem;
    }
    .actions {
        margin-top: 10px;
        display: flex;
        justify-content: center;
        gap: 10px;
    }
    .actions a {
        text-decoration: none;
        color: #fff;
        background: #2575FC;
        padding: 5px 10px;
        border-radius: 5px;
        transition: background 0.3s ease, transform 0.2s ease;
    }
    .actions a:hover {
        background: #6A11CB;
        transform: translateY(-5px); /* Action link hover effect */
    }

    /* Keyframe Animation for fade-in */
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
        <h1>Restaurant Management</h1>
        <div class="restaurant-list">
            <% if (restaurants != null && !restaurants.isEmpty()) { %>
                <% for (Restaurant restaurant : restaurants) { %>
                    <div class="restaurant-card">
                        <img src="<%= restaurant.getImgpath() %>" alt="<%= restaurant.getRestName() %>">
                        <div class="restaurant-info">
                            <h2><%= restaurant.getRestName() %></h2>
                            <p>Cuisine: <%= restaurant.getQuicineType() %></p>
                            <p>Delivery Time: <%= restaurant.getDeliveryTime() %> mins</p>
                            <p>Ratings: <%= restaurant.getRatings() %></p>
                            <div class="actions">
                             <!--    <a href="editRestaurant.jsp?restId=">Edit</a>
                                /*<a href="deleteRestaurant.jsp?restId=">Delete</a>-->
                                <a href="SelectRestaurantServlet?restId=<%= restaurant.getRestId() %>">View Menu</a>
                            </div>
                        </div>
                    </div>
                <% } %>
            <% } else { %>
                <p style="text-align: center; width: 100%;">No restaurants available</p>
            <% } %>
        </div>
    </div>
</body>
</html>

