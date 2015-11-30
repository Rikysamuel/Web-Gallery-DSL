/**
 * Created by steve on 29/11/2015.
 */
class CopyWebDirectories {

    /* copy all content folder in spesific path into out folder */
    public static void moveFileIntoOutFolder(String path,String dest) {
        new File(path).eachFile { file->
            if (file.file) {
                def src = new File(file.getAbsolutePath()).newDataInputStream()
                def dst = new File(dest + "\\" + file.getName()).newDataOutputStream()
                dst << src
            } else {
                new File(dest + "\\" + file.getName()).mkdir()
                moveFileIntoOutFolder(file.getAbsolutePath(),dest + "\\" + file.getName())
            }
        }
    }

    public static void createAvatar(String source, String destination) {
        new File(destination + "avatar.jpg").newDataOutputStream() << new File(source).newDataInputStream()
    }

    public static void main(String[] args) {
        createAvatar()
    }
}

