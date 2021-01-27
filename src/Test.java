import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Test {
    static int count = 0;
    static float money=0;
    static Product carts[]=new Product[20];
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bo=true;
        boolean bo1=true;
        while (bo){
            System.out.println("请输入用户名:");

            Scanner sc=new Scanner(System.in);
            String uername=sc.next();

            System.out.println("请输入你的密码:");
            String password=sc.next();

            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");
            //File file=new File("C:\\Users\\151509\\IdeaProjects\\java\\src\\users.xlsx");
            ReadUsersExcel readExcel=new ReadUsersExcel();
            User users[]=readExcel.readExcel(in);
            for (int i=0; i<users.length;i++) {
                if (uername.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功");
                    InputStream inPro=Class.forName("Test").getResourceAsStream("product.xlsx");

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
                                float num = product.getPrice();
                                money = money + num;
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

                                }
                            }
                        }
                        else if (yn1==3){
                            System.out.println("您需要付" + money + "元");
                            Order order = new Order();
                            order.setUser(users[i]);//订单关联用户
                            Product products[] =  new Product[count];
                            /*
                            实际买了2个商品，怎样把carts中的2个Product对象放入products
                             */
                            for(int h=0;h<count;h++){
                                if(carts[h]!=null){
                                    products[h]=carts[h];
                                }
                            }
                            order.setProducts(products);//订单关联商品：实际上应该进行处理，把数组中为null的去除
                            //下订单（创建Excel）
                            CreateOrder.createOrder(order);

                        }
                        else if (yn1==4){
                            bo1=false;
                        }
                    }
                    bo=false;
                    break;

                }
                else if(i==(users.length-1)){
                System.out.println("登陆失败");
            /*    System.out.println("正确的用户名是" + users[i].getUsername());
                System.out.println("正确的密码是" + users[i].getPassword());
                //测试密码
                */
                }
            }
        }
    }
}
