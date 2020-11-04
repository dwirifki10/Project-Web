<?php 

$artikel = [
			"judul" => "Belajar Pemrograman PHP",
			"penulis" => "Digital Talent",
			"view" => 128
			];

// Mencetak isi array
echo "<h2>" . $artikel['judul'] . "</h2>" ;
echo "<p> oleh : " . $artikel['penulis'] . "</h2>";
echo "<p> views : " . $artikel['view'] . "</p>";


 ?>