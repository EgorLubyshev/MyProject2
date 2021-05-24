<?php
	include "login.php";

	$sql = "SELECT * FROM users";

	if (array_key_exists("id", $_GET)){
		$sql .= " WHERE id = ".$_GET["id"];
	}

	$result = mysqli_query($link, $sql);

	$answer = [];
	while ($row = mysqli_fetch_assoc($result)) {
		$answer[] = $row;
	}

	echo json_encode([
		"data" => $answer,
		"status" => true
	]);
?>

<?php
	include  "login.php";	
	if( array_key_exists("login", $_GET) && 
		array_key_exists("password", $_GET) && 
	 	array_key_exists("mail", $_GET)){
			$login = $_GET["login"];
			$pass = $_GET["password"];
			$mail =  $_GET["mail"];

			$sql = "INSERT into users (login, password, mail) VALUES ('" .$login. "', '" .$pass."', '"  .$mail. "')";

			$result = mysqli_query($link, $sql);

			echo json_encode([
				"data" => [],
				"status" => true

			]);
	}
	else{
		echo json_encode([
				"data" => [],
				"status" => true

			]);
	}
?>



<?php
	include  "login.php";	
	if( array_key_exists("id", $_GET) && 
		array_key_exists("password", $_GET) 
			){
			$id = $_GET["id"];
			$pass = $_GET["password"];

			$sql = "UPDATE  users SET password = '" .$pass."' WHERE id=" .$id;

			$result = mysqli_query($link, $sql);




			echo json_encode([
				"data" => [],
				"status" => true

			]);
	}
	else{
		echo json_encode([
				"data" => [],
				"status" => false

			]);
	}
?>


<?php
	include  "login.php";	
	if( array_key_exists("id", $_GET)){
			$id = $_GET["id"];
			$sql = "DELETE from  users  WHERE id=" .$id;

			$result = mysqli_query($link, $sql);

			echo json_encode([
				"data" => [],
				"status" => true

			]);
	}
	else{
		echo json_encode([
				"data" => [],
				"status" => false

			]);
	}
?>

<?php
	$username = "root";
	$password = "";
	$db_name = "egor";
	$host = "localhost";

	$link = mysqli_connect($host, $username, $password, $db_name);
?>



http://10.67.172.157/EgorLubyshev/get_user.php

get set update delite login





a=0
for i in range(3):
   a=i
print(a) 2

a=17
for i in range(1,7,2):
   a=17
   a+=i
print(a) 22
   
a=12
for i in range(3,21,3):
   a+=1
print(a) 18

a=19
for i in range(21,7,-7):
   a-=i
   a=19
print(a) 19

a=0
while(a<7):
   a+=1
print(a) 7

a=[1,2,3]
for i in range(len(a)):
   a[i]+=1
print(*a) 2 3 4

a="абвгд"
for i in range(len(a)):
   if a[i]>='в' :
      print(a[i], end="") вгд
a=["3","1","12","3"]
for i in range(len(a)):
   if i>1 :
      print(a[i], end="") 123
a=["Привет","Привет","Привет","Привет"]
for i in range(len(a)):
   b=a[i]
   print(b[0],end="") ПППП

