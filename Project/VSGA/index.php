<?php 

// Membuat function dengan params
function perkenalan($nama, $salam){
	echo $salam . ", ";
	echo "perkenalkan nama saya : " . $nama . "<br>";
	echo "Senang berkenalan dengan anda  <br>";
}

// memanggil fungsi yang sudah dibuat
perkenalan("komang", "Hi");

echo "<hr>";

$saya = "Medi";
$ucapanSalam = "Selamat Pagi";

// memangil fungsi lagi dengan variable
perkenalan($saya, $ucapanSalam);


echo "<hr>";


function hitungUmur($thn_lahir, $thn_sekarang){
	$umur = $thn_sekarang - $thn_lahir;
	return $umur;
}

echo "Umur saya adalah ". hitungUmur(1992, 2019). " tahun";


function hitungUmur2($thn_lahir, $thn_sekarang){
	$umur = $thn_sekarang - $thn_lahir;
	return $umur;
}

function perkenalan2($nama, $salam="Selamat Datang"){
	echo $salam. ",";
	echo " Perkenalkan nama saya " . $nama ."<br>";

	// memanggil fungsi lain
	echo "saya berusia ". hitungUmur2(1992, 2019). " tahun";
	echo "senang berkenalan dengan anda";	
}

// memanggil function perkenalan
perkenalan2("komang");

echo "<hr>";

function faktorial($angka){
	if ($angka < 2) {
		return 1;
	}else{
		return ($angka * faktorial($angka-1));
	}
}

echo "faktorial 5 adalah : " . faktorial(5);

echo "<hr>";

function do_print(){
	echo time();
}

do_print();
echo "<br>";

function jumlah($a, $b){
	return ($a + $b);
}


echo "jumlah : " . jumlah(2,3);




?>