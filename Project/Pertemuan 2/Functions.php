<?php 
	
	// Membuat tanggal dari komputer saat ini
	echo date("l, d-M-Y");

	echo "<br><br>";

	// Membuat waktu yang berlaku sejak 1 januari 1970
	echo date("l, d-M-Y", time()-60*60*24*43);

	echo "<br><br>";

	echo date("l, d-M-Y", time()-(60*60*24*43) + (60*60*24*100));

	echo "<br><br>";

	// Membuat waktu sendiri dengan menggunakan mktime
	print mktime(0,0,0,0,0,0);
	// jam, menit, detik, bulan, tanggal tahun

	echo "<br><br>";

	echo date("l, d-M-Y", mktime(12, 45, 10, 7, 29, 2020));

	echo "<br><br>";

	echo date("l, d-M-Y", strtotime("29 juli 2020"));	

	echo "<br><br>";

	// Menghitung jumlah string
	$nama = "Siti Asropah";

	echo strlen($nama);

	echo "<br><br>";

	echo isset($nama);

 ?>