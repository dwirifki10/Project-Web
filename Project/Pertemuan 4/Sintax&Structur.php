<?php 
	
	$NamaFiles = "Indonesia.png";
	$NamaFiles = explode(".", $NamaFiles);
	$NamaFiles = strtolower(end($NamaFiles));

	if (!$NamaFiles == "png") {
		echo 
		"<script>
			alert('This is not Image, Please Upload Image');
		</script>";
	}else{
		echo 
		"<script>
			alert('It is work');
		</script>";
	}

 ?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<style type="text/css">
		.tableRow{
			background: red;
		}
		.elseRow{
			background: blue;
		}
	</style>
	<title>Document</title>
</head>
<body>
	<center>
	<table border="1" cellpadding="10" cellspacing="0">
		
		<?php for ($i = 1; $i <= 5; $i++) : ?>
			<?php if ($i % 2 == 0): ?>
				<tr class="tableRow">
					<?php else: ?>
						<tr class="elseRow">
			<?php endif ?>

			<?php for ($j=1; $j <= 5; $j++) : ?>
				<td><?php echo $i . "," . $j; ?></td>
			<?php endfor; ?>
		</tr>
		<?php endfor; ?>	

	</table>
	</center>

</body>
</html>