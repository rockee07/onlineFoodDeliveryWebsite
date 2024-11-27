<!DOCTYPE html>
<html>
<head>
    <title>TAP's PARADISE</title>
    <meta http-equiv="refresh" content="5;url=login.jsp"> <!-- Redirects after 5 seconds -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #6A11CB, #2575FC); /* Color combination */
            margin: 0;
            padding: 0;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }
        .message-container {
            text-align: center;
            background: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            animation: fadeIn 1.5s ease-in-out;
        }
        .message {
            font-size: 24px;
            font-weight: bold;
            animation: pulse 2s infinite; /* Pulse animation */
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
        @keyframes pulse {
            0%, 100% {
                transform: scale(1);
                opacity: 1;
            }
            50% {
                transform: scale(1.1);
                opacity: 0.8;
            }
        }
        .redirect-info {
            margin-top: 20px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <div class="message">
            Email-ID does not exist
        </div>
        <div class="redirect-info">
            Redirecting to Login page in 5 seconds...
        </div>
    </div>
</body>
</html>
