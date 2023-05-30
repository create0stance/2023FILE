function ageCheck() {
  var textBox = document.getElementById("name");
  var age = textBox.value;

  if(0 <= age && age < 20){
    alert('年齢:' + age + '歳\n未成年です');
  }else if(20 <= age){
    alert('年齢:' + age + '\n成人です');
  }else{
    alert('正しく入力して下さい');
  }
}