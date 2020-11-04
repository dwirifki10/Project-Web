<?php 

require 'Functions.php';

$keyword = $_GET["keyword"];

$mahasiswa = queryData("SELECT * FROM mahasiswa 
			 WHERE 
			 nim LIKE '%$keyword%' OR
			 nama LIKE '%$keyword%' OR
			 email LIKE '%$keyword%' OR
			 jurusan LIKE '%$keyword%'
			 ");
 ?>

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