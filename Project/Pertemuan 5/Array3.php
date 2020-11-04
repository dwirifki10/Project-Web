<?php 
	
$mahasiswa = [
	["Dwi Rifki Novianto", "E41191107", "Teknik Informatika", "dwirifkinovianto10@gmail.com"],
	["Siti Asropah", "A41191107", "Bahasa Inggris", "sitiasropah@gmail.com"]];

 ?>

 <!DOCTYPE html>
 <html>
 <head>
 	<title>Array3</title>
 </head>
 <body>
 
 <?php foreach ($mahasiswa as $mhs) : ?>
 	<ul>
 		<li>Nama : <?php echo $mhs[0]; ?></li>
 		<li>NIM : <?php echo $mhs[1]; ?></li>
 		<li>Jurusan : <?php echo $mhs[2]; ?></li>
 		<li> Email : <?php echo $mhs[3]; ?></li>
 	</ul>
<?php endforeach; ?> 	

 </body>
 </html>