<?php // file constanta.php 

// membuat konstanta
define('VERSION', '1.0.0');

const SITE_NAME = "Petanikode";
const BASE_URL = "https://www.petanikode.com";

// contoh kasus
// const BASE_URL = "Hello World";

// cetak nilai konstanta
echo "Site Name : " . SITE_NAME . "<br>";
echo "URL : " . BASE_URL . "<br>";
echo "Version : " . VERSION . "<br>";

// tambahan saja
$variable_biasa = "Hello World";
$variable_biasa = "Say Hello";

echo "Tampilkan variable : " . $variable_biasa;

?>