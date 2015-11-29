import groovy.xml.MarkupBuilder

/**
 * Created by rikysamuel on 11/27/2015.
 */
class HTMLGenerator {
    String name
    String description
    String profilePicPath
    boolean login
    boolean upload
    int template

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

    def login(boolean useLogin) {
        this.login = useLogin
    }

    def upload(boolean useUpload) {
        this.upload = useUpload
    }

    def template(int template) {
        this.template = template
    }

    def getHtml() {
        if (name != null) {
            if (description != null) {
                if (profilePicPath != null) {
                    if (template > 0) {
                        doHtml(this)
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

    def static templateOne(HTMLGenerator htmlDsl) {
        def markup = new MarkupBuilder(writer)

        markup.html() {
            head {
                title("Web Gallery")
                link(href: "assets/css/bootstrap.min.css", rel: "stylesheet")
                link(href: "assets/css/bootstrap-theme.min.css", rel:"stylesheet")
            }
            body {
                div class: "container", {
                    div class: "row", {
                        div class: "col-md-5", {
                            mkp.yield ""
                        }
                        div class: "col-md-3", {
                            h1("Web Gallery")
                        }
                        div class: "col-md-4", {
                            if (htmlDsl.login) {
                                div class: "row", {
                                    form class: "form-horizontal", role: "form", id: "proceed", action: "javascript:;", {
                                        div class: "form-group", {
                                            label for: "username", class: "col-sm-4 control-label", {
                                                mkp.yield "Username"
                                            }
                                            div class: "col-sm-8", {
                                                input type: "input", class: "form-control", id:"username", placeholder:"Username"
                                            }
                                        }
                                        div class: "form-group", {
                                            label for: "password", class: "col-sm-4 control-label", {
                                                mkp.yield "Password"
                                            }
                                            div class: "col-sm-8", {
                                                input type: "password", class: "form-control", id:"password", placeholder:"Password"
                                            }
                                        }
                                        div class: "form-group", {
                                            div class: "col-sm-offset-5 col-sm-7", {
                                                input type: "submit", class: "btn btn-default", value: "Login"
                                            }
                                        }
                                    }
                                }
                            } else {
                                mkp.yield ""
                            }
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            a href: "#", class: "thumbnail", {
                                img(src: htmlDsl.profilePicPath, alt:"picture")
                            }
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            div class: "row", {
                                div class: "col-md-2", {
                                    mkp.yield ""
                                }
                                div class: "col-md-9", {
                                    h3(htmlDsl.name)
                                }
                                div class: "col-md-1", {
                                    mkp.yield ""
                                }
                            }
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            p(style:"margin-top:2em; font-style: italic; font-size: 12px;", htmlDsl.description)
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
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
                title("Web Gallery")
                link(href: "assets/css/bootstrap.min.css", rel: "stylesheet")
                link(href: "assets/css/bootstrap-theme.min.css", rel:"stylesheet")
            }
            body {
                div class: "container", {
                    div class: "row", {
                        div class: "col-md-5", {
                            mkp.yield ""
                        }
                        div class: "col-md-3", {
                            h1("Web Gallery")
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            a href: "#", class: "thumbnail", {
                                img(src: htmlDsl.profilePicPath, alt:"picture")
                            }
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            div class: "row", {
                                div class: "col-md-2", {
                                    mkp.yield ""
                                }
                                div class: "col-md-9", {
                                    h3(htmlDsl.name)
                                }
                                div class: "col-md-1", {
                                    mkp.yield ""
                                }
                            }
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            p(style:"margin-top:2em; font-style: italic; font-size: 12px;", htmlDsl.description)
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }
                }
            }
        }
    }

    def static templateThree(HTMLGenerator htmlDsl) {
        def markup = new MarkupBuilder(writer)

        markup.html() {
            head {
                title("Web Gallery")
                link(href: "assets/css/bootstrap.min.css", rel: "stylesheet")
                link(href: "assets/css/bootstrap-theme.min.css", rel:"stylesheet")
            }
            body {
                div class: "container", {
                    div class: "row", {
                        div class: "col-md-5", {
                            mkp.yield ""
                        }
                        div class: "col-md-3", {
                            h1("Web Gallery")
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            a href: "#", class: "thumbnail", {
                                img(class: "img-circle", src: htmlDsl.profilePicPath, alt:"picture")
                            }
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            div class: "row", {
                                div class: "col-md-2", {
                                    mkp.yield ""
                                }
                                div class: "col-md-9", {
                                    h3(htmlDsl.name)
                                }
                                div class: "col-md-1", {
                                    mkp.yield ""
                                }
                            }
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }

                    div class: "row", {
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                        div class: "col-md-4", {
                            p(style:"margin-top:2em; font-style: italic; font-size: 12px;", htmlDsl.description)
                        }
                        div class: "col-md-4", {
                            mkp.yield ""
                        }
                    }
                }
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
            case 3 :
                templateThree(htmlDsl);
                break;
            default:
                println "template is not available"
                break;
        }

        File file = new File("out", "tes.html");
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }

        file << writer;
    }

    public static void main(String[] args) {
        HTMLGenerator.make {
            name "Lorem Ipsum Dolor Sit"
            picture "assets//img//landscape0.jpg"
            description "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            login false
            upload false
            template 1
            html
        }
    }
}
