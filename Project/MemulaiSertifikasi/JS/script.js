
keyword = document.getElementById('keyword');
container = document.getElementById('container');

keyword.addEventListener('keyup', function(){

	xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			container.innerHTML = xhr.responseText;
		}
	}

	xhr.open('GET', 'PHP/mahasiswa.php?keyword=' + keyword.value, 'true');
	xhr.send();

	

});