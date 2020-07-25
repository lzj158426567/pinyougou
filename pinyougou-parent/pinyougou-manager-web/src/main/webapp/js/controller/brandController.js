app.controller('brandController', function ($scope, brandService, $controller) {

    $controller('baseController',{$scope:$scope});
    // 读取后台的数据
    $scope.findAll = function () {
        brandService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        )
    }


    // 分页
    $scope.findPage = function (page, rows) {
        brandService.findPage(page, rows).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        )
    }

    $scope.add = function () {
        var object = null;// 方法名称
        if ($scope.entity.id != null) {
            object = brandService.updateTbBrand($scope.entity)
        } else {
            object = brandService.addTbBrand($scope.entity)
        }
        object.success(
            function (response) {
                if (response.success) {
                    // 重新加载页面
                    $scope.reloadList();
                } else {
                    alert(response.message);
                }
            }
        )
    }


    // 通过id寻找品牌
    $scope.findTbBrandById = function (id) {
        brandService.findTbBrandById(id).success(
            function (response) {
                $scope.entity = response;
            }
        )
    }

    // 批量删除
    // 首先定义一个数组
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

    // 执行删除操作
    $scope.deleteTbBrand = function () {
        //获取选中的复选框
        brandService.deleteTbBrand($scope.selectIds).success(
            function (response) {
                if (response.success) {
                    $scope.reloadList();//刷新列表
                }
            }
        );
    }

    //

    $scope.search = function (page, rows) {
        brandService.search(page, rows, $scope.serchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        )
    }

})
