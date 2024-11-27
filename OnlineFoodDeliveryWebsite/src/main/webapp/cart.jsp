<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.tap.model.CartItem, com.tap.model.Cart" %>
<%
    HttpSession s = request.getSession();
    Cart cart = (Cart) s.getAttribute("cart");
    Map<Integer, CartItem> items = cart != null ? cart.getItems() : null;
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
    h1 {
        text-align: center;
        margin: 20px 0;
        animation: fadeIn 1s ease-in-out;
    }
    table {
        width: 90%;
        margin: 20px auto;
        border-collapse: collapse;
        background: rgba(255, 255, 255, 0.1);
        border-radius: 10px;
        overflow: hidden;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
    }
    th, td {
        text-align: center;
        padding: 10px;
        border: 1px solid rgba(255, 255, 255, 0.2);
    }
    th {
        background: rgba(255, 255, 255, 0.2);
        color: #fff;
        transition: background 0.3s ease;
    }
    th:hover {
        background: rgba(255, 255, 255, 0.3); /* Hover effect on header */
    }
    tr:nth-child(even) {
        background: rgba(255, 255, 255, 0.1);
    }
    tr:hover {
        background: rgba(255, 255, 255, 0.2); /* Hover effect on rows */
        transform: scale(1.02);
        transition: transform 0.2s ease;
    }
    .actions form {
        display: inline;
    }
    button {
        background: #2575FC;
        color: #fff;
        border: none;
        padding: 5px 10px;
        border-radius: 5px;
        cursor: pointer;
        transition: background 0.3s, transform 0.2s;
    }
    button:hover {
        background: #6A11CB;
        transform: translateY(-5px); /* Button hover effect */
    }
    a {
        display: block;
        width: fit-content;
        margin: 20px auto;
        text-decoration: none;
        background: #2575FC;
        color: #fff;
        padding: 10px 20px;
        border-radius: 5px;
        text-align: center;
        transition: background 0.3s, transform 0.2s;
    }
    a:hover {
        background: #6A11CB;
        transform: translateY(-5px); /* Link hover effect */
    }

    /* Keyframe Animation for heading */
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
    <h1>Shopping Cart</h1>
    <table>
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Sub Total</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% if (items != null && !items.isEmpty()) { 
                for (CartItem item : items.values()) { %>
                    <tr>
                        <td><%= item.getName() %></td>
                        <td>₹<%= item.getPrice() %></td>
                        <td><%= item.getQuantity() %></td>
                        <td>₹<%= item.getSubTotal() %></td>
                        <td class="actions">
                            <form action="cart" method="post">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                                <button type="submit">Update</button>
                            </form>
                            <form action="cart" method="post">
                                <input type="hidden" name="action" value="remove">
                                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                                <button type="submit">Remove</button>
                            </form>
                        </td>
                    </tr>
            <%   } 
               } else { %>
                <tr>
                    <td colspan="5" style="text-align: center;">No items in cart</td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <a href="restaurant.jsp">Continue Shopping</a>
    <a href="checkout.jsp">Proceed to Checkout</a>
</body>
</html>

