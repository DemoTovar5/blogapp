export default function User(props) {
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>User View</title>
</head>
<body>
<h1>User View</h1>

<form id="user-form">
    <label for="username">Username</label>
    <input id="username" name="username" type="text"/>
    <label for="email">Email</label>
    <input id="email" name="email" type="text"/>
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    
    <input id="user-btn" type="submit" value="Register"/>
</form>
</body>
</html>`;

}