<!DOCTYPE html>
<html>
<head>
	<title>Array Assosiatif</title>
</head>
<body>


<center>
<H1>DAFTAR MAHASISWA</H1>

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


<table cellpadding="20" border="1.5" cellspacing="0" bgcolor="yellow">
	<tr>
		<td align="center">Gambar</td>
		<td align="center">Nama Mahasiswa</td>
		<td align="center">Jurusan</td>
		<td align="center">Email</td>
		<td align="center">No Handphone</td>
	</tr>
	<?php foreach($mahasiswa as $mhs) : ?>
	<tr>
		<td><img width="100px" src="Images/<?php echo $mhs["gambar"]; ?>"></td>
		<td><?php echo $mhs["nama"]; ?></td>
		<td><?php echo $mhs["jurusan"]; ?></td>
		<td><?php echo $mhs["email"]; ?></td>
		<td><?php echo $mhs["handphone"]; ?></td>
	</tr>
	<?php endforeach; ?>
</table>	
</center>


</body>
</html>