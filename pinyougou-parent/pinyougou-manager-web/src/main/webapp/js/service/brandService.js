//服务层
app.service('brandService',function($http){

    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../brand/findAll.do');
    }
    //分页
    this.findPage=function(page,rows){
        return $http.get('../brand/findPage.do?page='+page+'&rows='+rows);
    }
    //查询实体
    this.findTbBrandById=function(id){
        return $http.get('../brand/findTbBrandById.do?id='+id);
    }
    //增加
    this.addTbBrand=function(entity){
        return  $http.post('../brand/addTbBrand.do',entity );
    }
    //修改
    this.updateTbBrand=function(entity){
        return  $http.post('../brand/updateTbBrand.do',entity );
    }
    //删除
    this.dele=function(ids){
        return $http.get('../brand/deleteTbBrand.do?ids='+ids);
    }
    //搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('../brand/SerchPage.do?page='+page+"&rows="+rows, searchEntity);
    }
    //下拉列表数据
    this.selectOptionList=function(){
        return $http.get('../brand/selectOptionList.do');
    }

});
