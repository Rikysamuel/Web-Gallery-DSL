import groovy.xml.MarkupBuilder

/**
 * Created by rikysamuel on 11/27/2015.
 */
class HTMLGenerator {
    String name
    String description
    String profilePicPath
    boolean upload
    int template
    String footer
    String parentLocation
    String fileName

    def static writer = new StringWriter()

    def static make(closure) {
        HTMLGenerator memoDsl = new HTMLGenerator()
        closure.delegate = memoDsl
        closure()
    }

    def name(String name) {
        this.name = name
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

    def template(int template) {
        this.template = template
    }

    def footer(String footer) {
        this.footer = footer
    }

    def directory(String location) {
        this.parentLocation = location
    }

    def output(String fileName) {
        this.fileName = fileName
    }

    def methodMissing(String methodName, args) {
        println "Wrong Syntax"
    }

    def getHtml() {
        if (name != null) {
            if (description != null) {
                if (profilePicPath != null) {
                    if (template > 0) {
                        if (parentLocation != null) {
                            if (new File(parentLocation).isDirectory()) {
                                if (fileName != null) {
                                    doHtml(this)
                                } else {
                                    println "output name is not defined"
                                }
                            } else {
                                println "directory location is wrong"
                            }
                        } else {
                            println "directory location is not defined"
                        }
                    } else {
                        println "template is not defined!"
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

    public static void moveFileIntoOutFolder(String path, String dest) {
        new File(path).eachFile { file->
            if (file.file) {
                File src = new File(file.getAbsolutePath()).newDataInputStream()
                File dst = new File(dest + "\\" + file.getName()).newDataOutputStream()
                dst << src
            } else {
                new File(dest + "\\" + file.getName()).mkdir()
                moveFileIntoOutFolder(file.getAbsolutePath(),dest + "\\" + file.getName())
            }
        }
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
                link(href: "css/style2.css", rel: "stylesheet", type: "text/css", charset: "utf-8")
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
                        img(src: htmlDsl.profilePicPath, alt: "logo")
                        h1 {
                            mkp.yield htmlDsl.name
                        }
                        h2 {
                            mkp.yield htmlDsl.description
                        }
                    }
                    div class: "contents", {
                        div class: "imageContainer", {
                            img(class: "preview", src: "images/1.jpg", alt: "Lorem ipsum1")
                            p(class: "desc", "Lorem ipsum") {
                                mkp.yield ""
                            }
                        }

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

    private static doHtml(HTMLGenerator htmlDsl) {
        switch (htmlDsl.template) {
            case 1 :
                templateOne(htmlDsl);
                break;
            case 2 :
                templateTwo(htmlDsl);
                break;
            default:
                println "template is not available"
                break;
        }

        File directory = new File(htmlDsl.parentLocation);
        if (!directory.exists()) {
            directory.mkdirs()
        }

//        moveFileIntoOutFolder("resources/", htmlDsl.parentLocation)

        File file = new File(htmlDsl.parentLocation, htmlDsl.fileName);
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }

        file << writer;
    }
}
