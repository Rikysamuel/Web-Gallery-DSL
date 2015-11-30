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
                            li {
                                img(src: "images/illustration1.jpg", alt: "")
                                p {
                                    mkp.yield "Lorem Ipsum"
                                }

                            }
                            li {
                                img(src: "images/illustration2.jpg", alt:"")
                                p {
                                    mkp.yield "tes"
                                }
                            }
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
                            a href: "php/upload.php", {
                                mkp.yield "Upload"
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
}
