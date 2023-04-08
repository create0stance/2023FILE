package extra;

/**
 * 座席情報クラス
 *
 * @version 3.0
 * @author System Shared
 */
public class Seat {

    /** ユーザー（予約者）の情報 */
    private User user;

    /** 予約済み */
    private boolean isReserved;

    /**
     * ユーザー情報取得
     *
     * @return ユーザー情報
     */
    public User getUser() {
        return user;
    }

    /**
     * ユーザー情報登録
     *
     * @param user ユーザー情報
     */
    public void setUser(User user) {
        this.user = user;
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
