<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, com.tap.model.CartItem, com.tap.model.Cart" %>
<%
    HttpSession s = request.getSession();
    Cart cart = (Cart) s.getAttribute("cart");
    Map<Integer, CartItem> items = cart != null ? cart.getItems() : null;
    double grandTotal = 0;
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
        h1, h2 {
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
            transition: background 0.3s ease;
        }
        th:hover {
            background: rgba(255, 255, 255, 0.3); /* Hover effect on header */
        }
        tr:nth-child(even) {
            background: rgba(255, 255, 255, 0.1);
        }
        tr:hover {
            background: rgba(255, 255, 255, 0.2);
            transform: scale(1.02);
            transition: transform 0.2s ease;
        }
        .actions {
            text-align: center;
            margin: 20px 0;
        }
        button {
            background: #2575FC;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s, transform 0.2s;
        }
        button:hover {
            background: #6A11CB;
            transform: translateY(-5px);
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
            transform: translateY(-5px);
        }
        .payment-method {
        text-align: center;
        margin-top: 20px;
        background: rgba(255, 255, 255, 0.1);
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        transition: transform 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
    }
    .payment-method:hover {
        transform: scale(1.05); /* Slight zoom effect */
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3); /* Enhanced shadow on hover */
    }
    .payment-method label {
        display: inline-block;
        margin: 15px auto;
        font-size: 1.2em;
        color: #fff;
        padding: 10px 20px;
        background: linear-gradient(120deg, #6A11CB, #2575FC);
        border-radius: 5px;
        transition: background 0.3s ease, transform 0.2s ease;
        cursor: pointer;
    }
    .payment-method label:hover {
        background: linear-gradient(120deg, #2575FC, #6A11CB); /* Reverse gradient on hover */
        transform: translateY(-5px); /* Hover lift effect */
    }
    .actions {
        margin-top: 30px;
    }
    .actions button {
        padding: 10px 20px;
        font-size: 1em;
        color: #fff;
        background: linear-gradient(120deg, #6A11CB, #2575FC);
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background 0.3s ease, transform 0.2s ease;
    }
    .actions button:hover {
        background: linear-gradient(120deg, #2575FC, #6A11CB); /* Reverse gradient on hover */
        transform: translateY(-5px); /* Lift effect on hover */
    }
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
    <h1>Checkout</h1>
    <table>
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Sub Total</th>
            </tr>
        </thead>
        <tbody>
            <% if (items != null && !items.isEmpty()) { 
                for (CartItem item : items.values()) { 
                    grandTotal += item.getSubTotal();
            %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td>₹<%= item.getPrice() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td>₹<%= item.getSubTotal() %></td>
                </tr>
            <%   } 
               } else { %>
                <tr>
                    <td colspan="4" style="text-align: center;">No items in cart</td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <h2>Grand Total: ₹<%= grandTotal %></h2>
    <div class="payment-method">
    <h2>Select Payment Method</h2>
    <form action="confirmPayment" method="post">
        <label>
            <input type="radio" name="paymentMethod" value="PhonePe" required> PhonePe
            <input type="radio" name="paymentMethod" value="GooglePay" required> Google Pay
            <input type="radio" name="paymentMethod" value="COD" required> Cash on Delivery
            <button type="submit">Confirm Payment</button>
        </label>
    </form>
</div>
</body>
</html>
