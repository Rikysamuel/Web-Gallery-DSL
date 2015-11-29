import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by rikysamuel on 11/29/2015.
 */
public class test {
    public static void moveFileIntoOutFolder(String src, String dest) throws IOException {
        /*new File(src).eachFile {file->
            if (file.file) {
//                new File(file.getAbsolutePath()).bytes = new File(dest + "\\" + file.getName()).bytes
//                Files.copy(new File(file.getAbsolutePath()), new File(dest + "\\" + file.getName()))
//                dst.bytes << src.bytes
                InputStream is = new FileInputStream(src);
                OutputStream os = new FileOutputStream(dest);
                byte[] buffer = new byte[1024];
                int length
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length)
                }
            } else {
                new File(dest + "\\" + file.getName()).mkdir()
                moveFileIntoOutFolder(file.getAbsolutePath(),dest + "\\" + file.getName())
            }
        }*/
    }

    public static void main(String[] args) {
//        moveFileIntoOutFolder("resources\\", "E:\\test\\");
    }
}
