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
            BufferedReader br = new BufferedReader(new FileReader("/Users/carsoncheng/Downloads/arcadeSongs.csv"));

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
                            double noteMag = (Math.round(i*10)/10.0), bkMag = (Math.round(j*100)/100.0);
                            System.out.printf("物量當量：%-5s，Break當量：%-5s ----->",noteMag,bkMag);

                            noteMagCal(noteMag);
                            bkMagCal(bkMag);


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

    public static void noteMagCal (double noteMag){
        noteMag = Math.round(noteMag*10)/10.0;
        if (((int)(noteMag % 1)*10)/10.0 == 0){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 0，Good 數： 0 /",(int)noteMag);
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.1){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 2，Good 數： 1 /",(int)(noteMag-2.1));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.2){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 4，Good 數： 0 /",(int)(noteMag-3.2));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.3){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 1，Good 數： 1 /",(int)(noteMag-1.3));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.4){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 3，Good 數： 0 /",(int)(noteMag-2.4));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.5){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 0，Good 數： 1 /",(int)(noteMag-0.5));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.6){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 2，Good 數： 0 /",(int)(noteMag-1.6));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.7){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 4，Good 數： 1 /",(int)(noteMag-3.7));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.8){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 1，Good 數： 0 /",(int)(noteMag-0.8));
        } else if (((int)(noteMag % 1)*10)/10.0 == 0.9){
            System.out.printf("Tap Perfect 數：%3d，Great 數： 3，Good 數： 1 /",(int)(noteMag-2.9));
        }
    }

    public static void bkMagCal (double bkMag){
        if (bkMag % 1.0 == 0){
            System.out.println(" Break Perfect 數：" +(int)bkMag);
        } else if (bkMag % 1.0 == 0.25){
            System.out.println(" Break Perfect 數：" + (int)(bkMag-2.25) + "，Break P-1 數：" + 3);
        } else if (bkMag % 1.0 == 0.5){
            System.out.println(" Break Perfect 數：" + (int)(bkMag-1.5) + "，Break P-1 數：" + 2);
        } else if (bkMag % 1.0 == 0.75){
            System.out.println(" Break Perfect 數：" + (int)(bkMag-0.75) + "，Break P-1 數：" + 1);
        }
    }
}