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
    //查询股票回购
    searchShareBuyback(param);
    //查询股权质押
    searchSharePledge(param);
    //查询限售解禁
    searchRestrictedCirculation(param);
    //查询公司公告
    searchCompanyAnnounce(param);
    //查询公司新闻
    searchCompanyNews(param);
    /*setInterval(() => {
    	searchBasicIndex(param);
	}, 5000);*/
    $(document).keyup(function(event) {  
        if (event.keyCode == 13) { 
            //执行操作
        	searchCompanyInfo();
        }  
    });
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
	if(data.latestPrice-data.closePrice>=0){
		$('#latestPrice').html(data.latestPrice).css("color","red");
		$('#riseFallRatio').html(data.riseFallRatio+"%").css("color","red");
		$('#riseFallPirce').html(data.riseFallPirce).css("color","red");
	}else{
		$('#latestPrice').html(data.latestPrice).css("color","green");
		$('#riseFallRatio').html(data.riseFallRatio+"%").css("color","green");
		$('#riseFallPirce').html(data.riseFallPirce).css("color","green");
	}
	if(data.openPrice-data.closePrice>=0){
		$('#gt1').html(data.openPrice).css("color","red");
	}else{
		$('#gt1').html(data.openPrice).css("color","green");
	}
	if(data.maxPrice-data.closePrice>=0){
		$('#gt2').html(data.maxPrice).css("color","red");
	}else{
		$('#gt2').html(data.maxPrice).css("color","green");
	}
	$('#gt4').html(data.changeVolumn);
	$('#gt5').html(data.volumn);
	$('#gt6').html(data.peRatio);
	$('#gt8').html(data.closePrice);
	if(data.minprice-data.closePrice>=0){
		$('#gt9').html(data.minprice).css("color","red");
	}else{
		$('#gt9').html(data.minprice).css("color","green");
	}
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
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
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
				title: '净额(万元)',
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
				title: '净额(万元)',
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
				title: '净额(万元)',
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
				title: '净额(万元)',
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
				title: '净额(万元)',
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
	$('#sample_3').bootstrapTable('destroy');
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
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
	$('#detail_code').html(detail_code);
	$('#detail_name').html("财报披露");
	var columns=[
		{
			field: 'performanceChange',
			title: '业绩变动',
			valign:"middle",
			align:"center"
		},
		{
			field: 'expectedNetProfitLeft',
			title: '预计净利润(元)',
			valign:"middle",
			align:"center",
			formatter: function (value, row, index) {
                if(row.expectedNetProfitRight==value){
                    return value;
                }else {
                    return value+"~"+row.expectedNetProfitRight;
                }
            }	
		},
		{
			field: 'performanceChangeRatioLeft',
			title: '业绩变动幅度',
			valign:"middle",
			align:"center",
			formatter: function (value, row, index) {
                if(row.performanceChangeRatioRight==value){
                    return value+"%";
                }else {
                    return value+"%~"+row.performanceChangeRatioRight+"%";
                }
            }	
		},
		{
			field: 'performanceChangeReason',
			title: '业绩变动原因',
			valign:"middle",
			align:"center"
		},
		{
			field: 'previewType',
			title: '预告类型',
			valign:"middle",
			align:"center"
		},
		{
			field: 'previousYearProfit',
			title: '上年同期净利润(元)',
			valign:"middle",
			align:"center"
		},
		{
			field: 'announcementDate',
			title: '公告日期',
			valign:"middle",
			align:"center"
		}
	]
	$('#sample_3').bootstrapTable('destroy');
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getFinancialDisclosure.Action?param="+$('#sharesName').html(),
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
		content+="<td>"+ele.changeEquityRatio+"</td>";
		content+="<td>"+ele.changeShareRatio+"</td>";
		content+="<td>"+ele.totalHold+"</td>";
		content+="<td>"+ele.totalEquityRatio+"</td>";
		content+="<td>"+ele.totalShare+"</td>";
		content+="<td>"+ele.totalShareRatio+"</td>";
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
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
	$('#detail_code').html(detail_code);
	$('#detail_name').html("股东增减持");
	var columns = [
		[
			{
				field: 'shareholdersName',
				title: "股东名称",
				valign:"middle",
				align:"center",
				colspan: 1,
				rowspan: 2
			},
			{
				title: "持股变动信息",
				valign:"middle",
				align:"center",
				colspan: 4,
				rowspan: 1
			},
			{
				title: "变动后持股信息",
				valign:"middle",
				align:"center",
				colspan: 4,
				rowspan: 1
			},
			{
				field: 'beginDate',
				title: "变动开始日",
				valign:"middle",
				align:"center",
				colspan: 1,
				rowspan: 2
			},
			{
				field: 'endDate',
				title: "变动截止日",
				valign:"middle",
				align:"center",
				colspan: 1,
				rowspan: 2
			},
			{
				field: 'announcementDate',
				title: "公告日",
				valign:"middle",
				align:"center",
				colspan: 1,
				rowspan: 2
			}
		],
		[
			{
				field: 'changeType',
				title: '增减',
				valign:"middle",
				align:"center"
			},
			{
				field: 'changeShare',
				title: '变动数量(万股)',
				valign:"middle",
				align:"center"
			},{
				field: 'changeEquityRatio',
				title: '占总股本比例(%)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'changeShareRatio',
				title: '占流通股比例(%)',
				valign:"middle",
				align:"center"
			},{
				field: 'totalHold',
				title: '持股总数(万股)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'totalEquityRatio',
				title: '占总股本比例(%)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'totalShare',
				title: '持流通股数(万股)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'totalShareRatio',
				title: '占流通股比例(%)',
				valign:"middle",
				align:"center"
			}
		]
	];
	$('#sample_3').bootstrapTable('destroy');
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getShareholders.Action?param="+$('#sharesName').html(),
		dataType: "json",
		method: 'get',
		cache: false,
		pagination: true, 
		sortable: false,      //是否启用排序  
	    sortOrder: "asc",     //排序方式  
	    pageNumber:1,      //初始化加载第一页，默认第一页  
	    pageSize: 5,      //每页的记录行数（*）  
	    pageList: [10, 20, 50, 100],
		columns:columns
	});
}

//查询股票回购
function searchShareBuyback(param){
	$.ajax({
	 	url:"http://localhost:8080/search/getShareBuyback.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	//设置股票回购
	    	setShareBuyback(data);
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}

//设置股票回购
function setShareBuyback(data){
	var content="";
	$.each(data, function (index, ele) {
		content+="<tr>";
		if(ele.buybackPriceRangeLeft==ele.buybackPriceRangeRight){
			content+="<td>"+ele.buybackPriceRangeLeft+"</td>";
		}else{
			content+="<td>"+ele.buybackPriceRangeLeft+"~"+ele.buybackPriceRangeRight+"</td>";
		}
		content+="<td>"+ele.closePrice+"</td>";
		if(ele.buybackVolumnRangeLeft==ele.buybackVolumnRangeRight){
			content+="<td>"+ele.buybackVolumnRangeLeft+"</td>";
		}else{
			content+="<td>"+ele.buybackVolumnRangeLeft+"~"+ele.buybackVolumnRangeRight+"</td>";
		}
		if(ele.shareRatioLeft==ele.shareRatioRight){
			content+="<td>"+ele.shareRatioLeft+"</td>";
		}else{
			content+="<td>"+ele.shareRatioLeft+"~"+ele.shareRatioRight+"</td>";
		}
		if(ele.equityRatioLeft==ele.equityRatioRight){
			content+="<td>"+ele.equityRatioLeft+"</td>";
		}else{
			content+="<td>"+ele.equityRatioLeft+"~"+ele.equityRatioRight+"</td>";
		}
		if(ele.buybackAmountRangeLeft==ele.buybackAmountRangeRight){
			content+="<td>"+ele.buybackAmountRangeLeft+"</td>";
		}else{
			content+="<td>"+ele.buybackAmountRangeLeft+"~"+ele.buybackAmountRangeRight+"</td>";
		}
		content+="<td>"+ele.beginDate+"</td>";
		content+="<td>"+ele.implProgress+"</td>";
		content+="<td>"+ele.announcementDate+"</td>";
		content+="</tr>";
		if(index==2){
			return false;
		}
    });
	$("#shareBuyback").after(content);
}

//股票回购更多
function moreShareBuyback(){
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
	$('#detail_code').html(detail_code);
	$('#detail_name').html("股票回购");
	var columns = [
		[
			{
				field: 'buybackPriceRangeLeft',
				title: '回购价格区间(元)',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
	                if(row.buybackPriceRangeRight==value){
	                    return value;
	                }else {
	                    return value+"~"+row.buybackPriceRangeRight;
	                }
	            }
			},
			{
				field: 'closePrice',
				title: '公告日前一日收盘价',
				valign:"middle",
				align:"center"
			},
			{
				field: 'buybackVolumnRangeLeft',
				title: '回购数量区间(股)',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
	                if(row.buybackVolumnRangeRight==value){
	                    return value;
	                }else {
	                    return value+"~"+row.buybackVolumnRangeRight;
	                }
	            }
			},
			{
				field: 'shareRatioLeft',
				title: '占公告前一日流通股份比例(%)',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
	                if(row.shareRatioRight==value){
	                    return value;
	                }else {
	                    return value+"~"+row.shareRatioRight;
	                }
	            }
			},
			{
				field: 'equityRatioLeft',
				title: '占公告前一日总股本比例(%)',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
	                if(row.equityRatioRight==value){
	                    return value;
	                }else {
	                    return value+"~"+row.equityRatioRight;
	                }
	            }
			},
			{
				field: 'buybackAmountRangeLeft',
				title: '回购金额区间(元)',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
	                if(row.buybackAmountRangeRight==value){
	                    return value;
	                }else {
	                    return value+"~"+row.buybackAmountRangeRight;
	                }
	            }
			},
			{
				field: 'beginDate',
				title: '回购起始时间',
				valign:"middle",
				align:"center"
			},
			{
				field: 'implProgress',
				title: '实施进度',
				valign:"middle",
				align:"center"
			},
			{
				field: 'announcementDate',
				title: '公告日期',
				valign:"middle",
				align:"center"
			}
		]
	];
	$('#sample_3').bootstrapTable('destroy');
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getShareBuyback.Action?param="+$('#sharesName').html(),
		dataType: "json",
		method: 'get',
		cache: false,
		pagination: true, 
		sortable: false,      //是否启用排序  
	    sortOrder: "asc",     //排序方式  
	    pageNumber:1,      //初始化加载第一页，默认第一页  
	    pageSize: 5,      //每页的记录行数（*）  
	    pageList: [10, 20, 50, 100],
		columns:columns
	});
}

//查询股权质押
function searchSharePledge(param){
	$.ajax({
	 	url:"http://localhost:8080/search/getSharePledge.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	//设置股权质押
	    	setSharePledge(data);
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}



//设置股权质押
function setSharePledge(data){
	var content="";
	$.each(data, function (index, ele) {
		content+="<tr>";
		content+="<td>"+ele.shareholdersName+"</td>";
		content+="<td>"+ele.pledgeNumber+"</td>";
		content+="<td>"+ele.pledgeVolumn+"</td>";
		content+="<td>"+ele.pledgePrice+"</td>";
		content+="<td>"+ele.shareRatio+"</td>";
		content+="<td>"+ele.equityDatio+"</td>";
		if(ele.closePositionRangeLeft==ele.closePositionRangeRight){
			content+="<td>"+ele.closePositionRangeLeft+"</td>";
		}else{
			content+="<td>"+ele.closePositionRangeLeft+"~"+ele.closePositionRangeRight+"</td>";
		}
		if(ele.warningPositionRangeLeft==ele.warningPositionRangeRight){
			content+="<td>"+ele.warningPositionRangeLeft+"</td>";
		}else{
			content+="<td>"+ele.warningPositionRangeLeft+"~"+ele.warningPositionRangeRight+"</td>";
		}
		content+="<td>"+ele.updateDate+"</td>";
		content+="</tr>";
		if(index==2){
			return false;
		}
    });
	$("#sharePledge").after(content);
}

//股权质押更多
function moreSharePledge(){
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
	$('#detail_code').html(detail_code);
	$('#detail_name').html("股权质押");
	var columns = [
		[
			{
				field: 'shareholdersName',
				title: '股东名称',
				valign:"middle",
				align:"center"
			},
			{
				field: 'pledgeNumber',
				title: '最新质押笔数',
				valign:"middle",
				align:"center"
			},{
				field: 'pledgeVolumn',
				title: '剩余质押股数(股)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'pledgePrice',
				title: '剩余质押股份市值(元)',
				valign:"middle",
				align:"center"
			},{
				field: 'shareRatio',
				title: '占所持股份比例(%)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'equityDatio',
				title: '占总股本比例(%)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'closePositionRangeLeft',
				title: '平仓线区间(预估)',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
	                if(row.closePositionRangeRight==value){
	                    return value;
	                }else {
	                    return value+"~"+row.closePositionRangeRight;
	                }
	            }
			},
			{
				field: 'warningPositionRangeLeft',
				title: '预警线区间(预估)',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
	                if(row.warningPositionRangeRight==value){
	                    return value;
	                }else {
	                    return value+"~"+row.warningPositionRangeRight;
	                }
	            }
			},
			{
				field: 'updateDate',
				title: '更新日期',
				valign:"middle",
				align:"center"
			}
		]
	];
	$('#sample_3').bootstrapTable('destroy');
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getSharePledge.Action?param="+$('#sharesName').html(),
		dataType: "json",
		method: 'get',
		cache: false,
		pagination: true, 
		sortable: false,      //是否启用排序  
	    sortOrder: "asc",     //排序方式  
	    pageNumber:1,      //初始化加载第一页，默认第一页  
	    pageSize: 5,      //每页的记录行数（*）  
	    pageList: [10, 20, 50, 100],
		columns:columns
	});
}

//查询限售解禁
function searchRestrictedCirculation(param){
	$.ajax({
	 	url:"http://localhost:8080/search/getRestrictedCirculation.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	//设置限售解禁
	    	setRestrictedCirculation(data);
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}

//设置限售解禁
function setRestrictedCirculation(data){
	var content="";
	$.each(data, function (index, ele) {
		content+="<tr>";
		content+="<td>"+ele.circulationDate+"</td>";
		content+="<td>"+ele.shareholdersNum+"</td>";
		content+="<td>"+ele.shareNum+"</td>";
		content+="<td>"+ele.realShareNum+"</td>";
		content+="<td>"+ele.nonShareNum+"</td>";
		content+="<td>"+ele.realSharePrice+"</td>";
		content+="<td>"+ele.equityRatio+"</td>";
		content+="<td>"+ele.shareRatio+"</td>";
		content+="<td>"+ele.closePrice+"</td>";
		content+="<td>"+ele.shareType+"</td>";
		if(ele.beforeRange>=0){
			content+="<td style='color:red'>"+ele.beforeRange+"</td>";
		}else{
			content+="<td style='color:green'>"+ele.beforeRange+"</td>";
		}
		if(ele.afterRange>=0){
			content+="<td style='color:red'>"+ele.afterRange+"</td>";
		}else{
			content+="<td style='color:green'>"+ele.afterRange+"</td>";
		}
		content+="</tr>";
		if(index==2){
			return false;
		}
    });
	$("#restrictedCirculation").after(content);
}

//限售解禁更多
function moreRestrictedCirculation(){
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
	$('#detail_code').html(detail_code);
	$('#detail_name').html("限售解禁");
	var columns = [
		[
			{
				field: 'circulationDate',
				title: '解禁时间',
				valign:"middle",
				align:"center"
			},
			{
				field: 'shareholdersNum',
				title: '解禁股东数',
				valign:"middle",
				align:"center"
			},{
				field: 'shareNum',
				title: '解禁数量(股)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'realShareNum',
				title: '实际解禁数量(股)',
				valign:"middle",
				align:"center"
			},{
				field: 'nonShareNum',
				title: '未解禁数量(股)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'realSharePrice',
				title: '实际解禁市值(元)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'equityRatio',
				title: '占总市值比例(%)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'shareRatio',
				title: '占流通市值比例(%)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'closePrice',
				title: '解禁前一日收盘价(元)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'shareType',
				title: '限售股类型',
				valign:"middle",
				align:"center"
			},
			{
				field: 'beforeRange',
				title: '解禁前20日涨跌幅(%)',
				valign:"middle",
				align:"center"
			},
			{
				field: 'afterRange',
				title: '解禁后20日涨跌幅(%)',
				valign:"middle",
				align:"center"
			}
		]
	];
	$('#sample_3').bootstrapTable('destroy');
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getRestrictedCirculation.Action?param="+$('#sharesName').html(),
		dataType: "json",
		method: 'get',
		cache: false,
		pagination: true, 
		sortable: false,      //是否启用排序  
	    sortOrder: "asc",     //排序方式  
	    pageNumber:1,      //初始化加载第一页，默认第一页  
	    pageSize: 5,      //每页的记录行数（*）  
	    pageList: [10, 20, 50, 100],
		columns:columns
	});
}

//查询公司公告
 function searchCompanyAnnounce(param){
	 $.ajax({
		 	url:"http://localhost:8080/search/getCompanyAnnounce.Action",
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	param:param
		    },
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    beforeSend:function(xhr){},
		    success:function(data,textStatus,jqXHR){
		    	//设置公司公告
		    	setCompanyAnnounce(data);
		    },
		    error:function(xhr,textStatus){},
		    complete:function(){}
		 })
 }
 
//设置公司公告
function setCompanyAnnounce(data){
	var content="";
 	$.each(data, function (index, ele) {
 		content+="<tr>";
 		content+="<td style='text-align: left;'><a target='_blank' href="+ele.announceUrl+">"+ele.announceTitle+"</a></td>";
 		content+="<td>"+ele.announceType+"</td>";
 		content+="<td>"+ele.announceDate+"</td>";
 		content+="</tr>";
 		if(index==2){
 			return false;
 		}
 	});
 	$("#companyAnnounce").after(content);
}

//公司公告更多
function moreCompanyAnnounce(){
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
	$('#detail_code').html(detail_code);
	$('#detail_name').html("公司公告");
	var columns = [
		[
			{
				field: 'announceTitle',
				title: '公告标题',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
					return "<a target='_blank' href="+row.announceUrl+">"+value+"</a>"
		        }
			},
			{
				field: 'announceType',
				title: '公告类型',
				valign:"middle",
				align:"center"
			},{
				field: 'announceDate',
				title: '公告日期',
				valign:"middle",
				align:"center"
			}
		]
	];
	$('#sample_3').bootstrapTable('destroy');
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getCompanyAnnounce.Action?param="+$('#sharesName').html(),
		dataType: "json",
		method: 'get',
		cache: false,
		pagination: true, 
		sortable: false,      //是否启用排序  
	    sortOrder: "asc",     //排序方式  
	    pageNumber:1,      //初始化加载第一页，默认第一页  
	    pageSize: 5,      //每页的记录行数（*）  
	    pageList: [10, 20, 50, 100],
		columns:columns
	});
}
 
 
 
//查询公司新闻
function searchCompanyNews(param){
	$.ajax({
	 	url:"http://localhost:8080/search/getCompanyNews.Action",
	    type:'POST', //GET
	    async:true,    //或false,是否异步
	    data:{
	    	param:param
	    },
	    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	//设置公司新闻
	    	setCompanyNews(data);
	    },
	    error:function(xhr,textStatus){},
	    complete:function(){}
	 })
}

//设置公司新闻
function setCompanyNews(data){
	var content="";
	$.each(data, function (index, ele) {
		content+="<tr>";
		content+="<td style='text-align: left;'><a target='_blank' href="+ele.newsUrl+">"+ele.newsTitle+"</a></td>";
		content+="<td>"+ele.date+"</td>";
		content+="</tr>";
		if(index==2){
			return false;
		}
    });
	$("#companyNews").after(content);
}

//公司新闻更多
function moreCompanyNews(){
	var detail_code = $('#sharesName').html()+" "+$('#sharesCode').html();
	$('#detail_code').html(detail_code);
	$('#detail_name').html("公司新闻");
	var columns = [
		[
			{
				field: 'newsTitle',
				title: '新闻标题',
				valign:"middle",
				align:"center",
				formatter: function (value, row, index) {
					return "<a target='_blank' href="+row.newsUrl+">"+value+"</a>"
		        }
			},
			{
				field: 'date',
				title: '日期',
				valign:"middle",
				align:"center"
			}
		]
	];
	$('#sample_3').bootstrapTable('destroy');
	$('#sample_3').bootstrapTable({
		url: "http://localhost:8080/search/getCompanyNews.Action?param="+$('#sharesName').html(),
		dataType: "json",
		method: 'get',
		cache: false,
		pagination: true, 
		sortable: false,      //是否启用排序  
	    sortOrder: "asc",     //排序方式  
	    pageNumber:1,      //初始化加载第一页，默认第一页  
	    pageSize: 5,      //每页的记录行数（*）  
	    pageList: [10, 20, 50, 100],
		columns:columns
	});
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