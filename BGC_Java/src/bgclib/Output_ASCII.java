package bgclib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Output_ASCII {

    /* ASCII output function for Biome-BGC 		*/

    /**
     * Biome-BGC version 4.2 (final release)
     * See copyright.txt for Copyright information
     **/


    public boolean output_ascii(List<Double> arr, int nvars, File ptr) {
        int i = 0;
        Path filePath = Paths.get(ptr.getAbsolutePath());

        for (i = 0; i < nvars; i++) {
            //writer.printf("%10.8f\t", arr.get(i));
            try {
                Files.write(filePath, Collections.singleton(String.format("%10.8f", arr.get(i))), StandardCharsets.UTF_8);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        try {
            Files.write(filePath, Collections.singleton("\n"), StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return true;

    }

}
