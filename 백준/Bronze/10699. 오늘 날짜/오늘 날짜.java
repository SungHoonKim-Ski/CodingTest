import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static void input() throws IOException{

    }

    static void pro() throws IOException{
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(tz);
        System.out.println(sdf.format(ts));
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}