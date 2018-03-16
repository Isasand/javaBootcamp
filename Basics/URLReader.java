import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class URLReader {

    public URLReader(String argurl){
        url = argurl;
    }
    String url = "";

    public void read() throws Exception{
        URL wordURL = new URL(url);

        BufferedReader read = new BufferedReader(new InputStreamReader(wordURL.openStream()));

        String inputLine;
        Map<Integer,Integer> lengthMap=new HashMap<>();
        Integer val = 0;
        while((inputLine = read.readLine()) != null) {
            val = lengthMap.get(inputLine.length());
            if(val==null){
                val=0;
            }
            lengthMap.put(inputLine.length(), val + 1);
        }
        read.close();

        for(Map.Entry<Integer,Integer> i:lengthMap.entrySet()){
            System.out.println("Number of String with length "+i.getKey()+" is "+i.getValue());
        }
    }


}
