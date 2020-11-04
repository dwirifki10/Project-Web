<?php 

	if(isset($_POST['submit'])){

		if ($_POST['text'] == "admin" && $_POST["password"] == '123') {
			
			header("Location: GetandPost.php");
			exit;
			
		}else{

			$error = true;
		}


	}

 ?>

<!DOCTYPE html>
<html>
<head>
	<title>POST</title>
</head>
<body>

	<h1>Login Mahasiswa</h1>

<?php if (isset($error)): ?>
	<p>username / password salah</p>
<?php endif ?>
	

	<form action="" method="POST">
		<ul>
			<li>
				Username : 
				<input type="text" name="text">
			</li>
				<br>
			<li>
				Password :
				<input type="password" name="password">
			</li>
				<br>
			<li>
				<button type="submit" name="submit">Submit</button>
			</li>	
		</ul>
	</form>

</body>
</html>