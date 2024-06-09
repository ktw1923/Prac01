<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form id="registerForm">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br><br>
    <button type="button" onclick="register()">Register</button>
</form>
<script>
    function register() {
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        fetch('/api/users/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        })
            .then(response => response.text())
            .then(data => alert(data))
            .catch(error => console.error('Error:', error));
    }
</script>
</body>
</html>
