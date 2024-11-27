<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TAP's PARADISE</title>
    <meta http-equiv="refresh" content="5;url=home.jsp">
    <style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(120deg, #6A11CB, #2575FC);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        color: #fff;
    }

    .success-container {
        text-align: center;
        background: rgba(255, 255, 255, 0.1);
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
        animation: fadeIn 1s ease-in-out;
    }

    .checkmark-container {
        width: 100px;
        height: 100px;
        margin: 0 auto;
        border-radius: 50%;
        background: radial-gradient(circle, #28a745, #1e7a34);
        display: flex;
        justify-content: center;
        align-items: center;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
        animation: popIn 0.5s ease-out;
    }

    .checkmark {
        position: absolute;
            width: 30px;
            height: 60px;
            border: 5px solid white;
            border-width: 0 5px 5px 0;
            transform: rotate(45deg);
            animation: tick 0.5s ease-in-out forwards;
    }

    h1 {
        font-size: 2.5rem;
        margin: 20px 0;
    }

    p {
        font-size: 1.2rem;
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: scale(0.9);
        }
        to {
            opacity: 1;
            transform: scale(1);
        }
    }

    @keyframes popIn {
        0% {
            transform: scale(0);
            opacity: 0;
        }
        80% {
            transform: scale(1.1);
            opacity: 1;
        }
        100% {
            transform: scale(1);
        }
    }

    @keyframes drawCheck {
        0% {
            width: 0;
            height: 0;
        }
        50% {
            width: 60px;
            height: 0;
        }
        100% {
            width: 60px;
            height: 30px;
        }
    }
</style>
    
</head>
<body>
    <div class="success-container">
        <div class="checkmark-container">
            <div class="checkmark"></div>
        </div>
        <h1>Order Placed Successfully!</h1>
        <p>Thank you for your purchase. Your order has been confirmed.</p>
    </div>
</body>
</html>
