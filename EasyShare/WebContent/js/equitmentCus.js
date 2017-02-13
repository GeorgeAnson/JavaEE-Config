
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
        $(".selectbox").select2();
        $("#updateFream").hide();
        $("#serMessage").hide();
        $("#serEquitInfo").click(function(){
            updateFrameChk();
        });
        $("#delEquitInfo").click(function(){
            delOp();
        });
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
        var newEquiId = document.getElementById("newEquiId");
        newEquiId.value = tabler.rows[1].cells[0].innerText;
        newEquiId.click();

        var newEquiName = document.getElementById("newEquiName");
        newEquiName.value = tabler.rows[1].cells[1].innerText;
        newEquiName.click();

        var newEquiPrice = document.getElementById("newEquiPrice");
        newEquiPrice.value = tabler.rows[1].cells[2].innerText;
        newEquiPrice.click();
        
        var newEquiAmount = document.getElementById("newEquiAmount");
        newEquiAmount.value = tabler.rows[1].cells[3].innerText;
        newEquiAmount.click();

        var newEquiRemain = document.getElementById("newEquiRemain");
        newEquiRemain.value = tabler.rows[1].cells[4].innerText;
        newEquiRemain.click();
        
        var newSimplePro = document.getElementById("newSimplePro");
        newSimplePro.value = tabler.rows[1].cells[6].innerText;
        newSimplePro.click();

        $("#updateFream").slideDown("fast");
    }
    //rows[rowID].cells[colID].innerText
}
//tabler.rows.length


function delOp(){
    var tabler = document.getElementById("dataTables-example");
    if(tabler.rows.length != 2){
        var objer = getObjsByClass("search");
        objer[0].focus();
        showSerMessage();
        hideSerMessageTimer();
    }else{
        $.messager.confirm("删除", "确定删除吗!?", function() {
        //删除，获取id号，get提交
        	 var equiId=document.getElementById("newEquiId");
        	 equiId.value=tabler.rows[1].cells[0].innerText;
        	 equiId.click();
        	$.get('/EasyShare/equipment.html?type=delete&id='+equiId.value);
//        	window.location.reload(true);
        });
    }
}
