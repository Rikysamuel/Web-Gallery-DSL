<?php
error_reporting(E_ERROR | E_WARNING | E_PARSE);
if(isset($_FILES['image'])) {
  $file_name = $_FILES['image']['name'];
  $file_tmp =$_FILES['image']['tmp_name'];
  $file_type=$_FILES['image']['type'];
  $file_size =$_FILES['image']['size'];
  $file_ext=strtolower(end(explode('.',$_FILES['image']['name'])));

  $message = "Something is wrong";

  $extensions= array("jpg");

  if(in_array($file_ext,$extensions) === false){
    $error = true;
    $message = "Extension not allowed, please choose a .JPG file.";
  }

  if($file_size > 2097152){
    $error = true;
    $message = "File size should be under 2MB";
  }

  if($error !== true){
    move_uploaded_file($file_tmp,"../images/".$file_name);

    if($_POST["desc"] == '') {
      $desc = "No Description";
      $message = "Image " . $file_name . " uploaded successfully without description.";
    } else {
      $desc = $_POST["desc"];
      $message = "Image " . $file_name . " uploaded successfully.";
    }
    $name = explode('.',$_FILES['image']['name']);
    file_put_contents("../images/".$name[0].".desc", $desc);
  }

} else {
  $message = "Only .JPG files are accepted.";
}
?>

<html>
<head>
  <title>Your Gallery</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="../css/style.css" type="text/css" charset="utf-8">
</head>
<body>
  <main class="page">
    <header class="title">
      <img src="../avatar.jpg" alt="logo"/>
      <h1>The Gallery Uploader</h1>
      <h2>Upload images here<a href="../index.php">back?</a></h2>
    </header>
    <div class="contents">
      <h1 class="uploader"><?php echo $message; ?></h1>
      <form action="" method="POST" enctype="multipart/form-data">
        <span>Input File: </span><input type="file" name="image" /><br/>
        <span>Description: </span><input type="text" name="desc" value=""><br/>
        <input class="submit" type="submit"/>
      </form>
    </div>
    <footer>
      <p>Online Gallery copyright BlaBlaBla 2015.</p>
    </footer>
  </main>
</body>
<script src="jquery.min.js"></script>
<script src="script.js"></script>
</html>
