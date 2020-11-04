<?php 

require 'Functions.php';

if (isset($_POST["register"])) {
	if (Register($_POST) > 0) {
		echo 
		"<script>
			alert('Data berhasil ditambahkan');
			document.location.href = 'Register.php';
		</script>";
	}else{
		echo 
		"<script>
			alert('Data gagal ditambahkan');
			document.location.href = 'Register.php';
		</script>";
	}
}

 ?>
<!DOCTYPE html>
<html>
<head>
	<title>Halaman Register</title>
	<style type="text/css">
		label{
			display: block;
		}
	</style>
</head>
<body>

<h1>Halaman Tambah Admin</h1>
<h2>Silahkan Masukan Data Admin</h2>
<form action="" method="POST">
	<ul>
		<li>
			<label for="username">Username :</label>
			<input type="text" name="username" id="username">
		</li>
			<br>
		<li>
			<label for="password">Password :</label>
			<input type="password" name="password" id="password">
		</li>
			<br>
		<li>
			<label for="password2">Ulangi Password :</label>
			<input type="password" name="password2" id="password2">
		</li>
			<br>
		<li>
			<button input="submit" name="register">Register</button>
		</li>
	</ul>
</form>
<a href="Login.php">Sudah Punya Account ?</a>


</body>
</html>