<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TAP's PARADISE</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(120deg, #4A90E2, #9013FE);
        color: #fff;
        margin: 0;
        padding: 0;
        animation: fadeIn 1s ease-in-out;
    }
    .container {
        text-align: center;
        padding: 50px;
        animation: fadeIn 1s ease-in-out;
    }
    h1 {
        font-size: 2.5em;
        margin-bottom: 10px;
        animation: fadeIn 1s ease-in-out;
    }
    p {
        margin-bottom: 20px;
    }

    a {
        text-decoration: none;
        color: #fff;
        background: #4A90E2;
        padding: 10px 20px;
        border-radius: 5px;
        transition: background 0.3s ease, transform 0.2s ease;
    }
    a:hover {
        background: #9013FE;
        transform: translateY(-5px); /* Button hover effect */
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
        <h1>Welcome to TAP's PARADISE</h1>
        <p>Experience the joy of delicious meals delivered to your doorstep with just a click!</p>
        <a href="register.jsp">Get Started</a>
</div>
</body>
</html>

