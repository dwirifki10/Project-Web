<?php

$db = mysqli_connect("localhost", "root", "", "phpdasar");

function query($query){
	global $db;
	$result = mysqli_query($db, $query);
	$rows = [];
	while ($row = mysqli_fetch_assoc($result)) {
		$rows[] = $row;
	}
	return $rows;
}

function tambahData($data){
	global $db;

	 	$nim = htmlspecialchars($data['nim']);
		$nama = htmlspecialchars($data['nama']);
		$jurusan = htmlspecialchars($data['jurusan']);
		$email = htmlspecialchars($data['email']);
		$gambar = uploadData();

		if ($gambar == false) {
			return false;
		}
		

		$query = "INSERT INTO mahasiswa
					VALUES 
				 ('', '$gambar', '$nim', '$nama', '$jurusan', 
				 '$email')
				";

	mysqli_query($db, $query);

	return mysqli_affected_rows($db);
}


function uploadData(){

	$namaGambar = $_FILES["gambar"]["name"];
	$error = $_FILES["gambar"]["error"];
	$ukuranGambar = $_FILES["gambar"]["size"];
	$tmpNama = $_FILES["gambar"]["tmp_name"];

	// jika tidak ada file gambar
	if ($error === 4) {
		echo 
		"<script>
			alert('tidak ada gambar yang dimasukan');
			document.location.href = 'Index.php';
		</script>";
	return false;		
	}	

	// jika bukan gambar
	$ekstensiValid = ["jpg", "jpeg", "png"];
	$ekstensiGambarValid = explode(".", $namaGambar);
	$ekstensiGambarValid = end($ekstensiGambarValid);

	if (!in_array($ekstensiGambarValid, $ekstensiValid)) {
		echo 
		"<script>
			alert('yang anda upload bukan gambar');
			document.location.href = 'Index.php';
		</script>";
	return false;
	}


	// jika gambar dengan ukuran besar
	if ($ukuranGambar > 1000000) {
		echo 
		"<script>
			alert('ukuran gambar terlalu besar');
			document.location.href = 'Index.php';
		</script>";
	return false;		
	}

	// jika nama gambar yang dimasukan sama
	$namaFileBaru = uniqid();
	$namaFileBaru .= ".";
	$namaFileBaru .= $ekstensiGambarValid;

	// pindahkan file yang diupload
	move_uploaded_file($tmpNama, "Images/" . $namaFileBaru );

	return $namaFileBaru;

}




function hapusData($id){
	global $db;
	mysqli_query($db, "DELETE FROM mahasiswa WHERE id = $id");
	return mysqli_affected_rows($db);
}


function ubahData($data){
	global $db;
		$id = $data['id'];
	 	$nim = htmlspecialchars($data['nim']);
		$nama = htmlspecialchars($data['nama']);
		$jurusan = htmlspecialchars($data['jurusan']);
		$email = htmlspecialchars($data['email']);
		$gambarLama = htmlspecialchars($data['gambarLama']);

		if ($_FILES["gambar"]["error"] === 4) {
			$gambar = $gambarLama;	
		}else{
			$gambar = uploadData();
		}


		$query = "UPDATE mahasiswa SET
				 	nim = '$nim',
				 	nama = '$nama',
				 	jurusan = '$jurusan',
				 	email = '$email',
				 	gambar = '$gambar' 
				 WHERE id = $id  	
				  ";

	mysqli_query($db, $query);

	return mysqli_affected_rows($db);
}


function cariData($keyword){
	global $dataAwal2;
	$query = "SELECT * FROM mahasiswa WHERE
			nim LIKE '%$keyword%' OR
			nama LIKE '%$keyword%' OR
			jurusan LIKE '%$keyword%' OR
			email LIKE '%$keyword%'
			";

	return query($query);

}

function Register($data){
	global $db;
		$username = strtolower(stripslashes($data["username"]));
		$password = mysqli_escape_string($db, $data["password"]);
		$password2 = mysqli_real_escape_string($db, $data["password2"]);

	$query = mysqli_query($db,"SELECT * FROM users WHERE username = '$username'");

	if (mysqli_num_rows($query) === 1) {
	echo 
		"<script>
			alert('Username yang anda masukan sama');
			document.location.href = 'Register.php';
		</script>";	
	return false;
	}	

	if ($password != $password2) {
	  echo 
		"<script>
			alert('Password yang anda masukan tidak sama');
			document.location.href = 'Register.php';
		</script>";	
	return false;
	}			

	$password = password_hash($password, PASSWORD_DEFAULT);

    mysqli_query($db, "INSERT INTO users VALUES('', '$username', '$password')");

	return mysqli_affected_rows($db);

}
	


 ?>