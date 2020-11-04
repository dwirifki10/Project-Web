<?php 
session_start();

if (!isset($_SESSION["login"])) {
	header("Location: Login.php");
	exit;
}

require 'Functions.php';

	if (isset($_POST['submit'])) {
		
	if (tambahData($_POST) > 0) {
		echo 
		"<script>
			alert('Data berhasil ditambahkan');
			document.location.href = 'Index.php';
		</script>";
	}else{
		echo 
		"<script>
			alert('Data gagal ditambahkan');
			document.location.href = 'Index.php';
		</script>";
	}		 

}

 ?>
<!DOCTYPE html>
<html>
<head>
	<title>Tambah Mahasiswa Baru</title>
</head>
<body>


<h1>Tambah Data Mahasiswa</h1>
<form action="" method="POST" enctype="multipart/form-data">	
	<ul>
		<li>
			<label for="nim">NIM :</label><br>
			<input type="text" name="nim" id="nim" required="">
		</li>
			<br>
		<li>	
			<label for="nama">Nama :</label><br>
			<input type="text" name="nama" id="nama" required="">
		</li>
			<br>	
		<li>	
			<label for="jurusan">Jurusan :</label><br>
			<input type="text" name="jurusan" id="jurusan" required="">
		</li>
			<br>
		<li>	
			<label for="email">Email :</label><br>
			<input type="text" name="email" id="email" required="">
		</li>
			<br>	
		<li>
			<label for="gambar">Gambar :</label><br>
			<input type="file" name="gambar" id="gambar" >
		</li>
			<br>
		<li>	
			<button type="submit" name="submit">Tambahkan Data</button>
		</li>
	</ul>
</form>


</body>
</html>