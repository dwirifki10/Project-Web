<?php 

require 'PHP/Functions.php';

$id = $_GET["id"];

if(deleteData($id) > 0){
	echo 
		"<script>
		   	alert('Hapus Data Mahasiswa Berhasil');
		   	document.location.href = 'index.php';
		</script>";
	}else{
		echo 
		   "<script>
		   		alert('Hapus Data Mahasiswa Gagal');
		   		document.location.href = 'index.php';
			</script>";
	}


 ?>