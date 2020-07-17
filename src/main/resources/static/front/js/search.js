function searchByName() {
    //获取文本内容
    var gname = $("#gname").val();
    console.log(gname);
    $.post("/goods/findByName",{gname : gname}, function (data) {
        console.log(data);
        if (null != data){
            alert("即将跳转到商品页面");
            location.href = "goods.html"
        } else {
            alert("无相关商品");
        }

    },"json");
}

//查找全部会员信息
function findAll() {
    $.post("/member/findAll",{},function (data) {
        console(data);
        if (null != data){
            location.reload();
        }
    })
}