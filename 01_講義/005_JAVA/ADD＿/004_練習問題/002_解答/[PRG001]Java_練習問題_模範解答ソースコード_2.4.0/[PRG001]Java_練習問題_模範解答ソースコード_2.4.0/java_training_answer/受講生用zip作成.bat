@echo off
REM 7-zipをインストールしてある前提です
set ZIP_PATH="C:\Program Files\7-Zip\7z.exe"
REM オリジナルのフォルダリスト
set ORI_FOLDER1="src\Question01"
set ORI_FOLDER2="src\Question02"
set ORI_FOLDER3="src\Question03"
set ORI_FOLDER4="src\Question04"
set ORI_FOLDER5="src\Question05"
set ORI_FOLDER6="src\Question06"
set ORI_FOLDER7="src\Question07"
set ORI_FOLDER8="src\Question08"
set ORI_FOLDER9="src\Question09"
set ORI_FOLDER10="src\Question10"
set ORI_FOLDER11="src\Question11"
set ORI_FOLDER12="src\Question12"
set ORI_FOLDER13="src\Question13"
set ORI_FOLDER14="src\Question14"
set ORI_FOLDER15="src\Question15"
set ORI_FOLDER16="src\Question16"
set ORI_FOLDER17="src\Question17"
set ORI_FOLDER18="src\Question18"
set ORI_FOLDER19="src\Question19"
set ORI_FOLDER20="src\Question20"
set ORI_FOLDER21="src\Question21"
set ORI_FOLDER22="src\Question22"
set ORI_FOLDER23="src\Question23"
set ORI_FOLDER24="src\Question24"
set ORI_FOLDER25="src\Question25"
set ORI_FOLDER26="src\Question26"
set ORI_FOLDER27="src\Question27"
set ORI_FOLDER28="src\Question28"
set ORI_FOLDER29="src\Question29"
set ORI_FOLDER30="src\Question30"
set ORI_FOLDER31="src\Question31"

REM 移動先のフォルダリスト
set FOLDER0="解答ソースコード（受講生用）"
set FOLDER1="01_概要"
set FOLDER2="02_標準出力"
set FOLDER3="03_基本構文"
set FOLDER4="04_リテラル"
set FOLDER5="05_変数"
set FOLDER6="06_入出力"
set FOLDER7="07_式と演算子"
set FOLDER8="08_配列"
set FOLDER9="09_分岐処理"
set FOLDER10="10_繰り返し"
set FOLDER11="11_デバッグ①"
set FOLDER12="12_クラスの基本"
set FOLDER13="13_引数"
set FOLDER14="14_戻り値"
set FOLDER15="15_アクセス制御"
set FOLDER16="16_オーバーロード"
set FOLDER17="17_コンストラクタ"
set FOLDER18="18_Staticメンバ"
set FOLDER19="19_クラスライブラリ"
set FOLDER20="20_クラス型の変数"
set FOLDER21="21_継承"
set FOLDER22="22_オーバーライド"
set FOLDER23="23_Objectクラス"
set FOLDER24="24_抽象クラス"
set FOLDER25="25_インターフェイス"
set FOLDER26="26_パッケージ"
set FOLDER27="27_インポート"
set FOLDER28="28_例外"
set FOLDER29="29_コレクションフレームワーク"
set FOLDER30="30_デバッグ②"
set FOLDER31="31_コーディング規約"

REM 移動先のフォルダ作成
md ..\%FOLDER0%
md ..\%FOLDER0%\%FOLDER1%
md ..\%FOLDER0%\%FOLDER2%
md ..\%FOLDER0%\%FOLDER3%
md ..\%FOLDER0%\%FOLDER4%
md ..\%FOLDER0%\%FOLDER5%
md ..\%FOLDER0%\%FOLDER6%
md ..\%FOLDER0%\%FOLDER7%
md ..\%FOLDER0%\%FOLDER8%
md ..\%FOLDER0%\%FOLDER9%
md ..\%FOLDER0%\%FOLDER10%
md ..\%FOLDER0%\%FOLDER11%
md ..\%FOLDER0%\%FOLDER12%
md ..\%FOLDER0%\%FOLDER13%
md ..\%FOLDER0%\%FOLDER14%
md ..\%FOLDER0%\%FOLDER15%
md ..\%FOLDER0%\%FOLDER16%
md ..\%FOLDER0%\%FOLDER17%
md ..\%FOLDER0%\%FOLDER18%
md ..\%FOLDER0%\%FOLDER19%
md ..\%FOLDER0%\%FOLDER20%
md ..\%FOLDER0%\%FOLDER21%
md ..\%FOLDER0%\%FOLDER22%
md ..\%FOLDER0%\%FOLDER23%
md ..\%FOLDER0%\%FOLDER24%
md ..\%FOLDER0%\%FOLDER25%
md ..\%FOLDER0%\%FOLDER26%
md ..\%FOLDER0%\%FOLDER27%
md ..\%FOLDER0%\%FOLDER28%
md ..\%FOLDER0%\%FOLDER29%
md ..\%FOLDER0%\%FOLDER30%
md ..\%FOLDER0%\%FOLDER31%

REM フォルダを振り分ける
copy %ORI_FOLDER1% ..\%FOLDER0%\%FOLDER1%
copy %ORI_FOLDER2% ..\%FOLDER0%\%FOLDER2%
copy %ORI_FOLDER3% ..\%FOLDER0%\%FOLDER3%
copy %ORI_FOLDER4% ..\%FOLDER0%\%FOLDER4%
copy %ORI_FOLDER5% ..\%FOLDER0%\%FOLDER5%
copy %ORI_FOLDER6% ..\%FOLDER0%\%FOLDER6%
copy %ORI_FOLDER7% ..\%FOLDER0%\%FOLDER7%
copy %ORI_FOLDER8% ..\%FOLDER0%\%FOLDER8%
copy %ORI_FOLDER9% ..\%FOLDER0%\%FOLDER9%
copy %ORI_FOLDER10% ..\%FOLDER0%\%FOLDER10%
copy %ORI_FOLDER11% ..\%FOLDER0%\%FOLDER11%
copy %ORI_FOLDER12% ..\%FOLDER0%\%FOLDER12%
copy %ORI_FOLDER13% ..\%FOLDER0%\%FOLDER13%
copy %ORI_FOLDER14% ..\%FOLDER0%\%FOLDER14%
copy %ORI_FOLDER15% ..\%FOLDER0%\%FOLDER15%
copy %ORI_FOLDER16% ..\%FOLDER0%\%FOLDER16%
copy %ORI_FOLDER17% ..\%FOLDER0%\%FOLDER17%
copy %ORI_FOLDER18% ..\%FOLDER0%\%FOLDER18%
copy %ORI_FOLDER19% ..\%FOLDER0%\%FOLDER19%
copy %ORI_FOLDER20% ..\%FOLDER0%\%FOLDER20%
copy %ORI_FOLDER21% ..\%FOLDER0%\%FOLDER21%
copy %ORI_FOLDER22% ..\%FOLDER0%\%FOLDER22%
copy %ORI_FOLDER23% ..\%FOLDER0%\%FOLDER23%
copy %ORI_FOLDER24% ..\%FOLDER0%\%FOLDER24%
copy %ORI_FOLDER25% ..\%FOLDER0%\%FOLDER25%
copy %ORI_FOLDER26% ..\%FOLDER0%\%FOLDER26%
copy %ORI_FOLDER27% ..\%FOLDER0%\%FOLDER27%
copy %ORI_FOLDER28% ..\%FOLDER0%\%FOLDER28%
copy %ORI_FOLDER29% ..\%FOLDER0%\%FOLDER29%
copy %ORI_FOLDER30% ..\%FOLDER0%\%FOLDER30%
copy %ORI_FOLDER31% ..\%FOLDER0%\%FOLDER31%

REM フォルダごとにzip化
REM 7-zipをインストールしてある前提です
for /d %%f in (..\%FOLDER0%\*) do (
  echo Compressing %%f
  %ZIP_PATH% a -tzip %%f.zip %%f
)

explorer ..\%FOLDER0%

exit /B 0