import java.io.*;
import java.util.Scanner;

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
        } else{
            return fname;
        }
    }

    public String writeFile(int urinals, String fname) throws IOException {
        if(!(new File(fname).exists())){
            System.out.println("file does not exist!");
            BufferedWriter writer = new BufferedWriter(new FileWriter(fname, true));
            writer.write(Integer.toString(urinals));
            writer.newLine();
            writer.close();
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

    public boolean isGoodString(String str){

        for(int i = 1; i < str.length(); i++){
            if((str.charAt(i) == '0' || str.charAt(i) == '1')){
                if((str.charAt(i) == '1' && str.charAt(i-1) == '1')){
                    return false;
                }
            }else{
                return false;
            }

        }
        return true;
    }
    public int countUrinals(String positions){
        int cnt=0;
        int len = positions.length();
        if(!isGoodString(positions))
            return -1;

        for(int i=0; i<len; i++)
        {
            if(positions.charAt(i)=='0')
            {
                if((i-1<0 || positions.charAt(i-1)=='0') && (i+1>=len || positions.charAt(i+1)=='0'))
                {
                    cnt++;
                    i++;
                }
            }
        }
        return cnt;
    }
    public String readFile(String filename){
        File file = new File(filename);
        if(!file.exists()){
            return "File not found!";
        }else{
            try{
                System.out.println("output: ");
                BufferedReader br
                        = new BufferedReader(new FileReader(file));
                Scanner sc = new Scanner(file);
                String urinals;
                String outFilename = outFile();
                System.out.println("outfile name: "+outFilename);
                while (sc.hasNextLine()){
                    urinals = sc.nextLine();
                    int u = countUrinals(urinals);
                    System.out.println(u);
                    writeFile(u, outFilename);

                }
            }catch (FileNotFoundException e){
                System.out.println(e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "File read complete";
        }
    }

    public static void main(String[] args) throws IOException {
        urinals urinals = new urinals();
        System.out.println("Enter the input file name: ");
        Scanner sc = new Scanner(System.in);
        String fname = sc.nextLine();
        urinals.readFile(fname);
    }

}
