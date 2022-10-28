import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Darshan Navadiya
 */
class urinalsTest {
    urinals urinals = new urinals();

    @Test
    void validString(){
        Assertions.assertEquals(true, urinals.isGoodString("1001"));
    }

    @Test
    void invalidStringType1(){
        Assertions.assertEquals(false, urinals.isGoodString("10a01"));
    }

    @Test
    void invalidStringType2(){
        Assertions.assertEquals(false, urinals.isGoodString("darshan"));
    }

    @Test
    void invalidStringType3(){
        Assertions.assertEquals(false, urinals.isGoodString("110"));
    }

    @Test
    void readFileFailed(){
        Assertions.assertEquals("File not found!", urinals.readFile("unnamed.dat"));
    }

    @Test
    void readFileSuccess(){
        Assertions.assertEquals("File read complete", urinals.readFile("urinals.dat"));
    }

    @Test
    void countUrinals(){
        Assertions.assertEquals(3, urinals.countUrinals("00000"));
    }

    @Test
    void countUrinalsInvalid(){
        Assertions.assertEquals(-1, urinals.countUrinals("011"));
    }

    @Test
    void countUrinalsInvalidText(){
        Assertions.assertEquals(-1, urinals.countUrinals("011a"));
    }

    @Test
    void duplicateOutFile(){
//        Assertions.assertEquals("rule1.txt", urinals.outFile());
    }

    @Test
    void writeToBadFile() throws IOException {
//        Assertions.assertEquals("Bad File name!", urinals.writeFile(1, "rule3.txt"));
    }

    @Test
    void writeToFile() throws IOException {
        Assertions.assertEquals("File write successful!", urinals.writeFile(1, "rule.txt"));
    }
}