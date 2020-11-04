<?php 

// Tugas membuat program fungsi dan prosedur pertemuan 10
// Dwi Rifki Novianto - VSGA
	
	echo "<h1>Ini Merupakan Program Fungsi</h1>";
	
	// contoh param default 
	function hitungVolumeBalok($panjang = 5, $lebar = 4, $tinggi = 5){
		$hasil = $panjang * $lebar * $tinggi;
		return $hasil;
	}

	// bisa menggunakan perulangan for karena sisi =  n pangkat 3 
	// lalu untuk prosedur gunakan fungsi pow()
	function hitungVolumeKubus($sisi){
		$hasil = 1;
		for($i = 1; $i <= 3; $i++){
			$hasil *= $sisi;
		}
		return $hasil;
	}

	function hitungVolumeSilinder($r, $tinggi){
		$hasil = 3.14 * pow($r, 2) * $tinggi;
		return $hasil;
	}

	$balokdefault = hitungVolumeBalok();
	$balok = hitungVolumeBalok(10, 12, 10);
	$kubus = hitungVolumeKubus(5);
	$silinder = hitungVolumeSilinder(10, 10);

	echo "nilai dari balok : " . $balok . "<br>";
	echo "nilai dari kubus : " . $kubus . "<br>";
	echo "nilai dari silinder : " . $silinder . "<br>";
	echo "nilai dari balok dengan nilai default : " . $balokdefault;


	// akhir dari fungsi 

	echo "<hr>";
	echo "<h1> Ini Merupakan Program Prosedur </h1>";

	function hitungVolumeBalok2($panjang, $lebar, $tinggi){
		$hasil = $panjang * $lebar * $tinggi;
		return $hasil;
	}

	// menggunakan fungsi dari pow()
	function hitungVolumeKubus2($sisi){
		$hasil = pow($sisi, 3);
		return $hasil;
	}

	function hitungVolumeSilinder2($r, $tinggi){
		$hasil = 3.14 * pow($r, 2) * $tinggi;
		return $hasil;
	}


	echo "nilai dari silinder : " . hitungVolumeSilinder2(10,10) . "<br>";
	echo "nilai dari kubus : " . hitungVolumeKubus2(3) . "<br>";
	echo "nilai dari balok : " . hitungVolumeBalok2(10, 10, 10) . "<br>";

	// sebetulnya bisa menggunakan fungsi yang awal, sebagai contoh :
	echo "<hr><h1>Ini merupakan sebuah prosedur tanpa membuat fungsi kembali</h1><br>";

	echo "nilai dari silinder : " . hitungVolumeSilinder(10,10);

	// akhir dari prosedur


 ?>