
※shop_sumpleプロジェクトまたはshopプロジェクトにて、以下を行ってください。

①ファイルの配置
resourcesフォルダ内のファイルをプロジェクト内の同じフォルダ内に配置してください。

resources/static/css/layout.html
resources/templates/layout_view.html
resources/templates/common/以下のファイル

②IndexControllerに以下のメソッドを追加
/**
	 * レイアウト機能を利用する
	 * @return
	 */
	@RequestMapping("/layout_view")
	public String layout_view() {
		return "layout_view";
	}