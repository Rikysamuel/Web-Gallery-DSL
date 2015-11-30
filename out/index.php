<!DOCTYPE html>
<html>
<head>
  <title>Your Gallery</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="style.css" type="text/css" charset="utf-8">
</head>
<body>
  <div class="lightbox">
    <div class="center">
      <img class="fullimg" src="" alt=""></img>
      <div class="fulldesc"></div>
    </div>
  </div>
  <main class="page">
    <header class="title">
      <img src="avatar.jpg" alt="logo"/>
      <h1>The Gallery</h1>
      <h2>The great gallery of blablabla<a href="upload.php">Upload?</a></h2>
    </header>
    <div class="contents">

<?php
  foreach(glob($log_directory.'images/*.jpg') as $file) {
    $dpath = substr($file, 0, -3) . "desc";
    $handle = fopen($dpath, "r");
    if ($handle) {
      $desc = fgets($handle);
      fclose($handle);
    } else {
      echo "ERROR OPENING DESCRIPTION FILE";
    }

    echo <<< EOT
    <div class="imageContainer">
      <img class="preview" src="$file" alt="$desc"></img>
      <p class="desc">$desc</p>
    </div>
EOT;

  }
?>
      <div class="clearfix"></div>
    </div>
    <footer>
      <p>Online Gallery copyright BlaBlaBla 2015.</p>
    </footer>
  </main>
</body>
<script src="jquery.min.js"></script>
<script src="script.js"></script>
</html>
