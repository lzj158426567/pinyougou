app.controller('baseController', function ($scope) {

    // 分页控件配置
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 8,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    // 重新加载列表数据
    $scope.reloadList = function () {
        //切换页码
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    $scope.selectIds = [];
    // 定义一个方法，当复选狂被选中时增加到数组中
    $scope.updateSelectIds = function ($event, id) {
        if ($event.target.checked) {// 如果复选框被选中
            $scope.selectIds.push(id);
        } else {
            // 如果取消选择就从数组中移除
            var idx = $scope.selectIds.indexOf(id);// 获取数组的索引
            $scope.selectIds.splice(idx);
        }
    }

    $scope.serchEntity = {};


    //提取json字符串数据中某个属性，返回拼接字符串 逗号分隔
    $scope.jsonToString=function(jsonString,key){
        var json=JSON.parse(jsonString);//将json字符串转换为json对象
        var value="";
        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=","
            }
            value+=json[i][key];
        }
        return value;
    }
})