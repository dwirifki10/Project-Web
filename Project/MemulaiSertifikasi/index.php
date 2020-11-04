<?php 

require 'PHP/Functions.php';

$mahasiswa = queryData("SELECT * FROM mahasiswa");

 ?>
<!DOCTYPE html>
<html>
<head>
	<title>Halaman Index</title>
</head>
<body>

<h1>Daftar Mahasiswa Politeknik Negeri Jember</h1>

<form>
	<input type="text" name="search" placeholder="Cari sesuatu" autocomplete="off" autofocus size="30" id="keyword">
	<button type="submit" name="cari">Cari Mahasiswa</button>
</form>



<br><a href="addData.php">Tambah Data Mahasiswa</a><br><br>
<div id="container">
<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<td>No</td>
		<td>Hapus</td>
		<td>Photo</td>
		<td>NIM</td>
		<td>Nama</td>
		<td>Jurusan</td>
		<td>Email</td>
	</tr>	
<?php $i = 1; ?>	
<?php foreach($mahasiswa as $mhs): ?>	
	<tr>
		<td><?php echo $i; ?></td>
		<td>
		<a href="deleteData.php?id=<?php echo $mhs['id']; ?>" onclick="confirm('Apakah anda yakin ?')">Hapus</a>
		</td>
		<td>
		<img src="Photos/<?php echo $mhs['gambar']; ?>" width="50" height="50">
		</td>
		<td><?php echo $mhs["nim"]; ?></td>
		<td><?php echo $mhs["nama"] ?></td>
		<td><?php echo $mhs["jurusan"]; ?></td>
		<td><?php echo $mhs["email"]; ?></td>
	</tr>
<?php $i++; ?>	
<?php endforeach; ?>	
</table>
</div>


<script type="text/javascript" src="JS/script.js"></script>

</body>
</html>