// 円錐の体積を求める関数
function calcCone(radius, height) {
  // 底面の面積
  var base = radius * radius * Math.PI;
  // 体積 = 1/3 * 底面積 * 高さ
  return base * height / 3;
}
