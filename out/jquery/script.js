
$(document).ready(function(){

	//Clicked a preview. opens up lightbox
	$("img.preview").click(function() {
		imageSource = $(this).attr("src");
    imageCaption = $(this).attr("alt");
    console.log($("img.fullimg").attr("src"));
    $("img.fullimg").attr("src", imageSource);
    $("div.fulldesc").text(imageCaption);
    console.log($("img.fullimg").attr("src"));
    $("div.lightbox").css("display", "block");
    $("div.lightbox").animate({
  		opacity:'1'
  	},300);
	});

	//Clicked black spaces. remove lightbox
	$("div.lightbox").click(function() {
    $("div.lightbox").css("display", "none");
    $("div.lightbox").css("opacity", "0");
	});
});
