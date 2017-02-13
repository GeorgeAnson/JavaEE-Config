
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
        $(".selectbox").select2();
        $("#updateFream").hide();
        $("#serMessage").hide();

        $("#serMemberInfo").click(function(){
            updateFrameChk();
        });
        $("#delMemberInfo").click(function(){
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
    	
        var memberId = document.getElementById("memberId");
        memberId.value = tabler.rows[1].cells[0].innerText;
        memberId.click();
    	
        var memberNum = document.getElementById("memberNum");
        memberNum.value = tabler.rows[1].cells[1].innerText;
        memberNum.click();

        var memberName = document.getElementById("memberName");
        memberName.value = tabler.rows[1].cells[2].innerText;
        memberName.click();

        var memberClass = document.getElementById("memberClass");
        memberClass.value = tabler.rows[1].cells[3].innerText;
        memberClass.click();

        var memberContact = document.getElementById("memberContact");
        memberContact.value = tabler.rows[1].cells[5].innerText;
        memberContact.click();
        
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
        //删除之后的跳转操作

        });
    }
}
