<?php 

$db = mysqli_connect("localhost", "root", "", "phpdasar");


function queryData($query){
	global $db;
	$result = mysqli_query($db, $query);
	$rows = [];
	while ($row = mysqli_fetch_assoc($result)) {
		$rows[] = $row;
	}
	return $rows;
}

function addData($data){
	global $db;
	$nim = htmlspecialchars($data["nim"]);
	$nama = htmlspecialchars($data["nama"]);
	$jurusan = htmlspecialchars($data["jurusan"]);
	$email = htmlspecialchars($data["email"]);
	$photo = addPhoto();

	if($photo == false){
		return false;
	}
	
	$query = "INSERT INTO mahasiswa VALUES 
			('', '$photo', '$nim', '$nama', '$jurusan', '$email')";

	mysqli_query($db, $query);

	return mysqli_affected_rows($db);
}

function addPhoto(){

	$namaFile = $_FILES["foto"]["name"];
	$error = $_FILES["foto"]["error"];
	$size = $_FILES["foto"]["size"];
	$tmpName = $_FILES["foto"]["tmp_name"];

	if ($error === 4) {
		"<script>
			alert('Photo Kosong');
		</script>";
	return false;	
	}

	$ekstensiFileValid = ["jpg", "jpeg", "png"];
	$namaFiles = explode(".", $namaFile);
	$ekstensiFile =	strtolower(end($namaFiles)) ;

	if (!in_array($ekstensiFile, $ekstensiFileValid)) {
	echo 
		"<script>
			alert('Anda bukan upload photo');
		</script>";
	return false;	
	}

	if($size > 2000000){
	echo 
		"<script>
			alert('Photo lebih dari 2 mb');
		</script>";
	return false;
	}


	$namaFileValid = $namaFiles;
	$namaFileValid = uniqid();
	$namaFileValid .= $ekstensiFile;

	move_uploaded_file($tmpName, "Photos/" . $namaFileValid);

	return $namaFileValid;

}

function deleteData($data){
	global $db;
	$query = "DELETE FROM mahasiswa WHERE id = $data";
	mysqli_query($db, $query);
	return mysqli_affected_rows($db);
}





?>