package lesson29;

/**
 * 猫クラス
 */
public class Cat2901 {
    /** 名前 */
    private String name;

    /** 年齢 */
    private int age;

    /** 体重 */
    private double weight;

    /**
     * 名前を取得
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 名前を設定
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 年齢を取得
     * @return 年齢
     */
    public int getAge() {
        return age;
    }

    /**
     * 年齢を設定
     * @param age 年齢
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 体重を取得
     * @return 体重
     */
    public double getWeight() {
        return weight;
    }

    /**
     * 体重を設定
     * @param weight 体重
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * 猫の情報を表示
     */
    public void show() {
        System.out.println("名前：" + name);
        System.out.println("年齢：" + age + "才");
        System.out.println("体重：" + weight + "kg");
    }

    /**
     * 鳴くメソッド
     * */
    public void cry() {
        System.out.println("ニャー");
    }

    /**
     * 寝るメソッド
     */
    public void sleep() {
        weight += 0.1;
    }
}
