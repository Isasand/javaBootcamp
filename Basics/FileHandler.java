import java.io.*;
public class FileHandler {
    public FileHandler(){};

    public void ReadTempFile(String file) throws IOException{
        String line = null;
        float biggest =0;
        float smallest = 100;
        float allTemps = 0;
        float middle = 0;
        float total = 0;

        FileReader fileReader  = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null) {
            System.out.print("Reading temp...");
            //System.out.println(line);
            float temp = Float.parseFloat(line);

            System.out.println(temp);
            if (temp > biggest){
                biggest = temp;
                System.out.println("Temp was bigger than biggest!");
            }
            if(temp < smallest){
                smallest = temp;
                System.out.println("Temp was smaller than smallest!");
            }
            allTemps += temp;
            total += 1;
        }
        middle = allTemps/total;
        System.out.println("Smallest: " + smallest);
        System.out.println("Biggest: " + biggest);
        System.out.println("Middle: " + middle);
    }
}
