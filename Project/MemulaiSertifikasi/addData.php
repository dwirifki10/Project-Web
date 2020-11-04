<?php 

require 'PHP/Functions.php';

if (isset($_POST["submit"])) {
	if(addData($_POST) > 0){
		echo 
		   "<script>
		   		alert('Tamabah Data Mahasiswa Berhasil');
			</script>";
	}else{
		echo 
		   "<script>
		   		alert('Tamabah Data Mahasiswa Gagal');
			</script>";
	}
}


 ?>
<!DOCTYPE html>
<html>
<head>
	<title>Tambah Data</title>
</head>
<body>

	<h1>Tambah Data Mahasiswa</h1>
	<form action="" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label for="nim">NIM</label></td>
				<td><input type="text" name="nim"></td>
			</tr>
			<tr>
				<td><label for="nama">Nama</label></td>
				<td><input type="text" name="nama"></td>
			</tr>
			<tr>
				<td><label for="jurusan">Jurusan</label></td>
				<td><input type="text" name="jurusan"></td>
			</tr>
			<tr>
				<td><label for="email">Email</label></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><label for="foto">Photo</label></td>
				<td><input type="file" name="foto"></td>
			</tr>
			<tr>
				<td><button type="submit" name="submit">Tambah Data</button></td>
			</tr>
		</table>
	</form>
	<a href="index.php">Kembali</a>

</body>
</html>