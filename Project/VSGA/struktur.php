<?php 

$nilai = 85;
if(($nilai >= 85) && ($nilai <= 100)){
   $index = "A";
} elseif($nilai >= 70) {
   $index = "B";
} elseif($nilai >= 50) {
   $index = "C";
} elseif($nilai >= 30){
   $index = "D";
} else {
   $index = "E";
}
echo "Nilai anda adalah : ".$nilai;
echo "<br />";
echo "Dengan index      : ".$index;
echo "<br>";

for ($i=1; $i<= 10; $i+=2) { 
	echo $i;
}

echo "<br>";

function nilai($nilai){
	$hasil = 1;
	for($i = 1; $i <= 3; $i++){
		$hasil *= $nilai;
	}
	return $hasil;
}

echo nilai(10);



 ?>


 <script type="text/javascript">
 


function nilai(nilai){	
	var hasil = 1;
 	for(var i = 1; i <= 3; i++){
 		var hasil = hasil + nilai;
 		console.log(hasil);
 	}

}	

nilai(10);




 </script>