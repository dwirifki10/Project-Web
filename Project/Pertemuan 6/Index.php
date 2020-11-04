<?php 
session_start();

if (!isset($_SESSION["login"])) {
	header("Location: Login.php");
	exit;
}

require 'Functions.php';

$jumlahDataPerhalaman = 2;
$jumlahData = count(query("SELECT * FROM mahasiswa"));
$jumlahHalaman = ceil($jumlahData / $jumlahDataPerhalaman);
$halamanAktif = (isset($_GET["halaman"])) ? $_GET["halaman"] : 1;
$dataAwal = ($jumlahDataPerhalaman * $halamanAktif) - $jumlahDataPerhalaman;

if($halamanAktif == 0){
	header("Location: Index.php");
}


$mahasiswa = query("SELECT * FROM mahasiswa LIMIT $dataAwal, $jumlahDataPerhalaman");

if(isset($_POST["submit"])){
	
	$mahasiswa = cariData($_POST["cari"]);

}


 ?>
<!DOCTYPE html>
<html>
<head>
	<title>Halaman Admin</title>
</head>
<body>

<center>
<a href="Logout.php">Keluar dari Menu Admin</a>
<span>||</span>	
<a href="Tamu.php">Buku Tamu</a>	
	<h1>Halaman Awal Admin</h1>
	<form action="" method="POST">
		<input type="text" name="cari" placeholder="Kotak Pencarian" size="30" autofocus="">
		<button type="submit" name="submit">Cari</button>
	</form>
		<br>
	<a href="Tambah.php">Tambah Data Mahasiswa</a>
	<br><br>

<?php if (!isset($_POST["submit"])) : ?>
	<?php if ($halamanAktif > 1): ?>
		<a href="?halaman=<?= $halamanAktif - 1 ?>">&laquo</a>
	<?php endif ?>
	<?php for($i = 1; $i <= $jumlahHalaman; $i++) : ?>
		<?php if ($i == $halamanAktif) : ?>
			<a href="?halaman=<?= $i; ?>" style="font-weight: bold; color: red;">
				<?= $i; ?>	
			</a>	
		<?php else : ?>
			<a href="?halaman=<?= $i; ?>">
				<?= $i; ?>
			</a>
		<?php endif; ?>
	<?php endfor; ?>
	<?php if ($halamanAktif < $jumlahHalaman): ?>
		<a href="?halaman=<?= $halamanAktif + 1 ?>">&raquo</a>
	<?php endif ?>
<?php endif ?>

<?php if (isset($_POST["submit"])): ?>
	<a href="?">Kembali</a>	
<?php endif ?>


	<br>
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th align="center">No</th>
			<th align="center">Aksi</th>
			<th align="center">Gambar</th>
			<th align="center">NIM</th>
			<th align="center">Nama</th>
			<th align="center">Jurusan</th>
			<th align="center">Email</th>
		</tr>
	<?php $i = 1; ?>	
	<?php foreach($mahasiswa as $mhs) : ?>
		<tr>
			<td><?= $i; ?></td>
			<td>
				<a href="Ubah.php?id=<?= $mhs["id"] ?>">Ubah</a> ||
				<a href="Hapus.php?id=<?= $mhs["id"]; ?>" onclick="return confirm('Apakah anda yakin ingin menghapus ?')">Hapus</a> 
			</td>
			<td><img src="Images/<?= $mhs["gambar"]; ?>" width="90" height="80" ></td>
			<td><?= $mhs["nim"]; ?></td>
			<td><?= $mhs["nama"]; ?></td>
			<td><?= $mhs["jurusan"]; ?></td>
			<td><?= $mhs["email"]; ?></td>
		</tr>
	<?php $i++; ?>	
	<?php endforeach; ?>
	</table>
</center>

</body>
</html>