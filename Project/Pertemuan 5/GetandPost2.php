<?php 

	if (!isset($_GET["nama"]) || !isset($_GET["jurusan"]) || !isset($_GET["email"])) {

		header("Location: GetandPost.php");
		exit;

	}

 ?>

<!DOCTYPE html>
<html>
<head>
	<title>GET</title>
</head>
<body>

	<h1>Detail Mahasiswa</h1>

	<ul>
		<li><?php echo $_GET["nama"]; ?></li>
		<li><?php echo $_GET["jurusan"]; ?></li>
		<li><?php echo $_GET["email"]; ?></li>
	</ul>

<a href="GetandPost.php">Kembali</a>

</body>
</html>