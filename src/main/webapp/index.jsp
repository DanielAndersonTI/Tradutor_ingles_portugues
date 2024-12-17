<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tradutor_ingles_portugues</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Tradutor_ingles_portugues</h1>
        <form action="translate" method="post">
            <label for="word">Entre com a palavra:</label>
            <input type="text" id="word" name="word" required>
            <button type="submit">Traduzir</button>
        </form>
    </div>
</body>
</html>
