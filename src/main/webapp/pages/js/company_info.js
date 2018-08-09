$(function(){
	var param = getQueryString("param");
    //查询基本指标
    searchBasicIndex(param);
});

//查询基本指标
function searchBasicIndex(param){
	 $.ajax({
	 	url:"http://localhost:8080/search/getBasicIndex.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	if(data.sharesName==null){
	    		alert("没有该公司数据！");
	    		window.close();
	    	}else{
	    		//设置基本指标
	    		setBasicIndex(data);
	    	}
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}

//设置基本指标
function setBasicIndex(data){
	$('#sharesName').html(data.sharesName);
	$('#sharesCode').html("("+data.sharesCode+")");
	$('#latestPrice').html(data.latestPrice);
	$('#riseFallRatio').html(data.riseFallRatio);
	$('#riseFallPirce').html(data.riseFallPirce);
	$('#gt1').html(data.openPrice);
	$('#gt2').html(data.maxPrice);
	$('#gt4').html(data.changeVolumn);
	$('#gt5').html(data.volumn);
	$('#gt6').html(data.peRatio);
	$('#gt8').html(data.closePrice);
	$('#gt9').html(data.minprice);
	$('#gt11').html(data.quantityRatio);
	$('#gt12').html(data.price);
	$('#gt13').html(data.pbRatio);
}

//用来截取参数
function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}