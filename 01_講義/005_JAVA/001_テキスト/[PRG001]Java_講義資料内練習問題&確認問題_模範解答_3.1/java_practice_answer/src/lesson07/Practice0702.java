package lesson07;

public class Practice0702 {
    public static void main(String[] args) {
        String[] fruits = new String[4];

        fruits[0] = "りんご";
        fruits[1] = "みかん";
        fruits[2] = "いちご";
        fruits[3] = "ぶどう";

        System.out.println("1つ目の箱にある果物は" + fruits[0] + "です。");
        System.out.println("2つ目の箱にある果物は" + fruits[1] + "です。");
        System.out.println("3つ目の箱にある果物は" + fruits[2] + "です。");
        System.out.println("4つ目の箱にある果物は" + fruits[3] + "です。");
        System.out.println("果物は全部で" + fruits.length + "つあります。");
    }
}
