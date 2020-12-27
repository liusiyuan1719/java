import java.util.Scanner;
import java.io.File;
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入用户名:");

        Scanner sc=new Scanner(System.in);
        String uername=sc.next();
        System.out.println("你输入的用户名为："+uername);

        System.out.println("请输入你的密码:");
        String password=sc.next();
        System.out.println("你输入的密码为："+password);

        File file=new File("");
        ReadExcel readExcel=new ReadExcel();
        User users[]=readExcel.readExcel(file);
        for (int i=0; i<users.length;i++) {
            if (uername.equals(users[i].getUsername())&&password.equals(users[i].getPassword()))
            {
                break;
            }else {
                System.out.println("登陆失败");
            }
        }
    }
}
