
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
        $(".selectbox").select2();
        $("#updateFream").hide();
        $("#deleteFream").hide();
        $("#serMessage").hide();

        $("#serMoneyLogInfo").click(function(){
            updateFrameChk();
        });
        $("#delMoneyLogInfo").click(function(){
            delOp();
        });
//        $("#serBrowBookInfo").click(function(){
//            browBooksOp();
//        });
//        $("#serRetBookInfo").click(function(){
//            retBooksOp();
//        });
    });

    function  getObjsByClass (param) {
        var tags = tags || document.getElementsByTagName("*");
        var list = [];
        for( var k in tags)
        {
            var tag = tags[k];
            if(tag.type == param) {
                //document.write(tag.innerHTML);
                list.push(tag);
            }
        }
        return list;
    }

    function showSerMessage(){
        $("#serMessage").fadeIn("fast");
    }

    function hideSerMessage(){
        $("#serMessage").fadeOut("fast");

    }

    function hideSerMessageTimer(){
        var timer = setTimeout("hideSerMessage()", 3000);
    }

function updateFrameChk(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        var tradeId = document.getElementById("tradeId");
        tradeId.value = tabler.rows[1].cells[0].innerText;
        tradeId.click();

        var tradeName=document.getElementById("tradeName");
        tradeName.value=tabler.rows[1].cells[1].innerText;
        tradeName.click();
        
        var tradeNum = document.getElementById("tradeSum");
        tradeNum.value = tabler.rows[1].cells[3].innerText;
        tradeNum.click();

        var tradeItem = document.getElementById("tradeDetail");
        tradeItem.value = tabler.rows[1].cells[5].innerText;
        tradeItem.click();

        var tradeDate = document.getElementById("tradeDate");
        tradeDate.value = tabler.rows[1].cells[6].innerText;
        tradeDate.click();

        $("#updateFream").slideDown("fast");
    }
    //rows[rowID].cells[colID].innerText
}
//tabler.rows.length


function delOp(){
//    var tabler = document.getElementById("dataTables-example");
//    if(tabler.rows.length != 2){
//        var objer = getObjsByClass("search");
//        objer[0].focus();
//        showSerMessage();
//        hideSerMessageTimer();
//    }else{
//        $.messager.confirm("删除", "确定删除吗!?", function() {
//        //删除之后的跳转操作
//        	  var tradeId = document.getElementById("tradeId");
//              tradeId.value = tabler.rows[1].cells[0].innerText;
//              tradeId.click();
//              
//              $.get('/EasyShare/money.html?type=delete&fundID='+tradeId.value);
//        });
//    }
	
	var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        var tradeId = document.getElementById("delTradeId");
        tradeId.value = tabler.rows[1].cells[0].innerText;
        tradeId.click();

        var tradeName=document.getElementById("delTradeName");
        tradeName.value=tabler.rows[1].cells[1].innerText;
        tradeName.click();
   
        var tradeNum = document.getElementById("delTradeSum");
        tradeNum.value = tabler.rows[1].cells[3].innerText;
        tradeNum.click();

        var tradeItem = document.getElementById("delTradeDetail");
        tradeItem.value = tabler.rows[1].cells[5].innerText;
        tradeItem.click();

        var tradeDate = document.getElementById("delTradeDate");
        tradeDate.value = tabler.rows[1].cells[6].innerText;
        tradeDate.click();
        
        $("#deleteFream").slideDown("fast");
    }
}

//function browBooksOp(){
//    var tabler = document.getElementById("dataTables-example");
//    if(tabler.rows.length != 2){
//        var objer = getObjsByClass("search");
//        objer[0].focus();
//        showSerMessage();
//        hideSerMessageTimer();
//    }else{
//        $("#bookBrowerInfo").slideDown("fast");
//        document.getElementById("browBookId").value = tabler.rows[1].cells[0].innerText;
//        document.getElementById("browBookName").value = tabler.rows[1].cells[1].innerText;
//    }
//}
//
//function retBooksOp(){
//    var tabler = document.getElementById("dataTables-example");
//    if(tabler.rows.length != 2){
//        var objer = getObjsByClass("search");
//        objer[0].focus();
//        showSerMessage();
//        hideSerMessageTimer();
//    }else{
//        var flag = 0;
//        var i = 1;
//        var x = tabler.rows[1].cells[0].innerText;
//        var tBrowedBooks = document.getElementById("browBookInfo");
//        for(i = 1; i < tBrowedBooks.rows.length; i ++){
//            if(x == tBrowedBooks.rows[i].cells[0].innerText){
//                flag = 1;
//                break;
//            }
//        }
//        if(flag){
//            $("#bookRetInfo").slideDown("fast");
//            document.getElementById("retBookId").value = tBrowedBooks.rows[i].cells[0].innerText;
//            document.getElementById("retBookName").value = tBrowedBooks.rows[i].cells[1].innerText;
//            document.getElementById("retBookTime").value = tBrowedBooks.rows[i].cells[3].innerText;
//        }else{
//            alert("你没借过这本书呀。");
//        }
//    }
//}
