<?php 

// Array merupakan sebuah variable yang dapat memiliki banyak nilai

// Membuat Array dengan cara lama
$hari = Array("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu");

// Membuat Array dengan cara baru
$nama = ["Dwi", "Yuni", "Fauzi"];

// Menampilkan Array dengan menggunakan element
echo $nama[1]; 

echo "<br><br>";

// Menampilkan Array tanpa menggunakan element
var_dump($hari);

echo "<br><br>";

// Menambahkan element pada Array
$nama[] = "Siti Asropah";

var_dump($nama);






?>