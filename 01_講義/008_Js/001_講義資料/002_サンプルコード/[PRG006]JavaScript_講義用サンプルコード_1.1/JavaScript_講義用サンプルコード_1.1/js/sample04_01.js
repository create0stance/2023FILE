//コンストラクタの定義
function user(name, age, gender) {
   this.name = name;
   this.age = age;
   this.gender = gender;
   this.showDetail = showDetail;
}

//メソッドの定義
function showDetail() {
   var detail = this.name + "\n" + this.age + " years old\n" + this.gender;
   alert(detail)
}


