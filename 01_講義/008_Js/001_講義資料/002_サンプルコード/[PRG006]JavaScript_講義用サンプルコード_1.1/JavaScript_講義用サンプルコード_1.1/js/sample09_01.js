var target1 = '123-4567';
// 正規表現を使用して任意の数字を検索する
var result1 = target1.match(/^[0-9]{3}-[0-9]{4}$/);

document.write('検索1: ' + result1 + '<br>');

var target2 = '1234567';
// 正規表現を使用して任意の数字を検索する
var result2 = target2.match(/^[0-9]{3}-[0-9]{4}$/);

document.write('検索2: ' + result2 + '<br>');
