import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Darshan Navadiya
 */

public class urinals {
    public String outFile() {
        int cnt = 1;
        String fname = "rule.txt";
        File file = new File(fname);
        if(file.exists()){
            while((new File("rule" + Integer.toString(cnt)+".txt")).exists()){
                cnt++;
            }
            return "rule" + Integer.toString(cnt)+".txt";

            //            return true;
        } else{
            return fname;
            //            return false;
        }
    }

    public String writeFile(int urinals, String fname){
        if(!(new File(fname).exists())){
            return "Bad File name!";
        }
        else{
            try{

                BufferedWriter writer = new BufferedWriter(new FileWriter(fname, true));
                writer.write(Integer.toString(urinals));
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return "File write successful!";
        }
    }

    public static void main(String[] args) throws IOException {
        urinals urinals = new urinals();
//        System.out.println(urinals.outFile());;
//        outFile();
        System.out.println(urinals.writeFile(1, "rule3.txt"));;

    }

}
