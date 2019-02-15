$(function () {
    mui.init({
        pullRefresh: {
            container: '#pullrefresh',
            up: {
                auto: true,
                contentrefresh: '正在加载...',
                callback: pullupRefresh
            }
        }
    });

    function pullupRefresh() {
        /*setTimeout(function() {
            mui('#pullrefresh').pullRefresh().endPullupToRefresh((++count > 2)); //参数为true代表没有更多数据了。
            var table = document.body.querySelector('.mui-table-view');
            var cells = document.body.querySelectorAll('.mui-table-view-cell');
            var newCount = cells.length>0?5:20;//首次加载20条，满屏
            for (var i = cells.length, len = i + newCount; i < len; i++) {
                var li = document.createElement('li');
                li.className = 'mui-table-view-cell';
                li.innerHTML = '<a class="mui-navigate-right">Item ' + (i + 1) + '</a>';
                table.appendChild(li);
            }
        }, 1500);*/

        var table = document.body.querySelector('.mui-table-view');
        var cells = document.body.querySelectorAll('.mui-table-view-cell');
        var begin = cells.length;
        var end = cells.length > 0 ? begin + 10 : 20;
        $.get("/getInviteList?begin=" + begin + "&end=" + end, function (data) {
            mui('#pullrefresh').pullRefresh().endPullupToRefresh(!data.hasMore); //参数为true代表没有更多数据了。
            for (var index in data.dataList) {
                var invite = data.dataList[index];
                var li = document.createElement('li');
                li.className = 'mui-table-view-cell';
                li.setAttribute('href',"/inviteDetail?invite_id=" + invite.invite_id);
                li.addEventListener('tap',function () {
                    window.location.href = this.getAttribute("href");
                });
                var lihtml = '<a class="mui-navigate-right">';
                switch (invite.status) {
                    case 0:
                        lihtml += '<span class="mui-badge mui-badge-warning">等待处理</span>';
                        break;
                    case 1:
                        lihtml += '<span class="mui-badge">已接受</span>';
                        break;
                    case 2:
                        lihtml += '<span class="mui-badge mui-badge-purple">已拒绝</span>';
                        break;
                }
                li.innerHTML = lihtml + '<b>' + invite.from_name + '</b>' +
                    ' 邀请您加入 ' + '<b>' + invite.book_name + '</b>' + '</a>';
                table.appendChild(li);
            }
        });


        /*<li class="mui-table-view-cell">
		                <a class="mui-navigate-right">
		                    <span class="mui-badge mui-badge-warning">5</span>
		                    Item 3
		                </a>
		            </li>*/
        /*setTimeout(function () {
            console.log("!23");
            mui('#pullrefresh').pullRefresh().endPullupToRefresh(true); //参数为true代表没有更多数据了。
            var table = document.body.querySelector('.mui-table-view');
            var cells = document.body.querySelectorAll('.mui-table-view-cell');
            var newCount = cells.length > 0 ? 5 : 20;//首次加载20条，满屏
            for (var i = cells.length, len = i + newCount; i < len; i++) {
                var li = document.createElement('li');
                li.className = 'mui-table-view-cell';
                li.innerHTML = '<a class="mui-navigate-right">Item ' + (i + 1) + '</a>';
                table.appendChild(li);
            }
        }, 1500);*/
    }
});