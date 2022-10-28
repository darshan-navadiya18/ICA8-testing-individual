import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    void duplicateOutFile(){
        Assertions.assertEquals("rule1.txt", urinals.outFile());
    }

    @Test
    void writeToBadFile(){
        Assertions.assertEquals("Bad File name!", urinals.writeFile(1, "rule3.txt"));
    }

    @Test
    void writeToFile(){
        Assertions.assertEquals("File write successful!", urinals.writeFile(1, "rule.txt"));
    }
}