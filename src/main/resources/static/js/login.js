$(function() {
	mui(document.body).on('tap', '.mui-btn', function(e) {
		var check = true;
		mui("#myform input").each(function() {
			//若当前input为空，则alert提醒
			if (!this.value || this.value.trim() == "") {
				var label = this.previousElementSibling;
				mui.alert(label.innerText + " 不能为空！");
				check = false;
				return false;
			}
		}); //校验通过，继续执行业务逻辑
		if (check) {
			mui(this).button('loading');
			$("#submitclick").trigger("click");
		}
	});
});
