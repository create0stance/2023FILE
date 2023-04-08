package excellence;

/**
 * 座席情報クラス
 *
 * @version 1.0
 * @author System Shared
 */
public class Seat {

    /** 予約者の名前 */
    private String name;

    /** 予約済み */
    private boolean isReserved;

    /**
     * 名前取得
     *
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 名前登録
     *
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 予約済みか確認
     *
     * @return 予約済みか
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * 予約済みか登録
     *
     * @param isReserved 予約済みか
     */
    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

}
