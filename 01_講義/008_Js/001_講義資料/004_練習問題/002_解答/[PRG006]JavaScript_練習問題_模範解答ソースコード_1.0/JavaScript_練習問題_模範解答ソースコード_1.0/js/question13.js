function showMessage() {
  var message = document.messageForm.message.value;
  if(message.length == 0) {
    alert("何も入力されていません。")
  } else {
    alert("入力値：" + message);
  }
}