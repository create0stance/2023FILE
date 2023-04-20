package lesson16;

/**
 * 人間クラス
 */
public class Human1601 {
    /** 年齢 */
    private int age;

    /** 身長 */
    private double height;

    /**
     * 年齢と身長を設定
     *
     */
    public void setInformation() {
        age = 22;
        height = 170.5;
    }

    /**
     * 年齢を設定
     *
     * @param age 年齢
     */
    public void setInformation(int age) {
        this.age = age;
    }

    /**
     * 身長を設定
     *
     * @param height 身長
     */
    public void setInformation(double height) {
        this.height = height;
    }

    /**
     * 年齢と身長を設定
     *
     * @param age 年齢
     * @param height 身長
     */
    public void setInformation(int age, double height) {
        this.age = age;
        this.height = height;
    }
}
