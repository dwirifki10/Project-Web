<?php 
session_start();
require 'Functions.php';

if (isset($_COOKIE["id"]) && isset($_COOKIE["key"])) {
	
	$id = $_COOKIE["id"];
	$key = $_COOKIE["key"];

	$result = mysqli_query($db, "SELECT username FROM users WHERE id = $id");

	$query = mysqli_fetch_assoc($result);

	if ($key === hash('sha256', $query["username"])) {
		$_SESSION["login"] = true;
	}	

}


if (isset($_SESSION["login"])) {
	header("Location: Index.php");
	exit;
}

if (isset($_POST["submit"])) {

	$username = $_POST["username"];
	$password = $_POST["password"];

	$result = mysqli_query($db, "SELECT * FROM users WHERE username = '$username'");

	if (mysqli_num_rows($result) === 1) {
		
		$query = mysqli_fetch_assoc($result);
			if(password_verify($password, $query["password"])){
			$_SESSION["login"] = true;

			$ip = $_SERVER["REMOTE_ADDR"];
			$date = date("l, d-M-Y");

			$query = "INSERT INTO tamu VALUES('', '$ip', '$date', 'BERHASIL')";

			$result = mysqli_query($db, $query);	

			if (isset($_POST["remember"])) {
				setcookie('id', $query["id"], time()+60);
				setcookie('key', hash('sha256', $query["username"]), time()+60);	
			}

			header("Location: Index.php");
			exit;
		}
	}

	$ip = $_SERVER["REMOTE_ADDR"];
	$date = date("l, d-M-Y");

	$query = "INSERT INTO tamu VALUES('', '$ip', '$date', 'GAGAL')";

	mysqli_query($db, $query);

	$error = true;

}	

?>
<!DOCTYPE html>
<html>
<head>
	<title>Halaman Login</title>
	<style type="text/css">
		li{
			display: block;
		}
	</style>
</head>
<body>

<h1>Halaman Login</h1>
<h2>Silahkan Login Admin</h2>

<?php if (isset($error)): ?>
	<p style="font-style: italic; color: red;">Username / Password yang dimasukan tidak tepat</p>
<?php endif ?>

<form action="" method="POST">
	<ul>
		<li>
			<label for="username">Username :</label><br>
			<input type="text" name="username" id="username">
		</li>
			<br>
		<li>
			<label for="password">Password :</label><br>
			<input type="password" name="password" id="password">
		</li>
			<br>
		<li>
			<input type="checkbox" name="remember" id="remember">
			<label for="remember">Remember me</label>
		</li>
			<br>
		<li>
			<button input="submit" name="submit">Login Admin</button>
		</li>
	</ul>
</form>
<a href="Register.php">Belum Punya Account ?</a>

</body>
</html>