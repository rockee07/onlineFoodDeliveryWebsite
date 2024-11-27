<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TAP's PARADISE</title>
    <style>
        /* Root colors from your project */
        :root {
            --primary-bg-color: #ffffff; /* Primary background color */
            --secondary-bg-color: #0088cc; /* Secondary background color */
            --text-color: #333333; /* Neutral text color */
            --success-color: #28a745; /* Green for success */
        }

        body {
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, var(--secondary-bg-color), var(--primary-bg-color));
            font-family: Arial, sans-serif;
            color: var(--text-color);
        }

        .success-container {
            text-align: center;
            border: 2px solid rgba(0, 0, 0, 0.1);
            padding: 30px;
            border-radius: 15px;
            background-color: rgba(255, 255, 255, 0.1);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            width: 400px;
            animation: slideDown 0.8s ease-out;
        }

        .circle {
            width: 100px;
            height: 100px;
            margin: 0 auto 20px auto;
            border-radius: 50%;
            background-color: var(--success-color);
            display: flex;
            justify-content: center;
            align-items: center;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
        }

        .circle .tick-mark {
            color: var(--primary-bg-color);
            font-size: 50px;
            font-weight: bold;
        }

        .message {
            font-size: 22px;
            font-weight: 600;
            margin-bottom: 20px;
        }

        .redirect-message {
            font-size: 16px;
            color: var(--text-color);
            margin-top: 10px;
        }

        @keyframes slideDown {
            from {
                transform: translateY(-100%);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }
    </style>
    <script>
        // Redirect to login page after 3 seconds
        setTimeout(() => {
            window.location.href = "login.jsp";
        }, 3000);
    </script>
</head>
<body>
    <div class="success-container">
        <div class="circle">
            <div class="tick-mark">✔</div>
        </div>
        <div class="message">Successfully Registered!</div>
        <div class="redirect-message">Redirecting to the login page...</div>
    </div>
</body>
</html>


    