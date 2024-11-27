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
        max-width: 800px;
        margin: 50px auto;
        padding: 20px;
        background: rgba(255, 255, 255, 0.1); /* Semi-transparent white background */
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
    }
    .container:hover {
        transform: scale(1.03); /* Slight zoom-in effect */
        box-shadow: 0 6px 10px rgba(0, 0, 0, 0.4); /* Enhanced shadow on hover */
    }
    h1 {
        text-align: center;
        margin-bottom: 20px;
    }
    .welcome-text {
        text-align: center;
        margin-bottom: 30px;
    }
    .navigation {
        display: flex;
        justify-content: center;
        gap: 20px;
    }
    .navigation a {
        text-decoration: none;
        padding: 10px 20px;
        background: #2575FC; /* Button color */
        color: #fff;
        border-radius: 5px;
        font-weight: bold;
        transition: background 0.3s, transform 0.3s;
    }
    .navigation a:hover {
        background: #6A11CB; /* Hover effect */
        transform: translateY(-5px); /* Slight upward animation on hover */
    }
    .content {
        margin-top: 30px;
        text-align: center;
    }
    .content p {
        font-size: 1.2em;
    }
</style>
    
</head>
<body>
    <div class="container">
        <h1>Welcome to TAP's Delight!</h1>
        <div class="welcome-text">
            <p>Explore a world of flavors and have your favorite dishes delivered to your doorstep.</p>
        </div>
        <div class="navigation">
            <a href="restaurant.jsp">Restaurants</a>
            <a href="orderHistory">Order History</a>
            <a href="login.jsp">Logout</a>
        </div>
        <div class="content">
            <p>Discover exciting meals, track your orders, and enjoy hassle-free online food delivery.</p>
        </div>
    </div>
</body>
</html>
