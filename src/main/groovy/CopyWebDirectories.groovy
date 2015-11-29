/**
 * Created by steve on 29/11/2015.
 */
class CopyWebDirectories {

    /* copy all content folder in spesific path into out folder */
    public static void moveFileIntoOutFolder(String path,String dest) {
        new File(path).eachFile { file->
            if (file.file) {
                println(file.getAbsolutePath())
                def src = new File(file.getAbsolutePath())
                def dst = new File(dest + "\\" + file.getName())
                dst << src.text
            } else {
                println(file.getAbsolutePath())
                println('out\\' + file.getName())
                new File('out\\' + file.getName()).mkdir()
                moveFileIntoOutFolder(file.getAbsolutePath(),'out\\' + file.getName())
            }
        }
    }

    public static void main(String[] arg) {
        CopyWebDirectories.moveFileIntoOutFolder("D:\\Tes","out\\")
    }
}

