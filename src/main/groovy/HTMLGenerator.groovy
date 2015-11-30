import groovy.xml.MarkupBuilder

/**
 * Created by rikysamuel on 11/27/2015.
 */
class HTMLGenerator {
    String name
    String description
    String profilePicPath
    boolean upload
    String footer
    String parentLocation
    String fileName
    String color
    String bgColor

    def static writer = new StringWriter()

    def static make(closure) {
        HTMLGenerator memoDsl = new HTMLGenerator()
        closure.delegate = memoDsl
        closure()
    }

    def name(String name) {
        this.name = name
    }

    def color(String color) {
        this.color = color
    }

    def background(String color) {
        this.bgColor = color
    }

    def picture(String picPath) {
        this.profilePicPath = picPath
    }

    def description(String description) {
        this.description = description
    }

    def upload(boolean useUpload) {
        this.upload = useUpload
    }

    def footer(String footer) {
        this.footer = footer
    }

    def directory(String location) {
        this.parentLocation = location
    }

    def output(String fileName) {
        this.fileName = fileName + ".php"
    }

    def methodMissing(String methodName, args) {
        println "Wrong Syntax"
    }

    def getTemplateOne() {
        if (name != null) {
            if (description != null) {
                if (profilePicPath != null) {
                    if (parentLocation != null) {
                        if (fileName != null) {
                            doTemplateOne(this)
                        } else {
                            println "output name is not defined"
                        }
                    } else {
                        println "directory location is not defined"
                    }
                } else {
                    println "profile picture path is not defined!"
                }
            } else {
                println "description is not defined!"
            }
        } else {
            println "name is not defined!"
        }
    }

    def getTemplateTwo() {
        if (name != null) {
            if (description != null) {
                if (profilePicPath != null) {
                    if (parentLocation != null) {
                        if (fileName != null) {
                            doTemplateTwo(this)
                        } else {
                            println "output name is not defined"
                        }
                    } else {
                        println "directory location is not defined"
                    }
                } else {
                    println "profile picture path is not defined!"
                }
            } else {
                println "description is not defined!"
            }
        } else {
            println "name is not defined!"
        }
    }

    def getTemplateThree() {
        if (name != null) {
            if (description != null) {
                if (profilePicPath != null) {
                    if (parentLocation != null) {
                        if (fileName != null) {
                            doTemplateThree(this)
                        } else {
                            println "output name is not defined"
                        }
                    } else {
                        println "directory location is not defined"
                    }
                } else {
                    println "profile picture path is not defined!"
                }
            } else {
                println "description is not defined!"
            }
        } else {
            println "name is not defined!"
        }
    }

    def static String indexPhpCode() {
        return "<?php\n" +
                "  foreach(glob('images/*.jpg') as \$file) {\n" +
                "    \$dpath = substr(\$file, 0, -3) . \"desc\";\n" +
                "    \$handle = fopen(\$dpath, \"r\");\n" +
                "    if (\$handle) {\n" +
                "      \$desc = fgets(\$handle);\n" +
                "      fclose(\$handle);\n" +
                "    } else {\n" +
                "      echo \"ERROR OPENING DESCRIPTION FILE\";\n" +
                "    }\n" +
                "\n" +
                "    echo <<< EOT\n" +
                "    <div class=\"imageContainer\">\n" +
                "      <img class=\"preview\" src=\"\$file\" alt=\"\$desc\"></img>\n" +
                "      <p class=\"desc\">\$desc</p>\n" +
                "    </div>\n" +
                "EOT;\n" +
                "\n" +
                "  }\n" +
                "?>"
    }

    def static String indexPhpCode2() {
        return "<?php\n" +
                "  foreach(glob('images/*.jpg') as \$file) {\n" +
                "    \$dpath = substr(\$file, 0, -3) . \"desc\";\n" +
                "    \$handle = fopen(\$dpath, \"r\");\n" +
                "    if (\$handle) {\n" +
                "      \$desc = fgets(\$handle);\n" +
                "      fclose(\$handle);\n" +
                "    } else {\n" +
                "      echo \"ERROR OPENING DESCRIPTION FILE\";\n" +
                "    }\n" +
                "\n" +
                "    echo <<< EOT\n" +
                "<div class='row'>\n" +
                "        <div class='col-md-6'>\n" +
                "          <div class='col-md-6'>\n" +
                "            <div class='thumbnail'>\n" +
                "              <img src='\$file' alt='\$desc' />\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <div class='col-md-6'></div>\n" +
                "        </div>\n" +
                "        <div class='col-md-6'>\n" +
                "          <h3 style='margin-top: 50px; margin-left: -250px; color: white'>\$desc</h3>\n" +
                "        </div>\n" +
                "      </div>\n" +
                "EOT;\n" +
                "\n" +
                "  }\n" +
                "?>"
    }

    def static String indexPhpCode3() {
        return "<?php\n" +
                "  foreach(glob('images/*.jpg') as \$file) {\n" +
                "    \$dpath = substr(\$file, 0, -3) . \"desc\";\n" +
                "    \$handle = fopen(\$dpath, \"r\");\n" +
                "    if (\$handle) {\n" +
                "      \$desc = fgets(\$handle);\n" +
                "      fclose(\$handle);\n" +
                "    } else {\n" +
                "      echo \"ERROR OPENING DESCRIPTION FILE\";\n" +
                "    }\n" +
                "\n" +
                "    echo <<< EOT\n" +
                "<?php\n" +
                "  foreach(glob('images/*.jpg') as \$file) {\n" +
                "    \$dpath = substr(\$file, 0, -3) . \"desc\";\n" +
                "    \$handle = fopen(\$dpath, \"r\");\n" +
                "    if (\$handle) {\n" +
                "      \$desc = fgets(\$handle);\n" +
                "      fclose(\$handle);\n" +
                "    } else {\n" +
                "      echo \"ERROR OPENING DESCRIPTION FILE\";\n" +
                "    }\n" +
                "\n" +
                "    echo <<< EOT\n" +
                "    <li>\n" +
                "      <img src=\"\$file\" alt=\"\$desc\" />\n" +
                "      <p>\$desc</p>\n" +
                "    </li>\n" +
                "EOT;\n" +
                "\n" +
                "  }\n" +
                "?>"
    }

    def static String uploadPhpCode() {
        return "<?php\n" +
                "// error_reporting(E_ERROR | E_WARNING | E_PARSE);\n" +
                "if(isset(\$_FILES['image'])) {\n" +
                "  \$file_name = \$_FILES['image']['name'];\n" +
                "  \$file_tmp =\$_FILES['image']['tmp_name'];\n" +
                "  \$file_type=\$_FILES['image']['type'];\n" +
                "  \$file_size =\$_FILES['image']['size'];\n" +
                "  \$file_ext=strtolower(end(explode('.',\$_FILES['image']['name'])));\n" +
                "\n" +
                "  \$message = \"Something is wrong\";\n" +
                "\n" +
                "  \$extensions= array(\"jpg\",\"png\");\n" +
                "\n" +
                "  \$error = false;\n" +
                "\n" +
                "  if(in_array(\$file_ext,\$extensions) === false){\n" +
                "    \$error = true;\n" +
                "    \$message = \"Extension not allowed, please choose a .JPG or .PNG file.\";\n" +
                "  }\n" +
                "\n" +
                "  if(\$file_size > 2097152){\n" +
                "    \$error = true;\n" +
                "    \$message = \"File size should be under 2MB\";\n" +
                "  }\n" +
                "\n" +
                "  if(\$error !== true){\n" +
                "    move_uploaded_file(\$file_tmp,\"images/\".\$file_name);\n" +
                "    if(\$_POST[\"desc\"] == '') {\n" +
                "      \$desc = \"No Description\";\n" +
                "      \$message = \"Image \" . \$file_name . \" uploaded successfully without description.\";\n" +
                "    } else {\n" +
                "      \$desc = \$_POST[\"desc\"];\n" +
                "      \$message = \"Image \" . \$file_name . \" uploaded successfully.\";\n" +
                "    }\n" +
                "    \$name = explode('.',\$_FILES['image']['name']);\n" +
                "    file_put_contents(\"images/\".\$name[0].\".desc\", \$desc);\n" +
                "  }\n" +
                "\n" +
                "} else {\n" +
                "  \$message = \"Only .PNG or .JPG files are accepted.\";\n" +
                "}\n" +
                "?>"
    }

    def static templateOne(HTMLGenerator htmlDsl) {
        def markup = new MarkupBuilder(writer)

        markup.html() {
            head {
                title(htmlDsl.name)
                meta(charset: "utf-8")
                link(href: "css/style1.css", rel:"stylesheet", type:"text/css", charset: "utf-8")
            }
            body {
                span(id: "background")
                div id: "page", {
                    div id: "sidebar", {
                        div id: "title", {
                            mkp.yield htmlDsl.name
                        }
                        ul id: "profile", {
                            li {
                                mkp.yield htmlDsl.description
                            }
                        }

                    }

                    div id: "contents", {
                        ul class: "images", {
                            mkp.yieldUnescaped "\n"
                            mkp.yieldUnescaped indexPhpCode3()
                            mkp.yieldUnescaped "\n"
                        }
                    }
                }
            }
        }
    }

    def static templateTwo(HTMLGenerator htmlDsl) {
        def markup = new MarkupBuilder(writer)

        markup.html() {
            head {
                title(htmlDsl.name)
                meta(charset: "utf-8")
                link(href: "css/style.css", rel: "stylesheet", type: "text/css", charset: "utf-8")
            }
            body {
                div class: "lightbox", {
                    div class: "center", {
                        img(class: "fullimg", src: "", alt: "")
                        div class: "fulldesc", {
                            mkp.yield ""
                        }
                    }
                }

                main class: "page", {
                    header class: "title", {
                        img(src: "avatar.jpg", alt: "logo")
                        if (htmlDsl.color == null) {
                            h1 {
                                mkp.yield htmlDsl.name
                            }
                        } else {
                            h1 style: "color:" + htmlDsl.color + ";", {
                                mkp.yield htmlDsl.name
                            }
                        }
                        h2 {
                            mkp.yield htmlDsl.description
                            if (htmlDsl.upload) {
                                a href: "php/upload.php", {
                                    mkp.yield "Upload"
                                }
                            }
                        }
                    }
                    div class: "contents", {
                        mkp.yieldUnescaped "\n"
                        mkp.yieldUnescaped indexPhpCode()

                        div class: "clearfix", {
                            mkp.yield ""
                        }
                    }

                    footer {
                        p{
                            mkp.yield htmlDsl.footer
                        }
                    }
                }
            }
            script(src: "jquery/jquery.min.js") {
                mkp.yield ""
            }
            script(src: "jquery/script.js") {
                mkp.yield ""
            }
        }
    }

    def static templateThree(HTMLGenerator htmlDsl) {
        def markup = new MarkupBuilder(writer)
        if (htmlDsl.bgColor == null) {
            htmlDsl.bgColor = "#080829"
        }

        markup.html() {
            head {
                title(htmlDsl.name)
                meta(charset: "utf-8")
                link(href: "css/bootstrap/bootstrap.min.css", rel: "stylesheet")
                link(href: "css/bootstrap/bootstrap-theme.min.css", rel: "stylesheet")
                link(href: "css/style.css", rel: "stylesheet", type: "text/css", charset: "utf-8")
            }
            body style: "padding: 50px 20px 0px; background: " + htmlDsl.bgColor + ";", {
                div class: "container", {
                    div class: "row", {
                        div class: "well well-lg", {
                            div class: "page-header", {
                                div class: "col-sm-6 col-md-3", {
                                    div class: "thumbnail", {
                                        img(src: "avatar.jpg", alt: "Profile Picture")
                                    }
                                }
                                h1 {
                                    small style: "color: " + htmlDsl.color + ";", {
                                        mkp.yield htmlDsl.name
                                    }
                                }
                            }
                            p style: "font-style: italic", {
                                mkp.yield htmlDsl.description
                            }
                        }
                    }

                    if (htmlDsl.upload) {
                        div class: "row", {
                            div class: "col-md-3", {
                                mkp.yield ""
                            }
                            div class: "col-md-3", {
                                mkp.yield ""
                            }
                            div class: "col-md-3", {
                                mkp.yield ""
                            }
                            div class: "col-md-3", {
                                div class: "well well-lg", {
                                    form enctype: "multipart/form-data", action: "", method: "POST", {
                                        input (type: "file", name: "image")
                                        br {}
                                        label for: "name", {
                                            mkp.yield "Description"
                                        }
                                        br {}
                                        input (type: "text", name: "desc")
                                        br {}
                                        br {}
                                        input class: "btn btn-primary", type: "submit"
                                    }
                                }
                            }
                        }
                    }

                    div class: "row", style: "padding: 50px 20px 0px", {
                        mkp.yield ""
                    }

                    mkp.yieldUnescaped "\n"
                    mkp.yieldUnescaped indexPhpCode2()
                    mkp.yieldUnescaped "\n"

                    /*div class: "row", {
                        div class: "col-md-6", {
                            div class: "col-md-6", {
                                div class: "thumbnail", {
                                    img(src: "images/03.jpg", alt: "Generic placeholder thumbail")
                                }
                            }
                            div class: "col-md-6", {
                                mkp.yield ""
                            }
                        }
                        div class: "col-md-6", {
                            h3 style: "margin-top: 50px; margin-left: -250px; color: white" , {
                                mkp.yield "Some description of the image 3"
                            }
                        }
                    }*/

                }
            }
        }
    }

    private static doTemplateOne(HTMLGenerator htmlDsl) {
        if (!new File(htmlDsl.parentLocation).exists()) {
            new File(htmlDsl.parentLocation).mkdirs();
        }

        templateOne(htmlDsl)

        File directory = new File(htmlDsl.parentLocation);
        if (!directory.exists()) {
            directory.mkdirs()
        }

        CopyWebDirectories.createAvatar(htmlDsl.profilePicPath, htmlDsl.parentLocation)
        CopyWebDirectories.moveFileIntoOutFolder("resources", htmlDsl.parentLocation)

        File file = new File(htmlDsl.parentLocation, htmlDsl.fileName);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }

        file << writer;
    }

    private static doTemplateTwo(HTMLGenerator htmlDsl) {
        if (!new File(htmlDsl.parentLocation).exists()) {
            new File(htmlDsl.parentLocation).mkdirs();
        }

        templateTwo(htmlDsl)

        File directory = new File(htmlDsl.parentLocation);
        if (!directory.exists()) {
            directory.mkdirs()
        }

        CopyWebDirectories.createAvatar(htmlDsl.profilePicPath, htmlDsl.parentLocation)
        CopyWebDirectories.moveFileIntoOutFolder("resources", htmlDsl.parentLocation)

        File file = new File(htmlDsl.parentLocation, htmlDsl.fileName);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }

        file << writer;
    }

    private static doTemplateThree(HTMLGenerator htmlDsl) {
        if (!new File(htmlDsl.parentLocation).exists()) {
            new File(htmlDsl.parentLocation).mkdirs();
        }

        templateThree(htmlDsl)

        File directory = new File(htmlDsl.parentLocation);
        if (!directory.exists()) {
            directory.mkdirs()
        }

        CopyWebDirectories.createAvatar(htmlDsl.profilePicPath, htmlDsl.parentLocation)
        CopyWebDirectories.moveFileIntoOutFolder("resources", htmlDsl.parentLocation)

        File file = new File(htmlDsl.parentLocation, htmlDsl.fileName)
        if (file.exists()) {
            file.delete()
            file.createNewFile()
        }

        file << uploadPhpCode()
        file << writer
    }
}
