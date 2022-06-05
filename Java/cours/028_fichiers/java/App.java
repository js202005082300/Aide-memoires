import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Path f = Paths.get("infos.txt");

        try
        {
            Files.deleteIfExists(f);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}