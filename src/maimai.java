import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class maimai
{
    public static void main(String[] args)
    {
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("你的csv檔案"));

            int count = 1;
            while ((line = br.readLine()) != null)
            {
                String[] d = line.split(splitBy);
                int bk=Integer.parseInt(d[9]),totalMag=Integer.parseInt(d[10]);
                double limit = totalMag*0.11451499999999;
                double per = 100.0/totalMag;
                double perBk = 1.0/bk;
                boolean isCount = false;


                for(double i = 0.0;i < limit;i+=0.1){
                    for(double j = 0.0;j<bk && j<i/5.0;j+=0.25){
                        double score = i*per+j*perBk;
                        if (score >= 11.4514 && score < 11.4515 && (j>=3 || j==2.25 || j==1.5 || j==0.75 || j == 0.0)){
                            if(!isCount){
                                System.out.println(count+". "+d[1] + "," + d[2] + "," + d[3] + "," + d[4] + ", tap:" + d[5] + ",hold:" + d[6] + ",slide:" + d[7] + ",touch:" + d[8] + ",break:" + d[9] + ",物量當量:" + d[10]);
                            }
                            System.out.println("物量當量："+(Math.round(i*10)/10.0)+"，Break當量："+(Math.round(j*100)/100.0));

                            isCount = true;
                        }
                    }
                }

                if(isCount){
                    count++;
                    System.out.println();
                }


            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}