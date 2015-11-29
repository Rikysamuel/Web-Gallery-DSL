/**
 * Created by steve on 29/11/2015.
 */
class CopyWebDirectories {

    /* copy all content folder in spesific path into out folder */
    public static void moveFileIntoOutFolder(String path) {
        new File(path).eachFile { file->
            if (file.file) {
                def src = new File(file.getAbsolutePath())
                def dst = new File('out\\' + file.getName())
                dst << src.text
            } else {
                new File('out\\' + file.getName()).mkdir()
                moveFileIntoOutFolder(file.getAbsolutePath())
            }
        }
    }

    public static void main(String[] arg) {
        CopyWebDirectories.moveFileIntoOutFolder("D:\\Tes")
    }
}

