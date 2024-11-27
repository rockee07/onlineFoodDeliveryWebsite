<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>TAP's PARADISE</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(120deg, #6A11CB, #2575FC);
            margin: 0;
            padding: 0;
            color: #fff;
        }

        .form-container {
            width: 100%;
            max-width: 400px;
            margin: 100px auto;
            background: rgba(255, 255, 255, 0.1); /* Semi-transparent white */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .form-container:hover {
            transform: scale(1.03); /* Slight zoom-in effect */
            box-shadow: 0 6px 10px rgba(0, 0, 0, 0.4); /* Enhanced shadow */
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            animation: fadeIn 1s ease-in-out;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input[type="password"] {
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            background: rgba(255, 255, 255, 0.8); /* Light input background */
            transition: background 0.3s ease;
        }

        input[type="password"]:focus {
            background: #e6f7ff; /* Focus highlight */
            outline: none;
        }

        button {
            padding: 10px;
            border: none;
            border-radius: 5px;
            background: #2575FC;
            color: #fff;
            font-size: 1.2em;
            cursor: pointer;
            font-weight: bold;
            transition: background 0.3s, transform 0.2s;
        }

        button:hover {
            background: #6A11CB; /* Hover effect */
            transform: translateY(-5px); /* Slight upward animation */
        }

        .links {
            text-align: center;
            margin-top: 20px;
        }

        .links a {
            color: #00bcd4; /* Cyan link color */
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .links a:hover {
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
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Update Password</h2>
         <form action="updatePassword" method="post">
            <%
                // Retrieve email from session
                HttpSession s = request.getSession(false);
                String email = (session != null) ? (String) s.getAttribute("email") : null;

                if (email != null) {
            %>
                <input type="hidden" name="email" value="<%= email %>">
                <p>Updating password for: <b><%= email %></b></p>
            <% } else { %>
                <p>Error: Session expired. Please try again.</p>
                <a href="forgot.jsp">Go back</a>
            <% } %>
            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="password" required>
            <button type="submit">Update Password</button>
        </form>
    </div>
</body>
</html>
