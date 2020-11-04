<?php 

// Pengulangan pada Array

$angka = [3,2,15,20,11,31];

$angka[] = "100";

 ?>

<!DOCTYPE html>
<html>
<head>
	<title>Array2</title>
	<style type="text/css">
		.kotak{
			width: 50px;
			height: 50pxl;
			background-color: salmon;
			text-align: center;
			line-height: 50px;
			margin: 3px;
			float: left;
		}
		.clear{
			clear: both;
		}
	</style>
</head>
<body>

<?php for($i = 0; $i < count($angka); $i++) : ?>

<div class="kotak"> <?php echo $angka[$i]; ?></div>

<?php endfor; ?>

<div class="clear"></div>

<?php foreach ($angka as $a ) : ?>
	<div class="kotak"><?php echo $a; ?></div>
<?php endforeach; ?>




</body>
</html>