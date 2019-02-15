mui.init();

$(function () {
    var balance = $("#balance").text();
    if (balance < 0) {
        $("#balance_show").css("background", "#F22020");
    }


    $("#mynav").find(".mui-table-view-cell").each(function () {
        if (!this.classList.contains("mui-collapse")) {
            this.addEventListener('tap', function () {
                var myurl = this.getAttribute("href");
                mui('.mui-off-canvas-wrap').offCanvas('close');
                setTimeout(function () {
                    window.location.href = myurl;
                }, 300);
            })
        }
    });

    $("#menu_show").find(".mui-table-view-cell").each(function () {
        this.addEventListener('tap', function () {
            var myurl = this.getAttribute("href");
            if (myurl === "#") {
                mui.alert("暂未开放此功能！");
            } else if (myurl === "") {

            } else {
                window.location.href = myurl;
            }
        })
    });

    // Ajax请求收到的邀请数
    $.get("/inviteNum", function (data) {
        if (data === 0) {
            $("#inviteNum").css("display", "none");
        } else {
            $("#inviteNum").css("display", "");
            $("#inviteNum").html(data);
        }
    });

});
