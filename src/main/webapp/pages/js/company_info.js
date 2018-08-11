$(function(){

    var param = Params()["param"];
    //查询基本指标
    searchBasicIndex(param);//这里的productId就url 中所带这的参数
    //查询主力流入
    searchMainInflux(param);
    //查询财报披露
    searchFinancialDisclosure(param);
	//查询股东增减持
    searchShareholders(param);
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
		if(ele.mainInfluxPrice>=0){
			content+="<td style='color: red'>"+ele.mainInfluxPrice+"</td>";
			content+="<td style='color: red'>"+ele.mainInfluxRatio+"%</td>";
		}else{
			content+="<td style='color: green'>"+ele.mainInfluxPrice+"</td>";
			content+="<td style='color: green'>"+ele.mainInfluxRatio+"%</td>";
		}
		if(ele.hugeInfluxPrice>=0){
			content+="<td style='color: red'>"+ele.hugeInfluxPrice+"</td>";
			content+="<td style='color: red'>"+ele.hugeInfluxRatio+"%</td>";
		}else{
			content+="<td style='color: green'>"+ele.hugeInfluxPrice+"</td>";
			content+="<td style='color: green'>"+ele.hugeInfluxRatio+"%</td>";
		}
		if(ele.largeInfluxPrice>=0){
			content+="<td style='color: red'>"+ele.largeInfluxPrice+"</td>";
			content+="<td style='color: red'>"+ele.largeInfluxRatio+"%</td>";
		}else{
			content+="<td style='color: green'>"+ele.largeInfluxPrice+"</td>";
			content+="<td style='color: green'>"+ele.largeInfluxRatio+"%</td>";
		}
		if(ele.middleInfluxPrice>=0){
			content+="<td style='color: red'>"+ele.middleInfluxPrice+"</td>";
			content+="<td style='color: red'>"+ele.middleInfluxRatio+"%</td>";
		}else{
			content+="<td style='color: green'>"+ele.middleInfluxPrice+"</td>";
			content+="<td style='color: green'>"+ele.middleInfluxRatio+"%</td>";
		}
		
		if(ele.smallInfluxPrice>=0){
			content+="<td style='color: red'>"+ele.smallInfluxPrice+"</td>";
			content+="<td style='color: red'>"+ele.smallInfluxRatio+"%</td>";
		}else{
			content+="<td style='color: green'>"+ele.smallInfluxPrice+"</td>";
			content+="<td style='color: green'>"+ele.smallInfluxRatio+"%</td>";
		}
		content+="</tr>";
		if(index==0){
			return false;
		}
    });
	$("#mainInflux").after(content);
}

//主力流入更多
function moreMainInflux(){
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html()
	$('#detail_code').html(detail_code);
	$('#detail_name').html("主力流入");
	var columns = [
		[
			{
				field: 'date',
				title: "日期",
				valign:"middle",
				align:"center",
				colspan: 1,
				rowspan: 2
			},
			{
				title: "主力净流入",
				valign:"middle",
				align:"center",
				colspan: 2,
				rowspan: 1
			},
			{
				title: "超大单净流入",
				valign:"middle",
				align:"center",
				colspan: 2,
				rowspan: 1
			},
			{
				title: "大单净流入",
				valign:"middle",
				align:"center",
				colspan: 2,
				rowspan: 1
			},
			{
				title: "中单净流入",
				valign:"middle",
				align:"center",
				colspan: 2,
				rowspan: 1
			},
			{
				title: "小单净流入",
				valign:"middle",
				align:"center",
				colspan: 2,
				rowspan: 1
			}
		],
		[
			{
				field: 'mainInfluxPrice',
				title: '净额',
				valign:"middle",
				align:"center"
			},
			{
				field: 'mainInfluxRatio',
				title: '净占比',
				valign:"middle",
				align:"center"
			},{
				field: 'hugeInfluxPrice',
				title: '净额',
				valign:"middle",
				align:"center"
			},
			{
				field: 'hugeInfluxRatio',
				title: '净占比',
				valign:"middle",
				align:"center"
			},{
				field: 'largeInfluxPrice',
				title: '净额',
				valign:"middle",
				align:"center"
			},
			{
				field: 'largeInfluxRatio',
				title: '净占比',
				valign:"middle",
				align:"center"
			},
			{
				field: 'middleInfluxPrice',
				title: '净额',
				valign:"middle",
				align:"center"
			},
			{
				field: 'middleInfluxRatio',
				title: '净占比',
				valign:"middle",
				align:"center"
			},
			{
				field: 'smallInfluxPrice',
				title: '净额',
				valign:"middle",
				align:"center"
			},
			{
				field: 'smallInfluxRatio',
				title: '净占比',
				valign:"middle",
				align:"center"
			}
		]
	];
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getMainInflux.Action?param="+$('#sharesName').html(),
		dataType: "json",
		method: 'get',
		cache: false,
		pagination: true, 
		sortable: false,      //是否启用排序  
	    sortOrder: "asc",     //排序方式  
	    pageNumber:1,      //初始化加载第一页，默认第一页  
	    pageSize: 10,      //每页的记录行数（*）  
	    pageList: [10, 20, 50, 100],
		columns:columns
	});
}

//查询财报披露
function searchFinancialDisclosure(param){
	$.ajax({
	 	url:"http://localhost:8080/search/getFinancialDisclosure.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	//设置财报披露
	    	setFinancialDisclosure(data);
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}

//设置财报披露
function setFinancialDisclosure(data){
	var content="";
	$.each(data, function (index, ele) {
		content+="<tr>";
		content+="<td>"+ele.performanceChange+"</td>";
		if(ele.expectedNetProfitLeft==ele.expectedNetProfitRight){
			content+="<td>"+ele.expectedNetProfitLeft+"</td>";
		}else{
			content+="<td>"+ele.expectedNetProfitLeft+"~"+ele.expectedNetProfitRight+"</td>";	
		}
		if(ele.performanceChangeRatioLeft==ele.performanceChangeRatioRight){
			if(ele.performanceChangeRatioLeft>=0){
				content+="<td style='color:red'>"+ele.performanceChangeRatioLeft+"%</td>";
			}else{
				content+="<td style='color:green'>"+ele.performanceChangeRatioLeft+"%</td>";
			}
		}else{
			if(ele.performanceChangeRatioRight>=0){
				content+="<td style='color:red'>"+ele.performanceChangeRatioLeft+"%~"+ele.performanceChangeRatioRight+"%</td>";	
			}else{
				content+="<td style='color:green'>"+ele.performanceChangeRatioLeft+"%~"+ele.performanceChangeRatioRight+"%</td>";	
			}
		}
		content+="<td>"+ele.performanceChangeReason+"</td>";
		content+="<td>"+ele.previewType+"</td>";
		content+="<td>"+ele.previousYearProfit+"</td>";
		content+="<td>"+ele.announcementDate+"</td>";
		content+="</tr>";
		if(index==2){
			return false;
		}
    });
	$("#financialDisclosure").after(content);
}

//财报披露更多
function moreFinancialDisclosure(){
	
}

//查询股东增减持
function searchShareholders(param){
	$.ajax({
	 	url:"http://localhost:8080/search/getShareholders.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	//设置股东增减持
	    	setShareholders(data);
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}

//设置股东增减持
function setShareholders(data){
	var content="";
	$.each(data, function (index, ele) {
		content+="<tr>";
		content+="<td>"+ele.shareholdersName+"</td>";
		if(ele.changeType=='增持'){
			content+="<td style='color:red'>"+ele.changeType+"</td>";
		}else{
			content+="<td style='color:green'>"+ele.changeType+"</td>";
		}
		content+="<td>"+ele.changeShare+"</td>";
		content+="<td>"+ele.changeEquityRatio+"%</td>";
		content+="<td>"+ele.changeShareRatio+"%</td>";
		content+="<td>"+ele.totalHold+"</td>";
		content+="<td>"+ele.totalEquityRatio+"%</td>";
		content+="<td>"+ele.totalShare+"</td>";
		content+="<td>"+ele.totalShareRatio+"%</td>";
		content+="<td>"+ele.beginDate+"</td>";
		content+="<td>"+ele.endDate+"</td>";
		content+="<td>"+ele.announcementDate+"</td>";
		content+="</tr>";
		if(index==2){
			return false;
		}
    });
	$("#shareholders").after(content);
}

//股东增减持更多
function moreShareholders(){
	
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