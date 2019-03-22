import java.io.*;

public class CopyJPG {
    public static void main(String[] args) {

        InputStream is = null;
        OutputStream os = null;
        try {

            is = new FileInputStream(new File("E:\\Projects\\IntelliJ_Projects\\JavaFundamentals\\FilesAndStreams\\newdir\\46432601_10210784754414872_3846531285338030080_n.jpg"));
            os = new FileOutputStream(new File("E:\\Projects\\IntelliJ_Projects\\JavaFundamentals\\FilesAndStreams\\newdir\\picture-copy.jpg"));

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
