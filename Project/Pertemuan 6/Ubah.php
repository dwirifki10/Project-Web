<?php 
session_start();

if (!isset($_SESSION["login"])) {
	header("Location: Login.php");
	exit;
}
	
require 'Functions.php';

	$id = $_GET["id"];

	$mhs = query("SELECT * FROM mahasiswa WHERE id = $id")[0];

	if (!isset($mhs["id"])){
		header("Location: Index.php");
		exit;
	}


	if (isset($_POST['submit'])) {
		
	if (ubahData($_POST) > 0) {
		echo 
		"<script>
			alert('Data berhasil diubah');
			document.location.href = 'Index.php';
		</script>";
	}else{
		echo 
		"<script>
			alert('Data tidak ada yang berubah');
			document.location.href = 'Index.php';
		</script>";
	}		 

}

 ?>
<!DOCTYPE html>
<html>
<head>
	<title>Ubah Mahasiswa Baru</title>
</head>
<body>


<h1>Ubah Data Mahasiswa</h1>
<form action="" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="id" value="<?= $mhs["id"]; ?>">
	<input type="hidden" name="gambarLama" value="<?= $mhs["gambar"]; ?>">	
	<ul>
		<li>
			<label for="nim">NIM :</label><br>
			<input type="text" name="nim" id="nim" required="" value="<?= $mhs["nim"]; ?>">
		</li>
			<br>
		<li>	
			<label for="nama">Nama :</label><br>
			<input type="text" name="nama" id="nama" required="" value="<?= $mhs["nama"]; ?>">
		</li>
			<br>	
		<li>	
			<label for="jurusan">Jurusan :</label><br>
			<input type="text" name="jurusan" id="jurusan" required="" value="<?= $mhs["jurusan"]; ?>"> 
		</li>
			<br>
		<li>	
			<label for="email">Email :</label><br>
			<input type="text" name="email" id="email" required="" value="<?= $mhs["email"]; ?>" size="25">
		</li>
			<br>	
		<li>
			<label for="gambar">Gambar :</label><br>
			<img src="Images/<?= $mhs["gambar"]; ?>" width="80" ><br>
			<input type="file" name="gambar" id="gambar">
		</li>
			<br>
		<li>	
			<button type="submit" name="submit">Tambahkan Data</button>
		</li>
	</ul>
</form>


</body>
</html>