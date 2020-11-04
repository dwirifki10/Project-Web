<?php 

require 'Functions.php';

$tamu = query("SELECT * FROM tamu LIMIT 0, 75");


?>
<!DOCTYPE html>
<html>
<head>
	<title>Buku Tamu</title>
</head>
<body>

<h1>Daftar Nama Tamu / Berkunjung</h1>
<a href="Index.php">Kembali Ke Halaman Awal</a><br><br>	

<form method="POST">
<a href="TamuHapus.php?id=<?= 'BERHASIL'; ?>">Hapus Tamu Berhasil Login</a> ||  
<a href="TamuHapus.php?id=<?= 'GAGAL'; ?>">Hapus Tamu Gagal Login</a>
</form>


<?php foreach($tamu as $tm) : ?>
	<p>
	IP Address = <?= $tm["ip"]; ?> 
	|| Tanggal = <?= $tm["tanggal"]; ?> 
	|| Keterangan = <?= $tm["keterangan"]?>	
	</p>
<?php endforeach; ?>


</body>
</html>