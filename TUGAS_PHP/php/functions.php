<?php 

// check keadaan jika tombol sudah ditekan jalankan perintah ini
if (isset($_POST["submit"])) {
	$harga = $_POST["harga"];
	$discount = $_POST["discount"];

	// membuat function supaya terstruktur
	function discount($harga, $discount){
		return ($discount/100) * $harga;
	}

	function harga($harga, $discount){
		return ($harga - ($discount/100) * $harga);
	}

// tampilkan nilai 
echo "<br><br>Discount barang tersebut sebesar : Rp. " . discount($harga, $discount) ."<br>";
echo " Harga Barang tersebut sebesar : Rp. " . harga($harga, $discount);

}




 ?>