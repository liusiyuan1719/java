import java.io.InputStream;
import java.util.Scanner;
import java.io.File;
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bo=true;
        while (bo){
            System.out.println("请输入用户名:");

            Scanner sc=new Scanner(System.in);
            String uername=sc.next();


            System.out.println("请输入你的密码:");
            String password=sc.next();

            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            //File file=new File("C:\\Users\\151509\\IdeaProjects\\java\\src\\users.xlsx");
            ReadExcel readExcel=new ReadExcel();
            User users[]=readExcel.readExcel(in);
            for (int i=0; i<users.length;i++) {
                if (uername.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功");
                    bo=false;
                    break;
                } else {
                    System.out.println("登陆失败");
                    System.out.println("正确的密码是" + users[i].getPassword());
                }
            }
        }
    }
}
