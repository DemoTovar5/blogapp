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

    <label for="id">Search by Id</label>
    <input id="user-id" name="id" type="text"/>
    <label for="username">Enter Username</label>
    <input id="username" name="username" type="text"/>
    <br>
    <label for="old-password"> Old Password</label>
    <input id="old-password" name="old-password" type="password"/>
    <br>
    <label for="new-password"> New Password</label>
    <input id="new-password" name="new-password" type="password"/>
    
    
    <input id="update-btn" type="submit" value="Update"/>
</form>
</body>
</html>`;

}