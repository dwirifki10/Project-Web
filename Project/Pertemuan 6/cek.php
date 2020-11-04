<?php 


if(isset($_POST["submit"])){
	
	$nama = $_POST["nama"];
	$alamat = $_POST["alamat"];
	$ttl = $_POST["ttl"];
	$jenis_kelamin = $_POST["button"];
	$usia = $_POST["usia"];

	echo $nama .'<br>', $alamat .'<br>', $ttl .'<br>', $jenis_kelamin .'<br>', $usia .'<br>';

}

if($nama AND $jenis_kelamin == ""){
	header("location:kominfo.php?nama=kosong&jenis_kelamin=kosong");
}else{
	echo "Nama anda adalah ". $nama;
}

?>
