import java.io.InputStream;
import java.util.Scanner;
import java.io.File;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        boolean bo=true;
        int count =0;
        while (bo){
            System.out.println("请输入用户名:");

            Scanner sc=new Scanner(System.in);
            String uername=sc.next();


            System.out.println("请输入你的密码:");
            String password=sc.next();

            InputStream inPro=Class.forName("Test").getResourceAsStream("product.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            //File file=new File("C:\\Users\\151509\\IdeaProjects\\java\\src\\users.xlsx");
            ReadUsersExcel readExcel=new ReadUsersExcel();
            User users[]=readExcel.readExcel(in);
            for (int i=0; i<users.length;i++) {
                if (uername.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功");
                    ReadProductExcel readProductExcel=new ReadProductExcel();
                    Product products[] =readProductExcel.getAllProductExcel(inPro);
                    for (Product product:products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getProductname());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getDesc());
                        }
                    boolean bo1=true;

                    while (bo1){
                        Product carts[]=new Product[10];
                        System.out.println("请输入商品ID");
                        String pId=sc.next();
                        ReadProductExcel readProductExcel1=new ReadProductExcel();
                        inPro=null;
                        inPro=Class.forName("Test").getResourceAsStream("/product.xlsx");
                        Product product=readProductExcel1.getProductById(pId,inPro);
                        if(product!=null) {
                            count++;
                            carts[count] = product;
                            System.out.println("找到了该商品");
                            System.out.print(product.getId());
                            System.out.print("\t" + product.getProductname());
                            System.out.print("\t" + product.getPrice());
                            System.out.println("\t" + product.getDesc());

                        }
                        else {
                            System.out.println("没有该商品");
                        }
                        System.out.println("是否继续购买商品，请输入yes or no");
                        String yn=sc.next();
                        if (yn.equals("yes"))
                        {
                            inPro=null;
                            inPro=Class.forName("Test").getResourceAsStream("/product.xlsx");
                            readProductExcel=new ReadProductExcel();
                            products =readProductExcel.getAllProductExcel(inPro);
                            for (Product product1:products) {
                                System.out.print(product1.getId());
                                System.out.print("\t" + product1.getProductname());
                                System.out.print("\t" + product1.getPrice());
                                System.out.println("\t" + product1.getDesc());
                            }
                            bo1=true;
                        }
                        else {
                            System.out.println("你购买的商品数量为" + count);
                            for (int j=0;j<carts.length;j++){
                                System.out.print(carts[j].getId());
                                System.out.print("\t" + carts[j].getProductname());
                                System.out.print("\t" + carts[j].getPrice());
                                System.out.println("\t" + carts[j].getDesc());
                            }

                            bo1=false;
                        }
                    }
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
