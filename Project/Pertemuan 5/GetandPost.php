<?php 

	$mahasiswa = [
				 [
				 "nama" => "Dwi Rifki Novianto",
				 "jurusan" => "Teknik Informatika",
				 "email" => "dwirifkinovianto@gmail.com",
				 "handphone" => "083872523688",
				 "gambar" => "Keluarga.JPEG"
				 ],
				 [
				 "nama" => "Nur Endang Wahyuni",
				 "jurusan" => "Bahasa Indonesia",
				 "email" => "nurendangwahyuni@gmail.com",
				 "handphone" => "083872523683",
				 "gambar" => "admin.PNG"
				 ],
				 [
				 "nama" => "Muhammad Tri Fauzi",
				 "jurusan" => "Bahasa Inggris",
				 "email" => "mtrifauzi@gmail.com",
				 "handphone" => "083872523699",
				 "gambar" => "admin.PNG"
				 ]

	]; 

 ?>


<!DOCTYPE html>
<html>
<head>
	<title>GET</title>
</head>
<body>

<h1>Nama Siswa</h1>

<?php foreach($mahasiswa as $mhs): ?>
	<ul>
		<li>
			<a href="GetandPost2.php?nama= <?php echo $mhs["nama"]; ?>&jurusan= <?php echo $mhs["jurusan"]; ?>&email= <?php echo $mhs["email"]; ?>"><?php echo $mhs["nama"]; ?></a>
	</li>
	</ul>
<?php endforeach; ?>	
	

</body>
</html>