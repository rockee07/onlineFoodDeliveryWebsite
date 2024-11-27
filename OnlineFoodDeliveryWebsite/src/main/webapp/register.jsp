<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TAP's PARADISE</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(120deg, #6A11CB, #2575FC); /* Dark blue gradient */
        color: #fff;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 400px;
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
    h2 {
        text-align: center;
        margin-bottom: 20px;
        animation: fadeIn 1s ease-in-out;
    }
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        animation: slideInLeft 0.5s ease-in-out;
    }
    .form-group input,
    .form-group textarea {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 5px;
        font-size: 1em;
        background: rgba(255, 255, 255, 0.8); /* Light input background */
        transition: background 0.3s ease;
    }
    .form-group input:focus,
    .form-group textarea:focus {
        background: #e6f7ff; /* Subtle focus highlight */
        outline: none;
    }
    .form-group input[type="submit"] {
        background: #2575FC; /* Primary button color */
        color: #fff;
        cursor: pointer;
        font-weight: bold;
        transition: background 0.3s, transform 0.2s;
    }
    .form-group input[type="submit"]:hover {
        background: #6A11CB; /* Hover effect */
        transform: translateY(-5px); /* Slight upward animation */
    }
    .redirect {
        text-align: center;
        margin-top: 15px;
    }
    .redirect a {
        color: #00bcd4; /* Cyan link color */
        text-decoration: none;
        transition: color 0.3s ease;
    }
    .redirect a:hover {
        color: #80deea; /* Lighter cyan on hover */
        text-decoration: underline;
    }

    /* Keyframe Animations */
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    @keyframes slideInLeft {
        from {
            transform: translateX(-100%);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }
</style>
    
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone Number</label>
                <input type="text" id="phoneNumber" name="phonenumber" pattern="[0-9]{10}" title="Please enter a valid 10-digit phone number" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <textarea id="address" name="address" rows="3" required></textarea>
            </div>
            <div class="form-group">
                <input type="submit" value="Register">
            </div>
        </form>
        <div class="redirect">
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
        </div>
    </div>
</body>
</html>

