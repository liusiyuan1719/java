import java.io.InputStream;
import java.util.Scanner;
import java.io.File;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {
        boolean bo=true;
        boolean bo1=true;
        int money=0;
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
                    Product carts[]=new Product[20];
                    while (bo1){
                        System.out.println("购买商品请输入1");
                        System.out.println("查看购物车请输入2");
                        System.out.println("结账请输入3");
                        System.out.println("退出请输入4");
                        int yn1=sc.nextInt();
                        if (yn1==1){
                            inPro=null;
                            inPro=Class.forName("Test").getResourceAsStream("/product.xlsx");
                            ReadProductExcel readProductExcel=new ReadProductExcel();
                            Product products[] =readProductExcel.getAllProductExcel(inPro);
                            for (Product product:products) {
                                System.out.print(product.getId());
                                System.out.print("\t" + product.getProductname());
                                System.out.print("\t" + product.getPrice());
                                System.out.println("\t" + product.getDesc());
                            }
                            System.out.println("请输入商品ID");
                            String pId=sc.next();
                            inPro=null;
                            inPro=Class.forName("Test").getResourceAsStream("/product.xlsx");
                            ReadProductExcel readProductExcel1=new ReadProductExcel();
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
                        }
                        else if (yn1==2){
                            System.out.println("你购买的商品数量为" + count);
                            for (int j=0;j<=count;j++){
                                if (carts[j]!=null) {
                                    System.out.print(carts[j].getId());
                                    System.out.print("\t" + carts[j].getProductname());
                                    System.out.print("\t" + carts[j].getPrice());
                                    System.out.println("\t" + carts[j].getDesc());
                                    int num = Integer.parseInt(carts[j].getPrice());
                                    money = money + num;
                                }
                            }
                        }
                        else if (yn1==3){
                            System.out.println("您需要付" + money + "元");
                        }
                        else if (yn1==4){
                            bo1=false;
                        }
                    }
                    bo=false;
                    break;
                }
                else {
                    System.out.println("登陆失败");
                    System.out.println("正确的密码是" + users[i].getPassword());
                    break;
                }
            }
        }
    }
}
