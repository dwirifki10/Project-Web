<?php 

require 'Functions.php';

$ket = $_GET["id"];

function hapusTamu($ket){
	global $db;
	$result = mysqli_query($db, "DELETE FROM tamu WHERE keterangan = '$ket' ");
	echo 
	"<script>
		alert('Data berhasil dihapus');
		document.location.href = 'Tamu.php';
	</script>";
}

hapusTamu($ket);

 ?>