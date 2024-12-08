import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {
public static void main(String[] args) {
        Process proc;

        System.out.println("start");

		try {
            // 路径执行语句
            proc = Runtime.getRuntime().exec("D://python//python.exe E://python//search//temp.py");
            // reader流
            InputStreamReader stdin=new InputStreamReader(proc.getInputStream());
            // buffer缓冲
            BufferedReader input=new BufferedReader(stdin);
            // 按行读取
            String recommend_sentence = input.readLine();
            
            System.out.println(recommend_sentence);//得到输出

            input.close();
            stdin.close();
            proc.waitFor();
            
            System.out.println("end");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
