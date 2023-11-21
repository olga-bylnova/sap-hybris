<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Contact Request</title></head>
<body>
<form method="post">
    <label for="newSender">Sender: </label>
    <input id="newSender" type="text" name="newSender" value="${contactRequest.sender}"/>
    <br/>
    <label for="newMessage">Message:</label>
    <textarea id="newMessage" name="newMessage">${contactRequest.message}</textarea>
    <br/>
    <input type="submit" value="Send"/>
</form>
</body>
</html>