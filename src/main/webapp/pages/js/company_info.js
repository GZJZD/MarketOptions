$(function(){

    var param = Params()["param"];
    //查询基本指标
    searchBasicIndex(param);//这里的productId就url 中所带这的参数
    //查询主力流入
    searchMainInflux(param);
    //查询财报披露
//    searchFinancialDisclosure(param);
//	//查询股东增减持
//    searchShareholders(param);
//    //查询股票回购
//    searchShareBuyback(param);
//    //查询股权质押
//    searchSharePledge(param);
//    //查询限售解禁
//    searchRestrictedCirculation(param);
//    //查询公司公告
//    searchCompanyAnnounce(param);
//    //查询公司新闻
//    searchCompanyNews(param);
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

//查询主力流入
function searchMainInflux(param){
	$.ajax({
	 	url:"http://localhost:8080/search/getMainInflux.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	//设置主力流入
	    	setMainInflux(data);
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}

//设置主力流入
function setMainInflux(data){
	var content="";
	$.each(data, function (index, ele) {
		content+="<tr>";
		content+="<td>"+ele.date+"</td>";
		content+="<td style='color: red'>"+ele.mainInfluxPrice+"</td>";
		content+="<td style='color: red'>"+ele.mainInfluxRatio+"</td>";
		content+="<td style='color: red'>"+ele.hugeInfluxPrice+"</td>";
		content+="<td style='color: red'>"+ele.hugeInfluxRatio+"</td>";
		content+="<td style='color: red'>"+ele.largeInfluxPrice+"</td>";
		content+="<td style='color: red'>"+ele.largeInfluxRatio+"</td>";
		content+="<td>"+ele.middleInfluxPrice+"</td>";
		content+="<td>"+ele.middleInfluxRatio+"</td>";
		content+="<td style='color: green'>"+ele.smallInfluxPrice+"</td>";
		content+="<td style='color: green'>"+ele.smallInfluxRatio+"</td>";
		content+="</tr>";
		if(index==0){
			return false;
		}
    });
	$("#mainInflux").after(content);
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


//.Net索引器求值方式
function Params(){
    var pattern = /(\w*)=([a-zA-Z0-9\u4e00-\u9fa5]+)/ig, params = {};//定义正则表达式和一个空对象
    decodeURIComponent(window.location.href, true).replace(pattern, function(a, b, c){ params[b] = c; });
    return params;
}